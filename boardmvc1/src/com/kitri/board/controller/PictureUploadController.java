package com.kitri.board.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.kitri.board.model.AlbumDto;
import com.kitri.board.model.ReboardDto;
import com.kitri.board.service.*;
import com.kitri.member.model.MemberDto;
import com.kitri.util.*;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/picture")
public class PictureUploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String saveDirectory;
	private int maxPostSize;
	private String encoding;
	
	public void init(ServletConfig config) {
		ServletContext context = config.getServletContext();
		saveDirectory = context.getRealPath("/upload/album");
//		System.out.println(">>" + saveDirectory);
		maxPostSize = 3 * 1024 * 1024;
		encoding = BoardConstance.DEFAULT_CHAR_SET;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DateFormat df = new SimpleDateFormat("yyMMdd");
		String today = df.format(new Date());
		String upfolder = saveDirectory + File.separator + today;
		File folder = new File(upfolder);
		if(!folder.exists()) {
			folder.mkdirs();
		}		
		
		MultipartRequest multi = new MultipartRequest(request, upfolder, maxPostSize, encoding, new DefaultFileRenamePolicy());
		
		String act = multi.getParameter("act");
		
		HttpSession session = request.getSession();//session 생성
		MemberDto memberDto = (MemberDto) session.getAttribute("loginInfo");//session에서 MemberDto get
		
		String path = "/index.jsp";
		if(memberDto != null) {//로그인 했다면.
			int seq = CommonServiceImpl.getCommonService().getNextSeq();//글번호 얻기
			
			AlbumDto albumDto = new AlbumDto();
			albumDto.setSeq(seq);
			albumDto.setId(memberDto.getId());
			albumDto.setName(memberDto.getName());
			albumDto.setEmail(memberDto.getEmail1() + "@" + memberDto.getEmail2());
			albumDto.setSubject(multi.getParameter("subject"));
			albumDto.setContent(multi.getParameter("content"));
			albumDto.setBcode(NumberCheck.nullToZero(multi.getParameter("bcode")));
			albumDto.setOrignPicture(multi.getOriginalFileName("picturename"));
			albumDto.setSavePicture(multi.getFilesystemName("picturename"));
			albumDto.setSaveFolder(today);
			
			int cnt = AlbumServiceImpl.getAlbumService().writeArticle(albumDto);
			if(cnt != 0) {
				request.setAttribute("seq", seq + "");
				path = "/album/writeOk.jsp";
			} else {
				path = "/album/writeFail.jsp";
			}
		}
		PageMove.forward(path, request, response);
	}

}








