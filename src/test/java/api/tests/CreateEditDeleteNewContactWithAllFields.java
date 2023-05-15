package api.tests;

import api.contact.ContactApi;
import api.helpers.AddressHelper;
import api.helpers.ContactHelper;
import api.helpers.EmailHelper;
import api.helpers.PhoneHelper;
import org.testng.annotations.Test;

public class CreateEditDeleteNewContactWithAllFields {

    ContactApi contactApi = new ContactApi();
    ContactHelper contactHelper = new ContactHelper();
    EmailHelper emailHelper = new EmailHelper();
    PhoneHelper phoneHelper = new PhoneHelper();
    AddressHelper addressHelper = new AddressHelper();

    @Test
    public void CreateEditDeleteNewContact() {
        // создаем новый контакт
        Integer contactId = contactHelper.createContact();

        Integer emailId = emailHelper.createEmail(contactId);
        emailHelper.editExistingEmail(200, emailId, contactId);
        emailHelper.deleteEmail(emailId);

        Integer phoneId = phoneHelper.createPhone(contactId);
        phoneHelper.editPhone(phoneId, contactId);
        phoneHelper.deletePhone(phoneId);

        Integer addressId = addressHelper.createAddress(contactId);
        addressHelper.editAddress(addressId, contactId);
        addressHelper.deleteAddress(addressId);

        // удаляем контакт
        contactHelper.deleteContact(contactId);
    }
}
