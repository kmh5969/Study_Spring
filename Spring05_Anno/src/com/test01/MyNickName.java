package com.test01;

public class MyNickName {
	
	public NickName nickName;
	
	public MyNickName() {
		
	}
	
	public MyNickName(NickName nickName) {
		this.nickName = nickName;
	}
	
	@Override
	public String toString() {
		
		return "나의 " + nickName; 
	}

}
