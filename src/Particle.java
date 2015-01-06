import java.awt.Color;
import java.awt.Graphics;


public class Particle extends Actor{
public int particlesize=3;
public double direction;	
public int bewegungsfaktor=6;
public int lifetime;
public double directionabstractx,directionabstracty;
public boolean finished=false;
public int originid,targetid;
public double blutsrpitzfaktor=0.7;
	Particle(int x, int y , double gradr, int lifetime,int originid,int targetid){
	 giveBounds(x, y, particlesize, particlesize);
	 direction=gradr;
	this.originid=originid;
	this.targetid=targetid;
	 this.lifetime=lifetime;
	 directionabstractx= doubleRandom(-blutsrpitzfaktor, blutsrpitzfaktor);
	 directionabstracty=doubleRandom(-blutsrpitzfaktor, blutsrpitzfaktor);
 }
	public void paint(Graphics g){
switch(originid){

case -1:
	if(targetid==2){
		int r=intlRandom(2, 4);
		System.out.println("r:"+r);
		if(r==2){
			g.setColor(new Color(255,0 ,0));
		g.fillRect(x, y, height, width);
		}else{
		
			g.setColor(new Color(255,100 ,0));
		g.fillRect(x, y, height, width);
		}
	}else{
	g.setColor(new Color(200,0,30));
	g.fillRect(x, y, height, width);}
	break;
	default:
		g.setColor(new Color(0,255,80));
		g.fillRect(x, y, height, width);
}
	}
	
	
	int flyframe=0,flytime=bewegungsfaktor*2;
	public void PhyX(){
		if(flyframe>=flytime){
		 x = (int) Math.round(x + Math.cos(direction+directionabstractx) * bewegungsfaktor);
	      y = (int) Math.round(y + Math.sin(direction+directionabstracty) * bewegungsfaktor );
	   
	      flyframe=0;
		}else{
	    	  flyframe++;
		}
		  lifetime--;
	}	
	public static double doubleRandom(double low,double high){
		
		return (double) (Math.random() * (high - low) + low);
	}
public static int intRandom(int low,int high){
		
		return (int) (Math.random() * (high - low) + low);
	}
public int intlRandom(int low,int high){
	
	return (int) (Math.random() * (high - low) + low);
}
}
