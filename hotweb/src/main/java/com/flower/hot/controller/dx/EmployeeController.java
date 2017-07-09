package com.flower.hot.controller.dx;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flower.hot.model.dx.EmployeeModel;
import com.flower.hot.result.zmm.ListResultJson;
import com.flower.hot.result.zmm.ResultJson;
import com.flower.hot.service.dx.IEmployeeService;



@RestController
@RequestMapping("/Employee")
public class EmployeeController {
	
private IEmployeeService es=null;
	
	@Autowired
	public void setDs(IEmployeeService es) {
		this.es = es;
	}

	@RequestMapping("/add")
	public ResultJson add(EmployeeModel em)throws Exception{
		
		ResultJson result=new ResultJson();
		es.add(em);
		result.setResult("Y");
		return result;
	}
	@RequestMapping("/modify")
	public ResultJson modify(EmployeeModel em)throws Exception{
		
		ResultJson result=new ResultJson();
		es.modify(em);
		result.setResult("Y");
		return result;
	}
	@RequestMapping("/delete")
	public ResultJson delete(EmployeeModel em)throws Exception{
		
		ResultJson result=new ResultJson();
		es.delete(em);
		result.setResult("Y");
		return result;
	}
	@RequestMapping("/get")
	public EmployeeModel getEmployee(@RequestParam int eno)throws Exception{
		
		return es.getEmployee(eno);
	}
	@RequestMapping("/getList")
	public List<EmployeeModel> getList()throws Exception{
		
		return es.getList();
	}
	@RequestMapping("/getPage")
	public ListResultJson getListWithPage(@RequestParam(required=false,defaultValue="10") int rows,@RequestParam(required=false,defaultValue="1") int page) throws Exception
	{
		ListResultJson result=new ListResultJson();
		
		int count=es.getCountByAll();
		int pageCount=es.getPageCountByAll(rows);
		List list=es.getListByAllWithPage(rows, page);
		
		result.setPage(page);
		result.setPages(pageCount);
		result.setTotal(count);
		result.setRows(list);
		
		return result;
	}

}
