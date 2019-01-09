package kmw.utilities.core.services;

import java.util.NoSuchElementException;
import java.util.ServiceLoader;

public final class ServicesManager {

    private ServicesManager() {}

    public static <T> T getFirstOrFail(Class<T> serviceClass) {
        return ServiceLoader.load(serviceClass).findFirst().orElseThrow();
    }

    public static <T> T getSingleOrFail(Class<T> serviceClass) {
        if (ServiceLoader.load(serviceClass).stream().count() != 1) {
            throw new NoSuchElementException();
        }
        return getFirstOrFail(serviceClass);
    }

    public static <T> T getDefaultOrFail(Class<T> serviceClass) {
        for (T service : ServiceLoader.load(serviceClass)) {
            if (service.getClass().isAnnotationPresent(ManagedService.class)) {
                if (service.getClass().getAnnotation(ManagedService.class).isDefaultService()) {
                    return service;
                }
            }
        }
        throw new NoSuchElementException();
    }

    public static <T> T getNamedOrFail(Class<T> serviceClass, String serviceName) {
        for (T service : ServiceLoader.load(serviceClass)) {
            if (service.getClass().isAnnotationPresent(ManagedService.class)) {
                if (serviceName.equals(service.getClass().getAnnotation(ManagedService.class).serviceName())) {
                    return service;
                }
            }
        }
        throw new NoSuchElementException();
    }

}
