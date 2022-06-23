import java.awt.Dimension;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;


public class Capture {
	
	public static void main(String[] args) throws IOException{
		Webcam webcam = Webcam.getDefault();
		
		for(Dimension supportedSize: webcam.getViewSizes()){
			System.out.println(supportedSize.toString());
		}
		
		webcam.setViewSize(WebcamResolution.VGA.getSize());
		
		
		webcam.open();
		ImageIO.write(webcam.getImage(), "png", new File("D:\\newphoto.png"));
		webcam.close();
		System.out.println("Capture");
	}
}
