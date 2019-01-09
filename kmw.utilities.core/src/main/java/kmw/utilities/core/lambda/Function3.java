package kmw.utilities.core.lambda;

import javax.annotation.Nullable;

@FunctionalInterface
public interface Function3<T1, T2, T3, R> {

    @Nullable
    R apply(@Nullable T1 arg1, @Nullable T2 arg2, @Nullable T3 arg3);

}