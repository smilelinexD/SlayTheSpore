package Role;

public class Enemy extends Role{
	// Constructor
	public Enemy(String Name, int Health, int Energy) {
		super(Name, Health, Energy);
		switch(Name) {
		case "Cultist":
			this.Interface = new Cultist();
			break;
		case "Jaw_Worm":
			this.Interface = new Jaw_Worm();
			break;
		case "Louse_Red":
			this.Interface = new Louse_Red();
			break;
		case "Louse_Green":
			this.Interface = new Louse_Green();
			break;
		case "Gremlin_Nob":
			this.Interface = new Gremlin_Nob();
			break;
		case "Lagavulin":
			this.Interface = new Lagavulin();
			break;
		case "Slaver_Blue":
			this.Interface = new Slaver_Blue();
			break;
		case "Slaver_Red":
			this.Interface = new Slaver_Red();
			break;
		case "Fungi_Beast":
			this.Interface = new Fungi_Beast();
			break;
		case "Hexaghost":
			this.Interface = new Hexaghost();
			break;
		default:
			break;
		}
	}
	
	// Method
	
	//
	public void getIntend() {
		Interface.getIntend();
	}
	public void EnemyTurn(Role Enemy, Role Player) {
		Interface.EnemyTurn(Enemy, Player);
	}
	public String getIntendContent(){
		return Interface.getIntendContent(this);
	}
		
	// Member
	private IEnemy Interface = null;
}