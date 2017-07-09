package com.flower.hot.controller.dx;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flower.hot.model.dx.IdentityModel;
import com.flower.hot.result.zmm.ResultJson;
import com.flower.hot.service.dx.IIdentityService;

@RestController
@RequestMapping("/Identity")
public class IdentityController {
private IIdentityService iis=null;
	
	@Autowired
	public void setIis(IIdentityService iis) {
		this.iis = iis;
	}


	@RequestMapping("/add")
	public ResultJson add(IdentityModel im)throws Exception{
		
		ResultJson result=new ResultJson();
		iis.add(im);
		result.setResult("Y");
		return result;
	}
	
	@RequestMapping("/modify")
	public ResultJson modify(IdentityModel im) throws Exception
	{
		ResultJson result=new ResultJson();
		iis.modify(im);
		result.setResult("Y");
		
		return result;
	}
	
	@RequestMapping("/delete")
	public ResultJson delete(IdentityModel im) throws Exception
	{
		ResultJson result=new ResultJson();
		iis.delete(im);
		result.setResult("Y");
		
		return result;
	}
	
	@RequestMapping("/get")
	public IdentityModel got(@RequestParam String idname) throws Exception
	{
		return iis.getIdentity(idname);
	}
	
	@RequestMapping("/get/all")
	public List<IdentityModel> getAll() throws Exception
	{
		return iis.getList();
	}
	
	@RequestMapping("/get/allwithpage")
	public List<IdentityModel> getAllWithPage(@RequestParam int rows,@RequestParam int page) throws Exception
	{
		return iis.getListByAllWithPage(rows, page);
	}
	



}
