package com.starv.micro.goods.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.starv.micro.goods.dto.GoodsDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface IGoodsService {

    Flux<GoodsDTO> getGoods() throws JsonProcessingException;

    Mono<GoodsDTO> createGood(GoodsDTO dto);
}
