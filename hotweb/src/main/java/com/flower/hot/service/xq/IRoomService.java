package com.flower.hot.service.xq;

import java.util.List;

import com.flower.hot.model.xq.RoomModel;

public interface IRoomService {
	
	public void add(RoomModel rm)throws Exception;
	public void delete(RoomModel rm)throws Exception;
	public void modify(RoomModel rm)throws Exception;
	public List<RoomModel> getList()throws Exception;
	public RoomModel getRoom(int roomno)throws Exception;
	public int getCountByAll()throws Exception;
	public int getPageCountByAll(int rows)throws Exception;
	public List<RoomModel> getListByAllWithPage(int rows,int page) throws Exception;
	

}
