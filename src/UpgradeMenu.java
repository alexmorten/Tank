import java.awt.Color;
import java.awt.Graphics;


public class UpgradeMenu {
 
public UpgradeIcon[] upgradeIcons=new UpgradeIcon[10];
	UpgradeMenu(){
		for(int i=0;i<upgradeIcons.length;i++){
		if(i<5)	upgradeIcons[i]= new UpgradeIcon(Panel.myWidth/upgradeIcons.length*(i*2),300,Panel.myWidth/upgradeIcons.length,Panel.myWidth/upgradeIcons.length,i);
		else upgradeIcons[i]= new UpgradeIcon(Panel.myWidth/upgradeIcons.length*((i-5)*2),300+Panel.myWidth/upgradeIcons.length,Panel.myWidth/upgradeIcons.length,Panel.myWidth/upgradeIcons.length,i);
		}
		
	}
public void paint(Graphics g){
	if(Panel.upgradeMenueactive){
	g.setColor(new Color(0,0,255,150));
	g.fillRect(0, 0, Panel.myWidth, Panel.myHeight);
	for(int i=0;i<upgradeIcons.length;i++){
		upgradeIcons[i].paint(g);
	}}
		}
		public void checkClick(){
			if(Panel.upgradeMenueactive){
				for(int i=0;i<upgradeIcons.length;i++){
					if(upgradeIcons[i].contains(Panel.mse)){
						doUpgradeBuyStuff(upgradeIcons[i].id);
						
					}
					
				}
				
			}
			
		}
		public void doUpgradeBuyStuff(int id){
			if(Panel.money>=Value.Upgradecosts[id]){
			switch(id){
			case 0:
				
				Panel.Life+=Value.PanzerLive/100*5;
				Panel.money-=Value.Upgradecosts[id];
			
				break;
			default:
				System.out.println("Upgrade missing");
			
			}}
			
			
			
			
			
		}
}
