package edu.hit.software.se160132.controller;

import edu.hit.software.se160132.entity.EntityType;
import edu.hit.software.se160132.entity.PurchaseOrder;
import edu.hit.software.se160132.service.BuyerService;
import edu.hit.software.se160132.service.FindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/find")
public class FindController implements Controller {
    private final FindService findService;

    @Autowired
    public FindController(FindService findService) {
        this.findService = findService;
    }

    @RequestMapping("/purchaseOrder")
    public PurchaseOrder purchaseOrder(Long id){
        return getUid().flatMap(uid->findService.findPurchaseOrderById(id)).orElse(null);
    }

    @RequestMapping("/purchaseOrderSet")
    public List<PurchaseOrder> purchaseOrderSet(Long id){
        return getUid()
                .flatMap(uid->findService.findPurchaseOrderById(id))
                .map(purchaseOrder -> {
                    List<List<PurchaseOrder>> generations = new ArrayList<>();
                    generations.add(List.of(purchaseOrder));
                    while (generations.get(generations.size() - 1).size() > 0){
                        List<PurchaseOrder> newGeneration = new ArrayList<>();
                        for(var subOrder : generations.get(generations.size() - 1)){
                            newGeneration.addAll(findService.streamPurchaseOrderByPrecursor(subOrder.getId(), EntityType.PO));
                        }
                        generations.add(newGeneration);
                    }
                    return generations.stream().flatMap(List::stream).collect(Collectors.toList());
                }).orElse(List.of());
    }
}
