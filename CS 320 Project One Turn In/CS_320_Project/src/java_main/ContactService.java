package java_main;

import java.util.ArrayList;
import java.util.List;

public class ContactService {
	List<Contact> contacts = new ArrayList<>();
	public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null");
        }

        if (findContact(contact.getContactId()) != null) {
            throw new IllegalArgumentException("Contact ID already exists");
        }

        contacts.add(contact);
    }	
	public void deleteContact(String contactId) {
        Contact contact = findContact(contactId);

        if (contact == null) {
            throw new IllegalArgumentException("Contact not found");
        }

        contacts.remove(contact);
    }
	public void updateFirstName(String contactId, String firstName) {
        Contact contact = findContact(contactId);

        if (contact == null) {
            throw new IllegalArgumentException("Contact not found");
        }

        contact.setFirstName(firstName);
    }
	public void updateLastName(String contactId, String lastName) {
		Contact contact = findContact(contactId);

        if (contact == null) {
            throw new IllegalArgumentException("Contact not found");
        }

        contact.setLastName(lastName);
    }
	public void updatePhoneNumber(String contactId, String phoneNumber) {
		Contact contact = findContact(contactId);

        if (contact == null) {
            throw new IllegalArgumentException("Contact not found");
        }

        contact.setPhoneNumber(phoneNumber);
    }
	public void updateAddress(String contactId, String address) {
		Contact contact = findContact(contactId);

        if (contact == null) {
            throw new IllegalArgumentException("Contact not found");
        }

        contact.setAddress(address);
    }
	public Contact findContact(String contactId) {
        for (Contact contact : contacts) {
            if (contact.getContactId().equals(contactId)) {
                return contact;
            }
        }

        return null;
    }
}