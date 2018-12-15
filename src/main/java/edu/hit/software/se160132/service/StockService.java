package edu.hit.software.se160132.service;

import edu.hit.software.se160132.entity.GoodsTrans;
import edu.hit.software.se160132.entity.Stock;
import edu.hit.software.se160132.entity.StockItem;

public interface StockService {
    Stock createStock(String name, String description, Long store);
    GoodsTrans createStock2Stock(Long creator, Long goods, Integer amount, Long from, Long to, Long cause, Integer causeType);
    GoodsTrans createStock2Cart(Long creator, Long goods, Integer amount, Long from, Long to, Long cause, Integer causeType);
    GoodsTrans createCart2Stock(Long creator, Long goods, Integer amount, Long from, Long to, Long cause, Integer causeType);
    StockItem createStockItem(Long creator, Long goods, Long price, Long stock);
    Stock findStockById(Long id);
    StockItem findStockItemById(Long id);
}
