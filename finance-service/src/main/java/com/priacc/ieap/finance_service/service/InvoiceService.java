package com.priacc.ieap.finance_service.service;

import com.priacc.ieap.finance_service.model.Invoice;
import com.priacc.ieap.finance_service.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class InvoiceService {

    private final InvoiceRepository repo;

    public Invoice createInvoice(Invoice invoice) {
        log.info("Creating new invoice: {}", invoice.getInvoiceNumber());
        return repo.save(invoice);
    }

    public List<Invoice> getAllInvoices() {
        log.info("Fetching all invoices");
        return repo.findAll();
    }

    public Invoice getInvoiceById(Long id) {
        log.info("Fetching invoice with ID: {}", id);
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Invoice not found with ID: " + id));
    }

    public Invoice updateInvoice(Long id, Invoice updated) {
        log.info("Updating invoice with ID: {}", id);
        Invoice existing = getInvoiceById(id);

        existing.setInvoiceNumber(updated.getInvoiceNumber());
        existing.setCustomerName(updated.getCustomerName());
        existing.setAmount(updated.getAmount());
        existing.setIssuedDate(updated.getIssuedDate());
        existing.setPaid(updated.isPaid());

        return repo.save(existing);
    }

    public void deleteInvoice(Long id) {
        log.info("Deleting invoice with ID: {}", id);
        repo.deleteById(id);
    }
}