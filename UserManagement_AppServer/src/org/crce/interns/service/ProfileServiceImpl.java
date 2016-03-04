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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("profileService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ProfileService {

	@Autowired
	private ProfileDAO profileDAO;
	
	
	/**	GET details from database
	*	
	*	Calls DAO to get details of user
	*	@param	Profile user
	*	@return Profile result 
	*
	*/
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public UserDetails getProfile(UserDetails userDetails) {
		//Profile result = profileDAO.getProfile(user);
		UserDetails result = profileDAO.getProfile(userDetails);
		
		if(result == null){
			System.out.println("Returned NULL");
		}		
		
		return result;
	}
	
	/**	GET details from database
	*	
	*	Calls DAO to get details of user
	*	@param	Profile user
	*	@return Profile result 
	*
	*/
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public ProfessionalProfile getProfile(ProfessionalProfile professionalProfile) {
		//Profile result = profileDAO.getProfile(user);
		ProfessionalProfile result = profileDAO.getProfile(professionalProfile);
		
		if(result == null){
			System.out.println("Returned NULL");
		}		
		
		return result;
	}
	
	/**	GET details from database
	*	
	*	Calls DAO to get details of user
	*	@param	Profile user
	*	@return Profile result 
	*
	*/
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public PersonalProfile getProfile(PersonalProfile personalProfile) {
		//Profile result = profileDAO.getProfile(user);
		PersonalProfile result = profileDAO.getProfile(personalProfile);
		
		if(result == null){
			System.out.println("Returned NULL");
		}		
		
		return result;
	}	
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public ProfessionalProfile updateProfessionalProfile(ProfessionalProfile professionalProfile) {
		
		ProfessionalProfile result = profileDAO.updateProfessionalProfile(professionalProfile);
		
		
		if(result == null){
			System.out.println("Returned NULL");
		}
		
		
		return result;
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public PersonalProfile updatePersonalProfile(PersonalProfile personalProfile) {
		
		PersonalProfile result = profileDAO.updatePersonalProfile(personalProfile);
		
		
		if(result == null){
			System.out.println("Returned NULL");
		}
		
		
		return result;
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public UserDetails updateUserDetails(UserDetails userDetails) {
		
		UserDetails result = profileDAO.updateUserDetails(userDetails);
		
		
		if(result == null){
			System.out.println("Returned NULL");
		}
		
		
		return result;
	}
}
