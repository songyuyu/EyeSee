import java.awt.image.BufferedImage;

public class transpose {
	public BufferedImage modify_image(BufferedImage image, String indicator){
		// Obtaining the dimensions from the inputed image
		int width = image.getWidth();
		int height = image.getHeight();
		
		// Adjusting the dimensions to the transpose action
		int[] dimension = dimensionSelection(indicator, width, height);
		int d_width = dimension[0];
		int d_height = dimension[1];
		
		
		BufferedImage greyscaleimage = new BufferedImage(d_width, 
				d_height, BufferedImage.TYPE_3BYTE_BGR);


		for (int i=0; i<image.getHeight(); i++) {
			for (int j=0; j<image.getWidth(); j++) {
				int rgb = image.getRGB(j, i);
				int[] adjusted = valueSelection(indicator, width, height, i, j);
				greyscaleimage.setRGB(adjusted[0], adjusted[1], rgb);
			}
		}
		return greyscaleimage;
	}
	
	// returning the appropriate array of adjusted coordinate values
	private int[] valueSelection(String indicator, int width, int height,
			int i, int j) {
		switch (indicator) {
		case "invert":  
			width = width - j; 
			height = height - i;
			break;
		case "left": 
			int temp = width;
			width = i;
			height = temp - j;
			break;
		case "right": 
			width = height - i;
		  	height = j;
		  	break;
		default: System.out.println("No indicator matched");
		}
		int[] adjusted = new int[2]; 
		adjusted[0] = width;
		adjusted[1] = height;
		return adjusted;
	}
	
	// returning the dimensions array after the transpose
	private int[] dimensionSelection(String indicator, int width, int height) {
		switch (indicator) {
		case "invert": break;
		case "left": 
				int temp = width;
				width = height;
				height = temp;
				break;
		case "right": 
				int temp2 = width;
				width = height;
				height = temp2;
				break;
		default: System.out.println("No indicator matched");
		}
		int[] dimension = new int[2]; 
		dimension[0] = width+1;
		dimension[1] = height+1;
		return dimension;
	}
}
