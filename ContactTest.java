package test;

import contact.Contact;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    public void testValidContact() {
        Contact contact = new Contact(
                "12345",
                "Trevor",
                "Powell",
                "1234567890",
                "123 Main Street"
        );

        assertEquals("12345", contact.getContactId());
        assertEquals("Trevor", contact.getFirstName());
        assertEquals("Powell", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main Street", contact.getAddress());
    }

    @Test
    public void testContactIdCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact(null, "Trevor", "Powell",
                        "1234567890", "123 Main Street"));
    }

    @Test
    public void testContactIdCannotBeLongerThan10Characters() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345678901", "Trevor", "Powell",
                        "1234567890", "123 Main Street"));
    }

    @Test
    public void testFirstNameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", null, "Powell",
                        "1234567890", "123 Main Street"));
    }

    @Test
    public void testFirstNameCannotBeLongerThan10Characters() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", "Christopher", "Powell",
                        "1234567890", "123 Main Street"));
    }

    @Test
    public void testLastNameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", "Trevor", null,
                        "1234567890", "123 Main Street"));
    }

    @Test
    public void testLastNameCannotBeLongerThan10Characters() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", "Trevor", "Washingtonn",
                        "1234567890", "123 Main Street"));
    }

    @Test
    public void testPhoneCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", "Trevor", "Powell",
                        null, "123 Main Street"));
    }

    @Test
    public void testPhoneMustBe10Digits() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", "Trevor", "Powell",
                        "123456789", "123 Main Street"));
    }

    @Test
    public void testPhoneCannotContainLetters() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", "Trevor", "Powell",
                        "12345ABCDE", "123 Main Street"));
    }

    @Test
    public void testAddressCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", "Trevor", "Powell",
                        "1234567890", null));
    }

    @Test
    public void testAddressCannotBeLongerThan30Characters() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", "Trevor", "Powell",
                        "1234567890",
                        "1234567890123456789012345678901"));
    }

    @Test
    public void testFirstNameCanBeUpdated() {
        Contact contact = new Contact(
                "12345", "Trevor", "Powell",
                "1234567890", "123 Main Street");

        contact.setFirstName("John");

        assertEquals("John", contact.getFirstName());
    }

    @Test
    public void testLastNameCanBeUpdated() {
        Contact contact = new Contact(
                "12345", "Trevor", "Powell",
                "1234567890", "123 Main Street");

        contact.setLastName("Smith");

        assertEquals("Smith", contact.getLastName());
    }

    @Test
    public void testPhoneCanBeUpdated() {
        Contact contact = new Contact(
                "12345", "Trevor", "Powell",
                "1234567890", "123 Main Street");

        contact.setPhone("0987654321");

        assertEquals("0987654321", contact.getPhone());
    }

    @Test
    public void testAddressCanBeUpdated() {
        Contact contact = new Contact(
                "12345", "Trevor", "Powell",
                "1234567890", "123 Main Street");

        contact.setAddress("456 Oak Street");

        assertEquals("456 Oak Street", contact.getAddress());
    }
}