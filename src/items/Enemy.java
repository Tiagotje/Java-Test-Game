package items;

import java.awt.Color;
import java.util.Random;

import mainStuff.Game;

public class Enemy {
	
	public int x; public int y; 			//X and Y position
	public int l; public int w;				//Length and Width
	public Color color; 					//Extra Drawing stuff
	int t;	public int s;					//Type and Speed
	static Random r = new Random();			//New random object r
	public int xSpeed; public int ySpeed = 0;
	Player p = Game.p;
	
	public Enemy(){
		x = r.nextInt(Game.ScreenX-30);
		y = 0;   l = 30;    w = 30;
		color = Color.RED;
		t = 1;
		xSpeed = r.nextInt(15) - 8;
		while(ySpeed == 0) { ySpeed = r.nextInt(15) - 8; }
	}
	public void Move(){          //TO-DO
		x += this.xSpeed;
		y += this.ySpeed;
		if((x + xSpeed < 0) || (x + xSpeed > Game.ScreenX-30)){ xSpeed = -xSpeed; }
		if((y + ySpeed < 0) || (y + ySpeed > Game.ScreenY-30)){ ySpeed = -ySpeed; }
		
		
	}
	public void Check() {
		if( ((this.x >= p.x-p.w && this.x < p.x+p.w) && (this.y >= p.y-p.l && this.y < p.y+p.l)) ){
			Game.stuff.update();
			p.kill();
		}
		for(Enemy A: Game.Enemies){
			if( ((this.x >= A.x-A.w && this.x < A.x+A.w) && (this.y >= A.y-A.l && this.y < A.y+A.l)) ){
				this.xSpeed = -this.xSpeed;
				this.ySpeed = -this.ySpeed;
				A.xSpeed = -A.xSpeed;
				A.ySpeed = -A.ySpeed;
		}
		}
	}
}
