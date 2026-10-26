package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java_main.Contact;

class ContactTest {

	@Test
	void testContact() {
		Contact contact = new Contact("3238", "John", "Hamond", "3427890392", "Faris St");
		assertTrue(contact.getContactId().equals("3238"));
		assertTrue(contact.getFirstName().equals("John"));
		assertTrue(contact.getLastName().equals("Hamond"));
		assertTrue(contact.getPhoneNumber().equals("3427890392"));
		assertTrue(contact.getAddress().equals("Faris St"));
		
	}
	
	@Test
	void testContactFirstNameToLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("3238", "John Smithy110020", "Hamond", "3427890392", "Faris St");
		});
	}
	
	@Test
	void testContactLastNameToLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("3238", "John", "Hamond10299303", "3427890392", "Faris St");
		});
	}
	
	@Test
	void testContactPhoneNumberWrongNumberAmount() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("3238", "John", "Hamond", "34278", "Faris St");
		});
	}
	
	@Test
	void testContactAddressToLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("3238", "John", "Hamond", "3427890392", "Faris St7457287420754902752045720975295732490");
		});
	}
	@Test
	void testNullContactId() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "John", "Hamond", "3427890392", "Faris St");
		});
	}
	@Test
	void testNullFirstName() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("3238", null, "Hamond", "3427890392", "Faris St");
		});
	}
	@Test
	void testNullLastName() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("3238", "John", null, "3427890392", "Faris St");
		});
	}
	@Test
	void testNullPhoneNumber() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("3238", "John", "Hamond", null, "Faris St");
		});
	}
	@Test
	void testNullAddress() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("3238", "John", "Hamond","3427890392", null);
		});
	}
}
