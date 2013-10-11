/**
 * Created with IntelliJ IDEA.
 * User: Sean
 * Date: 10/4/13
 * Time: 3:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class HashEvaluation {

    private HashObject[] hashTable;
    private int totalNumberOfSearches;
    private int hashTableSize;

    private HashObject currentHashObj;
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

    public void searchLength(HashObject hashToFind, int listSize)
    {
        int currentLength=1;
        currentHashObj = hashTable[hashToFind.getHashTag()];

        currentLength = middleDownSearch(hashToFind, currentLength);
        //check the end of the array
        int outLimitCheck = currentLength+1+hashToFind.getHashTag();

        if(outLimitCheck == hashTable.length  &&  !currentHashObj.getWord().equals(hashToFind.getWord()))
            currentLength = topToMiddleSearch(hashToFind, currentLength);

        //add to the average for a true average can be taken at the end
        totalNumberOfSearches +=currentLength;

        //swap if old lowest if smaller
        if(currentLength>longestChain)
            longestChain = currentLength;
    }

    int middleDownSearch(HashObject hashToFind, int currentLength)
    {
        //keeps moving until the desired location is found
        while(!currentHashObj.getWord().equals(hashToFind.getWord())&& hashToFind.getHashTag()+currentLength<hashTable.length)
        {
            currentHashObj = hashTable[hashToFind.getHashTag()+currentLength];
            currentLength++;
        }
        return currentLength;
    }

    int topToMiddleSearch(HashObject hashToFind, int currentLength)
    {
        int counter= 0;
        String wordToFind = hashToFind.getWord();
        while(!currentHashObj.getWord().equals(wordToFind) && counter<hashToFind.getHashTag())
        {
            currentHashObj = hashTable[counter];
            counter++;
            currentLength++;
        }
        return currentLength;
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