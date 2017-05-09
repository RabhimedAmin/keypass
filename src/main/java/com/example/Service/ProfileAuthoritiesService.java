package com.example.Service;

import com.example.model.ProfileAuthorities;

public interface ProfileAuthoritiesService
{

	ProfileAuthorities createProfile(ProfileAuthorities profile);

	void removePorfile(Long id);
	
}
