package edu.hit.software.se160132.service;

import edu.hit.software.se160132.entity.*;
import edu.hit.software.se160132.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClerkService {
    private final ShelfRepository shelfRepository;
    private final ShelfSupplyRepository shelfSupplyRepository;
    private final ShelfDeliveryRepository shelfDeliveryRepository;
    private final ShelfShortageRepository shelfShortageRepository;
    private final ShelfItemRepository shelfItemRepository;

    @Autowired
    public ClerkService(
            ShelfRepository shelfRepository,
            ShelfSupplyRepository shelfSupplyRepository,
            ShelfDeliveryRepository shelfDeliveryRepository,
            ShelfShortageRepository shelfShortageRepository,
            ShelfItemRepository shelfItemRepository) {
        this.shelfRepository = shelfRepository;
        this.shelfSupplyRepository = shelfSupplyRepository;
        this.shelfDeliveryRepository = shelfDeliveryRepository;
        this.shelfShortageRepository = shelfShortageRepository;
        this.shelfItemRepository = shelfItemRepository;
    }

    public ShelfSupply createShelfSupply(Long clerk, Long shelf, Long goods, Integer amount, Long item, Long precursor, EntityType precursorType){
        ShelfSupply shelfSupply = new ShelfSupply();
        shelfSupply.setActor(clerk);
        shelfSupply.setAmount(amount);
        shelfSupply.setGoods(goods);
        shelfSupply.setItem(item);
        shelfSupply.setPrecursor(precursor);
        shelfSupply.setPrecursorType(precursorType);
        shelfSupply.setShelf(shelf);
        addQuantity(clerk, shelf, goods, amount, item);
        addFreeQuantity(clerk, shelf, goods, amount, item);
        return shelfSupplyRepository.save(shelfSupply);
    }

    public ShelfShortage createShelfShortage(Long clerk, Long shelf, Long goods, Integer amount, Long item){
        ShelfShortage shelfShortage = new ShelfShortage();
        shelfShortage.setActor(clerk);
        shelfShortage.setAmount(amount);
        shelfShortage.setGoods(goods);
        shelfShortage.setShelf(shelf);
        shelfShortage.setId(item);
        return shelfShortageRepository.save(shelfShortage);
    }

    public ShelfDelivery createShelfDelivery(Long clerk, Long shelf, Long goods, Integer amount, Long item, Long precursor, EntityType precursorType){
        ShelfDelivery shelfDelivery = new ShelfDelivery();
        shelfDelivery.setActor(clerk);
        shelfDelivery.setAmount(amount);
        shelfDelivery.setGoods(goods);
        shelfDelivery.setItem(item);
        shelfDelivery.setPrecursor(precursor);
        shelfDelivery.setPrecursorType(precursorType);
        shelfDelivery.setShelf(shelf);
        subQuantity(clerk, shelf, goods, amount, item);
        return shelfDeliveryRepository.save(shelfDelivery);
    }

    public boolean addQuantity(Long clerk, Long shelf, Long goods, Integer amount, Long item){
        ShelfItem shelfItem = shelfItemRepository.findById(item).orElseThrow();
        shelfItem.setAmount(shelfItem.getAmount() + amount);
        shelfItemRepository.save(shelfItem);
        return true;
    }

    public boolean addFreeQuantity(Long clerk, Long shelf, Long goods, Integer free, Long item){
        ShelfItem shelfItem = shelfItemRepository.findById(item).orElseThrow();
        shelfItem.setFree(shelfItem.getFree() + free);
        shelfItemRepository.save(shelfItem);
        return true;
    }

    public boolean subQuantity(Long clerk, Long shelf, Long goods, Integer amount, Long item){
        ShelfItem shelfItem = shelfItemRepository.findById(item).orElseThrow();
        shelfItem.setAmount(shelfItem.getAmount() - amount);
        shelfItemRepository.save(shelfItem);
        return true;
    }

    public boolean subFreeQuantity(Long clerk, Long shelf, Long goods, Integer free, Long item){
        ShelfItem shelfItem = shelfItemRepository.findById(item).orElseThrow();
        shelfItem.setFree(shelfItem.getFree() + free);
        shelfItemRepository.save(shelfItem);
        return true;
    }
}
