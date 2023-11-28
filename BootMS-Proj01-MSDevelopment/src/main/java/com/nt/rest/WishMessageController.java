//WishMessageController.java
package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wish")
public class WishMessageController {
	
	
	@GetMapping("/display")
	public  ResponseEntity<String>  displayWishMessage(){
		return new ResponseEntity<String>("Welcome to  MicroServices",HttpStatus.OK);
	}

}
