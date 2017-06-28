package com.kitri.factory;

import com.kitri.action.Action;
import com.kitri.reboard.action.*;


public class BoardActionFactory {
	
	private static Action reboardWriteAction;
	private static Action reboardViewAction;
	private static Action reboardListAction;
	private static Action reboardReplyAction;
	private static Action reboardModifyAction;
	private static Action reboardDeleteAction;
	private static Action reboardMoveReplyAction;
	
	static {
		reboardWriteAction = new ReboardWriteAction();
		reboardViewAction = new ReboardViewAction();
		reboardListAction = new ReboardListAction();
		reboardReplyAction = new ReboardReplyAction();
		reboardModifyAction = new ReboardModifyAction();
		reboardDeleteAction = new ReboardDeleteAction();
		reboardMoveReplyAction = new ReboardMoveReplyAction();
	}

	public static Action getReboardWriteAction() {
		return reboardWriteAction;
	}

	public static Action getReboardViewAction() {
		return reboardViewAction;
	}

	public static Action getReboardListAction() {
		return reboardListAction;
	}

	public static Action getReboardReplyAction() {
		return reboardReplyAction;
	}

	public static Action getReboardModifyAction() {
		return reboardModifyAction;
	}

	public static Action getReboardDeleteAction() {
		return reboardDeleteAction;
	}

	public static Action getReboardMoveReplyAction() {
		return reboardMoveReplyAction;
	}
	
}
