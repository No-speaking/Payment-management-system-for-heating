package com.flower.hot.service.impl.dx;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flower.hot.model.dx.IdentityModel;
import com.flower.hot.model.dx.WxxxModel;
import com.flower.hot.service.dx.IWxxxService;
@Service
@Transactional
public class WxxxServiceImpl implements IWxxxService {
	private SessionFactory sf=null;
	@Autowired
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public void add(WxxxModel wm) throws Exception {
		// TODO Auto-generated method stub
		sf.getCurrentSession().save(wm);

	}

	@Override
	public void delete(WxxxModel wm) throws Exception {
		// TODO Auto-generated method stub
		sf.getCurrentSession().delete(wm);

	}

	@Override
	public void modify(WxxxModel wm) throws Exception {
		// TODO Auto-generated method stub
		sf.getCurrentSession().update(wm);

	}

	@Override
	public List<WxxxModel> getList() throws Exception {
		// TODO Auto-generated method stub
		return sf.getCurrentSession().createQuery("from WxxxModel", WxxxModel.class).getResultList();
	}

	@Override
	public WxxxModel getWxxx(int wno) throws Exception {
		// TODO Auto-generated method stub
		return sf.getCurrentSession().get(WxxxModel.class, wno);
	}

	@Override
	public int getCountByAll() throws Exception {
		// TODO Auto-generated method stub
		Long lcount=sf.getCurrentSession().createQuery("select count(wm.wno) from WxxxModel wm", Long.class).uniqueResult();
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
	public List<WxxxModel> getListByAllWithPage(int rows, int page) throws Exception {
		// TODO Auto-generated method stub
		return sf.getCurrentSession().createQuery("from WxxxModel", WxxxModel.class).setFirstResult(rows*(page-1)).setMaxResults(rows).getResultList();
	}

}
