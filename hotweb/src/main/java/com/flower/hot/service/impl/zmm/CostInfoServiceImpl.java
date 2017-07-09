package com.flower.hot.service.impl.zmm;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flower.hot.model.zmm.CostInfoModel;
import com.flower.hot.model.zmm.YouhuiModel;
import com.flower.hot.service.zmm.ICostInfoService;
@Service
@Transactional
public class CostInfoServiceImpl implements ICostInfoService {
	private SessionFactory sf=null;
	@Autowired
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}


	@Override
	public void add(CostInfoModel cm) throws Exception {
		// TODO Auto-generated method stub
		sf.getCurrentSession().save(cm);

	}

	@Override
	public void modify(CostInfoModel cm) throws Exception {
		// TODO Auto-generated method stub
		sf.getCurrentSession().update(cm);

	}

	@Override
	public void delete(CostInfoModel cm) throws Exception {
		// TODO Auto-generated method stub
		sf.getCurrentSession().delete(cm);
	}

	@Override
	public List<CostInfoModel> getListByAll() throws Exception {
		// TODO Auto-generated method stub
		return sf.getCurrentSession().createQuery("from CostInfoModel", CostInfoModel.class).getResultList();
	}

	@Override
	public List<CostInfoModel> getListByAllWithPage(int rows, int page) throws Exception {
		// TODO Auto-generated method stub
		return sf.getCurrentSession().createQuery("from CostInfoModel", CostInfoModel.class).setFirstResult(rows*(page-1)).setMaxResults(rows).getResultList();
	}

	@Override
	public CostInfoModel getCostInfo(int costno) throws Exception {
		// TODO Auto-generated method stub
		return sf.getCurrentSession().get(CostInfoModel.class, costno);
	}

	@Override
	public int getCountByAll() throws Exception {
		// TODO Auto-generated method stub
		Long lcount=sf.getCurrentSession().createQuery("select count(cm.costno) from CostInfoModel cm", Long.class).uniqueResult();
		return lcount.intValue();
	}

	@Override
	public int getPageCountByAll(int rows) throws Exception {
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

}
