package com.kitri.admin.board.service;

import java.util.List;

import com.kitri.admin.board.model.BoardListDto;
import com.kitri.board.admin.dao.BoardAdminDaoImpl;

public class BoardAdminServiceImpl implements BoardAdminService{
	// �̱��� - �ܺο��� �������Ѵ�. ���ο��� �����. �ϳ��� �����. �ܺο��� ���ٶ����� ����.
	
	private static BoardAdminService boardAdminService; // 2. �������� ��ü����.
	
	static{ //3. static block �ʱ�ȭ -> ������ ȣ��
		boardAdminService= new BoardAdminServiceImpl();
	}
	
	public static BoardAdminService getBoardAdminService() { //�ܺ� ���� ����� ���� ���͸� ��� (���ʹ� ���� ������ �ʿ䰡 ���⿡, ������ ������ �ʴ´�, -- �޸𸮸� �����ϰ� ��)
		return boardAdminService; 
	}
	
	private BoardAdminServiceImpl() {} // 1. �����ڸ� ����� private ����
	
	@Override
	public List<BoardListDto> boardList() {
		
		return BoardAdminDaoImpl.getBoardAdminDao().boardList(); // SQL������ �ۼ��Ǿ�, DB���۵� ������� ���Ͻ��� ���񽺿��� ����.
	}

}
