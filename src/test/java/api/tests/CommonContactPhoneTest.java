package api.tests;

import api.phone.PhoneApi;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class CommonContactPhoneTest extends PhoneApi {

    @Test
    public void createEditDeleteContactPhoneTest() {
        createPhone(201);
        Response response = getAllPhones(200);
        int phoneId = response.jsonPath().getInt("[0].id");

    }
}
