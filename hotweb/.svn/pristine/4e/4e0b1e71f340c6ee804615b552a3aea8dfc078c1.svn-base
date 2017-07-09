package com.flower.hot.service.impl.dx;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flower.hot.model.dx.IdentityModel;
import com.flower.hot.service.dx.IIdentityService;
@Service
@Transactional
public class IdentityServiceImpl implements IIdentityService {
	private SessionFactory sf=null;
	@Autowired
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public void add(IdentityModel im) throws Exception {
		// TODO Auto-generated method stub
		sf.getCurrentSession().save(im);

	}

	@Override
	public void delete(IdentityModel im) throws Exception {
		// TODO Auto-generated method stub
		sf.getCurrentSession().delete(im);

	}

	@Override
	public void modify(IdentityModel im) throws Exception {
		// TODO Auto-generated method stub
		sf.getCurrentSession().update(im);

	}

	@Override
	public List<IdentityModel> getList() throws Exception {
		// TODO Auto-generated method stub
		return sf.getCurrentSession().createQuery("from IdentityModel", IdentityModel.class).getResultList();
	}

	@Override
	public IdentityModel getIdentity(String idname) throws Exception {
		// TODO Auto-generated method stub
		return sf.getCurrentSession().get(IdentityModel.class, idname);
	}

	@Override
	public int getCountByAll() throws Exception {
		// TODO Auto-generated method stub
		Long lcount=sf.getCurrentSession().createQuery("select count(im.idname) from IdentityModel im", Long.class).uniqueResult();
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
	public List<IdentityModel> getListByAllWithPage(int rows, int page) throws Exception {
		// TODO Auto-generated method stub
		return sf.getCurrentSession().createQuery("from IdentityModel", IdentityModel.class).setFirstResult(rows*(page-1)).setMaxResults(rows).getResultList();
	}

}
