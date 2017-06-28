package com.kitri.admin.board.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.action.Action;
import com.kitri.admin.board.model.BoardListDto;
import com.kitri.admin.board.service.BoardAdminServiceImpl;

public class BoardListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<BoardListDto> list = BoardAdminServiceImpl.getBoardAdminService().boardList();
		ServletContext application = request.getServletContext();
		application.setAttribute("boardmenu", list);
		return "/index.jsp";
	}

}
