package com.kitri.member.model.dao;

import java.util.List;

import com.kitri.member.model.MemberDetailDto;
import com.kitri.member.model.MemberDto;
import com.kitri.member.model.ZipDto;
import com.sun.javafx.collections.MappingChange.Map;

public interface MemberDao {
	
	int idChech(String id);
	List<ZipDto> zipSearch(String dong); //우편번호
	int register(MemberDetailDto memberdetaildto);
	
	MemberDto login(Map<String, String> map);
	
	MemberDetailDto getMember(String id);
	int modify(MemberDetailDto memberdetaildto);
	int delete(String id);
}
