package com.solvd.itcompany.model.Financial;

import com.solvd.itcompany.model.Pricing.ProgramPricing;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BalanceSheet implements FinancialReport {

    private static final Logger logger = LogManager.getLogger(BalanceSheet.class);
    private double totalSavings = 50000;
    private double expenses;
    private double revenue;

    public BalanceSheet(double totalSavings, double expenses, double revenue) {
        this.totalSavings = totalSavings;
        this.expenses = expenses;
        this.revenue = revenue;
    }

    public BalanceSheet() {
    }

    public BalanceSheet(double totalSavings) {
        this.totalSavings = totalSavings;
    }

    public double getTotalSavings() {
        return totalSavings;
    }

    public void setTotalSavings(double totalSavings) {
        this.totalSavings = totalSavings;
    }

    public double getExpenses() {
        return expenses;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public static void updateBalance(ProgramPricing price, OperatingExpenses total, double totalSavings) {
        totalSavings = (totalSavings + price.getPrice()) - total.getTotal();
        logger.info("The company total savings now is: {}", totalSavings);
    }

    @Override
    public String toString() {
        return "Total savings: " + totalSavings + ".";
    }

    @Override
    public double calculateProfit() {
        return this.revenue - this.expenses;
    }

    @Override
    public void generateSummary() {
        logger.info("--- Financial Summary ---");
        logger.info("Savings: {}", totalSavings);
        logger.info("Profit: {}", calculateProfit());
    }
}