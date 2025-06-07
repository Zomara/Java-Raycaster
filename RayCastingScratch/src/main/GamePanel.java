package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
	
	// SCREEN SETTINGS
	public final int screenWidth = 960;
	public final int screenHeight = 640;
	public final int mapX = 8;
	public final int mapY = 8;
	public final int mapSize = mapX*mapY;
	public final int tileSize = 64;
	
	
	int FPS = 60;
	
	// SYSTEM
	KeyHandler keyH = new KeyHandler();
	Sound music = new Sound(); 
	Thread gameThread;
	
	// Classes
	public Map map = new Map(this);
	public Rays rays = new Rays(this, map);
	public Player player = new Player(this, keyH, map);
	public Sprite sprite = new Sprite(this, map);
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.darkGray);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}
	
	public void setupGame () {
		//music.setFile(0);
		//music.play();
		//music.loop();
	}

	
	public void startGameThread() {
		
		gameThread = new Thread(this);
		gameThread.start();
		
	}

	@Override
	public void run() {	
		
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		
		while (gameThread != null) {
				
			currentTime = System.nanoTime();
			
			delta += (currentTime - lastTime) / drawInterval;
			lastTime = currentTime;
			
			if (delta >= 1) {
				update();
				repaint();
				delta--;
			}
			
		}
		
	}
	public void update() {
		player.update(keyH);
		rays.update(keyH);
		sprite.update();
		
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		rays.draw(g2, keyH);
		
		//sprite.draw(g2);
		
		
		//map.draw(g2);
		
		//player.draw(g2);
		
		g2.dispose();
		
	}

}
