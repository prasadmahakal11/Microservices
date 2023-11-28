
package com.nt.ms;

import java.util.Arrays;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
	
	@GetMapping("/details")
	public  ResponseEntity<String>  showBillingDetails(){
		System.out.println(client.getClass()+"  ..."+Arrays.toString(client.getClass().getInterfaces()));
		 //  use Client comp support to invoke Provider MS service
		  ResponseEntity<String> entity=client.getBillingInfo();
		  String  resultBody=entity.getBody();  // Provider MS result
		  try {
			  Thread.sleep(30000);
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
		  // return  ResponseEnttiy<String> object from Consumer MS
		    String billInfo="Bill amount::"+ new Random().nextInt(100000);  // consumer MS result
		  return  new ResponseEntity<String>(billInfo+"....."+resultBody,HttpStatus.OK);  // contains  Provider MS+ cosumer MS
	}

}
