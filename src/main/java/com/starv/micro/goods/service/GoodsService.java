package com.starv.micro.goods.service;

import com.starv.micro.goods.dto.GoodsDTO;
import com.starv.micro.goods.eureka.GetWithEureka;
import com.starv.micro.goods.mapper.GoodsToGoodsDtoMapper;
import com.starv.micro.goods.mapper.jackson.ProductAvailability;
import com.starv.micro.goods.model.Goods;
import com.starv.micro.goods.repository.GoodsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService implements IGoodsService {

    private final Logger log = LoggerFactory.getLogger(GoodsService.class);

    @Autowired
    private GoodsRepository repository;

    @Autowired
    private GoodsToGoodsDtoMapper mapper;

    @Autowired
    private GetWithEureka getWithEureka;


    @Override
    public List<GoodsDTO> getGoods() {
        List<Goods> goods = repository.findAll();

        List<GoodsDTO> goodsDTOS = goods
                .stream()
                .map(i -> mapper.goodsToGoodsDto(i))
                .toList();


        List<ProductAvailability> availability = getWithEureka.productsAvailability();

        availability
                .forEach(a -> provideWithAvailability(goodsDTOS, a));

        return goodsDTOS;
    }

    public void provideWithAvailability(List<GoodsDTO> goods, ProductAvailability avail) {
        List<GoodsDTO> genSku = goods
                .stream()
                .filter(item -> item.getSku().equals(avail.sku()))
                .toList();

        if (genSku.size() > 1) {
            log.error("Found different goods with the same SKU");
        }

        genSku.forEach(item -> provideWithAvailability(item, avail));
    }


    private void provideWithAvailability(GoodsDTO product, ProductAvailability avail) {
        product.setAvailableCount(avail.availableCount());
    }

}
