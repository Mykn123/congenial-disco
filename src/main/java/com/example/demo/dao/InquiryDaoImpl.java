package com.example.demo.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Inquiry;

@Repository
public class InquiryDaoImpl implements InquiryDao {
	
	@Autowired
	private  JdbcTemplate jdbcTemplate;

	@Override
	public void insertInquiry(Inquiry inquiry) {
		jdbcTemplate.update("INSERT INTO inquiry(name, email, contents, created)  VALUES(?,?,?,?)",
				inquiry.getName(), inquiry.getEmail(), inquiry.getContents(), inquiry.getCreated());
		
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public List<Inquiry> getALL() {
		String sql = "SELECT id, name, email, contents, created FROM inquiry";
		List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);
		List<Inquiry> list = new ArrayList<Inquiry>();
		for(Map<String, Object> result : resultList) {
			Inquiry inquiry = new Inquiry();
			inquiry.setId((int)result.get("id"));
			inquiry.setName((String)result.get("name"));
			inquiry.setEmail((String)result.get("email"));
			inquiry.setContents((String)result.get("contents"));
			inquiry.setCreated((LocalDateTime)result.get("created"));
			list.add(inquiry);
		}
		return list;
		// TODO 自動生成されたメソッド・スタブ
	
	}

	@Override
	public int updateInquiry(Inquiry inquiry) {
         return jdbcTemplate.update("UPDATE inquirty SET name = ?, email = ?, contents = ?, WHERE id = ?",
        		 inquiry.getName(), inquiry.getEmail(), inquiry.getContents(), inquiry.getId());
	}

}
