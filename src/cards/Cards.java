package cards;

import Role.Role;

public class Cards {
	// Method
	// Interface ICards
	public int Use(Role Player, Role Target) {
		return data.Use(Player, Target);
	}

	public String getName() {
		return data.getName();
	}

	public String getType() {
		return data.getType();
	}

	public String getRarity() {
		return data.getRarity();
	}

	public int getEnergy() {
		return data.getEnergy();
	}

	public String getDescription() {
		return data.getDescription();
	}

	// Set
	public void setTmpInGame() {
		this.tmpInGame = true;
	}

	// Check
	public boolean checkTmpInGame() {
		return this.tmpInGame;
	}
	public boolean checkEthereal() {
		return this.Ethereal;
	}
	// Member
	private ICards data = null;
	
	private boolean Ethereal = false;
	private boolean tmpInGame = false;

	// Constructor
	public Cards(String Name) {
		switch (Name) {
		case "Wound":
			data = new Wound();
			break;
		case "Burn":
			data = new Burn();
			break;
		case "Dazed":
			data = new Dazed();
			this.Ethereal = true;
			break;
		case "Bash":
			data = new Bash();
			break;
		case "Defend":
			data = new Defend();
			break;
		case "Strike":
			data = new Strike();
			break;
		case "Anger":
			data = new Anger();
			break;
		case "Armaments":
			data = new Armaments();
			break;
		case "Body_Slam":
			data = new Body_Slam();
			break;
		case "Clash":
			data = new Clash();
			break;
		case "Cleave":
			data = new Cleave();
			break;
		case "Clothesline":
			data = new Clothesline();
			break;
		case "Flex":
			data = new Flex();
			break;
		case "Havoc":
			data = new Havoc();
			break;
		case "Headbutt":
			data = new Headbutt();
			break;
		case "Heavy_Blade":
			data = new Heavy_Blade();
			break;
		case "Iron_Wave":
			data = new Iron_Wave();
			break;
		case "Perfected_Strike":
			data = new Perfected_Strike();
			break;
		case "Pommel_Strike":
			data = new Pommel_Strike();
			break;
		case "Shrug_It_Off":
			data = new Shrug_It_Off();
			break;
		case "Sword_Boomerang":
			data = new Sword_Boomerang();
			break;
		case "Thunderclap":
			data = new Thunderclap();
			break;
		case "True_Gift":
			data = new True_Gift();
			break;
		case "Twin_Strike":
			data = new Twin_Strike();
			break;
		case "Warcry":
			data = new Warcry();
			break;
		case "Wild_Strike":
			data = new Wild_Strike();
			break;
		case "Battle_Trance":
			data = new Battle_Trance();
			break;
		case "Blood_For_Blood":
			data = new Blood_For_Blood();
			break;
		case "Bloodletting":
			data = new Bloodletting();
			break;
		case "Burning_Pact":
			data = new Burning_Pact();
			break;
		case "Carnage":
			data = new Carnage();
			this.Ethereal = true;
			break;
		case "Combust":
			data = new Combust();
			break;
		case "Dark_Embrace":
			data = new Dark_Embrace();
			break;
		case "Disarm":
			data = new Disarm();
			break;
		case "Dropkick":
			data = new Dropkick();
			break;
		case "Dual_Wield":
			data = new Dual_Wield();
			break;
		case "Entrench":
			data = new Entrench();
			break;
		case "Evolve":
			data = new Evolve();
			break;
		case "Feel_No_Pain":
			data = new Feel_No_Pain();
			break;
		case "Fire_Breathing":
			data = new Fire_Breathing();
			break;
		case "Flame_Barrier":
			data = new Flame_Barrier();
			break;
		case "Ghostly_Armor":
			data = new Ghostly_Armor();
			this.Ethereal = true;
			break;
		case "Hemokinesis":
			data = new Hemokinesis();
			break;
		case "Inflame":
			data = new Inflame();
			break;
		case "Intimidate":
			data = new Intimidate();
			break;
		case "Metallicize":
			data = new Metallicize();
			break;
		case "Power_Through":
			data = new Power_Through();
			break;
		case "Pummel":
			data = new Pummel();
			break;
		case "Rage":
			data = new Rage();
			break;
		case "Reckless_Charge":
			data = new Reckless_Charge();
			break;
		case "Searing_Blow":
			data = new Searing_Blow();
			break;
		case "Second_Wind":
			data = new Second_Wind();
			break;
		case "Seeing_Red":
			data = new Seeing_Red();
			break;
		case "Sentinel":
			data = new Sentinel();
			break;
		case "Sever_Soul":
			data = new Sever_Soul();
			break;
		case "Shockwave":
			data = new Shockwave();
			break;
		case "Uppercut":
			data = new Uppercut();
			break;
		case "Whirlwind":
			data = new Whirlwind();
			break;
		case "Barricade":
			data = new Barricade();
			break;
		case "Berserk":
			data = new Berserk();
			break;
		case "Bludgeon":
			data = new Bludgeon();
			break;
		case "Brutality":
			data = new Brutality();
			break;
		case "Demon_Form":
			data = new Demon_Form();
			break;
		case "Feed":
			data = new Feed();
			break;
		case "Fiend_Fire":
			data = new Fiend_Fire();
			break;
		case "Immolate":
			data = new Immolate();
			break;
		case "Impervious":
			data = new Impervious();
			break;
		case "Juggernaut":
			data = new Juggernaut();
			break;
		case "Limit_Break":
			data = new Limit_Break();
			break;
		case "Offering":
			data = new Offering();
			break;
		default:
			break;
		}
	}
}
