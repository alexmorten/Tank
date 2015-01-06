import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public class KeyH implements MouseMotionListener,MouseListener,KeyListener {

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		System.out.println(Panel.mse);
		Fenster.panel.upgradeMenu.checkClick();
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		Panel.mse = new Point ((e.getX())-(Fenster.size.width-Panel.myWidth)/2,e.getY()-(((Fenster.size.height-(Panel.myHeight))-(Fenster.size.width-Panel.myWidth)/2)));
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		Panel.mse = new Point ((e.getX())-(Fenster.size.width-Panel.myWidth)/2,e.getY()-(((Fenster.size.height-(Panel.myHeight))-(Fenster.size.width-Panel.myWidth)/2)));
		
	}
  int targetposmovelength=8;
  private boolean PfeiltasteOben,PfeiltasteUnten,PfeiltasteRechts,PfeiltasteLinks,w,a,s,d,Leertaste;
  @Override
	
	public void keyPressed(KeyEvent arg0) {
	
		System.out.println(arg0.getKeyCode());			
	switch(arg0.getKeyCode()){
		case 87:   //w
			w=true;
			
			break;
		case 83://s
			s=true;			
		break;
		case 68://d
			d=true;
			
		break;
		case 65://a
		a=true;
			break;
		case 32://Leertaste
		Leertaste=true;
		break;
		case 39: //Pfeiltaste rechts
		PfeiltasteRechts=true;
			break;
		case 38: //Pfeiltaste oben
			PfeiltasteOben=true;
			break;
		case 37: //Pfeiltaste links
			PfeiltasteLinks=true;
			break;
		case 40: //Pfeiltaste unten
			PfeiltasteUnten=true;
			break;
		case 80: //p
			if(Panel.running){
				Panel.running=false;
				Panel.gamePaused=true;
			}
			else {
				Panel.running=true;
				Panel.gamePaused=false;
			}
			
			break;
		case 85: //u
			if(Panel.running){
				Panel.running=false;
				Panel.upgradeMenueactive=true;
			}
			else {
				Panel.running=true;
				Panel.upgradeMenueactive=false;
			}
			break;
		default:
			System.out.println(arg0.getKeyCode());
		
		}

		
	}
	

	@Override
	public void keyReleased(KeyEvent arg0) {
		switch(arg0.getKeyCode()){
		case 87:   //w
			w=false;
			
			break;
		case 83://s
			s=false;			
		break;
		case 68://d
			d=false;
			
		break;
		case 65://a
		a=false;
			break;
		case 32://Leertaste
		Leertaste=false;
		break;
		case 39: //Pfeiltaste rechts
		PfeiltasteRechts=false;
			break;
		case 38: //Pfeiltaste oben
			PfeiltasteOben=false;
			break;
		case 37: //Pfeiltaste links
			PfeiltasteLinks=false;
			break;
		case 40: //Pfeiltaste unten
			PfeiltasteUnten=false;
			break;
		default:
			System.out.println(arg0.getKeyCode());
		
		}
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
		
	}
	public void doKeystuff(){
		
		
		  //w
		if(w)	Fenster.panel.panzer.move(0);
			
			
	//s
		if(s)	Fenster.panel.panzer.move(2);
			
		
		//d
		if(d)	Fenster.panel.panzer.move(1);
			
	
		//a
		if(a)	Fenster.panel.panzer.move(3);
			
			
		//Leertaste
		if(Leertaste)	Fenster.panel.panzer.fireBullet();
	
		 //Pfeiltaste rechts
		if(PfeiltasteRechts)	Fenster.panel.panzer.moveTargetPos(1);
			
		//Pfeiltaste oben
		if(PfeiltasteOben)	Fenster.panel.panzer.moveTargetPos(0);;
		
		 //Pfeiltaste links
		if(PfeiltasteLinks)	Fenster.panel.panzer.moveTargetPos(3);
			
	//Pfeiltaste unten
	if(PfeiltasteUnten)		Fenster.panel.panzer.moveTargetPos(2);
	}

}
