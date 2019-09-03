package com.test01;

public class Score {
	
	private int no;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int sum;
	private double avg;
	private String grade;
	
	public Score() {
		
	}
	
	public Score(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getSum() {
		return kor + eng + math;
	}

	public double getAvg() {
		return getSum() / 3.0;
	}

	public String getGrade() {
		
		int g = (int)getAvg() / 10;
		
		switch (g) {
		case 10 :
		case 9 :
			
			grade = "A";
			break;
			
		case 8 :
			
			grade = "B";
			break;
			
		case 7 :
			
			grade = "C";
			break;
			
		case 6 :
			
			grade = "D";
			break;

		default:
			
			grade = "F";
			break;
		}
		
		return grade;
	}

	@Override
	public String toString() {
		return String.format("이름 : %3s  /  국어 : %3d  /  영어 : %3d  /  수학 : %3d  /  총점 : %3d  /  평균 : %.2f  /  등급 : %s", name, kor, eng, math, getSum(), getAvg(), getGrade());
	}
}
