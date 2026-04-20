package com.solvd.itcompany.model.Service;

import com.solvd.itcompany.interfaces.AuditOperation;
import com.solvd.itcompany.interfaces.SensitiveData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionInspector {
    private static final Logger LOGGER = LogManager.getLogger(ReflectionInspector.class);

    public static void analyzeObject(Object obj) {
        Class<?> clazz = obj.getClass();
        LOGGER.info("Starting reflective analysis of: {}", clazz.getSimpleName());

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);

                if (field.isAnnotationPresent(SensitiveData.class)) {
                    SensitiveData ann = field.getAnnotation(SensitiveData.class);
                    LOGGER.info("[FIELD] {} : {} (Mask Applied)", field.getName(), ann.mask());
                } else {
                    LOGGER.info("[FIELD] {} : {}", field.getName(), field.get(obj));
                }
            } catch (IllegalAccessException e) {
                LOGGER.error("Could not access field: {}", field.getName());
            }
        }

        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(AuditOperation.class)) {
                LOGGER.warn("[METHOD ALERT] Method '{}' requires auditing!", method.getName());
            }
        }
    }
}