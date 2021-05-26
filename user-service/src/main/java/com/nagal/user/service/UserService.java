package com.nagal.user.service;

import com.nagal.user.VO.Department;
import com.nagal.user.VO.ResponseTemplateVO;
import com.nagal.user.entity.User;
import com.nagal.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Slf4j
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;

//	@Autowired
//	private WebClient.Builder webclientbuilder;

	public User saveUser(User user) {
		log.info("inside saveUser in service");
		return userRepository.save(user);
	}

	public ResponseTemplateVO getUserWithDepartment(Long userId) {
		log.info("inside getUserWithDepartment in UserService ");
		ResponseTemplateVO vo=new ResponseTemplateVO();
		User user=userRepository.getByUserId(userId);

//		WebClient.Builder builder= WebClient.builder();

		Department department= restTemplate.getForObject("http://localhost:9001/departments/" + user.getDepartmentId(),Department.class);

		//Using builder patter to build on top of webclientbuilder going a get, over a uri and then doing a retierve.
		//body to mono whatever you are getting convert it to instance of department class.
		// reactive way of saying you are getting object, promise that you will get this object back.
		// getting back an asynchronous object. blocking it until we get a response.

//		Department department=webclientbuilder.build()
//				.get()
//				.uri("http://localhost:9001/departments/" + user.getDepartmentId())
//				.retrieve()
//				.bodyToMono(Department.class)
//				.block();

		vo.setDepartment(department);
		vo.setUser(user);
		return vo;
	}

}
