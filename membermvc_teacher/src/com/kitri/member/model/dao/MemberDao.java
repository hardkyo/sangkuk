package com.kitri.member.model.dao;

import java.util.List;
import java.util.Map;

import com.kitri.member.model.*;

public interface MemberDao {

	int idCheck(String id);
	List<ZipDto> zipSearch(String dong);
	int register(MemberDetailDto mddto);
	
	MemberDto login(Map<String, String> map);
	
	MemberDetailDto getMember(String id);
	int modify(MemberDetailDto mddto);
	int delete(String id);
}
