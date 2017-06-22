package com.kitri.factory;

import com.kitri.action.Action;
import com.kitri.admin.board.action.BoardListAction;
// �����̴�. ���������� action�� �ϳ���. �׸��� get��.
public class BoardAdminActionFactory {
	
	private static Action boardListAction; //BoardListAction�� ��ü�� ���������� ����
	
	static {
		boardListAction = new BoardListAction(); // ������ ȣ�� 
	}
	
	public static Action getBoardListAction() { //���ͻ���
		return boardListAction;
	}
	
}
