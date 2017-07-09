package com.flower.hot.service.impl.xq;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flower.hot.model.xq.UserModel;
import com.flower.hot.service.xq.IUserService;
@Service
@Transactional
public class UserServiceImpl implements IUserService {

	private SessionFactory sf=null;
	@Autowired
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Override
	public void add(UserModel um) throws Exception {
		// TODO Auto-generated method stub
		sf.getCurrentSession().save(um);

	}

	@Override
	public void delete(UserModel um) throws Exception {
		// TODO Auto-generated method stub
		sf.getCurrentSession().delete(um);

	}

	@Override
	public void modify(UserModel um) throws Exception {
		// TODO Auto-generated method stub
		sf.getCurrentSession().update(um);

	}

	@Override
	public List<UserModel> getList() throws Exception {
		// TODO Auto-generated method stub
		return sf.getCurrentSession().createQuery("from UserModel", UserModel.class).getResultList();
	}

	@Override
	public UserModel getUser(int uno) throws Exception {
		// TODO Auto-generated method stub
		return sf.getCurrentSession().get(UserModel.class, uno);
	}

	@Override
	public int getCountByAll() throws Exception {
		// TODO Auto-generated method stub
		Long lcount=sf.getCurrentSession().createQuery("select count(um.uno) from UserModel um", Long.class).uniqueResult();
		return lcount.intValue();
	}

	@Override
	public int getPageCountByAll(int rows) throws Exception {
		// TODO Auto-generated method stub
		int count=this.getCountByAll();
		int pageCount=0;
		if(count%rows==0){
			pageCount=count/rows;
		}
		else{
			pageCount=count/rows+1;
		}
		return pageCount;
	}

	@Override
	public List<UserModel> getListByAllWithPage(int rows, int page) throws Exception {
		// TODO Auto-generated method stub
		return sf.getCurrentSession().createQuery("from UserModel", UserModel.class).setFirstResult(rows*(page-1)).setMaxResults(rows).getResultList();
	}

}
