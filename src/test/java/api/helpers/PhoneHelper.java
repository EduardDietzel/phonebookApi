package api.helpers;

import api.phone.PhoneApi;
import io.restassured.response.Response;
import org.testng.Assert;

public class PhoneHelper extends PhoneApi {

    public int createPhone(Integer contactId) {
        createPhone(201, contactId);
        Response response = getAllPhones(200, contactId);
        int phoneId = response.jsonPath().getInt("[0].id");
        String countryCode = response.jsonPath().getString("[0].countryCode");
        String phoneNumber = response.jsonPath().getString("[0].phoneNumber");
        Assert.assertEquals(countryCode, randomDataBodyForCreatePhone(contactId).getCountryCode(), "Created countryCode is not equals");
        Assert.assertEquals(phoneNumber, randomDataBodyForCreatePhone(contactId).getPhoneNumber(), "Created phoneNumber is not equals");
        return phoneId;
    }

    public void editPhone(Integer phoneId, Integer contactId) {
        editExistingPhone(200, phoneId, contactId);
        Response editedPhoneResponse = getAllPhones(200, contactId);
        String editedCountryCode = editedPhoneResponse.jsonPath().getString("[0].countryCode");
        String editedPhoneNumber = editedPhoneResponse.jsonPath().getString("[0].phoneNumber");
        Assert.assertEquals(editedCountryCode, randomDataBodyForEditPhone(phoneId, contactId).getCountryCode(), "Edited countryCode is not equals");
        Assert.assertEquals(editedPhoneNumber, randomDataBodyForEditPhone(phoneId, contactId).getPhoneNumber(), "Edited phoneNumber is not equals");

    }

    public void deletePhone(Integer phoneId) {

        deleteExistingPhone(200, phoneId);
        Response errorMessage = getPhone(500, phoneId);
        Assert.assertEquals(errorMessage.jsonPath().
                getString("message"), "Error! This phone number doesn't exist in our DB");
    }
}
