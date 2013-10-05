
public class HashFill {

	private HashObject[] hashTable;
    private int longestChain;
    private int hashTableSize = 15077;

	/**
	 * sets the size of the table
	 * uses a constant prime number to ensure that the hash
	 * function developed occurs at optimal efficiency
	 */
	public void generateTable()
	{
		hashTable = new HashObject[(int) (hashTableSize)];
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
	 */
	public void fillTable(HashObject newEntry)
	{
		if(hashTable[newEntry.getTag()]==null)
			hashTable[newEntry.getTag()]=newEntry;
		else
			linearParse(newEntry);
	}
	/**
	 * method to check one spot at a time until and open spot is found
	 * the method will loop from the bottom to the top
	 * @param newEntry
	 */
	private void linearParse(HashObject newEntry) {

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

	public HashObject[] getTable()
	{
		return hashTable;
	}

    public int getHashTableSize() {
        return hashTableSize;
    }

    public void setHashTableSize(int hashTableSize) {
        this.hashTableSize = hashTableSize;
    }




}