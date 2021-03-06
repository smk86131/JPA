package com.mh.org;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mh.org.domain.Customer;
import com.mh.org.repository.CustomerRepository;

/**
 * jsp php asp 70~80 25 5
 * 
 * java + html = jsp
 */
@Controller
public class HomeController {

	@Autowired
	private CustomerRepository customerRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
//		logger.info("Welcome home! The client locale is {}.", locale);

//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		
//		String formattedDate = dateFormat.format(date);
//		
//		model.addAttribute("serverTime", formattedDate );

		model.addAttribute("mh", "haha");
		demo();

		return "home";
	}

	public void demo() {
		// save a few customers
		customerRepository.save(new Customer("Jack", "Bauer"));
		customerRepository.save(new Customer("Chloe", "O'Brian"));
		customerRepository.save(new Customer("Kim", "Bauer"));
		customerRepository.save(new Customer("David", "Palmer"));
		customerRepository.save(new Customer("Michelle", "Dessler"));

		// fetch all customers
		logger.info("Customers found with findAll():");
		logger.info("-------------------------------");
		for (Customer customer : customerRepository.findAll()) {
			logger.info(customer.toString());
		}
		logger.info("");

		// fetch an individual customer by ID
		Customer customer = customerRepository.findById(1L);
		logger.info("Customer found with findById(1L):");
		logger.info("--------------------------------");
		logger.info(customer.toString());
		logger.info("");

		// fetch customers by last name
		logger.info("Customer found with findByLastName('Bauer'):");
		logger.info("--------------------------------------------");
		customerRepository.findByLastName("Bauer").forEach(bauer -> {
			(Customer bauer) -> {
			logger.info(bauer.toString());
			}
		);
		// for (Customer bauer : repository.findByLastName("Bauer")) {
		// log.info(bauer.toString());
		// }
		logger.info("");
	}

}
