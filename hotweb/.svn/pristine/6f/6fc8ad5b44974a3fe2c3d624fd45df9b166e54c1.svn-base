package com.flower.hot.service.impl.yg;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flower.hot.model.yg.BuildModel;
import com.flower.hot.model.yg.HeadportModel;
import com.flower.hot.service.yg.IBuildService;


@Service
@Transactional
public class BuildServiceImpl implements IBuildService {

	
	private SessionFactory sf=null;
	@Autowired
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Override
	public void add(BuildModel bm) throws Exception {
		// TODO Auto-generated method stub
		sf.getCurrentSession().save(bm);

	}

	@Override
	public void delete(BuildModel bm) throws Exception {
		// TODO Auto-generated method stub
		sf.getCurrentSession().delete(bm);
	}

	@Override
	public void modify(BuildModel bm) throws Exception {
		// TODO Auto-generated method stub
		sf.getCurrentSession().update(bm);
	}

	@Override
	public List<BuildModel> getList() throws Exception {
		// TODO Auto-generated method stub
		return sf.getCurrentSession().createQuery("from BuildModel", BuildModel.class).getResultList();
	}

	@Override
	public BuildModel getBuild(int bno) throws Exception {
		// TODO Auto-generated method stub
		return sf.getCurrentSession().get(BuildModel.class, bno);
	}

	@Override
	public int getCountByAll() throws Exception {
		// TODO Auto-generated method stub
		Long lcount=sf.getCurrentSession().createQuery("select count(bm.bno) from BuildModel bm", Long.class).uniqueResult();
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
	public List<BuildModel> getListByAllWithPage(int rows, int page) throws Exception {
		// TODO Auto-generated method stub
		return sf.getCurrentSession().createQuery("from BuildModel", BuildModel.class).setFirstResult(rows*(page-1)).setMaxResults(rows).getResultList();
	}

}
