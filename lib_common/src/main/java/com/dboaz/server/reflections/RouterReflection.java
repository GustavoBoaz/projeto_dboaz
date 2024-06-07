package com.dboaz.server.reflections;

import com.dboaz.server.models.*;
import com.dboaz.server.notations.*;
import com.dboaz.server.notations.Route;
import com.dboaz.utils.enums.SeverityEnum;
import com.dboaz.utils.errors.GenericException;
import com.dboaz.utils.validations.RouterValidationUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

public class RouterReflection {
    private static final Logger LOGGER = LogManager.getLogger(RouterReflection.class);

    protected final Class<?> clazz;
    protected final Map<Class<?>, RouterDetail> routers;

    public RouterReflection() {
        this.clazz = null;
        this.routers = new HashMap<>();
    }

    public void registerRouter(Class<?> clazz) {
        RouterValidationUtils.hasMinRequired(clazz.getAnnotation(Router.class).basePath(), clazz, routers);

        LOGGER.info("[ RouterReflection | Register router: {} ]", clazz.getSimpleName());
        var router = new RouterDetail(clazz.getAnnotation(Router.class).basePath());
        processMethods(clazz.getDeclaredMethods(), router);
        routers.put(clazz, router);
    }

    public Response invokeMethod(Request request, Response response) {
        Map.Entry<Class<?>, RouterDetail> entrySet = getEntrySet(request.path);
        Class<?> router = entrySet.getKey();
        RouterDetail routerDetail = entrySet.getValue();

        Class[] argTypes = new Class[] { Object[].class };
        String[] mainArgs;
        String mainMethodName;

        routerDetail.getRoutes().forEach(route -> {

            // exemplo de request.path -> /api/users/43521 ou /api/users/43521/product
            // exemplo de route.fullPath -> /api/users/{id} ou /api/users/{id}/product

            // para descobrir qual o método é necessario saber seus parametros (mainArgs)
            // buscar método pelo seu fullPath

            // encontrar os pametros
            // buscar parametros @ParamPath pelo request.param
            // buscar parametros @ParamQuery pelo request.query
            // buscar parametros @ParamHeader pelo request.header
            // buscar parametros @ParamBody pelo request.body
        });

        // invocar metodo
        try {
            Method main = router.getDeclaredMethod(mainMethodName, argTypes);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

    }

    protected Map.Entry<Class<?>, RouterDetail> getEntrySet(String path) {
        for (Map.Entry<Class<?>, RouterDetail> entry : routers.entrySet()) {
            if (path.startsWith(entry.getValue().getBasePath())) {
                return entry;
            }
        }
        throw new GenericException("Error [ RouterReflection ]: Router not found".concat(clazz.getSimpleName()), SeverityEnum.SEV_004, 404);
    }

    protected void processMethods(Method[] methods, RouterDetail router) {
        for (Method method : methods) {
            if (method.isAnnotationPresent(Route.class)) {
                var route = new RouteDetail(
                    method.getName(),
                    method.getAnnotation(Route.class).method(),
                    method.getAnnotation(Route.class).childPath(),
                    router.getBasePath().concat(method.getAnnotation(Route.class).childPath())
                );
                processParameters(method.getParameters(), route);
                router.addRoute(route);
            }
        }
    }

    protected void processParameters(Parameter[] parameters, RouteDetail route) {
        for (Parameter parameter : parameters) {
            if (parameter.isAnnotationPresent(ParamPath.class)) {
                route.addParameter(
                        new ParamDetail(
                                parameter.getType(),
                                parameter.getName(),
                                parameter.getAnnotation(ParamPath.class).name(),
                                parameter.getAnnotation(ParamPath.class).required()
                        )
                );
            } else if (parameter.isAnnotationPresent(ParamQuery.class)) {
                route.addParameter(
                        new ParamDetail(
                                parameter.getType(),
                                parameter.getName(),
                                parameter.getAnnotation(ParamQuery.class).name(),
                                parameter.getAnnotation(ParamQuery.class).required()
                        )
                );
            } else if (parameter.isAnnotationPresent(ParamHeader.class)) {
                route.addParameter(
                        new ParamDetail(
                                parameter.getType(),
                                parameter.getName(),
                                parameter.getAnnotation(ParamHeader.class).name(),
                                parameter.getAnnotation(ParamHeader.class).required()
                        )
                );
            } else if (parameter.isAnnotationPresent(ParamBody.class)) {
                route.addParameter(
                        new ParamDetail(
                                parameter.getType(),
                                parameter.getName(),
                                parameter.getAnnotation(ParamBody.class).required()
                        )
                );
            }
        }
    }
}
