package edu.hit.software.se160132.service.impl;

import edu.hit.software.se160132.entity.Store;
import edu.hit.software.se160132.repository.StoreRepository;
import edu.hit.software.se160132.service.StoreService;

public class StoreServiceImpl implements StoreService {
    private final StoreRepository storeRepository;

    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public Store findStoreById(Long store) {
        return storeRepository.findById(store).orElseThrow();
    }

    @Override
    public Store createStore(String name, String description) {
        Store store = new Store();
        store.setName(name);
        store.setDescription(description);
        return storeRepository.save(store);
    }
}
