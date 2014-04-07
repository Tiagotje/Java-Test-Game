package mainStuff;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Mouse implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Mouse Click, X: " + e.getX() + " Y: " + e.getY());
		if(Game.state =="menu"){
			if( Game.collidePoint(200, 300, 200, 80, e.getX(), e.getY())){
				Game.state="game";
			}
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
