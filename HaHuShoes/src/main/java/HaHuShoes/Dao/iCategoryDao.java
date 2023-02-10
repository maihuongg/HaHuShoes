package HaHuShoes.Dao;

import java.util.List;

import HaHuShoes.Model.CategoryModel;

public interface iCategoryDao {
	//lấy tất cả Category
	List<CategoryModel> findAll(); 
	List<CategoryModel>	findTop3();
	CategoryModel get(int id);
	void insert(CategoryModel category);
	int countAll();
	List<CategoryModel> paging(int index);
	void edit(CategoryModel category);
	void delete(int cateId);
	
//	void insert(CategoryModel category);
//	void delete(int cateId);
//	void edit(CategoryModel category);
//	CategoryModel get(int cateId);
//	CategoryModel findCateName(String cateName);
	
}
