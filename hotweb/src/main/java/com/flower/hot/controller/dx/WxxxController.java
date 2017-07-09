package com.flower.hot.controller.dx;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flower.hot.model.dx.IdentityModel;
import com.flower.hot.model.dx.WxxxModel;
import com.flower.hot.result.zmm.ListResultJson;
import com.flower.hot.result.zmm.ResultJson;
import com.flower.hot.service.dx.IIdentityService;
import com.flower.hot.service.dx.IWxxxService;

@RestController
@RequestMapping("/Wxxx")
public class WxxxController {
private IWxxxService ws=null;

@Autowired
public void setIis(IWxxxService ws) {
	this.ws = ws;
}


@RequestMapping("/add")
public ResultJson add(WxxxModel wm)throws Exception{
	
	ResultJson result=new ResultJson();
	ws.add(wm);
	result.setResult("Y");
	return result;
}

@RequestMapping("/modify")
public ResultJson modify(WxxxModel wm) throws Exception
{
	ResultJson result=new ResultJson();
	ws.modify(wm);
	result.setResult("Y");
	
	return result;
}

@RequestMapping("/delete")
public ResultJson delete(WxxxModel wm) throws Exception
{
	ResultJson result=new ResultJson();
	ws.delete(wm);
	result.setResult("Y");
	
	return result;
}

@RequestMapping("/get")
public WxxxModel got(@RequestParam int wno) throws Exception
{
	return ws.getWxxx(wno);
}

@RequestMapping("/get/all")
public List<WxxxModel> getAll() throws Exception
{
	return ws.getList();
}

@RequestMapping("/get/allwithpage")
public List<WxxxModel> getAllWithPage(@RequestParam int rows,@RequestParam int page) throws Exception
{
	return ws.getListByAllWithPage(rows, page);
}

@RequestMapping("/getPage")
public ListResultJson getListWithPage(@RequestParam(required=false,defaultValue="10") int rows,@RequestParam(required=false,defaultValue="1") int page) throws Exception
{
	ListResultJson result=new ListResultJson();
	
	int count=ws.getCountByAll();
	int pageCount=ws.getPageCountByAll(rows);
	List list=ws.getListByAllWithPage(rows, page);
	
	result.setPage(page);
	result.setPages(pageCount);
	result.setTotal(count);
	result.setRows(list);
	
	return result;
}
}
