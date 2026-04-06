package com.solvd.itcompany.model.SalesTeam;

import com.solvd.itcompany.model.People.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Sales implements ISell {

    private static final Logger logger = LogManager.getLogger(Sales.class);
    protected Client.Employee seller;
    protected Client client;

    @Override
    public void marketing() {
        logger.info("We are now reaching for new clients!");
    }

    @Override
    public void meetingWithClient() {
        logger.info("We have a new client!");
    }

    @Override
    public String toString() {
        return "Client name: " + client + ". Employee name: " + seller + ".";
    }
}