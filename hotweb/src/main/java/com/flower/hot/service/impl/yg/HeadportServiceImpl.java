package com.flower.hot.service.impl.yg;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.flower.hot.model.yg.HeadportModel;
import com.flower.hot.model.zmm.YouhuiModel;
import com.flower.hot.service.yg.IHeadportService;


	@Service
	@Transactional
	public class HeadportServiceImpl implements IHeadportService {

		private SessionFactory sf=null;
		@Autowired
		public void setSf(SessionFactory sf) {
			this.sf = sf;
		}
		
		@Override
		public void add(HeadportModel hm) throws Exception {
			// TODO Auto-generated method stub
			sf.getCurrentSession().save(hm);

		}

		@Override
		public void delete(HeadportModel hm) throws Exception {
			// TODO Auto-generated method stub
			sf.getCurrentSession().delete(hm);

		}

		@Override
		public void modify(HeadportModel hm) throws Exception {
			// TODO Auto-generated method stub
			sf.getCurrentSession().update(hm);

		}

		@Override
		public List<HeadportModel> getList() throws Exception {
			// TODO Auto-generated method stub
			return sf.getCurrentSession().createQuery("from HeadportModel", HeadportModel.class).getResultList();
		}

		@Override
		public HeadportModel getHeadport(int portno) throws Exception {
			// TODO Auto-generated method stub
			return sf.getCurrentSession().get(HeadportModel.class, portno);
		}

		@Override
		public int getCountByAll() throws Exception {
			// TODO Auto-generated method stub
			Long lcount=sf.getCurrentSession().createQuery("select count(hm.portno) from HeadportModel hm", Long.class).uniqueResult();
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
		public List<HeadportModel> getListByAllWithPage(int rows, int page) throws Exception {
			// TODO Auto-generated method stub
			return sf.getCurrentSession().createQuery("from HeadportModel", HeadportModel.class).setFirstResult(rows*(page-1)).setMaxResults(rows).getResultList();
		}

	}


