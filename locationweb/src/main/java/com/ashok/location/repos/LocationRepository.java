package com.ashok.location.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashok.location.entities.Location;

public interface LocationRepository extends JpaRepository<Location , Integer> {

}
