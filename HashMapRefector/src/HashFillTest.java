import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: Sean
 * Date: 10/10/13
 * Time: 9:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class HashFillTest {

    HashFill testObj;

    @Before
    public void setUp() throws Exception {
        testObj = new HashFill();
    }

    @After
    public void tearDown() throws Exception {
        testObj = null;
    }

    @Test
    public void testGenerateTable() throws Exception {
        testObj.generateTable();
        boolean test = testObj.getTable().length >= 0;
        assertTrue(test);
    }

    @Test
    public void testHashFunction() throws Exception {
        testObj.generateTable();
        int hashValue = testObj.hashFunction("word");
        boolean test = (hashValue < testObj.getHashTableSize());

        assertTrue(test);
    }

    @Test
    public void testFillTable() throws Exception {
        testObj.generateTable();
        int hashValue = testObj.hashFunction("String");
        HashObject testHash = new HashObject("String", hashValue);
        testObj.fillTable(testHash);
        assertEquals("Fail", testHash.getWord(), testObj.getTable()[hashValue].getWord());
    }

    @Test
    public void testLinearParse()
    {
        testObj.generateTable();
        int hashValue = testObj.hashFunction("String");
        HashObject testHash = new HashObject("String", hashValue);
        testObj.fillTable(testHash);

        testHash = new HashObject("newString", hashValue);
        testObj.fillTable(testHash);

        assertEquals("Fail", testHash.getWord(), testObj.getTable()[hashValue+1].getWord());
    }

    @Test
    public void testGetHashTableSize() throws Exception {
        testObj.generateTable();
        assertEquals((long)testObj.getHashTableSize(), (long)testObj.getTable().length);
    }

    @Test
    public void testSetHashTableSize() throws Exception {
        testObj.setHashTableSize(100);
        testObj.generateTable();
        assertEquals((long)testObj.getHashTableSize(), 100);
    }
}
