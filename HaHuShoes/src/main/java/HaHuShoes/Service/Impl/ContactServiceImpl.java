package HaHuShoes.Service.Impl;

import HaHuShoes.Dao.iContactDao;
import HaHuShoes.Dao.Impl.ContactDaoImpl;
import HaHuShoes.Model.ContactModel;
import HaHuShoes.Service.iContactService;

public class ContactServiceImpl implements iContactService{

	iContactDao contactDao = new ContactDaoImpl();
	
	@Override
	public void insert(ContactModel contact) {
		// TODO Auto-generated method stub
		contactDao.insert(contact);
	}

}
