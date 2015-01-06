import java.awt.Graphics;
import java.awt.Point;


public class JPanzer extends Actor{
	public int gehWeite=5,targetposgehweite=10;
	public int targetcrossheight=20,targetcrosswidth=20;
	public boolean reloaded=true;
	public Point targetpos;
	public int live=Value.PanzerLive;
	public int id =-1;
public int shotdelay=500,shotdingens=0;
	JPanzer(int x, int y, int height,int width){
	giveBounds(x, y, height, width);
	targetpos=new Point(Fenster.panel.getWidth()/2,10);
	}

public void move(int direction){
	int pixels=gehWeite;
	switch(direction){
	
	case 0:
	if(y-pixels>0)	y-=pixels;
		break;
	case 1:
		if((x+width+pixels)<Fenster.panel.getWidth())x+=pixels;
		break;
	case 2:
		if((y+height+pixels)<Fenster.panel.getHeight())y+=pixels;
		break;
	case 3:
		if(x-pixels>0)x-=pixels;
	break;
	default:
		System.out.println(direction+" is not a valid direction");
	}
	
	
}
public void fireBullet(){
	if(reloaded){
	for(int i=0;i<Fenster.panel.bullets.length;i++){
		if(Fenster.panel.bullets[i]== null || Fenster.panel.bullets[i].ingame==false ){
		Fenster.panel.bullets[i]=new Bullet(x+(width/2)-(Value.bulletsize/2), y+Value.bulletsize, Value.bulletsize,Value.bulletsize,new Point(targetpos.x,targetpos.y),id);
			reloaded=false;
			break;
		}
	}
	}
	
}
public void paint(Graphics g){
	g.drawImage(Fenster.panel.panzImg, x, y, height, width, null);
	
	g.drawImage(Fenster.panel.targetImg,targetpos.x-targetcrosswidth/2,targetpos.y-targetcrossheight/2,targetcrossheight,targetcrosswidth,null);

}
public void PhyX() {
    if(shotdingens>=shotdelay ){
reloaded=true;
 shotdingens=0;
 }
 else{
	  if(!reloaded) shotdingens++;
	   
 }
	
}
public void moveTargetPos(int direction){
	int pixels=targetposgehweite;
	switch(direction){
	
	case 0:
		
		if(targetpos.y-pixels>0)targetpos.y-=pixels;
		break;
	case 1:
		if(targetpos.x+pixels<Fenster.panel.getWidth())targetpos.x+=pixels;
		break;
	case 2:
		if(targetpos.y+pixels<Fenster.panel.getHeight())targetpos.y+=pixels;
		break;
	case 3:
		if(targetpos.x-pixels>0)targetpos.x-=pixels;
	break;
	default:
		System.out.println(direction+" is not a valid direction");
	}
}
}
