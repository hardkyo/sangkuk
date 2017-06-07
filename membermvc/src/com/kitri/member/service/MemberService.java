package com.kitri.member.service;

import java.util.List;

import com.kitri.member.model.MemberDetailDto;
import com.kitri.member.model.MemberDto;
import com.kitri.member.model.ZipDto;

public interface MemberService {
	
	int idChech(String id);
	List<ZipDto> zipSearch(String dong); //������ȣ
	int register(MemberDetailDto memberdetaildto);
	
	MemberDto login(String id, String pass);
	
	MemberDetailDto getMember(String id);
	int modify(MemberDetailDto memberdetaildto);
	int delete(String id);
}
