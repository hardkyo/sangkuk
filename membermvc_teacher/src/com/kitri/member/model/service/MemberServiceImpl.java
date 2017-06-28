package com.kitri.member.model.service;

import java.util.*;

import com.kitri.member.model.*;
import com.kitri.member.model.dao.MemberDao;
import com.kitri.member.model.dao.MemberDaoImpl;

public class MemberServiceImpl implements MemberService {

	private MemberDao memberDao;
	
	public MemberServiceImpl() {
		memberDao = new MemberDaoImpl();
	
	}
	@Override
	public int idCheck(String id) {
		return memberDao.idCheck(id);
	}

	@Override
	public List<ZipDto> zipSearch(String dong) {
		return memberDao.zipSearch(dong);
	}

	@Override
	public int register(MemberDetailDto mddto) {
		return memberDao.register(mddto);
	}

	@Override
	public MemberDto login(String id, String pass) {
		Map<String, String> map = new HashMap<String,String>();
		map.put("userid", id);
		map.put("userpwd", pass);
		return memberDao.login(map);
	}

	@Override
	public MemberDetailDto getMember(String id) {
		return memberDao.getMember(id);
	}

	@Override
	public int modify(MemberDetailDto mddto) {

		return memberDao.modify(mddto);
	}

	@Override
	public int delete(String id) {

		return memberDao.delete(id);
	}

}
