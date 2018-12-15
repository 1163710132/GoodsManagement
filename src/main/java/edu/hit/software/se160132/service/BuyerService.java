package edu.hit.software.se160132.service;

import edu.hit.software.se160132.entity.GoodsTrans;
import edu.hit.software.se160132.entity.MoneyTrans;
import edu.hit.software.se160132.entity.Purchase;

public interface BuyerService {
    Purchase createPurchase(Long creator, Long supplier, Long total);
    GoodsTrans createGoodsTrans(Long creator, Long goods, Integer amount, Long purchase);
    MoneyTrans createMoneyTrans(Long creator, Long total, Long purchase);
}
