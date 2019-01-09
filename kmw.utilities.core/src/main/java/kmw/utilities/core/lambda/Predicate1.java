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

import javax.annotation.CheckReturnValue;

/**
 *
 * @author Christian P. Lerch
 * @param <T1>
 */
@FunctionalInterface
public interface Predicate1<T1> {
  
  /**
   * Returns the result of applying this predicate to {@code arg1}. This method is <i>generally
   * expected</i>, but not absolutely required, to have the following properties:
   *
   * <ul>
   * <li>Its execution does not cause any observable side effects.
   * <li>The computation is <i>consistent with equals</i>; that is, {@link Objects#equal
   *     Objects.equal}{@code (a, b)} implies that {@code predicate.apply(a) ==
   *     predicate.apply(b))}.
   * </ul>
   *
   * @param arg1
   * @return 
   * @throws NullPointerException if {@code arg1} is null and this predicate does not accept null
   *     arguments
   */
  @CheckReturnValue
  boolean test(T1 arg1);

}
