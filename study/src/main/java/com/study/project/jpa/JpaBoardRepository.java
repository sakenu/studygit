package com.study.project.jpa;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface JpaBoardRepository extends JpaRepository<JpaBoardEntity, Integer>{

	//벌크 방식 table JPQL
	@Modifying //insert, update, delete 꼭 붙여야합니다.
	@Query("""
			
			update JpaBoardEntity jbe
			 set jbe.userId = :userId
			 	, jbe.userName = :userName
			 	, jbe.boardSubject  = :boardSubject
			 	, jbe.boardContent = :boardContent
			 where jbe.boardNum = :boardNum 
			 
			 
			 
			""")
	int boardUpdate1(@Param("boardNum") int boardNum
			, @Param("userId") String userId
			, @Param("userName")String userName
			, @Param("boardSubject")String boardSubject
			, @Param("boardContent")String boardContent
			);

	
	
	
	@Modifying
	@Query("delete from JpaBoardEntity jbe where jbe.boardNum = :num")
	int deleteQuery(@Param("num") int num);

	
	
	List<JpaBoardEntity> findAllByUserNameContaining(String searchTxt, Sort sort);

	List<JpaBoardEntity> findAllByBoardSubjectContaining(String searchTxt, Sort sort);

	List<JpaBoardEntity> findAllByBoardSubjectOrBoardContentContaining(String subjectTxt, String contentTxt, Sort sort);

//	 //select
//	@Query(""" 
//			select a from JpaBoardEntity a
//			where 1=1
//			(
//				:type == 'subject'	 and a.boardSubject like concat('%',searchTxt, '%')
//			)
//			""")
//    public List<JpaBoardEntity> retList(@Param("type") String searchType);
//	
//	@Modifying
//	@Query(""" 
//			
//			insert into JpaBoardEntity a
//			(
//				a.userId
//				,a.userName 
//			)values(
//				:id
//				,:name
//				...
//			)
//			""")
//	
//	
//	@Query("""
//			delete from JpaBoardEntity a
//			where a.boardNum in ( :num )
//			
//			""")
	
	
	
	
	
	
	
	
	
	

}
