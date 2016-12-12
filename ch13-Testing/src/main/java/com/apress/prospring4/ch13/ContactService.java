package com.apress.prospring4.ch13;

import java.util.List;

// page 384
public interface ContactService {
	// 3 search methods
	List<Contact> findAll();
	List<Contact> findAllWithDeal();
	Contact findById(Long id);
	
	// 1 save method
	Contact save(Contact contact);
	
	// 1 delete method
	void delete(Contact contact);
}
