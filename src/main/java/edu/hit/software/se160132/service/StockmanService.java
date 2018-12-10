package edu.hit.software.se160132.service;

import edu.hit.software.se160132.entity.*;
import edu.hit.software.se160132.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockmanService {
    private final StockRepository stockRepository;
    private final StockSupplyRepository stockSupplyRepository;
    private final StockDeliveryRepository stockDeliveryRepository;
    private final StockItemRepository stockItemRepository;

    @Autowired
    public StockmanService(
            StockRepository stockRepository,
            StockSupplyRepository stockSupplyRepository,
            StockDeliveryRepository stockDeliveryRepository,
            StockItemRepository stockItemRepository) {
        this.stockRepository = stockRepository;
        this.stockSupplyRepository = stockSupplyRepository;
        this.stockDeliveryRepository = stockDeliveryRepository;
        this.stockItemRepository = stockItemRepository;
    }

    public StockSupply createSupply(Long stockman, Long stock, Long goods, Integer amount, Long precursor, EntityType precursorType){
        StockSupply stockSupply = new StockSupply();
        stockSupply.setPrecursorType(precursorType);
        stockSupply.setPrecursor(precursor);
        stockSupply.setActor(stockman);
        stockSupply.setAmount(amount);
        stockSupply.setGoods(goods);
        stockSupply.setStock(stock);
        addQuantity(stockman, stock, goods, amount);
        return stockSupplyRepository.save(stockSupply);
    }

    public boolean adjustQuantity(Long stockman, Long stock, Long goods, Integer amount){
        return amount == 0 ||
                (amount > 0 ? addQuantity(stockman, stock, goods, amount)
                : subQuantity(stockman, stock, goods, amount));
    }

    public boolean addQuantity(Long stockman, Long stock, Long goods, Integer amount){
        StockItem stockItem = stockItemRepository.findByStockAndGoods(stock, goods);
        stockItem.setAmount(stockItem.getAmount() + amount);
        stockItemRepository.save(stockItem);
        return true;
    }

    public boolean subQuantity(Long stockman, Long stock, Long goods, Integer amount){
        StockItem stockItem = stockItemRepository.findByStockAndGoods(stock, goods);
        stockItem.setAmount(stockItem.getAmount() - amount);
        stockItemRepository.save(stockItem);
        return true;
    }

    public StockDelivery createDeliver(Long stockman, Long stock, Long goods, Integer amount, Long precursor, EntityType precursorType){
        StockDelivery stockDelivery = new StockDelivery();
        stockDelivery.setGoods(goods);
        stockDelivery.setAmount(amount);
        stockDelivery.setStock(stock);
        stockDelivery.setPrecursorType(precursorType);
        stockDelivery.setPrecursor(precursor);
        stockDelivery.setActor(stockman);
        subQuantity(stockman, stock, goods, amount);
        return stockDeliveryRepository.save(stockDelivery);
    }
}
