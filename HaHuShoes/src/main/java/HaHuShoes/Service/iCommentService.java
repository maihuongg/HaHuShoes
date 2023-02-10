package HaHuShoes.Service;

import java.util.List;

import HaHuShoes.Model.CommentModel;

public interface iCommentService {
	
	void insert(CommentModel comment);
	
	List<CommentModel> findTop3();
	
	int countAll();
}
