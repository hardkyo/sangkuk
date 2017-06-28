package com.kitri.board.admin.dao;

import java.util.List;

import com.kitri.admin.board.model.*;

public interface BoardAdminDao {

	List<BoardListDto> boardList();
	List<CategoryDto> categoryList();
	void categoryMake(String cname);
	List<BoardTypeDto> boardTypeList();
	void boardMake(BoardListDto boardListDto);
	
}
