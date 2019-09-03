package com.mvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mvc.dto.MVCBoardDto;

@Repository
public class MVCBoardDaoImpl implements MVCBoardDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<MVCBoardDto> selectList() {
		
		List<MVCBoardDto> list = jdbcTemplate.query(SELECT_LIST_SQL, new myMapper());
		
		return list;
	}

	@Override
	public MVCBoardDto selectOne(int seq) {
		
		MVCBoardDto dto = jdbcTemplate.queryForObject(SELECT_ONE_SQL, new Object[] {seq}, new myMapper());
		
		return dto;
	}

	@Override
	public int insert(MVCBoardDto dto) {
		
		int res = jdbcTemplate.update(INSERT_SQL, new Object[] {dto.getWriter(), dto.getTitle(), dto.getContent()});
		
		return res;
	}

	@Override
	public int update(MVCBoardDto dto) {
		
		int res = jdbcTemplate.update(UPDATE_SQL, new Object[] {dto.getTitle(), dto.getContent(), dto.getSeq()});
		
		return res;
	}

	@Override
	public int delete(int seq) {
		
		int res = jdbcTemplate.update(DELETE_SQL, new Object[] {seq});
		
		return res;
	}
	
	public static final class myMapper implements RowMapper<MVCBoardDto> {

		@Override
		public MVCBoardDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			MVCBoardDto res = new MVCBoardDto();
			res.setSeq(rs.getInt("SEQ"));
			res.setTitle(rs.getString("TITLE"));
			res.setContent(rs.getString("CONTENT"));
			res.setWriter(rs.getString("WRITER"));
			res.setRegdate(rs.getDate("REGDATE"));
			
			return res;
		}
		
	}

}
