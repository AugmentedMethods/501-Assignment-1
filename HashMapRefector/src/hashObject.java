
public class hashObject {

	private String word;
	private int hashTag;
	
	public hashObject(String wor,int tag)
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
	
	public int getTag()
	{
		return hashTag;
	}
	
	public void setTag(int tag)
	{
		hashTag = tag;
	}
}