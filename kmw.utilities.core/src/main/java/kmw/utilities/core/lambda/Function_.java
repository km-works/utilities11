/*
 * Copyright (C) 2005-2016 Christian P. Lerch <christian.p.lerch[at]gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package kmw.utilities.core.lambda;

import java.io.Serializable;
import javax.annotation.Nullable;

import kmw.utilities.core.base.ObjectServiceUtil;

/**
 * @author Christian P. Lerch
 */
public final class Function_ {

    private Function_() {
    }

    /**
     * Creates a function that returns a constant {@code value}.
     *
     * @param value the constant value for the function to return
     * @return a function that always returns the given {@code value}
     */
    public static <E> Function0<E> constant(@Nullable E value) {
        return new ConstantFunction<>(value);
    }

    private static class ConstantFunction<E> implements Function0<E>, Serializable {

        private static final long serialVersionUID = 1L;

        private final E value;

        public ConstantFunction(@Nullable E value) {
            this.value = value;
        }

        @Override
        public E apply() {
            return value;
        }

        @Override
        public boolean equals(@Nullable Object obj) {
            if (obj instanceof ConstantFunction) {
                ConstantFunction<?> that = (ConstantFunction<?>) obj;
                return ObjectServiceUtil.equals(value, that.value);
            }
            return false;
        }

        @Override
        public int hashCode() {
            return ObjectServiceUtil.hashCode(value);
        }

        @Override
        public String toString() {
            return "constant(" + value + ")";
        }

    }

    /**
     * Returns a function that always returns the result of invoking {@link Supplier#get} on {@code
     * supplier}.
     */
    public static <T> Function0<T> forSupplier(Supplier<T> supplier) {
        return new SupplierFunction<>(supplier);
    }

    private static class SupplierFunction<T> implements Function0<T>, Serializable {

        private final Supplier<T> supplier;

        private SupplierFunction(Supplier<T> supplier) {
            this.supplier = ObjectServiceUtil.requireNonNull(supplier);
        }

        @Override
        public T apply() {
            return supplier.get();
        }

        @Override
        public boolean equals(@Nullable Object obj) {
            if (obj instanceof SupplierFunction) {
                SupplierFunction<?> that = (SupplierFunction<?>) obj;
                return this.supplier.equals(that.supplier);
            }
            return false;
        }

        @Override
        public int hashCode() {
            return supplier.hashCode();
        }

        @Override
        public String toString() {
            return "forSupplier(" + supplier + ")";
        }

        private static final long serialVersionUID = 0;
    }
}
