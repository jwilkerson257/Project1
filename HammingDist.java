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
	
	public HammingDist(String strg1, String strg2) throws IOException
	{
		this.strg1 = strg1;
		this.strg2 = strg2;
		readFile();
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
	
	public ArrayList<Integer> findNodes(String strg)
	{
		ArrayList<Integer> nodes = new ArrayList<Integer>();
		nodes.add(0);
		nodes.add(0);
		nodes.add(0);
		nodes.add(0);
		int dist = 0;
		int temp = 0;
		for (int k = 0; k < STID.size(); k++)
		{
			if (dist != 0)
			{
				dist = findHammingDist(strg, STID.get(k));
				temp = nodes.get(dist-1) + 1;
				if (dist == 1)
				{
					nodes.set(0, temp);
				}
				if (dist == 2)
				{
					nodes.set(1, temp);
				}
				if (dist == 3)
				{
					nodes.set(2, temp);
				}
				if (dist == 4)
				{
					nodes.set(3, temp);
				}
			}
		}
		return nodes;
	}
	
	public String toString()
	{
		String temp1 = String.format("The Hamming Distance of %s and %s: %d.\n", strg1, strg2, findHammingDist(strg1, strg2));
		String temp2 = String.format("Out of 119, for %s, number of nodes are: %d, %d, %d, %d and\n",strg1, findNodes(strg1).get(0), findNodes(strg1).get(1), findNodes(strg1).get(2), findNodes(strg1).get(3));
		String temp3 = String.format("for %s, number of nodes are: %d, %d, %d, %d respectively.",strg2, findNodes(strg2).get(0), findNodes(strg2).get(1), findNodes(strg2).get(2), findNodes(strg2).get(3));
		return temp1 + temp2 + temp3;
	}
}