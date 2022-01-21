package test05;

public class Hero {
	private String name;
	private String affiliation; //소속
	private long combatPower;
	
	public Hero(String name, String affiliation, long combatPower) {
		this.name = name;
		this.affiliation = affiliation;
		this.combatPower = combatPower;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAffiliation() {
		return affiliation;
	}
	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}
	public long getCombatPower() {
		return combatPower;
	}
	public void setCombatPower(long combatPower) {
		this.combatPower = combatPower;
	}
	
	
	
	
}
