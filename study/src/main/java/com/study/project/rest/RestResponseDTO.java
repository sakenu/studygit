package com.study.project.rest;

import java.util.List;

public class RestResponseDTO {
	
	
	
	private List<RestBoardDTO> list;
	private RestPageDTO page;
	
	
	
	public List<RestBoardDTO> getList() {
		return list;
	}
	public void setList(List<RestBoardDTO> list) {
		
		
		
		this.list = list;
	}
	public RestPageDTO getPage() {
		return page;
	}
	public void setPage(RestPageDTO page) {
		this.page = page;
	}
	
	

}
