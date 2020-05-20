package Assignment6;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.ArrayList;

public class Town implements Comparable<Town>{
	private String name;
	private Town predecessor;
	private PriorityQueue<Town> neighbors;
	private LinkedList<Town> shortest;
	private int distanceFromPrev = 2147836;
	public Town(String name) {
		this.name = name;
		neighbors = new PriorityQueue<Town>();
		shortest = new LinkedList<Town>();
	}
	
	public Town(Town templateTown) {
		this(templateTown.getName());
	}
	
	public int compareTo(Town o) {
		return this.name.compareTo(o.getName());
	}
	
	public String getName() {
		return this.name;
	}
	
	public Town getPredecessor(){
		return predecessor;
	}
	
	public void setPredecessor(Town o) {
		predecessor = o;
	}
	
	public boolean hasPredecessor() {
		return predecessor != null;
	}
	
	public PriorityQueue<Town> getNeighbors(){
		return neighbors;
	}
	
	public void addNeighbor(Town neighbor) {
		this.neighbors.add(neighbor);
	}
	
	public int getDistance() {
		return distanceFromPrev;
	}
	public void setDistance(int d) {
		distanceFromPrev = d;
	}
	
	public String toString() {
		return getName();
	}
	public LinkedList<Town> getShortest(){
		return shortest;
	}
	public void setShortest(LinkedList<Town> shortPath) {
		shortest = shortPath;
	}
	public void addToShortest(Town t) {
		shortest.add(t);
	}
	
	public int hashCode() {
		int code = 0;
		if(name.length() > 2) {
			code = name.charAt(0) + name.charAt(1);
		}
		else {
			code = name.charAt(0) * 2;
		}
		
		return code;
	}
	
	public boolean equals(Town o) {
		if(this.name.equals(o.getName())) {
			return true;
		}
		return false;
	}
	
	
}
