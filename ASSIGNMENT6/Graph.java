package Assignment6;
import java.util.Map.Entry;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Stack;
import java.io.*;

public class Graph implements GraphInterface<Town,Road>{
	private ArrayList<String> shortestPath;
	Town endVertex;
	private Set<Town> townSet;
	private Set<Road> roadSet;
	
	public Graph() {
		townSet = new HashSet<Town>();
		roadSet = new HashSet<Road>();
		shortestPath = new ArrayList<String>();
	}
	/**
     * Returns an edge connecting source vertex to target vertex if such
     * vertices and such edge exist in this graph. Otherwise returns
     * null. If any of the specified vertices is null
     * returns null
     *
     * In undirected graphs, the returned edge may have its source and target
     * vertices in the opposite order.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     *
     * @return an edge connecting source vertex to target vertex.
     */
    public Road getEdge(Town sourceVertex, Town destinationVertex) {
    	Road road = null;
    	
    	for(Road r: roadSet) {
    		if(r.getSource().equals(sourceVertex) && r.getDestination().equals(destinationVertex)) {
    			road = r;
    		}
    	}
    	return road;
    	
    }


    /**
     * Creates a new edge in this graph, going from the source vertex to the
     * target vertex, and returns the created edge. 
     * 
     * The source and target vertices must already be contained in this
     * graph. If they are not found in graph IllegalArgumentException is
     * thrown.
     *
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight weight of the edge
     * @param description description for edge
     *
     * @return The newly created edge if added to the graph, otherwise null.
     *
     * @throws IllegalArgumentException if source or target vertices are not
     * found in the graph.
     * @throws NullPointerException if any of the specified vertices is null.
     */
    public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
    	boolean added = false;
    	Road road = null;
    	if(sourceVertex == null || destinationVertex == null)
    		throw new NullPointerException("One vertice is null");
    	 
    	for(Town t: townSet) {
    		if(t.equals(sourceVertex)) {
    			for(Town t2: townSet) {
    				if(t2.equals(destinationVertex)) {
    					sourceVertex.addNeighbor(destinationVertex);
    					destinationVertex.addNeighbor(sourceVertex);
    					road = new Road(sourceVertex, destinationVertex, weight, description);
    					if(roadSet.add(road)) {
    						added = true;
    					}
    				}
    			}
    		}
    	}
    	if(added)
    	return road;
    	
    	return null;
    	
    }

    /**
     * Adds the specified vertex to this graph if not already present. More
     * formally, adds the specified vertex, v, to this graph if
     * this graph contains no vertex u such that
     * u.equals(v). If this graph already contains such vertex, the call
     * leaves this graph unchanged and returns false. In combination
     * with the restriction on constructors, this ensures that graphs never
     * contain duplicate vertices.
     *
     * @param v vertex to be added to this graph.
     *
     * @return true if this graph did not already contain the specified
     * vertex.
     *
     * @throws NullPointerException if the specified vertex is null.
     */
    public boolean addVertex(Town v) {
    	boolean add = true;
    	if(v == null)
    		throw new NullPointerException("The specified vertex is null");
    	
    	for(Town t: townSet) {
    		if(t.equals(v)) {
    			add = false;
    			break;
    		}
    	}
    	if(add) {
    		townSet.add(v);
    	}
    	return add;
    }

    /**
     * Returns true if and only if this graph contains an edge going
     * from the source vertex to the target vertex. In undirected graphs the
     * same result is obtained when source and target are inverted. If any of
     * the specified vertices does not exist in the graph, or if is
     * null, returns false.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     *
     * @return true if this graph contains the specified edge.
     */
    public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
    	boolean exists = false;
    	Road r = new Road(sourceVertex, destinationVertex, null);
    	for(Road road: roadSet) {
    		if(road.getSource().equals(sourceVertex) && road.getDestination().equals(destinationVertex)) {
    			exists = true;
    		}
    	}
    	return exists;
    }

    /**
     * Returns true if this graph contains the specified vertex. More
     * formally, returns true if and only if this graph contains a
     * vertex u such that u.equals(v). If the
     * specified vertex is null returns false.
     *
     * @param v vertex whose presence in this graph is to be tested.
     *
     * @return true if this graph contains the specified vertex.
     */
    public boolean containsVertex(Town v) {
    	for(Town t: townSet) {
    		if(t.equals(v)) 
    			return true;
    	}
    	return false;
    }

    /**
     * Returns a set of the edges contained in this graph. The set is backed by
     * the graph, so changes to the graph are reflected in the set. If the graph
     * is modified while an iteration over the set is in progress, the results
     * of the iteration are undefined.
     *
     *
     * @return a set of the edges contained in this graph.
     */
    public Set<Road> edgeSet(){
    	return roadSet;
    }

    /**
     * Returns a set of all edges touching the specified vertex (also
     * referred to as adjacent vertices). If no edges are
     * touching the specified vertex returns an empty set.
     *
     * @param vertex the vertex for which a set of touching edges is to be
     * returned.
     *
     * @return a set of all edges touching the specified vertex.
     *
     * @throws IllegalArgumentException if vertex is not found in the graph.
     * @throws NullPointerException if vertex is null.
     */
    public Set<Road> edgesOf(Town vertex){
    	if(vertex == null)
    		throw new NullPointerException("Vertex is null");
    	
    	if(townSet.contains(vertex) == false)
    		throw new IllegalArgumentException("Vertex is not found in the graph");
    	
    	Set<Road> edgeSet = new HashSet<Road>();
    	Iterator roadIterator = roadSet.iterator();
    	Road road;
    	while(roadIterator.hasNext()) {
    		road = (Road) roadIterator.next();
    		if(road.getSource().equals(vertex) || road.getDestination().equals(vertex)) {
    			edgeSet.add(road);
    		}
    	}
    	return edgeSet;
    }

    /**
     * Removes an edge going from source vertex to target vertex, if such
     * vertices and such edge exist in this graph. 
     * 
     * If weight >- 1 it must be checked
     * If description != null, it must be checked 
     * 
     * Returns the edge if removed
     * or null otherwise.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight weight of the edge
     * @param description description of the edge
     *
     * @return The removed edge, or null if no edge removed.
     */
    public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
    	if(weight <= -1) {
    		throw new RuntimeException("Weight is not valid");
    	}
    	if(description == null)
    		throw new RuntimeException("Description is null");
    	
    	Road road = new Road(sourceVertex, destinationVertex, weight, description);
    	Boolean found = false;
    	for(Road r: roadSet) {
    		if(r.getSource().equals(sourceVertex) && r.getDestination().equals(destinationVertex)) {
    			found = roadSet.remove(r);
    			break;
    		}else if(r.getDestination().equals(sourceVertex) && r.getDestination().equals(destinationVertex)) {
    			found = roadSet.remove(r);
    			break;
    		}
    	}   	
    	
    	if(found) {
    		return road;
    	}
    	
    	
    	return null;
    }


    /**
     * Removes the specified vertex from this graph including all its touching
     * edges if present. More formally, if the graph contains a vertex 
     * u such that u.equals(v), the call removes all edges
     * that touch u and then removes u itself. If no
     * such u is found, the call leaves the graph unchanged.
     * Returns true if the graph contained the specified vertex. (The
     * graph will not contain the specified vertex once the call returns).
     *
     * If the specified vertex is null returns false.
     *
     * @param v vertex to be removed from this graph, if present.
     *
     * @return true if the graph contained the specified vertex;
     * false otherwise.
     */
    public boolean removeVertex(Town v) {
    	boolean removed = false;
    	for(Town tSet: townSet) {
    		if(tSet.equals(v)) {
    			townSet.remove(tSet);
    			removed = true;
    			break;
    		}
    	}
    	return removed;
    		
    }

    /**
     * Returns a set of the vertices contained in this graph. The set is backed
     * by the graph, so changes to the graph are reflected in the set. If the
     * graph is modified while an iteration over the set is in progress, the
     * results of the iteration are undefined.
     *
     *
     * @return a set view of the vertices contained in this graph.
     */
    public Set<Town> vertexSet(){    	
    	return townSet;
    }
    
    
    /**
     * Find the shortest path from the sourceVertex to the destinationVertex
     * call the dijkstraShortestPath with the sourceVertex
     * @param sourceVertex starting vertex
     * @param destinationVertex ending vertex
     * @return An arraylist of Strings that describe the path from sourceVertex
     * to destinationVertex
     * They will be in the format: startVertex "via" Edge "to" endVertex weight
	 * As an example: if finding path from Vertex_1 to Vertex_10, the ArrayList<String>
	 * would be in the following format(this is a hypothetical solution):
	 * Vertex_1 via Edge_2 to Vertex_3 4 (first string in ArrayList)
	 * Vertex_3 via Edge_5 to Vertex_8 2 (second string in ArrayList)
	 * Vertex_8 via Edge_9 to Vertex_10 2 (third string in ArrayList)
     */   
    public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex){
    	
    	endVertex = destinationVertex;
    	dijkstraShortestPath(sourceVertex);
    	return shortestPath;
    }
    
    /**
     * Dijkstra's Shortest Path Method.  Internal structures are built which
     * hold the ability to retrieve the path, shortest distance from the
     * sourceVertex to all the other vertices in the graph, etc.
     * @param sourceVertex the vertex to find shortest path from
     * 
     */
    public void dijkstraShortestPath(Town sourceVertex) {
    	PriorityQueue<Road> roadQueue = new PriorityQueue<Road>();
    	Stack<Town> townStack = new Stack<Town>();
    	Stack<Town> tempStack = new Stack<Town>();
    	Town tempTown = null;
    	ArrayList<Town> townOrder = new ArrayList<Town>();
    	Town vertex = null;
    	ArrayList<String> visitedArray = new ArrayList<String>();
    	boolean visitedSource = false, visitedDestination = false;
    	boolean foundDestinationVertex = false;
    	int cost = 0;
    	boolean found = false;
    	Road r;
    	Town t, destination;
    	int weight = 0;
    	roadQueue.add(new Road(sourceVertex, sourceVertex, weight, "startPoint"));
    	sourceVertex.setPredecessor(null);
    	townOrder.add(sourceVertex);
    	int j  = 0;
    	while(!roadQueue.isEmpty() && !found) {
    		visitedSource = false;
    		visitedDestination = false;
    		 r = roadQueue.remove();
    		 sourceVertex = r.getDestination();
    		 if(sourceVertex.equals(endVertex)) {
    			 vertex = sourceVertex;
    			 found = true;
    			 break;
    		 }
    		
    		 for(String s: visitedArray) {
    			 if(s.equals(sourceVertex.getName())) {
    				 visitedSource = true;
    				 break;
    			 }
    		 }
    		 if(!visitedSource) {
    			 visitedArray.add(sourceVertex.getName());
    			 weight = 0;
    			 for(Road road: roadSet) {
    				 visitedDestination = false;
    				 visitedSource = false;
    				 if(road.getSource().equals(sourceVertex)) {
    					 destination = road.getDestination();
    					 weight = r.getWeight() + road.getWeight();
    					 for(String s: visitedArray) {
    		    			 if(s.equals(destination.getName())) {
    		    				 visitedDestination = true;
    		    				 break;
    		    			 }
    		    		 }
    					 if(!visitedDestination) {
    						 destination.setPredecessor(sourceVertex);
    						 townOrder.add(destination);
    						 roadQueue.add(new Road(sourceVertex, destination, weight, road.getName()));
    					 }
    				 }else if(road.getDestination().equals(sourceVertex)){
    					 destination = road.getSource();
    					 weight = road.getWeight() + r.getWeight();
    					 for(String s: visitedArray) {
    		    			 if(s.equals(destination.getName())) {
    		    				 visitedSource = true;
    		    				 break;
    		    			 }
    		    		 }
    					 if(!visitedDestination) {
    						 destination.setPredecessor(sourceVertex);
    						 townOrder.add(destination);
    						 roadQueue.add(new Road(sourceVertex, destination, weight, road.getName()));
    						 System.out.println(sourceVertex + "     line      410  graph   "+ destination);
    						 if(destination.getName().equals("Town_6")) {
    							 for(Town myTown: townOrder) {
    								 System.out.println(endVertex + "  "+myTown.getName() + "  line 405 graph "+ myTown.getPredecessor());
    							 }
    							 System.out.println(endVertex+"     this is                        the end "+ destination.getPredecessor().getPredecessor().getPredecessor().getPredecessor().getPredecessor().getPredecessor());
    						 } 
    					}
    					 
    				 }
    			 }
    		 }
    		
    	}
    	if(!found) {
    		shortestPath = null;
    		return;
    	}
    	townStack.push(vertex);
    	while(vertex != null && vertex.hasPredecessor()) {
    		vertex = vertex.getPredecessor();
    		townStack.push(vertex);
    		tempStack.push(vertex);
    	}
    	int i = 0;
    	Town startTown, nextTown;
    	Town tempStart, tempNext;
    	int size = townStack.size();
    	while(i < size + 1) {
    		startTown = townStack.pop();
    		nextTown = townStack.pop();
    		townStack.push(nextTown);
    		for(Road r2: roadSet) {
    			if(r2.getSource().equals(startTown) && r2.getDestination().equals(nextTown)) {
    				shortestPath.add(startTown + " via "+ r2.getName() + " to "+ nextTown + " "+ r2.getWeight() + " mi");
    				break;
    			}
    		}
    	 i +=2;
    	}  
    	townStack.clear();
    	 	
    }
}