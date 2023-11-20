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
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Optional;

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
    public Flux<GoodsDTO> getGoods() {
        Flux<Goods> found = repository.findAll();

        Flux<GoodsDTO> flux = found
                .map(i -> mapper.goodsToGoodsDto(i));


//        List<ProductAvailability> resource = getWithEureka.productsAvailability();
//
//        flux.doOnNext(goodsDTO -> findAvailability(goodsDTO, resource));

        return flux;
    }

    private void findAvailability(GoodsDTO goods, List<ProductAvailability> resource) {
        final String sku = goods.getSku();
        resource
                .stream()
                .filter(productAvailability -> productAvailability.sku().equals(sku))
                .findFirst()
                .map(ProductAvailability::availableCount)
                .ifPresent(goods::setAvailableCount);
    }

}
