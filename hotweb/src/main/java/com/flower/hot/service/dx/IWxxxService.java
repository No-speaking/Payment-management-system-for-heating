package com.flower.hot.service.dx;

import java.util.List;


import com.flower.hot.model.dx.WxxxModel;

public interface IWxxxService {
public void add(WxxxModel wm)throws Exception;
	
	public void delete(WxxxModel wm)throws Exception;
	
	public void modify(WxxxModel wm)throws Exception;
	
	public List<WxxxModel>getList()throws Exception;
	
	public WxxxModel getWxxx(int wno)throws Exception;
	
	public int getCountByAll()throws Exception;
	
	public int getPageCountByAll(int rows)throws Exception;
	
	public List<WxxxModel> getListByAllWithPage(int rows,int page)throws Exception;
}



