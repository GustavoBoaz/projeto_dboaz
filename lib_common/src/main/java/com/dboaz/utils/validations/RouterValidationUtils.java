package com.dboaz.utils.validations;

import com.dboaz.server.models.RouterDetail;
import com.dboaz.server.notations.Router;
import com.dboaz.utils.enums.SeverityEnum;
import com.dboaz.utils.errors.GenericException;

import java.util.Map;

public class RouterValidationUtils {
    public static void hasMinRequired(String basePath, Class<?> clazz, Map<Class<?>, RouterDetail> routers) {
        if (!clazz.isAnnotationPresent(Router.class)) {
            throw new GenericException("Error [ RouterReflection ]: @Router is missing in ".concat(clazz.getSimpleName()), SeverityEnum.SEV_001, 500);
        } else if (routers.containsKey(clazz)) {
            throw new GenericException("Error [ RouterReflection ]: Router already exists with the name ".concat(clazz.getSimpleName()), SeverityEnum.SEV_001, 500);
        } else {
            ifValidFormatBasePath(clazz.getAnnotation(Router.class).basePath(), clazz);
            ifExistBasePath(clazz.getAnnotation(Router.class).basePath(), clazz, routers);
        }
    }

    public static void ifValidFormatBasePath(String basePath, Class<?> clazz) {
        if (!basePath.startsWith("/")) {
            throw new GenericException("Error [ RouterReflection ]: Base path must start with / in class {}".concat(clazz.getSimpleName()), SeverityEnum.SEV_001, 500);
        } else if (basePath.endsWith("/")) {
            throw new GenericException("Error [ RouterReflection ]: Base path must not end with / in class {}".concat(clazz.getSimpleName()), SeverityEnum.SEV_001, 500);
        } else if (basePath.contains("//")) {
            throw new GenericException("Error [ RouterReflection ]: Base path must not contain // in class {}".concat(clazz.getSimpleName()), SeverityEnum.SEV_001, 500);
        } else if (basePath.contains("/.")) {
            throw new GenericException("Error [ RouterReflection ]: Base path must not contain /. in class {}".concat(clazz.getSimpleName()), SeverityEnum.SEV_001, 500);
        } else if (basePath.contains("./")) {
            throw new GenericException("Error [ RouterReflection ]: Base path must not contain ./ in class {}".concat(clazz.getSimpleName()), SeverityEnum.SEV_001, 500);
        } else if (basePath.equals("/")) {
            throw new GenericException("Error [ RouterReflection ]: Base path should not only / in class {}".concat(clazz.getSimpleName()), SeverityEnum.SEV_001, 500);
        }
    }

    public static void ifExistBasePath(String basePath, Class<?> clazz, Map<Class<?>, RouterDetail> routers) {
        for (Map.Entry<Class<?>, RouterDetail> entry : routers.entrySet()) {
            if (entry.getValue().getBasePath().equals(basePath)) {
                throw new GenericException("Error [ RouterReflection ]: Base path already exists in class {}".concat(clazz.getSimpleName()), SeverityEnum.SEV_001, 500);
            }
        }
    }

    public static void checkDuplicatedChildPath(String verbMethod, String childPath, RouterDetail router) {
        router.getRoutes().forEach(route -> {
            if (isEqualsChildPath(route.getChildPath(), childPath) && route.getVerbMethod().equals(verbMethod)) {
                throw new GenericException("Error [ RouterReflection ]: Child path {} and method is duplicated".concat(childPath), SeverityEnum.SEV_001, 500);
            }
        });
    }

    public static Boolean isEqualsChildPath(String childPath1, String childPaht2) {
        String path1 = removeBrackets(childPath1);
        String path2 = removeBrackets(childPaht2);
        if (path1 == path2) {
            return true;
        }
        return false;
    }

    public static String removeBrackets(String path) {
        return path.replaceAll("\\{[^}]*\\}", "");
    }
}
