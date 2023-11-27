package com.msvc.accountant.repository;

import com.msvc.accountant.entities.Accountant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountantRepository extends JpaRepository<Accountant, Long> {

    Accountant findByDni(String dni);

    Accountant findByEmail(String email);


}
