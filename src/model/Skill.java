package model;

public class Skill {

	Long skillid;
	String skillName;

	public Long getSkillid() {
		return skillid;
	}

	public void setSkillid(Long skillid) {
		this.skillid = skillid;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public Skill(Long skilld, String skillName) {
		super();
		this.skillid = skilld;
		this.skillName = skillName;
	}

}
