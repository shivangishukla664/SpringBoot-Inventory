package com.niit.inventory.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.inventory.model.Customer;
import com.niit.inventory.model.Product;
import com.niit.inventory.services.CustomerService;


@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	
	@RequestMapping("/login")
	public String viewHomePage(Model model)
	{
		List<Customer> listCustomers=service.listAll();
		model.addAttribute("listCustomers",listCustomers);
		return "login";
	}
	
	@RequestMapping("/view-customer")
	public String viewCustomer(Model model)
	{
		List<Customer> listCustomers=service.listAll();
		model.addAttribute("listCustomers",listCustomers);
		return "view-customer";
	}
	
	@RequestMapping("/showFormcust")
	public String showNewCustomer(Model model) {
	Customer customer = new Customer();
	model.addAttribute("customer", customer);

	return "customer";
	}
	
	
	
	
	
	@RequestMapping(value = "/saveCustomer", method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
	service.save(customer);

	return "redirect:login";
	}
	
	
	@RequestMapping(value = "/saveCustomers", method = RequestMethod.POST)
	public String saveCustomer1(@ModelAttribute("customer") Customer customer) {
	service.save(customer);

	return "redirect:view-customer";
	}
	
	

	@RequestMapping("/editCustomer")
	public ModelAndView showEditCustomerPage(@RequestParam("cust_id") int cust_id) {
	ModelAndView mav = new ModelAndView("edit-customer");
	Customer customer = service.get(cust_id);
	mav.addObject("customer", customer);

	return mav;
	}
	
	
	
	@RequestMapping("/deleteCustomer")
	public String deleteProduct(@RequestParam("cust_id") int cust_id) {
	service.delete(cust_id);
	return "redirect:view-customer";
	}
}
