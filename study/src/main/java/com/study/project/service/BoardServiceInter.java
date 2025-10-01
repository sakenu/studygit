package com.study.project.service;

import java.util.List;
import java.util.Map;

public interface BoardServiceInter {

	List<Map<String, Object>> list();

	int insert(Map<String, Object> insertMap);

	Map<String, Object> detail(int num);

	int update(Map<String, Object> dataMap);

	int delete(int num);

	int viewCnt(int num);

	int deleteNums(List<Integer> nums);

}
