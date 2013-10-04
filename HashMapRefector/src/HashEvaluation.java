/**
 * Created with IntelliJ IDEA.
 * User: Sean
 * Date: 10/4/13
 * Time: 3:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class HashEvaluation {

    private hashObject[] hashTable;
    private int totalNumberOfSearches;
    private int hashTableSize;

    private int longestChain;

    public HashEvaluation(HashFill hashObj)
    {
        hashTable = hashObj.getTable();
        hashTableSize = hashObj.getHashTableSize();
        totalNumberOfSearches = 0;
    }

    /**
     * @return
     * This is a new Comment
     */
    public double getLoadFactor(int stringsInFile)
    {
        return (double)stringsInFile/hashTable.length;
    }

    /**
     * Calculates the longest chain and the average search length of each word in the given list
     * @param wordToFind
     * @param listSize
     */
    public void searchLength(hashObject wordToFind, int listSize)
    {
        int currentLength=0;
        hashObject temp;
        currentLength=1;
        int counter2=0;
        temp = hashTable[wordToFind.getTag()];
        //keeps moving until the desired location is found
        while(!temp.getWord().equals(wordToFind.getWord())&&wordToFind.getTag()+currentLength<hashTable.length)
        {
            temp = hashTable[wordToFind.getTag()+currentLength];
            currentLength++;
        }
        //keeps moving until the desired location is found
        if(currentLength+1+wordToFind.getTag()==hashTable.length&&!temp.getWord().equals(wordToFind.getWord()))
        {
            while(!temp.getWord().equals(wordToFind.getWord())&&counter2<wordToFind.getTag())
            {
                temp = hashTable[counter2];
                counter2++;
                currentLength++;
            }
        }
        //add to the average for a true average can be taken at the end
        totalNumberOfSearches+=currentLength;
        if(currentLength>longestChain)
        {
            //replace longest chain if the current length is greater
            longestChain = currentLength;
        }
    }
    /**
     * Hash efficiency calculator
     * @return
     */
    public double hashEfficiency(double loadFactor, int numberOfStrings)
    {
        double averageSearchLength = (double)totalNumberOfSearches/numberOfStrings;
        System.out.println("The average Search length is: "+averageSearchLength);
        return loadFactor/averageSearchLength;
    }

    public int getLongestChain() {

        return longestChain;
    }

}
