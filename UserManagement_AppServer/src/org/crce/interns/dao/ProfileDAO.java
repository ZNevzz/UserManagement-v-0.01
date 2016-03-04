/**
 * @author Nevil Dsouza
 *
 *	Profile DAO
 *	DEPENDENCIES: ProfileService, UpdateProfileController, Profile
 */
package org.crce.interns.dao;

import org.crce.interns.model.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("profileDao")
public class ProfileDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	/*
	public void addProfile(Profile user) {
		sessionFactory.getCurrentSession().save(user);
	}*/
	
	
	/**	GET details from database
	*	
	*	@param	Profile user
	*	@return Profile result 
	*
	*/
	public UserDetails getProfile(UserDetails user) {
		System.out.println("before get");
		UserDetails result = (UserDetails)sessionFactory.getCurrentSession().get(UserDetails.class, user.getUsername());
		System.out.println("after get");
		return result;
	}
	
	/**	GET details from database
	*	
	*	@param	Profile user
	*	@return Profile result 
	*
	*/
	public ProfessionalProfile getProfile(ProfessionalProfile professionalProfile) {
		System.out.println("before get");
		ProfessionalProfile result = (ProfessionalProfile)sessionFactory.getCurrentSession().get(ProfessionalProfile.class, professionalProfile.getUsername());
		System.out.println("after get");
		return result;
	}
	
	/**	GET details from database
	*	
	*	@param	Profile user
	*	@return Profile result 
	*
	*/
	public PersonalProfile getProfile(PersonalProfile personalProfile) {
		System.out.println("before get");
		PersonalProfile result = (PersonalProfile)sessionFactory.getCurrentSession().get(PersonalProfile.class, personalProfile.getUsername());
		System.out.println("after get");
		return result;
	}
		
	
	

	
	/**	POST details to database
	*	
	*	@param	Profile user,String update
	*	@return Profile result 
	*	
	*	@Exception cannot update primary keys
	*/
	public Profile updateProfile(Profile user,String update) {
		// get user and store in Profile result
		Profile result = (Profile)sessionFactory.getCurrentSession().get(Profile.class, user.getId());
			System.out.println(result.getName());
		
		// update name of Profile result
		result.setName(update);
			System.out.println(result.getName());
		
		// update Profile result in database
		sessionFactory.getCurrentSession().update(result);
		
		result = (Profile)sessionFactory.getCurrentSession().get(Profile.class, result.getId());
		return result;
	}
	
	/**	POST details to database
	*	
	*	@param	Profile user,String update
	*	@return Profile result 
	*	
	*	@Exception cannot update primary keys
	*/
	public Profile updateProfileByBean(Profile user) {
		// get user and store in Profile result
		//Profile result = (Profile)sessionFactory.getCurrentSession().get(Profile.class, user.getId());
			//System.out.println(result.getName());
		
		// update name of Profile result
		//result.setName(update);
			//System.out.println(result.getName());
		
		// update Profile result in database
		sessionFactory.getCurrentSession().update(user);
		
		Profile result = (Profile)sessionFactory.getCurrentSession().get(Profile.class, user.getId());
		return result;
	}
	
	
	public ProfessionalProfile updateProfessionalProfile(ProfessionalProfile professionalProfile) {
		
		sessionFactory.getCurrentSession().update(professionalProfile);
		
		ProfessionalProfile result = (ProfessionalProfile)sessionFactory.getCurrentSession().get(ProfessionalProfile.class, professionalProfile.getUsername());
		
		return result;
	}
	
	public PersonalProfile updatePersonalProfile(PersonalProfile personalProfile) {
		
		sessionFactory.getCurrentSession().update(personalProfile);
		
		PersonalProfile result = (PersonalProfile)sessionFactory.getCurrentSession().get(PersonalProfile.class, personalProfile.getUsername());
		
		return result;
	}
	
	
}
