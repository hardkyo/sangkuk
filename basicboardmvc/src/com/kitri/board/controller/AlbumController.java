package com.kitri.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.util.BoardConstance;

/**
 * Servlet implementation class AlbumController
 */
@WebServlet("/album")
public class AlbumController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String act = request.getParameter("act");
		String path = "/index.jsp";
		
		if ("mv".equals(act)) {
			
		}else if ("".equals(act)) {
			
		}else if ("".equals(act)) {
			
		}else if ("".equals(act)) {
			
		}else if ("".equals(act)) {
			
		}else if ("".equals(act)) {
			
		}else if ("".equals(act)) {
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding(BoardConstance.DEFAULT_CHAR_SET);
		doGet(request, response);
	}

}
