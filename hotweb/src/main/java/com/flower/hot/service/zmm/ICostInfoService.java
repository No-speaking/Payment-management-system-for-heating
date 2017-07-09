package com.flower.hot.service.zmm;

import java.util.List;

import com.flower.hot.model.zmm.CostInfoModel;


public interface ICostInfoService {
	//增加
	public void add(CostInfoModel cm) throws Exception;
	//修改
	public void modify(CostInfoModel cm) throws Exception;
	//删除
	public void delete(CostInfoModel cm) throws Exception;
	
	//取得优惠列表
	public List<CostInfoModel> getListByAll() throws Exception;
	//取得所有优惠列表，分页
	public List<CostInfoModel> getListByAllWithPage(int rows,int page) throws Exception;
	
	//取得指定的部门
	public CostInfoModel getCostInfo(int costno) throws Exception;
	//取得优惠总个数
	public int getCountByAll() throws Exception;
	//取得优惠总页数
	public int getPageCountByAll(int rows) throws Exception;

}
