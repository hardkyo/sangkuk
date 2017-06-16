package com.kitri.member.model.service;

import java.util.List;

import com.kitri.member.model.MemberDetailDto;
import com.kitri.member.model.MemberDto;
import com.kitri.member.model.ZipDto;
import com.kitri.member.model.dao.MemberDao;
import com.kitri.member.model.dao.MemberDaoImpl;

public class MemberServiceImpl implements MemberService {

	private MemberDao memberDao;
	
	public MemberServiceImpl() {
		memberDao = new MemberDaoImpl();
	} 
	
	@Override
	public int idcheck(String id) {
		return memberDao.idcheck(id);
	}

	@Override
	public List<ZipDto> zipsearch(String dong) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int register(MemberDetailDto memberDetaildto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemberDto login(String id, String pass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberDetailDto getMember(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int modify(MemberDetailDto memberDetailDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
