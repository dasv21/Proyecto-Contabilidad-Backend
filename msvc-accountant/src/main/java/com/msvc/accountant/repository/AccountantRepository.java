package com.msvc.accountant.repository;

import com.msvc.accountant.entities.Accountant;
import com.msvc.accountant.projection.AccountantProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountantRepository extends JpaRepository<Accountant, Long> {

    Accountant findByDni(String dni);

    Accountant findByEmail(String email);

    @Query("SELECT a.id AS id, a.firstName AS firstName, a.email AS email, a.dni AS dni FROM Accountant a")
    List<AccountantProjection> findAllProjection();


}
