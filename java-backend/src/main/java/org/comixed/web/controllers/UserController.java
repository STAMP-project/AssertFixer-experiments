package org.comixed.web.controllers;

import java.security.Principal;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@RequestMapping("/user")
	@CrossOrigin
	public Principal getCurrentUser(Principal user) {
		return user;
	}
}
