package com.nexwork.api.account.ms_nexwork_api_account.persistence;

import java.util.List;
public interface GenericInterfaceDAO <T,ID> {
    List<T> findAll();
    T findById(ID id);
    T save(T entity);
    void delete(ID id);
}
