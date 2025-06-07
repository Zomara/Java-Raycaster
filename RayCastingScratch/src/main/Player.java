package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class Player{
	
	GamePanel gp;
	Map map;
	
	public final double PI = Math.PI;
	
	public double x;
	public double y;
	public double dx;
	public double dy;
	public double a;
	public int width;
	public int height;
	public int speed = 2;
	
	public int xo = 0; //offset for collisions
	public int yo = 0; //offset for collisions
	int collision_range = 10;
	
	public int cmx, cmy; //current map xy
	public int fmx, fmy; //forward map xy
	public int bmx, bmy; //backward map xy
	
	public Player(GamePanel gp, KeyHandler keyH, Map map) {
		
		this.gp = gp;
		this.map = map;
		
		x = 300;
		y = 300;
		a = 0;
		dx = Math.cos(a)*speed;
		dy = Math.sin(a)*speed; 
		width = 8;
		height = 8;
	

	}
	
	public void update(KeyHandler keyH) {
		if (dx<0) {
			xo=-collision_range;
		} else {
			xo = collision_range;
		}
		if (dy<0) {
			yo=-collision_range;
		} else {
			yo = collision_range;
		}
		
		cmx = (int) (x/gp.tileSize);
		cmy = (int) (y/gp.tileSize);
		fmx = (int) ((x+xo)/gp.tileSize);
		bmx = (int) ((x-xo)/gp.tileSize);
		fmy = (int) ((y+yo)/gp.tileSize);
		bmy = (int) ((y-yo)/gp.tileSize);
		
		if (keyH.upPressed) {
			if (map.mapW[cmy][fmx] == 0) {
				x += dx;
			}	
			if (map.mapW[fmy][cmx] == 0) {
				y += dy;
			}	
		}if (keyH.downPressed) {
			if (map.mapW[cmy][bmx] == 0) {
				x -= dx;
			}	
			if (map.mapW[bmy][cmx] == 0) {
				y -= dy;
			}	
		}
		
		if (keyH.leftPressed) {
			a -= 0.03;
			if (a<0) {
				a += PI*2;
			}
			dx = Math.cos(a)*speed;
			dy = Math.sin(a)*speed;
		}if (keyH.rightPressed) {
			a += 0.03;
			dx = Math.cos(a)*speed;
			dy = Math.sin(a)*speed;
			if (a>2*PI) {
				a -= 2*PI;
			}
		}

	}
	
	public void draw(Graphics2D g2) {
		g2.setColor(Color.red);
		g2.fillRect((int) x-width/2, (int) y-height/2, width, height);
		g2.setStroke(new BasicStroke(1));
		g2.draw(new Line2D.Double(x, y, x+dx*10, y+dy*10));
		
	}
	
}
