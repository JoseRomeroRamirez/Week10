package fakeRestApi.pageobjects;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import fakeRestApi.POJO.coverPhotosBooksPOJO;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class fakerestApi extends BasePageObject {
    String url = "https://fakerestapi.azurewebsites.net/api/v1/Activities";
    String urlBooks = "https://fakerestapi.azurewebsites.net/api/v1/Books";
    String urlCoverPhotosBooks = "https://fakerestapi.azurewebsites.net/api/v1/CoverPhotos";

    //Esta funcion almacena todos los IDs provenientes de la respuesta hacia https://fakerestapi.azurewebsites.net/api/v1/Activities
    public void almacenarIds() {
        String response = getResponse(url);
        JsonPath j = new JsonPath(response);
        int count = j.getInt("data.size()");
        String[] ids = new String[count + 1];
        System.out.println("Almacenando "+count+" IDs...");
        for (int i = 1; i < (count + 1); i++) {
            String id = getResponse(url + "/" + i);
            JsonPath jID = new JsonPath(id);
            String actualId = jID.getString("id");
            ids[i] = actualId;
        }
        int random = (int) Math.floor(Math.random() * (count - 0 + 1) + 0);
        System.out.println("Imprimiendo la informacion con el siguiente id: : "+random);
        System.out.println(getResponse(url + "/" + random));
    }
    //Realiza POST a la api de actividades con informacion brindada
    public void postMultipleActivities(int id, String title, String dueDate) {
        System.out.println("Realizando POST con la siguiente info, id: "+id+" titulo: "+" Fecha: "+dueDate);
        given().contentType(ContentType.JSON)
                .body("{\"id\":" + id + ",\"title\":\"" + title + "\",\"dueDate\":\"" + dueDate + "\",\"completed\":true}")
                .post(url).then().log().body();
    }
    //Evaluar el esquema obtenido de la api de books e imprimir los headers
    public void datosBooks() {
        System.out.println("Evaluando esquema obtenido de la api de books");
        Response response = given()
                .get(urlBooks).then().assertThat().body(matchesJsonSchemaInClasspath("schemaBooks.json")).extract().response();
        System.out.println("Imprimiendo los headers");
        System.out.println(response.getHeaders());
    }
    //Por medio de POJO se imprime los datos solicitados de la respuesta de books
    public void coverPhotosBooks() throws JsonProcessingException {
        String response = getResponse(urlCoverPhotosBooks);
        JsonPath j = new JsonPath(response);
        int count = j.getInt("data.size()");
        List<coverPhotosBooksPOJO> books = new ArrayList<coverPhotosBooksPOJO>();
        for (int i = 1; i <= (count); i++) {
            String id = getResponse(urlCoverPhotosBooks + "/" + (i));
            JsonPath jBook = new JsonPath(id);
            coverPhotosBooksPOJO book = new coverPhotosBooksPOJO();
            book.setId(jBook.getString("id"));
            book.setIdBook(jBook.getString("idBook"));
            book.setUrl(jBook.getString("url"));
            books.add(book);
        }
        ObjectMapper Mapper = new ObjectMapper();
        String allBooks =  Mapper.writerWithDefaultPrettyPrinter().writeValueAsString(books);
        List<coverPhotosBooksPOJO> booksDetails = Mapper.readValue(allBooks, new TypeReference<List<coverPhotosBooksPOJO>>() {});
        for (coverPhotosBooksPOJO bookL: booksDetails
             ) {
            System.out.println("IdBook: "+bookL.getId());
            System.out.println("Url: "+bookL.getUrl());
            System.out.println("---------------------------------------------------------------------------");
        }
    }
}