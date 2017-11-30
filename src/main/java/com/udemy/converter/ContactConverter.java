package com.udemy.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.udemy.entity.Contact;
import com.udemy.model.ContactModel;

@Component("contactConverter")
public class ContactConverter {

	public Contact convertToContactModelToContact(ContactModel contactModel) {
		Contact contact = new Contact();
		contact.setCity(contactModel.getCity());
		contact.setFirstName(contactModel.getFirstName());
		contact.setLastName(contactModel.getLastName());
		contact.setTelephone(contactModel.getTelephone());
		contact.setId(contactModel.getId());
		return contact;
		
		
	}
	
	public ContactModel convertContactToContactModel(Contact contact) {
		ContactModel contactModel = new ContactModel();
		if(null != contact) {
			
			contactModel.setCity(contact.getCity());
			contactModel.setFirstName(contact.getFirstName());
			contactModel.setLastName(contact.getLastName());
			contactModel.setTelephone(contact.getTelephone());
			contactModel.setId(contact.getId());
		}
		
		return contactModel;
	}
	
	public List<ContactModel> convertContactsToContactModels(List<Contact> contacts) {
		List<ContactModel> contactModels = new ArrayList<ContactModel>();
		
		for (Contact contact : contacts) {
			ContactModel contactModel = new ContactModel();
			contactModel.setCity(contact.getCity());
			contactModel.setFirstName(contact.getFirstName());
			contactModel.setLastName(contact.getLastName());
			contactModel.setTelephone(contact.getTelephone());
			contactModel.setId(contact.getId());
			contactModels.add(contactModel);
		}
	
		return contactModels;
	}
	
}
