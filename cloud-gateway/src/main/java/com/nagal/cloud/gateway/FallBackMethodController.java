package com.nagal.cloud.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

	@GetMapping("/userServiceFallBack")
	public String userServiceFallBackMethod(){
		return "user Service is taking longer than Expected  to respond" +
				"please try again later";
	}

	@GetMapping("/departmentServiceFallBack")
	public String departmentServiceFallBackMethod(){
		return "Department Service is taking longer than Expected to respond" +
				"please try again later";
	}


}
