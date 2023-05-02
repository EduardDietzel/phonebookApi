package api.tests;

import api.address.AddressesApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CommonContactAddressTest extends AddressesApi {

    @Test
    public void createEditDeleteContactAddressTest() {
        createAddress(201);
        Response response = getAllAddresses(200);
        int addressId = response.jsonPath().getInt("[0].id");
        String city = response.jsonPath().getString("[0].city");
        String country = response.jsonPath().getString("[0].country");
        String street = response.jsonPath().getString("[0].street");
        String zip = response.jsonPath().getString("[0].zip");
        Assert.assertEquals(city, randomDataBodyForCreateAddress().getCity(), "Created city is not equals");
        Assert.assertEquals(country, randomDataBodyForCreateAddress().getCountry(), "Created country is not equals");
        Assert.assertEquals(street, randomDataBodyForCreateAddress().getStreet(), "Created street is not equals");
        Assert.assertEquals(zip, randomDataBodyForCreateAddress().getZip(), "Created zip is not equals");

        editExistingAddress(200, addressId);
        Response editedAddressResponse = getAllAddresses(200);
        String editedCity = editedAddressResponse.jsonPath().getString("[0].city");
        String editedCountry = editedAddressResponse.jsonPath().getString("[0].country");
        String editedStreet = editedAddressResponse.jsonPath().getString("[0].street");
        String editedZip = editedAddressResponse.jsonPath().getString("[0].zip");
        Assert.assertEquals(editedCity, randomDataBodyForEditAddress(addressId).getCity(), "Edited city is not equals");
        Assert.assertEquals(editedCountry, randomDataBodyForEditAddress(addressId).getCountry(), "Edited country is not equals");
        Assert.assertEquals(editedStreet, randomDataBodyForEditAddress(addressId).getStreet(), "Edited street is not equals");
        Assert.assertEquals(editedZip, randomDataBodyForEditAddress(addressId).getZip(), "Edited zip is not equals");

        deleteExistingAddress(200, addressId);
        Response errorMessage = getAddress(500, addressId);
        Assert.assertEquals(errorMessage.jsonPath().getString("message"), "Error! This address doesn't exist in our DB");

    }
}
