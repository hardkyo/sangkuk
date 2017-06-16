package com.kitri.admin.board.service;

import java.util.List;

import com.kitri.admin.board.model.BoardListDto;
import com.kitri.board.admin.dao.BoardAdminDaoImpl;

public class BoardAdminServiceImpl implements BoardAdminService{
	// 싱글톤 - 외부에서 생성못한다. 내부에서 만든다. 하나만 만든다. 외부에서 접근때문에 게터.
	
	private static BoardAdminService boardAdminService; // 2. 전역변수 객체생성.
	
	static{ //3. static block 초기화 -> 생성자 호출
		boardAdminService= new BoardAdminServiceImpl();
	}
	
	public static BoardAdminService getBoardAdminService() { //외부 서비스 사용을 위해 게터만 사용 (세터는 값을 지정할 필요가 없기에, 별도로 만들지 않는다, -- 메모리만 차지하게 됨)
		return boardAdminService; 
	}
	
	private BoardAdminServiceImpl() {} // 1. 생성자를 만들어 private 막음
	
	@Override
	public List<BoardListDto> boardList() {
		
		return BoardAdminDaoImpl.getBoardAdminDao().boardList(); // SQL쿼리가 작성되어, DB동작된 결과값을 리턴시켜 서비스에서 받음.
	}

}
