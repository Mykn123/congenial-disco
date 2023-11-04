package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.InquiryDao;
import com.example.demo.entity.Inquiry;

@Service
public class InquiryServiceImpl implements InquiryService {

	
	
	@Autowired
		private  InquiryDao dao;
	
	
	@Override
	public void save(Inquiry inquiry) {
		dao.insertInquiry(inquiry);
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public List<Inquiry> geAll() {
		// TODO 自動生成されたメソッド・スタブ
		return dao.getALL();
	}

	@Override
	public void update(Inquiry inquiry) {
//		if(dao.updateInquiry(inquiry) == 0) {
//			throw new InquiryNotFoundException("can't find the same ID");	
//		}
	}

}
