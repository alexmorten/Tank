
public class Spawner {
public int spawntimer=0,spawndelay=10000,spawndistance,spawnrowmax=5,spawnslot=3;
	public Spawner() {
		spawndistance=Fenster.panel.getWidth()/spawnrowmax+10;
		
		
	
			spawnMob(0, 0);
			
		
	}
	
	
	public void spawnController(){
		if(spawntimer>=spawndelay){
			if(Panel.kills<3)   spawn(0);
				
			else if(Panel.kills<10)   spawn(1);
				
			else if(Panel.kills<20)   spawn(2);
			
		}else{
			spawntimer++;
		}
	}
	public void spawn(int Mobid){
		
			if(spawnslot>=spawnrowmax)spawnslot=0;
			for(int i=0;i<Fenster.panel.mobs.length;i++){
				if(Fenster.panel.mobs[i]==null || !Fenster.panel.mobs[i].ingame){
				spawnMob(i, Mobid);
				spawnslot++;
				spawntimer=0;
				break;
				}
				spawntimer=0;
			}
		
		
	}
	
	
	public void spawnMob(int i,int id){
		switch(id){
		case 0:
			Fenster.panel.mobs[i]=new Mob(spawndistance*spawnslot,10,id);
			break;
		case 1:
			Fenster.panel.mobs[i]=new BartBaer(spawndistance*spawnslot,10,id);
			break;
		case 2:
			Fenster.panel.mobs[i]=new Ufo(spawndistance*spawnslot,10,id);
			break;
		default:
			System.out.println("not valid mobid, spawner coudnt spawn it");
		
		}
	}
	
	
	
	
	
	
	
}
