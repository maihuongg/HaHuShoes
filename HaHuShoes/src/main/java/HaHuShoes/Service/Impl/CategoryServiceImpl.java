package HaHuShoes.Service.Impl;

import java.util.List;

import HaHuShoes.Dao.iCategoryDao;
import HaHuShoes.Dao.Impl.CategoryDaoImpl;
import HaHuShoes.Model.CategoryModel;
import HaHuShoes.Service.iCategoryService;

public class CategoryServiceImpl implements iCategoryService {
	iCategoryDao categoryDao = new CategoryDaoImpl();

	@Override
	public List<CategoryModel> findAll() {
		// TODO Auto-generated method stub
		return categoryDao.findAll();
	}

	@Override
	public List<CategoryModel> findTop3() {
		// TODO Auto-generated method stub
		return categoryDao.findTop3();
	}

	@Override
	public CategoryModel get(int id) {
		// TODO Auto-generated method stub
		return categoryDao.get(id);
	}

	@Override
	public void insert(CategoryModel category) {
		categoryDao.insert(category);
	}

	@Override
	public void delete(int categoryId) {
		categoryDao.delete(categoryId);
	}

	@Override
	public void edit(CategoryModel category) {
		categoryDao.edit(category);

	}

	@Override
	public List<CategoryModel> paging(int index) {
		// TODO Auto-generated method stub
		return categoryDao.paging(index);
	}

	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return categoryDao.countAll();
	}
}
