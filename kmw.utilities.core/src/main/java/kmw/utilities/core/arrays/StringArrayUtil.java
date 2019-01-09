package kmw.utilities.core.arrays;

import java.util.*;
import java.util.stream.Collectors;

import static kmw.utilities.core.arrays.ArrayServiceUtil.EMPTY_STRING_ARRAY;
import static kmw.utilities.core.strings.StringPool.*;
import static kmw.utilities.core.strings.StringServiceUtil.removeAnyChar;

public final class StringArrayUtil {

    private StringArrayUtil() {}

    //---------------------------------------------------------------------
    // Convenience methods for working with String arrays
    // From org.springframework:spring-core:4.1.2.RELEASE
    //      org.springframework.util.StringUtils
    //---------------------------------------------------------------------
    /**
     * Append the given String to the given String array, returning a new array consisting of the input array contents
     * plus the given String.
     *
     * @param array the array to append to (can be {@code null})
     * @param str the String to append
     * @return the new array (never {@code null})
     */
    public static String[] append(String[] array, String str) {
        if (ArrayServiceUtil.isNullOrEmpty(array)) {
            return new String[]{str};
        }
        String[] newArr = new String[array.length + 1];
        System.arraycopy(array, 0, newArr, 0, array.length);
        newArr[array.length] = str;
        return newArr;
    }

    /**
     * Concatenate the given String arrays into one, with overlapping array elements included twice.
     * <p>
     * The order of elements in the original arrays is preserved.
     *
     * @param array1 the first array (can be {@code null})
     * @param array2 the second array (can be {@code null})
     * @return the new array ({@code null} if both given arrays were {@code null})
     */
    public static String[] concat(String[] array1, String[] array2) {
        if (ArrayServiceUtil.isNullOrEmpty(array1)) {
            return array2;
        }
        if (ArrayServiceUtil.isNullOrEmpty(array2)) {
            return array1;
        }
        String[] newArr = new String[array1.length + array2.length];
        System.arraycopy(array1, 0, newArr, 0, array1.length);
        System.arraycopy(array2, 0, newArr, array1.length, array2.length);
        return newArr;
    }

    /**
     * Merge the given String arrays into one, with overlapping array elements only included once.
     * <p>
     * The order of elements in the original arrays is preserved (with the exception of overlapping elements, which are
     * only included on their first occurrence).
     *
     * @param array1 the first array (can be {@code null})
     * @param array2 the second array (can be {@code null})
     * @return the new array ({@code null} if both given arrays were {@code null})
     */
    public static String[] merge(String[] array1, String[] array2) {
        if (ArrayServiceUtil.isNullOrEmpty(array1)) {
            return array2;
        }
        if (ArrayServiceUtil.isNullOrEmpty(array2)) {
            return array1;
        }
        List<String> result = new ArrayList<>();
        result.addAll(Arrays.asList(array1));
        for (String str : array2) {
            if (!result.contains(str)) {
                result.add(str);
            }
        }
        return toStringArray(result);
    }

    /**
     * Turn given source String array into sorted array.
     *
     * @param array the source array
     * @return the sorted array (never {@code null})
     */
    public static String[] sort(String[] array) {
        if (ArrayServiceUtil.isNullOrEmpty(array)) {
            return EMPTY_STRING_ARRAY;
        }
        Arrays.sort(array);
        return array;
    }

    /**
     * Copy the given Collection into a String array. The Collection must contain String elements only.
     *
     * @param collection the Collection to copy
     * @return the String array ({@code null} if the passed-in Collection was {@code null})
     */
    public static String[] toStringArray(Collection<String> collection) {
        if (collection == null) {
            return null;
        }
        return collection.toArray(new String[collection.size()]);
    }

    /**
     * Copy the given Enumeration into a String array. The Enumeration must contain String elements only.
     *
     * @param enumeration the Enumeration to copy
     * @return the String array ({@code null} if the passed-in Enumeration was {@code null})
     */
    public static String[] toStringArray(Enumeration<String> enumeration) {
        if (enumeration == null) {
            return null;
        }
        List<String> list = Collections.list(enumeration);
        return list.toArray(new String[list.size()]);
    }

    /**
     * Trim the elements of the given String array, calling {@code String.trim()} on each of them.
     *
     * @param array the original String array
     * @return the resulting array (of the same size) with trimmed elements
     */
    public static String[] trimElements(String[] array) {
        if (ArrayServiceUtil.isNullOrEmpty(array)) {
            return EMPTY_STRING_ARRAY;
        }
        return toStringArray(Arrays.stream(array).map(s -> s.trim()).collect(Collectors.toList()));
    }

    /**
     * Remove duplicate Strings from the given array. Also sorts the array, as it uses a TreeSet.
     *
     * @param array the String array
     * @return an array without duplicates, in natural sort order
     */
    public static String[] removeDuplicates(String[] array) {
        if (ArrayServiceUtil.isNullOrEmpty(array)) {
            return array;
        }
        Set<String> set = new TreeSet<>();
        set.addAll(Arrays.asList(array));
        return toStringArray(set);
    }
    
    /*
     * Take an array of Strings and split each element based on the given delimiter. A {@code Properties} instance is then
     * generated, with the left of the delimiter providing the key, and the right of the delimiter providing the value.
     * <p>
     * Will trim both the key and value before adding them to the {@code Properties} instance.
     *
     * @param array the array to process
     * @param delimiter to split each element using (typically the equals symbol)
     * @return a {@code Properties} instance representing the array contents, or {@code null} if the array to process
     * was null or empty
     *
    public static PropertyMap splitArrayElementsIntoProperties(String[] array, String delimiter) {
        return splitArrayElementsIntoProperties(array, delimiter, null);
    }

    /*
     * Take an array Strings and split each element based on the given delimiter. A {@code Properties} instance is then
     * generated, with the left of the delimiter providing the key, and the right of the delimiter providing the value.
     * <p>
     * Will trim both the key and value before adding them to the {@code Properties} instance.
     *
     * @param array the array to process
     * @param delimiter to split each element using (typically the equals symbol)
     * @param charsToRemove one or more characters to remove from each element prior to attempting the split operation
     * (typically the quotation mark symbol), or {@code null} if no removal should occur
     * @return a {@code Properties} instance representing the array contents, or {@code null} if the array to process
     * was {@code null} or empty
     *
    public static PropertyMap splitArrayElementsIntoProperties(String[] array, String delimiter, String charsToRemove) {

        if (ArrayServiceUtil.isNullOrEmpty(array)) {
            return null;
        }
        ImmutableMap.Builder<String, String> builder = new ImmutableMap.Builder<>();
        for (String element : array) {
            if (charsToRemove != null) {
                element = removeAny(element, charsToRemove);
            }
            String[] splittedElement = split(element, delimiter);
            if (splittedElement == null) {
                continue;
            }
            builder.put(splittedElement[0].trim(), splittedElement[1].trim());
        }
        return PropertyMap.of(builder.build());
    }
    */

    /**
     * Tokenize the given String into a String array via a StringTokenizer. Trims tokens and omits empty tokens.
     * <p>
     * The given delimiters string is supposed to consist of any number of delimiter characters. Each of those
     * characters can be used to separate tokens. A delimiter is always a single character; for multi-character
     * delimiters, consider using {@code delimitedListToStringArray}
     *
     * @param str the String to tokenize
     * @param delimiters the delimiter characters, assembled as String (each of those characters is individually
     * considered as delimiter).
     * @return an array of the tokens
     * @see java.util.StringTokenizer
     * @see String#trim()
     * @see #csvToArray
     */
    public static String[] tokenize(String str, String delimiters) {
        return tokenize(str, delimiters, true, true);
    }

    /**
     * Tokenize the given String into a String array via a StringTokenizer.
     * <p>
     * The given delimiters string is supposed to consist of any number of delimiter characters. Each of those
     * characters can be used to separate tokens. A delimiter is always a single character; for multi-character
     * delimiters, consider using {@code delimitedListToStringArray}
     *
     * @param str the String to tokenize
     * @param delimiters the delimiter characters, assembled as String (each of those characters is individually
     * considered as delimiter)
     * @param trimTokens trim the tokens via String's {@code trim}
     * @param ignoreEmptyTokens omit empty tokens from the result array (only applies to tokens that are empty after
     * trimming; StringTokenizer will not consider subsequent delimiters as token in the first place).
     * @return an array of the tokens ({@code null} if the input String was {@code null})
     * @see java.util.StringTokenizer
     * @see String#trim()
     * @see #csvToArray
     */
    public static String[] tokenize(
            String str, String delimiters, boolean trimTokens, boolean ignoreEmptyTokens) {

        if (str == null) {
            return null;
        }
        StringTokenizer st = new StringTokenizer(str, delimiters);
        List<String> tokens = new ArrayList<>();
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (trimTokens) {
                token = token.trim();
            }
            if (!ignoreEmptyTokens || token.length() > 0) {
                tokens.add(token);
            }
        }
        return toStringArray(tokens);
    }

    /**
     * Take a String which is a delimited list and convert it to a String array.
     * <p>
     * A single delimiter can consists of more than one character: It will still be considered as single delimiter
     * string, rather than as bunch of potential delimiter characters - in contrast to {@code tokenizeToStringArray}.
     *
     * @param str the input String
     * @param delimiter the delimiter between elements (this is a single delimiter, rather than a bunch individual
     * delimiter characters)
     * @return an array of the tokens in the list
     * @see #tokenize
     */
    public static String[] csvToArray(String str, String delimiter) {
        return csvToArray(str, delimiter, null);
    }

    /**
     * Take a String which is a delimited list and convert it to a String array.
     * <p>
     * A single delimiter can consists of more than one character: It will still be considered as single delimiter
     * string, rather than as bunch of potential delimiter characters - in contrast to {@code tokenizeToStringArray}.
     *
     * @param str the input String
     * @param delimiter the delimiter between elements (this is a single delimiter, rather than a bunch individual
     * delimiter characters)
     * @param charsToRemove a set of characters to delete. Useful for deleting unwanted line breaks: e.g. "\r\n\f" will
     * delete all new lines and line feeds in a String.
     * @return an array of the tokens in the list
     * @see #tokenize
     */
    public static String[] csvToArray(String str, String delimiter, String charsToRemove) {
        if (str == null) {
            return EMPTY_STRING_ARRAY;
        }
        if (delimiter == null) {
            return new String[]{str};
        }
        List<String> result = new ArrayList<>();
        if (Strings_.EMPTY.equals(delimiter)) {
            for (int i = 0; i < str.length(); i++) {
                result.add(removeAnyChar(str.substring(i, i + 1), charsToRemove));
            }
        } else {
            int pos = 0;
            int delPos;
            while ((delPos = str.indexOf(delimiter, pos)) != -1) {
                result.add(removeAnyChar(str.substring(pos, delPos), charsToRemove));
                pos = delPos + delimiter.length();
            }
            if (str.length() > 0 && pos <= str.length()) {
                // Add rest of String, but not in case of empty input.
                result.add(removeAnyChar(str.substring(pos), charsToRemove));
            }
        }
        return toStringArray(result);
    }

    /**
     * Convert a CSV list into an array of Strings.
     *
     * @param str the input String
     * @return an array of Strings, or the empty array in case of empty input
     */
    public static String[] csvToArray(String str) {
        return csvToArray(str, Strings_.COMMA);
    }

    /**
     * Convenience method to convert a CSV string list to a set. Note that this will suppress duplicates.
     *
     * @param str the input String
     * @return a Set of String entries in the list
     */
    public static Set<String> csvToSet(String str) {
        Set<String> set = new TreeSet<>();
        String[] tokens = csvToArray(str);
        set.addAll(Arrays.asList(tokens));
        return set;
    }

    /**
     * Convenience method to return a Collection as a delimited (e.g. CSV) String. E.g. useful for {@code toString()}
     * implementations.
     *
     * @param coll the Collection to display
     * @param delim the delimiter to use (probably a ",")
     * @param prefix the String to start each element with
     * @param suffix the String to end each element with
     * @return the delimited String
     */
    public static String collectionToCsv(Collection<?> coll, String delim, String prefix, String suffix) {
        if (coll.isEmpty()) {
            return Strings_.EMPTY;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<?> it = coll.iterator();
        while (it.hasNext()) {
            sb.append(prefix).append(it.next()).append(suffix);
            if (it.hasNext()) {
                sb.append(delim);
            }
        }
        return sb.toString();
    }

    /**
     * Convenience method to return a Collection as a delimited (e.g. CSV) String. E.g. useful for {@code toString()}
     * implementations.
     *
     * @param coll the Collection to display
     * @param delim the delimiter to use (probably a ",")
     * @return the delimited String
     */
    public static String collectionToCsv(Collection<?> coll, String delim) {
        return collectionToCsv(coll, delim, Strings_.EMPTY, Strings_.EMPTY);
    }

    /**
     * Convenience method to return a Collection as a CSV String. E.g. useful for {@code toString()} implementations.
     *
     * @param coll the Collection to display
     * @return the delimited String
     */
    public static String collectionToCsv(Collection<?> coll) {
        return collectionToCsv(coll, Strings_.COMMA);
    }

    /**
     * Convenience method to return a String array as a delimited (e.g. CSV) String. E.g. useful for {@code toString()}
     * implementations.
     *
     * @param arr the array to display
     * @param delim the delimiter to use (probably a ",")
     * @return the delimited String
     */
    public static String arrayToCsv(Object[] arr, String delim) {
        if (ArrayServiceUtil.isNullOrEmpty(arr)) {
            return Strings_.EMPTY;
        }
        if (arr.length == 1) {
            return arr[0] == null ? Strings_.NULL : arr[0].toString();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) {
                sb.append(delim);
            }
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    /**
     * Convenience method to return a String array as a CSV String. E.g. useful for {@code toString()} implementations.
     *
     * @param arr the array to display
     * @return the delimited String
     */
    public static String arrayToCsv(Object[] arr) {
        return arrayToCsv(arr, Strings_.COMMA);
    }
}
