package week7.pageobjects;

import week7.POJO.berryPOJO;
import com.fasterxml.jackson.core.JsonProcessingException;

public class berryAPI extends BasePageObject{
    public berryAPI() {super();}

    public void getBerryFirmess(String pokeAPIurl, String schemaBerry, String firmess)  throws JsonProcessingException {
        berryPOJO berry = new berryPOJO();
        String response = getResponse(pokeAPIurl);
        schemaValidator(pokeAPIurl, schemaBerry);
        int count = getFromResponseInt(response,"count");
        for (int i = 0; i < count; i++) {
            berry.setName(getFromResponse(response,"results[" + i + "].name"));
            berry.setUrl(getFromResponse(response,"results[" + i + "].url"));
            if (berry.getUrl().contains("/berry-firmness/"+firmess+"/")) {
                getLog(berry.getUrl());
            }
        }
    }
}
