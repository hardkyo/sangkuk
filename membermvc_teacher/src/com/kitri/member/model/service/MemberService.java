package com.kitri.member.model.service;

import java.util.List;

import com.kitri.member.model.*;

public interface MemberService {

	int idCheck(String id);
	List<ZipDto> zipSearch(String dong);
	int register(MemberDetailDto mddto);
	
	MemberDto login(String id,String pass);
	
	MemberDetailDto getMember(String id);
	int modify(MemberDetailDto mddto);
	int delete(String id);
	
}
