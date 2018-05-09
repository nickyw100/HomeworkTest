package test;

import com.Ntrepid.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class SolutionTest {
    static List<String> u1 = Arrays.asList(
            "/-> ", "careers-> ", "mission-> ", "contact");

    static List<String> u2 = Arrays.asList(
            "/-> ", "careers-> ", "mission-> ", "contact");

    static List<String> u3 = Arrays.asList(
            "/-> ", "about-> ", "blog");
    public static HashMap<String, List<String>> map1 = new HashMap<String, List<String>>() {

        {
            put("u1", u1);
            put("u2", u2);
            put("u3", u3);
        }
    };
    static List<String> u4 = Arrays.asList(
            "/-> ", "home-> ", "player-> ", "interview");
    static List<String> u5 = Arrays.asList(
            "/-> ", "home-> ", "player-> ", "interview");
    static List<String> u6 = Arrays.asList(
            "/-> ", "home-> ", "player-> ", "stats");
    public static HashMap<String, List<String>> map2 = new HashMap<String, List<String>>() {

        {
            put("u4", u4);
            put("u5", u5);
            put("u6", u6);
        }

    };
    static List<String> u7 = Arrays.asList(
            "/-> ", "home-> ", "palace-> ", "stats-> ", "relegated-> ");
    static List<String> u8 = Arrays.asList(
            "/-> ", "home-> ", "palace-> ", "stats-> ", "relegated-> ");
    static List<String> u9 = Arrays.asList(
            "/-> ", "home-> ", "palace-> ", "stats-> ", "promoted-> ");
    static List<String> u10 = Arrays.asList(
            "/-> ", "home-> ", "palace-> ", "stats-> ", "relegated-> ");

    public static HashMap<String, List<String>> map3 = new HashMap<String, List<String>>() {

        {
            put("u7", u7);
            put("u8", u8);
            put("u9", u9);
            put("u10", u10);
        }

    };

    @Test
    public void testParseDataPathsHappyPath1() {

        Solution solution = new Solution();

        String result = solution.parsePathLogs(map1, 2);
        Assertions.assertNotNull("List of Paths retrieved must not be null", result);
        Assertions.assertEquals("[careers-> mission-> contact, /-> careers-> mission-> ]", result);

    }

    @Test
    public void testParseDataPathsHappyPath2() {

        Solution solution = new Solution();

        String result = solution.parsePathLogs(map2, 3);
        Assertions.assertNotNull("List of Paths retrieved must not be null", result);
        Assertions.assertEquals("[/-> home-> player-> , home-> player-> interview, home-> player-> stats]", result);

    }


    @Test
    public void testParseDataPathsHappyPath3() {

        Solution solution = new Solution();

        String result = solution.parsePathLogs(map3, 4);
        Assertions.assertNotNull("List of Paths retrieved must not be null", result);
        Assertions.assertEquals("[/-> home-> palace-> , home-> palace-> stats-> , palace-> stats-> relegated-> , palace-> stats-> promoted-> ]", result);

    }

    @Test
    public void testParseDataPathsNegativePath1() {

        Solution solution = new Solution();
        // Pass in a value of zero for the number to return to make sure it returns without processing.
        String result = solution.parsePathLogs(map2, 0);
        Assertions.assertNull(result);

    }

    @Test
    public void testParseDataPathsNegativePath2() {

        Solution solution = new Solution();
        // Pass in a null List to make sure it returns without processing.
        String result = solution.parsePathLogs(null, 5);
        Assertions.assertNull(result);

    }

    @Test
    public void testParseDataPathsNegativePath3() {

        Solution solution = new Solution();
        // Pass in a high value for the number to return to make sure it returns without processing.
        String result = solution.parsePathLogs(map2, 99);
        Assertions.assertNotNull("List of Paths retrieved must not be null", result);
        Assertions.assertEquals("[/-> home-> player-> , home-> player-> interview, home-> player-> stats]", result);

    }

}
