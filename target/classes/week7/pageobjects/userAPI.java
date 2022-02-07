package week7.pageobjects;

import java.util.List;
import java.util.Map;
import static io.restassured.path.json.JsonPath.from;

public class userAPI extends BasePageObject{
    public userAPI() {super();}
    //This method verify a user have given email and print it
    public void verifyEmailUser(String url, String url2 ,String email){
        String response = getResponse(url);
        List<Map> Users = from(response).get("data.findAll { user -> user.email == '"+email+"'}");
        int id = Integer.valueOf(Users.get(0).get("id").toString());
        getLog((url2 + id));
    }
    //This method Post a user
    public void postUser(String url, String name, String job) {
        postUsers(url, name, job);
    }

}
