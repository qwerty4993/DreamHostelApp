package com.ewaves.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ewaves.entities.Feature;

@Repository
public interface FeatureRepository extends PagingAndSortingRepository<Feature, Long> {

}
