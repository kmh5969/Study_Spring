package com.mvc.customer.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mvc.customer.dto.CustomerDto;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Override
	public List<CustomerDto> selectList() {

		return null;
	}

	@Override
	public CustomerDto selectOne(String id) {

		return null;
	}

	@Override
	public int insert(CustomerDto dto) {

		return 0;
	}

	@Override
	public int update(CustomerDto dto) {

		return 0;
	}

	@Override
	public int delete(String id) {

		return 0;
	}

}
