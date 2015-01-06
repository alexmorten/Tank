import java.awt.Graphics;


public class UpgradeIcon extends Actor{
public int id;

 UpgradeIcon(int x, int y,int width,int height,int id) {
	 this.id=id;
   giveBounds(x+2, y+2, width-4, height-4);
   

	}
	public void paint(Graphics g){
	g.drawImage(Fenster.panel.upgradeImgs[id], x, y, width, height, null);
	}
}
