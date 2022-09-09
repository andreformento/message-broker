package com.formento.bank.account.port;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

class WithdrawTransactionRequest {
    private final BigDecimal amount;

    WithdrawTransactionRequest(BigDecimal amount) {
        this.amount = amount;
    }

}

@RestController
@RequestMapping("/accounts/{account-id}/transactions")
public class AccountTransactionController {

    @PostMapping("/withdraw")
    void withdrawTransaction(@RequestBody WithdrawTransactionRequest request) {

    }

}
