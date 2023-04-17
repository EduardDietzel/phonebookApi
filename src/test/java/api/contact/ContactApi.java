package api.contact;

import api.ApiBase;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import schemas.contact.ContactDto;

public class ContactApi extends ApiBase {
    ContactDto dto;
    Response response;

    Faker faker = new Faker();

    /*
    делаем типизированную заготовку по созданию контакта
     */
    public ContactDto randomDataBodyForContact() {
        dto = new ContactDto();
        dto.setFirstName(faker.internet().uuid());
        dto.setLastName(faker.internet().uuid());
        dto.setDescription(faker.internet().uuid());
        return dto;
    }

    public Response createContact(Integer code) {
        String url = "/api/contact";
        response = postRequest(url, code, randomDataBodyForContact());
        return response;
    }

    public Response getContact(Integer code, int contactId) {
        String endpoint = "/api/contact/{id}";
        response = getRequestWithParam(endpoint, code, contactId);
        return response;
    }

    public void editExistingContact(Integer code) {
        String endpoint = "/api/contact";
        // putRequest(endpoint, code, )
    }
}
