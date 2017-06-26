package com.kitri.admin.board.service;

import java.util.List;

import com.kitri.admin.board.model.*;
import com.kitri.board.admin.dao.BoardAdminDaoImpl;

public class BoardAdminServiceImpl implements BoardAdminService {

	private static BoardAdminService boardAdminService;
	
	static {
		boardAdminService = new BoardAdminServiceImpl();
	}
	
	private BoardAdminServiceImpl() {}
	
	public static BoardAdminService getBoardAdminService() {
		return boardAdminService;
	}

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
		BoardAdminDaoImpl.getBoardAdminDao().boardMake(boardListDto);
	}

}













