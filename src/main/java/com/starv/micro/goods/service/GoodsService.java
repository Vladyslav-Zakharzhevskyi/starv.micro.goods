package com.starv.micro.goods.service;

import com.netflix.appinfo.InstanceInfo;
import com.starv.micro.goods.dto.GoodsDTO;
import com.starv.micro.goods.eureka.Eureka;
import com.starv.micro.goods.eureka.MicroServicesInfo;
import com.starv.micro.goods.mapper.GoodsToGoodsDtoMapper;
import com.starv.micro.goods.mapper.jackson.ProductAvailability;
import com.starv.micro.goods.model.Goods;
import com.starv.micro.goods.repository.GoodsRepository;
import com.starv.micro.goods.rest.IRestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
    private Eureka eureka;

    @Autowired
    private IRestService restService;


    @Override
    public Flux<GoodsDTO> getGoods() {
        Flux<Goods> goods = repository.findAll();

        InstanceInfo instanceInfo = eureka.getShuffledInstanceInfo(MicroServicesInfo.AVAILABILITY_SERVICE_NAME);
        List<ProductAvailability> availabilityData = restService.productsAvailability(instanceInfo);

        Flux<GoodsDTO> goodsWithAvailability = goods
                .map(g -> mapper.goodsToGoodsDto(g))
                .doOnNext(goodsDTO -> determine(goodsDTO, availabilityData));

        return goodsWithAvailability;
    }

    private void determine(GoodsDTO dto, List<ProductAvailability> availabiliyData) {
        final String sku = dto.getSku();
        final Long availability = findAvailability(sku, availabiliyData);
        dto.setAvailableCount(availability);
    }

    @Override
    public Mono<GoodsDTO> createGood(GoodsDTO dto) {
        Goods goods = mapper.goodsDtoToGoods(dto);
        Mono<Goods> saved = repository.save(goods);
        return saved.map(s -> mapper.goodsToGoodsDto(s));
    }

    private Long findAvailability(String sku, List<ProductAvailability> resource) {
        final Optional<ProductAvailability> availability = resource.stream()
                .filter(pa -> pa.sku().equals(sku))
                .findFirst();

        return availability
                .map(ProductAvailability::availableCount)
                .orElse(0L);
    }

}
