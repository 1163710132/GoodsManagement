package edu.hit.software.se160132.service;

import edu.hit.software.se160132.entity.Goods;
import edu.hit.software.se160132.entity.GoodsTrans;

public interface GoodsService {
    GoodsTrans saveGoodsTrans(GoodsTrans goodsTrans);
    Goods findGoodsById(Long id);
    Goods createGoods(String name, String description);
}
