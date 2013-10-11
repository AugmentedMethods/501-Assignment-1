import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: Sean
 * Date: 10/10/13
 * Time: 9:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class HashFunctionTest {
    @Test
    public void testCalculateHashValue() throws Exception {
        testEmpty();
        testLong();
        nonLetterSymbols();
        mixedWordTest();
    }

    @Test
    public void testEmpty()
    {
        int number = HashFunction.calculateHashValue("");
        boolean check = (number >= 0);
        assertTrue(check);
    }

    @Test
    public void testLong()
    {
        String longWord = "abcdefghijklmnopqrstuvwxyzqwertyuiopasdfghjklzxcvbnm";
        int number = HashFunction.calculateHashValue(longWord);
        boolean check = (number >= 0);
        assertTrue(check);
    }

    public void nonLetterSymbols()
    {
        String mixedWord = "1234567890-=[],.!@#$%^&*()_+|<>?";
        int number = HashFunction.calculateHashValue(mixedWord);
        boolean check = (number >= 0);
        assertTrue(check);
    }

    public void mixedWordTest()
    {
        String mixedWord = "qwertyuiop[]1234567890-=zxc.,";
        int number = HashFunction.calculateHashValue(mixedWord);
        boolean check = (number >= 0);
        assertTrue(check);
    }

}
