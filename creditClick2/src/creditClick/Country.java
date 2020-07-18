package creditClick;
import java.util.*;

public class Country 
{
	public String countryName;
	public List <Town> towns = new ArrayList<Town>();
	private List <Path> paths = new ArrayList <Path>();
	private int nrOfTowns;
	private int minPath;
	private int maxPath;
	
	@SuppressWarnings("serial")
	private List <String> townNames = new ArrayList <String>() 
	{{
		add("Amsterdam");
		add("The Hague");
		add("Rotterdam");
		add("Utrecht");
		add("Eindhoven");
		add("Maastricht");
		add("Haarlem");
		add("Leiden");
		add("Groningen");
		add("Breda");
		add("Delft");
		add("Lelystad");
		add("Enschede");
		add("Zwolle");
		add("Arnhem");
		add("Leeuwarden");
		add("Almere");
		add("Assen");
		add("Zaanstad");
		add("Middelburg");
		add("Kampen");
	}};
	
	public Country(String countryName, int nrOfTowns, int minPath, int maxPath)
	{
		this.countryName = countryName;
		this.nrOfTowns = nrOfTowns;
		this.minPath = minPath;
		this.maxPath = maxPath;
	}

	public void CalculateShortestRoute(Town t1, Town t2)
	{
		if(!CheckIfConnectedDirectly(t1,t2))
		{
			//Shit happens here
		}
		else
		{
			//There is a direct route
		}
		
	}
	
	public Boolean CheckIfAllConnected(Town town)
	{
		for(Town t : towns)
		{
			if(!CheckIfConnectedDirectly(town, t))
			{
				for(Path p : paths)
				{
					if(p.town1 == town)
					{
						if(!CheckIfConnectedDirectly(town, p.town2))
						{
							
						}
						
					}
					else if(p.town2 == town)
					{
						if(!CheckIfConnectedDirectly(town, p.town1))
						{
							
						}
					}
				}
			}
		}
		
		return true;
	}
	
	public void GenerateCountry()
	{
		System.out.printf("Generating %s...\n", this.countryName);
		int pathName = 1;
		Random rnd = new Random();
		
		//Creating towns with random names
		for(int i = 0; i < nrOfTowns; i++)
		{
			int index = rnd.nextInt(townNames.size());
			towns.add(new Town(townNames.get(index)));
			townNames.remove(index);
		}
		
		//Printing town names and population
		towns.forEach(t -> System.out.print(t.toString()));
		
		//Creating paths
		for(Town t : towns)
		{
			//Deciding how many paths the town will have
			int pathNr = rnd.nextInt((maxPath-minPath) +  1) + minPath;
			
			for(int i = 0; i < pathNr; i++)
			{
				int index = rnd.nextInt(towns.size());
				
				//Validating the path
				while(!PathIsValid(index, t))
					index = rnd.nextInt(towns.size());
				
				paths.add(new Path(pathName, t, towns.get(index), rnd.nextInt(50-10) + 10));
				pathName++;
			}
		}
		paths.forEach(p -> System.out.print(p.toString()));
	}
	
	//Getting average population of all towns
	public void PrintAvgPopulation()
	{
		List <Integer> populationList = new ArrayList<Integer>();
		
		towns.forEach(t -> populationList.add(t.population));
			
		System.out.printf("\nAverage population of %s: %s",this.countryName,populationList.stream().mapToInt(Integer::intValue).average().toString());
	}
	
	private Boolean CheckIfConnectedDirectly(Town from, Town to)
	{	
		for(Path p : paths)
		{
			if(p.town1 == from || p.town2 == from 
					&& p.town1 == to || p.town2 == to)
			{
				return true;
			}	
		}
		return false;
	}
	
	//Checking if the path is valid
	private Boolean PathIsValid(int index, Town t)
	{
		//Checking if the path is going to the origin town 
		if(towns.get(index) != t)
		{
			//Checking if this is the first path
			if(paths.size() > 1)
			{
			//Checking if the same path exists
			for(Path p : paths)
			{
				if(t == p.town2 && towns.get(index) == p.town1
						|| t == p.town1 && towns.get(index) == p.town2)
					return false;
			}
			return true;
			}	
			return true;
		}
		return false;
	}
}