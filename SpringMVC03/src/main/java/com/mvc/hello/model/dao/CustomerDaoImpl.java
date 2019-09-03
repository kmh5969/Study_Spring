package com.mvc.hello.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.hello.dto.CustomerDto;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	@Override
	public List<CustomerDto> selectList() {
		
		List<CustomerDto> list = new ArrayList<CustomerDto>();
		
		try {
			list = sqlSession.selectList(namespace+"selectList");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("SELECT LIST ERROR");
		} 
		return list;
	}

	@Override
	public CustomerDto selectone(String id) {
		CustomerDto dto = null;
		
		try {
			dto = sqlSession.selectOne(namespace+"selectOne", id);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("SELECT ONE ERROR");
		}
		return dto;
	}

	@Override
	public int insert(CustomerDto dto) {
		
		int res = 0;
		
		try {
			res = sqlSession.insert(namespace+"insert", dto);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("INSERT ERROR");
		}
		return res;
	}

	@Override
	public int update(CustomerDto dto) {
		int res = 0;
		
		try {
			res = sqlSession.update(namespace+"update", dto);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("update error");
		}
		return res;
	}

	@Override
	public int delete(String id) {
		int res = 0;
		
		try {
			res = sqlSession.delete(namespace+"delete", id);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DELETE ERROR");
		}
		return res;
	}

}
