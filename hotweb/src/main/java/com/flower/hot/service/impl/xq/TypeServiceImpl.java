package com.flower.hot.service.impl.xq;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.flower.hot.model.xq.RoomModel;
import com.flower.hot.model.xq.TypeModel;
import com.flower.hot.service.xq.ITypeService;
@Service
@Transactional
public class TypeServiceImpl implements ITypeService {

	
	private SessionFactory sf=null;
	@Autowired
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	@Override
	public void add(TypeModel tm) throws Exception {
		// TODO Auto-generated method stub
		sf.getCurrentSession().save(tm);

	}

	@Override
	public void delete(TypeModel tm) throws Exception {
		// TODO Auto-generated method stub
		sf.getCurrentSession().delete(tm);

	}

	@Override
	public void modify(TypeModel tm) throws Exception {
		// TODO Auto-generated method stub
		sf.getCurrentSession().update(tm);

	}

	@Override
	public List<TypeModel> getList() throws Exception {
		// TODO Auto-generated method stub
		return sf.getCurrentSession().createQuery("from TypeModel", TypeModel.class).getResultList();
	}

	@Override
	public TypeModel getType(int tno) throws Exception {
		// TODO Auto-generated method stub
		return sf.getCurrentSession().get(TypeModel.class, tno);
	}

	@Override
	public int getCountByAll() throws Exception {
		// TODO Auto-generated method stub
		Long lcount=sf.getCurrentSession().createQuery("select count(tm.tno) from TypeModel tm", Long.class).uniqueResult();
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
	public List<TypeModel> getListByAllWithPage(int rows, int page) throws Exception {
		// TODO Auto-generated method stub
		return sf.getCurrentSession().createQuery("from TypeModel", TypeModel.class).setFirstResult(rows*(page-1)).setMaxResults(rows).getResultList();
	}

}
