package main;

import java.awt.Color;
import java.awt.Graphics2D;

public class Sprite {
	GamePanel gp;
	Map map;
	
	public final double PI = Math.PI;
	
	int type = 1;
	int state = 1;
	double x = 6.5*64;
	double y = 6.5*64;
	double z = 20;
	
	public Sprite(GamePanel gp, Map map) {
		this.gp = gp;
		this.map = map;
	}
	
	public void update() {
		
	}
	
	public void draw(Graphics2D g2) {
		// gp.player.x, gp.player.y, x, y are already in pixel coordinates (tile pixels)
		// Get relative position in pixels
		double sx = x - gp.player.x;
		double sy = y - gp.player.y;
		double sz = z; // height (in pixels or whatever consistent unit)
		
		sy = -sy;
		
		// Rotate relative to player angle
		double adjustedpa = 2 * Math.PI - gp.player.a;
		double CS = Math.cos(adjustedpa);
		double SN = Math.sin(adjustedpa);

		double rotatedX = sx * CS - sy * SN;
		double rotatedY = sx * SN + sy * CS;
		
		sx = rotatedX;
		sy = rotatedY;

		// Project to screen space
		sx = (sx * 108.0 / sy) - (120 / 2); // Centered on 960 width screen
		sy = (sz * 108.0 / sy);             // Project height

		sy = 640 - sy; // Flip Y axis for Java screen coordinates

		// Draw sprite at computed screen position
		g2.setColor(Color.yellow);
		g2.fillRect((int) sx, (int) sy, 8, 8);
		System.out.println(sx +" "+sy);
		
		
	}

}
