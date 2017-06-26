package com.kitri.admin.board.service;

import java.util.List;

import com.kitri.admin.board.model.*;

public interface BoardAdminService {

	List<BoardListDto> boardList(); // ��� �Խ��� �������°Ŵϱ� ���ڰ��� �ʿ����
	List<CategoryDto>categoryList();
	void categoryMake(String cname);
	List<BoardTypeDto> boardTypeList();
	void boardMake(BoardListDto boardListDto);
}
