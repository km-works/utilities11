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
import kmworks.util.iter.IterUtil;

/**
 *
 * @author Christian P. Lerch
 */
public final class LambdaUtil {

    /**
     * Produce the conjunction ({@code &&}) of {@code p1} and {@code p2}.
     */
    public static <T> Predicate1<T> and(Predicate1<? super T> p1, Predicate1<? super T> p2) {
        return new AndPredicate<>(IterUtil.<Predicate1<? super T>>make(p1, p2));
    }

    /**
     * Produce the conjunction ({@code &&}) of the given predicates.
     *
    public static <T> Predicate1<T> and(Iterable<? extends Predicate1<? super T>> preds) {
        return new AndPredicate<>(preds);
    }
    */
    
    private static final class AndPredicate<T> implements Predicate1<T>, Serializable {

        private static final long serialVersionUID = 1L;
        private final Iterable<? extends Predicate1<? super T>> conjuncts;

        public AndPredicate(Iterable<? extends Predicate1<? super T>> predicates) {
            this.conjuncts = predicates;
        }

        @Override
        public boolean test(T arg) {
            for (Predicate1<? super T> p : conjuncts) {
                if (!p.test(arg)) {
                    return false;
                }
            }
            return true;
        }
    }

    public static <T1,T2> Predicate2<T1,T2> and(Predicate2<? super T1, ? super T2> p1, Predicate2<? super T1, ? super T2> p2) {
        return new AndPredicate2<>(IterUtil.<Predicate2<? super T1, ? super T2>>make(p1, p2));
    }

    /**
     * Produce the conjunction ({@code &&}) of the given predicates.
     *
    public static <T1,T2> Predicate2<T1,T2> and(Iterable<? extends Predicate2<? super T1, ? super T2>> preds) {
        return new AndPredicate2<>(preds);
    }
    */
    
    private static final class AndPredicate2<T1,T2> implements Predicate2<T1,T2>, Serializable {

        private static final long serialVersionUID = 1L;
        private final Iterable<? extends Predicate2<? super T1, ? super T2>> conjuncts;

        public AndPredicate2(Iterable<? extends Predicate2<? super T1, ? super T2>> predicates) {
            this.conjuncts = predicates;
        }

        @Override
        public boolean test(T1 arg1, T2 arg2) {
            for (Predicate2<? super T1, ? super T2> p : conjuncts) {
                if (!p.test(arg1, arg2)) {
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * Produce the disjunction ({@code ||}) of {@code p1} and {@code p2}.
     */
    public static <T> Predicate1<T> or(Predicate1<? super T> p1, Predicate1<? super T> p2) {
        return new OrPredicate<>(IterUtil.<Predicate1<? super T>>make(p1, p2));
    }

    /**
     * Produce the disjunction ({@code ||}) of the given predicates.
     */
    public static <T> Predicate1<T> or(Iterable<? extends Predicate1<? super T>> preds) {
        return new OrPredicate<>(preds);
    }

    private static final class OrPredicate<T> implements Predicate1<T>, Serializable {

        private static final long serialVersionUID = 1L;
        private final Iterable<? extends Predicate1<? super T>> disjuncts;

        public OrPredicate(Iterable<? extends Predicate1<? super T>> predicates) {
            disjuncts = predicates;
        }

        @Override
        public boolean test(T arg) {
            for (Predicate1<? super T> p : disjuncts) {
                if (p.test(arg)) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * Produce the negation ({@code !}) of {@code pred}.
     */
    public static <T> Predicate1<T> negate(Predicate1<? super T> pred) {
        return new NegationPredicate<>(pred);
    }

    private static final class NegationPredicate<T> implements Predicate1<T>, Serializable {

        private static final long serialVersionUID = 1L;
        private final Predicate1<? super T> _p;

        public NegationPredicate(Predicate1<? super T> p) {
            _p = p;
        }

        @Override
        public boolean test(T arg) {
            return !_p.test(arg);
        }
    }

    public static <T1,T2> Predicate2<T1,T2> negate(Predicate2<? super T1, ? super T2> pred) {
        return new NegationPredicate2<>(pred);
    }

    private static final class NegationPredicate2<T1,T2> implements Predicate2<T1,T2>, Serializable {

        private static final long serialVersionUID = 1L;
        private final Predicate2<? super T1, ? super T2> _p;

        public NegationPredicate2(Predicate2<? super T1, ? super T2> p) {
            _p = p;
        }

        @Override
        public boolean test(T1 arg1, T2 arg2) {
            return !_p.test(arg1, arg2);
        }
    }

    /**
     * Produce the negation ({@code !}) of {@code pred}.
     */
    public static <T> Predicate1<T> andNot(Predicate1<? super T> p1, Predicate1<? super T> p2) {
        return new AndNotPredicate<>(p1, p2);
    }

    private static final class AndNotPredicate<T> implements Predicate1<T>, Serializable {

        private static final long serialVersionUID = 1L;
        private final Predicate1<? super T> _p1;
        private final Predicate1<? super T> _p2;

        public AndNotPredicate(Predicate1<? super T> p1, Predicate1<? super T> p2) {
            _p1 = p1;
            _p2 = p2;
        }

        @Override
        public boolean test(T arg) {
            return and(_p1, negate(_p2)).test(arg);
        }
    }

}
