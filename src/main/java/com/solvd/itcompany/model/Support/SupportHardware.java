package com.solvd.itcompany.model.Support;

import com.solvd.itcompany.model.People.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SupportHardware extends ClientSupport {

    private static final Logger logger = LogManager.getLogger(SupportHardware.class);

    @Override
    public void helpClient(Client client) {
        logger.info("Hello {}. We are now helping you with your Hardware problems.", client.getName());
    }
}