package testproject;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import week7.pageobjects.fakerestApi;

public class APITest{

    @DataProvider(name="data")
    Object[][] userData(){
        return new Object[][] {
                {56,"Activity 56","2022-02-14T14:23:28.2970072+00:00"},
                {57, "Activity 57","2022-02-14T14:23:28.2970072+00:00"},
                {58, "Activity 58","2022-02-14T14:23:28.2970072+00:00"}
        };
    }
    @Test
    public void almacenarIdsTest(){
        fakerestApi fakerestApi = new fakerestApi();
        fakerestApi.almacenarIds();
    }
    @Test(dataProvider = "data")
    public void postMultipleActivitiesTest(int id, String title, String dueDate){
        fakerestApi fakerestApi = new fakerestApi();
        fakerestApi.postMultipleActivities(id, title, dueDate);
    }
    @Test
    public void schemaBooksTest(){
        fakerestApi fakerestApi = new fakerestApi();
        fakerestApi.datosBooks();
    }
}