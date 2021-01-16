package sokoban;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Sokoban extends JFrame {

	private final int OFFSET = 30;
	//private final int B_WIDTH = 100;
	//private final int B_HEIGHT = 30;
	//private JButton restart = new JButton("RESTART");
	//private JButton menu = new JButton("MENU");
	
	public Sokoban(String str) {
		initUI(str);
	}
	
	private void initUI(String str) {
		Board board = new Board(str);
		add(board);
		
		setTitle("SOKOBAN");
		setResizable(false);
		setSize(board.getBoardWidth() + OFFSET + 10, board.getBoardHeight() + 2 * OFFSET + 30);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				int confirmation = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Exit Option", JOptionPane.YES_NO_OPTION);
				if(confirmation == JOptionPane.YES_OPTION) {
					dispose();
					new MainMenu();
				}
			}
			
		});
		
//		if(board.isCompleted) {
//			Object[] options = {"Yes", "No, Exit", "No, Play again"};
//			int option = JOptionPane.showOptionDialog(null, "Congratulation! You have completed this level.%nDo you want to play another level?", "OPTIONS", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
//			
//			if(option == JOptionPane.YES_OPTION) {
//				new MainMenu();
//			}
//			if(option == JOptionPane.NO_OPTION) {
//				System.exit(0);
//			}
//			if(option == JOptionPane.CANCEL_OPTION) {
//				board.restartLevel();
//			}
//		}
		
		setVisible(true);
	}
	
//	public void closeGame() {
//		dispose();
//	}
	
	public static void main(String[] args) {
		new MainMenu();
	}

}
