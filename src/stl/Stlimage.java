package stl;

/** This class creates a lithophane from a 2D array of integers
 * @author Nguyen Gia Khanh Ho CST8132
 * @version 1.0
 * @since 1.8
 **/
public class Stlimage {
	private double minThick, thickScale, scale = 0.1;
	private double maxValue;

	public Stlimage (double min, double max) {
		this.minThick = min;
		this.thickScale = max - min;
	}

	/** This method takes in a 2D array, do the calculation and generate a lithophane from a 2D array of integers
	 * @param matrix
	 * 		  A 2D array contains data for the calculation
	 * @return A solid (lithophane) to print  a 3D image
	 **/
	public Solid createSolid(int[][] matrix) {
		int width = matrix.length; //length
		int length = matrix[0].length; //width
		Solid solid = new Solid(); //create a solid object
		maxValue = matrix [0][0];
		for(int y = 0; y < matrix.length; y++) {
			for(int x = 0; x < matrix[0].length; x++) {
				//find the maximum value in the integer array
				if(maxValue < matrix[y][x]) {
					maxValue = matrix[y][x];
				}
			}
		}

		for(int x = 0; x < matrix.length - 1; x++) {
			for(int y = 0; y < matrix[0].length - 1; y++) {
				//top
				Vertex v1 = createIfsVertex(x, y, matrix[x][y]);
				Vertex v2 = createIfsVertex(x+1, y, matrix[x+1][y]);
				Vertex v3 = createIfsVertex(x+1, y+1, matrix[x+1][y+1]);
				Vertex v4 = createIfsVertex(x, y+1, matrix[x][y+1]);
				solid.addFacet(v1,v2,v3,v4);
			}
		}

		//side 1
		Vertex vq = new Vertex(0,0,0);
		Vertex vw = new Vertex(width * scale,0,0);
		Vertex ve = new Vertex(width * scale,0,minThick);
		Vertex vr = new Vertex(0,0,minThick);
		solid.addFacet(vq,vw,ve,vr);

		//side 2
		Vertex v5 = new Vertex(0, length * scale, 0);
		Vertex v6 = new Vertex(0,0,0);
		Vertex v7 = new Vertex(0,0,minThick);
		Vertex v8 = new Vertex(0,length * scale, minThick);
		solid.addFacet(v5,v6,v7,v8);

		//side 3
		Vertex va = new Vertex(width * scale, 0, 0);
		Vertex vb = new Vertex(width * scale, length * scale, 0);
		Vertex vc = new Vertex(width * scale, length * scale, minThick);
		Vertex vd = new Vertex(width * scale, 0, minThick);
		solid.addFacet(va,vb,vc,vd);

		//side 4
		Vertex vek = new Vertex(width * scale, length * scale, 0);
		Vertex vf = new Vertex(0, length * scale, 0);
		Vertex vg = new Vertex(0, length * scale, minThick);
		Vertex vh = new Vertex(width * scale, length * scale, minThick);
		solid.addFacet(vek,vf,vg,vh);

		//bottom
		Vertex vm = new Vertex(0,0,0);
		Vertex vn = new Vertex(0, length * scale, 0);
		Vertex vo = new Vertex(width * scale, length * scale, 0);
		Vertex vu = new Vertex(width * scale, 0, 0);
		solid.addFacet(vm,vn,vo,vu);

		return solid;
	}

	private Vertex createIfsVertex(double x, double y, double z) {
		double thickness = minThick + thickScale * Math.sqrt(z / maxValue);
		Vertex newVertex = new Vertex(x * scale, y * scale, thickness);
		return newVertex;
	}
}
