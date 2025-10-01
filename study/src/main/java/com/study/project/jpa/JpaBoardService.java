package com.study.project.jpa;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JpaBoardService {
	
	private final JpaBoardRepository repository;
	public JpaBoardService(JpaBoardRepository repository) {
		this.repository = repository;
	}
	
	public List<JpaBoardEntity> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll(Sort.by(Sort.Direction.DESC, "boardNum"));
		//order by board_num desc
	}

	public JpaBoardEntity qqqq(JpaBoardDTO boardDto) {
		// TODO Auto-generated method stub
		
		Date date = new Date(System.currentTimeMillis());
		JpaBoardEntity entity = new JpaBoardEntity();
		
		entity.setUserId(boardDto.getUserId());
		entity.setUserName(boardDto.getUserName());
		entity.setBoardSubject(boardDto.getBoardSubject());
		entity.setBoardContent(boardDto.getBoardContent());
		entity.setRegDate(date);
		entity.setUptDate(null);
		entity.setViewCnt(0);
		
		
	
		
		
		return repository.save(entity);
	}

	public JpaBoardEntity findById(int num) {
		// TODO Auto-generated method stub
		return repository.findById(num).orElse(null);
	}

	@Transactional
	public JpaBoardEntity boardUpdate(JpaBoardDTO boardDto) {
		// TODO Auto-generated method stub
		
		JpaBoardEntity oneData = repository.findById(boardDto.getBoardNum()).orElse(null);
		oneData.setUserId(boardDto.getUserId());
		oneData.setUserName(boardDto.getUserName());
		oneData.setBoardSubject(boardDto.getBoardSubject());
		oneData.setBoardContent(boardDto.getBoardContent());
	
		//findByID where 적용   select ->> set하면 자동 update (hibernate) 한건변경 시
//		update board
//		set user_id = :userId
//		where board_num = 10
		
		return oneData;
	}

	@Transactional
	public int boardUpdate1(JpaBoardDTO boardDto) {
		// TODO Auto-generated method stub
		int boardNum = boardDto.getBoardNum();
		String userId = boardDto.getUserId();
		String userName = boardDto.getUserName();
		String boardSubject = boardDto.getBoardSubject();
		String boardContent = boardDto.getBoardContent();
		
		
		return repository.boardUpdate1(boardNum, userId, userName, boardSubject, boardContent);
	}

	@Transactional
	public void deletSet(int num) {
		// TODO Auto-generated method stub
		repository.deleteById(num);
	}

	@Transactional
	public int deleteQuery(int num) {
		// TODO Auto-generated method stub
		
		return repository.deleteQuery(num);
	}

	public List<JpaBoardEntity> searchSet(JpaSearchDTO searchDto) {
		// TODO Auto-generated method stub
		
		List<JpaBoardEntity> searchList = new ArrayList<JpaBoardEntity>();
		Sort sort = Sort.by(Sort.Direction.DESC, "regDate");
		
		//Containing  like '%keyword%'
		//StartsWith like '%keyword'
		//EndsWith like 'keyword%'
		//Entity 변수 변수 And Or
		
		
		if("name".equals(searchDto.getSearchType())) {
			searchList = repository.findAllByUserNameContaining(searchDto.getSearchTxt(), sort);
		}else if("subject".equals(searchDto.getSearchType())) {
			searchList = repository.findAllByBoardSubjectContaining(searchDto.getSearchTxt(), sort);
		}else if("subCont".equals(searchDto.getSearchType())) {
			searchList = repository.findAllByBoardSubjectOrBoardContentContaining(searchDto.getSearchTxt(), searchDto.getSearchTxt(), sort);
		}else {
			searchList = repository.findAll();
		}
				
				
				
				/*StartsWith
				EndsWith*/
		
		
		return searchList;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
