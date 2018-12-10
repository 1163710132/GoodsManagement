package edu.hit.software.se160132.service;

import edu.hit.software.se160132.entity.EntityType;
import edu.hit.software.se160132.entity.PurchaseOrder;
import edu.hit.software.se160132.entity.ShelfDelivery;
import edu.hit.software.se160132.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FindService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private GoodsRepository goodsRepository;
    @Autowired
    private PermissionRepository permissionRepository;
    @Autowired
    private PoRepository poRepository;
    @Autowired
    private ShelfDeliveryRepository shelfDeliveryRepository;
    @Autowired
    private ShelfItemRepository shelfItemRepository;
    @Autowired
    private ShelfRepository shelfRepository;
    @Autowired
    private ShelfShortageRepository shelfShortageRepository;
    @Autowired
    private SoRepository soRepository;
    @Autowired
    private StockAllocateRepository stockAllocateRepository;
    @Autowired
    private StockDeliveryRepository stockDeliveryRepository;
    @Autowired
    private StockItemRepository stockItemRepository;
    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private StockSupplyRepository stockSupplyRepository;
    @Autowired
    private StoreRepository storeRepository;

    public Optional<PurchaseOrder> findPurchaseOrderById(Long id){
        return poRepository.findById(id);
    }

    public List<PurchaseOrder> streamPurchaseOrderByPrecursor(Long precursor, EntityType precursorType){
        return poRepository.streamByPrecursorAndPrecursorType(precursor, precursorType);
    }
}
