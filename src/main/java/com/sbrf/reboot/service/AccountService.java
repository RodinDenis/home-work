package com.sbrf.reboot.service;

import com.sbrf.reboot.repository.AccountRepository;

import java.util.Set;

public class AccountService{
    AccountRepository ar;

    public AccountService(AccountRepository ar){
        this.ar = ar;
    }

    public boolean isClientHasContract(long clientId, long contractNumber) {
        Set<Long> accounts = ar.getAllAccountsByClientId(clientId);
        for(Long account : accounts){
            if(account == contractNumber)
                return true;
        }
        return false;
    }

    public boolean addContract(long clientId, long contractNumber) {
        if(!isClientHasContract(clientId, contractNumber)){
            ar.addAccountToClient(clientId, contractNumber);
            return true;
        }
        return false;
    }
}
