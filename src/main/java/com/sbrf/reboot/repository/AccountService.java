package com.sbrf.reboot.repository;

import com.sbrf.reboot.repository.AccountRepository;

public class AccountService {

    public AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public boolean isClientHasContract(long clientId, long contractNumber) {
        if (accountRepository.getAllAccountsByClientId(clientId).contains(contractNumber)){
            return true;
        }
        return false;
    }

    public boolean add(long clientId, long contractNumber) {
        if (!accountRepository.getAllAccountsByClientId(clientId).contains(contractNumber)){
            accountRepository.save(clientId, contractNumber);
            return true;
        }
        return false;
    }
}
