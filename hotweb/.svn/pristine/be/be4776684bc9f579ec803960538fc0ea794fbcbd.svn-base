package com.flower.hot.service.zmm;

import java.util.List;
import com.flower.hot.model.zmm.QunuanModel;
import com.flower.hot.model.zmm.ShoufeiModel;


public interface IShoufeiService {
	//增加
			public void add(ShoufeiModel sm) throws Exception;
			//修改
			public void modify(ShoufeiModel sm) throws Exception;
			//删除
			public void delete(ShoufeiModel sm) throws Exception;
			
			//取得优惠列表
			public List<ShoufeiModel> getListByAll() throws Exception;
			//取得所有优惠列表，分页
			public List<ShoufeiModel> getListByAllWithPage(int rows,int page) throws Exception;
			
			//取得指定的部门
			public ShoufeiModel getShoufei(String shouid) throws Exception;
			//取得优惠总个数
			public int getCountByAll() throws Exception;
			//取得优惠总页数
			public int getPageCountByAll(int rows) throws Exception;
			public List<QunuanModel> getQunuan(String shouid) throws Exception;

}
