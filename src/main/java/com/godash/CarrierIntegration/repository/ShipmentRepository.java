package com.godash.CarrierIntegration.repository;

import com.godash.CarrierIntegration.model.Shipment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShipmentRepository extends MongoRepository<Shipment, String> { // Change type parameter to String
}

