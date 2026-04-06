package com.solvd.itcompany.model.Payment;

import com.solvd.itcompany.model.Financial.BankAccount;
import com.solvd.itcompany.model.Pricing.ProgramPricing;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class PaymentMethod {

    private static final Logger logger = LogManager.getLogger(PaymentMethod.class);

    public static void credit(BankAccount balance, ProgramPricing price, int installments) {
        double result = price.getPrice() * (installments * 1.05);
        logger.info("You choose to use the payment method by Credit Card, the total of your service is: {}", result);
    }

    public static void debit(BankAccount balance, ProgramPricing price) {
        if (balance.getBalance() >= price.getPrice()) {
            logger.info("Payment done successfully!");
        } else {
            logger.warn("You don't have enough balance in your account to complete this transaction. Please try again or switch your payment method.");
        }
    }
}