package HaHuShoes.Model;

public class CountByRoleName {
	String roleName;
	Integer countNameInteger;
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Integer getCountNameInteger() {
		return countNameInteger;
	}
	public void setCountNameInteger(Integer countNameInteger) {
		this.countNameInteger = countNameInteger;
	}
	public CountByRoleName(String roleName, Integer countNameInteger) {
		super();
		this.roleName = roleName;
		this.countNameInteger = countNameInteger;
	}
	
}
