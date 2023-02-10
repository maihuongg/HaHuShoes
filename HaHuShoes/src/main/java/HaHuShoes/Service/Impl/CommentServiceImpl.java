package HaHuShoes.Service.Impl;

import java.util.List;

import HaHuShoes.Dao.iCommentDao;
import HaHuShoes.Dao.Impl.CommentDaoImpl;
import HaHuShoes.Model.CommentModel;
import HaHuShoes.Service.iCommentService;

public class CommentServiceImpl implements iCommentService{
	iCommentDao commentDao = new CommentDaoImpl();
	
	@Override
	public void insert(CommentModel comment) {
		// TODO Auto-generated method stub
		commentDao.insert(comment);
	}

	@Override
	public List<CommentModel> findTop3() {
		// TODO Auto-generated method stub
		return commentDao.findTop3();
	}

	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return commentDao.countAll();
	}

}
