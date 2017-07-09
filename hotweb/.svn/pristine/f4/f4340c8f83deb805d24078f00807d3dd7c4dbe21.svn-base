package com.flower.hot.service.impl.zmm;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flower.hot.model.zmm.CostInfoModel;
import com.flower.hot.model.zmm.QunuanModel;
import com.flower.hot.model.zmm.ShoufeiModel;
import com.flower.hot.service.zmm.IShoufeiService;
@Service
@Transactional
public class ShoufeiServiceImpl implements IShoufeiService {
	private SessionFactory sf=null;
	@Autowired
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public void add(ShoufeiModel sm) throws Exception {
		// TODO Auto-generated method stub
		sf.getCurrentSession().save(sm);

	}

	@Override
	public void modify(ShoufeiModel sm) throws Exception {
		// TODO Auto-generated method stub
		sf.getCurrentSession().update(sm);

	}

	@Override
	public void delete(ShoufeiModel sm) throws Exception {
		// TODO Auto-generated method stub
		sf.getCurrentSession().delete(sm);

	}

	@Override
	public List<ShoufeiModel> getListByAll() throws Exception {
		// TODO Auto-generated method stub
		return sf.getCurrentSession().createQuery("from ShoufeiModel", ShoufeiModel.class).getResultList();
	}

	@Override
	public List<ShoufeiModel> getListByAllWithPage(int rows, int page) throws Exception {
		// TODO Auto-generated method stub
		return sf.getCurrentSession().createQuery("from ShoufeiModel", ShoufeiModel.class).setFirstResult(rows*(page-1)).setMaxResults(rows).getResultList();
	}

	@Override
	public ShoufeiModel getShoufei(String shouid) throws Exception {
		// TODO Auto-generated method stub
		return sf.getCurrentSession().get(ShoufeiModel.class, shouid);
	}

	@Override
	public int getCountByAll() throws Exception {
		// TODO Auto-generated method stub
		Long lcount=sf.getCurrentSession().createQuery("select count(sm.shouid) from ShoufeiModel sm", Long.class).uniqueResult();
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
	public List<QunuanModel> getQunuan(String shouid) throws Exception {
		// TODO Auto-generated method stub
		Query<QunuanModel> query=sf.getCurrentSession().createQuery("select qm from ShoufeiModel sm inner join sm.qunuans qm where sm.shouid=:shouid",QunuanModel.class);
		query.setParameter("shouid", shouid);
		return query.getResultList();
	}
	

}
