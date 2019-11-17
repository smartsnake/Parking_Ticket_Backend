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
	public ResponseEntity<?> getAllPoints()
	{
		List<Point> inv = repository.findAll();
		if(inv == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		else {
			return new ResponseEntity<>(inv,HttpStatus.OK);
		}
	}

	//return list of all points within two times
	@RequestMapping(value = "/points/", method = RequestMethod.GET)
	public ResponseEntity<?> getAllPointsWithinTimes(long time1, long time2)
	{
		List<Point> inv = repository.findAll();
		if(inv == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		else {
			for(Iterator<Point> iter = inv.iterator(); iter.hasNext();) {
				Point a = iter.next();
				if(a.gettime() < time1 || a.gettime() > time2)) {
					iter.remove();
				}
			}
			return new ResponseEntity<>(inv,HttpStatus.OK);
		}
	}
	
	//create new point
	@RequestMapping(value = "/point/", method = RequestMethod.POST, produces="application/json")
	public ResponseEntity<?> savePoint(@Valid @RequestBody Point savePoint) {
		//TODO: Add validation here, Make sure that Point is not null and the coords and time is valid.
		if(savePoint == null){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}


		return new ResponseEntity<>(repository.save(savePoint), HttpStatus.CREATED);
	}


}