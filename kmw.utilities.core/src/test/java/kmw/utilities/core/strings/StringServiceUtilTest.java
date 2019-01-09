package kmw.utilities.core.strings;

import static junit.framework.TestCase.*;

import com.google.inject.Guice;
import kmw.utilities.core.UtilitiesCoreModule;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.regex.Pattern;

public class StringServiceUtilTest {

    @Test
    public void testIsBlank() {
        assertTrue(StringServiceUtil.isBlank(" "));
        assertTrue(StringServiceUtil.isBlank("  "));
        assertTrue(StringServiceUtil.isBlank(""));
        assertTrue(StringServiceUtil.isBlank(null));
        assertTrue(StringServiceUtil.isBlank("\r\n"));
        assertTrue(StringServiceUtil.isBlank("\t "));
     }


    @Test
    public void testCountNewlines() {
        assertEquals(2, StringServiceUtil.countNewlines("\r\n\n\r\r "));
    }


    @Test
    public void testGetFileExt() {
        assertEquals("ext", StringServiceUtil.getFileExt("filename.one.ext"));
        assertEquals("", StringServiceUtil.getFileExt("filename"));
        assertEquals("ext", StringServiceUtil.getFileExt(".ext"));
        assertEquals("", StringServiceUtil.getFileExt(null));
        assertEquals("", StringServiceUtil.getFileExt(""));
    }


    @Test
    public void testStripFileExt() {
        assertEquals("filename", StringServiceUtil.stripFileExt("filename.two"));
        assertEquals("filename", StringServiceUtil.stripFileExt("filename"));
        assertEquals("", StringServiceUtil.stripFileExt(".ext"));
        assertEquals("", StringServiceUtil.stripFileExt(null));
        assertEquals("", StringServiceUtil.stripFileExt(""));
    }

    @Test
    public void testCountMatches() {
        assertEquals(3, StringServiceUtil.countMatches(" . ..", Pattern.compile("\\.")));
    }

    @Test
    public void testRemoveWithespace() {
        assertEquals("123abc", StringServiceUtil.removeWhitespace(" 12\t3\na bc\r\n"));
    }

}
