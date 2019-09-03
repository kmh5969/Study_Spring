package com.mvc.practice.model;

import java.util.List;

public interface Biz {
	
	public List<MVCDto> selectList();
	public MVCDto selectOne(int seq);
	public int insert(MVCDto dto);
	public int update(MVCDto dto);
	public int delete(int seq);
	
}
