package api.tests;

import api.helpers.EmailHelper;
import org.testng.annotations.Test;

public class CommonContactEmailTest {

    EmailHelper emailHelper = new EmailHelper();
    int contactId = 4981;

    @Test
    public void createEditDeleteContactEmailTest() {

//        emailsApi.createEmail(201, contactId);
//        Response response = emailsApi.getAllEmails(200, contactId);
//        int emailId = response.jsonPath().getInt("[0].id");
//        String email = response.jsonPath().getString("[0].email");
//        Assert.assertEquals(email, emailsApi.randomDataBodyForCreateEmail(contactId).getEmail(), "Created emails is not equals");
        Integer emailId = emailHelper.createEmail(contactId);
        // задаем переменную, которую нам возвращает метод createEmail через return

//        emailsApi.editExistingEmail(200, emailId, contactId);
//        // получаем информацию о всех имейлах заданного контакта:
//        Response editedEmails = emailsApi.getAllEmails(200, contactId);
//        // достаем из списка первый (индекс 0) имейл:
//        String editedEmail = editedEmails.jsonPath().getString("[0].email");
//        // сравниваем полученный имейл с измененным:
//        Assert.assertEquals(editedEmail, emailsApi.randomDataBodyForEditEmail(emailId, contactId).getEmail(), "Edited emails is not equals");
        // заменяем редактирование имейла методом из Хелпера:
        emailHelper.editEmail(emailId, contactId);
        // заменяем метод удаления имейла методом из Хелпера:
        emailHelper.deleteEmail(emailId);
    }

}
