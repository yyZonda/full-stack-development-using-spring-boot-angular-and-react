package com.yy.flight.system.flightreservation.repos;

import com.yy.flight.system.flightreservation.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
