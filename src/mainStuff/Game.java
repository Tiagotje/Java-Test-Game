package mainStuff;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.util.ArrayList;
import java.util.Random;

import items.Enemy;
import items.Player;

import javax.swing.JFrame;
import javax.swing.JPanel;



@SuppressWarnings("serial")
public class Game extends JPanel{
	
	public static boolean running = true;
	public static Screen stuff;
	static int FPS = 50;			//Start FPS & Maximum FPS
	static int timesRun = 0;
	static int period = (int) 1000 / FPS;
	public static int ScreenX = 600;
	public static int ScreenY = 600;
	public static Player p = new Player(300, 300, Color.GREEN);
	public static ArrayList<Enemy> Enemies = new ArrayList<Enemy>();
	public static String state = "menu";
	public static long StartTime;
	public static int oldTimesRun;
	public static int score = 0;
	public static Random r = new Random();
	public static int spawnWait = 5;
	
	Game(){
		if (isFocusable()){
		setFocusable(true);
	}
		}
	
	public static boolean collidePoint(int Ax, int Ay, int Aw, int Al, int Px, int Py){
		if((Px >= Ax && Px <= Ax+Aw)&&(Py >= Ay && Py <= Ay+Al)){return true;}
		else{return false;}
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle("DAS SQUARES");
		
		GraphicsEnvironment GE = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Font fonts[] = GE.getAllFonts();
		for(Font fo : fonts){System.out.println(fo.getFontName());}
		
		stuff = new Screen();
		
		f.add(stuff);
		
		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		
		for (Enemy e : Enemies) {
		    e.Move();
		}
		
    	running = true;
   
    	StartTime = System.currentTimeMillis();
    	int oldTimesRun = 0;
    	
    	while(running){
    		//Count of cycles
    		timesRun++;
    		
    		if(state == "game"){
    			//new enemy every 5 seconds
    			if(timesRun % (FPS*spawnWait) == 0){Enemies.add(new Enemy()); spawnWait = r.nextInt(9)+1;}
    			
    			if(timesRun % (int) FPS == 0){score++;}
    			
    			//enemy update 10 times a second
    			if((timesRun) % (int)(FPS/10) == 0){
    				for(Enemy e: Enemies){ e.Move(); e.Check();}
    			}
    			//Update screen (Draw everything)
    			stuff.update();
    	
    		}
    		
    		//Every second (Update FPS and Score)
    		if(StartTime+1000 <= System.currentTimeMillis() ){
    			FPS = timesRun - oldTimesRun;
    			oldTimesRun = timesRun;
    			StartTime = System.currentTimeMillis();
    			spawnWait = r.nextInt(8)+1;
    			
    		}
    		//Stuff for sleeping
    		
    		try {
    			Thread.sleep(period);
    			}
    		catch(InterruptedException ex){}
    	}
	}


}

