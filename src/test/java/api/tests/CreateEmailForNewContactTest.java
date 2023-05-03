package api.tests;

import api.helpers.ContactHelper;
import api.helpers.EmailHelper;
import org.testng.annotations.Test;

public class CreateEmailForNewContactTest {

    EmailHelper emailHelper = new EmailHelper();
    ContactHelper contactHelper = new ContactHelper();

    @Test
    public void CreateEmailForNewContact() {
        // создаем новый контакт
        Integer contactId = contactHelper.createContact();
//        Response newContactResponse = contactApi.createContact(201);
//        Integer contactId = newContactResponse.jsonPath().getInt("id");

        Integer emailId = emailHelper.createEmail(contactId);

        emailHelper.editExistingEmail(200, emailId, contactId);
        // удаляем email
        emailHelper.deleteEmail(emailId);

        // удаляем контакт
        contactHelper.deleteContact(contactId);
    }
}
