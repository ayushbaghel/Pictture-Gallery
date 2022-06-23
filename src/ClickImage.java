import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import java.awt.event.*; 
import javax.imageio.ImageIO;
import javax.swing.JFrame;


import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.github.sarxos.webcam.util.ImageUtils;

public class ClickImage {


    public static void main(String[] args) throws IOException, Exception {
       captureWithPanel();
    }

    public static void captureWithPanel() throws IOException, Exception{
        Webcam webcam = Webcam.getDefault();
        webcam.setViewSize(WebcamResolution.VGA.getSize());

        WebcamPanel panel = new WebcamPanel(webcam);
        panel.setImageSizeDisplayed(true);

        JFrame window = new JFrame("Webcam");
		JButton button=new JButton("Click Here");  
		button.setBounds(50,100,95,30);

		  button.addActionListener(new ActionListener(){  
		public void actionPerformed(ActionEvent e) { 
			try{
			BufferedImage image = webcam.getImage();
			ImageIO.write(image, ImageUtils.FORMAT_JPG, new File("D:\\selfie.jpg"));
			button.setText("Captured 11");
			}catch(IOException ex){}
			finally{
				System.out.println("Finally");
			}
    }
	
	});  


		panel.add(button);
        window.add(panel);
        window.setResizable(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.pack();
        window.setVisible(true);

    }
}