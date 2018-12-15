package edu.hit.software.se160132.service.impl;

import edu.hit.software.se160132.entity.*;
import edu.hit.software.se160132.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InitService {
    private final AccountRepository accountRepository;
    private final PermissionRepository permissionRepository;
    private final StoreRepository storeRepository;
    private final ShelfRepository shelfRepository;
    private final StockRepository stockRepository;
    private final GoodsRepository goodsRepository;
    private final StockItemRepository stockItemRepository;
    private final ShelfItemRepository shelfItemRepository;

    @Autowired
    public InitService(
            AccountRepository accountRepository,
            PermissionRepository permissionRepository,
            StoreRepository storeRepository,
            ShelfRepository shelfRepository,
            StockRepository stockRepository,
            GoodsRepository goodsRepository,
            StockItemRepository stockItemRepository,
            ShelfItemRepository shelfItemRepository) {
        this.accountRepository = accountRepository;
        this.permissionRepository = permissionRepository;
        this.storeRepository = storeRepository;
        this.shelfRepository = shelfRepository;
        this.stockRepository = stockRepository;
        this.goodsRepository = goodsRepository;
        this.stockItemRepository = stockItemRepository;
        this.shelfItemRepository = shelfItemRepository;
    }

    public void doInit(){
        Account admin = new Account("admin", "admin");
        accountRepository.save(admin);
        Store store = storeRepository.save(new Store("store", "A store"));
        storeRepository.save(store);
        Shelf shelf = new Shelf(store.getId(), "shelf");
        shelfRepository.save(shelf);
        Stock stock = new Stock(store.getId(), "stock");
        stockRepository.save(stock);
        permissionRepository.save(new Permission(admin.getId(), RoleType.BUYER, stock.getId(), admin.getId()));
        permissionRepository.save(new Permission(admin.getId(), RoleType.CLERK, shelf.getId(), admin.getId()));
        permissionRepository.save(new Permission(admin.getId(), RoleType.STOCKMAN, stock.getId(), admin.getId()));
        permissionRepository.save(new Permission(admin.getId(), RoleType.SALESMAN, shelf.getId(), admin.getId()));
        permissionRepository.save(new Permission(admin.getId(), RoleType.MANAGER, store.getId(), admin.getId()));
        Goods goods = new Goods();
        goods.setName("apple");
        goods.setDescription("delicious apple");
        goodsRepository.save(goods);
        StockItem stockItem = new StockItem();
        stockItem.setGoods(goods.getId());
        stockItem.setAmount(0);
        stockItem.setStock(stock.getId());
        stockItem.setPrice(7777L);
        stockItemRepository.save(stockItem);
        ShelfItem shelfItem = new ShelfItem();
        shelfItem.setGoods(goods.getId());
        shelfItem.setAmount(0);
        shelfItem.setShelf(shelf.getId());
        shelfItem.setPrice(7777L);
        shelfItemRepository.save(shelfItem);
    }
}
