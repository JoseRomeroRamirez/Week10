package week7.actions;

import week7.pageobjects.BasePageObject;
import week7.pageobjects.userAPI;

public class verifyEmailUser extends BasePageObject {
    public verifyEmailUser() {super();}

    public void execute(String url, String url2,String email){
        userAPI userAPI = new userAPI();
        userAPI.verifyEmailUser(url, url2 ,email);
    }
}