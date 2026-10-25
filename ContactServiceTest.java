package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import contact.Contact;
import contact.ContactService;

public class ContactServiceTest {

    @Test
    public void testAddContact() {
        ContactService service = new ContactService();

        Contact contact = new Contact(
                "12345",
                "Trevor",
                "Powell",
                "1234567890",
                "123 Main Street"
        );

        service.addContact(contact);

        assertDoesNotThrow(() -> service.updateFirstName("12345", "John"));
    }

    @Test
    public void testDuplicateContactIdCannotBeAdded() {
        ContactService service = new ContactService();

        Contact contact1 = new Contact(
                "12345", "Trevor", "Powell",
                "1234567890", "123 Main Street");

        Contact contact2 = new Contact(
                "12345", "John", "Smith",
                "0987654321", "456 Oak Street");

        service.addContact(contact1);

        assertThrows(IllegalArgumentException.class, () ->
                service.addContact(contact2));
    }

    @Test
    public void testDeleteContact() {
        ContactService service = new ContactService();

        Contact contact = new Contact(
                "12345", "Trevor", "Powell",
                "1234567890", "123 Main Street");

        service.addContact(contact);
        service.deleteContact("12345");

        assertThrows(IllegalArgumentException.class, () ->
                service.updateFirstName("12345", "John"));
    }

    @Test
    public void testUpdateFirstName() {
        ContactService service = new ContactService();

        Contact contact = new Contact(
                "12345", "Trevor", "Powell",
                "1234567890", "123 Main Street");

        service.addContact(contact);
        service.updateFirstName("12345", "John");

        assertDoesNotThrow(() ->
                service.updateFirstName("12345", "Mike"));
    }

    @Test
    public void testUpdateLastName() {
        ContactService service = new ContactService();

        Contact contact = new Contact(
                "12345", "Trevor", "Powell",
                "1234567890", "123 Main Street");

        service.addContact(contact);
        service.updateLastName("12345", "Smith");

        assertDoesNotThrow(() ->
                service.updateLastName("12345", "Jones"));
    }

    @Test
    public void testUpdatePhone() {
        ContactService service = new ContactService();

        Contact contact = new Contact(
                "12345", "Trevor", "Powell",
                "1234567890", "123 Main Street");

        service.addContact(contact);
        service.updatePhone("12345", "0987654321");

        assertDoesNotThrow(() ->
                service.updatePhone("12345", "1111111111"));
    }

    @Test
    public void testUpdateAddress() {
        ContactService service = new ContactService();

        Contact contact = new Contact(
                "12345", "Trevor", "Powell",
                "1234567890", "123 Main Street");

        service.addContact(contact);
        service.updateAddress("12345", "456 Oak Street");

        assertDoesNotThrow(() ->
                service.updateAddress("12345", "789 Pine Street"));
    }

    @Test
    public void testUpdateNonexistentContact() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () ->
                service.updateFirstName("99999", "John"));
    }

    @Test
    public void testDeleteNonexistentContact() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () ->
                service.deleteContact("99999"));
    }
}
