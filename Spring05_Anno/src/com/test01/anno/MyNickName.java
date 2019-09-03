package com.test01.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyNickName {
	
	@Autowired
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
