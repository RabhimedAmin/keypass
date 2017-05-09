package com.example.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.example.Service.MemberService;
import com.example.model.Member;
import com.example.model.ProfileAuthorities;
import com.example.model.Resource;
import com.example.repository.MemberRepository;
import com.example.repository.ProfileAuthoritiesRepository;
import com.example.repository.ResourceRepository;


@Service("agentService")
public class MemberServiceImpl implements MemberService
{
	
	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	ResourceRepository resourceRepository;

	@Autowired
	private ProfileAuthoritiesRepository profileAuthoritiesRepository;
	
	@Override
	public void deleteAgent(long id)
	{
		// TODO Auto-generated method stub
		memberRepository.delete(id);
	}
	
	@Override
	public Member getAgent(long id)
	{
		// TODO Auto-generated method stub
		return memberRepository.findOne(id);
		
	}
	
	@Override
	public List<Member> getAllAgents()
	{
		// TODO Auto-generated method stub
		return memberRepository.findAll();
	}
	
	@Override
	public Member modifyAgent(Member member)
	{
		// TODO Auto-generated method stub
		return memberRepository.save(member);
	}
	
	@Override
	public Member createAgent(Member member)
	{
		// TODO Auto-generated method stub
		return memberRepository.save(member);
		
	}
	
	@Override
	public Member getAgentByName(String name, String password)
	{
		for (Member member : getAllAgents())
		{
			if (member.getName().equals(name)
					&& member.getPassword().equalsIgnoreCase(password))
				return member;
		}
		return null;
	}
	
	public boolean isManager(Resource resource, Member member)
	{
		String MANAGER = "MANAGER";
		return (member.getProfile().getGrantedAuthority().equals(MANAGER));
	}
	
	@Override
	public Member addResourceManager(Member member, Resource resource)
	{
		
		if (isManager(resource, member)
				&& !(resource.getManagers().contains(member)))
		{
			resource.getManagers().add(member);
			resourceRepository.save(resource);
			memberRepository.save(member);
		}
		return member;
	}
	
	@Override
	public void deleteResourceManager(Member member, Resource resource)
	{
		if (isManager(resource, member)
				&& resource.getManagers().contains(member))
		{
			resource.getManagers().remove(member);
			resourceRepository.save(resource);
			memberRepository.save(member);
			
		}
		
	}

	@Override
	@Transactional
	public Member createNewMember(Member model, Long profileAutoritiesId)
	{
		ProfileAuthorities pa = profileAuthoritiesRepository.findOne(profileAutoritiesId);
		Assert.notNull(pa,"profile cannot be null");
		model.setProfile(pa);
		return memberRepository.save(model);
	}
	
}
