package com.priacc.ieap.finance_service.service;


import com.priacc.ieap.finance_service.model.Expense;
import com.priacc.ieap.finance_service.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExpenseService {

    private final ExpenseRepository repo;

    public Expense createExpense(Expense expense) {
        log.info("Creating new expense: {}", expense.getDescription());
        return repo.save(expense);
    }

    public List<Expense> getAllExpenses() {
        log.info("Fetching all expenses");
        return repo.findAll();
    }

    public Expense getExpenseById(Long id) {
        log.info("Fetching expense with ID: {}", id);
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found with ID: " + id));
    }

    public Expense updateExpense(Long id, Expense updated) {
        log.info("Updating expense with ID: {}", id);
        Expense existing = getExpenseById(id);

        existing.setCategory(updated.getCategory());
        existing.setDescription(updated.getDescription());
        existing.setAmount(updated.getAmount());
        existing.setExpenseDate(updated.getExpenseDate());
        existing.setApproved(updated.isApproved());

        return repo.save(existing);
    }

    public void deleteExpense(Long id) {
        log.info("Deleting expense with ID: {}", id);
        repo.deleteById(id);
    }
}