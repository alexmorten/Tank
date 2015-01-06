
public class Value {
public static String[] mobnames={"Basic Red","BartBaer"};
public static int[] moblives={1500,2500,3000};
public static int[] mobdamge={20,30,35};
public static int[] mobRewards={5,10,20};
public static int BasicRed=0;
public static int PanzerLive=100;
public static int[] shootingMobids={1,2};
public static int BulletDamage=200;
public static int bulletsize=Fenster.panel.defaultMobSize*15/80;
public static String[] upgradeImgSrcs={"drohne.png","drohne.png","drohne.png","drohne.png","drohne.png","drohne.png","drohne.png","drohne.png"};
public static int[] Upgradecosts={10};


public static boolean isAnyShootingMob(int id){
	for(int i=0;i<shootingMobids.length;i++){
		if(shootingMobids[i]==id)return true;
	
		
	}
	return false;
	
}

}
