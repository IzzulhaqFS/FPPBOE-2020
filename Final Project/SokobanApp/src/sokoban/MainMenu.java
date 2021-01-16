package sokoban;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MainMenu {

	JFrame Menu = new JFrame("SOKOBAN");
	JButton Start = new JButton("Play");
	JButton Exit = new JButton("Exit");
	JButton MapMaker = new JButton("Map Maker");
	ImageIcon picture = new ImageIcon("src/resources/sokoban_image_2.jpg");
	JLabel imageLabel = new JLabel(picture);
	ArrayList<String> mapList = new ArrayList<String>();
	JComboBox<String> lvlList;
	private int menuWidth = 100;
	private int menuHeight = 30;
	private int menuY = 290;
	private int WIDTH = 400;
	private int HEIGHT = 400;
	
	public MainMenu() {
		getMapList();
		lvlList = new JComboBox<String>(mapList.toArray(new String[mapList.size()]));
		
		Menu.setResizable(false);
		Menu.setSize(WIDTH, HEIGHT);
		Menu.setLayout(null);
		Menu.setLocationRelativeTo(null);
		Menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Start.setSize(menuWidth, menuHeight);
		Start.setLocation(15, menuY);
		Menu.add(Start);
		Start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Sokoban(lvlList.getSelectedItem().toString());
				Menu.setVisible(false);
			}
		});
		
//		MapMaker.setSize(menuWidth, menuHeight);
//		MapMaker.setLocation(120, menuY);
//		Menu.add(MapMaker);
//		MapMaker.addActionListener(new ActionListener() {
//	
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				new MapMaker();
//				Menu.setVisible(false);
//			}
//		});
		
		lvlList.setSize(menuWidth + 35, menuHeight);
		lvlList.setLocation(125, menuY);
		Menu.add(lvlList);
		
		Exit.setSize(menuWidth, menuHeight);
		Exit.setLocation(270, menuY);
		Menu.add(Exit);
		Exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int confirmation = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Exit Option", JOptionPane.YES_NO_OPTION);
				if(confirmation == JOptionPane.YES_OPTION)
					System.exit(0);
			}
		});
		
		imageLabel.setBounds((WIDTH-320)/2, 50, 300, 200);
		imageLabel.setVisible(true);
		Menu.add(imageLabel);
		Menu.setVisible(true);
	}
	
	private static boolean levelExistAlready = false;
	
	public void getMapList() {
		for(int i = 0; i < 30; i++) {
			File map = new File("./" + i + ".txt");
			if(map.exists()) {
				System.out.println("Level " + i + " exists");
				mapList.add("./" + i + ".txt");
				levelExistAlready = true;
			}
		}
	}
}
