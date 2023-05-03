package api.tests;

import api.helpers.PhoneHelper;
import api.phone.PhoneApi;
import org.testng.annotations.Test;

public class CommonContactPhoneTest extends PhoneApi {

    PhoneHelper phoneHelper = new PhoneHelper();
    int contactId = 4981;

    @Test
    public void createEditDeleteContactPhoneTest() {
        Integer phoneId = phoneHelper.createPhone(contactId);
//        phoneApi.createPhone(201, contactId);
//        Response response = phoneApi.getAllPhones(200, contactId);
//        int phoneId = response.jsonPath().getInt("[0].id");
//        String countryCode = response.jsonPath().getString("[0].countryCode");
//        String phoneNumber = response.jsonPath().getString("[0].phoneNumber");
//        Assert.assertEquals(countryCode, phoneApi.randomDataBodyForCreatePhone(contactId).getCountryCode(), "Created countryCode is not equals");
//        Assert.assertEquals(phoneNumber, phoneApi.randomDataBodyForCreatePhone(contactId).getPhoneNumber(), "Created phoneNumber is not equals");

        phoneHelper.editPhone(phoneId, contactId);
//        phoneApi.editExistingPhone(200, phoneId, contactId);
//        Response editedPhoneResponse = phoneApi.getAllPhones(200, contactId);
//        String editedCountryCode = editedPhoneResponse.jsonPath().getString("[0].countryCode");
//        String editedPhoneNumber = editedPhoneResponse.jsonPath().getString("[0].phoneNumber");
//
//        Assert.assertEquals(editedCountryCode, phoneApi.randomDataBodyForEditPhone(phoneId, contactId).getCountryCode(), "Edited countryCode is not equals");
//        Assert.assertEquals(editedPhoneNumber, phoneApi.randomDataBodyForEditPhone(phoneId, contactId).getPhoneNumber(), "Edited phoneNumber is not equals");

        phoneHelper.deletePhone(phoneId);
    }
}
