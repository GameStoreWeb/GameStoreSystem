package com.gss.test;

import java.util.Date;
import java.util.List;

import com.gss.dao.AccountManage;
import com.gss.dao.WarehouseManage;
import com.gss.dao.impl.SellerLoginManageImpl;
import com.gss.dao.impl.WarehouseManageImpl;
import com.gss.entity.Goods;
import com.gss.entity.GoodsComment;
import com.gss.entity.Seller;

public class hetest {

	public static void main(String[] args) {
		int gId = 3;
		String gName = "name";
		String gCategory = "1";
		String gDetail = "www";
		float gDiscount = 0.1f;
		String gStandard = "368g";
		double gPrice = 8.8;
		int gSalesvolume = 1;
		
		
		AccountManage slm = new SellerLoginManageImpl();
		Seller gSeller = (Seller) slm.showUnitInfo("1");
		
		Goods goods = new Goods(gId,gName,gCategory,gDetail,
				gDiscount,gStandard,gPrice,gSeller,
				null,gSalesvolume,null);
		WarehouseManage ami = new WarehouseManageImpl();
		ami.addGoods(goods, ""+goods.getgSeller().getsId());
		
		System.out.println(goods);
		
	}
	
	public hetest() {
		// TODO Auto-generated constructor stub
	
	}

}
