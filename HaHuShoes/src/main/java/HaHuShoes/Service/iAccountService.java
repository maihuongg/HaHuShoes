package HaHuShoes.Service;

import java.util.List;

import HaHuShoes.Model.CountByRoleName;
import HaHuShoes.Model.UserModel;

public interface iAccountService {

	List<UserModel> paging(int index);

	int countAll();

	void edit(UserModel userModel);

	void delete(String username);

	void insert(UserModel userModel);

	List<UserModel> findAlL();

	UserModel login_new(String username, String password);

	UserModel findbyUsername(String username);

	UserModel login_cu(String username, String password);

	boolean insertUser(UserModel account);
	
	void editindividual(UserModel userModel);

	void editPassword(UserModel userModel);
	
	List<CountByRoleName> countbyRoleNames();
	
}
