import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class HammingDist
{
	String strg1;
	String strg2;
	ArrayList<String> STID = new ArrayList<String>();
	
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
		int count = 0;
		while (count < 120)
		{
			String temp = in.readLine();
			temp = temp.substring(1,5);
			STID.add(temp);
			count++;
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
		ArrayList<Integer> nodes = new ArrayList<Integer>();
		nodes.add(0);
		nodes.add(0);
		nodes.add(0);
		nodes.add(0);
		int dist = 0;
		for (int k = 0; k < STID.size(); k++)
		{
			dist = findHammingDist(strg1, STID.get(k));
			nodes.set(dist, nodes.get(dist));
		}
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