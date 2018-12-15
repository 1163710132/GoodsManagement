package edu.hit.software.se160132.service.impl;

import edu.hit.software.se160132.entity.*;
import edu.hit.software.se160132.repository.GoodsTransRepository;
import edu.hit.software.se160132.repository.MoneyTransRepository;
import edu.hit.software.se160132.repository.PurchaseRepository;
import edu.hit.software.se160132.service.BuyerService;
import edu.hit.software.se160132.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuyerServiceImpl implements BuyerService {
    private final PurchaseRepository purchaseRepository;
    private final GoodsTransRepository goodsTransRepository;
    private final MoneyTransRepository moneyTransRepository;

    @Autowired
    public BuyerServiceImpl(
            PurchaseRepository purchaseRepository,
            GoodsTransRepository goodsTransRepository,
            MoneyTransRepository moneyTransRepository,
            GoodsService goodsService) {
        this.purchaseRepository = purchaseRepository;
        this.goodsTransRepository = goodsTransRepository;
        this.moneyTransRepository = moneyTransRepository;
    }

    @Override
    public Purchase createPurchase(Long creator, Long supplier, Long total) {
        Purchase purchase = new Purchase();
        purchase.setCreator(creator);
        purchase.setSupplier(supplier);
        purchase.setTotal(total);
        return purchaseRepository.save(purchase);
    }

    @Override
    public GoodsTrans createGoodsTrans(Long creator, Long goods, Integer amount, Long purchase) {
        Purchase purchaseEntity = purchaseRepository.findById(purchase).orElseThrow();
        GoodsTrans goodsTrans = new GoodsTrans();
        goodsTrans.setCreator(creator);
        goodsTrans.setSource(purchaseEntity.getSupplier());
        goodsTrans.setSourceType(EntityType.SUPPLIER);
        goodsTrans.setGoods(goods);
        goodsTrans.setAmount(amount);
        goodsTrans.setTarget(purchase);
        goodsTrans.setTargetType(EntityType.PURCHASE);
        goodsTrans.setCause(purchase);
        goodsTrans.setCauseType(EntityType.PURCHASE);
        return goodsTransRepository.save(goodsTrans);
    }

    @Override
    public MoneyTrans createMoneyTrans(Long creator, Long total, Long purchase) {
        Purchase purchaseEntity = purchaseRepository.findById(purchase).orElseThrow();
        MoneyTrans moneyTrans = new MoneyTrans();
        moneyTrans.setCreator(creator);
        moneyTrans.setSource(purchaseEntity.getSupplier());
        moneyTrans.setSourceType(EntityType.SUPPLIER);
        moneyTrans.setTarget(creator);
        moneyTrans.setTargetType(EntityType.MAIN);
        moneyTrans.setCause(purchase);
        moneyTrans.setCauseType(EntityType.PURCHASE);
        moneyTrans.setTotal(total);
        return moneyTransRepository.save(moneyTrans);
    }
}
