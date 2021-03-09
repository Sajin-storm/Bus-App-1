package com.cap.sprint.BusApp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cap.sprint.BusApp.entities.BusRoute;

public interface IBusRouteRepository extends JpaRepository<BusRoute, Integer>{

	BusRoute findByBusBusNumber(String busNumber);

}
