package ifs;

/** This class is the child of AffineTransform class. It contains data to generate Sierpinski image
 * @author Nguyen Gia Khanh Ho CST8132
 * @version 1.0
 * @since 1.8
 **/
public class SierpinskiIfs implements AffineTransform {
	private double[][] affine = new double[][] {
		{0.50, 0.00, 0.00, 0.50, 0.00, 0.00, 0.33},
		{0.50, 0.00, 0.00, 0.50, 0.00, -0.50, 0.33},
		{0.50, 0.00, 0.00, 0.50, -0.43, -0.25, 0.34}
	};
	private double scale = 500;
	private int height = 449;
	private int width = 519;
	private int xOffset = 439;
	private int yOffset = 509;
	private String name = "Sierpinski";
	
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
