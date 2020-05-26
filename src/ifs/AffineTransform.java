package ifs;

/** The parent of all the affine transforms. It defines what all transforms must contain
 * @author Nguyen Gia Khanh Ho CST8132
 * @version 1.0
 * @since 1.8
 **/
public interface AffineTransform {	
	/** The name of the resulting ifs image
	 * @return this is the name describing what the image is
	 **/
	public abstract String getName();
	
	/** The 2D affine matrix for the image
	 * @return this returns an array containing the data to generate the image
	 **/
	public abstract double[][] getAffine();
	
	/** The scale of the resulting image
	 * @return this returns the scale of the image compare with the frame it's on 
	 **/
	public abstract double getScale();
	
	/** The height of the resulting image
	 * @return this returns the height of the frame in which the image generated
	 **/
	public abstract int getHeight();
	
	/** The width of the resulting image
	 * @return this returns the width of the frame in which the image generated
	 **/
	public abstract int getWidth();
	
	/** The x offset of the resulting image
	 * @return this is the x coordinate of the image
	 **/
	public abstract int getXoffset();
	
	/** The y offset of the resulting image
	 * @return this is the y coordinate of the image
	 **/
	public abstract int getYoffset();
}
