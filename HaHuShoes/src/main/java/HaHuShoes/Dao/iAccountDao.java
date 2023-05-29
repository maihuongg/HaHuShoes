package HaHuShoes.Dao;

import java.util.List;

import HaHuShoes.Model.CountByRoleName;
import HaHuShoes.Model.UserModel;


public interface iAccountDao {

	int countAll();

	void edit(UserModel userModel);

	void delete(String username);

	void insert(UserModel userModel);

	List<UserModel> paging(int index);

	List<UserModel> findAll();

	UserModel findbyUsername(String username);

	boolean insertUser(UserModel account);

	void editindividual(UserModel userModel);

	void editPassword(UserModel userModel);
	
	List<CountByRoleName> countbyRoleNames();
	
}
