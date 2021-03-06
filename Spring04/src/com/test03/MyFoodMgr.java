package com.test03;

public class MyFoodMgr {
	
	private Food favoriteFood;
	private Food unFavoriteFood;
	
	public MyFoodMgr() {
		favoriteFood = new Food();
		favoriteFood.setName("고기");
		favoriteFood.setPrice(15000);
	}
	
	public MyFoodMgr(Food favoriteFood, Food unFavoriteFood) {
		this.favoriteFood = favoriteFood;
		this.unFavoriteFood = unFavoriteFood;
	}

	public Food getFavoriteFood() {
		return favoriteFood;
	}

	public void setFavoriteFood(Food favoriteFood) {
		this.favoriteFood = favoriteFood;
	}

	public Food getUnFavoriteFood() {
		return unFavoriteFood;
	}

	public void setUnFavoriteFood(Food unFavoriteFood) {
		this.unFavoriteFood = unFavoriteFood;
	}

	@Override
	public String toString() {
		return "favoriteFood : " + favoriteFood + ", unFavoriteFood : " + unFavoriteFood;
	}
	
	

}
