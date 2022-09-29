package Role;

public class Buffs {
	// Constructor
	public Buffs() {
	}

	// Method
	// Check
	public boolean checkBuff() {
		return this.Buffed;
	}

	public boolean checkStrength() {
		return this.Strength;
	}

	public boolean checkRitual() {
		return this.Ritual;
	}

	public boolean checkDexterity() {
		return this.Dexterity;
	}

	public boolean checkMetallicize() {
		return this.Metallicize;
	}

	public boolean checkRage() {
		return this.Rage;
	}

	public boolean checkEnrage() {
		return this.Enrage;
	}

	public boolean checkEvolve() {
		return this.Evolve;
	}

	public boolean checkCombust() {
		return this.Combust;
	}

	public boolean checkDark_Embrace() {
		return this.Dark_Embrace;
	}

	public boolean checkFeel_No_Pain() {
		return this.Feel_No_Pain;
	}

	public boolean checkFire_Breathing() {
		return this.Fire_Breathing;
	}

	public boolean checkFlame_Barrier() {
		return this.Flame_Barrier;
	}

	public boolean checkBarricade() {
		return this.Barricade;
	}

	public boolean checkBerserk() {
		return this.Berserk;
	}

	public boolean checkBrutality() {
		return this.Brutality;
	}

	public boolean checkDemon_Form() {
		return this.Demon_Form;
	}

	public boolean checkJuggernaut() {
		return this.Juggernaut;
	}

	// Get
	public int getStrengthLvl() {
		return this.StrengthLvl;
	}

	public int getRitualLvl() {
		return this.RitualLvl;
	}

	public int getDexterityLvl() {
		return this.DexterityLvl;
	}

	public int getMetallicizeLvl() {
		return this.MetallicizeLvl;
	}

	public int getRageLvl() {
		return this.RageLvl;
	}

	public int getEnrageLvl() {
		return this.EnrageLvl;
	}

	public int getEvolveLvl() {
		return this.EvolveLvl;
	}

	public int getCombustLvl() {
		return this.CombustLvl;
	}

	public int getDark_EmbraceLvl() {
		return this.Dark_EmbraceLvl;
	}

	public int getFeel_No_PainLvl() {
		return this.Feel_No_PainLvl;
	}

	public int getFire_BreathingLvl() {
		return this.Fire_BreathingLvl;
	}

	public int getFlame_BarrierLvl() {
		return this.Flame_BarrierLvl;
	}

	public int getBerserkLvl() {
		return this.BerserkLvl;
	}

	public int getBrutalityLvl() {
		return this.BrutalityLvl;
	}

	public int getDemon_FormLvl() {
		return this.Demon_FormLvl;
	}

	public int getJuggernautLvl() {
		return this.JuggernautLvl;
	}

	// Got
	public void gotStrength(int Lvl) {
		this.StrengthLvl += Lvl;

		if (this.StrengthLvl != 0) {
			this.Buffed = true;
			this.Strength = true;
		} else {
			this.Strength = false;
			this.checkBuffed();
		}
	}

	public void gotRitual(int Lvl) {
		this.RitualLvl += Lvl;
		if (this.RitualLvl != 0) {
			this.Buffed = true;
			this.Ritual = true;
		} else {
			this.Ritual = false;
			this.checkBuffed();
		}
	}

	public void gotDexterity(int Lvl) {
		this.DexterityLvl += Lvl;
		if (this.DexterityLvl != 0) {
			this.Buffed = true;
			this.Dexterity = true;
		} else {
			this.Dexterity = false;
			this.checkBuffed();
		}
	}

	public void gotMetallicize(int Lvl) {
		this.MetallicizeLvl += Lvl;
		if (this.MetallicizeLvl > 0) {
			this.Buffed = true;
			this.Metallicize = true;
		} else {
			this.Metallicize = false;
			this.checkBuffed();
		}
	}

	public void gotRage(int Lvl) {
		this.RageLvl += Lvl;
		if (this.RageLvl != 0) {
			this.Buffed = true;
			this.Rage = true;
		} else {
			this.Rage = false;
			this.checkBuffed();
		}
	}

	public void gotEnrage(int Lvl) {
		this.EnrageLvl += Lvl;
		if (this.EnrageLvl != 0) {
			this.Buffed = true;
			this.Enrage = true;
		} else {
			this.Enrage = false;
			this.checkBuffed();
		}
	}

	public void gotEvolve(int Lvl) {
		this.EvolveLvl += Lvl;
		if (this.EvolveLvl != 0) {
			this.Buffed = true;
			this.Evolve = true;
		} else {
			this.Evolve = false;
			this.checkBuffed();
		}
	}

	public void gotCombust(int Lvl) {
		this.CombustLvl += Lvl;
		if (this.CombustLvl != 0) {
			this.Buffed = true;
			this.Combust = true;
		} else {
			this.Combust = false;
			this.checkBuffed();
		}
	}

	public void gotDark_Embrace(int Lvl) {
		this.Dark_EmbraceLvl += Lvl;
		if (this.Dark_EmbraceLvl != 0) {
			this.Buffed = true;
			this.Dark_Embrace = true;
		} else {
			this.Dark_Embrace = false;
			this.checkBuffed();
		}
	}

	public void gotFeel_No_Pain(int Lvl) {
		this.Feel_No_PainLvl += Lvl;
		if (this.Feel_No_PainLvl != 0) {
			this.Buffed = true;
			this.Feel_No_Pain = true;
		} else {
			this.Feel_No_Pain = false;
			this.checkBuffed();
		}
	}

	public void gotFire_Breathing(int Lvl) {
		this.Fire_BreathingLvl += Lvl;
		if (this.Fire_BreathingLvl != 0) {
			this.Buffed = true;
			this.Fire_Breathing = true;
		} else {
			this.Fire_Breathing = false;
			this.checkBuffed();
		}
	}

	public void gotFlame_Barrier(int Lvl) {
		this.Flame_BarrierLvl += Lvl;
		if (this.Flame_BarrierLvl != 0) {
			this.Buffed = true;
			this.Flame_Barrier = true;
		} else {
			this.Flame_Barrier = false;
			this.checkBuffed();
		}
	}

	public void gotBarricade() {
		this.Barricade = true;
	}

	public void gotBerserk(int Lvl) {
		this.BerserkLvl += Lvl;
		if (this.BerserkLvl != 0) {
			this.Buffed = true;
			this.Berserk = true;
		} else {
			this.Berserk = false;
			this.checkBuffed();
		}
	}

	public void gotBrutality(int Lvl) {
		this.BrutalityLvl += Lvl;
		if (this.BrutalityLvl != 0) {
			this.Buffed = true;
			this.Brutality = true;
		} else {
			this.Brutality = false;
			this.checkBuffed();
		}
	}

	public void gotDemon_Form(int Lvl) {
		this.Demon_FormLvl += Lvl;
		if (this.Demon_FormLvl != 0) {
			this.Buffed = true;
			this.Demon_Form = true;
		} else {
			this.Demon_Form = false;
			this.checkBuffed();
		}
	}

	public void gotJuggernaut(int Lvl) {
		this.JuggernautLvl += Lvl;
		if (this.JuggernautLvl != 0) {
			this.Buffed = true;
			this.Juggernaut = true;
		} else {
			this.Juggernaut = false;
			this.checkBuffed();
		}
	}

	// Combat
	public void RoundPass() {
		this.Rage = false;
		this.RageLvl = 0;

		this.Flame_Barrier = false;
		this.Flame_BarrierLvl = 0;

		this.checkBuffed();
	}

	private void checkBuffed() {
		if (!(this.Strength || this.Ritual || this.Dexterity || this.Metallicize || this.Rage || this.Enrage
				|| this.Evolve || this.Combust || this.Dark_Embrace || this.Feel_No_Pain || this.Fire_Breathing
				|| this.Barricade || this.Berserk || this.Brutality || this.Demon_Form || this.Juggernaut)) {
			this.Buffed = false;
		}
	}

	// Member
	protected boolean Buffed = false;

	protected boolean Strength = false;
	protected int StrengthLvl = 0;

	protected boolean Ritual = false;
	protected int RitualLvl = 0;

	protected boolean Dexterity = false;
	protected int DexterityLvl = 0;

	protected boolean Metallicize = false;
	protected int MetallicizeLvl = 0;

	protected boolean Rage = false;
	protected int RageLvl = 0;

	protected boolean Enrage = false;
	protected int EnrageLvl = 0;

	protected boolean Evolve = false;
	protected int EvolveLvl = 0;

	protected boolean Combust = false;
	protected int CombustLvl = 0;

	protected boolean Dark_Embrace = false;
	protected int Dark_EmbraceLvl = 0;

	protected boolean Feel_No_Pain = false;
	protected int Feel_No_PainLvl = 0;

	protected boolean Fire_Breathing = false;
	protected int Fire_BreathingLvl = 0;

	protected boolean Flame_Barrier = false;
	protected int Flame_BarrierLvl = 0;

	protected boolean Barricade = false;

	protected boolean Berserk = false;
	protected int BerserkLvl = 0;

	protected boolean Brutality = false;
	protected int BrutalityLvl = 0;

	protected boolean Demon_Form = false;
	protected int Demon_FormLvl = 0;

	protected boolean Juggernaut = false;
	protected int JuggernautLvl = 0;
}
