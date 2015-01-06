import java.awt.*;



public class Mob extends Actor{
public int Lebenmax,Leben;
public String name;
public int id;

	Mob(int x, int y,int id){
		giveBounds(x, y, Fenster.panel.defaultMobSize, Fenster.panel.defaultMobSize);
		ingame=true;
		this.id=id;
		Lebenmax=Value.moblives[id];
		Leben=Lebenmax;
		
	}

	int dropframe=0,droptime=30;
   public void PhyX(){
	   checkLife();
	   dropDown();
	   doOtherPhyX();
	
	   
   }
   public void doOtherPhyX(){
	   
	   
   }
   public void checkLife(){
	   if(Leben<=0){
		   Panel.kills++;
		   Panel.money+=Value.mobRewards[id];
		   delete();
		   
	   }
   }
   public void dealDamage(int damage){
	   Leben-=damage;
	   checkLife();
	   
   }
   public void dropDown(){
	   if(isinFrame()){
	      if(dropframe>=droptime){
	   y++;
	   dropframe=0;
	   }
	   else{
		   dropframe++;
		   
	   }}else{
		
		   
		   delete();
	   }
   }
   
   public void paint(Graphics g){
		g.setColor(new Color(255,18,50));
		g.fillRect(x, y, width, height); //Mob
		
		paintLebensbar(g);
		
		
	}
   public void paintLebensbar(Graphics g){
	   g.setColor(new Color(0,0,0));
		g.fillRect(x, y-11, width, 10); //Lebensbar Hintergrund
		
		g.setColor(new Color(255,0,255));
		g.fillRect(x+1, y-10, (Leben*(width-2))/Lebenmax,8);//Lebensbar   
   }
}
