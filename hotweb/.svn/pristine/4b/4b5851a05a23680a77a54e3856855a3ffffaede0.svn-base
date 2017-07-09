package com.flower.hot.controller.xq;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.flower.hot.model.xq.DistrictModel;
import com.flower.hot.result.zmm.ListResultJson;
import com.flower.hot.result.zmm.ResultJson;
import com.flower.hot.service.xq.IDistrictService;
@RestController
@RequestMapping("/District")
public class DistrictController {
	
private IDistrictService ds=null;
	
	@Autowired
	public void setDs(IDistrictService ds) {
		this.ds = ds;
	}

	@RequestMapping("/add")
	public ResultJson add(DistrictModel dm)throws Exception{
		
		ResultJson result=new ResultJson();
		ds.add(dm);
		result.setResult("Y");
		return result;
	}
	@RequestMapping("/modify")
	public ResultJson modify(DistrictModel dm)throws Exception{
		
		ResultJson result=new ResultJson();
		ds.modify(dm);
		result.setResult("Y");
		return result;
	}
	@RequestMapping("/delete")
	public ResultJson delete(DistrictModel dm)throws Exception{
		
		ResultJson result=new ResultJson();
		ds.delete(dm);
		result.setResult("Y");
		return result;
	}
	@RequestMapping("/get")
	public DistrictModel getDistrict(@RequestParam int dno)throws Exception{
		
		return ds.getDistrict(dno);
	}
	@RequestMapping("/getList")
	public List<DistrictModel> getList()throws Exception{
		
		return ds.getList();
	}
	@RequestMapping("/getPage")
	public ListResultJson getListWithPage(@RequestParam(required=false,defaultValue="10") int rows,@RequestParam(required=false,defaultValue="1") int page) throws Exception
	{
		ListResultJson result=new ListResultJson();
		
		int count=ds.getCountByAll();
		int pageCount=ds.getPageCountByAll(rows);
		List list=ds.getListByAllWithPage(rows, page);
		
		result.setPage(page);
		result.setPages(pageCount);
		result.setTotal(count);
		result.setRows(list);
		
		return result;
	}


}
