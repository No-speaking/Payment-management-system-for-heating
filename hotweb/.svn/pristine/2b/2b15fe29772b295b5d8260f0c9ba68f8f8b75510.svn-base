package com.flower.hot.controller.xq;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flower.hot.model.xq.DistrictModel;
import com.flower.hot.model.xq.UserModel;
import com.flower.hot.result.zmm.ListResultJson;
import com.flower.hot.result.zmm.ResultJson;
import com.flower.hot.service.xq.IUserService;

@RestController
@RequestMapping("/User")
public class UserController {
	private IUserService us=null;
	@Autowired
	public void setUs(IUserService us) {
		this.us = us;
	}
	@RequestMapping("/add")
	public ResultJson add(UserModel um)throws Exception{
		
		ResultJson result=new ResultJson();
		us.add(um);
		result.setResult("Y");
		return result;
	}
	@RequestMapping("/modify")
	public ResultJson modify(UserModel um)throws Exception{
		
		ResultJson result=new ResultJson();
		us.modify(um);
		result.setResult("Y");
		return result;
	}
	@RequestMapping("/delete")
	public ResultJson delete(UserModel um)throws Exception{
		
		ResultJson result=new ResultJson();
		us.delete(um);
		result.setResult("Y");
		return result;
	}
	@RequestMapping("/get")
	public UserModel getUser(@RequestParam int uno)throws Exception{
		
		return us.getUser(uno);
	}
	@RequestMapping("/getList")
	public List<UserModel> getList()throws Exception{
		
		return us.getList();
	}
	@RequestMapping("/getPage")
	public ListResultJson getListWithPage(@RequestParam(required=false,defaultValue="10") int rows,@RequestParam(required=false,defaultValue="1") int page) throws Exception
	{
		ListResultJson result=new ListResultJson();
		
		int count=us.getCountByAll();
		int pageCount=us.getPageCountByAll(rows);
		List list=us.getListByAllWithPage(rows, page);
		
		result.setPage(page);
		result.setPages(pageCount);
		result.setTotal(count);
		result.setRows(list);
		
		return result;
	}
	
	

}
