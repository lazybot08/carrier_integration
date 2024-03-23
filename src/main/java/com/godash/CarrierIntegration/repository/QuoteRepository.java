package com.godash.CarrierIntegration.repository;

import com.godash.CarrierIntegration.model.Quote;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuoteRepository extends MongoRepository<Quote, String> {
}
