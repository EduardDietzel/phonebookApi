package api.tests;

import api.phone.PhoneApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CommonContactPhoneTest extends PhoneApi {

    @Test
    public void createEditDeleteContactPhoneTest() {
        createPhone(201);
        Response response = getAllPhones(200);
        int phoneId = response.jsonPath().getInt("[0].id");
        String countryCode = response.jsonPath().getString("[0].countryCode");
        String phoneNumber = response.jsonPath().getString("[0].phoneNumber");
        Assert.assertEquals(countryCode, randomDataBodyForCreatePhone().getCountryCode(), "Created countryCode is not equals");
        Assert.assertEquals(phoneNumber, randomDataBodyForCreatePhone().getPhoneNumber(), "Created phoneNumber is not equals");

        editExistingPhone(200, phoneId);
        //getPhone(200, phoneId);
        Response editedCountryCodes = getAllPhones(200);
        Response editedPhoneNumbers = getAllPhones(200);
        String editedCountryCode = editedCountryCodes.jsonPath().getString("[0].countryCode");
        String editedPhoneNumber = editedPhoneNumbers.jsonPath().getString("[0].phoneNumber");
        Assert.assertEquals(editedCountryCode, randomDataBodyForEditPhone(phoneId).getCountryCode(), "Edited countryCode is not equals");
        Assert.assertEquals(editedPhoneNumber, randomDataBodyForEditPhone(phoneId).getPhoneNumber(), "Edited phoneNumber is not equals");

        deleteExistingPhone(200, phoneId);
        Response errorMessage = getPhone(500, phoneId);
        Assert.assertEquals(errorMessage.jsonPath().getString("message"), "Error! This phone doesn't exist in our DB");

    }
}
