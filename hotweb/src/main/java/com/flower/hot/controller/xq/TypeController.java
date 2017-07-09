package com.flower.hot.controller.xq;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flower.hot.model.xq.DistrictModel;
import com.flower.hot.model.xq.TypeModel;
import com.flower.hot.result.zmm.ListResultJson;
import com.flower.hot.result.zmm.ResultJson;
import com.flower.hot.service.xq.IDistrictService;
import com.flower.hot.service.xq.ITypeService;

@RestController
@RequestMapping("/Type")
public class TypeController {
	
	private ITypeService ts=null;
	
	@Autowired
	public void setTs(ITypeService ts) {
		this.ts = ts;
	}

	@RequestMapping("/add")
	public ResultJson add(TypeModel tm)throws Exception{
		
		ResultJson result=new ResultJson();
		ts.add(tm);
		result.setResult("Y");
		return result;
	}
	@RequestMapping("/modify")
	public ResultJson modify(TypeModel tm)throws Exception{
		
		ResultJson result=new ResultJson();
		ts.modify(tm);
		result.setResult("Y");
		return result;
	}
	@RequestMapping("/delete")
	public ResultJson delete(TypeModel tm)throws Exception{
		
		ResultJson result=new ResultJson();
		ts.delete(tm);
		result.setResult("Y");
		return result;
	}
	@RequestMapping("/get")
	public TypeModel getType(@RequestParam int tno)throws Exception{
		
		return ts.getType(tno);
	}
	@RequestMapping("/getList")
	public List<TypeModel> getList()throws Exception{
		
		return ts.getList();
	}
	@RequestMapping("/getPage")
	public ListResultJson getListWithPage(@RequestParam(required=false,defaultValue="10") int rows,@RequestParam(required=false,defaultValue="1") int page) throws Exception
	{
		ListResultJson result=new ListResultJson();
		
		int count=ts.getCountByAll();
		int pageCount=ts.getPageCountByAll(rows);
		List list=ts.getListByAllWithPage(rows, page);
		
		result.setPage(page);
		result.setPages(pageCount);
		result.setTotal(count);
		result.setRows(list);
		
		return result;
	}


}
