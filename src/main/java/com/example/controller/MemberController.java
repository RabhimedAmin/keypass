package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.Service.MemberService;
import com.example.Service.ProfileAuthoritiesService;
import com.example.business.MemberDto;
import com.example.model.Member;
import com.example.model.ProfileAuthorities;
import com.example.model.Resource;
import com.example.repository.ProfileAuthoritiesRepository;

@RestController("/agents")
@RequestMapping("/agents")
public class MemberController
{
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private ProfileAuthoritiesService profileAuthoritiesService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Member> getAgentById(
			@PathVariable("id") final Long agentId)
	{
		Member searchedAgent = memberService.getAgent(agentId);
		return new ResponseEntity<>(searchedAgent, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Member>> getAllAgent()
	{
		List<Member> searchedAgent = memberService.getAllAgents();
		return new ResponseEntity<>(searchedAgent, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String createAgent(@RequestBody MemberDto member)
	{
		Member model = memberService.createNewMember(member.toModel(),
				member.getProfileAutoritiesId());
		return "redirect:/agent/" + model.getId();
	}
	
	@RequestMapping(value = "/agent/{id}", method = RequestMethod.PUT)
	public String update(@RequestBody Member member)
	{
		memberService.modifyAgent(member);
		return "redirect:/agent/" + member.getId();
		
	}
	
	@RequestMapping(value = "/agent/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable Long id)
	{
		memberService.deleteAgent(id);
		return "redirect:/agents";
	}
	
	// @RequestMapping(value ="/agent/", method = RequestMethod.GET)
	// public String getAgentName (String name)
	// {
	// agentService.getAgentByName(name);
	// return "redirect:/agents";
	// }
	@RequestMapping(value = "/byname", method = RequestMethod.GET)
	public ResponseEntity<Member> getAgentName(String name, String password)
	{
		Member searchedAgent = memberService.getAgentByName(name, password);
		return new ResponseEntity<>(searchedAgent, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/manager/{id}", method = RequestMethod.DELETE)
	public String RevokeManager(@PathVariable("id") Resource r,
			@RequestBody Member member)
	{
		memberService.deleteResourceManager(member, r);
		;
		return "redirect:/agents";
	}
	
	@RequestMapping(value = "/manager/{id}", method = RequestMethod.POST)
	public String GrantManager(@PathVariable("id") Resource r,
			@RequestBody Member member)
	{
		memberService.addResourceManager(member, r);
		return "redirect:/agent/" + r.getId();
	}
	
	@RequestMapping(value = "/prfile/{id}", method = RequestMethod.POST)
	public String addProfile(@RequestBody ProfileAuthorities profile)
	{
		profileAuthoritiesService.createProfile(profile);
		return "redirect:/profile/" + profile.getId();
	}
	
	@RequestMapping(value = "/profile/{id}", method = RequestMethod.DELETE)
	public String deleteProfile(@PathVariable Long id)
	{
		profileAuthoritiesService.removePorfile(id);
		return "redirect:/agents";
	}
}
