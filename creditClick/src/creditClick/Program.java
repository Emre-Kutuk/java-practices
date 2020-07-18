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
		
		System.out.print("Enter a country name: ");
		String name = s.nextLine();
		
		System.out.print("Enter town number (max 20): ");
		int nrOfTowns = Integer.parseInt(s.nextLine());
		
		Country country = new Country(name, nrOfTowns);
		country.generateCountry();
		
		country.printAvgPopulation();
		
		country.towns.forEach(t -> t.printNeighbours());
		
		country.towns.get(0).printTownsNearby(200);
	}
}