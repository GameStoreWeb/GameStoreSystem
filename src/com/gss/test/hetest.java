package com.gss.test;

import java.util.ArrayList;
import java.util.List;

import com.gss.dao.CartManage;
import com.gss.dao.WarehouseManage;
import com.gss.dao.impl.CartManageImpl;
import com.gss.dao.impl.WarehouseManageImpl;
import com.gss.entity.Cart;
import com.gss.entity.Goods;

public class hetest {
	public static void main(String[] args) {
		
//		WarehouseManage wm = new WarehouseManageImpl();
//		List<Goods> goods = wm.showAllGoods();
//		
//		
//		for (Goods good : goods) {
//			System.out.println(good.getgPicture().get(0));
//			
//		}
		
		CartManage cm = new CartManageImpl();
		String userid = "02016083101";
		Cart cart = cm.showAllCart(userid);
		System.out.println(cart.getGoodsItem().get(0).getGoods().getgPicture());
	}
	

}
