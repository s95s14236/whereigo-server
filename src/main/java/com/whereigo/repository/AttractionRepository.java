package com.whereigo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.whereigo.model.Attraction;

public interface AttractionRepository extends JpaRepository<Attraction, Long> {

    Page<Attraction> findAllByRegion(String region, Pageable pageable);

    Page<Attraction> findAllByRegionAndTown(String region, String town, Pageable pageable);
}
