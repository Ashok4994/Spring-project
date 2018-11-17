package com.ashok.location.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ashok.location.entities.Location;
import com.ashok.location.service.LocationService;

@Controller
public class LocationController {

	@Autowired
	LocationService service;
	@RequestMapping("/showCreate")
	public String showCreate() {
		 return "location";
	}
	
	@RequestMapping("/saveLoc")
	public String saveLocation(@ModelAttribute("location") Location location,ModelMap modelMap) {
		Location locSaved = service.saveLocation(location);
		String msg = "Location saved with id:" + locSaved.getId();
		modelMap.addAttribute("msg",msg);
		return "location";
	}

	@RequestMapping("/dispalyLocations")
public String dispalyLocations(ModelMap modelMap) {
	List<Location> locations = service.getAllLocations();
	modelMap.addAttribute("locations",locations);
	return "displayLocations";
}
	
@RequestMapping("deleteLocation")	
public String deleteLocation(@RequestParam("id") int id,ModelMap modelMap) {
	//Location location = service.getLocationById(id);
	Location location = new Location();
	location.setId(id);
	service.deleteLocation(location);
	List<Location> locations = service.getAllLocations();
	modelMap.addAttribute("locations",locations);	
	return "displayLocations";
}

@RequestMapping("/updateLocation")
public String showUpdate(@RequestParam("id") int id,ModelMap modelMap) {
	Optional<Location> location = service.getLocationById(id);
	if (location.isPresent()) {
	    modelMap.addAttribute("location", location.get());
	}
	//modelMap.addAttribute("location",location);
	modelMap.addAttribute("name","ashok");
	return "editLocation";
}

@RequestMapping("/updateLoc")
public String updateLocation(@ModelAttribute("location") Location location,ModelMap modelMap) {
	Location locUpdated = service.updateLocation(location);
	String msg = "Location updated with id:" + locUpdated.getId();
	List<Location> locations = service.getAllLocations();
	modelMap.addAttribute("locations",locations);
	//modelMap.addAttribute("msg",msg);
	return "displayLocations";
}
}

