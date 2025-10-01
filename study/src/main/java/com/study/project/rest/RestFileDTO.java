package com.study.project.rest;

import java.sql.Date;

public class RestFileDTO {
	
	private int fileNum;        // 파일 PK
    private int boardNum;       // 게시글 번호 (FK)
    private String realName;    // 실제 파일명
    private String saveName;    // 서버에 저장된 파일명
    private String savePath;    // 저장 경로
    private Date fileSaveDate;  // 저장일자
    
	public int getFileNum() {
		return fileNum;
	}
	public void setFileNum(int fileNum) {
		this.fileNum = fileNum;
	}
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getSaveName() {
		return saveName;
	}
	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}
	public String getSavePath() {
		return savePath;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	public Date getFileSaveDate() {
		return fileSaveDate;
	}
	public void setFileSaveDate(Date fileSaveDate) {
		this.fileSaveDate = fileSaveDate;
	}
    
    
    
}
