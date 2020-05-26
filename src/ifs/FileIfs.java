package ifs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/** This class reads the data from a file, save the data and return the data for further use
 * @author Nguyen Gia Khanh Ho CST8132
 * @version 1.0
 * @since 1.8
 **/
public class FileIfs implements AffineTransform {
	private double[][] Affine;
	private double scale;
	private int height;
	private int width;
	private int xOffset;
	private int yOffset;
	private String name;
	
	public FileIfs(String fileName){
		try (Scanner input = new Scanner(new File(fileName))) {
			while (input.hasNextLine()) {
				String text = input.next();
				switch(text) {
					case "name":
						name = input.nextLine();
						break;
					case "affine":
						int row = Integer.parseInt(input.next());
						Affine = new double[row][7];
						for(int i = 0; i < row; i++) {
							for(int j = 0; j < 7; j++) {
								Affine[i][j] = Double.parseDouble(input.next());
							}
						}
						break;
					case "scale":
						scale = Double.parseDouble(input.next());
						break;
					case "height":
						height = Integer.parseInt(input.next());
						break;
					case "width":
						width = Integer.parseInt(input.next());
						break;
					case "xOffset":
						xOffset = Integer.parseInt(input.next());
						break;
					case "yOffset":
						yOffset = Integer.parseInt(input.next());
						break;
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("No such File " + e.getMessage());
		}
	}
	
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
		return Affine;
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
