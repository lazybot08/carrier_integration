package com.godash.CarrierIntegration.controller;

import com.godash.CarrierIntegration.model.Shipment;
import com.godash.CarrierIntegration.model.Tracking;
import com.godash.CarrierIntegration.repository.ShipmentRepository;
import com.godash.CarrierIntegration.repository.TrackingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shipments")
public class ShipmentController {

    @Autowired
    private ShipmentRepository shipmentRepository;

    @Autowired
    private TrackingRepository trackingRepository;

    @GetMapping
    public ResponseEntity<Iterable<Shipment>> getShipments() {
        Iterable<Shipment> shipments = shipmentRepository.findAll();
        return ResponseEntity.ok(shipments);
    }

    @PostMapping("/create")
    public ResponseEntity<Shipment> createShipment(@RequestBody Shipment shipment) {
        try {
            Shipment savedShipment = shipmentRepository.save(shipment);

            // Create tracking information for the new shipment
            Tracking newTracking = new Tracking();
            newTracking.setShipmentId(savedShipment.getId()); // Assuming you have a field in Tracking to store the shipment ID
            newTracking.setStatus("Pending");
            newTracking.setLocation(savedShipment.getOrigin());
            newTracking.setEstimatedDeliveryTime(null);
            trackingRepository.save(newTracking);

            return ResponseEntity.status(HttpStatus.CREATED).body(savedShipment);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Shipment> updateShipment(@PathVariable String id, @RequestBody Shipment shipmentDetails) {
        Shipment shipment = shipmentRepository.findById(id)
                .orElse(null);
        if (shipment == null) {
            return ResponseEntity.notFound().build();
        }
        shipment.setSender(shipmentDetails.getSender());
        shipment.setRecipient(shipmentDetails.getRecipient());
        shipment.setOrigin(shipmentDetails.getOrigin());
        shipment.setDestination(shipmentDetails.getDestination());
        shipment.setWeight(shipmentDetails.getWeight());
        shipment.setPackageType(shipmentDetails.getPackageType());

        final Shipment updatedShipment = shipmentRepository.save(shipment);
        return ResponseEntity.ok(updatedShipment);
    }
}
