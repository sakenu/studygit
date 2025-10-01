package com.study.project.rest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class RestBoardServiceClass implements RestBoardServiceInter{
	
	private final RestBoardMapper mapper;
	public RestBoardServiceClass(RestBoardMapper mapper) {
		this.mapper = mapper;
	}
	
	private String savePath = "C:/Users/user/Desktop/upload";
	private final Path uploadRoot = Paths.get(savePath);

	@Override
	public List<Map<String, Object>> findAll() {
		// TODO Auto-generated method stub
		return mapper.findAll();
	}

	@Override
	public List<RestBoardDTO> dtoFindAll(SearchDTO searchDTO) {
		// TODO Auto-generated method stub
		return mapper.dtoFindAll(searchDTO);
	}

	@Transactional
	@Override
	public int create(RestBoardDTO dto, List<MultipartFile> fileList) throws Exception {
		List<Path> savedFiles = new ArrayList<Path>();
		
		try {
		// TODO Auto-generated method stub
		mapper.create(dto);
		Integer boardNum = dto.getBoardNum();
		
		if (boardNum == null) return 0;
		
		
			//폴더 없을때 생성
			if (!Files.exists(uploadRoot)) {
	            Files.createDirectories(uploadRoot);
	        }
	
			//파일 있는 경우만
			//파일 생성 무조건 1개씩 생성
	        if (fileList != null) {
	            for (MultipartFile f : fileList) {
	                if (f == null || f.isEmpty()) continue;
	
	                String realName = Paths.get(Objects.requireNonNull(f.getOriginalFilename())).getFileName().toString();
	                String saveName = UUID.randomUUID() + "_" + realName;
	                
	                Path target = uploadRoot.resolve(saveName);
	
	                // 저장
	                Files.copy(f.getInputStream(), target, StandardCopyOption.REPLACE_EXISTING);
	                
	                savedFiles.add(target);
	                
	                RestFileDTO fileDTO = new RestFileDTO();
	                fileDTO.setBoardNum(boardNum);
	                fileDTO.setRealName(realName);
	                fileDTO.setSaveName(saveName);
	                fileDTO.setSavePath(savePath);
	                
	                int fileInsert = mapper.fileCreate(fileDTO);
	                if (fileInsert == 0) return 0;
	            }
	        }
		
	        return 1;
		}catch (Exception e) {
			e.printStackTrace();
	        // 파일 삭제 (보상 처리)
	        for (Path p : savedFiles) {
	            try { Files.deleteIfExists(p); } catch (IOException ignore) {}
	        }
	        return 0; // 실패
	    }
	}

	@Override
	public RestPageDTO page(SearchDTO searchDTO) {
		// TODO Auto-generated method stub
		int count = mapper.totalCount(searchDTO);
		
		int curPage = searchDTO.getCurPage();
		int pageSize = searchDTO.getPageSize();
		int blockSize = 5;
		
		int totalPages = (int) Math.ceil(count / (double)pageSize);
		int currentBlock = (int) Math.ceil((double)curPage / blockSize);
		
		int blockStart = (currentBlock - 1) * blockSize + 1;
		int blockEnd = Math.min(currentBlock * blockSize, Math.max(totalPages, 1));
		
		
		RestPageDTO pageDTO = new RestPageDTO();
		pageDTO.setBlockSize(blockSize);
		pageDTO.setCurPage(searchDTO.getCurPage());
		pageDTO.setPageSize(searchDTO.getPageSize());
		pageDTO.setCount(count);
		pageDTO.setTotalPages(totalPages);
		pageDTO.setCurrentBlock(currentBlock);
		pageDTO.setBlockStart(blockStart);
		pageDTO.setBlockEnd(blockEnd);
		
		return pageDTO;
	}

	@Override
	public RestBoardDTO read(int num) {
		// TODO Auto-generated method stub
		return mapper.read(num);
	}

	@Override
	public List<RestFileDTO> fileFind(int num) {
		// TODO Auto-generated method stub
		return mapper.fileFind(num);
	}

	
	
}
