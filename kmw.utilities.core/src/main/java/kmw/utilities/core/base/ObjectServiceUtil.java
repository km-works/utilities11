package kmw.utilities.core.base;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public final class ObjectServiceUtil {

    private ObjectServiceUtil() {
    }

    /**
     * Returns {@code true} if the arguments are equal to each other and {@code false} otherwise. Consequently, if both arguments
     * are {@code null}, {@code true} is returned and if exactly one argument is {@code null}, {@code
     * false} is returned. Otherwise, equality is determined by using the {@link Object#equals equals} method of the first
     * argument.
     *
     * @param a an object
     * @param b an object to be compared with {@code a} for equality
     * @return {@code true} if the arguments are equal to each other and {@code false} otherwise
     * @see Object#equals(Object)
     * @since JDK7
     */
    @CheckReturnValue
    public static boolean equals(@Nullable Object a, @Nullable Object b) {
        return Objects.equals(a, b);
    }

    /**
     * Returns {@code true} if the arguments are deeply equal to each other and {@code false} otherwise.
     * <p>
     * Two {@code null} values are deeply equal. If both arguments are arrays, the algorithm in {@link Arrays#deepEquals(Object[],
     * Object[]) Arrays.deepEquals} is used to determine equality. Otherwise, equality is determined by using the {@link
     * Object#equals equals} method of the first argument.
     *
     * @param a an object
     * @param b an object to be compared with {@code a} for deep equality
     * @return {@code true} if the arguments are deeply equal to each other and {@code false} otherwise
     * @see Arrays#deepEquals(Object[], Object[])
     * @see Objects#equals(Object, Object)
     * @since JDK7
     */
    @CheckReturnValue
    public static boolean deepEquals(@Nullable Object a, @Nullable Object b) {
        return Objects.deepEquals(a, b);
    }

    /**
     * Returns the hash code of a non-{@code null} argument and 0 for a {@code null} argument.
     *
     * @param o an object
     * @return the hash code of a non-{@code null} argument and 0 for a {@code null} argument
     * @see Object#hashCode
     * @since JDK7
     */
    @CheckReturnValue
    public static int hashCode(@Nullable Object o) {
        return Objects.hashCode(o);
    }

    /**
     * Generates a hash code for a sequence of input values. The hash code is generated as if all the input values were placed
     * into an array, and that array were hashed by calling {@link Arrays#deepHashCode(Object[])}.
     * <p>
     * Please note, that if the array contains other arrays as elements, the
     * hash code is based on their contents in a recursive manner.
     * It is therefore unacceptable to invoke this method on an array that
     * contains itself as an element, either directly or indirectly through
     * one or more levels of other arrays. The behavior of such an invocation is undefined.
     * <p>
     * This method is useful for implementing {@link
     * Object#hashCode()} on objects containing multiple fields. For example, if an object that has three fields,
     * {@code x}, {@code y}, and {@code z}, one could write:
     *
     * <blockquote><pre>
     * &#064;Override public int hashCode() {
     *     return Objects.deepHash(x, y, z);
     * }
     * </pre></blockquote>
     * <p>
     * When just a single object reference is supplied, the returned value will equal the hash code of that single object
     * reference as computed by calling {@link #hashCode(Object)}.
     * <p>
     * Calling this method with no arguments (i.e. {@code hash()}) will return a value of {@code 1}.
     *
     * @param values the values to be hashed
     * @return a deep hash value of the sequence of input values
     * @see Arrays#deepHashCode(Object[])
     * @since 2.0
     */
    @CheckReturnValue
    public static int deepHash(@Nullable Object... values) {
        if (values == null) {
            return 0;                       // null hash
        }
        switch (values.length) {
            case 0:
                return 1;                     // empty hash
            case 1:
                return hashCode(values[0]);   // single object hash
            default:
                return Arrays.deepHashCode(values);
        }
    }

    /**
     * Returns the result of calling {@code toString} for a non-{@code
     * null} argument and {@code "null"} for a {@code null} argument.
     * <p> Warning: {@code toString(this)} will subsequently call {@code this.toString()}.
     * Hence you cannot use this method for implementing the {@code toString()} method for any object.
     *
     * @param o an object
     * @return the result of calling {@code toString} for a non-{@code
     * null} argument and {@code "null"} for a {@code null} argument
     * @see Object#toString
     * @see String#valueOf(Object)
     * @since JDK7
     */
    @CheckReturnValue
    public static String toString(@Nullable Object o) {
        return Objects.toString(o);
    }

    /**
     * Returns the result of calling {@code toString} on the first argument if the first argument is not {@code null} and returns
     * the second argument otherwise.
     *
     * @param o           an object
     * @param nullDefault string to return if the first argument is {@code null}
     * @return the result of calling {@code toString} on the first argument if it is not {@code null} and the second argument
     * otherwise.
     * @see Objects#toString(Object)
     * @since JDK7
     */
    @CheckReturnValue
    public static String toString(@Nullable Object o, @Nonnull String nullDefault) {
        return Objects.toString(o, nullDefault);
    }

    /**
     * Returns 0 if the arguments are identical and {@code
     * c.compare(a, b)} otherwise. Consequently, if both arguments are {@code null} 0 is returned.
     * <p>
     * <p>
     * Note that if one of the arguments is {@code null}, a {@code
     * NullPointerException} may or may not be thrown depending on what ordering policy, if any, the {@link Comparator Comparator}
     * chooses to have for {@code null} values.
     *
     * @param <T> the type of the objects being compared
     * @param a   an object
     * @param b   an object to be compared with {@code a}
     * @param c   the {@code Comparator} to compare the first two arguments
     * @return 0 if the arguments are identical and {@code
     * c.compare(a, b)} otherwise.
     * @see Comparable
     * @see Comparator
     * @since JDK7
     */
    @CheckReturnValue
    public static <T> int compare(@Nullable T a, @Nullable T b, @Nonnull Comparator<? super T> c) {
        return Objects.compare(a, b, c);
    }

    /**
     * Checks that the specified object reference is not {@code null}. This method is designed primarily for doing parameter
     * validation in methods and constructors, as demonstrated below:
     * <blockquote><pre>
     * public Foo(Bar bar) {
     *     this.bar = Objects.requireNonNull(bar);
     * }
     * </pre></blockquote>
     *
     * @param obj the object reference to check for nullity
     * @param <T> the type of the reference
     * @return {@code obj} if not {@code null}
     * @throws NullPointerException if {@code obj} is {@code null}
     * @since JDK7
     */
    public static <T> T requireNonNull(@Nonnull T obj) {
        return Objects.requireNonNull(obj);
    }

    /**
     * Checks that the specified object reference is not {@code null} and throws a customized {@link NullPointerException} if it
     * is. This method is designed primarily for doing parameter validation in methods and constructors with multiple parameters,
     * as demonstrated below:
     * <blockquote><pre>
     * public Foo(Bar bar, Baz baz) {
     *     this.bar = Objects.requireNonNull(bar, "bar must not be null");
     *     this.baz = Objects.requireNonNull(baz, "baz must not be null");
     * }
     * </pre></blockquote>
     *
     * @param obj     the object reference to check for nullity
     * @param message detail message to be used in the event that a {@code
     *                NullPointerException} is thrown
     * @param <T>     the type of the reference
     * @return {@code obj} if not {@code null}
     * @throws NullPointerException if {@code obj} is {@code null}
     * @since JDK7
     */
    public static <T> T requireNonNull(@Nonnull T obj, @Nonnull String message) {
        return Objects.requireNonNull(obj, message);
    }

    /**
     * Returns {@code true} if the provided reference is {@code null} otherwise returns {@code false}.
     *
     * @param obj a reference to be checked against {@code null}
     * @return {@code true} if the provided reference is {@code null} otherwise {@code false}
     * @apiNote This method exists to be used as a {@link java.util.function.Predicate}, {@code filter(Objects::isNull)}
     * @see java.util.function.Predicate
     * @since 1.8
     */
    @CheckReturnValue
    public static boolean isNull(@Nullable Object obj) {
        return obj == null;
    }

    /**
     * Returns {@code true} if the provided reference is non-{@code null} otherwise returns {@code false}.
     *
     * @param obj a reference to be checked against {@code null}
     * @return {@code true} if the provided reference is non-{@code null} otherwise {@code false}
     * @apiNote This method exists to be used as a {@link java.util.function.Predicate}, {@code filter(Objects::nonNull)}
     * @see java.util.function.Predicate
     * @since 1.8
     */
    @CheckReturnValue
    public static boolean isNotNull(@Nullable Object obj) {
        return !isNull(obj);
    }

    /*
          hash functions from PLT
     */

    /**
     * Prime number used for hashing (approximately 2^32 divided by the golden ratio).
     */
    public static final int KNUTH_CONST = -1640531535; // == 2654435761 (unsigned)

    /**
     * Optimized implementation of {@link #hash(int[])} with 0 args.
     */
    public static int hash() {
        return 1;
    }

    /**
     * Optimized implementation of {@link #hash(int[])} with 1 arg.
     */
    public static int hash(int a) {
        return KNUTH_CONST ^ a;
    }

    /**
     * Optimized implementation of {@link #hash(int[])}) with 2 args.
     */
    public static int hash(int a, int b) {
        return ((KNUTH_CONST ^ a) * KNUTH_CONST) ^ b;
    }

    /**
     * Optimized implementation of {@link #hash(int[])} with 3 args.
     */
    public static int hash(int a, int b, int c) {
        return ((((KNUTH_CONST ^ a) * KNUTH_CONST) ^ b) * KNUTH_CONST) ^ c;
    }

    /**
     * Optimized implementation of {@link #hash(int[])} with 4 args.
     */
    public static int hash(int a, int b, int c, int d) {
        return ((((((KNUTH_CONST ^ a) * KNUTH_CONST) ^ b) * KNUTH_CONST) ^ c) * KNUTH_CONST) ^ d;
    }

    /**
     * Produce a hash value based on the given keys according to an algorithm attributed to
     * Knuth (The Art of Programming, Vol. 3, Sorting and Searching) (TODO: verify this source).
     * The key idea is to combine 32-bit hash keys (where a typical class has multiple hash keys)
     * using exclusive OR after multiplying the existing accumulated result by a large prime number.
     */
    public static int hash(int... keys) {
        var result = 1;
        for (var i = 0; i < keys.length; i++) {
            result = (result * KNUTH_CONST) ^ keys[i];
        }
        return result;
    }

    /**
     * Optimized implementation of {@link #hash(Object[])} with 1 arg.
     */
    public static int hash(Object a) {
        return hash((a == null) ? 0 : a.hashCode());
    }

    /**
     * Optimized implementation of {@link #hash(Object[])}) with 2 args.
     */
    public static int hash(Object a, Object b) {
        return hash((a == null) ? 0 : a.hashCode(), (b == null) ? 0 : b.hashCode());
    }

    /**
     * Optimized implementation of {@link #hash(Object[])} with 3 args.
     */
    public static int hash(Object a, Object b, Object c) {
        return hash((a == null) ? 0 : a.hashCode(), (b == null) ? 0 : b.hashCode(),
                (c == null) ? 0 : c.hashCode());
    }

    /**
     * Optimized implementation of {@link #hash(Object[])} with 4 args.
     */
    public static int hash(Object a, Object b, Object c, Object d) {
        return hash((a == null) ? 0 : a.hashCode(), (b == null) ? 0 : b.hashCode(),
                (c == null) ? 0 : c.hashCode(), (d == null) ? 0 : d.hashCode());
    }

    /**
     * Produce a hash code for an object in which {@code #equals()} depends on the given values.
     */
    public static int hash(Object... objs) {
        var len = objs.length;
        int[] keys = new int[len];
        for (var i = 0; i < len; i++) {
            Object obj = objs[i];
            keys[i] = (obj == null) ? 0 : obj.hashCode();
        }
        return hash(keys);
    }

    /**
     * Produce a hash code for an object in which {@code equals()} depends on the given values.
     */
    public static int hash(Iterable<?> iter) {
        var result = 1;
        for (Object obj : iter) {
            var key = (obj == null) ? 0 : obj.hashCode();
            result = (result * KNUTH_CONST) ^ key;
        }
        return result;
    }

}
