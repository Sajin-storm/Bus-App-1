package com.cap.sprint.BusApp.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cap.sprint.BusApp.entities.AdminUser;

@Repository
public interface IAdminRepository extends JpaRepository<AdminUser,Integer>{

}
