package com.godash.CarrierIntegration.repository;

import com.godash.CarrierIntegration.model.Tracking;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TrackingRepository extends MongoRepository<Tracking, String> {
	Optional<Tracking> findByShipmentId(String shipmentId);
}
