package Assignment6;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.Collections;
public class TownGraphManager implements TownGraphManagerInterface{
	Graph townGraph;
	public TownGraphManager() {
		townGraph = new Graph();
	}
	
	public void populateTownGraph(File f) throws FileNotFoundException{
		Scanner sc = new Scanner(f);
		String fileString = "";
		Town town1 = null;
		Town town2 = null;
		int weight = 0;
		String roadName = "";
		
		while(sc.hasNextLine()) {
			fileString = sc.nextLine();
			String[] s = fileString.split("[\\s,;]+");
			Town t1 = new Town(s[2]), t2 = new Town(s[3]);
			townGraph.addVertex(t1);
			townGraph.addVertex(t2);
			townGraph.addEdge(t1, t2, Integer.parseInt(s[1]), s[0]);
		}
	}
	/**
	 * Adds a road with 2 towns and a road name
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @param roadName name of road
	 * @return true if the road was added successfully
	 */
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		Town source = new Town(town1);
		Town destination = new Town(town2);
		Road r;
		r = townGraph.addEdge(source, destination, weight, roadName);
		if(r != null) {
			return true;
		}
		return false;
	}
	
	/**
	 * Returns the name of the road that both towns are connected through
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return name of road if town 1 and town2 are in the same road, returns null if not
	 */
	public String getRoad(String town1, String town2) {
		String roadname = "";
		Town t1 = new Town(town1);
		Town t2 = new Town(town2);
		Road r = null;
		if(townGraph.containsEdge(t1, t2)) {
			r = townGraph.getEdge(t1, t2);
		}
		if(r != null)
		return r.getName();
		else return null;
	}
	
	/**
	 * Adds a town to the graph
	 * @param v the town's name  (lastname, firstname)
	 * @return true if the town was successfully added, false if not
	 */
	public boolean addTown(String v) {
		return townGraph.addVertex(new Town(v));
	}
	
	/**
	 * Gets a town with a given name
	 * @param name the town's name 
	 * @return the Town specified by the name, or null if town does not exist
	 */
	public Town getTown(String name) {
		Town t = new Town(name);
		if(townGraph.containsVertex(t)) {
			return t;
		}
		return t;
	}
	
	/**
	 * Determines if a town is already in the graph
	 * @param v the town's name 
	 * @return true if the town is in the graph, false if not
	 */
	public boolean containsTown(String v) {
		Town t = new Town(v);
		return townGraph.containsVertex(t);
	}
	
	/**
	 * Determines if a road is in the graph
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return true if the road is in the graph, false if not
	 */
	public boolean containsRoadConnection(String town1, String town2) {
		Town t1 = new Town(town1);
		Town t2 = new Town(town2);
		return townGraph.containsEdge(t1,t2);
	}
	
	/**
	 * Creates an arraylist of all road titles in sorted order by road name
	 * @return an arraylist of all road titles in sorted order by road name
	 */
	public ArrayList<String> allRoads(){
		String temp = "";
		String word1 = "";
		String word2 = "";
		String min = "";
		int index = 0;
		boolean exists = false;
		Set<Road> roadSet = townGraph.edgeSet();
		ArrayList<Road> roads = new ArrayList<>(roadSet);
		ArrayList<String> roadList = new ArrayList<String>();
		for(int i = 0; i < roads.size(); i++) {
			roadList.add(roads.get(i).getName());
		}
		min = roadList.get(0);
		for(int i = 0; i < roadList.size(); i++) {
			word1 = roadList.get(i);
			min = word1;
		
			for(int j = i; j < roadList.size(); j++) {
				word2 = roadList.get(j);
				for(int a = 0; a < word2.length() && a < min.length(); a++) {
					if(word2.charAt(a) < min.charAt(a)) {
						if(word2.charAt(a) > 47 && word2.charAt(a) < 58 && min.charAt(a) > 47 && min.charAt(a) < 58) {
							if(word2.length() <= min.length()) {
								min = word2;
								index = j;
								break;
							}
							
						}
						min = word2;
						index = j;
						break;
					}
				}
			}
			if(!min.equals(word1)) {//create an arrayList of already added mins
				//roadList.set(i, min);
				Collections.swap(roadList, index, i);
				//System.out.println(roadList.get(index) + "    line 158 after swap "+ roadList.get(i));
				//roadList.set(index, word1);
			}else {
				continue;
			}
				
		}
		return roadList;
	}

	/**
	 * Deletes a road from the graph
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @param roadName the road name
	 * @return true if the road was successfully deleted, false if not
	 */
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		Town t1 = new Town(town1);
		Town t2 = new Town(town2);
		Road removed = townGraph.removeEdge(t1, t2, 0, road);
		if(removed != null) {
			return true;
		}
	
		return false;
	}
	
	/**
	 * Deletes a town from the graph
	 * @param v name of town (lastname, firstname)
	 * @return true if the town was successfully deleted, false if not
	 */
	public boolean deleteTown(String v) {
		Town t = new Town(v);
		
		return townGraph.removeVertex(t);
	}

	/**
	 * Creates an arraylist of all towns in alphabetical order (last name, first name)
	 * @return an arraylist of all towns in alphabetical order (last name, first name)
	 */
	public ArrayList<String> allTowns(){
		Set<Town> townSet = townGraph.vertexSet();
		ArrayList<Town> townList = new ArrayList<>(townSet);
		ArrayList<String> townNames = new ArrayList<String>();
		for(int i = 0; i < townSet.size(); i++) {
			townNames.add(townList.get(i).getName());
		}
		Collections.sort(townNames);
		return townNames;
	}
	
	/**
	 * Returns the shortest path from town 1 to town 2
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return an Arraylist of roads connecting the two towns together, null if the
	 * towns have no path to connect them.
	 */
	public ArrayList<String> getPath(String town1, String town2){
		Town t1 = new Town(town1);
		Town t2 = new Town(town2);
		ArrayList<String> shortPath = new ArrayList<String>();
		ArrayList<String> path = townGraph.shortestPath(t1,t2);
		if(path != null) {
			return path;
		}
		else return shortPath;
	}
}
