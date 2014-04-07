package items;

import java.awt.Color;

import mainStuff.Game;

public class Player {
	
	public int x; public int y; 			//X and Y pos
	public int l; public int w;				//Length and Width
	public Color color; 							//Extra Drawing stuff
	
	public Player(int sx, int sy, Color c){
		x = sx;
		y = sx;
		l = 30;
		w = 30;
		color = c;
		
	}
	public void Move(int XC, int YC){
		if( this.x+XC >= 0 && this.x <= Game.ScreenX-XC - this.l)
			{this.x = this.x + XC;}
		
		if( this.y+YC >= 0 && this.y <= Game.ScreenY-YC- this.l)
			{this.y = (this.y + YC);}
		
		}
	public void kill() {
		Game.stuff.update();
		Game.state = "dead";
		Game.running = false;
		Game.stuff.update();
		System.out.println("You're dead");
		
	}
	}

