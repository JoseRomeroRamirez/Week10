package week7.actions;

import week7.pageobjects.BasePageObject;
import week7.pageobjects.userAPI;

public class postUser extends BasePageObject {
    public postUser() {super();}

    public void execute(String url, String name,String job){
        userAPI userAPI = new userAPI();
        userAPI.postUser(url, name , job);
    }
}