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
    public ContactDto randomDataBodyForCreateContact() {
        dto = new ContactDto();
        dto.setFirstName(faker.internet().uuid());
        dto.setLastName(faker.internet().uuid());
        dto.setDescription(faker.internet().uuid());
        return dto;
    }

//    public ContactDto randomDataBodyForEditContact(Integer contactId) {
//        dto = new ContactDto();
//        dto.setId(contactId);
//        dto.setFirstName(faker.internet().uuid());
//        dto.setLastName(faker.internet().uuid());
//        dto.setDescription(faker.internet().uuid());
//        return dto;
//    }

    public ContactDto randomDataBodyForEditContact(Integer contactId) {
        dto = new ContactDto();
        dto.setId(contactId);
        dto.setFirstName("Eddy");
        dto.setLastName("Dietz");
        dto.setDescription("Deutsch");
        return dto;
    }

    public Response createContact(Integer code) {
        String endpoint = "/api/contact";
        response = postRequest(endpoint, code, randomDataBodyForCreateContact());
        response.as(ContactDto.class);
        return response;
    }

    public void editExistingContact(Integer code, Integer contactId) {
        String endpoint = "/api/contact";
        putRequest(endpoint, code, randomDataBodyForEditContact(contactId));
    }

    public void deleteExistingContact(Integer code, Integer contactId) {
        String endpoint = "/api/contact/{id}";
        deleteRequest(endpoint, code, contactId);
    }

    public Response getContact(Integer code, int contactId) {
        String endpoint = "/api/contact/{id}";
        response = getRequestWithParam(endpoint, code, "id", contactId);
        response.as(ContactDto.class);
        return response;
    }
}
