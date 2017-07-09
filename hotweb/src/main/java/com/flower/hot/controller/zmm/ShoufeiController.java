package com.flower.hot.controller.zmm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.flower.hot.model.zmm.QunuanModel;
import com.flower.hot.model.zmm.ShoufeiModel;
import com.flower.hot.result.zmm.ListResultJson;
import com.flower.hot.result.zmm.ResultJson;

import com.flower.hot.service.zmm.IShoufeiService;

@RestController
@RequestMapping("/shoufei")
public class ShoufeiController {
	private IShoufeiService ss=null;

	
	public IShoufeiService getSs() {
		return ss;
	}
	@Autowired
	public void setSs(IShoufeiService ss) {
		this.ss = ss;
	}
	@RequestMapping("/add")
	public ResultJson add(ShoufeiModel sm) throws Exception
	{
		ResultJson result=new ResultJson();
		ss.add(sm);
		result.setResult("Y");
		
		return result;
	}
	@RequestMapping("/modify")
	public ResultJson modify(ShoufeiModel sm) throws Exception
	{
		ResultJson result=new ResultJson();
		ss.modify(sm);
		result.setResult("Y");
		
		return result;
	}
	@RequestMapping("/delete")
	public ResultJson delete(ShoufeiModel sm) throws Exception
	{
		ResultJson result=new ResultJson();
		ss.delete(sm);
		result.setResult("Y");
		
		return result;
	}
	
	@RequestMapping("/get")
	public ShoufeiModel got(@RequestParam String shouid) throws Exception
	{
		return ss.getShoufei(shouid);
	}
	
	@RequestMapping("/get/all")
	public List<ShoufeiModel> getAll() throws Exception
	{
		return ss.getListByAll();
	}
	
	@RequestMapping("/get/allwithpage")
	public List<ShoufeiModel> getAllWithPage(@RequestParam int rows,@RequestParam int page) throws Exception
	{
		return ss.getListByAllWithPage(rows, page);
	}
	
	@RequestMapping("/get/all/pages")
	public ListResultJson getListWithPage(@RequestParam(required=false,defaultValue="10") int rows,@RequestParam(required=false,defaultValue="1") int page) throws Exception
	{
		ListResultJson result=new ListResultJson();
		
		int count=ss.getCountByAll();
		int pageCount=ss.getPageCountByAll(rows);
		List list=ss.getListByAllWithPage(rows, page);
		
		result.setPage(page);
		result.setPages(pageCount);
		result.setTotal(count);
		result.setRows(list);
		
		return result;
	}
	
	//取得指定的优惠的缴费列表
			@RequestMapping(value="/get/qunuans")
			public List<QunuanModel> getBehaves(@RequestParam String shouid) throws Exception
			{
				return ss.getQunuan(shouid);
				
			}


}
