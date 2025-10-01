package com.study.project.jpa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.support.QuerydslJpaRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jpa/board")
public class JpaBoardController {
	
	private final JpaBoardService service;
	public JpaBoardController(JpaBoardService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<JpaBoardEntity> findAll(){
		
		List<JpaBoardEntity> list = service.findAll();
		
		return list;
	}
	
	@PostMapping
	public Map<String, Object> save(@RequestBody JpaBoardDTO boardDto){
		
		JpaBoardEntity insert = service.qqqq(boardDto);
		
		Map<String, Object> status = new HashMap<String, Object>();
		status.put("status", insert.getBoardNum() == 0 ? false : true);
		
		return status;
		
	}
	
	@GetMapping("/{num}")
	public JpaBoardEntity read(@PathVariable int num) {
		
//		Optional<JpaBoardEntity>
		
		return service.findById(num);
	}
	
	@PutMapping("/set")
	public Map<String, Object> boardUpdate(@RequestBody JpaBoardDTO boardDto){
		
		JpaBoardEntity update = service.boardUpdate(boardDto);
		
		
		Map<String, Object> status = new HashMap<String, Object>();
		status.put("status", update.getBoardNum() == 0 ? false : true);
		
		return status;
	}
	
	@PutMapping("/query")
	public Map<String, Object> boardUpdate1(@RequestBody JpaBoardDTO boardDto){
		
		int update = service.boardUpdate1(boardDto);
		
		
		Map<String, Object> status = new HashMap<String, Object>();
		status.put("status", update == 0 ? false : true);
		
		return status;
	}
	
	@DeleteMapping("/set/{num}")
	public Map<String, Object> deleteSet(@PathVariable int num){
		
		Map<String, Object> status = new HashMap<String, Object>();
		try {
			service.deletSet(num);
			status.put("status", true);
		}catch (Exception e) {
			// TODO: handle exception
			status.put("status", false);
		}
		
		return status;
	}
	
	@DeleteMapping("/query/{num}")
	public Map<String, Object> deleteQuery(@PathVariable int num){
		
		int delete = service.deleteQuery(num);
		Map<String, Object> status = new HashMap<String, Object>();
		status.put("status", delete == 0 ? false : true);
		
		return status;
	}
	
	
	@PostMapping("/search/set")
	public List<JpaBoardEntity> searchSet(@RequestBody JpaSearchDTO searchDto){
		
		List<JpaBoardEntity> searchList = service.searchSet(searchDto);
		
		return searchList;
	}
	
	
	
	
	
	

}
