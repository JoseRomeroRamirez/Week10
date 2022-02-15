package testproject;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import fakeRestApi.pageobjects.fakerestApi;


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
        System.out.println("Fin del test");
    }
    @Test(dataProvider = "data")
    public void postMultipleActivitiesTest(int id, String title, String dueDate){
        fakerestApi fakerestApi = new fakerestApi();
        fakerestApi.postMultipleActivities(id, title, dueDate);
        System.out.println("Fin del test");
    }
    @Test
    public void schemaBooksTest(){
        fakerestApi fakerestApi = new fakerestApi();
        fakerestApi.datosBooks();
        System.out.println("Fin del test");
    }
    @Test
    public void coverPhotosBooksTest() throws JsonProcessingException {
        fakerestApi fakerestApi = new fakerestApi();
        fakerestApi.coverPhotosBooks();
        System.out.println("Fin del test");
    }
}