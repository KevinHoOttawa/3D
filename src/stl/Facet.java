package stl;

/** Class to represent a single facet
 * @author Nguyen Gia Khanh Ho CST8132
 * @version 1.0
 * @since 1.8
 **/
public class Facet {
	private Vertex normal;
	private Vertex v1, v2, v3;
	
	public Facet (Vertex v1, Vertex v2, Vertex v3) {
		this.v1 = v1;
		this.v2 = v2;
		this.v3 = v3;
		normal = Vertex.calcNormal(v1, v2, v3);
	}
	
	/** This method creates a String of the Facet specified in the StL ASCII Format
	 * @return A String of the Facet
	 **/
	public String toString() {
		return "\nfacet normal " + normal.toString() + "\n outer loop" + "\n  vertex " + v1.toString() + "\n  vertex " + v2.toString() + "\n  vertex " + v3.toString() + "\n endloop" + "\nendfacet";		
	}
	

	
}
