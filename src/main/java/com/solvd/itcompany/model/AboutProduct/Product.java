package com.solvd.itcompany.model.AboutProduct;

import com.solvd.itcompany.model.People.Client;
import com.solvd.itcompany.exceptions.InvalidPriceException;
import java.util.Objects;

public class Product {
    private float progress = 0.0E0f;
    private double price;
    private Client owner;

    public Product(float progress, Client owner) {
        this.progress = progress;
        this.owner = owner;
    }

    public float getProgress() {
        return progress;
    }

    public void setProgress(float progress) {
        this.progress = progress;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws InvalidPriceException {
        if (price <= 0) {
            throw new InvalidPriceException("Invalid price: $" + price + ". Price must be greater than zero.");
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product owner: " + owner.getName() + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(owner, product.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner);
    }
}