package com.kitri.member.model.service;

import java.util.List;

import com.kitri.member.model.MemberDetailDto;
import com.kitri.member.model.MemberDto;
import com.kitri.member.model.ZipDto;

public interface MemberService {
	int idcheck(String id);
	List <ZipDto> zipsearch(String dong);
	int register(MemberDetailDto memberDetaildto);
	MemberDto login(String id, String pass);
	MemberDetailDto getMember(String id);
	int modify(MemberDetailDto memberDetailDto);
	int delete(String id);
}
