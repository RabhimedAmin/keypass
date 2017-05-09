package com.example.Service;

import java.util.List;

import com.example.model.Member;
import com.example.model.Resource;

public interface MemberService {

	public Member createAgent(Member member);
	
	void deleteAgent(long id);

	Member modifyAgent(Member member);

	List<Member> getAllAgents();

	Member getAgent(long id);

	
	

	Member getAgentByName(String name,String password);

	Member addResourceManager(Member member, Resource resource);

	void deleteResourceManager(Member member, Resource resource);

	public Member createNewMember(Member model, Long profileAutoritiesId);

	
}
