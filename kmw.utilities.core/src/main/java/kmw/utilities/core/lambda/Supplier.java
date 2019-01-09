/*
 * Copyright (C) 2005-2018 Christian P. Lerch <christian.p.lerch[at]gmail.com>
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


/**
 * A supplier of some results.
 *
 * <p>A class that can supply objects of a single type. This could
 * be a factory, generator, builder, closure, or something else. No
 * guarantees are implied by this interface.
 *
 * <p>There is no requirement that a new or distinct result be returned each
 * time the supplier is invoked.
 *
 * @param <T> the type of results supplied by this supplier
 *
 * @author Christian P. Lerch
 */
@FunctionalInterface
public interface Supplier<T> {

    /**
     * Retrieves an instance of the appropriate type. The returned object may or
     * may not be a new instance, depending on the implementation.
     *
     * @return an instance of the appropriate type
     */
    T get();
}