package com.flower.hot.service.impl.xq;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flower.hot.model.xq.DistrictModel;
import com.flower.hot.model.xq.RoomModel;
import com.flower.hot.service.xq.IDistrictService;
@Service
@Transactional
public class DistrictServiceImpl implements IDistrictService {

	private SessionFactory sf=null;
	@Autowired
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Override
	public void add(DistrictModel dm) throws Exception {
		// TODO Auto-generated method stub
		sf.getCurrentSession().save(dm);

	}

	@Override
	public void delete(DistrictModel dm) throws Exception {
		// TODO Auto-generated method stub
		sf.getCurrentSession().delete(dm);

	}

	@Override
	public void modify(DistrictModel dm) throws Exception {
		// TODO Auto-generated method stub
		sf.getCurrentSession().update(dm);

	}

	@Override
	public List<DistrictModel> getList() throws Exception {
		// TODO Auto-generated method stub
		return sf.getCurrentSession().createQuery("from DistrictModel", DistrictModel.class).getResultList();
	}

	@Override
	public DistrictModel getDistrict(int dno) throws Exception {
		// TODO Auto-generated method stub
		return sf.getCurrentSession().get(DistrictModel.class, dno);
	}

	@Override
	public int getCountByAll() throws Exception {
		// TODO Auto-generated method stub
		Long lcount=sf.getCurrentSession().createQuery("select count(dm.dno) from DistrictModel dm", Long.class).uniqueResult();
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
	public List<DistrictModel> getListByAllWithPage(int rows, int page) throws Exception {
		// TODO Auto-generated method stub
		return sf.getCurrentSession().createQuery("from DistrictModel", DistrictModel.class).setFirstResult(rows*(page-1)).setMaxResults(rows).getResultList();
	}

}
