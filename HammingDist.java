public class HammingDist
{
	String strg1;
	String strg2;
	int node1;
	int node2;
	int node3;
	int node4;
	
	
	public HammingDist(String strg1, String strg2)
	{
		this.strg1 = strg1;
		this.strg2 = strg2;
	}
	
	public int findHammingDist(String strg1, String strg2)
	{
		int dist = 0;
		for (int k = 0; k < 4; k++)
		{
			if (strg1.charAt(k) != strg2.charAt(k))
			{
				dist++;
			}
		}
		return dist;
	}
}