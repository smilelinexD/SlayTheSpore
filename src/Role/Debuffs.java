package Role;
public class Debuffs {
	// Constructor
	public Debuffs() {}
	
	// Method
	
	// Get
	public int getVulnerableDuration() {
		return this.VulnerableDuration;
	}
	
	public int getWeakDuration() {
		return this.WeakDuration;
	}
	
	public int getEntangledDuration() {
		return this.EntangledDuration;
	}
	
	public int getCantDrawDuration() {
		return this.CantDrawDuration;
	}
	
	// Check
	public boolean checkDebuff() {
		return this.Debuffed;
	}
	
	public boolean checkVulnerable() {
		return this.Vulnerable;
	}
	
	public boolean checkWeak() {
		return this.Weak;
	}
	
	public boolean checkEntangled() {
		return this.Entangled;
	}
	
	public boolean checkCantDraw() {
		return this.CantDraw;
	}
	
	// Got
	public void GotVulnerable(int Duration) {
		this.VulnerableDuration += Duration;
		this.Debuffed = true;
		this.Vulnerable = true;
	}
	
	public void GotWeak(int Duration) {
		this.WeakDuration += Duration;
		this.Debuffed = true;
		this.Weak = true;
	}
	
	public void GotEntangled(int Duration) {
		this.EntangledDuration += Duration;
		this.Debuffed = true;
		this.Entangled = true;
	}
	
	public void gotCantDraw(int Duration) {
		this.CantDrawDuration += Duration;
		this.Debuffed = true;
		this.CantDraw = true;
	}
	
	public void RoundPass() {
		if(this.Vulnerable) {
			this.VulnerableDuration --;
			if(this.VulnerableDuration == 0) {
				this.Vulnerable = false;
			}
		}
		
		if(this.Weak) {
			this.WeakDuration --;
			if(this.WeakDuration == 0) {
				this.Weak = false;
			}
		}
		
		if(this.Entangled) {
			this.EntangledDuration --;
			if(this.EntangledDuration == 0) {
				this.Entangled = false;
			}
		}
		
		if(this.CantDraw) {
			this.CantDrawDuration --;
			if(this.CantDrawDuration == 0) {
				this.CantDraw = false;
			}
		}
		
		if(!(this.Vulnerable || this.Weak || this.Entangled || this.CantDraw)) {
			this.Debuffed = false;
		}
		
	}
	
	// Member
	protected boolean Debuffed = false;
	
	protected boolean Vulnerable = false;
	protected int VulnerableDuration = 0;
	
	protected boolean Weak = false;
	protected int WeakDuration = 0;
	
	protected boolean Entangled = false;
	protected int EntangledDuration = 0;
	
	protected boolean CantDraw = false;
	protected int CantDrawDuration = 0;
}
