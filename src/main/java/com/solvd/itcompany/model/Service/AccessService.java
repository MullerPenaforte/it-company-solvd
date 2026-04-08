package com.solvd.itcompany.model.Service;

import com.solvd.itcompany.enums.Department;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AccessService {
    private static final Logger logger = LogManager.getLogger(AccessService.class);

    public static void checkDepartmentAccess(Department dept) {
        if (dept == null) {
            logger.error("Cannot check access: Department is null!");
            return;
        }

        switch (dept) {
            case IT:
                logger.info("Access granted: Entering server room.");
                break;
        }
        switch (dept) {
            case IT:
                logger.info("Access granted: Entering server room.");
                break;
            case FINANCE:
                logger.warn("Access restricted: Financial vault only.");
                break;
            default:
                logger.info("Access granted: General office area.");
        }
    }
}