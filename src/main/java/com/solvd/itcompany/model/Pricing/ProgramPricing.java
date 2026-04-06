package com.solvd.itcompany.model.Pricing;

public class ProgramPricing implements CalculateTime {
    private int complexity;
    private String type;
    private double price;

    public ProgramPricing(int complexity, String type) {
        this.complexity = complexity;
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getComplexity() {
        return complexity;
    }

    public void setComplexity(int complexity) {
        this.complexity = complexity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public double calculateTime(int developers) {
        double hours;
        double factorType;
        double factorDev;

        factorType = switch (this.type.toLowerCase()) {
            case "backend" -> 1.2;
            case "frontend" -> 1.1;
            case "front+back" -> 1.8;
            default -> 1.0;
        };

        factorDev = switch (developers) {
            case 2 -> 1.3;
            case 3 -> 1.5;
            default -> 1.0;
        };

        return Math.ceil((this.complexity * 10 * factorType) / factorDev);
    }

    public double calculatePrice(double hours, int developers, double total) {
        return price = (hours * developers * 45) + total;
    }

    @Override
    public String toString() {
        return "Price: " + price;
    }
}
