package edu.hit.software.se160132.service;

import edu.hit.software.se160132.entity.EntityType;
import edu.hit.software.se160132.entity.PurchaseOrder;
import edu.hit.software.se160132.entity.State;
import edu.hit.software.se160132.repository.PoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BuyerService {
    private final PoRepository poRepository;

    @Autowired
    public BuyerService(PoRepository poRepository) {
        this.poRepository = poRepository;
    }

    public PurchaseOrder createPurchase(Long buyer, Long supplier, Long goods, Integer amount, Long total, Long precursor, EntityType precursorType){
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setActor(buyer);
        purchaseOrder.setSupplier(supplier);
        purchaseOrder.setGoods(goods);
        purchaseOrder.setAmount(amount);
        purchaseOrder.setTotal(total);
        purchaseOrder.setPrecursor(precursor);
        purchaseOrder.setPrecursorType(precursorType);
        return poRepository.save(purchaseOrder);
    }
}
