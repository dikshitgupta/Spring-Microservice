package com.nagal.user.controller;

import com.nagal.user.VO.ResponseTemplateVO;
import com.nagal.user.entity.User;
import com.nagal.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/")
	public User saveUser(@RequestBody User user){
		log.info("In save  user inside Usercontroller");
		return userService.saveUser(user);
	}

	@GetMapping("/{id}")
	public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId){
		log.info("In save  user inside Usercontroller");
		return userService.getUserWithDepartment(userId);
	}


}
