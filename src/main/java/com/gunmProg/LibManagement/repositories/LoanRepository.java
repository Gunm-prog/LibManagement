package com.gunmProg.LibManagement.repositories;

import com.gunmProg.LibManagement.models.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

}
