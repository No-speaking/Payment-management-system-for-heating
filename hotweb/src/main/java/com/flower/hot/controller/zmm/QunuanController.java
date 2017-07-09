package com.flower.hot.controller.zmm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flower.hot.model.zmm.QunuanModel;

import com.flower.hot.result.zmm.ListResultJson;
import com.flower.hot.result.zmm.ResultJson;
import com.flower.hot.service.zmm.IQunuanService;
import com.flower.hot.service.zmm.IShoufeiService;

@RestController
@RequestMapping("/qunuan")
public class QunuanController {
private IQunuanService qs=null;
	public IQunuanService getQs() {
		return qs;
	}
	@Autowired
	public void setQs(IQunuanService qs) {
		this.qs = qs;
	}
	@RequestMapping("/add")
	public ResultJson add(QunuanModel qm) throws Exception
	{
		ResultJson result=new ResultJson();
		qs.add(qm);
		result.setResult("Y");
		
		return result;
	}
	@RequestMapping("/modify")
	public ResultJson modify(QunuanModel qm) throws Exception
	{
		ResultJson result=new ResultJson();
		qs.modify(qm);
		result.setResult("Y");
		
		return result;
	}
	@RequestMapping("/delete")
	public ResultJson delete(QunuanModel qm) throws Exception
	{
		ResultJson result=new ResultJson();
		qs.delete(qm);
		result.setResult("Y");
		
		return result;
	}
	
	@RequestMapping("/get")
	public QunuanModel got(@RequestParam int quid) throws Exception
	{
		return qs.getQunuan(quid);
	}
	
	@RequestMapping("/get/all")
	public List<QunuanModel> getAll() throws Exception
	{
		return qs.getListByAll();
	}
	
	@RequestMapping("/get/allwithpage")
	public List<QunuanModel> getAllWithPage(@RequestParam int rows,@RequestParam int page) throws Exception
	{
		return qs.getListByAllWithPage(rows, page);
	}
	
	@RequestMapping("/get/all/pages")
	public ListResultJson getListWithPage(@RequestParam(required=false,defaultValue="10") int rows,@RequestParam(required=false,defaultValue="1") int page) throws Exception
	{
		ListResultJson result=new ListResultJson();
		
		int count=qs.getCountByAll();
		int pageCount=qs.getPageCountByAll(rows);
		List list=qs.getListByAllWithPage(rows, page);
		
		result.setPage(page);
		result.setPages(pageCount);
		result.setTotal(count);
		result.setRows(list);
		
		return result;
	}

}
