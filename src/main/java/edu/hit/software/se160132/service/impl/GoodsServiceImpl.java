package edu.hit.software.se160132.service.impl;

import edu.hit.software.se160132.entity.Goods;
import edu.hit.software.se160132.entity.GoodsTrans;
import edu.hit.software.se160132.repository.GoodsRepository;
import edu.hit.software.se160132.repository.GoodsTransRepository;
import edu.hit.software.se160132.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl implements GoodsService {
    private final GoodsRepository goodsRepository;
    private final GoodsTransRepository goodsTransRepository;

    @Autowired
    public GoodsServiceImpl(
            GoodsRepository goodsRepository,
            GoodsTransRepository goodsTransRepository) {
        this.goodsRepository = goodsRepository;
        this.goodsTransRepository = goodsTransRepository;
    }

    @Override
    public GoodsTrans saveGoodsTrans(GoodsTrans goodsTrans) {
        return goodsTransRepository.save(goodsTrans);
    }

    @Override
    public Goods findGoodsById(Long id) {
        return goodsRepository.findById(id).orElseThrow();
    }

    @Override
    public Goods createGoods(String name, String description) {
        Goods goods = new Goods();
        goods.setName(name);
        goods.setDescription(description);
        return goodsRepository.save(goods);
    }
}
