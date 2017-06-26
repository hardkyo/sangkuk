package com.kitri.admin.board.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.action.Action;
import com.kitri.admin.board.service.BoardAdminServiceImpl;
import com.kitri.util.Encoding;

public class CategoryMakeAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cname = Encoding.isoToEuc(request.getParameter("cname"));
		BoardAdminServiceImpl.getBoardAdminService().categoryMake(cname);
		return "/index.jsp";
	}

}
