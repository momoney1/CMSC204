package Assignment6;

public class Road implements Comparable<Road>{
	
	private Town source;
	private Town destination;
	private int degrees;
	private String name;
	
	public Road(Town source, Town destination, String name) {
		this(source, destination, 0, name);
	}
	
	public Road(Town source, Town destination, int degrees, String name) {
		this.source = source;
		this.destination = destination;
		this.degrees = degrees;
		this.name = name;
	}
	
	public int compareTo(Road o) {
		int n = -1;
		if(this.degrees == o.getWeight()) {
			n = 0;
		}else if(this.degrees > o.getWeight()) {
			n = 1;
		}
		return n;
	}
	
	public boolean contains(Town town) {
		if(this.source.equals(town) || this.destination.equals(town)) {
			return true;
		}
		return false;
	}
	
	public Town getSource() {
		return source;
	}
	
	public Town getDestination() {
		return destination;
	}
	
	public int getWeight() {
		return degrees;
	}
	public String getName() {
		return name;
	}
	public String toString() {
		
		return "";
	}
	
	public boolean equals(Road r) {
		if(this.contains(r.getSource()) && this.contains(r.getDestination())) {
			return true;
		}
		return false;
	}

}
