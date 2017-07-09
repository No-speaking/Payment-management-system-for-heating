package com.flower.hot.controller.yg;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flower.hot.model.yg.HeadportModel;
import com.flower.hot.model.zmm.YouhuiModel;
import com.flower.hot.result.zmm.ResultJson;
import com.flower.hot.service.yg.IHeadportService;
@RestController
@RequestMapping("/Headport")
public class HeadportController {

	
  private IHeadportService hs=null;
  
  @Autowired
  public void setRs(IHeadportService hs){
	  this.hs=hs;
  }
  
  @RequestMapping("/add")
  public ResultJson add(HeadportModel hm)throws Exception{
	  
	   ResultJson result = new ResultJson();
	   hs.add(hm);
	   result.setResult("Y");
	   return result;
  }
  
  @RequestMapping("/modify")
	public ResultJson modify(HeadportModel hm) throws Exception
	{
		ResultJson result=new ResultJson();
		hs.modify(hm);
		result.setResult("Y");
		
		return result;
	}
	@RequestMapping("/delete")
	public ResultJson delete(HeadportModel hm) throws Exception
	{
		ResultJson result=new ResultJson();
		hs.delete(hm);
		result.setResult("Y");
		
		return result;
	}
	
	@RequestMapping("/get")
	public HeadportModel got(@RequestParam int portno) throws Exception
	{
		return hs.getHeadport(portno);
	}
	
	@RequestMapping("/get/all")
	public List<HeadportModel> getAll() throws Exception
	{
		return hs.getList();
	}
	
	@RequestMapping("/get/allwithpage")
	public List<HeadportModel> getAllWithPage(@RequestParam int rows,@RequestParam int page) throws Exception
	{
		return hs.getListByAllWithPage(rows, page);
	}
	
}

