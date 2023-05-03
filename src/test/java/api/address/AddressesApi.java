package api.address;

import api.ApiBase;
import io.restassured.response.Response;
import schemas.address.AddressesDto;

public class AddressesApi extends ApiBase {
    Response response;
    AddressesDto dto;

    public AddressesDto randomDataBodyForCreateAddress(Integer contactId) {
        dto = new AddressesDto();
        dto.setCity("Berlin");
        dto.setCountry("Germany");
        dto.setStreet("Manteuffelstraße 69");
        dto.setZip("10999");
        dto.setContactId(contactId); // 4981
        return dto;
    }

    public AddressesDto randomDataBodyForEditAddress(Integer addressId, Integer contactId) {
        dto = new AddressesDto();
        dto.setCity("Berlin");
        dto.setCountry("Germany");
        dto.setStreet("Hohenstaufenstraße 9");
        dto.setZip("10781");
        dto.setContactId(contactId);// 4981
        dto.setId(addressId);
        return dto;
    }

    public void createAddress(Integer code, Integer contactId) {
        String endpoint = "/api/address";
        postRequest(endpoint, code, randomDataBodyForCreateAddress(contactId));
    }

    public void editExistingAddress(Integer code, int addressId, Integer contactId) {
        String endpoint = "/api/address";
        putRequest(endpoint, code, randomDataBodyForEditAddress(addressId, contactId));
    }

    public void deleteExistingAddress(Integer code, int addressId) {
        String endpoint = "/api/address/{id}";
        deleteRequest(endpoint, code, addressId);
    }

    public Response getAllAddresses(Integer code, Integer contactId) {
        String endpoint = "/api/address/{contactId}/all";
        response = getRequestWithParam(endpoint, code, "contactId", contactId); // 4981
        return response;
    }

    public Response getAddress(Integer code, int addressId) {
        String endpoint = "/api/address/{id}";
        response = getRequestWithParam(endpoint, code, "id", addressId);
        return response;
    }
}
