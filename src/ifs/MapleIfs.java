package ifs;

/** This class is the child of AffineTransform class. It contains data to generate Maple Leaf image
 * @author Nguyen Gia Khanh Ho CST8132
 * @version 1.0
 * @since 1.8
 **/
public class MapleIfs implements AffineTransform {
	private double[][] affine = new double[][] {
		{0.51, 0.00, 0.01, 0.14, 1.31, 0.08, 0.10},
		{0.50, -0.45, 0.52, 0.43, 0.75, -1.49, 0.35},
		{0.47, 0.47, -0.49, 0.45, 0.74, 1.62, 0.35},
		{0.51, 0.00, 0.00, 0.49, -1.62, -0.02, 0.20}
	};
	private double scale = 100;
	private int height = 702;
	private int width = 885;
	private int xOffset = 340;
	private int yOffset = 445;
	private String name = "Maple Leaf";
	
	/** The name of the resulting ifs image
	 * @return this is the name describing what the image is
	 **/
	public String getName() {
		return name;
	}
	
	/** The 2D affine matrix for the image
	 * @return this returns an array containing the data to generate the image
	 **/
	public double[][] getAffine() {
		return affine;
	}
	
	/** The scale of the resulting image
	 * @return this returns the scale of the image compare with the frame it's on 
	 **/
	public double getScale() {
		return scale;
	}
	
	/** The height of the resulting image
	 * @return this returns the height of the frame in which the image generated
	 **/
	public int getHeight() {
		return height;	
	}
	
	/** The width of the resulting image
	 * @return this returns the width of the frame in which the image generated
	 **/
	public int getWidth() {
		return width;
	}
	
	/** The x offset of the resulting image
	 * @return this is the x coordinate of the image
	 **/
	public int getXoffset() {
		return xOffset;
		
	}
	
	/** The y offset of the resulting image
	 * @return this is the y coordinate of the image
	 **/
	public int getYoffset() {
		return yOffset;
	}
}
