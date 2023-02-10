package HaHuShoes.Service;

import java.util.List;

import HaHuShoes.Model.CategoryModel;



public interface iCategoryService {
	List<CategoryModel> findAll();
	List<CategoryModel> findTop3();
	CategoryModel get(int id);
	void insert(CategoryModel category);
	int countAll();
	List<CategoryModel> paging(int index);
	void edit(CategoryModel category);
	void delete(int categoryId);
}
