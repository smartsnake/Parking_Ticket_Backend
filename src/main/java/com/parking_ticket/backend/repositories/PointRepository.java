package com.parking_ticket.backend.repositories;

import com.parking_ticket.backend.models.Point;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.repository.query.Param;

import java.util.*;

@RepositoryRestResource
public interface PointRepository extends MongoRepository<Point, String> {
    public List<Point> getAllPointsWithinTimes(@Param("time1")long time1, @Param("time2")long time2);
}
