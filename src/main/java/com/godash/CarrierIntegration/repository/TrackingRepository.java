package com.godash.CarrierIntegration.repository;

import com.godash.CarrierIntegration.model.Tracking;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TrackingRepository extends MongoRepository<Tracking, String> {
}
