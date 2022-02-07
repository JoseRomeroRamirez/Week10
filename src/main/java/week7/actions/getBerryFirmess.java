package week7.actions;

import com.fasterxml.jackson.core.JsonProcessingException;
import week7.pageobjects.BasePageObject;
import week7.pageobjects.berryAPI;

public class getBerryFirmess extends BasePageObject {
    public getBerryFirmess() {super();}

    public void execute(String pokeAPIUrl, String schemaBerry, String firmess) throws JsonProcessingException {
        berryAPI berryAPI = new berryAPI();
        berryAPI.getBerryFirmess(pokeAPIUrl, schemaBerry, firmess);
    }
}