package com.kitri.admin.board.service;

import java.util.List;

import com.kitri.admin.board.dao.BoardAdminDaoImpl;
import com.kitri.admin.board.model.*;
import com.kitri.reboard.action.ReboardDeleteAction;

public class BoardAdminServiceImpl implements BoardAdminService {
	private static BoardAdminService boardAdminService; // 2. �ڱ� �ڽ��� �����ϴ� �� ����� (�ܺο��� ���� x )
	
	static { // static ��� �ʱ�ȭ 
		boardAdminService =new BoardAdminServiceImpl(); // 3. static���� �ϸ� ��� ������Ʈ�� ��Ʋ� �ϳ��� ��ü�� ������� ( singleton pattern )
	}

	public static BoardAdminService getBoardAdminService() { //4. action���� ����ؾ� �ϴϱ� getter ����� 
		return boardAdminService;
	}

	private BoardAdminServiceImpl() {}; // 1. private���� ������ ���� (�ܺο��� ���� x)
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
