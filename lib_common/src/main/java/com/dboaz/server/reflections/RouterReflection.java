package com.dboaz.server.reflections;

import com.dboaz.server.models.*;
import com.dboaz.server.notations.*;
import com.dboaz.server.notations.Route;
import com.dboaz.utils.enums.SeverityEnum;
import com.dboaz.utils.errors.GenericException;
import com.dboaz.utils.validations.RouterValidationUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
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
        routers.put(clazz, router);
        processMethods(clazz.getDeclaredMethods(), router);
    }

    public Response invokeMethod(Request request, Response response) {
        Map.Entry<Class<?>, RouterDetail> entrySet = getEntrySet(request.path);
        Class<?> router = entrySet.getKey();
        var routerDetail = entrySet.getValue();
        var routeDetail = routerDetail.searchRouteByVerbMethodAndFullPath(request.method, request.path);
        String mainMethodName = routeDetail.getName();

        // parametros do metodo
        if (!routeDetail.getParametes().isEmpty()) {
            Class[] argTypes = new Class[routeDetail.getParametes().size()];
            Object[] mainArgs = new Object[routeDetail.getParametes().size()];
            for (int i = 0; i < routeDetail.getParametes().size(); i++) {
                ParamDetail param = routeDetail.getParametes().get(i);
                argTypes[i] = param.getType();

               if (param.getNotationType() == ParamQuery.class) {
                mainArgs[i] = request.params.get(param.getName());
               } else if (param.getNotationType() == ParamHeader.class) {
                mainArgs[i] = request.headers.get(param.getName());
               } else if (param.getNotationType() == ParamBody.class) {
                mainArgs[i] = request.body;
               }
            }

            // invocar metodo com parametros
            try {
                var inst = router.getDeclaredConstructor().newInstance();
                var main = router.getDeclaredMethod(mainMethodName, argTypes);
                var resp = (ResponseRoute) main.invoke(inst, mainArgs);

                return response.builder()
                    .status(resp.getStatus())
                    .contentType(resp.getContentType())
                    .headers(resp.getHeaders())
                    .body(resp.getBody())
                    .build();
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException | IllegalArgumentException | SecurityException e) {
                throw new RuntimeException(e);
            }
        } else {
            // invocar metodosem parametros
            try {
                var inst = router.getDeclaredConstructor().newInstance();
                var main = router.getDeclaredMethod(mainMethodName);
                var resp = (ResponseRoute) main.invoke(inst);
                return response.builder()
                    .status(resp.getStatus())
                    .contentType(resp.getContentType())
                    .headers(resp.getHeaders())
                    .body(resp.getBody())
                    .build();
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException | IllegalArgumentException | SecurityException e) {
                throw new RuntimeException(e);
            }
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
                String verbMethod = method.getAnnotation(Route.class).method();
                String childPath = method.getAnnotation(Route.class).childPath();
                
                RouterValidationUtils.checkDuplicatedChildPath(verbMethod, childPath, router);
                
                var route = new RouteDetail(
                    method.getName(),
                    verbMethod,
                    childPath,
                    router.getBasePath().concat(childPath)
                );
                router.addRoute(route);
                processParameters(method.getParameters(), route);
            }
        }
    }

    protected void processParameters(Parameter[] parameters, RouteDetail route) {
        for (Parameter parameter : parameters) {
            if (parameter.isAnnotationPresent(ParamPath.class)) {
                route.addParameter(
                    new ParamDetail(
                        ParamPath.class,
                        parameter.getType(),
                        parameter.getName(),
                        parameter.getAnnotation(ParamPath.class).name(),
                        parameter.getAnnotation(ParamPath.class).required()
                    )
                );
            } else if (parameter.isAnnotationPresent(ParamQuery.class)) {
                route.addParameter(
                    new ParamDetail(
                        ParamQuery.class,
                        parameter.getType(),
                        parameter.getName(),
                        parameter.getAnnotation(ParamQuery.class).name(),
                        parameter.getAnnotation(ParamQuery.class).required()
                    )
                );
            } else if (parameter.isAnnotationPresent(ParamHeader.class)) {
                route.addParameter(
                    new ParamDetail(
                        ParamHeader.class,
                        parameter.getType(),
                        parameter.getName(),
                        parameter.getAnnotation(ParamHeader.class).name(),
                        parameter.getAnnotation(ParamHeader.class).required()
                    )
                );
            } else if (parameter.isAnnotationPresent(ParamBody.class)) {
                route.addParameter(
                    new ParamDetail(
                        ParamBody.class,
                        parameter.getType(),
                        parameter.getName(),
                        parameter.getAnnotation(ParamBody.class).required()
                    )
                );
            }
        }
    }
}
