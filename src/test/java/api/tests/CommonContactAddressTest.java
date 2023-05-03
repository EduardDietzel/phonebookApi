package api.tests;

import api.address.AddressesApi;
import api.helpers.AddressHelper;
import org.testng.annotations.Test;

public class CommonContactAddressTest extends AddressesApi {

    AddressHelper addressHelper = new AddressHelper();
    int contactId = 4981;

    @Test
    public void createEditDeleteContactAddressTest() {
        Integer addressId = addressHelper.createAddress(contactId);
//        addressApi.createAddress(201, contactId);
//        Response response = addressApi.getAllAddresses(200, contactId);
//        int addressId = response.jsonPath().getInt("[0].id");
//        String city = response.jsonPath().getString("[0].city");
//        String country = response.jsonPath().getString("[0].country");
//        String street = response.jsonPath().getString("[0].street");
//        String zip = response.jsonPath().getString("[0].zip");
//        Assert.assertEquals(city, addressApi.randomDataBodyForCreateAddress(contactId).getCity(), "Created city is not equals");
//        Assert.assertEquals(country, addressApi.randomDataBodyForCreateAddress(contactId).getCountry(), "Created country is not equals");
//        Assert.assertEquals(street, addressApi.randomDataBodyForCreateAddress(contactId).getStreet(), "Created street is not equals");
//        Assert.assertEquals(zip, addressApi.randomDataBodyForCreateAddress(contactId).getZip(), "Created zip is not equals");

        addressHelper.editAddress(addressId, contactId);
//        addressApi.editExistingAddress(200, addressId, contactId);
//        Response editedAddressResponse = addressApi.getAllAddresses(200, contactId);
//        String editedCity = editedAddressResponse.jsonPath().getString("[0].city");
//        String editedCountry = editedAddressResponse.jsonPath().getString("[0].country");
//        String editedStreet = editedAddressResponse.jsonPath().getString("[0].street");
//        String editedZip = editedAddressResponse.jsonPath().getString("[0].zip");
//        Assert.assertEquals(editedCity, addressApi.randomDataBodyForEditAddress(addressId, contactId).getCity(), "Edited city is not equals");
//        Assert.assertEquals(editedCountry, addressApi.randomDataBodyForEditAddress(addressId, contactId).getCountry(), "Edited country is not equals");
//        Assert.assertEquals(editedStreet, addressApi.randomDataBodyForEditAddress(addressId, contactId).getStreet(), "Edited street is not equals");
//        Assert.assertEquals(editedZip, addressApi.randomDataBodyForEditAddress(addressId, contactId).getZip(), "Edited zip is not equals");

        addressHelper.deleteAddress(addressId);
    }
}
