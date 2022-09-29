package cards;

import java.util.Random;

import Role.Role;

public class Dual_Wield implements ICards{
	// Method
	@Override
	public int Use(Role Player, Role NULL) {
		if (Player.useEnergy(this.Energy) != -1) {
			int index;
			do{
				index = ran.nextInt(Player.getHand().size());
			}while(Player.getHand().get(index).getType() != "Attack" && Player.getHand().get(index).getType() != "Power");
			String name = Player.getHand().get(index).getName();
			Cards tmp = new Cards(name);
			tmp.setTmpInGame();
			Player.addCardToHand(tmp);
			tmp = null;
			return 0;
		} else {
			return -1;
		}
	}

	@Override
	public String getName() {
		return this.Name;
	}

	@Override
	public String getType() {
		return this.Type;
	}

	@Override
	public String getRarity() {
		return this.Rarity;
	}

	@Override
	public int getEnergy() {
		return this.Energy;
	}

	@Override
	public String getDescription() {
		return this.Description;
	}

	// Member
	protected String Name = "Dual_Wield";
	protected String Type = "Skill";
	protected String Rarity = "Uncommon";
	protected int Energy = 1;
	protected String Description = "Create a copy of an Attack or\nPower card in your\nhand.";
	
	private Random ran = new Random();
}
