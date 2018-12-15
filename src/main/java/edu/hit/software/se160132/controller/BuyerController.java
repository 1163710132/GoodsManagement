package edu.hit.software.se160132.controller;

import edu.hit.software.se160132.entity.EntityType;
import edu.hit.software.se160132.entity.GoodsTrans;
import edu.hit.software.se160132.entity.Purchase;
import edu.hit.software.se160132.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/buyer")
public class BuyerController implements Controller {
    private final BuyerService buyerService;

    @Autowired
    public BuyerController(BuyerService buyerService) {
        this.buyerService = buyerService;
    }

    @RequestMapping("/purchase")
    public Purchase purchase(Long supplier, Long total){
        if(!hasRole(EntityType.BUYER)){
            return null;
        }
        return getUid().map(uid -> {
            return buyerService.createPurchase(uid, supplier, total);
        }).orElse(null);
    }

    @RequestMapping("/purchaseEntry")
    public GoodsTrans purchaseEntry(Long goods, Integer amount, Long purchase){
        if(!hasRole(EntityType.BUYER)){
            return null;
        }
        return getUid().map(uid -> {
            return buyerService.createGoodsTrans(uid, goods, amount, purchase);
        }).orElse(null);
    }
}
