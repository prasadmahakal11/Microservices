
package com.nt.ms;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.client.BillingServiceConsumerClient;

@RestController
@RequestMapping("/shopping")
public class ShoppingServiceOperationsController {
	@Autowired
	private  BillingServiceConsumerClient client;
	
	@GetMapping("/details")
	public  ResponseEntity<String>  showBillingDetails(){
		 //  use Client comp support to invoke Provider MS service
		  ResponseEntity<String> entity=client.getBillingDetails();
		  String  resultBody=entity.getBody();  // Provider MS result
		  // return  ResponseEnttiy<String> object from Consumer MS
		    String billInfo="Bill amount::"+ new Random().nextInt(100000);  // cosumer MS result
		  return  new ResponseEntity<String>(billInfo+"....."+resultBody,HttpStatus.OK);  // contains  Provider MS+ cosumer MS
	}

}
