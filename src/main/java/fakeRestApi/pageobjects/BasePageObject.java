package fakeRestApi.pageobjects;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.path.json.JsonPath.from;
import io.restassured.http.ContentType;


/** This Class contains common methods that we are going to use in pages object*/
public class BasePageObject {
    //This method get the response as a String
    public String getResponse(String url){
        return given().get(url).then().extract().body().asString();
    }
    //This method log a get given url
    public void getLog (String url){
        given().get(url).then().log().all();
    }
    //This method post an user(name and job) given url, name and job
    public void postUsers(String url,String name, String job) {
        given().contentType(ContentType.JSON)
        .body("{\n" +
        "   \"name\": \""+name+"\",\n" +
        "   \"job\": \""+job+"\"\n}")
        .post(url).then().statusCode(201).log().body();
    }
    // this method validate the schema of a json
    public void schemaValidator(String url, String schema){
        given().get(url).then().assertThat().body(matchesJsonSchemaInClasspath(schema)).statusCode(200);
    }
    //This method return specific data from a json as a string, given response and get
    public String getFromResponse(String response, String get){
        return from(response).get(get);
    }
    //This method return specific data from a json as a int, given response and get
    public int getFromResponseInt(String response, String get){
        return from(response).get(get);
    }
}
