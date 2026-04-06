package com.solvd.itcompany.model.Support;

import com.solvd.itcompany.model.People.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class ClientSupport implements ISupport {

    private static final Logger logger = LogManager.getLogger(ClientSupport.class);

    @Override
    public void helpClient(Client client) {
        logger.info("Hello {}. How can we help you today? Is it Hardware or Software related?", client.getName());
    }
}