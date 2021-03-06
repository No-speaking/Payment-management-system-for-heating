package com.flower.hot.service.impl.xq;

import java.util.List;



import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.flower.hot.model.xq.RoomModel;
import com.flower.hot.model.zmm.YouhuiModel;
import com.flower.hot.service.xq.IRoomService;
@Service
@Transactional
public class RoomServiceImpl implements IRoomService {

	private SessionFactory sf=null;
	@Autowired
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Override
	public void add(RoomModel rm) throws Exception {
		// TODO Auto-generated method stub
		sf.getCurrentSession().save(rm);

	}

	@Override
	public void delete(RoomModel rm) throws Exception {
		// TODO Auto-generated method stub
		sf.getCurrentSession().delete(rm);

	}

	@Override
	public void modify(RoomModel rm) throws Exception {
		// TODO Auto-generated method stub
		sf.getCurrentSession().update(rm);

	}

	@Override
	public List<RoomModel> getList() throws Exception {
		// TODO Auto-generated method stub
		return sf.getCurrentSession().createQuery("from RoomModel", RoomModel.class).getResultList();
	}

	@Override
	public RoomModel getRoom(int roomno) throws Exception {
		// TODO Auto-generated method stub
		return sf.getCurrentSession().get(RoomModel.class, roomno);
	}

	@Override
	public int getCountByAll() throws Exception {
		// TODO Auto-generated method stub
		Long lcount=sf.getCurrentSession().createQuery("select count(rm.roomno) from RoomModel rm", Long.class).uniqueResult();
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
	public List<RoomModel> getListByAllWithPage(int rows, int page) throws Exception {
		// TODO Auto-generated method stub
		return sf.getCurrentSession().createQuery("from RoomModel", RoomModel.class).setFirstResult(rows*(page-1)).setMaxResults(rows).getResultList();
	}

}
