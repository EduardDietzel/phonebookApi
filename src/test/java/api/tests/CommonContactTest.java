package api.tests;

import api.contact.ContactApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CommonContactTest extends ContactApi {

    @Test
    public void createEditDeleteNewContact() {
        Response actualResponse = createContact(201);
        int contactId = actualResponse.jsonPath().getInt("id");
        Response expectedResponse = getContact(200, contactId);
        Assert.assertEquals(actualResponse.jsonPath().getString("firstName"), expectedResponse.jsonPath().getString("firstName"), "firstName contact not equal");
        Assert.assertEquals(actualResponse.jsonPath().getString("lastName"), expectedResponse.jsonPath().getString("lastName"), "lastName contact not equal");
        Assert.assertEquals(actualResponse.jsonPath().getString("description"), expectedResponse.jsonPath().getString("description"), "description contact not equal");
    }
}
