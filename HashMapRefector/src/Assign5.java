import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;



public class Assign5 {

	private int listSize = 0;
	private hashFill hashTable = new hashFill();
	private hashObject newEntry;
	
	public static void main(String args[]) throws IOException
	{
		if(args.length!=1)
		{
			System.out.println("Failed need a file");
		}
	Assign5 testCase = new Assign5();
	testCase.linesInFile("input.txt");
	testCase.hashTable.generateTable(testCase.getListSize());
	testCase.fileReader("input.txt");
	System.out.println("Load Factor: "+(testCase.hashTable.getLoadFactor(testCase.getListSize())*100));
	testCase.fileSearch("input.txt");
	System.out.println("Efficiency: "+(testCase.hashTable.hashEfficiency(testCase.getListSize())*100));
	System.out.println("Longest Chain: "+testCase.hashTable.getLongestChain());
	testCase.fileMaker("input.txt");

	}
	/**
	 * This method simply find the number of items in the list of words given
	 * @param fileName
	 * @return
	 */
	private String linesInFile(String fileName)
	{
		try{
			  // Open the file that is the first 
			  // command line parameter
			  FileInputStream fstream = new FileInputStream(fileName);
			  // Get the object of DataInputStream
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String tempString = new String();
			
			  
			  while((tempString = br.readLine())!= null)
			  {
				  listSize++;
			  }
			in.close();
			  //Close the input stream
			
			    }catch (Exception e){//Catch exception if any
			  System.err.println("Could not find the file, try again: " + e.getMessage());
			  return "failed";
			  }
	//	System.out.println(listSize);
		return "";	
	}

	/**
	 * method provides entries for the hash table 
	 * @param fileName
	 * @return
	 */
	private String fileReader(String fileName)
	{
		try{
			  // Open the file that is the first 
			  // command line parameter
			  FileInputStream fstream = new FileInputStream(fileName);
			  // Get the object of DataInputStream
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String tempString = new String();
			
			  //A hash object is used to store both the tag and the word
			  while((tempString = br.readLine())!= null)
			  {
				 hashTable.hashFunction(tempString, listSize);
				 newEntry = new hashObject(tempString,hashTable.hashFunction(tempString, listSize));
				 hashTable.fillTable(newEntry,listSize);
			  }
			in.close();
			  //Close the input stream
			
			    }catch (Exception e){//Catch exception if any
			  System.err.println("Could not find the file, try again: " + e.getMessage());
			  return "failed";
			  }
		return "";	
	}
	
	/**
	 * This method re reads all the data to find the efficiency, and the search lengths
	 * @param fileName
	 * @return
	 */
	private String fileSearch(String fileName)
	{
		try{
			  // Open the file that is the first 
			  // command line parameter
			  FileInputStream fstream = new FileInputStream(fileName);
			  // Get the object of DataInputStream
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String tempString = new String();
			
			  
			  while((tempString = br.readLine())!= null)
			  {
				 hashTable.hashFunction(tempString, listSize);
				 newEntry = new hashObject(tempString,hashTable.hashFunction(tempString, listSize));
				 hashTable.searchLength(newEntry,listSize);
			  }
			in.close();
			  //Close the input stream
			
			    }catch (Exception e){//Catch exception if any
			  System.err.println("Could not find the file, try again: " + e.getMessage());
			  return "failed";
			  }
		//System.out.println(listSize);
		return "";	
	}

	private void fileMaker(String fileName) throws IOException
	{
		hashObject[] tempTable = hashTable.getTable();
		PrintWriter outputStream1 = null;
		int secondCounter =0;
        try {
            outputStream1 = new PrintWriter(new FileWriter("outFile.txt"));   
            hashObject temp;
    		for(int i=0; i<tempTable.length;i++)
    		{
    			if(tempTable[i]!=null){
    				temp = tempTable[i];
    				outputStream1.println("Word: "+temp.getWord()+", its hash tag: "+temp.getTag()+", its location in the table: "+i+", and its element number: "+secondCounter);
    				secondCounter++;
   
    			}
    		}
          
           
        } finally {
            if (outputStream1 != null) {
                outputStream1.close();
            }
        }
	}
		
	public int getListSize()
	{
		return listSize;
	}
}