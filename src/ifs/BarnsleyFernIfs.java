package ifs;

/** This class is the child of AffineTransform class. It contains data to generate BarnsleyFern image
 * @author Nguyen Gia Khanh Ho CST8132
 * @version 1.0
 * @since 1.8
 **/
public class BarnsleyFernIfs implements AffineTransform {
	private double[][] affine = new double[][] {
		{0.00, 0.00, 0.00, 0.16, 0.00, 0.00, 0.01},
		{0.85, 0.04, -0.04, 0.85, 0.00, 1.60, 0.85},
		{0.20, -0.26, 0.23, 0.22, 0.00, 1.60, 0.07},
		{-0.15, 0.28, 0.26, 0.24, 0.00, 0.44, 0.07}
	};
	private double scale = 100;
	private int height = 503;
	private int width = 1019;
	private int xOffset = 228;
	private int yOffset = 10;
	private String name = "Barnsley Fern";
	
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
