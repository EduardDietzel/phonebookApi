package api.helpers;

import api.email.EmailsApi;
import io.restassured.response.Response;
import org.testng.Assert;

public class EmailHelper extends EmailsApi {

    public int createEmail(Integer contactId) {
        createEmail(201, contactId);
        Response response = getAllEmails(200, contactId);
        int emailId = response.jsonPath().getInt("[0].id");
        String email = response.jsonPath().getString("[0].email");
        Assert.assertEquals(email, randomDataBodyForCreateEmail(contactId).getEmail(), "Created emails is not equals");
        return emailId;
    }

    public void editEmail(Integer emailId, Integer contactId) {
        editExistingEmail(200, emailId, contactId);
        // получаем информацию о всех имейлах заданного контакта:
        Response editedEmails = getAllEmails(200, contactId);
        // достаем из списка первый (индекс 0) имейл:
        String editedEmail = editedEmails.jsonPath().getString("[0].email");
        // сравниваем полученный имейл с измененным:
        Assert.assertEquals(editedEmail, randomDataBodyForEditEmail(emailId, contactId).getEmail(), "Edited emails is not equals");
    }

    public void deleteEmail(Integer emailId) {
        deleteExistingEmail(200, emailId);
        Response errorMessage = getEmail(500, emailId);
        Assert.assertEquals(errorMessage.jsonPath().getString("message"), "Error! This email doesn't exist in our DB");

    }
}
