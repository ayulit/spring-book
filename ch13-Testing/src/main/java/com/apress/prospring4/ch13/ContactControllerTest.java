package com.apress.prospring4.ch13;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


import java.util.ArrayList;
import java.util.List;



import org.junit.Before;
import org.junit.Test;




import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.ui.ExtendedModelMap;

public class ContactControllerTest {
	private final List<Contact> contacts = new ArrayList<Contact>();
	
	@Before // JUnit annotation
	public void initContacts() {
		Contact contact = new Contact();
		contact.setId(11);
		contact.setFirstName("Bender");
		contact.setLastName("Rodriguez");
		contacts.add(contact);
	}
	
	@Test
	public void testList() {
		ContactService contactService = mock(ContactService.class); // imitation!
		when(contactService.findAll()).thenReturn(contacts);
		
		ContactController contactController = new ContactController();
		
		// Reflection!
		ReflectionTestUtils.setField(contactController, "contactService", contactService);
		
		ExtendedModelMap uiModel = new ExtendedModelMap();
		uiModel.addAttribute("contacts", contactController.listData());
	}

}
