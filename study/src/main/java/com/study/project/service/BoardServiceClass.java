package com.study.project.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.project.repository.BoardMapper;

@Service
public class BoardServiceClass implements BoardServiceInter{
	
	@Autowired
	public BoardMapper mapper;

	@Override
	public List<Map<String, Object>> list() {
		// TODO Auto-generated method stub
		return mapper.list();
	}

	@Override
	public int insert(Map<String, Object> insertMap) {
		// TODO Auto-generated method stub
		return mapper.insert(insertMap);
	}

	@Override
	public Map<String, Object> detail(int num) {
		// TODO Auto-generated method stub
		return mapper.detail(num);
	}

	@Override
	public int update(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return mapper.update(dataMap);
	}

	@Override
	public int delete(int num) {
		// TODO Auto-generated method stub
		return mapper.delete(num);
	}

	@Override
	public int viewCnt(int num) {
		// TODO Auto-generated method stub
		
		
		
		return mapper.viewCnt(num);
	}

	@Override
	public int deleteNums(List<Integer> nums) {
		// TODO Auto-generated method stub
		return mapper.deleteNums(nums);
	}
	

}
