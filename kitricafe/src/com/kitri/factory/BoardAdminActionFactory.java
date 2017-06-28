package com.kitri.factory;

import com.kitri.action.Action;
import com.kitri.admin.board.action.*;

public class BoardAdminActionFactory {

	private static Action boardListAction;
	private static Action boardMakeAction;
	private static Action boardTypeListAction;
	private static Action categoryListAction;
	private static Action categoryMakeAction;

	static {
		boardListAction = new BoardListAction();
		boardMakeAction = new BoardMakeAction();
		boardTypeListAction = new BoardTypeListAction();
		categoryListAction = new CategoryListAction();
		categoryMakeAction = new CategoryMakeAction();
	}

	public static Action getBoardListAction() {
		return boardListAction;
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

}
