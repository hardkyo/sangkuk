package com.kitri.member.service;

import com.kitri.member.model.MemberDetailDto;
import com.kitri.member.model.MemberDto;
import com.kitri.member.model.ZipDto;

public interface MemberService {
	
	int idChech(String id);
	int zipSearch(ZipDto dto);
	int register(MemberDto memberdto, MemberDetailDto memberdetaildto);
	
	int login(String id, String pass);
	
	int getMember(String id);
	int modify(String id);
	int delete(String id);
}
