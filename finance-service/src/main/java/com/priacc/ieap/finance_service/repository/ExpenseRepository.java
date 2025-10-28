package com.priacc.ieap.finance_service.repository;


import com.priacc.ieap.finance_service.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}