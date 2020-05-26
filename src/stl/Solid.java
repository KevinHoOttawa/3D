package stl;

import java.io.PrintWriter;
import java.util.ArrayList;

/** Class to represent a StL ASCII Format solid. A 3D object that is composed of multiple Facet
 * @author Nguyen Gia Khanh Ho CST8132
 * @version 1.0
 * @since 1.8
 **/
public class Solid {
	private String name;
	private ArrayList <Facet> facets = new ArrayList <>();
	
	public Solid() {
		this.name = "";
	}
	
	
	public Solid(String name) {
		this.name = name;
	}
	
	/** This method adds Facet to facets list
	 * @param facet
	 * 		  The facet added to the facets list
	 * @return True if the facet is added successfully, false if not
	 **/
	public boolean addFacet (Facet facet) {
		facets.add(facet);
		return facets.contains(facet);		
	}

	/** This method takes a variable number of Vertex and creates Facet and add them to the Solid
	 * @param vertices
	 * 		  A variable argument that takes multiple vertexes to create Facet
	 * @return True if successfully add Facet to the Solid, false if the number of Vertexes less than or equal 2 vertexes
	 **/
	public boolean addFacet(Vertex ... vertices) {

		if(vertices.length <= 2) {
			return false;
		}
		
		if(vertices.length % 3 == 0) {
			for(int i = 3; i <= vertices.length; i+=3) {
				Facet f1 = new Facet(vertices[i-3], vertices[i-2], vertices[i-1]); 
				facets.add(f1);
			}
		} else {
			for(int i = 3; i <= vertices.length; i+=3) {
				Facet f1 = new Facet(vertices[0], vertices[i-2], vertices[i-1]);
				facets.add(f1);
			}
			
			Facet f1 = new Facet(vertices[0], vertices[vertices.length - 2], vertices[vertices.length - 1]);
			facets.add(f1);
		}
		
		return true;
	}
	
	/** This method creates a String of the solid specified in the StL ASCII Format
	 * @return a String of the solid
	 **/
	public String toString() {
		System.out.println("solid " + name);
		for(int i = 0; i < facets.size(); i++) {
			System.out.println(facets.get(i).toString());
		}
		return "endsolid " + name;
	}

	/** This method prints the Solid to a file
	 * @param printWriter
	 * 		  The file taking the Solid
	 **/
	public void print(PrintWriter printWriter) {
		printWriter.write("solid " + this.name);
		for (int i =0; i < facets.size(); i ++) {
			printWriter.append(facets.get(i).toString());
		} 	
		printWriter.write("\nendsolid " + this.name);
		printWriter.close();
	}
	
}
