package week7.pageobjects;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class fakerestApi extends BasePageObject {
    String url = "https://fakerestapi.azurewebsites.net/api/v1/Activities";
    String urlBooks = "https://fakerestapi.azurewebsites.net/api/v1/Books";
    String urlCoverPhotosBooks = "https://fakerestapi.azurewebsites.net/api/v1/CoverPhotos";

    public void almacenarIds() {
        String response = getResponse(url);
        JsonPath j = new JsonPath(response);
        int count = j.getInt("data.size()");
        String[] ids = new String[count + 1];
        for (int i = 1; i < (count + 1); i++) {
            String id = getResponse(url + "/" + i);
            JsonPath jID = new JsonPath(id);
            String actualId = jID.getString("id");
            ids[i] = actualId;
        }
        int random = (int) Math.floor(Math.random() * (count - 0 + 1) + 0);
        System.out.println(random);
        System.out.println(getResponse(url + "/" + random));
    }

    public void postMultipleActivities(int id, String title, String dueDate) {
        given().contentType(ContentType.JSON)
                .body("{\"id\":" + id + ",\"title\":\"" + title + "\",\"dueDate\":\"" + dueDate + "\",\"completed\":true}")
                .post(url).then().log().body();
    }

    public void datosBooks() {
        Response response = given()
                .get(urlBooks).then().assertThat().body(matchesJsonSchemaInClasspath("schemaBooks.json")).extract().response();
        System.out.println(response.getHeaders());
    }
    public void coverPhotosBooks(){
        String response = getResponse(urlCoverPhotosBooks);
        System.out.println(response);
    }
}