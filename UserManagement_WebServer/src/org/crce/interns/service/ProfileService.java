/**
 * @author Nevil Dsouza
 *
 *	Profile Service
 *	DEPENDENCIES: UpdateProfileController, Profile, ProfileDAO
 *
 */

package org.crce.interns.service;

import org.crce.interns.dao.ProfileDAO;
import org.crce.interns.model.*;
import org.springframework.stereotype.Service;

@Service("profileService")
public interface ProfileService {

	
	public UserDetails getProfile(UserDetails userDetails);
		
	public ProfessionalProfile getProfile(ProfessionalProfile professionalProfile);
	
	public PersonalProfile getProfile(PersonalProfile personalProfile);
	
	public ProfessionalProfile updateProfessionalProfile(ProfessionalProfile professionalProfile);
	
	public PersonalProfile updatePersonalProfile(PersonalProfile personalProfile);
		
	public UserDetails updateUserDetails(UserDetails userDetails);

}
