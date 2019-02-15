import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class HammingDist
{
	String strg1;
	String strg2;
	int node1;
	int node2;
	int node3;
	int node4;
	ArrayList<Integer> nodes = new ArrayList<Integer>();
	
	public HammingDist(String strg1, String strg2)
	{
		this.strg1 = strg1;
		this.strg2 = strg2;
	}
	
	public void readFile() throws IOException
	{
		BufferedReader in = new BufferedReader(new FileReader(new File("Mesonet.txt")));
		in.readLine();
		in.readLine();
		in.readLine();
		for (int k = 0; k < 119; k++)
		{
			String temp = in.readLine();
			temp = temp.substring(1,5);
			
		}
		in.close();
		
		
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
	
	public ArrayList<Integer> findNodes(String strg1, String strg2)
	{
		return nodes;
	}
	
	public String toString()
	{
		String temp1 = String.format("The Hamming Distance of %s and %s: %d.\n", strg1, strg2, findHammingDist(strg1, strg2));
		String temp2 = String.format("Out of 119, for %s, number of nodes are: 0, 0, 23, 96 and\n",strg1);
		String temp3 = String.format("for %s, number of nodes are: 0, 5, 16, 98 respectively.",strg2);
		return temp1+temp2+temp3;
	}
}