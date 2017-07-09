package com.flower.hot.service.zmm;

import java.util.List;
import com.flower.hot.model.zmm.CostInfoModel;
import com.flower.hot.model.zmm.YouhuiModel;



public interface IYouhuiService {
	//增加
		public void add(YouhuiModel ym) throws Exception;
		//修改
		public void modify(YouhuiModel ym) throws Exception;
		//删除
		public void delete(YouhuiModel ym) throws Exception;
		
		//取得优惠列表
		public List<YouhuiModel> getListByAll() throws Exception;
		//取得所有优惠列表，分页
		public List<YouhuiModel> getListByAllWithPage(int rows,int page) throws Exception;
		
		//取得指定的部门
		public YouhuiModel getYouhui(String youid) throws Exception;
		//取得优惠总个数
		public int getCountByAll() throws Exception;
		//取得优惠总页数
		public int getPageCountByAll(int rows) throws Exception;
		public List<CostInfoModel> getCostInfo(String youid) throws Exception;

}
