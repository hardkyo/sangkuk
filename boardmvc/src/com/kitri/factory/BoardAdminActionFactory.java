package com.kitri.factory;

import com.kitri.action.Action;
import com.kitri.admin.board.action.BoardListAction;
// 공장이다. 여러개만들어도 action은 하나만. 그리고 get만.
public class BoardAdminActionFactory {
	
	private static Action boardListAction; //BoardListAction의 객체를 전역변수로 생성
	
	static {
		boardListAction = new BoardListAction(); // 생성자 호출 
	}
	
	public static Action getBoardListAction() { //게터생성
		return boardListAction;
	}
	
}
