package edu.hit.software.se160132.controller;

import edu.hit.software.se160132.entity.GoodsTrans;
import edu.hit.software.se160132.entity.StockItem;
import edu.hit.software.se160132.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/stockman")
public class StockmanController implements Controller {
    private final StockService stockService;

    @Autowired
    public StockmanController(StockService stockService) {
        this.stockService = stockService;
    }

    @RequestMapping("/stockIn")
    public GoodsTrans stockIn(Long source, Long target, Long cause, Integer amount){
        getUid().map(uid -> {
            StockItem stockItem = stockService.findStockItemById(target);
            stockService.createCart2Stock(uid, stockItem.getGoods(), amount, )
        })
    }

    @RequestMapping("/stockOut")
    public GoodsTrans stockIn(){

    }
}
