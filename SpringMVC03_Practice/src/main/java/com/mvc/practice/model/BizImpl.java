package com.mvc.practice.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BizImpl implements Biz {
	
	@Autowired
	private DaoImpl dao;

	@Override
	public List<MVCDto> selectList() {
		
		return dao.selectList();
	}

	@Override
	public MVCDto selectOne(int seq) {
		
		return dao.selectOne(seq);
	}

	@Override
	public int insert(MVCDto dto) {
		
		return dao.insert(dto);
	}

	@Override
	public int update(MVCDto dto) {
		
		return dao.update(dto);
	}

	@Override
	public int delete(int seq) {
		
		return dao.delete(seq);
	}

}
