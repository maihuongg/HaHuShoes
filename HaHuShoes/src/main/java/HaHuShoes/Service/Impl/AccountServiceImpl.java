package HaHuShoes.Service.Impl;

import java.util.List;

import HaHuShoes.Dao.iAccountDao;
import HaHuShoes.Dao.Impl.AccountDaoImpl;
import HaHuShoes.Model.UserModel;
import HaHuShoes.Service.iAccountService;

public class AccountServiceImpl implements iAccountService {
	iAccountDao loginDAO = new AccountDaoImpl();

	@Override
	public UserModel login_cu(String username, String password) {
		UserModel account = loginDAO.findbyUsername(username);
		if (account != null) {
			if (account.getPassword().trim().equals(password)) {
				return account;
			}
		}
		return null;
	}

	@Override
	public UserModel findbyUsername(String username) {
		// TODO Auto-generated method stub
		return loginDAO.findbyUsername(username);
	}

	@Override
	public UserModel login_new(String username, String password) {
		// TODO Auto-generated method stub
		UserModel user = this.findbyUsername(username);
		if (user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;
	}

	@Override
	public List<UserModel> findAlL() {
		// TODO Auto-generated method stub
		return loginDAO.findAll();
	}

	@Override
	public void insert(UserModel userModel) {
		// TODO Auto-generated method stub
		loginDAO.insert(userModel);
	}

	@Override
	public void delete(String username) {
		// TODO Auto-generated method stub
		loginDAO.delete(username);
	}

	@Override
	public void edit(UserModel userModel) {
		// TODO Auto-generated method stub
		loginDAO.edit(userModel);
	}

	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return loginDAO.countAll();
	}

	@Override
	public List<UserModel> paging(int index) {
		// TODO Auto-generated method stub
		return loginDAO.paging(index);
	}
	@Override
	public boolean insertUser(UserModel account){
		return loginDAO.insertUser(account);
		}

	@Override
	public void editindividual(UserModel userModel) {
		// TODO Auto-generated method stub
		loginDAO.editindividual(userModel);
	}
	
	@Override
	public void editPassword(UserModel userModel) {
		// TODO Auto-generated method stub
		loginDAO.edit(userModel);
	}

}
