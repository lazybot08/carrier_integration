package com.godash.CarrierIntegration.controller;

import com.godash.CarrierIntegration.model.Tracking;
import com.godash.CarrierIntegration.repository.TrackingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/trackings")
public class TrackingController {

    @Autowired
    private TrackingRepository trackingRepository;

    @GetMapping
    public ResponseEntity<List<Tracking>> getTrackings() {
        try {
            List<Tracking> trackings = trackingRepository.findAll();
            return ResponseEntity.ok(trackings);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tracking> getTrackingById(@PathVariable String id) {
        try {
            Optional<Tracking> optionalTracking = trackingRepository.findByShipmentId(id);
            if (optionalTracking.isPresent()) {
                return ResponseEntity.ok(optionalTracking.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tracking> updateTrackingById(@PathVariable String id, @RequestBody Tracking updatedTracking) {
        try {
            Optional<Tracking> optionalTracking = trackingRepository.findByShipmentId(id);
            if (optionalTracking.isPresent()) {
                Tracking existingTracking = optionalTracking.get();
                existingTracking.setStatus(updatedTracking.getStatus());
                existingTracking.setLocation(updatedTracking.getLocation());
                existingTracking.setEstimatedDeliveryTime(updatedTracking.getEstimatedDeliveryTime());
                return ResponseEntity.ok(trackingRepository.save(existingTracking));
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
