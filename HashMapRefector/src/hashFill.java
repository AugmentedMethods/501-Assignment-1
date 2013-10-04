
public class hashFill {

	private hashObject[] hashTable;
	private double loadFactor;
	private int longestChain=0;
	private double averageSearch=0;
	private int currentLength=0;
	private double hashEfficency =0;
    private int hashTableSize = 15077;
	
	/**
	 * sets the size of the table
	 * uses a constant prime number to ensure that the hash
	 * function developed occurs at optimal efficiency
	 * @param listSize
	 */
	public void generateTable(int listSize)
	{
		hashTable = new hashObject[(int) (hashTableSize)];
	}
	/**
	 * Refactored, made the hash function a class
	 * @param word
	 * @param 
	 * @return
	 */
	public int hashFunction(String word)
	{
        return HashFunction.calculateHashValue(word) % hashTable.length;
	}
	/**
	 * adds the new entry to the table depending on the hash tag
	 * if there is an opening add it to the correct spot, if not 
	 * Perform linear Parse
	 * @param newEntry
	 * @param listSize
	 */
	public void fillTable(hashObject newEntry,int listSize)
	{
		if(hashTable[newEntry.getTag()]==null)
			hashTable[newEntry.getTag()]=newEntry;

		else
			linearParse(newEntry,listSize);

	}
	/**
	 * method to check one spot at a time until and open spot is found
	 * the method will loop from the bottom to the top
	 * @param newEntry
	 * @param listSize
	 */
	private void linearParse(hashObject newEntry, int listSize) {
		for(int counter =1; counter+newEntry.getTag()<hashTable.length;counter++)
		{
			if(hashTable[newEntry.getTag()+counter]==null)
			{
				hashTable[newEntry.getTag()+counter]=newEntry;
				return;
			}
		}
		for(int counter =0; counter<newEntry.getTag();counter++){
			if(hashTable[counter]==null)
			{
				hashTable[counter]=newEntry;
				return;
			}
		}
		
	}

	/**
	 * @param listSize
	 * @return
     * This is a new Comment
	 */
	public double getLoadFactor(int listSize)
	{
		double value = listSize;
		double value2 =hashTable.length;
		loadFactor = value/value2;
		return loadFactor;
	}
	
	/**
	 * Calculates the longest chain and the average search length of each word in the given list
	 * @param wordToFind
	 * @param listSize
	 */
	public void searchLength(hashObject wordToFind, int listSize)
	{
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
		averageSearch+=currentLength;
		if(currentLength>longestChain)
		{
			//replace longest chain if the current length is greater
			longestChain = currentLength;
		}		
	}
	
	public hashObject[] getTable()
	{
		return hashTable;
	}
	
	
	public int getLongestChain()
	{
		return longestChain;
	}
	
	/**
	 * Hash efficiency calculator
	 * @param listSize
	 * @return
	 */
	public double hashEfficiency(int listSize)
	{
		double value1=averageSearch;
		averageSearch=value1/listSize;
		System.out.println("The average Search length is: "+averageSearch);
		hashEfficency = (loadFactor/averageSearch);
		return hashEfficency;
	}
}