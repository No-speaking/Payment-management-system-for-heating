package com.flower.hot.service.xq;

import java.util.List;

import com.flower.hot.model.xq.DistrictModel;

public interface IDistrictService {
	
	public void add(DistrictModel dm)throws Exception;
	public void delete(DistrictModel dm)throws Exception;
	public void modify(DistrictModel dm)throws Exception;
	public List<DistrictModel> getList()throws Exception;
	public DistrictModel getDistrict(int dno)throws Exception;
	public int getCountByAll()throws Exception;
	public int getPageCountByAll(int rows)throws Exception;
	public List<DistrictModel> getListByAllWithPage(int rows,int page) throws Exception;

}
