package kmw.utilities.core.strings;

import com.google.common.base.Splitter;
import com.google.common.base.Strings;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.Arrays;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static kmw.utilities.core.strings.StringPool.*;

public final class StringServiceUtil {

    /*
     * ==========
     * from JDK11
     * ==========
     */

    @Nonnull public static Stream<String> lines(@Nullable final String string) {
        return string == null ? Stream.of() : Arrays.stream(string.split("\\r?\\n")); //JDK11: string.lines();
    }

    @Nonnull public static String strip(@Nullable final String string) {
        return stripLeading(stripTrailing(string));
    }

    @Nonnull public static String stripLeading(@Nullable final String string) {
        //JDK11: return nullToEmpty(string.stripLeading());
        if (isBlank(string)) return Strings_.EMPTY;
        final String nnString = nullToEmpty(string);
        int pos = 0;
        while (Character.isWhitespace(nnString.charAt(pos))) {
            pos++;
        }
        return nnString.substring(pos);
    }

    @Nonnull public static String stripTrailing(@Nullable final String string) {
        //JDK11: return nullToEmpty(string.stripTrailing());
        if (isBlank(string)) return Strings_.EMPTY;
        final String nnString = nullToEmpty(string);
        int pos = nnString.length() - 1;
        while (Character.isWhitespace(nnString.charAt(pos))) {
            pos--;
        }
        return nnString.substring(0, pos+1);
    }

    public static boolean isBlank(@Nullable final String string) {
        return !nullToEmpty(string).codePoints().anyMatch(ch -> !Character.isWhitespace(ch));
    }

    /*
     * ==========
     * from Guava
     * ==========
     */

    public static boolean isNullOrEmpty(@Nullable final String string) {
        return string == null || string.isEmpty();
    }

    @Nullable public static String emptyToNull(@Nullable final String string) {
        return isNullOrEmpty(string) ? null : string;
    }

    @Nonnull public static String nullToEmpty(@Nullable final String string) {
        return string == null ? Strings_.EMPTY : string;
    }

    @Nonnull public static String repeat(@Nullable final String string, int count) {
        checkArgument(count >= 0, format(Messages_.PARAM_1_2_MUST_BE_POSITIVE, 2, "count"));
        return Strings.repeat(nullToEmpty(string), count);
    }

    @Nonnull public static String commonPrefix(@Nullable final String a, @Nullable final String b) {
        return Strings.commonPrefix(nullToEmpty(a), nullToEmpty(b));
    }

    @Nonnull public static String commonSuffix(@Nullable final String a, @Nullable final String b) {
        return Strings.commonSuffix(nullToEmpty(a), nullToEmpty(b));
    }

    @Nonnull public static String padEnd(@Nullable final String string, int minLength, char padChar) {
        return Strings.padEnd(nullToEmpty(string), minLength, padChar);
    }

    @Nonnull public static String padStart(@Nullable final String string, int minLength, char padChar) {
        return Strings.padStart(nullToEmpty(string), minLength, padChar);
    }

    @Nonnull public static Iterable<String> split(@Nullable final String string, @Nonnull Pattern pattern) {
        return Splitter.on(pattern).split(nullToEmpty(string));
    }

    @Nonnull public static Iterable<String> split(@Nullable final String string, @Nonnull Pattern pattern, int limit) {
        return Splitter.on(pattern).limit(limit).split(nullToEmpty(string));
    }

    /*
     * ==========
     * from Kotlin StdLib
     * ==========
     */

    /*
     * ===============
     * from utilities8
     * ===============
     */

    public static boolean hasLength(@Nullable final String string) {
        return !isNullOrEmpty(string);
    }

    public static boolean hasText(@Nullable final String string) {
        return !isBlank(string);
    }

    @Nonnull public static String nvl(@Nullable String string, @Nonnull String defaultValue) {
        checkNotNull(defaultValue, format(Messages_.PARAM_1_2_MUST_NOT_BE_NULL, 2, "defaultValue"));
        return string == null ? defaultValue : string;
    }

    @Nullable public static String apply(@Nullable String string, @Nonnull Function<String, String> fn) {
        checkNotNull(fn, format(Messages_.PARAM_1_2_MUST_NOT_BE_NULL, 2, "fn"));
        return string == null ? null : fn.apply(string);
    }

    @Nonnull public static String substringReverse(@Nullable String string, int beginIdx, int endIdx)
            throws IndexOutOfBoundsException {
        final String nnString = nullToEmpty(string);
        final int len = nnString.length();
        return nnString.substring(len - endIdx, len - beginIdx);
    }

    @Nonnull public static String substringReverse(@Nullable String str, int endIdx)
            throws IndexOutOfBoundsException {
        return substringReverse(str, 0, endIdx);
    }

    public static int countMatches(@Nullable String string, @Nonnull Pattern pattern) {
        checkNotNull(pattern, format(Messages_.PARAM_1_2_MUST_NOT_BE_NULL, 2, "pattern"));
        Matcher matcher = pattern.matcher(nullToEmpty(string));
        return (int)matcher.results().count();
    }

    public static int countNewlines(@Nullable final String string) {
        return countMatches(string, Pattern.compile("\r?\n"));
    }

    /**
     * Remove any given character in a String.
     *
     * @param string the original String
     * @param charsToDelete a set of characters to remove. E.g. "az\n" will remove 'a's, 'z's and new lines.
     * @return the resulting String
     */
    @Nonnull public static String removeAnyChar(@Nullable final String string, @Nullable final String charsToDelete) {
        if (isNullOrEmpty(charsToDelete)) {
            return string;
        }
        return nullToEmpty(string).codePoints().filter(ch -> charsToDelete.indexOf(ch) == -1)
                .collect(StringBuilder::new, (sb, c) -> sb.append((char)c), StringBuilder::append)
                .toString();
    }

    @Nonnull public static String removeWhitespace(@Nullable String string) {
        return nullToEmpty(string).codePoints().filter(ch -> !Character.isWhitespace(ch))
                .collect(StringBuilder::new, (sb, c) -> sb.append((char)c), StringBuilder::append)
                .toString();
    }

    /**
     * Utility to normalize whitespace in a String, i.e. collapses any sequence whitespaces (spaces, tabs, linefeeds
     * etc) into a single ' ' (blank) character. Note: doesn't trim() or strip() the string, however,
     * whitespace at the beginning and end is also normalized.
     *
     * @param string String to normalize
     * @return normalized version of string.
     */
    @Nonnull public static String normalizeWhitespace(@Nullable final String string) {
        final StringBuilder sb = new StringBuilder();
        final CharacterIterator iter = new StringCharacterIterator(nullToEmpty(string));
        var inWhitespace = false; // Set if we're in a consecutive whitespace after the first one
        for (var ch = iter.first(); ch != CharacterIterator.DONE; ch = iter.next()) {
            if (Character.isWhitespace(ch)) {
                if (!inWhitespace) {
                    sb.append(Chars_.SPACE);
                    inWhitespace = true;
                }
            } else {
                inWhitespace = false;
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    @Nonnull public static String getFileExt(@Nullable final String fileName) {
        final String nnString = nullToEmpty(fileName);
        final int pos = nnString.lastIndexOf(Chars_.DOT);
        return (pos < 0 ? Strings_.EMPTY : nnString.substring(pos + 1));
    }

    @Nonnull public static String stripFileExt(@Nullable final String fileName) {
        final String nnString = nullToEmpty(fileName);
        final int pos = nnString.lastIndexOf(Chars_.DOT);
        return (pos < 0 ? nnString : nnString.substring(0, pos));
    }

    @Nonnull public static String toLower(@Nullable String string) {
        return nullToEmpty(string).toLowerCase();
    }

    @Nonnull public static String toUpper(@Nullable String string) {
        return nullToEmpty(string).toUpperCase();
    }

    @Nonnull public static String toProper(@Nullable String string) {
        return null;
    }


}
