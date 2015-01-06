import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.*;


public class Panel extends JPanel implements Runnable{
	public Image panzImg,bulImg,targetImg,HintergrundImg,BartBaerImg,ProjectileImg,UfoImg;
	public Image[] upgradeImgs=new Image[10];
	public JPanzer panzer;
	public int defaultMobSize=80;
	public Mob[] mobs;
	public Bullet[] bullets;
	public UpgradeMenu upgradeMenu;
	public static boolean running=false;
	public Thread Gloop;
	public Spawner spawner;
	public static int Lifemax,Life;
	public static Effect effectm;
	public static int kills=0,money=20;
	public static boolean gameactive=true,gamePaused=false,upgradeMenueactive=false;
	public static Point mse;
	public static int myWidth,myHeight;
	
	
		
public boolean first=true;
public void paint(){
	repaint();
	
}
public void machalles(){
	Lifemax=Value.PanzerLive;
	Life=Value.PanzerLive;
	myWidth=getWidth();
	myHeight=getHeight();
	Gloop=new Thread(this);
	BartBaerImg=new ImageIcon("Res/Bartbaer.png").getImage();
	UfoImg=new ImageIcon("Res/Ufo1.png").getImage();
	ProjectileImg=new ImageIcon("Res/Projektil.png").getImage();
	HintergrundImg=new ImageIcon("Res/Hintergrund.jpg").getImage();
	panzImg=new ImageIcon("Res/panzerEcht.png").getImage();
	bulImg=new ImageIcon("Res/Bullet.png").getImage();
	panzer=new JPanzer((getWidth()/2)-(defaultMobSize/2),getHeight()-defaultMobSize,defaultMobSize/4*3,defaultMobSize);
	targetImg=new ImageIcon("Res/TargetCross.png").getImage();
	
	mobs=new Mob[100];
	bullets=new Bullet[100];
	spawner = new Spawner();
	effectm=new Effect();
	upgradeMenu= new UpgradeMenu();
	running=true;
	setUpgradeImgs();
	Gloop.start();
	
}
public void setUpgradeImgs(){
	for(int i=0;i<upgradeImgs.length;i++){
		if(i<Value.upgradeImgSrcs.length)upgradeImgs[i]=new ImageIcon("Res/"+Value.upgradeImgSrcs[i]).getImage();
	}
}
	public void paintComponent(Graphics g){
	if(first){	machalles();
	first=false;
	
	}

g.setColor(new Color(255,255,255));
	
	//g.fillRect(0, 0, getWidth(), getHeight());
	g.drawImage(HintergrundImg, 0, 0, getWidth(), getHeight(),null);
	g.setColor(new Color(0,255,150,30));
	g.fillRect(0, 0, getWidth(), getHeight());
		paintActors(g, bullets);
		paintActors(g,mobs);
		
		panzer.paint(g);
		effectm.doParticlestuff(g);
		
		check(g);
		upgradeMenu.paint(g);
		paintStatistics(g);
	 if(!running && gamePaused)paintPause(g);
	}
	public void paintPause(Graphics g){
		g.setColor(new Color(0,255,0,30));
		g.fillRect(0, 0, getWidth(), getHeight());
		
		g.setFont(new Font("Courier New",Font.BOLD,100));
		g.setColor(new Color(0,255,0));
	    g.drawString("Game Paused",0,400);
	}
	
	
	
	public void paintActors(Graphics g,Actor[] a){ 
		for(int i=0;i<a.length;i++){
			if(a[i]!=null && a[i].ingame==true)	a[i].paint(g);
			
		}

		
	}
	public void PhyX(Actor[] a){
		for(int i=0;i<a.length;i++){
		if(a[i]!=null && a[i].ingame)	a[i].PhyX();
		
			
		}
		
		
	}
	int keyframe=0,keytime=30;
	private void doKeyStuff(){
		if(keyframe>=keytime){
			keyframe=0;
			Fenster.fenster.keyh.doKeystuff();
			
		}else{
			keyframe++;
			
			
		}
	}
	@Override
	public void run() {
	while(gameactive){
		while(running){
			
			PhyX(mobs);
			PhyX(bullets);
			panzer.PhyX();
			spawner.spawnController();
			doKeyStuff();
			repaintCont();
			
			try{
				Thread.sleep(1);
			}catch(Exception e){}		
						
			
		}
		repaintCont();
		try{
			Thread.sleep(5);
		}catch(Exception e){}	
	
	}
		
	}
	int repframe=0,reptime=15;
	public void repaintCont(){
		if(repframe>=reptime){
			repframe=0;
			
			repaint();
		}else{
			repframe++;
			
			
		}
	}
	public void paintStatistics(Graphics g){
		g.setColor(new Color(255,0,70,180));
		
		
		g.setFont(new Font("Courier New",Font.BOLD,40));
	    g.drawString("Life: "+Life*100/Lifemax+"%",0,30);
	    
	    g.drawString("Kills: "+kills,0,70);
	    
	    g.drawString("Money: "+money +"$",0,110);
		
	}
	public void paintLoss(Graphics g){
		g.setColor(new Color(240,20,20,150));
		g.fillRect(0,0,getWidth(),getHeight());
		g.setColor(new Color(255,255,255));
		g.setFont(new Font("Courier New",Font.BOLD,100));
	    g.drawString("Game Over",0,200);
		
	}
	public void check(Graphics g){
		if(Life<=0){
			running=false;
			paintLoss(g);
			
			
		}
		
	}
	
}
