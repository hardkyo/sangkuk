package com.kitri.admin.board.service;

import java.util.List;

import com.kitri.admin.board.dao.BoardAdminDaoImpl;
import com.kitri.admin.board.model.*;
import com.kitri.reboard.action.ReboardDeleteAction;

public class BoardAdminServiceImpl implements BoardAdminService {
	private static BoardAdminService boardAdminService; // 2. 자기 자신을 리턴하는 거 만들기 (외부에서 생성 x )
	
	static { // static 블록 초기화 
		boardAdminService =new BoardAdminServiceImpl(); // 3. static으로 하면 모든 프로젝트를 통틀어서 하나의 객체만 만들어짐 ( singleton pattern )
	}

	public static BoardAdminService getBoardAdminService() { //4. action에서 사용해야 하니까 getter 만들기 
		return boardAdminService;
	}

	private BoardAdminServiceImpl() {}; // 1. private으로 생성자 막기 (외부에서 생성 x)
	@Override
	public List<BoardListDto> boardList() {
		return BoardAdminDaoImpl.getBoardAdminDao().boardList();
	}

	@Override
	public List<CategoryDto> categoryList() {
		return BoardAdminDaoImpl.getBoardAdminDao().categoryList();
	}

	@Override
	public void categoryMake(String cname) {
		BoardAdminDaoImpl.getBoardAdminDao().categoryMake(cname);
	}

	@Override
	public List<BoardTypeDto> boardTypeList() {
		return BoardAdminDaoImpl.getBoardAdminDao().boardTypeList();
	}

	@Override
	public void boardMake(BoardListDto boardListDto) {
		BoardAdminDaoImpl.getBoardAdminDao().boardMake(boardListDto);;
		
	}
}
