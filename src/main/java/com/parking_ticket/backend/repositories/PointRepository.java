package com.parking_ticket.backend.repositories;

import com.parking_ticket.backend.models.Point;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface PointRepository extends MongoRepository<Point, String> {

}
