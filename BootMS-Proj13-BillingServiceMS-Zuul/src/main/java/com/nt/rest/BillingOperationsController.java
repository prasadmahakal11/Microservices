
package com.nt.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/billing/api")
  //@Slf4j   --->   if this added then  there is no need of creating  Logger object manually
public class BillingOperationsController {
	@Value("${server.port}")
	private   int  port;
	@Value("${eureka.instance.instance-id}")
	private   String instanceId;
	
	
	
	@GetMapping("/info")
	public   ResponseEntity<String>  showPaymentModes(){
		ResponseEntity<String> entity=new  ResponseEntity<String>("we accept  UPI Payment/ CardPayment/ NetBanking Payment --instancedId::"+instanceId+"..."+port,HttpStatus.OK);
		return  entity;
	}

}
