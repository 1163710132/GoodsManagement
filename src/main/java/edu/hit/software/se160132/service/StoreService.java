package edu.hit.software.se160132.service;

import edu.hit.software.se160132.entity.Store;

public interface StoreService {
    Store findStoreById(Long store);
    Store createStore(String name, String description);
}
