package com.flower.hot.controller.zmm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.flower.hot.model.zmm.TongZhiModel;
import com.flower.hot.result.zmm.ListResultJson;
import com.flower.hot.result.zmm.ResultJson;
import com.flower.hot.service.zmm.ITongZhiService;

@RestController
@RequestMapping("/tongzhi")
public class TongZhiController {
	private ITongZhiService tzs=null;
	@Autowired
	public void setTzs(ITongZhiService tzs) {
		this.tzs = tzs;
	}
	@RequestMapping("/add")
	public ResultJson add(TongZhiModel tzm) throws Exception
	{
		ResultJson result=new ResultJson();
		tzs.add(tzm);
		result.setResult("Y");
		
		return result;
	}
	@RequestMapping("/modify")
	public ResultJson modify(TongZhiModel tzm) throws Exception
	{
		ResultJson result=new ResultJson();
		tzs.modify(tzm);
		result.setResult("Y");
		
		return result;
	}
	@RequestMapping("/delete")
	public ResultJson delete(TongZhiModel tzm) throws Exception
	{
		ResultJson result=new ResultJson();
		tzs.delete(tzm);
		result.setResult("Y");
		
		return result;
	}
	
	@RequestMapping("/get")
	public TongZhiModel got(@RequestParam int tongid) throws Exception
	{
		return tzs.getTongZhi(tongid);
	}
	
	@RequestMapping("/get/all")
	public List<TongZhiModel> getAll() throws Exception
	{
		return tzs.getListByAll();
	}
	
	@RequestMapping("/get/allwithpage")
	public List<TongZhiModel> getAllWithPage(@RequestParam int rows,@RequestParam int page) throws Exception
	{
		return tzs.getListByAllWithPage(rows, page);
	}
	@RequestMapping("/get/all/pages")
	public ListResultJson getListWithPage(@RequestParam(required=false,defaultValue="10") int rows,@RequestParam(required=false,defaultValue="1") int page) throws Exception
	{
		ListResultJson result=new ListResultJson();
		
		int count=tzs.getCountByAll();
		int pageCount=tzs.getPageCountByAll(rows);
		List list=tzs.getListByAllWithPage(rows, page);
		
		result.setPage(page);
		result.setPages(pageCount);
		result.setTotal(count);
		result.setRows(list);
		
		return result;
	}
	
}
