import java.awt.image.BufferedImage;
import java.awt.Color;

public class gconvert {
	public BufferedImage modifyImage(BufferedImage image, String filter){
		BufferedImage greyscaleimage = new BufferedImage(image.getWidth(), 
				image.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
		
		// Applying the Luminosity Algorithm to convert the image to greyscale
		for (int i=0; i<image.getHeight(); i++) {
			for (int j=0; j<image.getWidth(); j++) {
				Color c = new Color(image.getRGB(j, i));
				int r = c.getRed();
				int g = c.getGreen();
				int b = c.getBlue();
				
				// Luminosity Algorithm = 0.21R + 0.72G + 0.07B
				int grsc = (int) (0.21*r+0.72*g+0.07*b);
				
				// Set Greycolor
				Color grscColor = new Color(grsc,grsc,grsc);
				int newRGB = grscColor.getRGB();
				greyscaleimage.setRGB(j, i, newRGB);
			}
		}
		return greyscaleimage;
	}
}
