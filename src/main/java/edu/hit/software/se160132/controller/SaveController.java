package edu.hit.software.se160132.controller;

import edu.hit.software.se160132.entity.GoodsTrans;
import edu.hit.software.se160132.service.BuyerService;
import edu.hit.software.se160132.service.ShelfService;
import edu.hit.software.se160132.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("save")
public class SaveController {
    private final BuyerService buyerService;
    private final StockService stockService;
    private final ShelfService shelfService;

    @Autowired
    public SaveController(BuyerService buyerService, StockService stockService, ShelfService shelfService) {
        this.buyerService = buyerService;
        this.stockService = stockService;
        this.shelfService = shelfService;
    }
}
