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
		HttpSession session = request.getSession(); // session ����
		MemberDto memberDto = (MemberDto) session.getAttribute("loginInfo");
		String path = "/index.jsp"; //������ login.jsp���� �����Ƿ� index
		
		if (memberDto != null) { // �α����� �ߴٸ� - ������!! feat ����
			int seq = CommonServiceImpl.getCommonService().getNextSeq(); // �� ��ȣ ��� db����
			
			AlbumDto albumDto = new AlbumDto();
			albumDto.setSeq(seq); // �۹�ȣ ������ ������ �ۼ��� �� Ȯ���� ������ ��, �ۼ��� ���� ������ �� ��ȣ�� �ʿ���
			albumDto.setId(memberDto.getId()); // session
			albumDto.setName(memberDto.getName()); // session
			albumDto.setEmail(memberDto.getEmail1() + "@" + memberDto.getEmail2()); // session
			albumDto.setSubject(multi.getParameter("subject")); // parameter
			albumDto.setContent(multi.getParameter("content")); // parameter
			albumDto.setBcode(NumberCheck.nullToZero(multi.getParameter("bcode"))); // parameter
			albumDto.setOrignPicture(multi.getOriginalFileName("picturename"));
			albumDto.setSavePicture(multi.getFilesystemName("picturename"));
			albumDto.setSaveFolder(today);
//			albumDto.setRef(seq); // �����϶��� ref(�׷��ȣ)�� seq�� ���� ����.
			
			int cnt = AlbumServiceImpl.getAlbumService().writeArticle(albumDto);
			if (cnt != 0) {
				// bcode, pg, key, word�� queryString���� �ѱ��, �������� request�� session�� �޾Ƽ� �ѱ���
				request.setAttribute("seq", seq +""); // ����ȯ�ϱ� �������ϱ�... �������� ������!!!!!!
				path = "album/writeOk.jsp"; // �ּҴ� �빮�� �ҹ��� ������, �۹�ȣ ���������� ( �ۼ��� �� Ȯ�� ), bcode, pg, key, word
				
			} else
				path = "album/writeFail.jsp";
		} PageMove.forward(path, request, response);
	}

}
