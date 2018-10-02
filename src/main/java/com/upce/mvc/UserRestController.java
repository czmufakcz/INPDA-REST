package com.upce.mvc;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/users")
public class UserRestController {

	@GetMapping
	public ResponseEntity<String> getUsers() {
        return new ResponseEntity<String>("Pepa", HttpStatus.OK);
	}
}
