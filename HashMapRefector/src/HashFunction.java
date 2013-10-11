/**
 * Created with IntelliJ IDEA.
 * User: Sean
 * Date: 10/4/13
 * Time: 1:34 AM
 * To change this template use File | Settings | File Templates.
 */
public class HashFunction {

    private HashFunction(){}

    public static int calculateHashValue(String word)
    {
        int hash = 15077;
        //basic idea is to read each character and perform a couple logical operations on each character
        for (int i =0; i < word.length(); i++) {
            if(word.charAt(i)>='a' && word.charAt(i)<='z')
                hash = 37 * hash + word.charAt(i);

            hash = 37 ^ hash + word.charAt(i)/79;
            hash = ((hash << 5) + hash) + word.charAt(i);
        }
        return Math.abs(hash);
    }
}
