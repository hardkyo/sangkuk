package com.kitri.factory;

import com.kitri.action.Action;
import com.kitri.admin.board.action.*;

public class BoardAdminActionFactory {

	private static Action boardListAction;
	private static Action boardMakeAction;
	private static Action boardTypeListAction;
	private static Action categoryListAction;
	private static Action categoryMakeAction;

	static { // class가 읽혀질 때 딱 한번만 생성됨. 다른 곳에서 Factory를 아무리 많이 만들어도 딱 한번만 생성. ( static블록에 넣었을 때 )
		boardListAction = new BoardListAction();
		boardMakeAction = new BoardMakeAction();
		boardTypeListAction = new BoardTypeListAction();
		categoryListAction = new CategoryListAction();
		categoryMakeAction = new CategoryMakeAction();
	}
	public static Action getBoardMakeAction() {
		return boardMakeAction;
	}

	public static Action getBoardTypeListAction() {
		return boardTypeListAction;
	}

	public static Action getCategoryListAction() {
		return categoryListAction;
	}

	public static Action getCategoryMakeAction() {
		return categoryMakeAction;
	}


	public static Action getBoardListAction() {
		return boardListAction;
	} // 가져다 쓰기만 하면 되니까 setter 필요 없음

}
