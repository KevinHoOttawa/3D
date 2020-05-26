import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import ifs.*;
import stl.Solid;
import stl.Stlimage;

/** The main of the entire program, which is used to generate menu of selections, prompt user to choose the image they want and print it
 * @author Nguyen Gia Khanh Ho CST8132
 * @version 1.0
 * @since 1.8
 **/
public class IfsStlFile {

	public static void main(String[] args) {
		int choice;
		Scanner input = new Scanner(System.in);
		IfsCreator a = new IfsCreator();
		
		//Get the array of affine transform objects
		IfsCreator newIfs = new IfsCreator();		//newIfs: instance of IfsCreator		
		AffineTransform [] arr = newIfs.getTransforms();  //getTransforms(): array of the 3 images

		
		//Create a menu
		System.out.println("Available fractal images are: ");
		for(int i = 0; i < arr.length; i++) {
			System.out.println("\t" + (i + 1) + " " + arr[i].getName());
		}
		
		//Prompt user for selection
		System.out.println("What image do you want? ");
		choice = input.nextInt();
		
		//Validate selection and prompt again if the number is out of range
		while(choice < 1 || choice > arr.length) {
			System.out.println("Please select a value from 1 to " + arr.length + ": ");
			choice = input.nextInt();
		}
		
//		Generate ifs image
//		a.generateIfs(arr[choice-1]);
		
		//Create Stlimage class with values of 0.8 and 4.0
		Stlimage Image = new Stlimage(0.8, 4.0);
		
		//Create Solid from ifs image
		Solid solid = Image.createSolid(a.generateIfs(arr[choice-1]));
		
		File pic = new File("C:\\temp" + "\\" + arr[choice-1].getName() + ".stl");
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(pic);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		solid.print(pw);
		System.out.println("Done!");
	}
}
