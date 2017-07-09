package com.flower.hot.controller.zmm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.flower.hot.model.zmm.CostInfoModel;
import com.flower.hot.model.zmm.YouhuiModel;
import com.flower.hot.result.zmm.ListResultJson;
import com.flower.hot.result.zmm.ResultJson;
import com.flower.hot.service.zmm.ICostInfoService;
import com.flower.hot.service.zmm.IYouhuiService;

@RestController
@RequestMapping("/costinfo")
public class CostInfoController {
	private ICostInfoService cs=null;

	public ICostInfoService getCs() {
		return cs;
	}
	@Autowired
	public void setCs(ICostInfoService cs) {
		this.cs = cs;
	}
	@RequestMapping("/add")
	public ResultJson add(CostInfoModel cm) throws Exception
	{
		ResultJson result=new ResultJson();
		cs.add(cm);
		result.setResult("Y");
		
		return result;
	}
	@RequestMapping("/modify")
	public ResultJson modify(CostInfoModel cm) throws Exception
	{
		ResultJson result=new ResultJson();
		cs.modify(cm);
		result.setResult("Y");
		
		return result;
	}
	@RequestMapping("/delete")
	public ResultJson delete(CostInfoModel cm) throws Exception
	{
		ResultJson result=new ResultJson();
		cs.delete(cm);
		result.setResult("Y");
		
		return result;
	}
	
	@RequestMapping("/get")
	public CostInfoModel got(@RequestParam int costno) throws Exception
	{
		return cs.getCostInfo(costno);
	}
	
	@RequestMapping("/get/all")
	public List<CostInfoModel> getAll() throws Exception
	{
		return cs.getListByAll();
	}
	
	@RequestMapping("/get/allwithpage")
	public List<CostInfoModel> getAllWithPage(@RequestParam int rows,@RequestParam int page) throws Exception
	{
		return cs.getListByAllWithPage(rows, page);
	}
	
	@RequestMapping("/get/all/pages")
	public ListResultJson getListWithPage(@RequestParam(required=false,defaultValue="10") int rows,@RequestParam(required=false,defaultValue="1") int page) throws Exception
	{
		ListResultJson result=new ListResultJson();
		
		int count=cs.getCountByAll();
		int pageCount=cs.getPageCountByAll(rows);
		List list=cs.getListByAllWithPage(rows, page);
		
		result.setPage(page);
		result.setPages(pageCount);
		result.setTotal(count);
		result.setRows(list);
		
		return result;
	}
	
	
	
}
