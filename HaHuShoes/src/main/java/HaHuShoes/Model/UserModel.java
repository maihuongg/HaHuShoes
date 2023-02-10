package HaHuShoes.Model;

public class UserModel {
	private int userId;
	private String userName;
	private String email;
	private String fullName;
	private String password;
	private String images;
	private String userCode;
	private int roleId;
	private int status;
	

	public UserModel(int userId, String userName, String email, String fullName, String password, String images,
			String userCode, int roleId,  int status) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.fullName = fullName;
		this.password = password;
		this.images = images;
		this.userCode = userCode;
		this.roleId = roleId;
		this.status = status;
	}

	public UserModel() {
		// TODO Auto-generated constructor stub
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}


	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	
	
}
