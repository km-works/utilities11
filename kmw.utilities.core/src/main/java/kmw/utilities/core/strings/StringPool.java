package kmw.utilities.core.strings;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class StringPool {

    private StringPool() {}

    public static String format(@Nonnull final String fmt, @Nullable final Object... args) {
        return String.format(fmt, args);
    }

    public static class Chars_ {
        public static final char COLON = ':';
        public static final char COMMA = ',';
        public static final char DOLLAR = '$';
        public static final char DOT = '.';
        public static final char LEFT_SQUARE = '[';
        public static final char RIGHT_SQUARE = ']';
        public static final char SEMICOLON = ';';
        public static final char SPACE = ' ';
    }

    public static class Strings_ {
        public static final String COMMA = String.valueOf(Chars_.COMMA);
        public static final String EMPTY = "";
        public static final String NULL = "null";
    }

    public static class Messages_ {
        public static final String PARAM_1_2_MUST_NOT_BE_NULL = "Param-%d: %s must not be null";
        public static final String PARAM_1_2_MUST_BE_POSITIVE = "Param-%d: %s must be positive";
    }

}
