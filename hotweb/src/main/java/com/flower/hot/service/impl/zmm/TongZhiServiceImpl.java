package com.flower.hot.service.impl.zmm;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flower.hot.model.zmm.TongZhiModel;
import com.flower.hot.model.zmm.YouhuiModel;
import com.flower.hot.service.zmm.ITongZhiService;
@Service
@Transactional
public class TongZhiServiceImpl implements ITongZhiService {
	private SessionFactory sf=null;
	@Autowired
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}


	@Override
	public void add(TongZhiModel tzm) throws Exception {
		// TODO Auto-generated method stub
		sf.getCurrentSession().save(tzm);

	}

	@Override
	public void modify(TongZhiModel tzm) throws Exception {
		// TODO Auto-generated method stub
		sf.getCurrentSession().update(tzm);
	}

	@Override
	public void delete(TongZhiModel tzm) throws Exception {
		// TODO Auto-generated method stub
		sf.getCurrentSession().delete(tzm);
	}

	@Override
	public List<TongZhiModel> getListByAll() throws Exception {
		// TODO Auto-generated method stub
		return sf.getCurrentSession().createQuery("from TongZhiModel", TongZhiModel.class).getResultList();
	}

	@Override
	public List<TongZhiModel> getListByAllWithPage(int rows, int page) throws Exception {
		// TODO Auto-generated method stub
		return sf.getCurrentSession().createQuery("from TongZhiModel", TongZhiModel.class).setFirstResult(rows*(page-1)).setMaxResults(rows).getResultList();
	}

	@Override
	public TongZhiModel getTongZhi(int tongid) throws Exception {
		// TODO Auto-generated method stub
		return sf.getCurrentSession().get(TongZhiModel.class, tongid);
	}

	@Override
	public int getCountByAll() throws Exception {
		// TODO Auto-generated method stub
		Long lcount=sf.getCurrentSession().createQuery("select count(tzm.tongid) from TongZhiModel tzm", Long.class).uniqueResult();
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

}
