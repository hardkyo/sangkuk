package com.kitri.factory;

import com.kitri.action.Action;
import com.kitri.reboard.action.ReboardDeleteAction;
import com.kitri.reboard.action.ReboardListAction;
import com.kitri.reboard.action.ReboardModifyAction;
import com.kitri.reboard.action.ReboardReplyAction;
import com.kitri.reboard.action.ReboardViewAction;
import com.kitri.reboard.action.ReboardWriteAction;

public class BoardActionFactory {
	// ��Ŭ������ �׼��� ����� �׼��� ��ǰ�ϴ� ����

	private static Action reboardWriteAction;
	private static Action reboardViewAction;
	private static Action reboardListAction;
	private static Action reboardReplyAction;
	private static Action reboardModifyAction;
	private static Action reboardDeleteAction;
	       
	static{
		reboardWriteAction = new ReboardWriteAction(); 
		reboardViewAction = new ReboardViewAction();
		reboardListAction = new ReboardListAction();
		reboardReplyAction = new ReboardReplyAction();
		reboardModifyAction = new ReboardModifyAction();
		reboardDeleteAction = new ReboardDeleteAction();
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
	
	
}
