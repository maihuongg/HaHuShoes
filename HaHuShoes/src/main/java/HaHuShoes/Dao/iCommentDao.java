package HaHuShoes.Dao;

import java.util.List;

import HaHuShoes.Model.CommentModel;

public interface iCommentDao {

	void insert(CommentModel comment);

	List<CommentModel> findTop3();

	int countAll();

}
