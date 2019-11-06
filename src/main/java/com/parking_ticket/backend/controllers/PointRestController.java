package com.parking_ticket.backend.controllers;

import com.parking_ticket.backend.models.Point;

import com.parking_ticket.backend.repositories.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@Validated
public class PointRestController {
	@Autowired
    private PointRepository repository;

	//return list of all points
	@RequestMapping(value = "/points/", method = RequestMethod.GET)
	public ResponseEntity<?> getAllInvoices()
	{
		List<Point> inv = repository.findAll();
		if(inv == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		else {
			return new ResponseEntity<>(inv,HttpStatus.OK);
		}
	}
	
	//create new point
	@RequestMapping(value = "/point/", method = RequestMethod.POST)
	public ResponseEntity<?> saveInvoice(@Valid @RequestBody Point savePoint) {
		
		return new ResponseEntity<>(repository.save(savePoint), HttpStatus.CREATED);
	}


}