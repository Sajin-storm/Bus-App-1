package com.cap.sprint.BusApp.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cap.sprint.BusApp.entities.BusOperator;

@Repository
public interface IBusOperatorRepository extends JpaRepository<BusOperator,Integer>{

	//Repository methods to be used for fetching data

	public List<BusOperator> findByBusBusRouteRouteName(String route);

	public BusOperator findByBusOperatorUsername(String busOperatorUsername);

	public BusOperator findByPassword(String oldPassword);

}
