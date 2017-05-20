package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.Service.ProfileAuthoritiesService;
import com.example.model.ProfileAuthorities;

@RestController("/Profils")
@RequestMapping("/Porifls")

public class ProfileAuthoritiesController {

	@Autowired
	ProfileAuthoritiesService profileAuthoritiesService;

	@RequestMapping(value = "/prfile/{id}", method = RequestMethod.POST)
	public String addProfile(@RequestBody ProfileAuthorities profile) {
		profileAuthoritiesService.createProfile(profile);
		return "redirect:/profile/" + profile.getId();
	}

	@RequestMapping(value = "/profile/{id}", method = RequestMethod.DELETE)
	public String deleteProfile(@PathVariable Long id) {
		profileAuthoritiesService.removePorfile(id);
		return "redirect:/members";
	}
}
