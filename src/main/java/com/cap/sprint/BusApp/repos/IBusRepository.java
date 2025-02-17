package com.cap.sprint.BusApp.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cap.sprint.BusApp.entities.Bus;

@Repository
public interface IBusRepository extends JpaRepository<Bus,Integer>{

	//Repository methods to be used for fetching data
	
	Bus findByBusNumber(String busNumber);

	Bus findByBusOperatorBusOperatorUsername(String busOperatorUsername);

}
