package mainStuff;

import items.Enemy;
import items.Player;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;


@SuppressWarnings("serial")
public class Screen extends JComponent{

	public int ScreenX = Game.ScreenX;
	public int ScreenY = Game.ScreenY;
	
	
	Player p = Game.p;
	
	
	
	public Screen(){
		setPreferredSize(new Dimension(ScreenX, ScreenY));
		KeyListener KeyLis = new Keys();
		MouseListener MouseLis = new Mouse();
		this.addKeyListener(KeyLis);
		this.addMouseListener(MouseLis);
		setFocusable(true);
	}
	public void draw(Graphics g){
		
		BufferedImage BI = new BufferedImage(this.getWidth(), this.getHeight(),
								BufferedImage.TYPE_INT_RGB);
		Graphics2D gd = BI.createGraphics();
		FontMetrics gdfm = gd.getFontMetrics();
		
		if(Game.state == "menu"){
			//Draw START Button
			gd.setColor( new Color(0, 130, 0) );
			gd.fillRect(200, 300, 200, 80);
			gd.setFont(new Font("Bookman Old Style", Font.PLAIN, 50));
			gd.setColor(Color.white);
			gd.drawString("START", 210, 360);
			gdfm = gd.getFontMetrics();
			System.out.println("START WIDTH = " + gdfm.stringWidth("START"));
			}
		
		
		if(Game.state == "game"){
			//Back ground
			gd.setColor( Color.black );
			gd.fillRect(0, 0, getWidth(), getHeight());
			//Draw player
			gd.setColor( p.color );
			gd.fillRect(p.x , p.y, p.l , p.w);
			//Draw Enemies
			for (Enemy e : Game.Enemies) {
				gd.setColor( e.color);
				gd.fillRect(e.x, e.y, e.l, e.w);
			}//Draw FPS , Score
			gd.setFont(new Font("Bookman Old Style", Font.PLAIN, 20));
			gd.setColor(Color.WHITE);
			gd.drawString("FPS: "+Game.FPS, 30, 30);
			gd.drawString("SCORE: "+ Game.score, 200, 30);
			gd.drawString("ENEMIES: " +Game.Enemies.size(), 420, 30);
			
		
		}
		if(Game.state == "dead"){
			gd.setColor( Color.black );
			gd.fillRect(0, 0, getWidth(), getHeight());
			
			gd.setFont(new Font("Comic Sans MS", Font.PLAIN, 50)); 
			gd.setColor(Color.WHITE);
			gd.drawString("GAME OVER", 150, 200);
			gd.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
			gd.drawString("SCORE: " + Game.score, 200, 250);
		}
		g.drawImage(BI, 0, 0, null);
		gd.dispose();
	}
	public void paint(Graphics g){
		draw(g);
	}
	public void update(){
		draw(this.getGraphics());
		
	}
}


	


