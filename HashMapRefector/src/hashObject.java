
public class HashObject {

	private String word;
	private int hashTag;
	
	public HashObject(String wor, int tag)
	{
		word = wor;
		hashTag = tag;
	}

	public String getWord()
	{
		return word;
	}
	
	public void setWord(String wor)
	{
		word = wor;
	}
	
	public int getHashTag()
	{
		return hashTag;
	}
	
	public void setHashTag(int tag)
	{
		hashTag = tag;
	}
}