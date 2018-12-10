package edu.hit.software.se160132.service;

import edu.hit.software.se160132.entity.*;
import edu.hit.software.se160132.repository.*;
import edu.hit.software.se160132.security.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InitService {
    private final AccountRepository accountRepository;
    private final PermissionRepository permissionRepository;
    private final StoreRepository storeRepository;
    private final ShelfRepository shelfRepository;
    private final StockRepository stockRepository;

    @Autowired
    public InitService(
            AccountRepository accountRepository,
            PermissionRepository permissionRepository,
            StoreRepository storeRepository,
            ShelfRepository shelfRepository,
            StockRepository stockRepository) {
        this.accountRepository = accountRepository;
        this.permissionRepository = permissionRepository;
        this.storeRepository = storeRepository;
        this.shelfRepository = shelfRepository;
        this.stockRepository = stockRepository;
    }

    public void doInit(){
        Account admin = new Account("admin", "admin");
        accountRepository.save(admin);
        Store store = storeRepository.save(new Store("store", "A store"));
        Shelf shelf = new Shelf(store.getId(), "shelf");
        Stock stock = new Stock(store.getId(), "stock");
        permissionRepository.save(new Permission(admin.getId(), Role.BUYER, stock.getId()));
        permissionRepository.save(new Permission(admin.getId(), Role.CLERK, shelf.getId()));
        permissionRepository.save(new Permission(admin.getId(), Role.STOCKMAN, stock.getId()));
        permissionRepository.save(new Permission(admin.getId(), Role.SALESMAN, shelf.getId()));
        permissionRepository.save(new Permission(admin.getId(), Role.MANAGER, store.getId()));
    }
}
