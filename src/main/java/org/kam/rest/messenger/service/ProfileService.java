package org.kam.rest.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.kam.rest.messenger.database.DatabaseClass;
import org.kam.rest.messenger.model.Profile;

public class ProfileService {
	
	private Map<Long, Profile> profiles = DatabaseClass.getProfiles();

	public List<Profile> getAllprofiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(long id)
	{
		return profiles.get(id);
		
	}
	
	public Profile addProfile(Profile Profile){
		Profile.setId(profiles.size() + 1);
		profiles.put(Profile.getId(), Profile);
		return Profile;
	}
	
	public Profile updateProfile(Profile Profile)
	{
		if (Profile.getId() <= 0)
		{
			return null;
		}
		profiles.put(Profile.getId(), Profile);
		return Profile;
	}
	
	public Profile removeProfile(long id)
	{
		return profiles.remove(id);		
	}
}
