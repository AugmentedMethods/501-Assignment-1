import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: Sean
 * Date: 10/10/13
 * Time: 9:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class HashEvaluationTest {

    HashEvaluation testObj;

    @Before
    public void setUp() throws Exception {
        HashFill testFill = new HashFill();
        testFill.generateTable();
        testFill.fillTable(new HashObject("string", 1));
        testFill.fillTable(new HashObject("word", 1));


        testObj = new HashEvaluation(testFill);
    }

    @After
    public void tearDown() throws Exception {
        testObj = null;
    }

    @Test
    public void testGetLoadFactor() throws Exception {
       testObj.searchLength(new HashObject("string", 1), 2);
        double load = testObj.getLoadFactor(0);
        boolean test = load >= 0;
        assertTrue(test);
    }

    @Test
    public void testHashEfficiency() throws Exception {
        testObj.searchLength(new HashObject("string", 1), 2);
        double effi = testObj.hashEfficiency(1, 2);
        boolean test = effi >= 0;
        assertTrue(test);
    }

    @Test
    public void testGetLongestChain() throws Exception {
        testObj.searchLength(new HashObject("string", 1), 2);
        double chain = testObj.getLongestChain();
        boolean test = chain >= 0;
        assertTrue(test);
    }
}
