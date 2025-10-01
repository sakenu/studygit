package com.study.project.rest;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface RestBoardServiceInter {

	List<Map<String, Object>> findAll();

	List<RestBoardDTO> dtoFindAll(SearchDTO searchDTO);
	
	int create(RestBoardDTO dto, List<MultipartFile> fileList) throws Exception;

	RestPageDTO page(SearchDTO searchDTO);

	RestBoardDTO read(int num);

	List<RestFileDTO> fileFind(int num);

	

}
