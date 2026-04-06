package com.solvd.itcompany.model.SalesTeam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SalesHardware extends Sales {

    private static final Logger logger = LogManager.getLogger(SalesHardware.class);

    @Override
    public void marketing() {
        logger.info("Hardware team is now reaching for new clients!");
    }

    @Override
    public void meetingWithClient() {
        logger.info("Hardware team just got a new client!");
    }
}