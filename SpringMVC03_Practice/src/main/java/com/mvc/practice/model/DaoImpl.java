package com.mvc.practice.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class DaoImpl implements Dao {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public List<MVCDto> selectList() {
		
		List<MVCDto> list = jdbc.query(SELECT_LIST_SQL, new myMapper());
		
		return list;
	}
	
	@Override
	public MVCDto selectOne(int seq) {

		MVCDto dto = jdbc.queryForObject(SELECT_ONE_SQL, new Object[] {seq}, new myMapper());
		
		return dto;
	}
	
	@Override
	public int insert(MVCDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int update(MVCDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int delete(int seq) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public static final class myMapper implements RowMapper<MVCDto> {

		@Override
		public MVCDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			MVCDto dto = new MVCDto();
			dto.setSeq(rs.getInt(1));
			dto.setWriter(rs.getString(2));
			dto.setTitle(rs.getString(3));
			dto.setContent(rs.getString(4));
			dto.setRegdate(rs.getDate(5));
			
			return dto;
		}
		
	}
	
}
