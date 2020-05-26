package ifs;

import java.security.SecureRandom;

/** This method creates an IFS image given an affine transform
 * @author Nguyen Gia Khanh Ho CST8132
 * @version 1.0
 * @since 1.8
 **/
public class IfsCreator {
	private int A = 0;
	private int B = 1;
	private int C = 2;
	private int D = 3;
	private int E = 4;
	private int F = 5;
	private int PROB = 6;
	
	/** The method creates new objects of the AffineTransform's children as a list of object
	 * @return The array of AffineTransforms.
	 **/
	public AffineTransform[] getTransforms() {
		AffineTransform [] affineTransform = {
				new BarnsleyFernIfs(), 
				new SierpinskiIfs(), 
				new MapleIfs(),
				new FileIfs("GoldenDragon.ifs")
		}; 
		return affineTransform;
	}

	/** The method takes an affine transform and generate a 3D printable image of IFS fractals.
	 * @param affineTransform
	 *		  The matrix which contains data to generate IFS image
	 * @return A new 2D array containing data of the IFS image
	 **/
	public int[][] generateIfs(AffineTransform affineTransform) {
		double affine [][] = affineTransform.getAffine();
		double scale = affineTransform.getScale();
		int height = affineTransform.getHeight();
		int width = affineTransform.getWidth();
		int xOffset = affineTransform.getXoffset();
		int yOffset = affineTransform.getYoffset();

		double x = 0, y = 0, u, v;
		int xDisp, yDisp;

		SecureRandom rnd = new SecureRandom();

		int test [][] = new int [width][height];

		for (int i = 0; i < width * height; i++) {

			double rndNumber = rnd.nextDouble();

			int rowNumber = 0;
			double prob = 0;

			for (int j = 0; j < affine.length; j++ ) {

				prob += affine[j][PROB];	

				if(rndNumber < prob) {
					rowNumber = j;
					break;
				} 				
			}

			double[] rows = affine [rowNumber];

			u = rows[A] * x + rows[B] * y + rows[E];
			v = rows[C] * x + rows[D] * y + rows[F];
			x = u;
			y = v;
			xDisp = (int) Math.floor(x* scale) + xOffset;
			yDisp = (int) Math.floor(y* scale) + yOffset;
			test[yDisp][xDisp] += 1;
		}
		return test;
	}
}
