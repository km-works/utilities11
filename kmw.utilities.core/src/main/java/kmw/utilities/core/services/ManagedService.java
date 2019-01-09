package kmw.utilities.core.services;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ManagedService {

    String serviceName() default "";
    boolean isDefaultService() default false;

}
