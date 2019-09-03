package com.mvc.hello.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.hello.dto.CustomerDto;
import com.mvc.hello.model.dao.CustomerDaoImpl;

@Service
public class CustomerBizImpl implements CustomerBiz {

	@Autowired
	private CustomerDaoImpl dao;
	
	@Override
	public List<CustomerDto> selectList() {
		return dao.selectList();
	}

	@Override
	public CustomerDto selectone(String id) {
		return dao.selectone(id);
	}

	@Override
	public int insert(CustomerDto dto) {
		return dao.insert(dto);
	}

	@Override
	public int update(CustomerDto dto) {
		return dao.update(dto);
	}

	@Override
	public int delete(String id) {
		return dao.delete(id);
	}

}
