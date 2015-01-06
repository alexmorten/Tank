import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import javax.management.modelmbean.ModelMBeanNotificationBroadcaster;
import javax.security.auth.callback.ChoiceCallback;


public class Bullet extends Actor {
 public int bulletDamage=Value.BulletDamage;
 private boolean hastarget=false;
 public boolean bulletfriendly=true;
private double bewegungsfaktor=6;
public int id;
 public Point target;
	Bullet(int x, int y, int height, int width,Point target,int id){
		giveBounds(x, y, height, width);
	this.target=target;
	this.id=id;
		ingame=true;
	}
	@Override
	public void paint(Graphics g){
		
		if(id==-1)g.drawImage(Fenster.panel.ProjectileImg, x, y, height, width, null);
		else g.drawImage(Fenster.panel.ProjectileImg, x, y, height, width, null);
	}
	
	
	int flyframe=0,flytime=10;
	public void PhyX(){
			
	if(isinFrame())	{
   checkForHits();
   flystuff();
		}else{
		
		delete();
	}
	
	
	
	}
	double grad;
	double gradr;
public void fly(){
if(!hastarget)
	doAngle();
	
	 
	 x = (int) Math.round(x + Math.cos(gradr) * bewegungsfaktor);
      y = (int) Math.round(y + Math.sin(gradr) * bewegungsfaktor );
	
}
public void checkForHits(){
if(id==-1){
	for(int i=0;i<Fenster.panel.mobs.length;i++){
	if(Fenster.panel.mobs[i]!=null && Fenster.panel.mobs[i].ingame ){	
	if(Fenster.panel.mobs[i].intersects(this)){
		Fenster.panel.mobs[i].dealDamage(bulletDamage);
		System.out.println("getroffen:"+Fenster.panel.mobs[i].id);
		Panel.effectm.doNewEffect(x, y, 50, gradr,id,Fenster.panel.mobs[i].id);
		delete();
		
		
	}	
	
	}
	
	}}else if(Value.isAnyShootingMob(id)){
		if(this.intersects(Fenster.panel.panzer)){
			Panel.Life-=Value.mobdamge[id];
			Panel.effectm.doNewEffect(x, y, 50 , gradr,id,-1);
			delete();
		}
	}
	
	
}
public void doAngle(){
	grad =Math.toDegrees(Math.atan2(target.y - y, target.x -x));
	
	
	System.out.println(grad);
	 gradr = Math.toRadians( grad);
	 System.out.println(gradr);
	 hastarget=true;
}

	public void flystuff(){
			if(flyframe>=flytime){
		fly();
		flyframe=0;
	}else{
		flyframe++;
		
	}	

		
	}
	
}
