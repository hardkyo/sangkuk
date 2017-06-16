package com.kitri.board.admin.dao;

import java.util.List;

import com.kitri.admin.board.model.BoardListDto;

public interface BoardAdminDao {
	List<BoardListDto> boardList();
}
