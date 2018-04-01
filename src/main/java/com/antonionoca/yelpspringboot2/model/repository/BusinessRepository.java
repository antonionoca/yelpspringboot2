package com.antonionoca.yelpspringboot2.model.repository;

import com.antonionoca.yelpspringboot2.model.entity.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessRepository extends JpaRepository<Business, Long> {
}
