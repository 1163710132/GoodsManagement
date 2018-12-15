package edu.hit.software.se160132.service.impl;

import edu.hit.software.se160132.entity.*;
import edu.hit.software.se160132.repository.*;
import edu.hit.software.se160132.service.StockService;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl implements StockService {
    private final StockRepository stockRepository;
    private final GoodsTransRepository goodsTransRepository;
    private final StockItemRepository stockItemRepository;

    public StockServiceImpl(
            StockRepository stockRepository,
            GoodsTransRepository goodsTransRepository,
            StockItemRepository stockItemRepository) {
        this.stockRepository = stockRepository;
        this.goodsTransRepository = goodsTransRepository;
        this.stockItemRepository = stockItemRepository;
    }

    @Override
    public Stock createStock(String name, String description, Long store) {
        Stock stock = new Stock();
        stock.setName(name);
        stock.setDescription(description);
        stock.setStore(store);
        return stockRepository.save(stock);
    }

    @Override
    public GoodsTrans createStock2Stock(Long creator, Long goods, Integer amount, Long from, Long to, Long cause, Integer causeType) {
        GoodsTrans goodsTrans = new GoodsTrans();
        goodsTrans.setCreator(creator);
        goodsTrans.setGoods(goods);
        goodsTrans.setAmount(amount);
        goodsTrans.setSource(from);
        goodsTrans.setSourceType(EntityType.STOCK_ITEM);
        goodsTrans.setTarget(to);
        goodsTrans.setTargetType(EntityType.STOCK_ITEM);
        goodsTrans.setCause(cause);
        goodsTrans.setCauseType(causeType);
        return goodsTransRepository.save(goodsTrans);
    }

    @Override
    public GoodsTrans createStock2Cart(Long creator, Long goods, Integer amount, Long from, Long to, Long cause, Integer causeType) {
        GoodsTrans goodsTrans = new GoodsTrans();
        goodsTrans.setCreator(creator);
        goodsTrans.setGoods(goods);
        goodsTrans.setAmount(amount);
        goodsTrans.setSource(from);
        goodsTrans.setSourceType(EntityType.STOCK_ITEM);
        goodsTrans.setTarget(to);
        goodsTrans.setTargetType(EntityType.CART);
        goodsTrans.setCause(cause);
        goodsTrans.setCauseType(causeType);
        return goodsTransRepository.save(goodsTrans);
    }

    @Override
    public GoodsTrans createCart2Stock(Long creator, Long goods, Integer amount, Long from, Long to, Long cause, Integer causeType) {
        GoodsTrans goodsTrans = new GoodsTrans();
        goodsTrans.setCreator(creator);
        goodsTrans.setGoods(goods);
        goodsTrans.setAmount(amount);
        goodsTrans.setSource(from);
        goodsTrans.setSourceType(EntityType.CART);
        goodsTrans.setTarget(to);
        goodsTrans.setTargetType(EntityType.STOCK_ITEM);
        goodsTrans.setCause(cause);
        goodsTrans.setCauseType(causeType);
        return goodsTransRepository.save(goodsTrans);
    }

    @Override
    public StockItem createStockItem(Long creator, Long goods, Long price, Long stock) {
        StockItem stockItem = new StockItem();
        stockItem.setGoods(goods);
        stockItem.setAmount(0);
        stockItem.setPrice(price);
        stockItem.setStock(stock);
        return stockItemRepository.save(stockItem);
    }

    @Override
    public Stock findStockById(Long id) {
        return stockRepository.findById(id).orElseThrow();
    }

    @Override
    public StockItem findStockItemById(Long id) {
        return stockItemRepository.findById(id).orElseThrow();
    }
}
