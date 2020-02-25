package com.dao;

import java.util.List;

import com.bean.LoginBean;


public interface LoginDao {
	
	public int insertv(LoginBean loginBean) ;
	
	public List<LoginBean>fetch();
	
	public void update (LoginBean loginBean);
	
	public void delete (LoginBean loginBean);
	
}

