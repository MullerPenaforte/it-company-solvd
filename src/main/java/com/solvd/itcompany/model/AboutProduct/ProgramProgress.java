package com.solvd.itcompany.model.AboutProduct;

import com.solvd.itcompany.model.People.Client;
import com.solvd.itcompany.exceptions.InvalidProgressException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class ProgramProgress {

    private static final Logger logger = LogManager.getLogger(ProgramProgress.class);

    public static void validateProgress(double percentage) throws InvalidProgressException {
        if (percentage < 0 || percentage > 100) {
            throw new InvalidProgressException("Invalid percentage: " + percentage + "%. Must be between 0 and 100.");
        }
    }

    public static void showProgress(Client client, Product progress) {
        logger.info("Hello dear client {}, your app is {} % done already!", client.getName(), progress.getProgress());
    }
}
