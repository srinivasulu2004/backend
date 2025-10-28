package com.priacc.ieap.employee_service.repository;

import com.priacc.ieap.employee_service.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByUsername(String Usenamer);

}
