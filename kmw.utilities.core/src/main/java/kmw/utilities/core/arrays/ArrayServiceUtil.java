package kmw.utilities.core.arrays;

import kmw.utilities.core.base.ClassServiceUtil;

import java.lang.reflect.Array;
import javax.annotation.Nullable;

public final class ArrayServiceUtil {

    private ArrayServiceUtil() {}

    /**
     * An empty immutable {@code Object} array.
     */
    public static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];
    /**
     * An empty immutable {@code Class} array.
     */
    public static final Class<?>[] EMPTY_CLASS_ARRAY = new Class[0];
    /**
     * An empty immutable {@code String} array.
     */
    public static final String[] EMPTY_STRING_ARRAY = new String[0];
    /**
     * An empty immutable {@code long} array.
     */
    public static final long[] EMPTY_LONG_ARRAY = new long[0];
    /**
     * An empty immutable {@code Long} array.
     */
    public static final Long[] EMPTY_LONG_OBJECT_ARRAY = new Long[0];
    /**
     * An empty immutable {@code int} array.
     */
    public static final int[] EMPTY_INT_ARRAY = new int[0];
    /**
     * An empty immutable {@code Integer} array.
     */
    public static final Integer[] EMPTY_INTEGER_OBJECT_ARRAY = new Integer[0];
    /**
     * An empty immutable {@code short} array.
     */
    public static final short[] EMPTY_SHORT_ARRAY = new short[0];
    /**
     * An empty immutable {@code Short} array.
     */
    public static final Short[] EMPTY_SHORT_OBJECT_ARRAY = new Short[0];
    /**
     * An empty immutable {@code byte} array.
     */
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    /**
     * An empty immutable {@code Byte} array.
     */
    public static final Byte[] EMPTY_BYTE_OBJECT_ARRAY = new Byte[0];
    /**
     * An empty immutable {@code double} array.
     */
    public static final double[] EMPTY_DOUBLE_ARRAY = new double[0];
    /**
     * An empty immutable {@code Double} array.
     */
    public static final Double[] EMPTY_DOUBLE_OBJECT_ARRAY = new Double[0];
    /**
     * An empty immutable {@code float} array.
     */
    public static final float[] EMPTY_FLOAT_ARRAY = new float[0];
    /**
     * An empty immutable {@code Float} array.
     */
    public static final Float[] EMPTY_FLOAT_OBJECT_ARRAY = new Float[0];
    /**
     * An empty immutable {@code boolean} array.
     */
    public static final boolean[] EMPTY_BOOLEAN_ARRAY = new boolean[0];
    /**
     * An empty immutable {@code Boolean} array.
     */
    public static final Boolean[] EMPTY_BOOLEAN_OBJECT_ARRAY = new Boolean[0];
    /**
     * An empty immutable {@code char} array.
     */
    public static final char[] EMPTY_CHAR_ARRAY = new char[0];
    /**
     * An empty immutable {@code Character} array.
     */
    public static final Character[] EMPTY_CHARACTER_OBJECT_ARRAY = new Character[0];

    /**
     * The index value when an element is not found in a list or array: {@code -1}.
     * This value is returned by methods in this class and can also be used in comparisons with values returned by
     * various method from {@link java.util.List}.
     */
    public static final int INDEX_NOT_FOUND = -1;


    public static boolean isNullOrEmpty(@Nullable Object[] array) {
        return array == null || array.length == 0;
    }

    public static boolean isNullOrEmpty(@Nullable String[] array) {
        return array == null || array.length == 0;
    }

    // Generic array
    //-----------------------------------------------------------------------
    /**
     * <p>Create a type-safe generic array.
     *
     * <p>The Java language does not allow an array to be created from a generic type:
     *
     * <pre>
     public static &lt;T&gt; T[] createAnArray(int size) {
     return new T[size]; // compiler error here
     }
     public static &lt;T&gt; T[] createAnArray(int size) {
     return (T[])new Object[size]; // ClassCastException at runtime
     }
     * </pre>
     *
     * <p>Therefore new arrays of generic types can be created with this method.
     * For example, an array of Strings can be created:
     *
     * <pre>
     String[] array = ArrayUtils.toArray("1", "2");
     String[] emptyArray = ArrayUtils.&lt;String&gt;toArray();
     * </pre>
     *
     * <p>The method is typically used in scenarios, where the caller itself uses generic types
     * that have to be combined into an array.
     *
     * <p>Note, this method makes only sense to provide arguments of the same type so that the
     * compiler can deduce the type of the array itself. While it is possible to select the
     * type explicitly like in
     * <code>Number[] array = ArrayUtils.&lt;Number&gt;toArray(Integer.valueOf(42), Double.valueOf(Math.PI))</code>,
     * there is no real advantage when compared to
     * <code>new Number[] {Integer.valueOf(42), Double.valueOf(Math.PI)}</code>.
     *
     * @param  <T>   the array's element type
     * @param  items  the varargs array items, null allowed
     * @return the array, not null unless a null array is passed in
     * @since  3.0
     */
    public static <T> T[] toArray(final T... items) {
        return items;
    }

    // Clone
    //-----------------------------------------------------------------------
    /**
     * <p>Shallow clones an array returning a typecast result and handling
     * {@code null}.
     *
     * <p>The objects in the array are not cloned, thus there is no special
     * handling for multi-dimensional arrays.
     *
     * <p>This method returns {@code null} for a {@code null} input array.
     *
     * @param <T> the component type of the array
     * @param array  the array to shallow clone, may be {@code null}
     * @return the cloned array, {@code null} if {@code null} input
     */
    public static <T> T[] clone(final T[] array) {
        if (array == null) {
            return null;
        }
        return array.clone();
    }

    /**
     * <p>Clones an array returning a typecast result and handling
     * {@code null}.
     *
     * <p>This method returns {@code null} for a {@code null} input array.
     *
     * @param array  the array to clone, may be {@code null}
     * @return the cloned array, {@code null} if {@code null} input
     */
    public static long[] clone(final long[] array) {
        if (array == null) {
            return null;
        }
        return array.clone();
    }

    /**
     * <p>Clones an array returning a typecast result and handling
     * {@code null}.
     *
     * <p>This method returns {@code null} for a {@code null} input array.
     *
     * @param array  the array to clone, may be {@code null}
     * @return the cloned array, {@code null} if {@code null} input
     */
    public static int[] clone(final int[] array) {
        if (array == null) {
            return null;
        }
        return array.clone();
    }

    /**
     * <p>Clones an array returning a typecast result and handling
     * {@code null}.
     *
     * <p>This method returns {@code null} for a {@code null} input array.
     *
     * @param array  the array to clone, may be {@code null}
     * @return the cloned array, {@code null} if {@code null} input
     */
    public static short[] clone(final short[] array) {
        if (array == null) {
            return null;
        }
        return array.clone();
    }

    /**
     * <p>Clones an array returning a typecast result and handling
     * {@code null}.
     *
     * <p>This method returns {@code null} for a {@code null} input array.
     *
     * @param array  the array to clone, may be {@code null}
     * @return the cloned array, {@code null} if {@code null} input
     */
    public static char[] clone(final char[] array) {
        if (array == null) {
            return null;
        }
        return array.clone();
    }

    /**
     * <p>Clones an array returning a typecast result and handling
     * {@code null}.
     *
     * <p>This method returns {@code null} for a {@code null} input array.
     *
     * @param array  the array to clone, may be {@code null}
     * @return the cloned array, {@code null} if {@code null} input
     */
    public static byte[] clone(final byte[] array) {
        if (array == null) {
            return null;
        }
        return array.clone();
    }

    /**
     * <p>Clones an array returning a typecast result and handling
     * {@code null}.
     *
     * <p>This method returns {@code null} for a {@code null} input array.
     *
     * @param array  the array to clone, may be {@code null}
     * @return the cloned array, {@code null} if {@code null} input
     */
    public static double[] clone(final double[] array) {
        if (array == null) {
            return null;
        }
        return array.clone();
    }

    /**
     * <p>Clones an array returning a typecast result and handling
     * {@code null}.
     *
     * <p>This method returns {@code null} for a {@code null} input array.
     *
     * @param array  the array to clone, may be {@code null}
     * @return the cloned array, {@code null} if {@code null} input
     */
    public static float[] clone(final float[] array) {
        if (array == null) {
            return null;
        }
        return array.clone();
    }

    /**
     * <p>Clones an array returning a typecast result and handling
     * {@code null}.
     *
     * <p>This method returns {@code null} for a {@code null} input array.
     *
     * @param array  the array to clone, may be {@code null}
     * @return the cloned array, {@code null} if {@code null} input
     */
    public static boolean[] clone(final boolean[] array) {
        if (array == null) {
            return null;
        }
        return array.clone();
    }

    // nullToEmpty
    //-----------------------------------------------------------------------
    /**
     * <p>Defensive programming technique to change a {@code null}
     * reference to an empty one.
     *
     * <p>This method returns an empty array for a {@code null} input array.
     *
     * @param array  the array to check for {@code null} or empty
     * @param type   the class representation of the desired array
     * @param <T>  the class type
     * @return the same array, {@code public static} empty array if {@code null}
     * @throws IllegalArgumentException if the type argument is null
     * @since 3.5
     */
    public static <T> T[] nullToEmpty(final T[] array, final Class<T[]> type) {
        if (type == null) {
            throw new IllegalArgumentException("The type must not be null");
        }

        if (array == null) {
            return type.cast(Array.newInstance(type.getComponentType(), 0));
        }
        return array;
    }


    /**
     * <p>Defensive programming technique to change a {@code null}
     * reference to an empty one.
     *
     * <p>This method returns an empty array for a {@code null} input array.
     *
     * <p>As a memory optimizing technique an empty array passed in will be overridden with
     * the empty {@code public static} references in this class.
     *
     * @param array  the array to check for {@code null} or empty
     * @return the same array, {@code public static} empty array if {@code null} or empty input
     * @since 2.5
     */
    public static Object[] nullToEmpty(final Object[] array) {
        if (isEmpty(array)) {
            return EMPTY_OBJECT_ARRAY;
        }
        return array;
    }

    /**
     * <p>Defensive programming technique to change a {@code null}
     * reference to an empty one.
     *
     * <p>This method returns an empty array for a {@code null} input array.
     *
     * <p>As a memory optimizing technique an empty array passed in will be overridden with
     * the empty {@code public static} references in this class.
     *
     * @param array  the array to check for {@code null} or empty
     * @return the same array, {@code public static} empty array if {@code null} or empty input
     * @since 3.2
     */
    public static Class<?>[] nullToEmpty(final Class<?>[] array) {
        if (isEmpty(array)) {
            return EMPTY_CLASS_ARRAY;
        }
        return array;
    }

    /**
     * <p>Defensive programming technique to change a {@code null}
     * reference to an empty one.
     *
     * <p>This method returns an empty array for a {@code null} input array.
     *
     * <p>As a memory optimizing technique an empty array passed in will be overridden with
     * the empty {@code public static} references in this class.
     *
     * @param array  the array to check for {@code null} or empty
     * @return the same array, {@code public static} empty array if {@code null} or empty input
     * @since 2.5
     */
    public static String[] nullToEmpty(final String[] array) {
        if (isEmpty(array)) {
            return EMPTY_STRING_ARRAY;
        }
        return array;
    }

    /**
     * <p>Defensive programming technique to change a {@code null}
     * reference to an empty one.
     *
     * <p>This method returns an empty array for a {@code null} input array.
     *
     * <p>As a memory optimizing technique an empty array passed in will be overridden with
     * the empty {@code public static} references in this class.
     *
     * @param array  the array to check for {@code null} or empty
     * @return the same array, {@code public static} empty array if {@code null} or empty input
     * @since 2.5
     */
    public static long[] nullToEmpty(final long[] array) {
        if (isEmpty(array)) {
            return EMPTY_LONG_ARRAY;
        }
        return array;
    }

    /**
     * <p>Defensive programming technique to change a {@code null}
     * reference to an empty one.
     *
     * <p>This method returns an empty array for a {@code null} input array.
     *
     * <p>As a memory optimizing technique an empty array passed in will be overridden with
     * the empty {@code public static} references in this class.
     *
     * @param array  the array to check for {@code null} or empty
     * @return the same array, {@code public static} empty array if {@code null} or empty input
     * @since 2.5
     */
    public static int[] nullToEmpty(final int[] array) {
        if (isEmpty(array)) {
            return EMPTY_INT_ARRAY;
        }
        return array;
    }

    /**
     * <p>Defensive programming technique to change a {@code null}
     * reference to an empty one.
     *
     * <p>This method returns an empty array for a {@code null} input array.
     *
     * <p>As a memory optimizing technique an empty array passed in will be overridden with
     * the empty {@code public static} references in this class.
     *
     * @param array  the array to check for {@code null} or empty
     * @return the same array, {@code public static} empty array if {@code null} or empty input
     * @since 2.5
     */
    public static short[] nullToEmpty(final short[] array) {
        if (isEmpty(array)) {
            return EMPTY_SHORT_ARRAY;
        }
        return array;
    }

    /**
     * <p>Defensive programming technique to change a {@code null}
     * reference to an empty one.
     *
     * <p>This method returns an empty array for a {@code null} input array.
     *
     * <p>As a memory optimizing technique an empty array passed in will be overridden with
     * the empty {@code public static} references in this class.
     *
     * @param array  the array to check for {@code null} or empty
     * @return the same array, {@code public static} empty array if {@code null} or empty input
     * @since 2.5
     */
    public static char[] nullToEmpty(final char[] array) {
        if (isEmpty(array)) {
            return EMPTY_CHAR_ARRAY;
        }
        return array;
    }

    /**
     * <p>Defensive programming technique to change a {@code null}
     * reference to an empty one.
     *
     * <p>This method returns an empty array for a {@code null} input array.
     *
     * <p>As a memory optimizing technique an empty array passed in will be overridden with
     * the empty {@code public static} references in this class.
     *
     * @param array  the array to check for {@code null} or empty
     * @return the same array, {@code public static} empty array if {@code null} or empty input
     * @since 2.5
     */
    public static byte[] nullToEmpty(final byte[] array) {
        if (isEmpty(array)) {
            return EMPTY_BYTE_ARRAY;
        }
        return array;
    }

    /**
     * <p>Defensive programming technique to change a {@code null}
     * reference to an empty one.
     *
     * <p>This method returns an empty array for a {@code null} input array.
     *
     * <p>As a memory optimizing technique an empty array passed in will be overridden with
     * the empty {@code public static} references in this class.
     *
     * @param array  the array to check for {@code null} or empty
     * @return the same array, {@code public static} empty array if {@code null} or empty input
     * @since 2.5
     */
    public static double[] nullToEmpty(final double[] array) {
        if (isEmpty(array)) {
            return EMPTY_DOUBLE_ARRAY;
        }
        return array;
    }

    /**
     * <p>Defensive programming technique to change a {@code null}
     * reference to an empty one.
     *
     * <p>This method returns an empty array for a {@code null} input array.
     *
     * <p>As a memory optimizing technique an empty array passed in will be overridden with
     * the empty {@code public static} references in this class.
     *
     * @param array  the array to check for {@code null} or empty
     * @return the same array, {@code public static} empty array if {@code null} or empty input
     * @since 2.5
     */
    public static float[] nullToEmpty(final float[] array) {
        if (isEmpty(array)) {
            return EMPTY_FLOAT_ARRAY;
        }
        return array;
    }

    /**
     * <p>Defensive programming technique to change a {@code null}
     * reference to an empty one.
     *
     * <p>This method returns an empty array for a {@code null} input array.
     *
     * <p>As a memory optimizing technique an empty array passed in will be overridden with
     * the empty {@code public static} references in this class.
     *
     * @param array  the array to check for {@code null} or empty
     * @return the same array, {@code public static} empty array if {@code null} or empty input
     * @since 2.5
     */
    public static boolean[] nullToEmpty(final boolean[] array) {
        if (isEmpty(array)) {
            return EMPTY_BOOLEAN_ARRAY;
        }
        return array;
    }

    /**
     * <p>Defensive programming technique to change a {@code null}
     * reference to an empty one.
     *
     * <p>This method returns an empty array for a {@code null} input array.
     *
     * <p>As a memory optimizing technique an empty array passed in will be overridden with
     * the empty {@code public static} references in this class.
     *
     * @param array  the array to check for {@code null} or empty
     * @return the same array, {@code public static} empty array if {@code null} or empty input
     * @since 2.5
     */
    public static Long[] nullToEmpty(final Long[] array) {
        if (isEmpty(array)) {
            return EMPTY_LONG_OBJECT_ARRAY;
        }
        return array;
    }

    /**
     * <p>Defensive programming technique to change a {@code null}
     * reference to an empty one.
     *
     * <p>This method returns an empty array for a {@code null} input array.
     *
     * <p>As a memory optimizing technique an empty array passed in will be overridden with
     * the empty {@code public static} references in this class.
     *
     * @param array  the array to check for {@code null} or empty
     * @return the same array, {@code public static} empty array if {@code null} or empty input
     * @since 2.5
     */
    public static Integer[] nullToEmpty(final Integer[] array) {
        if (isEmpty(array)) {
            return EMPTY_INTEGER_OBJECT_ARRAY;
        }
        return array;
    }

    /**
     * <p>Defensive programming technique to change a {@code null}
     * reference to an empty one.
     *
     * <p>This method returns an empty array for a {@code null} input array.
     *
     * <p>As a memory optimizing technique an empty array passed in will be overridden with
     * the empty {@code public static} references in this class.
     *
     * @param array  the array to check for {@code null} or empty
     * @return the same array, {@code public static} empty array if {@code null} or empty input
     * @since 2.5
     */
    public static Short[] nullToEmpty(final Short[] array) {
        if (isEmpty(array)) {
            return EMPTY_SHORT_OBJECT_ARRAY;
        }
        return array;
    }

    /**
     * <p>Defensive programming technique to change a {@code null}
     * reference to an empty one.
     *
     * <p>This method returns an empty array for a {@code null} input array.
     *
     * <p>As a memory optimizing technique an empty array passed in will be overridden with
     * the empty {@code public static} references in this class.
     *
     * @param array  the array to check for {@code null} or empty
     * @return the same array, {@code public static} empty array if {@code null} or empty input
     * @since 2.5
     */
    public static Character[] nullToEmpty(final Character[] array) {
        if (isEmpty(array)) {
            return EMPTY_CHARACTER_OBJECT_ARRAY;
        }
        return array;
    }

    /**
     * <p>Defensive programming technique to change a {@code null}
     * reference to an empty one.
     *
     * <p>This method returns an empty array for a {@code null} input array.
     *
     * <p>As a memory optimizing technique an empty array passed in will be overridden with
     * the empty {@code public static} references in this class.
     *
     * @param array  the array to check for {@code null} or empty
     * @return the same array, {@code public static} empty array if {@code null} or empty input
     * @since 2.5
     */
    public static Byte[] nullToEmpty(final Byte[] array) {
        if (isEmpty(array)) {
            return EMPTY_BYTE_OBJECT_ARRAY;
        }
        return array;
    }

    /**
     * <p>Defensive programming technique to change a {@code null}
     * reference to an empty one.
     *
     * <p>This method returns an empty array for a {@code null} input array.
     *
     * <p>As a memory optimizing technique an empty array passed in will be overridden with
     * the empty {@code public static} references in this class.
     *
     * @param array  the array to check for {@code null} or empty
     * @return the same array, {@code public static} empty array if {@code null} or empty input
     * @since 2.5
     */
    public static Double[] nullToEmpty(final Double[] array) {
        if (isEmpty(array)) {
            return EMPTY_DOUBLE_OBJECT_ARRAY;
        }
        return array;
    }

    /**
     * <p>Defensive programming technique to change a {@code null}
     * reference to an empty one.
     *
     * <p>This method returns an empty array for a {@code null} input array.
     *
     * <p>As a memory optimizing technique an empty array passed in will be overridden with
     * the empty {@code public static} references in this class.
     *
     * @param array  the array to check for {@code null} or empty
     * @return the same array, {@code public static} empty array if {@code null} or empty input
     * @since 2.5
     */
    public static Float[] nullToEmpty(final Float[] array) {
        if (isEmpty(array)) {
            return EMPTY_FLOAT_OBJECT_ARRAY;
        }
        return array;
    }

    /**
     * <p>Defensive programming technique to change a {@code null}
     * reference to an empty one.
     *
     * <p>This method returns an empty array for a {@code null} input array.
     *
     * <p>As a memory optimizing technique an empty array passed in will be overridden with
     * the empty {@code public static} references in this class.
     *
     * @param array  the array to check for {@code null} or empty
     * @return the same array, {@code public static} empty array if {@code null} or empty input
     * @since 2.5
     */
    public static Boolean[] nullToEmpty(final Boolean[] array) {
        if (isEmpty(array)) {
            return EMPTY_BOOLEAN_OBJECT_ARRAY;
        }
        return array;
    }

    // Subarrays
    //-----------------------------------------------------------------------
    /**
     * <p>Produces a new array containing the elements between
     * the start and end indices.
     *
     * <p>The start index is inclusive, the end index exclusive.
     * Null array input produces null output.
     *
     * <p>The component type of the subarray is always the same as
     * that of the input array. Thus, if the input is an array of type
     * {@code Date}, the following usage is envisaged:
     *
     * <pre>
     * Date[] someDates = (Date[])ArrayUtils.subarray(allDates, 2, 5);
     * </pre>
     *
     * @param <T> the component type of the array
     * @param array  the array
     * @param startIndexInclusive  the starting index. Undervalue (&lt;0)
     *      is promoted to 0, overvalue (&gt;array.length) results
     *      in an empty array.
     * @param endIndexExclusive  elements up to endIndex-1 are present in the
     *      returned subarray. Undervalue (&lt; startIndex) produces
     *      empty array, overvalue (&gt;array.length) is demoted to
     *      array length.
     * @return a new array containing the elements between
     *      the start and end indices.
     * @since 2.1
     * @see Arrays#copyOfRange(Object[], int, int)
     */
    public static <T> T[] subarray(final T[] array, int startIndexInclusive, int endIndexExclusive) {
        if (array == null) {
            return null;
        }
        if (startIndexInclusive < 0) {
            startIndexInclusive = 0;
        }
        if (endIndexExclusive > array.length) {
            endIndexExclusive = array.length;
        }
        final int newSize = endIndexExclusive - startIndexInclusive;
        final Class<?> type = array.getClass().getComponentType();
        if (newSize <= 0) {
            @SuppressWarnings("unchecked") // OK, because array is of type T
            final T[] emptyArray = (T[]) Array.newInstance(type, 0);
            return emptyArray;
        }
        @SuppressWarnings("unchecked") // OK, because array is of type T
        final
        T[] subarray = (T[]) Array.newInstance(type, newSize);
        System.arraycopy(array, startIndexInclusive, subarray, 0, newSize);
        return subarray;
    }

    /**
     * <p>Produces a new {@code long} array containing the elements
     * between the start and end indices.
     *
     * <p>The start index is inclusive, the end index exclusive.
     * Null array input produces null output.
     *
     * @param array  the array
     * @param startIndexInclusive  the starting index. Undervalue (&lt;0)
     *      is promoted to 0, overvalue (&gt;array.length) results
     *      in an empty array.
     * @param endIndexExclusive  elements up to endIndex-1 are present in the
     *      returned subarray. Undervalue (&lt; startIndex) produces
     *      empty array, overvalue (&gt;array.length) is demoted to
     *      array length.
     * @return a new array containing the elements between
     *      the start and end indices.
     * @since 2.1
     * @see Arrays#copyOfRange(long[], int, int)
     */
    public static long[] subarray(final long[] array, int startIndexInclusive, int endIndexExclusive) {
        if (array == null) {
            return null;
        }
        if (startIndexInclusive < 0) {
            startIndexInclusive = 0;
        }
        if (endIndexExclusive > array.length) {
            endIndexExclusive = array.length;
        }
        final int newSize = endIndexExclusive - startIndexInclusive;
        if (newSize <= 0) {
            return EMPTY_LONG_ARRAY;
        }

        final long[] subarray = new long[newSize];
        System.arraycopy(array, startIndexInclusive, subarray, 0, newSize);
        return subarray;
    }

    /**
     * <p>Produces a new {@code int} array containing the elements
     * between the start and end indices.
     *
     * <p>The start index is inclusive, the end index exclusive.
     * Null array input produces null output.
     *
     * @param array  the array
     * @param startIndexInclusive  the starting index. Undervalue (&lt;0)
     *      is promoted to 0, overvalue (&gt;array.length) results
     *      in an empty array.
     * @param endIndexExclusive  elements up to endIndex-1 are present in the
     *      returned subarray. Undervalue (&lt; startIndex) produces
     *      empty array, overvalue (&gt;array.length) is demoted to
     *      array length.
     * @return a new array containing the elements between
     *      the start and end indices.
     * @since 2.1
     * @see Arrays#copyOfRange(int[], int, int)
     */
    public static int[] subarray(final int[] array, int startIndexInclusive, int endIndexExclusive) {
        if (array == null) {
            return null;
        }
        if (startIndexInclusive < 0) {
            startIndexInclusive = 0;
        }
        if (endIndexExclusive > array.length) {
            endIndexExclusive = array.length;
        }
        final int newSize = endIndexExclusive - startIndexInclusive;
        if (newSize <= 0) {
            return EMPTY_INT_ARRAY;
        }

        final int[] subarray = new int[newSize];
        System.arraycopy(array, startIndexInclusive, subarray, 0, newSize);
        return subarray;
    }

    /**
     * <p>Produces a new {@code short} array containing the elements
     * between the start and end indices.
     *
     * <p>The start index is inclusive, the end index exclusive.
     * Null array input produces null output.
     *
     * @param array  the array
     * @param startIndexInclusive  the starting index. Undervalue (&lt;0)
     *      is promoted to 0, overvalue (&gt;array.length) results
     *      in an empty array.
     * @param endIndexExclusive  elements up to endIndex-1 are present in the
     *      returned subarray. Undervalue (&lt; startIndex) produces
     *      empty array, overvalue (&gt;array.length) is demoted to
     *      array length.
     * @return a new array containing the elements between
     *      the start and end indices.
     * @since 2.1
     * @see Arrays#copyOfRange(short[], int, int)
     */
    public static short[] subarray(final short[] array, int startIndexInclusive, int endIndexExclusive) {
        if (array == null) {
            return null;
        }
        if (startIndexInclusive < 0) {
            startIndexInclusive = 0;
        }
        if (endIndexExclusive > array.length) {
            endIndexExclusive = array.length;
        }
        final int newSize = endIndexExclusive - startIndexInclusive;
        if (newSize <= 0) {
            return EMPTY_SHORT_ARRAY;
        }

        final short[] subarray = new short[newSize];
        System.arraycopy(array, startIndexInclusive, subarray, 0, newSize);
        return subarray;
    }

    /**
     * <p>Produces a new {@code char} array containing the elements
     * between the start and end indices.
     *
     * <p>The start index is inclusive, the end index exclusive.
     * Null array input produces null output.
     *
     * @param array  the array
     * @param startIndexInclusive  the starting index. Undervalue (&lt;0)
     *      is promoted to 0, overvalue (&gt;array.length) results
     *      in an empty array.
     * @param endIndexExclusive  elements up to endIndex-1 are present in the
     *      returned subarray. Undervalue (&lt; startIndex) produces
     *      empty array, overvalue (&gt;array.length) is demoted to
     *      array length.
     * @return a new array containing the elements between
     *      the start and end indices.
     * @since 2.1
     * @see Arrays#copyOfRange(char[], int, int)
     */
    public static char[] subarray(final char[] array, int startIndexInclusive, int endIndexExclusive) {
        if (array == null) {
            return null;
        }
        if (startIndexInclusive < 0) {
            startIndexInclusive = 0;
        }
        if (endIndexExclusive > array.length) {
            endIndexExclusive = array.length;
        }
        final int newSize = endIndexExclusive - startIndexInclusive;
        if (newSize <= 0) {
            return EMPTY_CHAR_ARRAY;
        }

        final char[] subarray = new char[newSize];
        System.arraycopy(array, startIndexInclusive, subarray, 0, newSize);
        return subarray;
    }

    /**
     * <p>Produces a new {@code byte} array containing the elements
     * between the start and end indices.
     *
     * <p>The start index is inclusive, the end index exclusive.
     * Null array input produces null output.
     *
     * @param array  the array
     * @param startIndexInclusive  the starting index. Undervalue (&lt;0)
     *      is promoted to 0, overvalue (&gt;array.length) results
     *      in an empty array.
     * @param endIndexExclusive  elements up to endIndex-1 are present in the
     *      returned subarray. Undervalue (&lt; startIndex) produces
     *      empty array, overvalue (&gt;array.length) is demoted to
     *      array length.
     * @return a new array containing the elements between
     *      the start and end indices.
     * @since 2.1
     * @see Arrays#copyOfRange(byte[], int, int)
     */
    public static byte[] subarray(final byte[] array, int startIndexInclusive, int endIndexExclusive) {
        if (array == null) {
            return null;
        }
        if (startIndexInclusive < 0) {
            startIndexInclusive = 0;
        }
        if (endIndexExclusive > array.length) {
            endIndexExclusive = array.length;
        }
        final int newSize = endIndexExclusive - startIndexInclusive;
        if (newSize <= 0) {
            return EMPTY_BYTE_ARRAY;
        }

        final byte[] subarray = new byte[newSize];
        System.arraycopy(array, startIndexInclusive, subarray, 0, newSize);
        return subarray;
    }

    /**
     * <p>Produces a new {@code double} array containing the elements
     * between the start and end indices.
     *
     * <p>The start index is inclusive, the end index exclusive.
     * Null array input produces null output.
     *
     * @param array  the array
     * @param startIndexInclusive  the starting index. Undervalue (&lt;0)
     *      is promoted to 0, overvalue (&gt;array.length) results
     *      in an empty array.
     * @param endIndexExclusive  elements up to endIndex-1 are present in the
     *      returned subarray. Undervalue (&lt; startIndex) produces
     *      empty array, overvalue (&gt;array.length) is demoted to
     *      array length.
     * @return a new array containing the elements between
     *      the start and end indices.
     * @since 2.1
     * @see Arrays#copyOfRange(double[], int, int)
     */
    public static double[] subarray(final double[] array, int startIndexInclusive, int endIndexExclusive) {
        if (array == null) {
            return null;
        }
        if (startIndexInclusive < 0) {
            startIndexInclusive = 0;
        }
        if (endIndexExclusive > array.length) {
            endIndexExclusive = array.length;
        }
        final int newSize = endIndexExclusive - startIndexInclusive;
        if (newSize <= 0) {
            return EMPTY_DOUBLE_ARRAY;
        }

        final double[] subarray = new double[newSize];
        System.arraycopy(array, startIndexInclusive, subarray, 0, newSize);
        return subarray;
    }

    /**
     * <p>Produces a new {@code float} array containing the elements
     * between the start and end indices.
     *
     * <p>The start index is inclusive, the end index exclusive.
     * Null array input produces null output.
     *
     * @param array  the array
     * @param startIndexInclusive  the starting index. Undervalue (&lt;0)
     *      is promoted to 0, overvalue (&gt;array.length) results
     *      in an empty array.
     * @param endIndexExclusive  elements up to endIndex-1 are present in the
     *      returned subarray. Undervalue (&lt; startIndex) produces
     *      empty array, overvalue (&gt;array.length) is demoted to
     *      array length.
     * @return a new array containing the elements between
     *      the start and end indices.
     * @since 2.1
     * @see Arrays#copyOfRange(float[], int, int)
     */
    public static float[] subarray(final float[] array, int startIndexInclusive, int endIndexExclusive) {
        if (array == null) {
            return null;
        }
        if (startIndexInclusive < 0) {
            startIndexInclusive = 0;
        }
        if (endIndexExclusive > array.length) {
            endIndexExclusive = array.length;
        }
        final int newSize = endIndexExclusive - startIndexInclusive;
        if (newSize <= 0) {
            return EMPTY_FLOAT_ARRAY;
        }

        final float[] subarray = new float[newSize];
        System.arraycopy(array, startIndexInclusive, subarray, 0, newSize);
        return subarray;
    }

    /**
     * <p>Produces a new {@code boolean} array containing the elements
     * between the start and end indices.
     *
     * <p>The start index is inclusive, the end index exclusive.
     * Null array input produces null output.
     *
     * @param array  the array
     * @param startIndexInclusive  the starting index. Undervalue (&lt;0)
     *      is promoted to 0, overvalue (&gt;array.length) results
     *      in an empty array.
     * @param endIndexExclusive  elements up to endIndex-1 are present in the
     *      returned subarray. Undervalue (&lt; startIndex) produces
     *      empty array, overvalue (&gt;array.length) is demoted to
     *      array length.
     * @return a new array containing the elements between
     *      the start and end indices.
     * @since 2.1
     * @see Arrays#copyOfRange(boolean[], int, int)
     */
    public static boolean[] subarray(final boolean[] array, int startIndexInclusive, int endIndexExclusive) {
        if (array == null) {
            return null;
        }
        if (startIndexInclusive < 0) {
            startIndexInclusive = 0;
        }
        if (endIndexExclusive > array.length) {
            endIndexExclusive = array.length;
        }
        final int newSize = endIndexExclusive - startIndexInclusive;
        if (newSize <= 0) {
            return EMPTY_BOOLEAN_ARRAY;
        }

        final boolean[] subarray = new boolean[newSize];
        System.arraycopy(array, startIndexInclusive, subarray, 0, newSize);
        return subarray;
    }

    // Is same length
    //-----------------------------------------------------------------------
    /**
     * <p>Checks whether two arrays are the same length, treating
     * {@code null} arrays as length {@code 0}.
     *
     * <p>Any multi-dimensional aspects of the arrays are ignored.
     *
     * @param array1 the first array, may be {@code null}
     * @param array2 the second array, may be {@code null}
     * @return {@code true} if length of arrays matches, treating
     *  {@code null} as an empty array
     */
    public static boolean isSameLength(final Object[] array1, final Object[] array2) {
        return getLength(array1) == getLength(array2);
    }

    /**
     * <p>Checks whether two arrays are the same length, treating
     * {@code null} arrays as length {@code 0}.
     *
     * @param array1 the first array, may be {@code null}
     * @param array2 the second array, may be {@code null}
     * @return {@code true} if length of arrays matches, treating
     *  {@code null} as an empty array
     */
    public static boolean isSameLength(final long[] array1, final long[] array2) {
        return getLength(array1) == getLength(array2);
    }

    /**
     * <p>Checks whether two arrays are the same length, treating
     * {@code null} arrays as length {@code 0}.
     *
     * @param array1 the first array, may be {@code null}
     * @param array2 the second array, may be {@code null}
     * @return {@code true} if length of arrays matches, treating
     *  {@code null} as an empty array
     */
    public static boolean isSameLength(final int[] array1, final int[] array2) {
        return getLength(array1) == getLength(array2);
    }

    /**
     * <p>Checks whether two arrays are the same length, treating
     * {@code null} arrays as length {@code 0}.
     *
     * @param array1 the first array, may be {@code null}
     * @param array2 the second array, may be {@code null}
     * @return {@code true} if length of arrays matches, treating
     *  {@code null} as an empty array
     */
    public static boolean isSameLength(final short[] array1, final short[] array2) {
        return getLength(array1) == getLength(array2);
    }

    /**
     * <p>Checks whether two arrays are the same length, treating
     * {@code null} arrays as length {@code 0}.
     *
     * @param array1 the first array, may be {@code null}
     * @param array2 the second array, may be {@code null}
     * @return {@code true} if length of arrays matches, treating
     *  {@code null} as an empty array
     */
    public static boolean isSameLength(final char[] array1, final char[] array2) {
        return getLength(array1) == getLength(array2);
    }

    /**
     * <p>Checks whether two arrays are the same length, treating
     * {@code null} arrays as length {@code 0}.
     *
     * @param array1 the first array, may be {@code null}
     * @param array2 the second array, may be {@code null}
     * @return {@code true} if length of arrays matches, treating
     *  {@code null} as an empty array
     */
    public static boolean isSameLength(final byte[] array1, final byte[] array2) {
        return getLength(array1) == getLength(array2);
    }

    /**
     * <p>Checks whether two arrays are the same length, treating
     * {@code null} arrays as length {@code 0}.
     *
     * @param array1 the first array, may be {@code null}
     * @param array2 the second array, may be {@code null}
     * @return {@code true} if length of arrays matches, treating
     *  {@code null} as an empty array
     */
    public static boolean isSameLength(final double[] array1, final double[] array2) {
        return getLength(array1) == getLength(array2);
    }

    /**
     * <p>Checks whether two arrays are the same length, treating
     * {@code null} arrays as length {@code 0}.
     *
     * @param array1 the first array, may be {@code null}
     * @param array2 the second array, may be {@code null}
     * @return {@code true} if length of arrays matches, treating
     *  {@code null} as an empty array
     */
    public static boolean isSameLength(final float[] array1, final float[] array2) {
        return getLength(array1) == getLength(array2);
    }

    /**
     * <p>Checks whether two arrays are the same length, treating
     * {@code null} arrays as length {@code 0}.
     *
     * @param array1 the first array, may be {@code null}
     * @param array2 the second array, may be {@code null}
     * @return {@code true} if length of arrays matches, treating
     *  {@code null} as an empty array
     */
    public static boolean isSameLength(final boolean[] array1, final boolean[] array2) {
        return getLength(array1) == getLength(array2);
    }

    //-----------------------------------------------------------------------
    /**
     * <p>Returns the length of the specified array.
     * This method can deal with {@code Object} arrays and with primitive arrays.
     *
     * <p>If the input array is {@code null}, {@code 0} is returned.
     *
     * <pre>
     * ArrayUtils.getLength(null)            = 0
     * ArrayUtils.getLength([])              = 0
     * ArrayUtils.getLength([null])          = 1
     * ArrayUtils.getLength([true, false])   = 2
     * ArrayUtils.getLength([1, 2, 3])       = 3
     * ArrayUtils.getLength(["a", "b", "c"]) = 3
     * </pre>
     *
     * @param array  the array to retrieve the length from, may be null
     * @return The length of the array, or {@code 0} if the array is {@code null}
     * @throws IllegalArgumentException if the object argument is not an array.
     * @since 2.1
     */
    public static int getLength(final Object array) {
        if (array == null) {
            return 0;
        }
        return Array.getLength(array);
    }

    /**
     * <p>Checks whether two arrays are the same type taking into account
     * multi-dimensional arrays.
     *
     * @param array1 the first array, must not be {@code null}
     * @param array2 the second array, must not be {@code null}
     * @return {@code true} if type of arrays matches
     * @throws IllegalArgumentException if either array is {@code null}
     */
    public static boolean isSameType(final Object array1, final Object array2) {
        if (array1 == null || array2 == null) {
            throw new IllegalArgumentException("The Array must not be null");
        }
        return array1.getClass().getName().equals(array2.getClass().getName());
    }

    // Reverse
    //-----------------------------------------------------------------------
    /**
     * <p>Reverses the order of the given array.
     *
     * <p>There is no special handling for multi-dimensional arrays.
     *
     * <p>This method does nothing for a {@code null} input array.
     *
     * @param array  the array to reverse, may be {@code null}
     */
    public static void reverse(final Object[] array) {
        if (array == null) {
            return;
        }
        reverse(array, 0, array.length);
    }

    /**
     * <p>Reverses the order of the given array.
     *
     * <p>This method does nothing for a {@code null} input array.
     *
     * @param array  the array to reverse, may be {@code null}
     */
    public static void reverse(final long[] array) {
        if (array == null) {
            return;
        }
        reverse(array, 0, array.length);
    }

    /**
     * <p>Reverses the order of the given array.
     *
     * <p>This method does nothing for a {@code null} input array.
     *
     * @param array  the array to reverse, may be {@code null}
     */
    public static void reverse(final int[] array) {
        if (array == null) {
            return;
        }
        reverse(array, 0, array.length);
    }

    /**
     * <p>Reverses the order of the given array.
     *
     * <p>This method does nothing for a {@code null} input array.
     *
     * @param array  the array to reverse, may be {@code null}
     */
    public static void reverse(final short[] array) {
        if (array == null) {
            return;
        }
        reverse(array, 0, array.length);
    }

    /**
     * <p>Reverses the order of the given array.
     *
     * <p>This method does nothing for a {@code null} input array.
     *
     * @param array  the array to reverse, may be {@code null}
     */
    public static void reverse(final char[] array) {
        if (array == null) {
            return;
        }
        reverse(array, 0, array.length);
    }

    /**
     * <p>Reverses the order of the given array.
     *
     * <p>This method does nothing for a {@code null} input array.
     *
     * @param array  the array to reverse, may be {@code null}
     */
    public static void reverse(final byte[] array) {
        if (array == null) {
            return;
        }
        reverse(array, 0, array.length);
    }

    /**
     * <p>Reverses the order of the given array.
     *
     * <p>This method does nothing for a {@code null} input array.
     *
     * @param array  the array to reverse, may be {@code null}
     */
    public static void reverse(final double[] array) {
        if (array == null) {
            return;
        }
        reverse(array, 0, array.length);
    }

    /**
     * <p>Reverses the order of the given array.
     *
     * <p>This method does nothing for a {@code null} input array.
     *
     * @param array  the array to reverse, may be {@code null}
     */
    public static void reverse(final float[] array) {
        if (array == null) {
            return;
        }
        reverse(array, 0, array.length);
    }

    /**
     * <p>Reverses the order of the given array.
     *
     * <p>This method does nothing for a {@code null} input array.
     *
     * @param array  the array to reverse, may be {@code null}
     */
    public static void reverse(final boolean[] array) {
        if (array == null) {
            return;
        }
        reverse(array, 0, array.length);
    }

    /**
     * <p>
     * Reverses the order of the given array in the given range.
     *
     * <p>
     * This method does nothing for a {@code null} input array.
     *
     * @param array
     *            the array to reverse, may be {@code null}
     * @param startIndexInclusive
     *            the starting index. Undervalue (&lt;0) is promoted to 0, overvalue (&gt;array.length) results in no
     *            change.
     * @param endIndexExclusive
     *            elements up to endIndex-1 are reversed in the array. Undervalue (&lt; start index) results in no
     *            change. Overvalue (&gt;array.length) is demoted to array length.
     * @since 3.2
     */
    public static void reverse(final boolean[] array, final int startIndexInclusive, final int endIndexExclusive) {
        if (array == null) {
            return;
        }
        int i = startIndexInclusive < 0 ? 0 : startIndexInclusive;
        int j = Math.min(array.length, endIndexExclusive) - 1;
        boolean tmp;
        while (j > i) {
            tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
            j--;
            i++;
        }
    }

    /**
     * <p>
     * Reverses the order of the given array in the given range.
     *
     * <p>
     * This method does nothing for a {@code null} input array.
     *
     * @param array
     *            the array to reverse, may be {@code null}
     * @param startIndexInclusive
     *            the starting index. Undervalue (&lt;0) is promoted to 0, overvalue (&gt;array.length) results in no
     *            change.
     * @param endIndexExclusive
     *            elements up to endIndex-1 are reversed in the array. Undervalue (&lt; start index) results in no
     *            change. Overvalue (&gt;array.length) is demoted to array length.
     * @since 3.2
     */
    public static void reverse(final byte[] array, final int startIndexInclusive, final int endIndexExclusive) {
        if (array == null) {
            return;
        }
        int i = startIndexInclusive < 0 ? 0 : startIndexInclusive;
        int j = Math.min(array.length, endIndexExclusive) - 1;
        byte tmp;
        while (j > i) {
            tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
            j--;
            i++;
        }
    }

    /**
     * <p>
     * Reverses the order of the given array in the given range.
     *
     * <p>
     * This method does nothing for a {@code null} input array.
     *
     * @param array
     *            the array to reverse, may be {@code null}
     * @param startIndexInclusive
     *            the starting index. Undervalue (&lt;0) is promoted to 0, overvalue (&gt;array.length) results in no
     *            change.
     * @param endIndexExclusive
     *            elements up to endIndex-1 are reversed in the array. Undervalue (&lt; start index) results in no
     *            change. Overvalue (&gt;array.length) is demoted to array length.
     * @since 3.2
     */
    public static void reverse(final char[] array, final int startIndexInclusive, final int endIndexExclusive) {
        if (array == null) {
            return;
        }
        int i = startIndexInclusive < 0 ? 0 : startIndexInclusive;
        int j = Math.min(array.length, endIndexExclusive) - 1;
        char tmp;
        while (j > i) {
            tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
            j--;
            i++;
        }
    }

    /**
     * <p>
     * Reverses the order of the given array in the given range.
     *
     * <p>
     * This method does nothing for a {@code null} input array.
     *
     * @param array
     *            the array to reverse, may be {@code null}
     * @param startIndexInclusive
     *            the starting index. Undervalue (&lt;0) is promoted to 0, overvalue (&gt;array.length) results in no
     *            change.
     * @param endIndexExclusive
     *            elements up to endIndex-1 are reversed in the array. Undervalue (&lt; start index) results in no
     *            change. Overvalue (&gt;array.length) is demoted to array length.
     * @since 3.2
     */
    public static void reverse(final double[] array, final int startIndexInclusive, final int endIndexExclusive) {
        if (array == null) {
            return;
        }
        int i = startIndexInclusive < 0 ? 0 : startIndexInclusive;
        int j = Math.min(array.length, endIndexExclusive) - 1;
        double tmp;
        while (j > i) {
            tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
            j--;
            i++;
        }
    }

    /**
     * <p>
     * Reverses the order of the given array in the given range.
     *
     * <p>
     * This method does nothing for a {@code null} input array.
     *
     * @param array
     *            the array to reverse, may be {@code null}
     * @param startIndexInclusive
     *            the starting index. Undervalue (&lt;0) is promoted to 0, overvalue (&gt;array.length) results in no
     *            change.
     * @param endIndexExclusive
     *            elements up to endIndex-1 are reversed in the array. Undervalue (&lt; start index) results in no
     *            change. Overvalue (&gt;array.length) is demoted to array length.
     * @since 3.2
     */
    public static void reverse(final float[] array, final int startIndexInclusive, final int endIndexExclusive) {
        if (array == null) {
            return;
        }
        int i = startIndexInclusive < 0 ? 0 : startIndexInclusive;
        int j = Math.min(array.length, endIndexExclusive) - 1;
        float tmp;
        while (j > i) {
            tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
            j--;
            i++;
        }
    }

    /**
     * <p>
     * Reverses the order of the given array in the given range.
     *
     * <p>
     * This method does nothing for a {@code null} input array.
     *
     * @param array
     *            the array to reverse, may be {@code null}
     * @param startIndexInclusive
     *            the starting index. Undervalue (&lt;0) is promoted to 0, overvalue (&gt;array.length) results in no
     *            change.
     * @param endIndexExclusive
     *            elements up to endIndex-1 are reversed in the array. Undervalue (&lt; start index) results in no
     *            change. Overvalue (&gt;array.length) is demoted to array length.
     * @since 3.2
     */
    public static void reverse(final int[] array, final int startIndexInclusive, final int endIndexExclusive) {
        if (array == null) {
            return;
        }
        int i = startIndexInclusive < 0 ? 0 : startIndexInclusive;
        int j = Math.min(array.length, endIndexExclusive) - 1;
        int tmp;
        while (j > i) {
            tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
            j--;
            i++;
        }
    }

    /**
     * <p>
     * Reverses the order of the given array in the given range.
     *
     * <p>
     * This method does nothing for a {@code null} input array.
     *
     * @param array
     *            the array to reverse, may be {@code null}
     * @param startIndexInclusive
     *            the starting index. Undervalue (&lt;0) is promoted to 0, overvalue (&gt;array.length) results in no
     *            change.
     * @param endIndexExclusive
     *            elements up to endIndex-1 are reversed in the array. Undervalue (&lt; start index) results in no
     *            change. Overvalue (&gt;array.length) is demoted to array length.
     * @since 3.2
     */
    public static void reverse(final long[] array, final int startIndexInclusive, final int endIndexExclusive) {
        if (array == null) {
            return;
        }
        int i = startIndexInclusive < 0 ? 0 : startIndexInclusive;
        int j = Math.min(array.length, endIndexExclusive) - 1;
        long tmp;
        while (j > i) {
            tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
            j--;
            i++;
        }
    }

    /**
     * <p>
     * Reverses the order of the given array in the given range.
     *
     * <p>
     * This method does nothing for a {@code null} input array.
     *
     * @param array
     *            the array to reverse, may be {@code null}
     * @param startIndexInclusive
     *            the starting index. Under value (&lt;0) is promoted to 0, over value (&gt;array.length) results in no
     *            change.
     * @param endIndexExclusive
     *            elements up to endIndex-1 are reversed in the array. Under value (&lt; start index) results in no
     *            change. Over value (&gt;array.length) is demoted to array length.
     * @since 3.2
     */
    public static void reverse(final Object[] array, final int startIndexInclusive, final int endIndexExclusive) {
        if (array == null) {
            return;
        }
        int i = startIndexInclusive < 0 ? 0 : startIndexInclusive;
        int j = Math.min(array.length, endIndexExclusive) - 1;
        Object tmp;
        while (j > i) {
            tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
            j--;
            i++;
        }
    }

    /**
     * <p>
     * Reverses the order of the given array in the given range.
     *
     * <p>
     * This method does nothing for a {@code null} input array.
     *
     * @param array
     *            the array to reverse, may be {@code null}
     * @param startIndexInclusive
     *            the starting index. Undervalue (&lt;0) is promoted to 0, overvalue (&gt;array.length) results in no
     *            change.
     * @param endIndexExclusive
     *            elements up to endIndex-1 are reversed in the array. Undervalue (&lt; start index) results in no
     *            change. Overvalue (&gt;array.length) is demoted to array length.
     * @since 3.2
     */
    public static void reverse(final short[] array, final int startIndexInclusive, final int endIndexExclusive) {
        if (array == null) {
            return;
        }
        int i = startIndexInclusive < 0 ? 0 : startIndexInclusive;
        int j = Math.min(array.length, endIndexExclusive) - 1;
        short tmp;
        while (j > i) {
            tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
            j--;
            i++;
        }
    }

    // Swap
    //-----------------------------------------------------------------------
    /**
     * Swaps two elements in the given array.
     *
     * <p>There is no special handling for multi-dimensional arrays. This method
     * does nothing for a {@code null} or empty input array or for overflow indices.
     * Negative indices are promoted to 0(zero).</p>
     *
     * Examples:
     * <ul>
     *     <li>ArrayUtils.swap(["1", "2", "3"], 0, 2) -&gt; ["3", "2", "1"]</li>
     *     <li>ArrayUtils.swap(["1", "2", "3"], 0, 0) -&gt; ["1", "2", "3"]</li>
     *     <li>ArrayUtils.swap(["1", "2", "3"], 1, 0) -&gt; ["2", "1", "3"]</li>
     *     <li>ArrayUtils.swap(["1", "2", "3"], 0, 5) -&gt; ["1", "2", "3"]</li>
     *     <li>ArrayUtils.swap(["1", "2", "3"], -1, 1) -&gt; ["2", "1", "3"]</li>
     * </ul>
     *
     * @param array the array to swap, may be {@code null}
     * @param offset1 the index of the first element to swap
     * @param offset2 the index of the second element to swap
     * @since 3.5
     */
    public static void swap(final Object[] array, int offset1, int offset2) {
        if (array == null || array.length == 0) {
            return;
        }
        swap(array, offset1, offset2, 1);
    }

    /**
     * Swaps two elements in the given long array.
     *
     * <p>There is no special handling for multi-dimensional arrays. This method
     * does nothing for a {@code null} or empty input array or for overflow indices.
     * Negative indices are promoted to 0(zero).</p>
     *
     * Examples:
     * <ul>
     *     <li>ArrayUtils.swap([true, false, true], 0, 2) -&gt; [true, false, true]</li>
     *     <li>ArrayUtils.swap([true, false, true], 0, 0) -&gt; [true, false, true]</li>
     *     <li>ArrayUtils.swap([true, false, true], 1, 0) -&gt; [false, true, true]</li>
     *     <li>ArrayUtils.swap([true, false, true], 0, 5) -&gt; [true, false, true]</li>
     *     <li>ArrayUtils.swap([true, false, true], -1, 1) -&gt; [false, true, true]</li>
     * </ul>
     *
     *
     * @param array  the array to swap, may be {@code null}
     * @param offset1 the index of the first element to swap
     * @param offset2 the index of the second element to swap
     * @since 3.5
     */
    public static void swap(final long[] array, int offset1, int offset2) {
        if (array == null || array.length == 0) {
            return;
        }
        swap(array, offset1, offset2, 1);
    }

    /**
     * Swaps two elements in the given int array.
     *
     * <p>There is no special handling for multi-dimensional arrays. This method
     * does nothing for a {@code null} or empty input array or for overflow indices.
     * Negative indices are promoted to 0(zero).</p>
     *
     * Examples:
     * <ul>
     *     <li>ArrayUtils.swap([1, 2, 3], 0, 2) -&gt; [3, 2, 1]</li>
     *     <li>ArrayUtils.swap([1, 2, 3], 0, 0) -&gt; [1, 2, 3]</li>
     *     <li>ArrayUtils.swap([1, 2, 3], 1, 0) -&gt; [2, 1, 3]</li>
     *     <li>ArrayUtils.swap([1, 2, 3], 0, 5) -&gt; [1, 2, 3]</li>
     *     <li>ArrayUtils.swap([1, 2, 3], -1, 1) -&gt; [2, 1, 3]</li>
     * </ul>
     *
     * @param array  the array to swap, may be {@code null}
     * @param offset1 the index of the first element to swap
     * @param offset2 the index of the second element to swap
     * @since 3.5
     */
    public static void swap(final int[] array, int offset1, int offset2) {
        if (array == null || array.length == 0) {
            return;
        }
        swap(array, offset1, offset2, 1);
    }

    /**
     * Swaps two elements in the given short array.
     *
     * <p>There is no special handling for multi-dimensional arrays. This method
     * does nothing for a {@code null} or empty input array or for overflow indices.
     * Negative indices are promoted to 0(zero).</p>
     *
     * Examples:
     * <ul>
     *     <li>ArrayUtils.swap([1, 2, 3], 0, 2) -&gt; [3, 2, 1]</li>
     *     <li>ArrayUtils.swap([1, 2, 3], 0, 0) -&gt; [1, 2, 3]</li>
     *     <li>ArrayUtils.swap([1, 2, 3], 1, 0) -&gt; [2, 1, 3]</li>
     *     <li>ArrayUtils.swap([1, 2, 3], 0, 5) -&gt; [1, 2, 3]</li>
     *     <li>ArrayUtils.swap([1, 2, 3], -1, 1) -&gt; [2, 1, 3]</li>
     * </ul>
     *
     * @param array  the array to swap, may be {@code null}
     * @param offset1 the index of the first element to swap
     * @param offset2 the index of the second element to swap
     * @since 3.5
     */
    public static void swap(final short[] array, int offset1, int offset2) {
        if (array == null || array.length == 0) {
            return;
        }
        swap(array, offset1, offset2, 1);
    }

    /**
     * Swaps two elements in the given char array.
     *
     * <p>There is no special handling for multi-dimensional arrays. This method
     * does nothing for a {@code null} or empty input array or for overflow indices.
     * Negative indices are promoted to 0(zero).</p>
     *
     * Examples:
     * <ul>
     *     <li>ArrayUtils.swap([1, 2, 3], 0, 2) -&gt; [3, 2, 1]</li>
     *     <li>ArrayUtils.swap([1, 2, 3], 0, 0) -&gt; [1, 2, 3]</li>
     *     <li>ArrayUtils.swap([1, 2, 3], 1, 0) -&gt; [2, 1, 3]</li>
     *     <li>ArrayUtils.swap([1, 2, 3], 0, 5) -&gt; [1, 2, 3]</li>
     *     <li>ArrayUtils.swap([1, 2, 3], -1, 1) -&gt; [2, 1, 3]</li>
     * </ul>
     *
     * @param array  the array to swap, may be {@code null}
     * @param offset1 the index of the first element to swap
     * @param offset2 the index of the second element to swap
     * @since 3.5
     */
    public static void swap(final char[] array, int offset1, int offset2) {
        if (array == null || array.length == 0) {
            return;
        }
        swap(array, offset1, offset2, 1);
    }

    /**
     * Swaps two elements in the given byte array.
     *
     * <p>There is no special handling for multi-dimensional arrays. This method
     * does nothing for a {@code null} or empty input array or for overflow indices.
     * Negative indices are promoted to 0(zero).</p>
     *
     * Examples:
     * <ul>
     *     <li>ArrayUtils.swap([1, 2, 3], 0, 2) -&gt; [3, 2, 1]</li>
     *     <li>ArrayUtils.swap([1, 2, 3], 0, 0) -&gt; [1, 2, 3]</li>
     *     <li>ArrayUtils.swap([1, 2, 3], 1, 0) -&gt; [2, 1, 3]</li>
     *     <li>ArrayUtils.swap([1, 2, 3], 0, 5) -&gt; [1, 2, 3]</li>
     *     <li>ArrayUtils.swap([1, 2, 3], -1, 1) -&gt; [2, 1, 3]</li>
     * </ul>
     *
     * @param array  the array to swap, may be {@code null}
     * @param offset1 the index of the first element to swap
     * @param offset2 the index of the second element to swap
     * @since 3.5
     */
    public static void swap(final byte[] array, int offset1, int offset2) {
        if (array == null || array.length == 0) {
            return;
        }
        swap(array, offset1, offset2, 1);
    }

    /**
     * Swaps two elements in the given double array.
     *
     * <p>There is no special handling for multi-dimensional arrays. This method
     * does nothing for a {@code null} or empty input array or for overflow indices.
     * Negative indices are promoted to 0(zero).</p>
     *
     * Examples:
     * <ul>
     *     <li>ArrayUtils.swap([1, 2, 3], 0, 2) -&gt; [3, 2, 1]</li>
     *     <li>ArrayUtils.swap([1, 2, 3], 0, 0) -&gt; [1, 2, 3]</li>
     *     <li>ArrayUtils.swap([1, 2, 3], 1, 0) -&gt; [2, 1, 3]</li>
     *     <li>ArrayUtils.swap([1, 2, 3], 0, 5) -&gt; [1, 2, 3]</li>
     *     <li>ArrayUtils.swap([1, 2, 3], -1, 1) -&gt; [2, 1, 3]</li>
     * </ul>
     *
     * @param array  the array to swap, may be {@code null}
     * @param offset1 the index of the first element to swap
     * @param offset2 the index of the second element to swap
     * @since 3.5
     */
    public static void swap(final double[] array, int offset1, int offset2) {
        if (array == null || array.length == 0) {
            return;
        }
        swap(array, offset1, offset2, 1);
    }

    /**
     * Swaps two elements in the given float array.
     *
     * <p>There is no special handling for multi-dimensional arrays. This method
     * does nothing for a {@code null} or empty input array or for overflow indices.
     * Negative indices are promoted to 0(zero).</p>
     *
     * Examples:
     * <ul>
     *     <li>ArrayUtils.swap([1, 2, 3], 0, 2) -&gt; [3, 2, 1]</li>
     *     <li>ArrayUtils.swap([1, 2, 3], 0, 0) -&gt; [1, 2, 3]</li>
     *     <li>ArrayUtils.swap([1, 2, 3], 1, 0) -&gt; [2, 1, 3]</li>
     *     <li>ArrayUtils.swap([1, 2, 3], 0, 5) -&gt; [1, 2, 3]</li>
     *     <li>ArrayUtils.swap([1, 2, 3], -1, 1) -&gt; [2, 1, 3]</li>
     * </ul>
     *
     * @param array  the array to swap, may be {@code null}
     * @param offset1 the index of the first element to swap
     * @param offset2 the index of the second element to swap
     * @since 3.5
     */
    public static void swap(final float[] array, int offset1, int offset2) {
        if (array == null || array.length == 0) {
            return;
        }
        swap(array, offset1, offset2, 1);
    }

    /**
     * Swaps two elements in the given boolean array.
     *
     * <p>There is no special handling for multi-dimensional arrays. This method
     * does nothing for a {@code null} or empty input array or for overflow indices.
     * Negative indices are promoted to 0(zero).</p>
     *
     * Examples:
     * <ul>
     *     <li>ArrayUtils.swap([1, 2, 3], 0, 2) -&gt; [3, 2, 1]</li>
     *     <li>ArrayUtils.swap([1, 2, 3], 0, 0) -&gt; [1, 2, 3]</li>
     *     <li>ArrayUtils.swap([1, 2, 3], 1, 0) -&gt; [2, 1, 3]</li>
     *     <li>ArrayUtils.swap([1, 2, 3], 0, 5) -&gt; [1, 2, 3]</li>
     *     <li>ArrayUtils.swap([1, 2, 3], -1, 1) -&gt; [2, 1, 3]</li>
     * </ul>
     *
     * @param array  the array to swap, may be {@code null}
     * @param offset1 the index of the first element to swap
     * @param offset2 the index of the second element to swap
     * @since 3.5
     */
    public static void swap(final boolean[] array, int offset1, int offset2) {
        if (array == null || array.length == 0) {
            return;
        }
        swap(array, offset1, offset2, 1);
    }

    /**
     * Swaps a series of elements in the given boolean array.
     *
     * <p>This method does nothing for a {@code null} or empty input array or
     * for overflow indices. Negative indices are promoted to 0(zero). If any
     * of the sub-arrays to swap falls outside of the given array, then the
     * swap is stopped at the end of the array and as many as possible elements
     * are swapped.</p>
     *
     * Examples:
     * <ul>
     *     <li>ArrayUtils.swap([true, false, true, false], 0, 2, 1) -&gt; [true, false, true, false]</li>
     *     <li>ArrayUtils.swap([true, false, true, false], 0, 0, 1) -&gt; [true, false, true, false]</li>
     *     <li>ArrayUtils.swap([true, false, true, false], 0, 2, 2) -&gt; [true, false, true, false]</li>
     *     <li>ArrayUtils.swap([true, false, true, false], -3, 2, 2) -&gt; [true, false, true, false]</li>
     *     <li>ArrayUtils.swap([true, false, true, false], 0, 3, 3) -&gt; [false, false, true, true]</li>
     * </ul>
     *
     * @param array the array to swap, may be {@code null}
     * @param offset1 the index of the first element in the series to swap
     * @param offset2 the index of the second element in the series to swap
     * @param len the number of elements to swap starting with the given indices
     * @since 3.5
     */
    public static void swap(final boolean[] array, int offset1, int offset2, int len) {
        if (array == null || array.length == 0 || offset1 >= array.length || offset2 >= array.length) {
            return;
        }
        if (offset1 < 0) {
            offset1 = 0;
        }
        if (offset2 < 0) {
            offset2 = 0;
        }
        len = Math.min(Math.min(len, array.length - offset1), array.length - offset2);
        for (int i = 0; i < len; i++, offset1++, offset2++) {
            boolean aux = array[offset1];
            array[offset1] = array[offset2];
            array[offset2] = aux;
        }
    }

    /**
     * Swaps a series of elements in the given byte array.
     *
     * <p>This method does nothing for a {@code null} or empty input array or
     * for overflow indices. Negative indices are promoted to 0(zero). If any
     * of the sub-arrays to swap falls outside of the given array, then the
     * swap is stopped at the end of the array and as many as possible elements
     * are swapped.</p>
     *
     * Examples:
     * <ul>
     *     <li>ArrayUtils.swap([1, 2, 3, 4], 0, 2, 1) -&gt; [3, 2, 1, 4]</li>
     *     <li>ArrayUtils.swap([1, 2, 3, 4], 0, 0, 1) -&gt; [1, 2, 3, 4]</li>
     *     <li>ArrayUtils.swap([1, 2, 3, 4], 2, 0, 2) -&gt; [3, 4, 1, 2]</li>
     *     <li>ArrayUtils.swap([1, 2, 3, 4], -3, 2, 2) -&gt; [3, 4, 1, 2]</li>
     *     <li>ArrayUtils.swap([1, 2, 3, 4], 0, 3, 3) -&gt; [4, 2, 3, 1]</li>
     * </ul>
     *
     * @param array the array to swap, may be {@code null}
     * @param offset1 the index of the first element in the series to swap
     * @param offset2 the index of the second element in the series to swap
     * @param len the number of elements to swap starting with the given indices
     * @since 3.5
     */
    public static void swap(final byte[] array, int offset1, int offset2, int len) {
        if (array == null || array.length == 0 || offset1 >= array.length || offset2 >= array.length) {
            return;
        }
        if (offset1 < 0) {
            offset1 = 0;
        }
        if (offset2 < 0) {
            offset2 = 0;
        }
        len = Math.min(Math.min(len, array.length - offset1), array.length - offset2);
        for (int i = 0; i < len; i++, offset1++, offset2++) {
            byte aux = array[offset1];
            array[offset1] = array[offset2];
            array[offset2] = aux;
        }
    }

    /**
     * Swaps a series of elements in the given char array.
     *
     * <p>This method does nothing for a {@code null} or empty input array or
     * for overflow indices. Negative indices are promoted to 0(zero). If any
     * of the sub-arrays to swap falls outside of the given array, then the
     * swap is stopped at the end of the array and as many as possible elements
     * are swapped.</p>
     *
     * Examples:
     * <ul>
     *     <li>ArrayUtils.swap([1, 2, 3, 4], 0, 2, 1) -&gt; [3, 2, 1, 4]</li>
     *     <li>ArrayUtils.swap([1, 2, 3, 4], 0, 0, 1) -&gt; [1, 2, 3, 4]</li>
     *     <li>ArrayUtils.swap([1, 2, 3, 4], 2, 0, 2) -&gt; [3, 4, 1, 2]</li>
     *     <li>ArrayUtils.swap([1, 2, 3, 4], -3, 2, 2) -&gt; [3, 4, 1, 2]</li>
     *     <li>ArrayUtils.swap([1, 2, 3, 4], 0, 3, 3) -&gt; [4, 2, 3, 1]</li>
     * </ul>
     *
     * @param array the array to swap, may be {@code null}
     * @param offset1 the index of the first element in the series to swap
     * @param offset2 the index of the second element in the series to swap
     * @param len the number of elements to swap starting with the given indices
     * @since 3.5
     */
    public static void swap(final char[] array, int offset1, int offset2, int len) {
        if (array == null || array.length == 0 || offset1 >= array.length || offset2 >= array.length) {
            return;
        }
        if (offset1 < 0) {
            offset1 = 0;
        }
        if (offset2 < 0) {
            offset2 = 0;
        }
        len = Math.min(Math.min(len, array.length - offset1), array.length - offset2);
        for (int i = 0; i < len; i++, offset1++, offset2++) {
            char aux = array[offset1];
            array[offset1] = array[offset2];
            array[offset2] = aux;
        }
    }

    /**
     * Swaps a series of elements in the given double array.
     *
     * <p>This method does nothing for a {@code null} or empty input array or
     * for overflow indices. Negative indices are promoted to 0(zero). If any
     * of the sub-arrays to swap falls outside of the given array, then the
     * swap is stopped at the end of the array and as many as possible elements
     * are swapped.</p>
     *
     * Examples:
     * <ul>
     *     <li>ArrayUtils.swap([1, 2, 3, 4], 0, 2, 1) -&gt; [3, 2, 1, 4]</li>
     *     <li>ArrayUtils.swap([1, 2, 3, 4], 0, 0, 1) -&gt; [1, 2, 3, 4]</li>
     *     <li>ArrayUtils.swap([1, 2, 3, 4], 2, 0, 2) -&gt; [3, 4, 1, 2]</li>
     *     <li>ArrayUtils.swap([1, 2, 3, 4], -3, 2, 2) -&gt; [3, 4, 1, 2]</li>
     *     <li>ArrayUtils.swap([1, 2, 3, 4], 0, 3, 3) -&gt; [4, 2, 3, 1]</li>
     * </ul>
     *
     * @param array the array to swap, may be {@code null}
     * @param offset1 the index of the first element in the series to swap
     * @param offset2 the index of the second element in the series to swap
     * @param len the number of elements to swap starting with the given indices
     * @since 3.5
     */
    public static void swap(final double[] array,  int offset1, int offset2, int len) {
        if (array == null || array.length == 0 || offset1 >= array.length || offset2 >= array.length) {
            return;
        }
        if (offset1 < 0) {
            offset1 = 0;
        }
        if (offset2 < 0) {
            offset2 = 0;
        }
        len = Math.min(Math.min(len, array.length - offset1), array.length - offset2);
        for (int i = 0; i < len; i++, offset1++, offset2++) {
            double aux = array[offset1];
            array[offset1] = array[offset2];
            array[offset2] = aux;
        }
    }

    /**
     * Swaps a series of elements in the given float array.
     *
     * <p>This method does nothing for a {@code null} or empty input array or
     * for overflow indices. Negative indices are promoted to 0(zero). If any
     * of the sub-arrays to swap falls outside of the given array, then the
     * swap is stopped at the end of the array and as many as possible elements
     * are swapped.</p>
     *
     * Examples:
     * <ul>
     *     <li>ArrayUtils.swap([1, 2, 3, 4], 0, 2, 1) -&gt; [3, 2, 1, 4]</li>
     *     <li>ArrayUtils.swap([1, 2, 3, 4], 0, 0, 1) -&gt; [1, 2, 3, 4]</li>
     *     <li>ArrayUtils.swap([1, 2, 3, 4], 2, 0, 2) -&gt; [3, 4, 1, 2]</li>
     *     <li>ArrayUtils.swap([1, 2, 3, 4], -3, 2, 2) -&gt; [3, 4, 1, 2]</li>
     *     <li>ArrayUtils.swap([1, 2, 3, 4], 0, 3, 3) -&gt; [4, 2, 3, 1]</li>
     * </ul>
     *
     * @param array the array to swap, may be {@code null}
     * @param offset1 the index of the first element in the series to swap
     * @param offset2 the index of the second element in the series to swap
     * @param len the number of elements to swap starting with the given indices
     * @since 3.5
     */
    public static void swap(final float[] array, int offset1, int offset2, int len) {
        if (array == null || array.length == 0 || offset1 >= array.length || offset2 >= array.length) {
            return;
        }
        if (offset1 < 0) {
            offset1 = 0;
        }
        if (offset2 < 0) {
            offset2 = 0;
        }
        len = Math.min(Math.min(len, array.length - offset1), array.length - offset2);
        for (int i = 0; i < len; i++, offset1++, offset2++) {
            float aux = array[offset1];
            array[offset1] = array[offset2];
            array[offset2] = aux;
        }

    }

    /**
     * Swaps a series of elements in the given int array.
     *
     * <p>This method does nothing for a {@code null} or empty input array or
     * for overflow indices. Negative indices are promoted to 0(zero). If any
     * of the sub-arrays to swap falls outside of the given array, then the
     * swap is stopped at the end of the array and as many as possible elements
     * are swapped.</p>
     *
     * Examples:
     * <ul>
     *     <li>ArrayUtils.swap([1, 2, 3, 4], 0, 2, 1) -&gt; [3, 2, 1, 4]</li>
     *     <li>ArrayUtils.swap([1, 2, 3, 4], 0, 0, 1) -&gt; [1, 2, 3, 4]</li>
     *     <li>ArrayUtils.swap([1, 2, 3, 4], 2, 0, 2) -&gt; [3, 4, 1, 2]</li>
     *     <li>ArrayUtils.swap([1, 2, 3, 4], -3, 2, 2) -&gt; [3, 4, 1, 2]</li>
     *     <li>ArrayUtils.swap([1, 2, 3, 4], 0, 3, 3) -&gt; [4, 2, 3, 1]</li>
     * </ul>
     *
     * @param array the array to swap, may be {@code null}
     * @param offset1 the index of the first element in the series to swap
     * @param offset2 the index of the second element in the series to swap
     * @param len the number of elements to swap starting with the given indices
     * @since 3.5
     */
    public static void swap(final int[] array,  int offset1, int offset2, int len) {
        if (array == null || array.length == 0 || offset1 >= array.length || offset2 >= array.length) {
            return;
        }
        if (offset1 < 0) {
            offset1 = 0;
        }
        if (offset2 < 0) {
            offset2 = 0;
        }
        len = Math.min(Math.min(len, array.length - offset1), array.length - offset2);
        for (int i = 0; i < len; i++, offset1++, offset2++) {
            int aux = array[offset1];
            array[offset1] = array[offset2];
            array[offset2] = aux;
        }
    }

    /**
     * Swaps a series of elements in the given long array.
     *
     * <p>This method does nothing for a {@code null} or empty input array or
     * for overflow indices. Negative indices are promoted to 0(zero). If any
     * of the sub-arrays to swap falls outside of the given array, then the
     * swap is stopped at the end of the array and as many as possible elements
     * are swapped.</p>
     *
     * Examples:
     * <ul>
     *     <li>ArrayUtils.swap([1, 2, 3, 4], 0, 2, 1) -&gt; [3, 2, 1, 4]</li>
     *     <li>ArrayUtils.swap([1, 2, 3, 4], 0, 0, 1) -&gt; [1, 2, 3, 4]</li>
     *     <li>ArrayUtils.swap([1, 2, 3, 4], 2, 0, 2) -&gt; [3, 4, 1, 2]</li>
     *     <li>ArrayUtils.swap([1, 2, 3, 4], -3, 2, 2) -&gt; [3, 4, 1, 2]</li>
     *     <li>ArrayUtils.swap([1, 2, 3, 4], 0, 3, 3) -&gt; [4, 2, 3, 1]</li>
     * </ul>
     *
     * @param array the array to swap, may be {@code null}
     * @param offset1 the index of the first element in the series to swap
     * @param offset2 the index of the second element in the series to swap
     * @param len the number of elements to swap starting with the given indices
     * @since 3.5
     */
    public static void swap(final long[] array,  int offset1, int offset2, int len) {
        if (array == null || array.length == 0 || offset1 >= array.length || offset2 >= array.length) {
            return;
        }
        if (offset1 < 0) {
            offset1 = 0;
        }
        if (offset2 < 0) {
            offset2 = 0;
        }
        len = Math.min(Math.min(len, array.length - offset1), array.length - offset2);
        for (int i = 0; i < len; i++, offset1++, offset2++) {
            long aux = array[offset1];
            array[offset1] = array[offset2];
            array[offset2] = aux;
        }
    }

    /**
     * Swaps a series of elements in the given array.
     *
     * <p>This method does nothing for a {@code null} or empty input array or
     * for overflow indices. Negative indices are promoted to 0(zero). If any
     * of the sub-arrays to swap falls outside of the given array, then the
     * swap is stopped at the end of the array and as many as possible elements
     * are swapped.</p>
     *
     * Examples:
     * <ul>
     *     <li>ArrayUtils.swap(["1", "2", "3", "4"], 0, 2, 1) -&gt; ["3", "2", "1", "4"]</li>
     *     <li>ArrayUtils.swap(["1", "2", "3", "4"], 0, 0, 1) -&gt; ["1", "2", "3", "4"]</li>
     *     <li>ArrayUtils.swap(["1", "2", "3", "4"], 2, 0, 2) -&gt; ["3", "4", "1", "2"]</li>
     *     <li>ArrayUtils.swap(["1", "2", "3", "4"], -3, 2, 2) -&gt; ["3", "4", "1", "2"]</li>
     *     <li>ArrayUtils.swap(["1", "2", "3", "4"], 0, 3, 3) -&gt; ["4", "2", "3", "1"]</li>
     * </ul>
     *
     * @param array the array to swap, may be {@code null}
     * @param offset1 the index of the first element in the series to swap
     * @param offset2 the index of the second element in the series to swap
     * @param len the number of elements to swap starting with the given indices
     * @since 3.5
     */
    public static void swap(final Object[] array,  int offset1, int offset2, int len) {
        if (array == null || array.length == 0 || offset1 >= array.length || offset2 >= array.length) {
            return;
        }
        if (offset1 < 0) {
            offset1 = 0;
        }
        if (offset2 < 0) {
            offset2 = 0;
        }
        len = Math.min(Math.min(len, array.length - offset1), array.length - offset2);
        for (int i = 0; i < len; i++, offset1++, offset2++) {
            Object aux = array[offset1];
            array[offset1] = array[offset2];
            array[offset2] = aux;
        }
    }

    /**
     * Swaps a series of elements in the given short array.
     *
     * <p>This method does nothing for a {@code null} or empty input array or
     * for overflow indices. Negative indices are promoted to 0(zero). If any
     * of the sub-arrays to swap falls outside of the given array, then the
     * swap is stopped at the end of the array and as many as possible elements
     * are swapped.</p>
     *
     * Examples:
     * <ul>
     *     <li>ArrayUtils.swap([1, 2, 3, 4], 0, 2, 1) -&gt; [3, 2, 1, 4]</li>
     *     <li>ArrayUtils.swap([1, 2, 3, 4], 0, 0, 1) -&gt; [1, 2, 3, 4]</li>
     *     <li>ArrayUtils.swap([1, 2, 3, 4], 2, 0, 2) -&gt; [3, 4, 1, 2]</li>
     *     <li>ArrayUtils.swap([1, 2, 3, 4], -3, 2, 2) -&gt; [3, 4, 1, 2]</li>
     *     <li>ArrayUtils.swap([1, 2, 3, 4], 0, 3, 3) -&gt; [4, 2, 3, 1]</li>
     * </ul>
     *
     * @param array the array to swap, may be {@code null}
     * @param offset1 the index of the first element in the series to swap
     * @param offset2 the index of the second element in the series to swap
     * @param len the number of elements to swap starting with the given indices
     * @since 3.5
     */
    public static void swap(final short[] array,  int offset1, int offset2, int len) {
        if (array == null || array.length == 0 || offset1 >= array.length || offset2 >= array.length) {
            return;
        }
        if (offset1 < 0) {
            offset1 = 0;
        }
        if (offset2 < 0) {
            offset2 = 0;
        }
        if (offset1 == offset2) {
            return;
        }
        len = Math.min(Math.min(len, array.length - offset1), array.length - offset2);
        for (int i = 0; i < len; i++, offset1++, offset2++) {
            short aux = array[offset1];
            array[offset1] = array[offset2];
            array[offset2] = aux;
        }
    }

    // Shift
    //-----------------------------------------------------------------------
    /**
     * Shifts the order of the given array.
     *
     * <p>There is no special handling for multi-dimensional arrays. This method
     * does nothing for {@code null} or empty input arrays.</p>
     *
     * @param array  the array to shift, may be {@code null}
     * @param offset
     *          The number of positions to rotate the elements.  If the offset is larger than the number of elements to
     *          rotate, than the effective offset is modulo the number of elements to rotate.
     * @since 3.5
     */
    public static void shift(final Object[] array, int offset) {
        if (array == null) {
            return;
        }
        shift(array, 0, array.length, offset);
    }

    /**
     * Shifts the order of the given long array.
     *
     * <p>There is no special handling for multi-dimensional arrays. This method
     * does nothing for {@code null} or empty input arrays.</p>
     *
     * @param array  the array to shift, may be {@code null}
     * @param offset
     *          The number of positions to rotate the elements.  If the offset is larger than the number of elements to
     *          rotate, than the effective offset is modulo the number of elements to rotate.
     * @since 3.5
     */
    public static void shift(final long[] array, int offset) {
        if (array == null) {
            return;
        }
        shift(array, 0, array.length, offset);
    }

    /**
     * Shifts the order of the given int array.
     *
     * <p>There is no special handling for multi-dimensional arrays. This method
     * does nothing for {@code null} or empty input arrays.</p>
     *
     * @param array  the array to shift, may be {@code null}
     * @param offset
     *          The number of positions to rotate the elements.  If the offset is larger than the number of elements to
     *          rotate, than the effective offset is modulo the number of elements to rotate.
     * @since 3.5
     */
    public static void shift(final int[] array, int offset) {
        if (array == null) {
            return;
        }
        shift(array, 0, array.length, offset);
    }

    /**
     * Shifts the order of the given short array.
     *
     * <p>There is no special handling for multi-dimensional arrays. This method
     * does nothing for {@code null} or empty input arrays.</p>
     *
     * @param array  the array to shift, may be {@code null}
     * @param offset
     *          The number of positions to rotate the elements.  If the offset is larger than the number of elements to
     *          rotate, than the effective offset is modulo the number of elements to rotate.
     * @since 3.5
     */
    public static void shift(final short[] array, int offset) {
        if (array == null) {
            return;
        }
        shift(array, 0, array.length, offset);
    }

    /**
     * Shifts the order of the given char array.
     *
     * <p>There is no special handling for multi-dimensional arrays. This method
     * does nothing for {@code null} or empty input arrays.</p>
     *
     * @param array  the array to shift, may be {@code null}
     * @param offset
     *          The number of positions to rotate the elements.  If the offset is larger than the number of elements to
     *          rotate, than the effective offset is modulo the number of elements to rotate.
     * @since 3.5
     */
    public static void shift(final char[] array, int offset) {
        if (array == null) {
            return;
        }
        shift(array, 0, array.length, offset);
    }

    /**
     * Shifts the order of the given byte array.
     *
     * <p>There is no special handling for multi-dimensional arrays. This method
     * does nothing for {@code null} or empty input arrays.</p>
     *
     * @param array  the array to shift, may be {@code null}
     * @param offset
     *          The number of positions to rotate the elements.  If the offset is larger than the number of elements to
     *          rotate, than the effective offset is modulo the number of elements to rotate.
     * @since 3.5
     */
    public static void shift(final byte[] array, int offset) {
        if (array == null) {
            return;
        }
        shift(array, 0, array.length, offset);
    }

    /**
     * Shifts the order of the given double array.
     *
     * <p>There is no special handling for multi-dimensional arrays. This method
     * does nothing for {@code null} or empty input arrays.</p>
     *
     * @param array  the array to shift, may be {@code null}
     * @param offset
     *          The number of positions to rotate the elements.  If the offset is larger than the number of elements to
     *          rotate, than the effective offset is modulo the number of elements to rotate.
     * @since 3.5
     */
    public static void shift(final double[] array, int offset) {
        if (array == null) {
            return;
        }
        shift(array, 0, array.length, offset);
    }

    /**
     * Shifts the order of the given float array.
     *
     * <p>There is no special handling for multi-dimensional arrays. This method
     * does nothing for {@code null} or empty input arrays.</p>
     *
     * @param array  the array to shift, may be {@code null}
     * @param offset
     *          The number of positions to rotate the elements.  If the offset is larger than the number of elements to
     *          rotate, than the effective offset is modulo the number of elements to rotate.
     * @since 3.5
     */
    public static void shift(final float[] array, int offset) {
        if (array == null) {
            return;
        }
        shift(array, 0, array.length, offset);
    }

    /**
     * Shifts the order of the given boolean array.
     *
     * <p>There is no special handling for multi-dimensional arrays. This method
     * does nothing for {@code null} or empty input arrays.</p>
     *
     * @param array  the array to shift, may be {@code null}
     * @param offset
     *          The number of positions to rotate the elements.  If the offset is larger than the number of elements to
     *          rotate, than the effective offset is modulo the number of elements to rotate.
     * @since 3.5
     */
    public static void shift(final boolean[] array, int offset) {
        if (array == null) {
            return;
        }
        shift(array, 0, array.length, offset);
    }

    /**
     * Shifts the order of a series of elements in the given boolean array.
     *
     * <p>There is no special handling for multi-dimensional arrays. This method
     * does nothing for {@code null} or empty input arrays.</p>
     *
     * @param array
     *            the array to shift, may be {@code null}
     * @param startIndexInclusive
     *            the starting index. Undervalue (&lt;0) is promoted to 0, overvalue (&gt;array.length) results in no
     *            change.
     * @param endIndexExclusive
     *            elements up to endIndex-1 are shiftd in the array. Undervalue (&lt; start index) results in no
     *            change. Overvalue (&gt;array.length) is demoted to array length.
     * @param offset
     *          The number of positions to rotate the elements.  If the offset is larger than the number of elements to
     *          rotate, than the effective offset is modulo the number of elements to rotate.
     * @since 3.5
     */
    public static void shift(final boolean[] array, int startIndexInclusive, int endIndexExclusive, int offset) {
        if (array == null) {
            return;
        }
        if (startIndexInclusive >= array.length - 1 || endIndexExclusive <= 0) {
            return;
        }
        if (startIndexInclusive < 0) {
            startIndexInclusive = 0;
        }
        if (endIndexExclusive >= array.length) {
            endIndexExclusive = array.length;
        }
        int n = endIndexExclusive - startIndexInclusive;
        if (n <= 1) {
            return;
        }
        offset %= n;
        if (offset < 0) {
            offset += n;
        }
        // For algorithm explanations and proof of O(n) time complexity and O(1) space complexity
        // see https://beradrian.wordpress.com/2015/04/07/shift-an-array-in-on-in-place/
        while (n > 1 && offset > 0) {
            int n_offset = n - offset;

            if (offset > n_offset) {
                swap(array, startIndexInclusive, startIndexInclusive + n - n_offset,  n_offset);
                n = offset;
                offset -= n_offset;
            } else if (offset < n_offset) {
                swap(array, startIndexInclusive, startIndexInclusive + n_offset,  offset);
                startIndexInclusive += offset;
                n = n_offset;
            } else {
                swap(array, startIndexInclusive, startIndexInclusive + n_offset, offset);
                break;
            }
        }
    }

    /**
     * Shifts the order of a series of elements in the given byte array.
     *
     * <p>There is no special handling for multi-dimensional arrays. This method
     * does nothing for {@code null} or empty input arrays.</p>
     *
     * @param array
     *            the array to shift, may be {@code null}
     * @param startIndexInclusive
     *            the starting index. Undervalue (&lt;0) is promoted to 0, overvalue (&gt;array.length) results in no
     *            change.
     * @param endIndexExclusive
     *            elements up to endIndex-1 are shiftd in the array. Undervalue (&lt; start index) results in no
     *            change. Overvalue (&gt;array.length) is demoted to array length.
     * @param offset
     *          The number of positions to rotate the elements.  If the offset is larger than the number of elements to
     *          rotate, than the effective offset is modulo the number of elements to rotate.
     * @since 3.5
     */
    public static void shift(final byte[] array, int startIndexInclusive, int endIndexExclusive, int offset) {
        if (array == null) {
            return;
        }
        if (startIndexInclusive >= array.length - 1 || endIndexExclusive <= 0) {
            return;
        }
        if (startIndexInclusive < 0) {
            startIndexInclusive = 0;
        }
        if (endIndexExclusive >= array.length) {
            endIndexExclusive = array.length;
        }
        int n = endIndexExclusive - startIndexInclusive;
        if (n <= 1) {
            return;
        }
        offset %= n;
        if (offset < 0) {
            offset += n;
        }
        // For algorithm explanations and proof of O(n) time complexity and O(1) space complexity
        // see https://beradrian.wordpress.com/2015/04/07/shift-an-array-in-on-in-place/
        while (n > 1 && offset > 0) {
            int n_offset = n - offset;

            if (offset > n_offset) {
                swap(array, startIndexInclusive, startIndexInclusive + n - n_offset,  n_offset);
                n = offset;
                offset -= n_offset;
            } else if (offset < n_offset) {
                swap(array, startIndexInclusive, startIndexInclusive + n_offset,  offset);
                startIndexInclusive += offset;
                n = n_offset;
            } else {
                swap(array, startIndexInclusive, startIndexInclusive + n_offset, offset);
                break;
            }
        }
    }

    /**
     * Shifts the order of a series of elements in the given char array.
     *
     * <p>There is no special handling for multi-dimensional arrays. This method
     * does nothing for {@code null} or empty input arrays.</p>
     *
     * @param array
     *            the array to shift, may be {@code null}
     * @param startIndexInclusive
     *            the starting index. Undervalue (&lt;0) is promoted to 0, overvalue (&gt;array.length) results in no
     *            change.
     * @param endIndexExclusive
     *            elements up to endIndex-1 are shiftd in the array. Undervalue (&lt; start index) results in no
     *            change. Overvalue (&gt;array.length) is demoted to array length.
     * @param offset
     *          The number of positions to rotate the elements.  If the offset is larger than the number of elements to
     *          rotate, than the effective offset is modulo the number of elements to rotate.
     * @since 3.5
     */
    public static void shift(final char[] array, int startIndexInclusive, int endIndexExclusive, int offset) {
        if (array == null) {
            return;
        }
        if (startIndexInclusive >= array.length - 1 || endIndexExclusive <= 0) {
            return;
        }
        if (startIndexInclusive < 0) {
            startIndexInclusive = 0;
        }
        if (endIndexExclusive >= array.length) {
            endIndexExclusive = array.length;
        }
        int n = endIndexExclusive - startIndexInclusive;
        if (n <= 1) {
            return;
        }
        offset %= n;
        if (offset < 0) {
            offset += n;
        }
        // For algorithm explanations and proof of O(n) time complexity and O(1) space complexity
        // see https://beradrian.wordpress.com/2015/04/07/shift-an-array-in-on-in-place/
        while (n > 1 && offset > 0) {
            int n_offset = n - offset;

            if (offset > n_offset) {
                swap(array, startIndexInclusive, startIndexInclusive + n - n_offset,  n_offset);
                n = offset;
                offset -= n_offset;
            } else if (offset < n_offset) {
                swap(array, startIndexInclusive, startIndexInclusive + n_offset,  offset);
                startIndexInclusive += offset;
                n = n_offset;
            } else {
                swap(array, startIndexInclusive, startIndexInclusive + n_offset, offset);
                break;
            }
        }
    }

    /**
     * Shifts the order of a series of elements in the given double array.
     *
     * <p>There is no special handling for multi-dimensional arrays. This method
     * does nothing for {@code null} or empty input arrays.</p>
     *
     * @param array
     *            the array to shift, may be {@code null}
     * @param startIndexInclusive
     *            the starting index. Undervalue (&lt;0) is promoted to 0, overvalue (&gt;array.length) results in no
     *            change.
     * @param endIndexExclusive
     *            elements up to endIndex-1 are shiftd in the array. Undervalue (&lt; start index) results in no
     *            change. Overvalue (&gt;array.length) is demoted to array length.
     * @param offset
     *          The number of positions to rotate the elements.  If the offset is larger than the number of elements to
     *          rotate, than the effective offset is modulo the number of elements to rotate.
     * @since 3.5
     */
    public static void shift(final double[] array, int startIndexInclusive, int endIndexExclusive, int offset) {
        if (array == null) {
            return;
        }
        if (startIndexInclusive >= array.length - 1 || endIndexExclusive <= 0) {
            return;
        }
        if (startIndexInclusive < 0) {
            startIndexInclusive = 0;
        }
        if (endIndexExclusive >= array.length) {
            endIndexExclusive = array.length;
        }
        int n = endIndexExclusive - startIndexInclusive;
        if (n <= 1) {
            return;
        }
        offset %= n;
        if (offset < 0) {
            offset += n;
        }
        // For algorithm explanations and proof of O(n) time complexity and O(1) space complexity
        // see https://beradrian.wordpress.com/2015/04/07/shift-an-array-in-on-in-place/
        while (n > 1 && offset > 0) {
            int n_offset = n - offset;

            if (offset > n_offset) {
                swap(array, startIndexInclusive, startIndexInclusive + n - n_offset,  n_offset);
                n = offset;
                offset -= n_offset;
            } else if (offset < n_offset) {
                swap(array, startIndexInclusive, startIndexInclusive + n_offset,  offset);
                startIndexInclusive += offset;
                n = n_offset;
            } else {
                swap(array, startIndexInclusive, startIndexInclusive + n_offset, offset);
                break;
            }
        }
    }

    /**
     * Shifts the order of a series of elements in the given float array.
     *
     * <p>There is no special handling for multi-dimensional arrays. This method
     * does nothing for {@code null} or empty input arrays.</p>
     *
     * @param array
     *            the array to shift, may be {@code null}
     * @param startIndexInclusive
     *            the starting index. Undervalue (&lt;0) is promoted to 0, overvalue (&gt;array.length) results in no
     *            change.
     * @param endIndexExclusive
     *            elements up to endIndex-1 are shiftd in the array. Undervalue (&lt; start index) results in no
     *            change. Overvalue (&gt;array.length) is demoted to array length.
     * @param offset
     *          The number of positions to rotate the elements.  If the offset is larger than the number of elements to
     *          rotate, than the effective offset is modulo the number of elements to rotate.
     * @since 3.5
     */
    public static void shift(final float[] array, int startIndexInclusive, int endIndexExclusive, int offset) {
        if (array == null) {
            return;
        }
        if (startIndexInclusive >= array.length - 1 || endIndexExclusive <= 0) {
            return;
        }
        if (startIndexInclusive < 0) {
            startIndexInclusive = 0;
        }
        if (endIndexExclusive >= array.length) {
            endIndexExclusive = array.length;
        }
        int n = endIndexExclusive - startIndexInclusive;
        if (n <= 1) {
            return;
        }
        offset %= n;
        if (offset < 0) {
            offset += n;
        }
        // For algorithm explanations and proof of O(n) time complexity and O(1) space complexity
        // see https://beradrian.wordpress.com/2015/04/07/shift-an-array-in-on-in-place/
        while (n > 1 && offset > 0) {
            int n_offset = n - offset;

            if (offset > n_offset) {
                swap(array, startIndexInclusive, startIndexInclusive + n - n_offset,  n_offset);
                n = offset;
                offset -= n_offset;
            } else if (offset < n_offset) {
                swap(array, startIndexInclusive, startIndexInclusive + n_offset,  offset);
                startIndexInclusive += offset;
                n = n_offset;
            } else {
                swap(array, startIndexInclusive, startIndexInclusive + n_offset, offset);
                break;
            }
        }
    }

    /**
     * Shifts the order of a series of elements in the given int array.
     *
     * <p>There is no special handling for multi-dimensional arrays. This method
     * does nothing for {@code null} or empty input arrays.</p>
     *
     * @param array
     *            the array to shift, may be {@code null}
     * @param startIndexInclusive
     *            the starting index. Undervalue (&lt;0) is promoted to 0, overvalue (&gt;array.length) results in no
     *            change.
     * @param endIndexExclusive
     *            elements up to endIndex-1 are shiftd in the array. Undervalue (&lt; start index) results in no
     *            change. Overvalue (&gt;array.length) is demoted to array length.
     * @param offset
     *          The number of positions to rotate the elements.  If the offset is larger than the number of elements to
     *          rotate, than the effective offset is modulo the number of elements to rotate.
     * @since 3.5
     */
    public static void shift(final int[] array, int startIndexInclusive, int endIndexExclusive, int offset) {
        if (array == null) {
            return;
        }
        if (startIndexInclusive >= array.length - 1 || endIndexExclusive <= 0) {
            return;
        }
        if (startIndexInclusive < 0) {
            startIndexInclusive = 0;
        }
        if (endIndexExclusive >= array.length) {
            endIndexExclusive = array.length;
        }
        int n = endIndexExclusive - startIndexInclusive;
        if (n <= 1) {
            return;
        }
        offset %= n;
        if (offset < 0) {
            offset += n;
        }
        // For algorithm explanations and proof of O(n) time complexity and O(1) space complexity
        // see https://beradrian.wordpress.com/2015/04/07/shift-an-array-in-on-in-place/
        while (n > 1 && offset > 0) {
            int n_offset = n - offset;

            if (offset > n_offset) {
                swap(array, startIndexInclusive, startIndexInclusive + n - n_offset,  n_offset);
                n = offset;
                offset -= n_offset;
            } else if (offset < n_offset) {
                swap(array, startIndexInclusive, startIndexInclusive + n_offset,  offset);
                startIndexInclusive += offset;
                n = n_offset;
            } else {
                swap(array, startIndexInclusive, startIndexInclusive + n_offset, offset);
                break;
            }
        }
    }

    /**
     * Shifts the order of a series of elements in the given long array.
     *
     * <p>There is no special handling for multi-dimensional arrays. This method
     * does nothing for {@code null} or empty input arrays.</p>
     *
     * @param array
     *            the array to shift, may be {@code null}
     * @param startIndexInclusive
     *            the starting index. Undervalue (&lt;0) is promoted to 0, overvalue (&gt;array.length) results in no
     *            change.
     * @param endIndexExclusive
     *            elements up to endIndex-1 are shiftd in the array. Undervalue (&lt; start index) results in no
     *            change. Overvalue (&gt;array.length) is demoted to array length.
     * @param offset
     *          The number of positions to rotate the elements.  If the offset is larger than the number of elements to
     *          rotate, than the effective offset is modulo the number of elements to rotate.
     * @since 3.5
     */
    public static void shift(final long[] array, int startIndexInclusive, int endIndexExclusive, int offset) {
        if (array == null) {
            return;
        }
        if (startIndexInclusive >= array.length - 1 || endIndexExclusive <= 0) {
            return;
        }
        if (startIndexInclusive < 0) {
            startIndexInclusive = 0;
        }
        if (endIndexExclusive >= array.length) {
            endIndexExclusive = array.length;
        }
        int n = endIndexExclusive - startIndexInclusive;
        if (n <= 1) {
            return;
        }
        offset %= n;
        if (offset < 0) {
            offset += n;
        }
        // For algorithm explanations and proof of O(n) time complexity and O(1) space complexity
        // see https://beradrian.wordpress.com/2015/04/07/shift-an-array-in-on-in-place/
        while (n > 1 && offset > 0) {
            int n_offset = n - offset;

            if (offset > n_offset) {
                swap(array, startIndexInclusive, startIndexInclusive + n - n_offset,  n_offset);
                n = offset;
                offset -= n_offset;
            } else if (offset < n_offset) {
                swap(array, startIndexInclusive, startIndexInclusive + n_offset,  offset);
                startIndexInclusive += offset;
                n = n_offset;
            } else {
                swap(array, startIndexInclusive, startIndexInclusive + n_offset, offset);
                break;
            }
        }
    }

    /**
     * Shifts the order of a series of elements in the given array.
     *
     * <p>There is no special handling for multi-dimensional arrays. This method
     * does nothing for {@code null} or empty input arrays.</p>
     *
     * @param array
     *            the array to shift, may be {@code null}
     * @param startIndexInclusive
     *            the starting index. Undervalue (&lt;0) is promoted to 0, overvalue (&gt;array.length) results in no
     *            change.
     * @param endIndexExclusive
     *            elements up to endIndex-1 are shiftd in the array. Undervalue (&lt; start index) results in no
     *            change. Overvalue (&gt;array.length) is demoted to array length.
     * @param offset
     *          The number of positions to rotate the elements.  If the offset is larger than the number of elements to
     *          rotate, than the effective offset is modulo the number of elements to rotate.
     * @since 3.5
     */
    public static void shift(final Object[] array, int startIndexInclusive, int endIndexExclusive, int offset) {
        if (array == null) {
            return;
        }
        if (startIndexInclusive >= array.length - 1 || endIndexExclusive <= 0) {
            return;
        }
        if (startIndexInclusive < 0) {
            startIndexInclusive = 0;
        }
        if (endIndexExclusive >= array.length) {
            endIndexExclusive = array.length;
        }
        int n = endIndexExclusive - startIndexInclusive;
        if (n <= 1) {
            return;
        }
        offset %= n;
        if (offset < 0) {
            offset += n;
        }
        // For algorithm explanations and proof of O(n) time complexity and O(1) space complexity
        // see https://beradrian.wordpress.com/2015/04/07/shift-an-array-in-on-in-place/
        while (n > 1 && offset > 0) {
            int n_offset = n - offset;

            if (offset > n_offset) {
                swap(array, startIndexInclusive, startIndexInclusive + n - n_offset,  n_offset);
                n = offset;
                offset -= n_offset;
            } else if (offset < n_offset) {
                swap(array, startIndexInclusive, startIndexInclusive + n_offset,  offset);
                startIndexInclusive += offset;
                n = n_offset;
            } else {
                swap(array, startIndexInclusive, startIndexInclusive + n_offset, offset);
                break;
            }
        }
    }

    /**
     * Shifts the order of a series of elements in the given short array.
     *
     * <p>There is no special handling for multi-dimensional arrays. This method
     * does nothing for {@code null} or empty input arrays.</p>
     *
     * @param array
     *            the array to shift, may be {@code null}
     * @param startIndexInclusive
     *            the starting index. Undervalue (&lt;0) is promoted to 0, overvalue (&gt;array.length) results in no
     *            change.
     * @param endIndexExclusive
     *            elements up to endIndex-1 are shifted in the array. Undervalue (&lt; start index) results in no
     *            change. Overvalue (&gt;array.length) is demoted to array length.
     * @param offset
     *          The number of positions to rotate the elements.  If the offset is larger than the number of elements to
     *          rotate, than the effective offset is modulo the number of elements to rotate.
     * @since 3.5
     */
    public static void shift(final short[] array, int startIndexInclusive, int endIndexExclusive, int offset) {
        if (array == null) {
            return;
        }
        if (startIndexInclusive >= array.length - 1 || endIndexExclusive <= 0) {
            return;
        }
        if (startIndexInclusive < 0) {
            startIndexInclusive = 0;
        }
        if (endIndexExclusive >= array.length) {
            endIndexExclusive = array.length;
        }
        int n = endIndexExclusive - startIndexInclusive;
        if (n <= 1) {
            return;
        }
        offset %= n;
        if (offset < 0) {
            offset += n;
        }
        // For algorithm explanations and proof of O(n) time complexity and O(1) space complexity
        // see https://beradrian.wordpress.com/2015/04/07/shift-an-array-in-on-in-place/
        while (n > 1 && offset > 0) {
            int n_offset = n - offset;

            if (offset > n_offset) {
                swap(array, startIndexInclusive, startIndexInclusive + n - n_offset,  n_offset);
                n = offset;
                offset -= n_offset;
            } else if (offset < n_offset) {
                swap(array, startIndexInclusive, startIndexInclusive + n_offset,  offset);
                startIndexInclusive += offset;
                n = n_offset;
            } else {
                swap(array, startIndexInclusive, startIndexInclusive + n_offset, offset);
                break;
            }
        }
    }

    // IndexOf search
    // ----------------------------------------------------------------------

    // Object IndexOf
    //-----------------------------------------------------------------------
    /**
     * <p>Finds the index of the given object in the array.
     *
     * <p>This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null} input array.
     *
     * @param array  the array to search through for the object, may be {@code null}
     * @param objectToFind  the object to find, may be {@code null}
     * @return the index of the object within the array,
     *  {@link #INDEX_NOT_FOUND} ({@code -1}) if not found or {@code null} array input
     */
    public static int indexOf(final Object[] array, final Object objectToFind) {
        return indexOf(array, objectToFind, 0);
    }

    /**
     * <p>Finds the index of the given object in the array starting at the given index.
     *
     * <p>This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null} input array.
     *
     * <p>A negative startIndex is treated as zero. A startIndex larger than the array
     * length will return {@link #INDEX_NOT_FOUND} ({@code -1}).
     *
     * @param array  the array to search through for the object, may be {@code null}
     * @param objectToFind  the object to find, may be {@code null}
     * @param startIndex  the index to start searching at
     * @return the index of the object within the array starting at the index,
     *  {@link #INDEX_NOT_FOUND} ({@code -1}) if not found or {@code null} array input
     */
    public static int indexOf(final Object[] array, final Object objectToFind, int startIndex) {
        if (array == null) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            startIndex = 0;
        }
        if (objectToFind == null) {
            for (int i = startIndex; i < array.length; i++) {
                if (array[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = startIndex; i < array.length; i++) {
                if (objectToFind.equals(array[i])) {
                    return i;
                }
            }
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * <p>Finds the last index of the given object within the array.
     *
     * <p>This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null} input array.
     *
     * @param array  the array to travers backwords looking for the object, may be {@code null}
     * @param objectToFind  the object to find, may be {@code null}
     * @return the last index of the object within the array,
     *  {@link #INDEX_NOT_FOUND} ({@code -1}) if not found or {@code null} array input
     */
    public static int lastIndexOf(final Object[] array, final Object objectToFind) {
        return lastIndexOf(array, objectToFind, Integer.MAX_VALUE);
    }

    /**
     * <p>Finds the last index of the given object in the array starting at the given index.
     *
     * <p>This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null} input array.
     *
     * <p>A negative startIndex will return {@link #INDEX_NOT_FOUND} ({@code -1}). A startIndex larger than
     * the array length will search from the end of the array.
     *
     * @param array  the array to traverse for looking for the object, may be {@code null}
     * @param objectToFind  the object to find, may be {@code null}
     * @param startIndex  the start index to travers backwards from
     * @return the last index of the object within the array,
     *  {@link #INDEX_NOT_FOUND} ({@code -1}) if not found or {@code null} array input
     */
    public static int lastIndexOf(final Object[] array, final Object objectToFind, int startIndex) {
        if (array == null) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            return INDEX_NOT_FOUND;
        } else if (startIndex >= array.length) {
            startIndex = array.length - 1;
        }
        if (objectToFind == null) {
            for (int i = startIndex; i >= 0; i--) {
                if (array[i] == null) {
                    return i;
                }
            }
        } else if (array.getClass().getComponentType().isInstance(objectToFind)) {
            for (int i = startIndex; i >= 0; i--) {
                if (objectToFind.equals(array[i])) {
                    return i;
                }
            }
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * <p>Checks if the object is in the given array.
     *
     * <p>The method returns {@code false} if a {@code null} array is passed in.
     *
     * @param array  the array to search through
     * @param objectToFind  the object to find
     * @return {@code true} if the array contains the object
     */
    public static boolean contains(final Object[] array, final Object objectToFind) {
        return indexOf(array, objectToFind) != INDEX_NOT_FOUND;
    }

    // long IndexOf
    //-----------------------------------------------------------------------
    /**
     * <p>Finds the index of the given value in the array.
     *
     * <p>This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null} input array.
     *
     * @param array  the array to search through for the object, may be {@code null}
     * @param valueToFind  the value to find
     * @return the index of the value within the array,
     *  {@link #INDEX_NOT_FOUND} ({@code -1}) if not found or {@code null} array input
     */
    public static int indexOf(final long[] array, final long valueToFind) {
        return indexOf(array, valueToFind, 0);
    }

    /**
     * <p>Finds the index of the given value in the array starting at the given index.
     *
     * <p>This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null} input array.
     *
     * <p>A negative startIndex is treated as zero. A startIndex larger than the array
     * length will return {@link #INDEX_NOT_FOUND} ({@code -1}).
     *
     * @param array  the array to search through for the object, may be {@code null}
     * @param valueToFind  the value to find
     * @param startIndex  the index to start searching at
     * @return the index of the value within the array,
     *  {@link #INDEX_NOT_FOUND} ({@code -1}) if not found or {@code null} array input
     */
    public static int indexOf(final long[] array, final long valueToFind, int startIndex) {
        if (array == null) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            startIndex = 0;
        }
        for (int i = startIndex; i < array.length; i++) {
            if (valueToFind == array[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * <p>Finds the last index of the given value within the array.
     *
     * <p>This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null} input array.
     *
     * @param array  the array to travers backwords looking for the object, may be {@code null}
     * @param valueToFind  the object to find
     * @return the last index of the value within the array,
     *  {@link #INDEX_NOT_FOUND} ({@code -1}) if not found or {@code null} array input
     */
    public static int lastIndexOf(final long[] array, final long valueToFind) {
        return lastIndexOf(array, valueToFind, Integer.MAX_VALUE);
    }

    /**
     * <p>Finds the last index of the given value in the array starting at the given index.
     *
     * <p>This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null} input array.
     *
     * <p>A negative startIndex will return {@link #INDEX_NOT_FOUND} ({@code -1}). A startIndex larger than the
     * array length will search from the end of the array.
     *
     * @param array  the array to traverse for looking for the object, may be {@code null}
     * @param valueToFind  the value to find
     * @param startIndex  the start index to travers backwards from
     * @return the last index of the value within the array,
     *  {@link #INDEX_NOT_FOUND} ({@code -1}) if not found or {@code null} array input
     */
    public static int lastIndexOf(final long[] array, final long valueToFind, int startIndex) {
        if (array == null) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            return INDEX_NOT_FOUND;
        } else if (startIndex >= array.length) {
            startIndex = array.length - 1;
        }
        for (int i = startIndex; i >= 0; i--) {
            if (valueToFind == array[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * <p>Checks if the value is in the given array.
     *
     * <p>The method returns {@code false} if a {@code null} array is passed in.
     *
     * @param array  the array to search through
     * @param valueToFind  the value to find
     * @return {@code true} if the array contains the object
     */
    public static boolean contains(final long[] array, final long valueToFind) {
        return indexOf(array, valueToFind) != INDEX_NOT_FOUND;
    }

    // int IndexOf
    //-----------------------------------------------------------------------
    /**
     * <p>Finds the index of the given value in the array.
     *
     * <p>This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null} input array.
     *
     * @param array  the array to search through for the object, may be {@code null}
     * @param valueToFind  the value to find
     * @return the index of the value within the array,
     *  {@link #INDEX_NOT_FOUND} ({@code -1}) if not found or {@code null} array input
     */
    public static int indexOf(final int[] array, final int valueToFind) {
        return indexOf(array, valueToFind, 0);
    }

    /**
     * <p>Finds the index of the given value in the array starting at the given index.
     *
     * <p>This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null} input array.
     *
     * <p>A negative startIndex is treated as zero. A startIndex larger than the array
     * length will return {@link #INDEX_NOT_FOUND} ({@code -1}).
     *
     * @param array  the array to search through for the object, may be {@code null}
     * @param valueToFind  the value to find
     * @param startIndex  the index to start searching at
     * @return the index of the value within the array,
     *  {@link #INDEX_NOT_FOUND} ({@code -1}) if not found or {@code null} array input
     */
    public static int indexOf(final int[] array, final int valueToFind, int startIndex) {
        if (array == null) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            startIndex = 0;
        }
        for (int i = startIndex; i < array.length; i++) {
            if (valueToFind == array[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * <p>Finds the last index of the given value within the array.
     *
     * <p>This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null} input array.
     *
     * @param array  the array to travers backwords looking for the object, may be {@code null}
     * @param valueToFind  the object to find
     * @return the last index of the value within the array,
     *  {@link #INDEX_NOT_FOUND} ({@code -1}) if not found or {@code null} array input
     */
    public static int lastIndexOf(final int[] array, final int valueToFind) {
        return lastIndexOf(array, valueToFind, Integer.MAX_VALUE);
    }

    /**
     * <p>Finds the last index of the given value in the array starting at the given index.
     *
     * <p>This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null} input array.
     *
     * <p>A negative startIndex will return {@link #INDEX_NOT_FOUND} ({@code -1}). A startIndex larger than the
     * array length will search from the end of the array.
     *
     * @param array  the array to traverse for looking for the object, may be {@code null}
     * @param valueToFind  the value to find
     * @param startIndex  the start index to travers backwards from
     * @return the last index of the value within the array,
     *  {@link #INDEX_NOT_FOUND} ({@code -1}) if not found or {@code null} array input
     */
    public static int lastIndexOf(final int[] array, final int valueToFind, int startIndex) {
        if (array == null) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            return INDEX_NOT_FOUND;
        } else if (startIndex >= array.length) {
            startIndex = array.length - 1;
        }
        for (int i = startIndex; i >= 0; i--) {
            if (valueToFind == array[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * <p>Checks if the value is in the given array.
     *
     * <p>The method returns {@code false} if a {@code null} array is passed in.
     *
     * @param array  the array to search through
     * @param valueToFind  the value to find
     * @return {@code true} if the array contains the object
     */
    public static boolean contains(final int[] array, final int valueToFind) {
        return indexOf(array, valueToFind) != INDEX_NOT_FOUND;
    }

    // short IndexOf
    //-----------------------------------------------------------------------
    /**
     * <p>Finds the index of the given value in the array.
     *
     * <p>This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null} input array.
     *
     * @param array  the array to search through for the object, may be {@code null}
     * @param valueToFind  the value to find
     * @return the index of the value within the array,
     *  {@link #INDEX_NOT_FOUND} ({@code -1}) if not found or {@code null} array input
     */
    public static int indexOf(final short[] array, final short valueToFind) {
        return indexOf(array, valueToFind, 0);
    }

    /**
     * <p>Finds the index of the given value in the array starting at the given index.
     *
     * <p>This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null} input array.
     *
     * <p>A negative startIndex is treated as zero. A startIndex larger than the array
     * length will return {@link #INDEX_NOT_FOUND} ({@code -1}).
     *
     * @param array  the array to search through for the object, may be {@code null}
     * @param valueToFind  the value to find
     * @param startIndex  the index to start searching at
     * @return the index of the value within the array,
     *  {@link #INDEX_NOT_FOUND} ({@code -1}) if not found or {@code null} array input
     */
    public static int indexOf(final short[] array, final short valueToFind, int startIndex) {
        if (array == null) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            startIndex = 0;
        }
        for (int i = startIndex; i < array.length; i++) {
            if (valueToFind == array[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * <p>Finds the last index of the given value within the array.
     *
     * <p>This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null} input array.
     *
     * @param array  the array to travers backwords looking for the object, may be {@code null}
     * @param valueToFind  the object to find
     * @return the last index of the value within the array,
     *  {@link #INDEX_NOT_FOUND} ({@code -1}) if not found or {@code null} array input
     */
    public static int lastIndexOf(final short[] array, final short valueToFind) {
        return lastIndexOf(array, valueToFind, Integer.MAX_VALUE);
    }

    /**
     * <p>Finds the last index of the given value in the array starting at the given index.
     *
     * <p>This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null} input array.
     *
     * <p>A negative startIndex will return {@link #INDEX_NOT_FOUND} ({@code -1}). A startIndex larger than the
     * array length will search from the end of the array.
     *
     * @param array  the array to traverse for looking for the object, may be {@code null}
     * @param valueToFind  the value to find
     * @param startIndex  the start index to travers backwards from
     * @return the last index of the value within the array,
     *  {@link #INDEX_NOT_FOUND} ({@code -1}) if not found or {@code null} array input
     */
    public static int lastIndexOf(final short[] array, final short valueToFind, int startIndex) {
        if (array == null) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            return INDEX_NOT_FOUND;
        } else if (startIndex >= array.length) {
            startIndex = array.length - 1;
        }
        for (int i = startIndex; i >= 0; i--) {
            if (valueToFind == array[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * <p>Checks if the value is in the given array.
     *
     * <p>The method returns {@code false} if a {@code null} array is passed in.
     *
     * @param array  the array to search through
     * @param valueToFind  the value to find
     * @return {@code true} if the array contains the object
     */
    public static boolean contains(final short[] array, final short valueToFind) {
        return indexOf(array, valueToFind) != INDEX_NOT_FOUND;
    }

    // char IndexOf
    //-----------------------------------------------------------------------
    /**
     * <p>Finds the index of the given value in the array.
     *
     * <p>This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null} input array.
     *
     * @param array  the array to search through for the object, may be {@code null}
     * @param valueToFind  the value to find
     * @return the index of the value within the array,
     *  {@link #INDEX_NOT_FOUND} ({@code -1}) if not found or {@code null} array input
     * @since 2.1
     */
    public static int indexOf(final char[] array, final char valueToFind) {
        return indexOf(array, valueToFind, 0);
    }

    /**
     * <p>Finds the index of the given value in the array starting at the given index.
     *
     * <p>This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null} input array.
     *
     * <p>A negative startIndex is treated as zero. A startIndex larger than the array
     * length will return {@link #INDEX_NOT_FOUND} ({@code -1}).
     *
     * @param array  the array to search through for the object, may be {@code null}
     * @param valueToFind  the value to find
     * @param startIndex  the index to start searching at
     * @return the index of the value within the array,
     *  {@link #INDEX_NOT_FOUND} ({@code -1}) if not found or {@code null} array input
     * @since 2.1
     */
    public static int indexOf(final char[] array, final char valueToFind, int startIndex) {
        if (array == null) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            startIndex = 0;
        }
        for (int i = startIndex; i < array.length; i++) {
            if (valueToFind == array[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * <p>Finds the last index of the given value within the array.
     *
     * <p>This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null} input array.
     *
     * @param array  the array to travers backwords looking for the object, may be {@code null}
     * @param valueToFind  the object to find
     * @return the last index of the value within the array,
     *  {@link #INDEX_NOT_FOUND} ({@code -1}) if not found or {@code null} array input
     * @since 2.1
     */
    public static int lastIndexOf(final char[] array, final char valueToFind) {
        return lastIndexOf(array, valueToFind, Integer.MAX_VALUE);
    }

    /**
     * <p>Finds the last index of the given value in the array starting at the given index.
     *
     * <p>This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null} input array.
     *
     * <p>A negative startIndex will return {@link #INDEX_NOT_FOUND} ({@code -1}). A startIndex larger than the
     * array length will search from the end of the array.
     *
     * @param array  the array to traverse for looking for the object, may be {@code null}
     * @param valueToFind  the value to find
     * @param startIndex  the start index to travers backwards from
     * @return the last index of the value within the array,
     *  {@link #INDEX_NOT_FOUND} ({@code -1}) if not found or {@code null} array input
     * @since 2.1
     */
    public static int lastIndexOf(final char[] array, final char valueToFind, int startIndex) {
        if (array == null) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            return INDEX_NOT_FOUND;
        } else if (startIndex >= array.length) {
            startIndex = array.length - 1;
        }
        for (int i = startIndex; i >= 0; i--) {
            if (valueToFind == array[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * <p>Checks if the value is in the given array.
     *
     * <p>The method returns {@code false} if a {@code null} array is passed in.
     *
     * @param array  the array to search through
     * @param valueToFind  the value to find
     * @return {@code true} if the array contains the object
     * @since 2.1
     */
    public static boolean contains(final char[] array, final char valueToFind) {
        return indexOf(array, valueToFind) != INDEX_NOT_FOUND;
    }

    // byte IndexOf
    //-----------------------------------------------------------------------
    /**
     * <p>Finds the index of the given value in the array.
     *
     * <p>This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null} input array.
     *
     * @param array  the array to search through for the object, may be {@code null}
     * @param valueToFind  the value to find
     * @return the index of the value within the array,
     *  {@link #INDEX_NOT_FOUND} ({@code -1}) if not found or {@code null} array input
     */
    public static int indexOf(final byte[] array, final byte valueToFind) {
        return indexOf(array, valueToFind, 0);
    }

    /**
     * <p>Finds the index of the given value in the array starting at the given index.
     *
     * <p>This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null} input array.
     *
     * <p>A negative startIndex is treated as zero. A startIndex larger than the array
     * length will return {@link #INDEX_NOT_FOUND} ({@code -1}).
     *
     * @param array  the array to search through for the object, may be {@code null}
     * @param valueToFind  the value to find
     * @param startIndex  the index to start searching at
     * @return the index of the value within the array,
     *  {@link #INDEX_NOT_FOUND} ({@code -1}) if not found or {@code null} array input
     */
    public static int indexOf(final byte[] array, final byte valueToFind, int startIndex) {
        if (array == null) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            startIndex = 0;
        }
        for (int i = startIndex; i < array.length; i++) {
            if (valueToFind == array[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * <p>Finds the last index of the given value within the array.
     *
     * <p>This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null} input array.
     *
     * @param array  the array to travers backwords looking for the object, may be {@code null}
     * @param valueToFind  the object to find
     * @return the last index of the value within the array,
     *  {@link #INDEX_NOT_FOUND} ({@code -1}) if not found or {@code null} array input
     */
    public static int lastIndexOf(final byte[] array, final byte valueToFind) {
        return lastIndexOf(array, valueToFind, Integer.MAX_VALUE);
    }

    /**
     * <p>Finds the last index of the given value in the array starting at the given index.
     *
     * <p>This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null} input array.
     *
     * <p>A negative startIndex will return {@link #INDEX_NOT_FOUND} ({@code -1}). A startIndex larger than the
     * array length will search from the end of the array.
     *
     * @param array  the array to traverse for looking for the object, may be {@code null}
     * @param valueToFind  the value to find
     * @param startIndex  the start index to travers backwards from
     * @return the last index of the value within the array,
     *  {@link #INDEX_NOT_FOUND} ({@code -1}) if not found or {@code null} array input
     */
    public static int lastIndexOf(final byte[] array, final byte valueToFind, int startIndex) {
        if (array == null) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            return INDEX_NOT_FOUND;
        } else if (startIndex >= array.length) {
            startIndex = array.length - 1;
        }
        for (int i = startIndex; i >= 0; i--) {
            if (valueToFind == array[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * <p>Checks if the value is in the given array.
     *
     * <p>The method returns {@code false} if a {@code null} array is passed in.
     *
     * @param array  the array to search through
     * @param valueToFind  the value to find
     * @return {@code true} if the array contains the object
     */
    public static boolean contains(final byte[] array, final byte valueToFind) {
        return indexOf(array, valueToFind) != INDEX_NOT_FOUND;
    }

    // double IndexOf
    //-----------------------------------------------------------------------
    /**
     * <p>Finds the index of the given value in the array.
     *
     * <p>This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null} input array.
     *
     * @param array  the array to search through for the object, may be {@code null}
     * @param valueToFind  the value to find
     * @return the index of the value within the array,
     *  {@link #INDEX_NOT_FOUND} ({@code -1}) if not found or {@code null} array input
     */
    public static int indexOf(final double[] array, final double valueToFind) {
        return indexOf(array, valueToFind, 0);
    }

    /**
     * <p>Finds the index of the given value within a given tolerance in the array.
     * This method will return the index of the first value which falls between the region
     * defined by valueToFind - tolerance and valueToFind + tolerance.
     *
     * <p>This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null} input array.
     *
     * @param array  the array to search through for the object, may be {@code null}
     * @param valueToFind  the value to find
     * @param tolerance tolerance of the search
     * @return the index of the value within the array,
     *  {@link #INDEX_NOT_FOUND} ({@code -1}) if not found or {@code null} array input
     */
    public static int indexOf(final double[] array, final double valueToFind, final double tolerance) {
        return indexOf(array, valueToFind, 0, tolerance);
    }

    /**
     * <p>Finds the index of the given value in the array starting at the given index.
     *
     * <p>This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null} input array.
     *
     * <p>A negative startIndex is treated as zero. A startIndex larger than the array
     * length will return {@link #INDEX_NOT_FOUND} ({@code -1}).
     *
     * @param array  the array to search through for the object, may be {@code null}
     * @param valueToFind  the value to find
     * @param startIndex  the index to start searching at
     * @return the index of the value within the array,
     *  {@link #INDEX_NOT_FOUND} ({@code -1}) if not found or {@code null} array input
     */
    public static int indexOf(final double[] array, final double valueToFind, int startIndex) {
        if (isEmpty(array)) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            startIndex = 0;
        }
        for (int i = startIndex; i < array.length; i++) {
            if (valueToFind == array[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * <p>Finds the index of the given value in the array starting at the given index.
     * This method will return the index of the first value which falls between the region
     * defined by valueToFind - tolerance and valueToFind + tolerance.
     *
     * <p>This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null} input array.
     *
     * <p>A negative startIndex is treated as zero. A startIndex larger than the array
     * length will return {@link #INDEX_NOT_FOUND} ({@code -1}).
     *
     * @param array  the array to search through for the object, may be {@code null}
     * @param valueToFind  the value to find
     * @param startIndex  the index to start searching at
     * @param tolerance tolerance of the search
     * @return the index of the value within the array,
     *  {@link #INDEX_NOT_FOUND} ({@code -1}) if not found or {@code null} array input
     */
    public static int indexOf(final double[] array, final double valueToFind, int startIndex, final double tolerance) {
        if (isEmpty(array)) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            startIndex = 0;
        }
        final double min = valueToFind - tolerance;
        final double max = valueToFind + tolerance;
        for (int i = startIndex; i < array.length; i++) {
            if (array[i] >= min && array[i] <= max) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * <p>Finds the last index of the given value within the array.
     *
     * <p>This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null} input array.
     *
     * @param array  the array to travers backwords looking for the object, may be {@code null}
     * @param valueToFind  the object to find
     * @return the last index of the value within the array,
     *  {@link #INDEX_NOT_FOUND} ({@code -1}) if not found or {@code null} array input
     */
    public static int lastIndexOf(final double[] array, final double valueToFind) {
        return lastIndexOf(array, valueToFind, Integer.MAX_VALUE);
    }

    /**
     * <p>Finds the last index of the given value within a given tolerance in the array.
     * This method will return the index of the last value which falls between the region
     * defined by valueToFind - tolerance and valueToFind + tolerance.
     *
     * <p>This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null} input array.
     *
     * @param array  the array to search through for the object, may be {@code null}
     * @param valueToFind  the value to find
     * @param tolerance tolerance of the search
     * @return the index of the value within the array,
     *  {@link #INDEX_NOT_FOUND} ({@code -1}) if not found or {@code null} array input
     */
    public static int lastIndexOf(final double[] array, final double valueToFind, final double tolerance) {
        return lastIndexOf(array, valueToFind, Integer.MAX_VALUE, tolerance);
    }

    /**
     * <p>Finds the last index of the given value in the array starting at the given index.
     *
     * <p>This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null} input array.
     *
     * <p>A negative startIndex will return {@link #INDEX_NOT_FOUND} ({@code -1}). A startIndex larger than the
     * array length will search from the end of the array.
     *
     * @param array  the array to traverse for looking for the object, may be {@code null}
     * @param valueToFind  the value to find
     * @param startIndex  the start index to travers backwards from
     * @return the last index of the value within the array,
     *  {@link #INDEX_NOT_FOUND} ({@code -1}) if not found or {@code null} array input
     */
    public static int lastIndexOf(final double[] array, final double valueToFind, int startIndex) {
        if (isEmpty(array)) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            return INDEX_NOT_FOUND;
        } else if (startIndex >= array.length) {
            startIndex = array.length - 1;
        }
        for (int i = startIndex; i >= 0; i--) {
            if (valueToFind == array[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * <p>Finds the last index of the given value in the array starting at the given index.
     * This method will return the index of the last value which falls between the region
     * defined by valueToFind - tolerance and valueToFind + tolerance.
     *
     * <p>This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null} input array.
     *
     * <p>A negative startIndex will return {@link #INDEX_NOT_FOUND} ({@code -1}). A startIndex larger than the
     * array length will search from the end of the array.
     *
     * @param array  the array to traverse for looking for the object, may be {@code null}
     * @param valueToFind  the value to find
     * @param startIndex  the start index to travers backwards from
     * @param tolerance  search for value within plus/minus this amount
     * @return the last index of the value within the array,
     *  {@link #INDEX_NOT_FOUND} ({@code -1}) if not found or {@code null} array input
     */
    public static int lastIndexOf(final double[] array, final double valueToFind, int startIndex, final double tolerance) {
        if (isEmpty(array)) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            return INDEX_NOT_FOUND;
        } else if (startIndex >= array.length) {
            startIndex = array.length - 1;
        }
        final double min = valueToFind - tolerance;
        final double max = valueToFind + tolerance;
        for (int i = startIndex; i >= 0; i--) {
            if (array[i] >= min && array[i] <= max) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * <p>Checks if the value is in the given array.
     *
     * <p>The method returns {@code false} if a {@code null} array is passed in.
     *
     * @param array  the array to search through
     * @param valueToFind  the value to find
     * @return {@code true} if the array contains the object
     */
    public static boolean contains(final double[] array, final double valueToFind) {
        return indexOf(array, valueToFind) != INDEX_NOT_FOUND;
    }

    /**
     * <p>Checks if a value falling within the given tolerance is in the
     * given array.  If the array contains a value within the inclusive range
     * defined by (value - tolerance) to (value + tolerance).
     *
     * <p>The method returns {@code false} if a {@code null} array
     * is passed in.
     *
     * @param array  the array to search
     * @param valueToFind  the value to find
     * @param tolerance  the array contains the tolerance of the search
     * @return true if value falling within tolerance is in array
     */
    public static boolean contains(final double[] array, final double valueToFind, final double tolerance) {
        return indexOf(array, valueToFind, 0, tolerance) != INDEX_NOT_FOUND;
    }

    // float IndexOf
    //-----------------------------------------------------------------------
    /**
     * <p>Finds the index of the given value in the array.
     *
     * <p>This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null} input array.
     *
     * @param array  the array to search through for the object, may be {@code null}
     * @param valueToFind  the value to find
     * @return the index of the value within the array,
     *  {@link #INDEX_NOT_FOUND} ({@code -1}) if not found or {@code null} array input
     */
    public static int indexOf(final float[] array, final float valueToFind) {
        return indexOf(array, valueToFind, 0);
    }

    /**
     * <p>Finds the index of the given value in the array starting at the given index.
     *
     * <p>This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null} input array.
     *
     * <p>A negative startIndex is treated as zero. A startIndex larger than the array
     * length will return {@link #INDEX_NOT_FOUND} ({@code -1}).
     *
     * @param array  the array to search through for the object, may be {@code null}
     * @param valueToFind  the value to find
     * @param startIndex  the index to start searching at
     * @return the index of the value within the array,
     *  {@link #INDEX_NOT_FOUND} ({@code -1}) if not found or {@code null} array input
     */
    public static int indexOf(final float[] array, final float valueToFind, int startIndex) {
        if (isEmpty(array)) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            startIndex = 0;
        }
        for (int i = startIndex; i < array.length; i++) {
            if (valueToFind == array[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * <p>Finds the last index of the given value within the array.
     *
     * <p>This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null} input array.
     *
     * @param array  the array to travers backwords looking for the object, may be {@code null}
     * @param valueToFind  the object to find
     * @return the last index of the value within the array,
     *  {@link #INDEX_NOT_FOUND} ({@code -1}) if not found or {@code null} array input
     */
    public static int lastIndexOf(final float[] array, final float valueToFind) {
        return lastIndexOf(array, valueToFind, Integer.MAX_VALUE);
    }

    /**
     * <p>Finds the last index of the given value in the array starting at the given index.
     *
     * <p>This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null} input array.
     *
     * <p>A negative startIndex will return {@link #INDEX_NOT_FOUND} ({@code -1}). A startIndex larger than the
     * array length will search from the end of the array.
     *
     * @param array  the array to traverse for looking for the object, may be {@code null}
     * @param valueToFind  the value to find
     * @param startIndex  the start index to travers backwards from
     * @return the last index of the value within the array,
     *  {@link #INDEX_NOT_FOUND} ({@code -1}) if not found or {@code null} array input
     */
    public static int lastIndexOf(final float[] array, final float valueToFind, int startIndex) {
        if (isEmpty(array)) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            return INDEX_NOT_FOUND;
        } else if (startIndex >= array.length) {
            startIndex = array.length - 1;
        }
        for (int i = startIndex; i >= 0; i--) {
            if (valueToFind == array[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * <p>Checks if the value is in the given array.
     *
     * <p>The method returns {@code false} if a {@code null} array is passed in.
     *
     * @param array  the array to search through
     * @param valueToFind  the value to find
     * @return {@code true} if the array contains the object
     */
    public static boolean contains(final float[] array, final float valueToFind) {
        return indexOf(array, valueToFind) != INDEX_NOT_FOUND;
    }

    // boolean IndexOf
    //-----------------------------------------------------------------------
    /**
     * <p>Finds the index of the given value in the array.
     *
     * <p>This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null} input array.
     *
     * @param array  the array to search through for the object, may be {@code null}
     * @param valueToFind  the value to find
     * @return the index of the value within the array,
     *  {@link #INDEX_NOT_FOUND} ({@code -1}) if not found or {@code null} array input
     */
    public static int indexOf(final boolean[] array, final boolean valueToFind) {
        return indexOf(array, valueToFind, 0);
    }

    /**
     * <p>Finds the index of the given value in the array starting at the given index.
     *
     * <p>This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null} input array.
     *
     * <p>A negative startIndex is treated as zero. A startIndex larger than the array
     * length will return {@link #INDEX_NOT_FOUND} ({@code -1}).
     *
     * @param array  the array to search through for the object, may be {@code null}
     * @param valueToFind  the value to find
     * @param startIndex  the index to start searching at
     * @return the index of the value within the array,
     *  {@link #INDEX_NOT_FOUND} ({@code -1}) if not found or {@code null}
     *  array input
     */
    public static int indexOf(final boolean[] array, final boolean valueToFind, int startIndex) {
        if (isEmpty(array)) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            startIndex = 0;
        }
        for (int i = startIndex; i < array.length; i++) {
            if (valueToFind == array[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * <p>Finds the last index of the given value within the array.
     *
     * <p>This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) if
     * {@code null} array input.
     *
     * @param array  the array to travers backwords looking for the object, may be {@code null}
     * @param valueToFind  the object to find
     * @return the last index of the value within the array,
     *  {@link #INDEX_NOT_FOUND} ({@code -1}) if not found or {@code null} array input
     */
    public static int lastIndexOf(final boolean[] array, final boolean valueToFind) {
        return lastIndexOf(array, valueToFind, Integer.MAX_VALUE);
    }

    /**
     * <p>Finds the last index of the given value in the array starting at the given index.
     *
     * <p>This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null} input array.
     *
     * <p>A negative startIndex will return {@link #INDEX_NOT_FOUND} ({@code -1}). A startIndex larger than
     * the array length will search from the end of the array.
     *
     * @param array  the array to traverse for looking for the object, may be {@code null}
     * @param valueToFind  the value to find
     * @param startIndex  the start index to travers backwards from
     * @return the last index of the value within the array,
     *  {@link #INDEX_NOT_FOUND} ({@code -1}) if not found or {@code null} array input
     */
    public static int lastIndexOf(final boolean[] array, final boolean valueToFind, int startIndex) {
        if (isEmpty(array)) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            return INDEX_NOT_FOUND;
        } else if (startIndex >= array.length) {
            startIndex = array.length - 1;
        }
        for (int i = startIndex; i >= 0; i--) {
            if (valueToFind == array[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * <p>Checks if the value is in the given array.
     *
     * <p>The method returns {@code false} if a {@code null} array is passed in.
     *
     * @param array  the array to search through
     * @param valueToFind  the value to find
     * @return {@code true} if the array contains the object
     */
    public static boolean contains(final boolean[] array, final boolean valueToFind) {
        return indexOf(array, valueToFind) != INDEX_NOT_FOUND;
    }

    // Primitive/Object array converters
    // ----------------------------------------------------------------------

    // Character array converters
    // ----------------------------------------------------------------------
    /**
     * <p>Converts an array of object Characters to primitives.
     *
     * <p>This method returns {@code null} for a {@code null} input array.
     *
     * @param array  a {@code Character} array, may be {@code null}
     * @return a {@code char} array, {@code null} if null array input
     * @throws NullPointerException if array content is {@code null}
     */
    public static char[] toPrimitive(final Character[] array) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return EMPTY_CHAR_ARRAY;
        }
        final char[] result = new char[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i].charValue();
        }
        return result;
    }

    /**
     * <p>Converts an array of object Character to primitives handling {@code null}.
     *
     * <p>This method returns {@code null} for a {@code null} input array.
     *
     * @param array  a {@code Character} array, may be {@code null}
     * @param valueForNull  the value to insert if {@code null} found
     * @return a {@code char} array, {@code null} if null array input
     */
    public static char[] toPrimitive(final Character[] array, final char valueForNull) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return EMPTY_CHAR_ARRAY;
        }
        final char[] result = new char[array.length];
        for (int i = 0; i < array.length; i++) {
            final Character b = array[i];
            result[i] = (b == null ? valueForNull : b.charValue());
        }
        return result;
    }

    /**
     * <p>Converts an array of primitive chars to objects.
     *
     * <p>This method returns {@code null} for a {@code null} input array.
     *
     * @param array a {@code char} array
     * @return a {@code Character} array, {@code null} if null array input
     */
    public static Character[] toObject(final char[] array) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return EMPTY_CHARACTER_OBJECT_ARRAY;
        }
        final Character[] result = new Character[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = Character.valueOf(array[i]);
        }
        return result;
    }

    // Long array converters
    // ----------------------------------------------------------------------
    /**
     * <p>Converts an array of object Longs to primitives.
     *
     * <p>This method returns {@code null} for a {@code null} input array.
     *
     * @param array  a {@code Long} array, may be {@code null}
     * @return a {@code long} array, {@code null} if null array input
     * @throws NullPointerException if array content is {@code null}
     */
    public static long[] toPrimitive(final Long[] array) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return EMPTY_LONG_ARRAY;
        }
        final long[] result = new long[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i].longValue();
        }
        return result;
    }

    /**
     * <p>Converts an array of object Long to primitives handling {@code null}.
     *
     * <p>This method returns {@code null} for a {@code null} input array.
     *
     * @param array  a {@code Long} array, may be {@code null}
     * @param valueForNull  the value to insert if {@code null} found
     * @return a {@code long} array, {@code null} if null array input
     */
    public static long[] toPrimitive(final Long[] array, final long valueForNull) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return EMPTY_LONG_ARRAY;
        }
        final long[] result = new long[array.length];
        for (int i = 0; i < array.length; i++) {
            final Long b = array[i];
            result[i] = (b == null ? valueForNull : b.longValue());
        }
        return result;
    }

    /**
     * <p>Converts an array of primitive longs to objects.
     *
     * <p>This method returns {@code null} for a {@code null} input array.
     *
     * @param array  a {@code long} array
     * @return a {@code Long} array, {@code null} if null array input
     */
    public static Long[] toObject(final long[] array) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return EMPTY_LONG_OBJECT_ARRAY;
        }
        final Long[] result = new Long[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = Long.valueOf(array[i]);
        }
        return result;
    }

    // Int array converters
    // ----------------------------------------------------------------------
    /**
     * <p>Converts an array of object Integers to primitives.
     *
     * <p>This method returns {@code null} for a {@code null} input array.
     *
     * @param array  a {@code Integer} array, may be {@code null}
     * @return an {@code int} array, {@code null} if null array input
     * @throws NullPointerException if array content is {@code null}
     */
    public static int[] toPrimitive(final Integer[] array) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return EMPTY_INT_ARRAY;
        }
        final int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i].intValue();
        }
        return result;
    }

    /**
     * <p>Converts an array of object Integer to primitives handling {@code null}.
     *
     * <p>This method returns {@code null} for a {@code null} input array.
     *
     * @param array  a {@code Integer} array, may be {@code null}
     * @param valueForNull  the value to insert if {@code null} found
     * @return an {@code int} array, {@code null} if null array input
     */
    public static int[] toPrimitive(final Integer[] array, final int valueForNull) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return EMPTY_INT_ARRAY;
        }
        final int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            final Integer b = array[i];
            result[i] = (b == null ? valueForNull : b.intValue());
        }
        return result;
    }

    /**
     * <p>Converts an array of primitive ints to objects.
     *
     * <p>This method returns {@code null} for a {@code null} input array.
     *
     * @param array  an {@code int} array
     * @return an {@code Integer} array, {@code null} if null array input
     */
    public static Integer[] toObject(final int[] array) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return EMPTY_INTEGER_OBJECT_ARRAY;
        }
        final Integer[] result = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = Integer.valueOf(array[i]);
        }
        return result;
    }

    // Short array converters
    // ----------------------------------------------------------------------
    /**
     * <p>Converts an array of object Shorts to primitives.
     *
     * <p>This method returns {@code null} for a {@code null} input array.
     *
     * @param array  a {@code Short} array, may be {@code null}
     * @return a {@code byte} array, {@code null} if null array input
     * @throws NullPointerException if array content is {@code null}
     */
    public static short[] toPrimitive(final Short[] array) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return EMPTY_SHORT_ARRAY;
        }
        final short[] result = new short[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i].shortValue();
        }
        return result;
    }

    /**
     * <p>Converts an array of object Short to primitives handling {@code null}.
     *
     * <p>This method returns {@code null} for a {@code null} input array.
     *
     * @param array  a {@code Short} array, may be {@code null}
     * @param valueForNull  the value to insert if {@code null} found
     * @return a {@code byte} array, {@code null} if null array input
     */
    public static short[] toPrimitive(final Short[] array, final short valueForNull) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return EMPTY_SHORT_ARRAY;
        }
        final short[] result = new short[array.length];
        for (int i = 0; i < array.length; i++) {
            final Short b = array[i];
            result[i] = (b == null ? valueForNull : b.shortValue());
        }
        return result;
    }

    /**
     * <p>Converts an array of primitive shorts to objects.
     *
     * <p>This method returns {@code null} for a {@code null} input array.
     *
     * @param array  a {@code short} array
     * @return a {@code Short} array, {@code null} if null array input
     */
    public static Short[] toObject(final short[] array) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return EMPTY_SHORT_OBJECT_ARRAY;
        }
        final Short[] result = new Short[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = Short.valueOf(array[i]);
        }
        return result;
    }

    // Byte array converters
    // ----------------------------------------------------------------------
    /**
     * <p>Converts an array of object Bytes to primitives.
     *
     * <p>This method returns {@code null} for a {@code null} input array.
     *
     * @param array  a {@code Byte} array, may be {@code null}
     * @return a {@code byte} array, {@code null} if null array input
     * @throws NullPointerException if array content is {@code null}
     */
    public static byte[] toPrimitive(final Byte[] array) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return EMPTY_BYTE_ARRAY;
        }
        final byte[] result = new byte[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i].byteValue();
        }
        return result;
    }

    /**
     * <p>Converts an array of object Bytes to primitives handling {@code null}.
     *
     * <p>This method returns {@code null} for a {@code null} input array.
     *
     * @param array  a {@code Byte} array, may be {@code null}
     * @param valueForNull  the value to insert if {@code null} found
     * @return a {@code byte} array, {@code null} if null array input
     */
    public static byte[] toPrimitive(final Byte[] array, final byte valueForNull) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return EMPTY_BYTE_ARRAY;
        }
        final byte[] result = new byte[array.length];
        for (int i = 0; i < array.length; i++) {
            final Byte b = array[i];
            result[i] = (b == null ? valueForNull : b.byteValue());
        }
        return result;
    }

    /**
     * <p>Converts an array of primitive bytes to objects.
     *
     * <p>This method returns {@code null} for a {@code null} input array.
     *
     * @param array  a {@code byte} array
     * @return a {@code Byte} array, {@code null} if null array input
     */
    public static Byte[] toObject(final byte[] array) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return EMPTY_BYTE_OBJECT_ARRAY;
        }
        final Byte[] result = new Byte[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = Byte.valueOf(array[i]);
        }
        return result;
    }

    // Double array converters
    // ----------------------------------------------------------------------
    /**
     * <p>Converts an array of object Doubles to primitives.
     *
     * <p>This method returns {@code null} for a {@code null} input array.
     *
     * @param array  a {@code Double} array, may be {@code null}
     * @return a {@code double} array, {@code null} if null array input
     * @throws NullPointerException if array content is {@code null}
     */
    public static double[] toPrimitive(final Double[] array) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return EMPTY_DOUBLE_ARRAY;
        }
        final double[] result = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i].doubleValue();
        }
        return result;
    }

    /**
     * <p>Converts an array of object Doubles to primitives handling {@code null}.
     *
     * <p>This method returns {@code null} for a {@code null} input array.
     *
     * @param array  a {@code Double} array, may be {@code null}
     * @param valueForNull  the value to insert if {@code null} found
     * @return a {@code double} array, {@code null} if null array input
     */
    public static double[] toPrimitive(final Double[] array, final double valueForNull) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return EMPTY_DOUBLE_ARRAY;
        }
        final double[] result = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            final Double b = array[i];
            result[i] = (b == null ? valueForNull : b.doubleValue());
        }
        return result;
    }

    /**
     * <p>Converts an array of primitive doubles to objects.
     *
     * <p>This method returns {@code null} for a {@code null} input array.
     *
     * @param array  a {@code double} array
     * @return a {@code Double} array, {@code null} if null array input
     */
    public static Double[] toObject(final double[] array) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return EMPTY_DOUBLE_OBJECT_ARRAY;
        }
        final Double[] result = new Double[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = Double.valueOf(array[i]);
        }
        return result;
    }

    //   Float array converters
    // ----------------------------------------------------------------------
    /**
     * <p>Converts an array of object Floats to primitives.
     *
     * <p>This method returns {@code null} for a {@code null} input array.
     *
     * @param array  a {@code Float} array, may be {@code null}
     * @return a {@code float} array, {@code null} if null array input
     * @throws NullPointerException if array content is {@code null}
     */
    public static float[] toPrimitive(final Float[] array) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return EMPTY_FLOAT_ARRAY;
        }
        final float[] result = new float[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i].floatValue();
        }
        return result;
    }

    /**
     * <p>Converts an array of object Floats to primitives handling {@code null}.
     *
     * <p>This method returns {@code null} for a {@code null} input array.
     *
     * @param array  a {@code Float} array, may be {@code null}
     * @param valueForNull  the value to insert if {@code null} found
     * @return a {@code float} array, {@code null} if null array input
     */
    public static float[] toPrimitive(final Float[] array, final float valueForNull) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return EMPTY_FLOAT_ARRAY;
        }
        final float[] result = new float[array.length];
        for (int i = 0; i < array.length; i++) {
            final Float b = array[i];
            result[i] = (b == null ? valueForNull : b.floatValue());
        }
        return result;
    }

    /**
     * <p>Converts an array of primitive floats to objects.
     *
     * <p>This method returns {@code null} for a {@code null} input array.
     *
     * @param array  a {@code float} array
     * @return a {@code Float} array, {@code null} if null array input
     */
    public static Float[] toObject(final float[] array) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return EMPTY_FLOAT_OBJECT_ARRAY;
        }
        final Float[] result = new Float[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = Float.valueOf(array[i]);
        }
        return result;
    }

    /**
     * <p>Create an array of primitive type from an array of wrapper types.
     *
     * <p>This method returns {@code null} for a {@code null} input array.
     *
     * @param array  an array of wrapper object
     * @return an array of the corresponding primitive type, or the original array
     * @since 3.5
     */
    public static Object toPrimitive(final Object array) {
        if (array == null) {
            return null;
        }
        Class<?> ct = array.getClass().getComponentType();
        Class<?> pt = ClassServiceUtil.wrapperToPrimitive(ct);
        if(Integer.TYPE.equals(pt)) {
            return toPrimitive((Integer[]) array);
        }
        if(Long.TYPE.equals(pt)) {
            return toPrimitive((Long[]) array);
        }
        if(Short.TYPE.equals(pt)) {
            return toPrimitive((Short[]) array);
        }
        if(Double.TYPE.equals(pt)) {
            return toPrimitive((Double[]) array);
        }
        if(Float.TYPE.equals(pt)) {
            return toPrimitive((Float[]) array);
        }
        return array;
    }

    // Boolean array converters
    // ----------------------------------------------------------------------
    /**
     * <p>Converts an array of object Booleans to primitives.
     *
     * <p>This method returns {@code null} for a {@code null} input array.
     *
     * @param array  a {@code Boolean} array, may be {@code null}
     * @return a {@code boolean} array, {@code null} if null array input
     * @throws NullPointerException if array content is {@code null}
     */
    public static boolean[] toPrimitive(final Boolean[] array) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return EMPTY_BOOLEAN_ARRAY;
        }
        final boolean[] result = new boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i].booleanValue();
        }
        return result;
    }

    /**
     * <p>Converts an array of object Booleans to primitives handling {@code null}.
     *
     * <p>This method returns {@code null} for a {@code null} input array.
     *
     * @param array  a {@code Boolean} array, may be {@code null}
     * @param valueForNull  the value to insert if {@code null} found
     * @return a {@code boolean} array, {@code null} if null array input
     */
    public static boolean[] toPrimitive(final Boolean[] array, final boolean valueForNull) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return EMPTY_BOOLEAN_ARRAY;
        }
        final boolean[] result = new boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            final Boolean b = array[i];
            result[i] = (b == null ? valueForNull : b.booleanValue());
        }
        return result;
    }

    /**
     * <p>Converts an array of primitive booleans to objects.
     *
     * <p>This method returns {@code null} for a {@code null} input array.
     *
     * @param array  a {@code boolean} array
     * @return a {@code Boolean} array, {@code null} if null array input
     */
    public static Boolean[] toObject(final boolean[] array) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return EMPTY_BOOLEAN_OBJECT_ARRAY;
        }
        final Boolean[] result = new Boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = (array[i] ? Boolean.TRUE : Boolean.FALSE);
        }
        return result;
    }

    // ----------------------------------------------------------------------
    /**
     * <p>Checks if an array of Objects is empty or {@code null}.
     *
     * @param array  the array to test
     * @return {@code true} if the array is empty or {@code null}
     * @since 2.1
     */
    public static boolean isEmpty(final Object[] array) {
        return getLength(array) == 0;
    }

    /**
     * <p>Checks if an array of primitive longs is empty or {@code null}.
     *
     * @param array  the array to test
     * @return {@code true} if the array is empty or {@code null}
     * @since 2.1
     */
    public static boolean isEmpty(final long[] array) {
        return getLength(array) == 0;
    }

    /**
     * <p>Checks if an array of primitive ints is empty or {@code null}.
     *
     * @param array  the array to test
     * @return {@code true} if the array is empty or {@code null}
     * @since 2.1
     */
    public static boolean isEmpty(final int[] array) {
        return getLength(array) == 0;
    }

    /**
     * <p>Checks if an array of primitive shorts is empty or {@code null}.
     *
     * @param array  the array to test
     * @return {@code true} if the array is empty or {@code null}
     * @since 2.1
     */
    public static boolean isEmpty(final short[] array) {
        return getLength(array) == 0;
    }

    /**
     * <p>Checks if an array of primitive chars is empty or {@code null}.
     *
     * @param array  the array to test
     * @return {@code true} if the array is empty or {@code null}
     * @since 2.1
     */
    public static boolean isEmpty(final char[] array) {
        return getLength(array) == 0;
    }

    /**
     * <p>Checks if an array of primitive bytes is empty or {@code null}.
     *
     * @param array  the array to test
     * @return {@code true} if the array is empty or {@code null}
     * @since 2.1
     */
    public static boolean isEmpty(final byte[] array) {
        return getLength(array) == 0;
    }

    /**
     * <p>Checks if an array of primitive doubles is empty or {@code null}.
     *
     * @param array  the array to test
     * @return {@code true} if the array is empty or {@code null}
     * @since 2.1
     */
    public static boolean isEmpty(final double[] array) {
        return getLength(array) == 0;
    }

    /**
     * <p>Checks if an array of primitive floats is empty or {@code null}.
     *
     * @param array  the array to test
     * @return {@code true} if the array is empty or {@code null}
     * @since 2.1
     */
    public static boolean isEmpty(final float[] array) {
        return getLength(array) == 0;
    }

    /**
     * <p>Checks if an array of primitive booleans is empty or {@code null}.
     *
     * @param array  the array to test
     * @return {@code true} if the array is empty or {@code null}
     * @since 2.1
     */
    public static boolean isEmpty(final boolean[] array) {
        return getLength(array) == 0;
    }

    // ----------------------------------------------------------------------
    /**
     * <p>Checks if an array of Objects is not empty and not {@code null}.
     *
     * @param <T> the component type of the array
     * @param array  the array to test
     * @return {@code true} if the array is not empty and not {@code null}
     * @since 2.5
     */
    public static <T> boolean isNotEmpty(final T[] array) {
        return !isEmpty(array);
    }

    /**
     * <p>Checks if an array of primitive longs is not empty and not {@code null}.
     *
     * @param array  the array to test
     * @return {@code true} if the array is not empty and not {@code null}
     * @since 2.5
     */
    public static boolean isNotEmpty(final long[] array) {
        return !isEmpty(array);
    }

    /**
     * <p>Checks if an array of primitive ints is not empty and not {@code null}.
     *
     * @param array  the array to test
     * @return {@code true} if the array is not empty and not {@code null}
     * @since 2.5
     */
    public static boolean isNotEmpty(final int[] array) {
        return !isEmpty(array);
    }

    /**
     * <p>Checks if an array of primitive shorts is not empty and not {@code null}.
     *
     * @param array  the array to test
     * @return {@code true} if the array is not empty and not {@code null}
     * @since 2.5
     */
    public static boolean isNotEmpty(final short[] array) {
        return !isEmpty(array);
    }

    /**
     * <p>Checks if an array of primitive chars is not empty and not {@code null}.
     *
     * @param array  the array to test
     * @return {@code true} if the array is not empty and not {@code null}
     * @since 2.5
     */
    public static boolean isNotEmpty(final char[] array) {
        return !isEmpty(array);
    }

    /**
     * <p>Checks if an array of primitive bytes is not empty and not {@code null}.
     *
     * @param array  the array to test
     * @return {@code true} if the array is not empty and not {@code null}
     * @since 2.5
     */
    public static boolean isNotEmpty(final byte[] array) {
        return !isEmpty(array);
    }

    /**
     * <p>Checks if an array of primitive doubles is not empty and not {@code null}.
     *
     * @param array  the array to test
     * @return {@code true} if the array is not empty and not {@code null}
     * @since 2.5
     */
    public static boolean isNotEmpty(final double[] array) {
        return !isEmpty(array);
    }

    /**
     * <p>Checks if an array of primitive floats is not empty and not {@code null}.
     *
     * @param array  the array to test
     * @return {@code true} if the array is not empty and not {@code null}
     * @since 2.5
     */
    public static boolean isNotEmpty(final float[] array) {
        return !isEmpty(array);
    }

    /**
     * <p>Checks if an array of primitive booleans is not empty and not {@code null}.
     *
     * @param array  the array to test
     * @return {@code true} if the array is not empty and not {@code null}
     * @since 2.5
     */
    public static boolean isNotEmpty(final boolean[] array) {
        return !isEmpty(array);
    }

}
