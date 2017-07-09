package com.flower.hot.controller.xq;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flower.hot.model.xq.RoomModel;
import com.flower.hot.result.zmm.ResultJson;
import com.flower.hot.service.xq.IRoomService;
@RestController
@RequestMapping("/Room")
public class RoomController {
	
	private IRoomService rs=null;
	
	@Autowired
	public void setRs(IRoomService rs) {
		this.rs = rs;
	}

	@RequestMapping("/add")
	public ResultJson add(RoomModel rm)throws Exception{
		
		ResultJson result=new ResultJson();
		rs.add(rm);
		result.setResult("Y");
		return result;
	}
	@RequestMapping("/modify")
	public ResultJson modify(RoomModel rm)throws Exception{
		
		ResultJson result=new ResultJson();
		rs.modify(rm);
		result.setResult("Y");
		return result;
	}
	@RequestMapping("/delete")
	public ResultJson delete(RoomModel rm)throws Exception{
		
		ResultJson result=new ResultJson();
		rs.delete(rm);
		result.setResult("Y");
		return result;
	}
	@RequestMapping("/get")
	public RoomModel getRoom(@RequestParam int roomno)throws Exception{
		
		return rs.getRoom(roomno);
	}
	@RequestMapping("/getList")
	public List<RoomModel> getList()throws Exception{
		
		return rs.getList();
	}
	@RequestMapping("/getPage")
	public List<RoomModel> getPage(@RequestParam int rows,@RequestParam int page)throws Exception{
		
		return rs.getListByAllWithPage(rows, page);
	}

}
