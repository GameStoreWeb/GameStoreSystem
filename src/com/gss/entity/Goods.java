package com.gss.entity;

import java.util.List;

/**
 * @author Joker
 * 商品类，包含以下属性：
 * 商品Id、商品名、商品类别、简介、优惠、
 * 规格、单价、商家、图片、销售量和评论
 */
public class Goods { 
	private int gId;
	private String gName;
	private String gCategory;
	private String gDetail;
	private float gDiscount;
	private String gStandard;
	private double gPrice;
	private Seller gSeller;
	private List<String> gPicture;
	private int gSalesvolume;
	private GoodsComment comments;
	
	public Goods(int gId, String gName, String gCategory, String gDetail,
			float gDiscount, String gStandard, double gPrice, Seller gSeller,
			List<String> gPicture, int gSalesvolume, GoodsComment comments) {
		super();
		this.gId = gId;
		this.gName = gName;
		this.gCategory = gCategory;
		this.gDetail = gDetail;
		this.gDiscount = gDiscount;
		this.gStandard = gStandard;
		this.gPrice = gPrice;
		this.gSeller = gSeller;
		this.gPicture = gPicture;
		this.gSalesvolume = gSalesvolume;
		this.comments = comments;
	}
	
	public Goods() {
		super();
	}

	public int getgId() {
		return gId;
	}
	public void setgId(int gId) {
		this.gId = gId;
	}
	public String getgName() {
		return gName;
	}
	public void setgName(String gName) {
		this.gName = gName;
	}
	public String getgCategory() {
		return gCategory;
	}
	public void setgCategory(String gCategory) {
		this.gCategory = gCategory;
	}
	public String getgDetail() {
		return gDetail;
	}
	public void setgDetail(String gDetail) {
		this.gDetail = gDetail;
	}
	public float getgDiscount() {
		return gDiscount;
	}
	public void setgDiscount(float gDiscount) {
		this.gDiscount = gDiscount;
	}
	public String getgStandard() {
		return gStandard;
	}
	public void setgStandard(String gStandard) {
		this.gStandard = gStandard;
	}
	public double getgPrice() {
		return gPrice;
	}
	public void setgPrice(double gPrice) {
		this.gPrice = gPrice;
	}
	public Seller getgSeller() {
		return gSeller;
	}
	public void setgSeller(Seller gSeller) {
		this.gSeller = gSeller;
	}
	public List<String> getgPicture() {
		return gPicture;
	}
	public void setgPicture(List<String> gPicture) {
		this.gPicture = gPicture;
	}
	public int getgSalesvolume() {
		return gSalesvolume;
	}
	public void setgSalesvolume(int gSalesvolume) {
		this.gSalesvolume = gSalesvolume;
	}
	public GoodsComment getComments() {
		return comments;
	}
	public void setComments(GoodsComment comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Goods [gId=" + gId + ", gName=" + gName + ", gCategory="
				+ gCategory + ", gDetail=" + gDetail + ", gDiscount="
				+ gDiscount + ", gStandard=" + gStandard + ", gPrice=" + gPrice
				+ ", gSeller=" + gSeller + ", gPicture=" + gPicture
				+ ", gSalesvolume=" + gSalesvolume + ", comments=" + comments
				+ "]";
	}
	
	
	
	
}
