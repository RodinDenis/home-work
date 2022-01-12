package com.sbrf.reboot.repository;

import java.util.Set;

public interface AccountRepository {
    public Set<Long> getAllAccountsByClientId(long clientId);

    default public void save (long clientId, long contractNumber){

    }
}
