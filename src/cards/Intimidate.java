package cards;

import java.util.ArrayList;

import Role.Enemy;
import Role.Role;

public class Intimidate implements ICards{
	// Method
	@Override
	public int Use(Role Player, Role NULL) {
		if(Player.useEnergy(this.Energy) != -1) {
			ArrayList<Enemy> Targets = Player.getBattle().Enemies;
			for(Role Target : Targets) {
				if(Target.checkDead() == false) {
					Target.gotDebuff("Weak", 1);
				}
			}
			Player.ExhaustUsing();
			return 0;
		}
		else {
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
	protected String Name = "Intimidate";
	protected String Type = "Skill";
	protected String Rarity = "Uncommon";
	protected int Energy = 0;
	protected String Description = "Apply 1 Weak to ALL enemies.\nExhaust.";
}
