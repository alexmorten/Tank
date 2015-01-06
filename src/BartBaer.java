import java.awt.Graphics;
import java.awt.Point;


public class BartBaer extends Mob{
public int id=1;
	BartBaer(int x, int y,int id) {
		
		super(x, y,id);
		
	}
	
	public void paint(Graphics g){
		g.drawImage(Fenster.panel.BartBaerImg, x, y, width, height, null);
		paintLebensbar(g);
	}
	
	int shootframe=0,shoottime=4000;
	@Override
	public void doOtherPhyX(){
		if(shootframe>=shoottime){
			firebullet();
			
			shootframe=0;
			
		}else{
			
			shootframe++;
		}
		
	}
	public void firebullet(){
		for(int i=0;i<Fenster.panel.bullets.length;i++){
			if(Fenster.panel.bullets[i]== null || Fenster.panel.bullets[i].ingame==false ){
			Fenster.panel.bullets[i]=new Bullet(x+(width/2)-(Value.bulletsize/2), y+Value.bulletsize,Value.bulletsize, Value.bulletsize,new Point(Fenster.panel.panzer.x+Fenster.panel.panzer.width/2,Fenster.panel.panzer.y+Fenster.panel.panzer.height/2),id);
				
				break;
			}
		}
	}
}
