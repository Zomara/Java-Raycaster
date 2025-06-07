package main;

import java.awt.Color;
import java.awt.Graphics2D;

public class Map {
	GamePanel gp;
	
	int mapW[][] = {
			{2, 4, 2, 2, 2, 2, 4, 2}, 
			{2, 0, 2, 0, 0, 0, 0, 2},
			{2, 0, 2, 0, 0, 0, 0, 2},
			{2, 0, 2, 0, 2, 2, 0, 2},
			{2, 0, 0, 0, 0, 0, 0, 2},
			{2, 0, 0, 0, 0, 2, 0, 2},
			{2, 2, 0, 0, 0, 0, 0, 2},
			{2, 2, 2, 2, 2, 2, 2, 2}};
	
	int mapF[][] = {
			{1, 1, 1, 1, 1, 1, 1, 1}, 
			{1, 1, 1, 1, 1, 1, 1, 1},
			{1, 1, 1, 1, 1, 1, 1, 1}, 
			{1, 1, 1, 1, 1, 1, 1, 1},
			{1, 1, 1, 1, 1, 1, 1, 1}, 
			{1, 1, 1, 1, 1, 1, 1, 1},
			{1, 1, 1, 1, 1, 1, 1, 1}, 
			{1, 1, 1, 1, 1, 1, 1, 1}};
	
	int mapC[][] = {
			{3, 3, 3, 3, 3, 3, 3, 3}, 
			{3, 3, 3, 3, 3, 3, 3, 3},
			{3, 3, 3, 3, 3, 3, 3, 3},
			{3, 3, 3, 3, 3, 3, 3, 3},
			{3, 3, 3, 3, 3, 3, 3, 3},
			{3, 3, 3, 3, 3, 3, 3, 3},
			{3, 3, 3, 3, 3, 3, 3, 3},
			{3, 3, 3, 3, 3, 3, 3, 3}};
	
	public Map (GamePanel gp) {
		this.gp = gp;
	}
	
	public void draw(Graphics2D g2) {
		
		
		int x, y, row, col;
		
		for(row=0;row<gp.mapY;row++) {
			for(col=0;col<gp.mapX;col++) {
				
				if (mapW[row][col] > 0) {
					g2.setColor(Color.white);
				} else {
					g2.setColor(Color.black);
				}
				
				y = row*gp.tileSize;
				x = col*gp.tileSize;
				
				g2.fillRect(x, y, gp.tileSize-1, gp.tileSize-1);
				
			}
		}
		
	}
	
}
