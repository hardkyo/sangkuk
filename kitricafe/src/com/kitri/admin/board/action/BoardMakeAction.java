package com.kitri.admin.board.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.action.Action;
import com.kitri.admin.board.model.BoardListDto;
import com.kitri.admin.board.service.BoardAdminServiceImpl;
import com.kitri.util.Encoding;

public class BoardMakeAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardListDto boardListDto = new BoardListDto();
		boardListDto.setCcode(Integer.parseInt(request.getParameter("ccode")));
		boardListDto.setBtype(Integer.parseInt(request.getParameter("btype")));
		boardListDto.setBname(Encoding.isoToEuc(request.getParameter("bname")));
		
		BoardAdminServiceImpl.getBoardAdminService().boardMake(boardListDto);
		return "/index.jsp";
	}

}
