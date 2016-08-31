package com.gss.entity;

/**
 * @author Joker
 * 商品类别类，包含类别ID和类别名两个属性
 */
public class GoodsCategory {
	private String categoryId;
	private String categoryName;
	
	public GoodsCategory(String categoryId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}
	
	public GoodsCategory() {
		super();
	}

	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "GoodsCategory [categoryId=" + categoryId + ", categoryName="
				+ categoryName + "]";
	}
	
	
}
