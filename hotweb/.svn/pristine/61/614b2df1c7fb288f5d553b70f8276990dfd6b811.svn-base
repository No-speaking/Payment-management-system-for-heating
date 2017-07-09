package com.flower.hot.service.impl.dx;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flower.hot.model.dx.EmployeeModel;
import com.flower.hot.service.dx.IEmployeeService;
@Service
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {
	private SessionFactory sf=null;
	@Autowired
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public void add(EmployeeModel em) throws Exception {
		// TODO Auto-generated method stub
		sf.getCurrentSession().save(em);

	}

	@Override
	public void delete(EmployeeModel em) throws Exception {
		// TODO Auto-generated method stub
		sf.getCurrentSession().delete(em);

	}

	@Override
	public void modify(EmployeeModel em) throws Exception {
		// TODO Auto-generated method stub
		sf.getCurrentSession().update(em);

	}

	@Override
	public List<EmployeeModel> getList() throws Exception {
		// TODO Auto-generated method stub
		return sf.getCurrentSession().createQuery("from EmployeeModel", EmployeeModel.class).getResultList();
	}

	@Override
	public EmployeeModel getEmployee(int eno) throws Exception {
		// TODO Auto-generated method stub
		return sf.getCurrentSession().get(EmployeeModel.class, eno);
	}

	@Override
	public int getCountByAll() throws Exception {
		// TODO Auto-generated method stub
		Long lcount=sf.getCurrentSession().createQuery("select count(em.eno) from EmployeeModel em", Long.class).uniqueResult();
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
	public List<EmployeeModel> getListByAllWithPage(int rows, int page) throws Exception {
		// TODO Auto-generated method stub
		return sf.getCurrentSession().createQuery("from EmployeeModel", EmployeeModel.class).setFirstResult(rows*(page-1)).setMaxResults(rows).getResultList();
	}

}
