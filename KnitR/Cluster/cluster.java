import java.util.*;
import java.io.*;

class cluster 
{
	public static void main(String[] args) throws IOException
	{
		monthly_analysis();
	}

	public static void monthly_analysis() throws IOException
	{
		Scanner mc = new Scanner(new File("monthlycluster.txt"));

		// monthyl cluster
//BIODIESEL_CLASS	BIOMASS_CLASS	ETHANOL_CLASS	HYDRO_CLASS	SOL_CLASS	TOT_GEO_CHANGE	TOT_HYDRO_CHANGE	TOT_SOL_CHANGE	TOT_WIND_CHANGE	WIND_CLASS	month-year
//		0				1 				2 				3	 		4	 			5	 			6 					7 			 8 				9 			10

		while(mc.hasNextLine())
		{
			String[] parsedline = mc.nextLine().toUpperCase().split("\t");

			// change the if conditions to match which attributes you want to examine
			if (parsedline[3].equals("HIGH +") && parsedline[4].equals("MED +") && parsedline[6].equals("INCREASED") && parsedline[7].equals("INCREASED") && parsedline[8].equals("DECREASED"))
			{
				double num = Double.parseDouble(parsedline[10].replace(",",""));
				double temp = num/100;
				int year = (int) temp;
				double doublemonth = num - ((double) (year * 100));
				doublemonth = doublemonth * 12 + 0.1;
				int month = (int) doublemonth;

				System.out.println("Year: " + year + "\tMonth: " + month);

			}

		}
	}




}
