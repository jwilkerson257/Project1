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
	String srcFile = "Mesonet.txt";
	
	/*
	 * This method reads the Mesonet.txt file and fills an Array List of strings with STID values that
	 * is pulled from the first 4 characters after a space on every line after the first four lines.
	 * 
	 */
	public void readFile() throws IOException
	{
		BufferedReader in = new BufferedReader(new FileReader(new File(srcFile)));
		//The three readLine commands skip the first three lines that do not contain STID values
		in.readLine();
		in.readLine();
		in.readLine();
		int count = 0;
		String temp = "";
		// The while loop fills an Array List with STID values
		while (count < 120)
		{
			temp = in.readLine();
			temp = temp.substring(1,5);
			STID.add(temp);
			count++;
		}
		in.close();
	}
	
	/*
	 * Constructor for the HammingDist class that assigns the inputs
	 * to two global string variables and calls the readFile method
	 * 
	 */
	public HammingDist(String strg1, String strg2) throws IOException
	{
		this.strg1 = strg1;
		this.strg2 = strg2;
		readFile();
	}
	
	/*
	 * Finds the Hamming distance between two strings
	 * 
	 */
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
	
	/*
	 * Fills an Integer Array List with the number of STIDs that share a Hamming Distance with the specified STID
	 * 
	 */
	public ArrayList<Integer> findNodes(String strg)
	{
		ArrayList<Integer> nodes = new ArrayList<Integer>();
		//Adds enough space for each of the node values
		nodes.add(0);
		nodes.add(0);
		nodes.add(0);
		nodes.add(0);
		int dist = 0;
		//temp is used as a temporary variable to hold the current value of an element at a specific index and then increases it by one
		int temp = 0;
		for (int k = 0; k < STID.size(); k++)
		{
			//if statement is used so when it compares the same STID value to itself, it ignores it
			if (!strg.equals(STID.get(k)))
			{
				dist = findHammingDist(strg, STID.get(k));
				temp = nodes.get(dist-1) + 1;
				//The switch statement increases the value of the element in the array that corresponds with hamming distance
				switch (dist)
				{
				case 1:
					nodes.set(0, temp);
					break;
				case 2:
					nodes.set(1, temp);
					break;
				case 3:
					nodes.set(2, temp);
					break;
				case 4:
					nodes.set(3, temp);
					break;
				default:
					break;
				}
			}
		}
		return nodes;
	}
	
	/*
	 * Formats the output of a HammDist object to the specified qualifications
	 * 
	 */
	public String toString()
	{
		//ArrayList of the nodes each STID has
		ArrayList<Integer> nodesFirstString = findNodes(strg1);
		ArrayList<Integer> nodesSecondString = findNodes(strg2);
		String temp1 = String.format("The Hamming Distance of %s and %s: %d.\n", strg1, strg2, findHammingDist(strg1, strg2));
		String temp2 = String.format("Out of 119, for %s, number of nodes are: %d, %d, %d, %d and\n",strg1, nodesFirstString.get(0), nodesFirstString.get(1), nodesFirstString.get(2), nodesFirstString.get(3));
		String temp3 = String.format("for %s, number of nodes are: %d, %d, %d, %d respectively.",strg2, nodesSecondString.get(0), nodesSecondString.get(1), nodesSecondString.get(2), findNodes(strg2).get(3));
		return temp1 + temp2 + temp3;
	}
}