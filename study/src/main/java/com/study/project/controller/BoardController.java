package com.study.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.project.service.BoardServiceInter;

@Controller
public class BoardController {
	
	@Autowired
	public BoardServiceInter service;

	@RequestMapping("list")
	@ResponseBody
	public List<Map<String, Object>> list(){
		
		List<Map<String, Object>> boardList = service.list();
		
		return boardList;
	}
	
	
	@RequestMapping("insert")
	
	public Map<String, Object> insert(@RequestBody Map<String, Object> insertMap ) {
		
		int insert = service.insert(insertMap);
		Map<String, Object> status = new HashMap<String, Object>();
		
		if(insert == 0) {
//			등록에 실패했다
			status.put("stus", "fail");
		}else {
			status.put("stus", "succ");
		}
		
		
		return status;
		
		
		 //redirect , forward
	}
	
	@RequestMapping("/detail/{num}")
	@ResponseBody
	public Map<String, Object> detail(@PathVariable int num){
		
		Map<String, Object> detailMap = service.detail(num);
		return detailMap;
	}
	
	@RequestMapping("update")
	@ResponseBody
	public Map<String, Object> update(@RequestBody Map<String, Object> dataMap){
		
			
		int update = service.update(dataMap);
		
		Map<String, Object> status = new HashMap<String, Object>();
		if(update == 0) {
			status.put("stus", "fail");
		}else {
			status.put("stus", "succ");
		}
		return status;
	}
	
	
	@RequestMapping("/delete/{num}")
	@ResponseBody
	public Map<String, Object> delete(@PathVariable int num){
		
		int delete = service.delete(num);
		
		Map<String, Object> status = new HashMap<String, Object>();
		if(delete == 0) {
			status.put("stus", "fail");
		}else {
			status.put("stus", "succ");
		}
		
		
		return status;
	}
	
	@RequestMapping("/viewCnt/{num}")
	@ResponseBody
	public Map<String, Object> viewCnt(@PathVariable int num){
		
		int update = service.viewCnt(num); 
		
		Map<String, Object> status = new HashMap<String, Object>();
		
		status.put("stus", update == 0 ? false : true);
//		
//		int num1 = 10;
//		
//		boolean aa = num1 == 1 ? true : false ;
//		
//		if(num1 == 1) {
//			aa = true;
//		}else {
//			aa = false;
//		}
//				

		return status;
	}
	
	@RequestMapping("deleteNums")
	@ResponseBody
	public Map<String, Object> deleteNums(@RequestBody List<Integer> nums){
		
		int delete = service.deleteNums(nums);
	
		Map<String, Object> status = new HashMap<String, Object>();
	
		status.put("stus", delete == 0 ? false : true);
		return status;
	}
	
	
	

}
