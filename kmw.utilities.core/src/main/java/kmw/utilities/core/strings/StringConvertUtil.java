package kmw.utilities.core.strings;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.google.common.base.Preconditions.checkNotNull;
import static kmw.utilities.core.strings.StringServiceUtil.*;

public class StringConvertUtil {

    private StringConvertUtil() {
    }

    public static ByteBuffer toByteBuffer(@Nonnull final String string, @Nonnull final Charset charset) {
        checkNotNull(string);
        checkNotNull(charset);
        return ByteBuffer.wrap(string.getBytes(charset));
    }

    public static CharBuffer toCharBuffer(@Nonnull final String string, @Nonnull final Charset charset) {
        return toByteBuffer(string, charset).asCharBuffer();
    }

    @Nonnull
    public static String fromByteBuffer(@Nonnull final ByteBuffer buffer, @Nonnull final Charset charset) {
        checkNotNull(buffer);
        checkNotNull(charset);
        byte[] bytes;
        if (buffer.hasArray()) {
            bytes = buffer.array();
        } else {
            bytes = new byte[buffer.remaining()];
            buffer.get(bytes);
        }
        return new String(bytes, charset);
    }

    /**
     * Null-tolerant, case-insensitive conversion to Boolean. The following string values are all mapped to true:
     * "true", "1", "y", "yes", "on"
     *
     * @param string String value to be converted to boolean or null
     * @return Boolean value or null
     */
    public static boolean toBoolean(@Nullable final String string) {
        final String str = toLower(string);
        if (isNullOrEmpty(str)) return false;
        try {
            return Boolean.valueOf(str);
        } catch (Exception ex) {
            return str.equals("1") || str.equals("y") || str.equals("on") || str.equals("yes");
        }
    }

    /**
     * Null-tolerant conversion to Integer.
     *
     * @param string String value to be converted to Integer or null
     * @return Integer value, if string can be parsed, or null otherwise
     */
    @Nullable
    public static Integer toInteger(@Nullable final String string) {
        try {
            return Integer.valueOf(nullToEmpty(string));
        } catch (NumberFormatException ex) {
            return null;
        }
    }

    public static boolean isInteger(@Nullable final String string) {
        return toInteger(string) != null;
    }

    @Nonnull
    public static String zeroPaddedString(final int number, final int totalWidth) {
        final String fmtString = "%1$0" + totalWidth + "d";
        return String.format(fmtString, number);
    }

    @Nonnull
    public static String isoDateTimeString(@Nonnull final Date date) {
        return dateTimeString(date, "yyyy-MM-dd'T'HH:mm:ss");
    }

    @Nonnull
    public static String isoDateString(@Nonnull final Date date) {
        return dateTimeString(date, "yyyy-MM-dd");
    }

    @Nonnull
    public static String dateTimeString(@Nonnull final Date dateTime, @Nonnull final String simpleDateTimeFormat) {
        checkNotNull(dateTime);
        checkNotNull(simpleDateTimeFormat);
        final SimpleDateFormat sdf = new SimpleDateFormat(simpleDateTimeFormat);
        return sdf.format(dateTime);
    }

    @Nonnull
    public static String dateTimeString(final long milliseconds, @Nonnull final String simpleDateTimeFormat) {
        checkNotNull(simpleDateTimeFormat);
        return dateTimeString(new Date(milliseconds), simpleDateTimeFormat);
    }

}
