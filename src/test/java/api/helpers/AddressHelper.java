package api.helpers;

import api.address.AddressesApi;
import io.restassured.response.Response;
import org.testng.Assert;

public class AddressHelper extends AddressesApi {

    public int createAddress(Integer contactId) {
        createAddress(201, contactId);
        Response response = getAllAddresses(200, contactId);
        int addressId = response.jsonPath().getInt("[0].id");
        String city = response.jsonPath().getString("[0].city");
        String country = response.jsonPath().getString("[0].country");
        String street = response.jsonPath().getString("[0].street");
        String zip = response.jsonPath().getString("[0].zip");
        Assert.assertEquals(city, randomDataBodyForCreateAddress(contactId).getCity(), "Created city is not equals");
        Assert.assertEquals(country, randomDataBodyForCreateAddress(contactId).getCountry(), "Created country is not equals");
        Assert.assertEquals(street, randomDataBodyForCreateAddress(contactId).getStreet(), "Created street is not equals");
        Assert.assertEquals(zip, randomDataBodyForCreateAddress(contactId).getZip(), "Created zip is not equals");
        return addressId;
    }

    public void editAddress(Integer addressId, Integer contactId) {
        editExistingAddress(200, addressId, contactId);
        Response editedAddressResponse = getAllAddresses(200, contactId);
        String editedCity = editedAddressResponse.jsonPath().getString("[0].city");
        String editedCountry = editedAddressResponse.jsonPath().getString("[0].country");
        String editedStreet = editedAddressResponse.jsonPath().getString("[0].street");
        String editedZip = editedAddressResponse.jsonPath().getString("[0].zip");
        Assert.assertEquals(editedCity, randomDataBodyForEditAddress(addressId, contactId).getCity(), "Edited city is not equals");
        Assert.assertEquals(editedCountry, randomDataBodyForEditAddress(addressId, contactId).getCountry(), "Edited country is not equals");
        Assert.assertEquals(editedStreet, randomDataBodyForEditAddress(addressId, contactId).getStreet(), "Edited street is not equals");
        Assert.assertEquals(editedZip, randomDataBodyForEditAddress(addressId, contactId).getZip(), "Edited zip is not equals");

    }

    public void deleteAddress(Integer addressId) {

        deleteExistingAddress(200, addressId);
        Response errorMessage = getAddress(500, addressId);
        Assert.assertEquals(errorMessage.jsonPath().getString("message"), "Error! This address doesn't exist in our DB");
    }
}
