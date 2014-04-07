package mainStuff;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


	
	public class Keys implements KeyListener {
		
		static int Xspeed = 15;
		static int Yspeed = 15;

		public void keyTyped(KeyEvent e) {

		}

	    //a of left  =  37 of 65
	    //w of up =  	38 of 87
	    //d of right    39 of 68
	    //s of down		40 of 83
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()){
			//left
			case 37: {Game.p.Move(-Xspeed, 0); break;}
			case 65: {Game.p.Move(-Xspeed, 0); break;}
			//up
			case 38: {Game.p.Move(0, -Yspeed); break;}
			case 87: {Game.p.Move(0, -Yspeed); break;}
			//right
			case 39: {Game.p.Move(Xspeed, 0); break;}
			case 68: {Game.p.Move(Xspeed, 0); break;}
			//down
			case 40: {Game.p.Move(0, Yspeed); break;}
			case 83: {Game.p.Move(0, Yspeed); break;}
			//Q
			case 81: {Game.p.kill(); break;}
			default: {System.out.println(e.getKeyCode());}
			

			}
		}


		public void keyReleased(KeyEvent e) {
			
		}
	
}

