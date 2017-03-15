package com.ewaves.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ewaves.domain.FeatureLookup;
import com.ewaves.service.FeatureService;

@RestController
@RequestMapping("/feature")
public class FeatureController {

	@Autowired
	FeatureService featureService;

	@RequestMapping(value = "/getAllFeatures", method = RequestMethod.GET)
	public List<FeatureLookup> getAllFeatures() {
		return featureService.getFeatures();
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void addFeatue(@RequestBody FeatureLookup feature) {
		featureService.addFeatue(feature);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void updateFeatue(@PathVariable("id") Long id, @RequestBody FeatureLookup feature) {
		featureService.updateFeatue(id, feature);
	}
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteFeature(@PathVariable("id") Long id){
		featureService.delete(id);
	}
	
}
