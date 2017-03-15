package com.ewaves.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ewaves.domain.FeatureLookup;
import com.ewaves.repository.FeatureLookupRepository;
import com.ewaves.repository.FeatureRepository;

@Service
public class FeatureService {

	@Autowired
	FeatureRepository featureRepository;
	@Autowired
	FeatureLookupRepository featureLookupRepository;
	public List<FeatureLookup> getFeatures() {
		System.out.println(featureLookupRepository.findAll());
		return (List<FeatureLookup>) featureLookupRepository.findAll();
	}

	public void addFeatue(FeatureLookup featureLookup) {
		FeatureLookup dbfeatureLookup = featureLookupRepository.findByName(featureLookup.getName());
		if (dbfeatureLookup != null) {
			throw new RuntimeException("Funktionen finns redan");
		}

		featureLookupRepository.save(featureLookup);

	}

	public void updateFeatue(Long id, FeatureLookup feature) {
		// TODO Auto-generated method stub

	}

	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

}
