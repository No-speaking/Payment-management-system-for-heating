package com.flower.hot.controller.yg;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flower.hot.model.yg.BuildModel;
import com.flower.hot.model.yg.HeadportModel;
import com.flower.hot.model.zmm.YouhuiModel;
import com.flower.hot.result.zmm.ListResultJson;
import com.flower.hot.result.zmm.ResultJson;
import com.flower.hot.service.yg.IBuildService;
import com.flower.hot.service.yg.IHeadportService;
@RestController
@RequestMapping("/Build")
public class BuildController {

	
  private IBuildService bs=null;
  
  @Autowired
  public void setRs(IBuildService bs){
	  this.bs=bs;
  }
  
  @RequestMapping("/add")
  public ResultJson add(BuildModel bm)throws Exception{
	  
	   ResultJson result = new ResultJson();
	   bs.add(bm);
	   result.setResult("Y");
	   return result;
  }
  
  @RequestMapping("/modify")
	public ResultJson modify(BuildModel bm) throws Exception
	{
		ResultJson result=new ResultJson();
		bs.modify(bm);
		result.setResult("Y");
		
		return result;
	}
	@RequestMapping("/delete")
	public ResultJson delete(BuildModel bm) throws Exception
	{
		ResultJson result=new ResultJson();
		bs.delete(bm);
		result.setResult("Y");
		
		return result;
	}
	
	@RequestMapping("/get")
	public BuildModel got(@RequestParam int bno) throws Exception
	{
		return bs.getBuild(bno);
	}
	
	@RequestMapping("/get/all")
	public List<BuildModel> getAll() throws Exception
	{
		return bs.getList();
	}
	
	@RequestMapping("/get/allwithpage")
	public ListResultJson getListWithPage(@RequestParam(required=false,defaultValue="10") int rows,@RequestParam(required=false,defaultValue="1") int page) throws Exception
	{
		ListResultJson result=new ListResultJson();
		
		int count=bs.getCountByAll();
		int pageCount=bs.getPageCountByAll(rows);
		List list=bs.getListByAllWithPage(rows, page);
		
		result.setPage(page);
		result.setPages(pageCount);
		result.setTotal(count);
		result.setRows(list);
		
		return result;
	}
	
}

