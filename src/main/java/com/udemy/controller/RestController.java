package com.udemy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.udemy.model.ContactModel;
import com.udemy.service.ContactService;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {
	
	
	@Autowired
	@Qualifier("contactServiceImpl")
	private ContactService contactService;
	

	@GetMapping("/checkrest")
	public ResponseEntity<List<ContactModel>> checkRest(){
		
		
		return new ResponseEntity<List<ContactModel>>(contactService.listAllContacts(), HttpStatus.OK);
		
	}
	
}
