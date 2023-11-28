
package com.nt.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/billing/api")
  //@Slf4j   --->   if this added then  there is no need of creating  Logger object manually
public class BillingOperationsController {
	private static Logger logger=LoggerFactory.getLogger(BillingOperationsController.class);
	
	
	@GetMapping("/info")
	public   ResponseEntity<String>  showPaymentModes(){
		logger.info(" at beginging of  showPaymentModes() method -- Billing Service");
		ResponseEntity<String> entity=new  ResponseEntity<String>("we accept  UPI Payment/ CardPayment/ NetBanking Payment",HttpStatus.OK);
		logger.info(" at end of  showPaymentModes() method -- Billing Service");
		return  entity;
	}

}
