package com.store.api.controller;

import com.store.api.dto.TransactionDto;
import com.store.api.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping(path = "/{transactionId}")
    public ResponseEntity<TransactionDto> getTransactionById(@PathVariable("transactionId") Long id) {
        return ResponseEntity.ok(transactionService.getTransactionById(id));
    }

    @GetMapping
    public ResponseEntity<List<TransactionDto>> getAllTransactions() {
        return ResponseEntity.ok(transactionService.getTransactions());
    }

    @PostMapping
    public ResponseEntity<TransactionDto> createTransaction(@RequestBody TransactionDto transactionDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(transactionService.createTransaction(transactionDto));
    }

    @DeleteMapping(path = "/{transactionId}")
    public ResponseEntity<String> deleteTransactionById(@PathVariable("transactionId") Long id) {
        transactionService.deleteTransactionById(id);
        return ResponseEntity.ok("Transaction successfully deleted.");
    }

    @PutMapping(path = "/{transactionId}")
    public ResponseEntity<TransactionDto> updateTransaction(
            @PathVariable("transactionId") Long id,
            @RequestBody TransactionDto transactionDto) {
        return ResponseEntity.ok(transactionService.updateTransactionById(id, transactionDto));
    }

}
