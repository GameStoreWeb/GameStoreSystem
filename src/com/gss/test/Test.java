package com.gss.test;

import java.util.Date;

import com.gss.dao.CartManage;
import com.gss.dao.LoginManage;
import com.gss.dao.impl.CartManageImpl;
import com.gss.dao.impl.UserLoginManageImpl;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		LoginManage lm = new UserLoginManageImpl();
//		System.out.println(lm.checkLogin("joker", "123456"));
		
//		Date date = new Date();
//		System.out.println(date.getDate());
		
		CartManage lm = new CartManageImpl();
		lm.modifyGoods("1","02016083101",2);

		
	}

}
