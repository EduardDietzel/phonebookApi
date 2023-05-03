package api.phone;

import api.ApiBase;
import io.restassured.response.Response;
import schemas.phone.PhoneDto;

public class PhoneApi extends ApiBase {
    Response response;
    PhoneDto dto;

    public PhoneDto randomDataBodyForCreatePhone(Integer contactId) {
        dto = new PhoneDto();
        dto.setCountryCode("+49");
        dto.setPhoneNumber("9878765675");
        dto.setContactId(contactId); // 4981
        return dto;
    }

    public PhoneDto randomDataBodyForEditPhone(Integer phoneId, Integer contactId) {
        dto = new PhoneDto();
        dto.setCountryCode("+41");
        dto.setPhoneNumber("1234765675");
        dto.setContactId(contactId); // 4981
        dto.setId(phoneId);
        return dto;
    }

    public void createPhone(Integer code, Integer contactId) {
        String endpoint = "/api/phone";
        postRequest(endpoint, code, randomDataBodyForCreatePhone(contactId));
    }

    public void editExistingPhone(Integer code, int phoneId, Integer contactId) {
        String endpoint = "/api/phone";
        putRequest(endpoint, code, randomDataBodyForEditPhone(phoneId, contactId));
    }

    public void deleteExistingPhone(Integer code, int phoneId) {
        String endpoint = "/api/phone/{id}";
        deleteRequest(endpoint, code, phoneId);
    }

    public Response getAllPhones(Integer code, Integer contactId) {
        String endpoint = "/api/phone/{contactId}/all";
        response = getRequestWithParam(endpoint, code, "contactId", contactId);
        return response;
    }

    public Response getPhone(Integer code, int phoneId) {
        String endpoint = "/api/phone/{id}";
        response = getRequestWithParam(endpoint, code, "id", phoneId);
        return response;
    }
}
