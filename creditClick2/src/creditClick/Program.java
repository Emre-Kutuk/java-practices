package creditClick;
import java.util.*;

public class Program 

{
	public static void main(String[] args)
	{
		Program myprogram = new Program();
		myprogram.Start();
	}
	
	@SuppressWarnings("resource")
	void Start()
	{
		Scanner s = new Scanner(System.in);
		
		System.out.print("Enter a name for the country: ");
		String name = s.nextLine();
		
		System.out.print("Enter town number (max 20): ");
		int nrOfTowns = Integer.parseInt(s.nextLine());
		
		System.out.print("Enter min road for a town(min 1): ");
		int minPath = Integer.parseInt(s.nextLine());
		System.out.print("Enter max road for a town: ");
		int maxPath = Integer.parseInt(s.nextLine());
		
		Country country = new Country(name, nrOfTowns, minPath, maxPath);
		country.GenerateCountry();
		
		country.PrintAvgPopulation();
	}
}