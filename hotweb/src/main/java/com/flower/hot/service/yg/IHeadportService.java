package com.flower.hot.service.yg;

import java.util.List;

import com.flower.hot.model.yg.HeadportModel;

public interface IHeadportService {
	
	  public void add(HeadportModel hm)throws Exception;
	  public void delete(HeadportModel hm)throws Exception;
	  public void modify(HeadportModel hm)throws Exception;
	  public List<HeadportModel>getList()throws Exception;
	  public HeadportModel getHeadport( int portno)throws Exception;
	  public int getCountByAll()throws Exception;
	  public int getPageCountByAll(int rows)throws Exception;
	  public List<HeadportModel> getListByAllWithPage(int rows,int page)throws Exception;
	  
}   
