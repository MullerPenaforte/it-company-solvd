package com.solvd.itcompany.model.Service;

import com.solvd.itcompany.enums.Department;
import com.solvd.itcompany.enums.ProjectPriority;
import com.solvd.itcompany.interfaces.AccessValidator;
import com.solvd.itcompany.model.People.Employee;
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
            case FINANCE:
                logger.warn("Access restricted: Financial vault only.");
                break;
            default:
                logger.info("Access granted: General office area.");
        }
    }

    public static void processTicket(ProjectPriority priority) {
        if (priority == null) {
            logger.error("Priority cannot be null!");
            return;
        }

        logger.info("Processing ticket with priority: " + priority);

        if (priority == ProjectPriority.URGENT) {
            logger.warn("ALERT: This is an urgent matter! Immediate action required.");
        } else {
            logger.info("Timeframe to resolve: " + priority.getDaysToResolve() + " day(s).");
        }
    }

    public static void grantApproval(Employee emp, String level, AccessValidator validator) {
        if (validator.validate(emp, level)) {
            logger.info("Access GRANTED for: " + emp.getName());
        } else {
            logger.warn("Access DENIED for: " + emp.getName() + ". Required: " + level);
        }
    }
}