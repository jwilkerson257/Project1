
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
	
	public String toString()
	{
		String temp1 = String.format("The Hamming Distance of %s and %s: %d.\n", strg1, strg2, findHammingDist(strg1, strg2));
		String temp2 = String.format("Out of 119, for %s, number of nodes are: 0, 0, 23, 96 and\n",strg1);
		String temp3 = String.format("for %s, number of nodes are: 0, 5, 16, 98 respectively.",strg2);
		return temp1+temp2+temp3;
	}
}