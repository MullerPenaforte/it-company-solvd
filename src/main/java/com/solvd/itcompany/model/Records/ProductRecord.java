package com.solvd.itcompany.model.Records;

import com.solvd.itcompany.interfaces.SensitiveData;
import com.solvd.itcompany.model.People.Client;


public record ProductRecord(float progress, @SensitiveData(mask = "HIDDEN_PRICE")double price, Client owner) {

    public ProductRecord {
        if (price <= 0) {

            throw new IllegalArgumentException("Price must be greater than zero. Received: " + price);
        }
    }


    @Override
    public String toString() {
        return "Product owner: " + owner.getName() + " | Price: $" + price;
    }
}