//EmployeeOperationsController.java
package com.nt.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")
public class EmployeeOperationsController {
	
	@Value("${dbuser}")
	private  String user;
	
	@Value("${dbpwd}")
	private  String pwd;
	
	@GetMapping("/show")
	public  ResponseEntity<String>  showData(){
		return new ResponseEntity<String>(" db Properties from GITLab Account are ::"+user+"...."+pwd,HttpStatus.OK);
	}

}
