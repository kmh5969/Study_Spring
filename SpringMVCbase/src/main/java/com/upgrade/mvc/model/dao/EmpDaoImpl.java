package com.upgrade.mvc.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.upgrade.mvc.dto.EmpDto;

@Repository
public class EmpDaoImpl implements EmpDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<EmpDto> selectList() {
		
		List<EmpDto> list = null;
		
		try {
			list = sqlSession.selectList(namespace+"selectList");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("selectList() 에러!");
		}
		return list;
	}

	@Override
	public EmpDto selectOne(int empno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(EmpDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(EmpDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int empno) {
		// TODO Auto-generated method stub
		return 0;
	}

}
