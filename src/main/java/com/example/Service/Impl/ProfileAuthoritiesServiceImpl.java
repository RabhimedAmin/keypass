package com.example.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Service.ProfileAuthoritiesService;
import com.example.model.ProfileAuthorities;
import com.example.repository.ProfileAuthoritiesRepository;

@Service
public class ProfileAuthoritiesServiceImpl implements ProfileAuthoritiesService
{
	@Autowired
	ProfileAuthoritiesRepository profileAuthoritiesRepository;
	
	@Override
	public ProfileAuthorities createProfile(ProfileAuthorities profile)
	{
		return profileAuthoritiesRepository.save(profile);
	}
	
	@Override
	public void removePorfile(Long id)
	{
		profileAuthoritiesRepository.delete(id);
	}
	
}
