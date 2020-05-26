package stl;

import java.text.DecimalFormat;

/** This class represent a single 3D vertex
 * @author Nguyen Gia Khanh Ho CST8132
 * @version 1.0
 * @since 1.8
 **/
public class Vertex {
	
	double x, y, z;
	static DecimalFormat df = new DecimalFormat("#.##");
	
	public Vertex (double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;	
	}
	
	/** This creates a String of this Vertex specified in the StL ASCII Format
	 * @return A String of the Vertex
	 **/
	public String toString() {
		return df.format(x) + " " + df.format(y) + " " + df.format(z);		
	}
	
	/** This is a static method to calculate unit normal Vertex given three vetices
	 * @param v1a
	 * 		  Value of the first vertex
	 * @param v2a
	 *        Value of the second vertex
	 * @param v3a
	 *        Value of the third vertex
	 * @return Unit normal Vertex from the values of three vertices
	 **/
	public static Vertex calcNormal(Vertex v1a, Vertex v2a, Vertex v3a) {
		double a1 = v2a.x - v1a.x;
		double b1 = v2a.y - v1a.y;
		double c1 = v2a.z - v1a.z;
		double a2 = v3a.x - v1a.x;
		double b2 = v3a.y - v1a.y;
		double c2 = v3a.z - v1a.z;
		double a = b1 * c2 - b2 * c1; 
		double b = a2 * c1 - a1 * c2; 
		double c = a1 * b2 - b1 * a2;
		
		double unit = (a*a) + (b*b) + (c*c);
		double sqroot = java.lang.Math.sqrt(unit);
		
		double normalX = a/sqroot;
		double normalY = b/sqroot;
		double normalZ = c/sqroot;
		
		Vertex Normal = new Vertex(normalX,normalY,normalZ);
		return Normal;

	}
}
