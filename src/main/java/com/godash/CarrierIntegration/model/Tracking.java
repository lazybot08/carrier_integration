package com.godash.CarrierIntegration.model;

import org.springframework.data.annotation.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Tracking {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String trackingId;
    
    private String shipmentId;
    private String status;
    private String location;
    private String estimatedDeliveryTime;

    // Constructors, getters, and setters
    
    public Tracking() {
    }
    
    public String getTrackingId() {
        return trackingId;
    }

    public String getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(String long1) {
        this.shipmentId = long1;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEstimatedDeliveryTime() {
        return estimatedDeliveryTime;
    }

    public void setEstimatedDeliveryTime(String estimatedDeliveryTime) {
        this.estimatedDeliveryTime = estimatedDeliveryTime;
    }
}
