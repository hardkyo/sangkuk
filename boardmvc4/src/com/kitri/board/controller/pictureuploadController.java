package com.kitri.board.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jws.WebService;
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
public class pictureuploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String saveDirectory;
	private int maxPostSize;
	private String encoding;
	
	public void init(ServletConfig config){
		ServletContext context = config.getServletContext();
		saveDirectory = context.getRealPath("/upload/album");
		maxPostSize = 3*1024*1024;
		encoding = BoardConstance.DEFAULT_CHAR_SET;
		System.out.println(saveDirectory);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DateFormat df = new SimpleDateFormat("yyMMdd");
		String today = df.format(new Date());
		String upfolder = saveDirectory+File.separator+ today;
		File folder = new File(upfolder);
		if(!folder.exists()){
			folder.mkdirs();
		}
		MultipartRequest multi = new MultipartRequest(request, upfolder, maxPostSize, encoding, new DefaultFileRenamePolicy());
		String opic= multi.getOriginalFileName("picturename");
		String spic = multi.getFilesystemName("picturename");
		String act = multi.getParameter("act");
		System.out.println(">>"+opic);
		System.out.println(">>"+spic);
		HttpSession session = request.getSession(); // session 생성
		MemberDto memberDto = (MemberDto) session.getAttribute("loginInfo");
		String path = "/index.jsp"; //원래는 login.jsp지만 없으므로 index
		
		if (memberDto != null) { // 로그인을 했다면 - 하지마!! feat 빡구
			int seq = CommonServiceImpl.getCommonService().getNextSeq(); // 글 번호 얻기 db에서
			
			AlbumDto albumDto = new AlbumDto();
			albumDto.setSeq(seq); // 글번호 얻어오는 이유는 작성한 글 확인을 눌렀을 때, 작성한 글을 보려면 글 번호가 필요함
			albumDto.setId(memberDto.getId()); // session
			albumDto.setName(memberDto.getName()); // session
			albumDto.setEmail(memberDto.getEmail1() + "@" + memberDto.getEmail2()); // session
			albumDto.setSubject(multi.getParameter("subject")); // parameter
			albumDto.setContent(multi.getParameter("content")); // parameter
			albumDto.setBcode(NumberCheck.nullToZero(multi.getParameter("bcode"))); // parameter
			albumDto.setOrignPicture(multi.getOriginalFileName("picturename"));
			albumDto.setSavePicture(multi.getFilesystemName("picturename"));
			albumDto.setSaveFolder(today);
//			albumDto.setRef(seq); // 새글일때는 ref(그룹번호)를 seq와 같게 설정.
			
			int cnt = AlbumServiceImpl.getAlbumService().writeArticle(albumDto);
			if (cnt != 0) {
				// bcode, pg, key, word는 queryString으로 넘기고, 나머지는 request나 session에 받아서 넘기자
				request.setAttribute("seq", seq +""); // 형변환하기 귀찮으니까... 귀찮으면 때려쳐!!!!!!
				path = "album/writeOk.jsp"; // 주소는 대문자 소문자 구분함, 글번호 가져가야함 ( 작성한 글 확인 ), bcode, pg, key, word
				
			} else
				path = "album/writeFail.jsp";
		} PageMove.forward(path, request, response);
	}

}
