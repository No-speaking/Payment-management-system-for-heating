package com.flower.hot.controller.zmm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.flower.hot.model.zmm.CostInfoModel;
import com.flower.hot.model.zmm.YouhuiModel;
import com.flower.hot.result.zmm.ResultJson;
import com.flower.hot.service.zmm.IYouhuiService;



@RestController
@RequestMapping("/youhui")
public class YouhuiController {
private IYouhuiService ys=null;
	
	@Autowired
	public void setYs(IYouhuiService ys) {
		this.ys = ys;
	}

	@RequestMapping("/add")
	public ResultJson add(YouhuiModel ym) throws Exception
	{
		ResultJson result=new ResultJson();
		ys.add(ym);
		result.setResult("Y");
		
		return result;
	}
	@RequestMapping("/modify")
	public ResultJson modify(YouhuiModel ym) throws Exception
	{
		ResultJson result=new ResultJson();
		ys.modify(ym);
		result.setResult("Y");
		
		return result;
	}
	@RequestMapping("/delete")
	public ResultJson delete(YouhuiModel ym) throws Exception
	{
		ResultJson result=new ResultJson();
		ys.delete(ym);
		result.setResult("Y");
		
		return result;
	}
	
	@RequestMapping("/get")
	public YouhuiModel got(@RequestParam String youid) throws Exception
	{
		return ys.getYouhui(youid);
	}
	
	@RequestMapping("/get/all")
	public List<YouhuiModel> getAll() throws Exception
	{
		return ys.getListByAll();
	}
	
	@RequestMapping("/get/allwithpage")
	public List<YouhuiModel> getAllWithPage(@RequestParam int rows,@RequestParam int page) throws Exception
	{
		return ys.getListByAllWithPage(rows, page);
	}
	
	
	//取得指定的优惠的缴费列表
		@RequestMapping(value="/get/costs")
		public List<CostInfoModel> getBehaves(@RequestParam String youid) throws Exception
		{
			return ys.getCostInfo(youid);
			
		}

}
