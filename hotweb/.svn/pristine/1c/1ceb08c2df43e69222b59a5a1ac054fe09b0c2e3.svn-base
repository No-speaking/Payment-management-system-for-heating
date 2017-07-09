package com.flower.hot.service.zmm;

import java.util.List;

import com.flower.hot.model.zmm.QunuanModel;


public interface IQunuanService {
	//增加
		public void add(QunuanModel qm) throws Exception;
		//修改
		public void modify(QunuanModel qm) throws Exception;
		//删除
		public void delete(QunuanModel qm) throws Exception;
		
		//取得优惠列表
		public List<QunuanModel> getListByAll() throws Exception;
		//取得所有优惠列表，分页
		public List<QunuanModel> getListByAllWithPage(int rows,int page) throws Exception;
		
		//取得指定的部门
		public QunuanModel getQunuan(int quid) throws Exception;
		//取得优惠总个数
		public int getCountByAll() throws Exception;
		//取得优惠总页数
		public int getPageCountByAll(int rows) throws Exception;


}
