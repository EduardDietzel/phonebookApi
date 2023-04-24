package api.phone;

import api.ApiBase;
import io.restassured.response.Response;
import schemas.phone.PhoneDto;

public class PhoneApi extends ApiBase {
    Response response;
    PhoneDto dto;

    public PhoneDto randomDataBodyForCreatePhone() {
        dto = new PhoneDto();
        dto.setCountryCode("+49");
        dto.setPhoneNumber("9878765675");
        dto.setContactId(4909);
        return dto;
    }

    public PhoneDto randomDataBodyForEditePhone(Integer phoneId) {
        dto = new PhoneDto();
        dto.setCountryCode("+41");
        dto.setPhoneNumber("1234765675");
        dto.setContactId(4909);
        dto.setId(phoneId);
        return dto;
    }

    public void createPhone(Integer code) {
        String endpoint = "/api/phone";
        postRequest(endpoint, code, randomDataBodyForCreatePhone());
    }

    public void editExistingPhone(Integer code, int phoneId) {
        String endpoint = "/api/phone";
        putRequest(endpoint, code, randomDataBodyForEditePhone(phoneId));
    }

    public void deleteExistingPhone(Integer code, int phoneId) {
        String endpoint = "/api/phone/{id}";
        deleteRequest(endpoint, code, phoneId);
    }

    public Response getAllPhones(Integer code) {
        String endpoint = "/api/phone/{contactId}/all";
        response = getRequestWithParam(endpoint, code, "contactId", 4909);
        return response;
    }

    public Response getPhone(Integer code, int phoneId) {
        String endpoint = "/api/phone/{Id}";
        response = getRequestWithParam(endpoint, code, "id", phoneId);
        return response;
    }
}
