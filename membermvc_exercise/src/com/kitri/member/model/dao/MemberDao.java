package com.kitri.member.model.dao;

import java.util.List;

import com.kitri.member.model.MemberDetailDto;
import com.kitri.member.model.ZipDto;

public interface MemberDao {
	int idcheck(String id);
	List<ZipDto> zipsearch(String dong);
	int register(MemberDetailDto memberDetailDto);
	int login(String id, String pass);
	MemberDetailDto getMember(String id);
	int modify(MemberDetailDto memberDetailDto);
	int delete(String id);
}
