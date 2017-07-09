package com.flower.hot.service.zmm;

import java.util.List;

import com.flower.hot.model.zmm.TongZhiModel;


public interface ITongZhiService {
	//增加
			public void add(TongZhiModel tzm) throws Exception;
			//修改
			public void modify(TongZhiModel tzm) throws Exception;
			//删除
			public void delete(TongZhiModel tzm) throws Exception;
			
			//取得优惠列表
			public List<TongZhiModel> getListByAll() throws Exception;
			//取得所有优惠列表，分页
			public List<TongZhiModel> getListByAllWithPage(int rows,int page) throws Exception;
			
			//取得指定的部门
			public TongZhiModel getTongZhi(int tongid) throws Exception;
			//取得优惠总个数
			public int getCountByAll() throws Exception;
			//取得优惠总页数
			public int getPageCountByAll(int rows) throws Exception;


}
