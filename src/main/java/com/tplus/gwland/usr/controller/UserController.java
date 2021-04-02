package com.tplus.gwland.usr.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.tplus.gwland.cmm.controller.AbstractController;
import com.tplus.gwland.sec.CurrentUser;
import com.tplus.gwland.sec.UserPrincipal;
import com.tplus.gwland.usr.domian.User;
import com.tplus.gwland.usr.repository.UserRepository;
import com.tplus.gwland.usr.service.UserServiceImpl;

import lombok.RequiredArgsConstructor;


@RestController 
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor 
@RequestMapping("/user")

public class UserController extends AbstractController<User>{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private final UserRepository userRepository;
	private final UserServiceImpl service;
	
	
	@PostMapping("/add")
	public ResponseEntity<Long> save(@RequestBody User t) {
		logger.info("회원 가입정보"+t.toString());
		return ResponseEntity.ok(service.save(t));
	}
	@PostMapping("/login")
	public ResponseEntity<Long> login(@RequestBody User t) {
		logger.info("회원 로그인정보"+t.toString());
		return ResponseEntity.ok(service.save(t));
	}
	@DeleteMapping("/delete")
	public ResponseEntity<Long> delete(@RequestBody User t) {
		return ResponseEntity.ok(service.delete(t));
	}
	@GetMapping("/count")
	public ResponseEntity<Long> count() {
		return ResponseEntity.ok(service.count());
	}
	@GetMapping("/all")
	public ResponseEntity<List<User>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}
	@GetMapping("/list")
	public ResponseEntity<Page<User>> findList(Pageable pageable){
		return ResponseEntity.ok(service.findList(pageable));
	}
	@GetMapping("/one")
	public ResponseEntity<User> getOne(@CurrentUser UserPrincipal userPrincipal) {
		return ResponseEntity.ok(userRepository.findById(userPrincipal.getId()).orElse(null));
	}
	@GetMapping("/find/{id}")
	public ResponseEntity<Optional<User>> findById(@PathVariable long id) {
		return ResponseEntity.ok(service.findById(id));
	}
	@GetMapping("/exists/{id}")
	public ResponseEntity<Boolean> existsById(@PathVariable long id) {
		return ResponseEntity.ok(service.existsById(id));
	}
	@Override   //예외처리  
	public ResponseEntity<User> getOne(long id) {
		return null;
	}
}