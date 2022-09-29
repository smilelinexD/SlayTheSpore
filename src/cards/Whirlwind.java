package cards;

import Role.Role;

public class Whirlwind implements ICards{
	// Method
	@Override
	public int Use(Role Player, Role NULL) {
		int tmp = Player.getEnergy();
		Player.useEnergy(tmp);
		for(int i = 0; i < tmp; i++) {
			for(Role Target : Player.getBattle().Enemies) {
				if(Target.checkDead() == false) {
					Target.Hurt(Player.DamageCount(5));
				}
			}
		}
		return 0;
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
	protected String Name = "Whirlwind";
	protected String Type = "Attack";
	protected String Rarity = "Uncommon";
	protected int Energy = -1;
	protected String Description = "Deal 5 damage to ALL enemies X times.";
}
