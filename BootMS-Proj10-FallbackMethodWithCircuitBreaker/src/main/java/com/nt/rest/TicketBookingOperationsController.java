//TicketBookingOperationsController.java
package com.nt.rest;

import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
@RequestMapping("/tickets")
public class TicketBookingOperationsController {
	
	
	@GetMapping("/booking")
	/*@HystrixCommand(fallbackMethod = "dummyMethod",
	                                          commandProperties = {@HystrixProperty(name="circuitBreaker.enabled", value="true") })*/
	
	@HystrixCommand(fallbackMethod = "dummyMethod",
    commandProperties = {@HystrixProperty(name="circuitBreaker.enabled", value="true"),
    		                                      @HystrixProperty(name="circuitBreaker.requestVolumeThreshold", value="5"),
                                                  @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds", value="7000")
                                                }
	                                       )
	
	public   ResponseEntity<String> bookTickets(){
		System.out.println("TicketBookingOperationsController.bookTickets()");
		  if(new Random().nextInt(10)<8)
			    throw  new RuntimeException("Problem in  ticket booking");
		  
		return  new  ResponseEntity<String>("booked the tickets ....",HttpStatus.OK);
	}
	int  count=0;
	public    ResponseEntity<String> dummyMethod(){
		System.out.println("TicketBookingOperationsController.dummyMethod()::"+ ++count);
		return  new  ResponseEntity<String>("Please try later .. some problem in ticket booking operation",HttpStatus.OK);
	}

}//class
