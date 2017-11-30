package com.udemy.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.constant.ViewConstant;
import com.udemy.model.ContactModel;
import com.udemy.service.ContactService;

@Controller
@RequestMapping("/contacts")
public class ContactController {
	
	private static final Log LOG = LogFactory.getLog(ContactController.class);
	
	@Autowired
	@Qualifier("contactServiceImpl")
	private ContactService contactService;
	
	@GetMapping("/cancel")
	public String cancel(){
		
		return ViewConstant.REDIRECT_SHOW_CONTACTS;
	}
	

	@GetMapping("/contactform")
	public ModelAndView redictContactForm(@RequestParam(name = "id", required = false) int id) {
		ContactModel contactModel = new ContactModel();
		if(id != 0) {
			contactModel = contactService.findContactByIdModel(id);
		}
		
		ModelAndView modelAndView = new ModelAndView(ViewConstant.CONTACT_FORM);
		modelAndView.addObject("contactModel",contactModel);
		
		return modelAndView;
	}
	
	@PostMapping("/addcontact")
	public ModelAndView addContact(@ModelAttribute(name = "contactModel") ContactModel contactModel) {
		ModelAndView modelAndView = new ModelAndView(ViewConstant.REDIRECT_SHOW_CONTACTS);
		LOG.info("METHOD : addContact() -- PARAMS: " + contactModel.toString());
		
		if(null != contactService.addContact(contactModel)) {
			modelAndView.addObject("result", 1);
		}else {
			modelAndView.addObject("result", 0);
		}
		
		
		return modelAndView;
	}
	@GetMapping("/showcontacts")
	public ModelAndView showContacts() {
		ModelAndView modelAndView = new ModelAndView(ViewConstant.CONTACTS);
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		modelAndView.addObject("username", user.getUsername());
		modelAndView.addObject("contacts", contactService.listAllContacts());
		return modelAndView;
	}
	
//	Este metodo debería ser post y el envio al server deberia ser por ajax.
	@GetMapping("/removecontact")
	public ModelAndView removeContact(@RequestParam(name = "id", required = true) int id) {
		contactService.removeContact(id);
		
		return showContacts();
	}
	
	
	
}
