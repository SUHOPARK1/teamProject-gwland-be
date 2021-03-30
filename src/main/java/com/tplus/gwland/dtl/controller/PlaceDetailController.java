package com.tplus.gwland.dtl.controller;

import java.util.List;
import java.util.Optional;

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
import com.tplus.gwland.dtl.domain.PlaceDetail;
import com.tplus.gwland.dtl.service.PlaceDetailServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/detail")
public class PlaceDetailController extends AbstractController<PlaceDetail> {
	private final PlaceDetailServiceImpl service;

	@PostMapping("/save")
	public ResponseEntity<Long> save(@RequestBody PlaceDetail t) {
		System.out.println(t);
		return ResponseEntity.ok(service.save(t));
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Long> delete(@RequestBody PlaceDetail t) {
		return ResponseEntity.ok(service.delete(t));
	}

	@GetMapping("/count")
	public ResponseEntity<Long> count() {
		return ResponseEntity.ok(service.count());
	}

	@GetMapping("/one/{id}")
	public ResponseEntity<PlaceDetail> getOne(@PathVariable long id) {
		return ResponseEntity.ok(service.getOne(id));
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Optional<PlaceDetail>> findById(@PathVariable long id) {
		return ResponseEntity.ok(service.findById(id));
	}

	@GetMapping("/exists/{id}")
	public ResponseEntity<Boolean> existsById(@PathVariable long id) {
		return ResponseEntity.ok(service.existsById(id));
	}

	@GetMapping("/all")
	public ResponseEntity<List<PlaceDetail>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}

	@GetMapping("/contentid/{contentid}")
	public ResponseEntity<List<PlaceDetail>> findByContentid(String contentid) {
		return ResponseEntity.ok(service.findByContentid(contentid));
	}

}