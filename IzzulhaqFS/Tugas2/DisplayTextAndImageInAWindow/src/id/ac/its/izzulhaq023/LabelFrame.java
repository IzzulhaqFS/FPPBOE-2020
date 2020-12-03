package id.ac.its.izzulhaq023;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class LabelFrame extends JFrame {

	private JFrame frame = new JFrame("Mahasiswa");
	private ImageIcon picture = new ImageIcon("res/images/FotoSaya.jpg");
	private JLabel textLabel1 = new JLabel("Izzulhaq Fawwaz Syauqiy");
//	private JLabel textLabel2 = new JLabel("05111840000023");
	private JLabel imageLabel = new JLabel(picture);
	
	public LabelFrame() {
		frame.setResizable(false);
		frame.setSize(800, 800);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		imageLabel.setSize(472, 760);
		imageLabel.setLocation(164, -32);
		imageLabel.setText("05111840000023 Izzulhaq Fawwaz Syauqiy");
		imageLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		imageLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
		imageLabel.setIconTextGap(16);
		
		textLabel1.setSize(160, 80);
		textLabel1.setLocation(0, 0);
		frame.add(textLabel1);
		frame.add(imageLabel);
		
//		textLabel1.setLocation(200, 700);
//		frame.add(textLabel1);
		frame.setVisible(true);	
	}
}
