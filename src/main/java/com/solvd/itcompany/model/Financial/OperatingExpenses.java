package com.solvd.itcompany.model.Financial;

public class OperatingExpenses {
    private double softwarePrice;
    private double officeSuppliesPrice;
    private double total;

    public OperatingExpenses(double softwarePrice, double officeSuppliesPrice) {

        this.softwarePrice = softwarePrice;
        this.officeSuppliesPrice = officeSuppliesPrice;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getOfficeSuppliesPrice() {
        return officeSuppliesPrice;
    }

    public void setOfficeSuppliesPrice(double officeSuppliesPrice) {
        this.officeSuppliesPrice = officeSuppliesPrice;
    }

    public double getSoftwarePrice() {
        return softwarePrice;
    }

    public void setSoftwarePrice(double softwarePrice) {
        this.softwarePrice = softwarePrice;
    }

    public double calculateTotal(double softwarePrice, double officeSuppliesPrice) {
        return this.total = softwarePrice + officeSuppliesPrice;
    }

}
