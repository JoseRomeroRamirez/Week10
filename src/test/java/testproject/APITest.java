package testproject;

import week7.actions.getBerryFirmess;
import week7.actions.postUser;
import week7.actions.verifyEmailUser;
import week7.base.TestUtilities;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class APITest extends TestUtilities {
    @DataProvider(name="user-data")
    Object[][] userData(){
        return new Object[][] {
                {"Morpheus","leader","https://reqres.in/api/users"},
                {"Jose", "QA", "https://reqres.in/api/users"},
                {"Antonio", "Scrum", "https://reqres.in/api/users"}
        };
    }
    @Test
    @Parameters({"url","url2","email"})
    public void verifyEmailUserTest(String url, String url2,String email){
        verifyEmailUser verifyEmailUser = new verifyEmailUser();
        verifyEmailUser.execute(url, url2 ,email);
    }
    @Test(dataProvider = "user-data")
    public void postUserTest(String name,String job, String url){
        postUser postUser = new postUser();
        postUser.execute(url, name , job);
    }
    @Test
    @Parameters({"pokeAPIUrl","schema", "firmess"})
    public void getBerryFirmessTest(String pokeAPIUrl, String schemaBerry, String firmess) throws JsonProcessingException {
        getBerryFirmess getBerryFirmess = new getBerryFirmess();
        getBerryFirmess.execute(pokeAPIUrl, schemaBerry, firmess);
    }
}
