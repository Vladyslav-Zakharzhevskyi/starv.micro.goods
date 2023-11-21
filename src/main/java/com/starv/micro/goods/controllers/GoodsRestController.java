package com.starv.micro.goods.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.starv.micro.goods.dto.GoodsDTO;
import com.starv.micro.goods.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class GoodsRestController {

    @Autowired
    private IGoodsService service;

    @RequestMapping(method = RequestMethod.GET, path = "/goods")
    public Flux<GoodsDTO> getGoods() throws JsonProcessingException {
        return service.getGoods();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/goods")
    public Mono<GoodsDTO> createGood(GoodsDTO dto) {
        return service.createGood(dto);
    }

}
