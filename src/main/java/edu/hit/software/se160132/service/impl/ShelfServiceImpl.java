package edu.hit.software.se160132.service.impl;

import edu.hit.software.se160132.entity.EntityType;
import edu.hit.software.se160132.entity.GoodsTrans;
import edu.hit.software.se160132.entity.Shelf;
import edu.hit.software.se160132.entity.ShelfItem;
import edu.hit.software.se160132.repository.GoodsTransRepository;
import edu.hit.software.se160132.repository.ShelfItemRepository;
import edu.hit.software.se160132.repository.ShelfRepository;
import edu.hit.software.se160132.service.ShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShelfServiceImpl implements ShelfService {
    private final ShelfRepository shelfRepository;
    private final GoodsTransRepository goodsTransRepository;
    private final ShelfItemRepository shelfItemRepository;

    @Autowired
    public ShelfServiceImpl(
            ShelfRepository shelfRepository,
            GoodsTransRepository goodsTransRepository,
            ShelfItemRepository shelfItemRepository) {
        this.shelfRepository = shelfRepository;
        this.goodsTransRepository = goodsTransRepository;
        this.shelfItemRepository = shelfItemRepository;
    }

    @Override
    public Shelf createShelf(String name, String description, Long store) {
        Shelf shelf = new Shelf();
        shelf.setName(name);
        shelf.setDescription(description);
        shelf.setStore(store);
        return shelfRepository.save(shelf);
    }

    @Override
    public GoodsTrans createShelf2Shelf(Long creator, Long goods, Integer amount, Long from, Long to, Long cause, Integer causeType) {
        GoodsTrans goodsTrans = new GoodsTrans();
        goodsTrans.setCreator(creator);
        goodsTrans.setGoods(goods);
        goodsTrans.setAmount(amount);
        goodsTrans.setSource(from);
        goodsTrans.setSourceType(EntityType.SHELF_ITEM);
        goodsTrans.setTarget(to);
        goodsTrans.setTargetType(EntityType.SHELF_ITEM);
        goodsTrans.setCause(cause);
        goodsTrans.setCauseType(causeType);
        return goodsTransRepository.save(goodsTrans);
    }

    @Override
    public GoodsTrans createShelf2Cart(Long creator, Long goods, Integer amount, Long from, Long to, Long cause, Integer causeType) {
        GoodsTrans goodsTrans = new GoodsTrans();
        goodsTrans.setCreator(creator);
        goodsTrans.setGoods(goods);
        goodsTrans.setAmount(amount);
        goodsTrans.setSource(from);
        goodsTrans.setSourceType(EntityType.SHELF_ITEM);
        goodsTrans.setTarget(to);
        goodsTrans.setTargetType(EntityType.CART);
        goodsTrans.setCause(cause);
        goodsTrans.setCauseType(causeType);
        return goodsTransRepository.save(goodsTrans);
    }

    @Override
    public GoodsTrans createCart2Shelf(Long creator, Long goods, Integer amount, Long from, Long to, Long cause, Integer causeType) {
        GoodsTrans goodsTrans = new GoodsTrans();
        goodsTrans.setCreator(creator);
        goodsTrans.setGoods(goods);
        goodsTrans.setAmount(amount);
        goodsTrans.setSource(from);
        goodsTrans.setSourceType(EntityType.CART);
        goodsTrans.setTarget(to);
        goodsTrans.setTargetType(EntityType.SHELF_ITEM);
        goodsTrans.setCause(cause);
        goodsTrans.setCauseType(causeType);
        return goodsTransRepository.save(goodsTrans);
    }

    @Override
    public ShelfItem createShelfItem(Long creator, Long goods, Long price, Long shelf) {
        ShelfItem shelfItem = new ShelfItem();
        shelfItem.setGoods(goods);
        shelfItem.setAmount(0);
        shelfItem.setPrice(price);
        shelfItem.setShelf(shelf);
        return shelfItemRepository.save(shelfItem);
    }

    @Override
    public Shelf findShelfById(Long id) {
        return shelfRepository.findById(id).orElseThrow();
    }

    @Override
    public ShelfItem findShelfItemById(Long id) {
        return shelfItemRepository.findById(id).orElseThrow();
    }
}
