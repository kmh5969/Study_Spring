package com.test01;

public class Woman {
	
	void classWork() {
		
		System.out.println("출석카드 찍는다.");				// CCC (Cross-Cutting Concern)
		
		try {
			System.out.println("컴퓨터 켜서 쇼핑한다.");		// CC (Core Concern)
			
		} catch (Exception e) {
			System.out.println("쉬는 날이다.");
			
		} finally {
			System.out.println("집에 간다.");
		}
	}

}
