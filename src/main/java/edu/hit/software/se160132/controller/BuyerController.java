package edu.hit.software.se160132.controller;

import edu.hit.software.se160132.entity.EntityType;
import edu.hit.software.se160132.entity.Permission;
import edu.hit.software.se160132.entity.PurchaseOrder;
import edu.hit.software.se160132.security.Role;
import edu.hit.software.se160132.service.BuyerService;
import org.apache.shiro.authz.annotation.RequiresRoles;
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
    public PurchaseOrder purchase(
            Long actor,
            Long supplier, Long goods, Integer amount,
            Long total, Long precursor, Integer precursorType){
        if(!hasRole(Role.BUYER)){
            return null;
        }
        return getUid().map(uid -> {
            return buyerService.createPurchase(
                    uid,
                    supplier,
                    goods,
                    amount,
                    total,
                    precursor,
                    EntityType.getByValue(precursorType)
            );
        }).orElse(null);
    }
}
