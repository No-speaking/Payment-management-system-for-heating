package com.flower.hot.service.xq;

import java.util.List;


import com.flower.hot.model.xq.UserModel;

public interface IUserService {
	
	public void add(UserModel um)throws Exception;
	public void delete(UserModel um)throws Exception;
	public void modify(UserModel um)throws Exception;
	public List<UserModel> getList()throws Exception;
	public UserModel getUser(int uno)throws Exception;
	public int getCountByAll()throws Exception;
	public int getPageCountByAll(int rows)throws Exception;
	public List<UserModel> getListByAllWithPage(int rows,int page) throws Exception;

}
