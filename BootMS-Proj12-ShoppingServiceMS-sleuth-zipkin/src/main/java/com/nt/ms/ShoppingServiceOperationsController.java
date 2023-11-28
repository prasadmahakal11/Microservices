
package com.nt.ms;

import java.util.Arrays;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.client.IBillingServiceRestConsumer;

@RestController
@RequestMapping("/shopping/api")
public class ShoppingServiceOperationsController {
	@Autowired
	private  IBillingServiceRestConsumer client;  //Client comp injection
	private Logger logger=LoggerFactory.getLogger(ShoppingServiceOperationsController.class);
	
	@GetMapping("/details")
	public  ResponseEntity<String>  showBillingDetails(){
		logger.info("at the beginging of  showBillingDetails() --ShoppingService");
		 //  use Client comp support to invoke Provider MS service
		logger.info("before calling provider Ms");
		  ResponseEntity<String> entity=client.getBillingInfo();
		  String  resultBody=entity.getBody();  // Provider MS result
		  logger.info("after calling provider Ms");
		  // return  ResponseEnttiy<String> object from Consumer MS
		    String billInfo="Bill amount::"+ new Random().nextInt(100000);  // consumer MS result
		    
		    logger.info("at the end  of  showBillingDetails() --ShoppingService");
		  return  new ResponseEntity<String>(billInfo+"....."+resultBody,HttpStatus.OK);  // contains  Provider MS+ cosumer MS
	}

}
