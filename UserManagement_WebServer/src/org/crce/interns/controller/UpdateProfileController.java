/**
 * @author Nevil Dsouza
 *
 *	Main controller
 *	DEPENDENCIES: ProfileService, Profile, ProfileDAO
 */
package org.crce.interns.controller;

import org.crce.interns.model.*;
import org.crce.interns.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class UpdateProfileController {
	
	@Autowired
	private ProfileService profileService;
		
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView index() {
		
		System.out.println("Inside Controller");
		
		ModelAndView model=null;
		
		model = new ModelAndView("index");
				
		return model;
	}

	
	/**	GET details from database
	*	
	*	Creates hardcoded user by setName and setID on user.This value is supposed to be retrieved from Session.
	*	This enhancement will be added later
	*	@param	None
	*	@return MOdelAndView viewprofile page with name
	*
	*/
	
	
	
	@RequestMapping(value="/viewprofile.html", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam("id") String id) {
		
		System.out.println("Inside Controller");
		
		ModelAndView model=null;

		
		UserDetails userDetails= new UserDetails();
		userDetails.setUsername(id);
		ProfessionalProfile professionalProfile=new ProfessionalProfile();
		PersonalProfile personalProfile=new PersonalProfile();
		
		
		userDetails.setUsername(id);
		professionalProfile.setUsername(id);
		personalProfile.setUsername(id);
		
		
		userDetails = profileService.getProfile(userDetails);
		professionalProfile = profileService.getProfile(professionalProfile);
		personalProfile = profileService.getProfile(personalProfile);
		
		
		//Profile result = profileService.getProfile(user);
		
		model = new ModelAndView("viewprofile");
		
		model.addObject("userDetails",userDetails);
		model.addObject("professionalProfile",professionalProfile);
		model.addObject("personalProfile",personalProfile);
		
		return model;
	}
	
	
	/**	URL Navigator to editprofile
	*	
	*	Creates hardcoded user by setName and setID on user.This value is supposed to be retrieved from Session.
	*	This enhancement will be added later.
	*	@param	None
	*	@return MOdelAndView editprofile page with name
	*
	*/
	@RequestMapping(value="/editprofile.html", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam("id") String id) {
		
		System.out.println("Inside Controller");
		
		ModelAndView model=null;
		
		UserDetails userDetails= new UserDetails();
		ProfessionalProfile professionalProfile=new ProfessionalProfile();
		PersonalProfile personalProfile=new PersonalProfile();
		
		
		userDetails.setUsername(id);
		professionalProfile.setUsername(id);
		personalProfile.setUsername(id);
		
		
		userDetails = profileService.getProfile(userDetails);
		professionalProfile = profileService.getProfile(professionalProfile);
		personalProfile = profileService.getProfile(personalProfile);
		
		
		//Profile result = profileService.getProfile(user);
		
		model = new ModelAndView("editprofile");
		
		model.addObject("userDetails",userDetails);
		model.addObject("professionalProfile",professionalProfile);
		model.addObject("personalProfile",personalProfile);
		
		return model;
	}
	
		
	
	/**	POST details to database via Profile
	*	
	*	Creates hardcoded user by setName and setID on user.This value is supposed to be retrieved from Session.
	*	This enhancement will be added later.
	*	
	*
	*
	*	@param	String name to be updated
	*	@return MOdelAndView viewprofile page with name
	*
	*/
	@RequestMapping(value="/update-profile.html", method = RequestMethod.POST)
	public ModelAndView updateProfile(@RequestParam("name") String name) {
		
		System.out.println("Inside Controller");
		
		ModelAndView model=null;

		
		Profile user= new Profile();
		user.setName("Nevil");
		user.setId("100");
		

		Profile result = profileService.updateProfile(user,name);
		
		
		model = new ModelAndView("viewprofile");
		
		model.addObject("name",result.getName());
		model.addObject("result",result);
		return model;
	}
	
	
	
	
	
	@RequestMapping(value="/update-profile1.html", method = RequestMethod.POST)
	public ModelAndView updateProfileByBean(@ModelAttribute("userDetails") UserDetails userDetails) {
		
		System.out.println("Inside Controller");
		
		ModelAndView model=null;
		
		//UserDetails userDetails= new UserDetails();
		ProfessionalProfile professionalProfile=new ProfessionalProfile();
		PersonalProfile personalProfile=new PersonalProfile();
				
		professionalProfile.setUsername(userDetails.getUsername());
		personalProfile.setUsername(userDetails.getUsername());
		
		
		
		//userDetails = profileService.updateUserDetails(userDetails);
		//professionalProfile = profileService.updateProfessionalProfile(professionalProfile);
		//personalProfile = profileService.updatePersonalProfile(personalProfile);
		
		
		
		
		//Profile user= new Profile();
		//user.setName("Nevil");
		//user.setId("100");
		

		//Profile result = profileService.updateProfileByBean(user);
		
		
		model = new ModelAndView("viewprofile");
		model.addObject("userDetails",userDetails);
		model.addObject("professionalProfile",professionalProfile);
		model.addObject("personalProfile",personalProfile);
		//model.addObject("name",result.getName());
		//model.addObject("result",result);
		
		return model;
	}
//-----------------------------------------------------------------------------------------//
	@RequestMapping(value="/edit-professional.html", method = RequestMethod.GET)
	public ModelAndView editProfessionalProfile(@RequestParam("id") String id) {
		
		System.out.println("Inside Controller");
		
		ModelAndView model=null;		

		ProfessionalProfile professionalProfile=new ProfessionalProfile();
		PersonalProfile personalProfile=new PersonalProfile();
		
		
		professionalProfile.setUsername(id);
		personalProfile.setUsername(id);

		professionalProfile = profileService.getProfile(professionalProfile);
		personalProfile = profileService.getProfile(personalProfile);
				
		model = new ModelAndView("editprofile");		
		model.addObject("professionalProfile",professionalProfile);
		model.addObject("personalProfile",personalProfile);

		
		return model;
	}

	
	@RequestMapping(value="/update-professional.html", method = RequestMethod.POST)
	public ModelAndView updateProfessionalProfile(@ModelAttribute("professionalProfile")ProfessionalProfile professionalProfileBean) {
		
		System.out.println("Inside Controller");
	
		ModelAndView model=null;
		
		UserDetails userDetails= new UserDetails();
		ProfessionalProfile professionalProfile=new ProfessionalProfile();
		PersonalProfile personalProfile=new PersonalProfile();
		
		professionalProfile = professionalProfileBean;
		
		userDetails.setUsername(professionalProfile.getUsername());		
		personalProfile.setUsername(professionalProfile.getUsername());
		
		
		userDetails = profileService.getProfile(userDetails);		
		personalProfile = profileService.getProfile(personalProfile);		
		
		professionalProfile = profileService.updateProfessionalProfile(professionalProfile);
		
		model = new ModelAndView("viewprofile");
		model.addObject("userDetails",userDetails);
		model.addObject("professionalProfile",professionalProfile);
		model.addObject("personalProfile",personalProfile);			
		
		return model;
	}
	//-----------------------------------------------------------------------------------------//
	@RequestMapping(value="/edit-personal.html", method = RequestMethod.GET)
	public ModelAndView editPersonalProfile(@RequestParam("id") String id) {
		
		System.out.println("Inside Controller");
		
		ModelAndView model=null;		

		ProfessionalProfile professionalProfile=new ProfessionalProfile();
		PersonalProfile personalProfile=new PersonalProfile();
		
		
		professionalProfile.setUsername(id);
		personalProfile.setUsername(id);

		professionalProfile = profileService.getProfile(professionalProfile);
		personalProfile = profileService.getProfile(personalProfile);
				
		model = new ModelAndView("editprofile");		
		model.addObject("professionalProfile",professionalProfile);
		model.addObject("personalProfile",personalProfile);
		
		return model;
	}


	@RequestMapping(value="/update-personal.html", method = RequestMethod.POST)
	public ModelAndView updatePersonalProfile(@ModelAttribute("personalProfile")PersonalProfile personalProfileBean) {
		
		System.out.println("Inside Controller");
	
		ModelAndView model=null;
		
		UserDetails userDetails= new UserDetails();
		ProfessionalProfile professionalProfile=new ProfessionalProfile();
		PersonalProfile personalProfile=new PersonalProfile();
		
		personalProfile = personalProfileBean;
		
		userDetails.setUsername(personalProfile.getUsername());		
		professionalProfile.setUsername(personalProfile.getUsername());
		
		
		userDetails = profileService.getProfile(userDetails);
		professionalProfile = profileService.getProfile(professionalProfile);
		personalProfile = profileService.updatePersonalProfile(personalProfile);
		
						
		
		model = new ModelAndView("viewprofile");
		model.addObject("userDetails",userDetails);
		model.addObject("professionalProfile",professionalProfile);
		model.addObject("personalProfile",personalProfile);			
		
		return model;
	}
	//-----------------------------------------------------------------------------------------//

}


/*

*/