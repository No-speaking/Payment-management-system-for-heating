package com.flower.hot.service.impl.zmm;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flower.hot.model.zmm.QunuanModel;
import com.flower.hot.model.zmm.ShoufeiModel;
import com.flower.hot.service.zmm.IQunuanService;
@Service
@Transactional
public class QunuanServiceImpl implements IQunuanService {
	private SessionFactory sf=null;
	@Autowired
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}


	@Override
	public void add(QunuanModel qm) throws Exception {
		// TODO Auto-generated method stub
		sf.getCurrentSession().save(qm);
	}

	@Override
	public void modify(QunuanModel qm) throws Exception {
		// TODO Auto-generated method stub
		sf.getCurrentSession().update(qm);
	}

	@Override
	public void delete(QunuanModel qm) throws Exception {
		// TODO Auto-generated method stub
		sf.getCurrentSession().delete(qm);
	}

	@Override
	public List<QunuanModel> getListByAll() throws Exception {
		// TODO Auto-generated method stub
		return sf.getCurrentSession().createQuery("from QunuanModel", QunuanModel.class).getResultList();
	}

	@Override
	public List<QunuanModel> getListByAllWithPage(int rows, int page) throws Exception {
		// TODO Auto-generated method stub
		return sf.getCurrentSession().createQuery("from QunuanModel", QunuanModel.class).setFirstResult(rows*(page-1)).setMaxResults(rows).getResultList();
	}

	@Override
	public QunuanModel getQunuan(int quid) throws Exception {
		// TODO Auto-generated method stub
		return sf.getCurrentSession().get(QunuanModel.class, quid);
	}

	@Override
	public int getCountByAll() throws Exception {
		// TODO Auto-generated method stub
		Long lcount=sf.getCurrentSession().createQuery("select count(om.quid) from QunuanModel om", Long.class).uniqueResult();
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
