package com.kitri.board.service;

import com.kitri.util.PageNavigation;

public interface CommonService {

	int getNextSeq(); // �۹�ȣ ���� �޼ҵ�
	
	PageNavigation makePageNavigation(int bcode, int pg, String key, String word); // pagenavigation���� ����¡ ó�� ���ִ°� ��

}