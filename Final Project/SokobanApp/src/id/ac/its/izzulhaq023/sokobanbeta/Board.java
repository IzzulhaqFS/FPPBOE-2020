package id.ac.its.izzulhaq023.sokobanbeta;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Board extends JPanel {

	private final int OFFSET = 30;
	private final int SPACE = 20;
	private final int LEFT_COLLISION = 1;
	private final int RIGHT_COLLISION = 2;
	private final int TOP_COLLISION = 3;
	private final int BOTTOM_COLLISION = 4;
	
	private ArrayList<Wall> walls;
	private ArrayList<Baggage> baggage;
	private ArrayList<Area> areas;
	
	private Player p;
	private int w = 0;
	private int h = 0;
	
	private boolean isCompleted = false;
	
	private String level = "    ######\n"
						 + "    ##   #\n"
						 + "    ##$  #\n"
						 + "  ####  $##\n"
						 + "  ##  $ $ #\n"
						 + "#### # ## #   ######\n"
						 + "##   # ## #####  ..#\n"
						 + "## $  $          ..#\n"
						 + "###### ### #@##  ..#\n"
						 + "    ##     #########\n"
						 + "    ########\n";
	
	public Board() {
		initBoard();
	}
	
	private void initBoard() {
		addKeyListener(new TAdapter());
		setFocusable(true);
		initWorld();
	}
	
	public int getBoardWidth() {
		return this.w;
	}
	
	public int getBoardHeight() {
		return this.h;
	}
	
	private void initWorld() {
		walls = new ArrayList<>();
		baggage = new ArrayList<>();
		areas = new ArrayList<>();
		
		int x = OFFSET;
		int y = OFFSET;
		
		Wall wall;
		Baggage bagg;
		Area area;
		
		for(int i = 0; i < level.length(); i++) {
			char item = level.charAt(i);
			
			switch(item) {
			case '\n':
				y += SPACE;
				
				if(this.w < x)
					this.w = x;
				
				x = OFFSET;
				break;
			case '#':
				wall = new Wall(x, y);
				walls.add(wall);
				x += SPACE;
				break;
			case '$':
				bagg = new Baggage(x, y);
				baggage.add(bagg);
				x += SPACE;
				break;
			case '.':
				area = new Area(x, y);
				areas.add(area);
				x += SPACE;
				break;
			case '@':
				p = new Player(x, y);
				x += SPACE;
				break;
			case ' ':
				x += SPACE;
				break;
			default:
				break;
			}
			
			h = y;
		}
	}
	
	private void buildWorld(Graphics g) {
		g.setColor(new Color(250, 240, 170));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		ArrayList<Actor> world = new ArrayList<>();
		
		world.addAll(walls);
		world.addAll(areas);
		world.addAll(baggage);
		world.add(p);
		
		for(int i = 0; i < world.size(); i++) {
			Actor item = world.get(i);
			
			if(item instanceof Player || item instanceof Baggage)
				g.drawImage(item.getImage(), item.getX() + 2, item.getY() + 2, this);
			else
				g.drawImage(item.getImage(), item.getX(), item.getY(), this);
			
			if(isCompleted) {
				g.setColor(new Color(0, 0, 0));
				g.drawString("Completed", 25, 20);
			}
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		buildWorld(g);
	}
	
	private class TAdapter extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			if(isCompleted)
				return;
			
			int key = e.getKeyCode();
			
			switch(key) {
			case KeyEvent.VK_LEFT:
				if(checkWallCollision(p, LEFT_COLLISION))
					return;
				
				if(checkBagCollision(LEFT_COLLISION))
					return;
				
				p.move(-SPACE, 0);
				
				break;
			case KeyEvent.VK_RIGHT:
				if(checkWallCollision(p, RIGHT_COLLISION))
					return;
				
				if(checkBagCollision(RIGHT_COLLISION))
					return;
				
				p.move(SPACE, 0);
				
				break;
			case KeyEvent.VK_UP:
				if(checkWallCollision(p, TOP_COLLISION))
					return;
				
				if(checkBagCollision(TOP_COLLISION))
					return;
				
				p.move(0, -SPACE);
				
				break;
			case KeyEvent.VK_DOWN:
				if(checkWallCollision(p, BOTTOM_COLLISION))
					return;
				
				if(checkBagCollision(BOTTOM_COLLISION))
					return;
				
				p.move(0, SPACE);
				
				break;
			case KeyEvent.VK_R:
				restartLevel();
				
				break;
			default:
				break;
			}
			
			repaint();
		}
		
	}
	
	private boolean checkWallCollision(Actor actor, int type) {
		switch(type) {
		case LEFT_COLLISION:
			for(int i = 0; i < walls.size(); i++) {
				Wall wall = walls.get(i);
				if(actor.isLeftCollision(wall))
					return true;
			}
			
			return false;
		case RIGHT_COLLISION:
			for(int i = 0; i < walls.size(); i++) {
				Wall wall = walls.get(i);
				if(actor.isRightCollision(wall))
					return true;
			}
			
			return false;
		case TOP_COLLISION:
			for(int i = 0; i < walls.size(); i++) {
				Wall wall = walls.get(i);
				if(actor.isTopCollision(wall))
					return true;
			}
			
			return false;
		case BOTTOM_COLLISION:
			for(int i = 0; i < walls.size(); i++) {
				Wall wall = walls.get(i);
				if(actor.isBottomCollision(wall))
					return true;
			}
			
			return false;
		default:
			break;
		}
		
		return false;
	}
	
	private boolean checkBagCollision(int type) {
		switch(type) {
		case LEFT_COLLISION:
			for(int i = 0; i < baggage.size(); i++) {
				Baggage bag = baggage.get(i);
				
				if(p.isLeftCollision(bag)) {
					for(int j = 0; j < baggage.size(); j++) {
						Baggage item = baggage.get(j);
						
						if(!bag.equals(item)) {
							if(bag.isLeftCollision(item))
								return true;
						}
						
						if(checkWallCollision(bag, LEFT_COLLISION))
							return true;
					}
					
					bag.move(-SPACE, 0);
					isCompleted();
				}
			}
			
			return false;
		case RIGHT_COLLISION:
			for(int i = 0; i < baggage.size(); i++) {
				Baggage bag = baggage.get(i);
				
				if(p.isRightCollision(bag)) {
					for(int j = 0; j < baggage.size(); j++) {
						Baggage item = baggage.get(j);
						
						if(!bag.equals(item)) {
							if(bag.isRightCollision(item))
								return true;
						}
						
						if(checkWallCollision(bag, RIGHT_COLLISION))
							return true;
					}
					
					bag.move(SPACE, 0);
					isCompleted();
				}
			}
			
			return false;
		case TOP_COLLISION:
			for(int i = 0; i < baggage.size(); i++) {
				Baggage bag = baggage.get(i);
				
				if(p.isTopCollision(bag)) {
					for(int j = 0; j < baggage.size(); j++) {
						Baggage item = baggage.get(j);
						
						if(!bag.equals(item)) {
							if(bag.isTopCollision(item))
								return true;
						}
						
						if(checkWallCollision(bag, TOP_COLLISION))
							return true;
					}
					
					bag.move(0, -SPACE);
					isCompleted();
				}
			}
			
			return false;
		case BOTTOM_COLLISION:
			for(int i = 0; i < baggage.size(); i++) {
				Baggage bag = baggage.get(i);
				
				if(p.isBottomCollision(bag)) {
					for(int j = 0; j < baggage.size(); j++) {
						Baggage item = baggage.get(j);
						
						if(!bag.equals(item)) {
							if(bag.isBottomCollision(item))
								return true;
						}
						
						if(checkWallCollision(bag, BOTTOM_COLLISION))
							return true;
					}
					
					bag.move(0, SPACE);
					isCompleted();
				}
			}
			
			break;
		default:
			break;
		}
		
		return false;
	}
	
	public void isCompleted() {
		int nOfBags = baggage.size();
		int finishedBags = 0;
		
		for(int i = 0; i < nOfBags; i++) {
			Baggage bag = baggage.get(i);
			
			for(int j = 0; j < nOfBags; j++) {
				Area area = areas.get(j);
				
				if(bag.getX() == area.getX() && bag.getY() == area.getY())
					finishedBags += 1;
			}
		}
		
		if(finishedBags == nOfBags) {
			isCompleted = true;
			repaint();
		}
	}
	
	public void restartLevel() {
		areas.clear();
		baggage.clear();
		walls.clear();
		
		initWorld();
		
		if(isCompleted)
			isCompleted = false;
	}
}