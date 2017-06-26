package com.kitri.admin.board.service;

import java.util.List;

import com.kitri.admin.board.model.*;

public interface BoardAdminService {

	List<BoardListDto> boardList(); // 모든 게시판 가져오는거니까 인자값은 필요없음
	List<CategoryDto>categoryList();
	void categoryMake(String cname);
	List<BoardTypeDto> boardTypeList();
	void boardMake(BoardListDto boardListDto);
}
