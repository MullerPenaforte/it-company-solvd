package com.solvd.itcompany.model.SalesTeam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SalesSoftware extends Sales {

    private static final Logger logger = LogManager.getLogger(SalesSoftware.class);

    @Override
    public void marketing() {
        logger.info("Software team is now reaching for new clients!");
    }

    @Override
    public void meetingWithClient() {
        logger.info("Software team just got a new client!");
    }
}