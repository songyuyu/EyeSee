
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class greyConverter {
	public static void main(String args[]) throws IOException{
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame("Image Editor");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				frame.setSize(800, 640);
			} 
			});
		
		
		File loadedImage = new File ("/Users/Sonny/Desktop/10668433_678828068876737_1961812895_n.jpg");
	
		// "image" creats the object for the original image 
		BufferedImage image = null; 
		try {
			image = ImageIO.read(loadedImage);
			
			// "convert" creates the object for the gconvert file
			gconvert convert = new gconvert();
			image = convert.modifyImage(image, "blue");
			
			// "trans" creates the object for the transpose file
		    transpose trans = new transpose();
		    image = trans.modify_image(image, "left");
		
			// Saving the file to a source location
			File f = new File("/Users/Sonny/Desktop/output.png");
			ImageIO.write(image, "jpg", f);
			System.out.println("File saved");
			}
			catch (IOException e) {
				System.out.println("Error: e");
			}
				
	}
	


}
