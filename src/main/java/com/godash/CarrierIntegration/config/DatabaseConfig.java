package com.godash.CarrierIntegration.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class DatabaseConfig {

    private static final String DATABASE_URI = "mongodb+srv://aryanj868:DJmQWWVEcyWhhrPK@cluster0.boye3yr.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
    private static final String DATABASE_NAME = "go_dash"; // Replace with your actual database name

    public static MongoDatabase getDatabase() {
        // Create a MongoDB client
        MongoClient mongoClient = MongoClients.create(DATABASE_URI);

        // Access the specified database
        MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);

        return database;
    }
}
