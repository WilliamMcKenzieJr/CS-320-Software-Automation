package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java_main.Contact;
import java_main.ContactService;

class ContactServiceTest {

	@Test
	void testAddContact() {
		ContactService service = new ContactService();
		Contact contact = new Contact("1", "John", "Hamond", "3427890392", "Faris St");
		
		service.addContact(contact);
		
		assertNotNull(service.findContact("1"));
		
		assertEquals("1", service.findContact("1").getContactId());
		assertEquals("John", service.findContact("1").getFirstName());
		assertEquals("Hamond", service.findContact("1").getLastName());
		assertEquals("3427890392", service.findContact("1").getPhoneNumber());
		assertEquals("Faris St", service.findContact("1").getAddress());
	}
	@Test
	void testDeleteContact() {
		ContactService service = new ContactService();
		Contact contact = new Contact("1", "John", "Hamond", "3427890392", "Faris St");
		
		service.addContact(contact);
		service.deleteContact("1");
		assertNull(service.findContact("1"));
	}
	@Test
	void testUpdateContact() {
		ContactService service = new ContactService();
		Contact contact = new Contact("1", "John", "Hamond", "3427890392", "Faris St");
		
		service.addContact(contact);
		service.updateFirstName("1", "Johnny");
		service.updateLastName("1", "Smith");
		service.updatePhoneNumber("1", "3427838292");
		service.updateAddress("1", "Faris Lane");
		
		assertEquals("Johnny", service.findContact("1").getFirstName());
		assertEquals("Smith", service.findContact("1").getLastName());
		assertEquals("3427838292", service.findContact("1").getPhoneNumber());
        assertEquals("Faris Lane", service.findContact("1").getAddress());
        assertEquals("1", service.findContact("1").getContactId());
	}
	@Test
	void testAddDuplicateContactIdNotAllowed() {
		ContactService service = new ContactService();
		Contact contact1 = new Contact("1", "John", "Hamond", "3427890392", "Faris St");
		Contact contact2 = new Contact("1", "Johnny", "Hamonds", "3427838392", "Faris Lane");
			
		service.addContact(contact1);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addContact(contact2);
			
			
		});
	}

}
