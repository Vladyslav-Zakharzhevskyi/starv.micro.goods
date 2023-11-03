package com.starv.micro.goods.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.starv.micro.goods.dto.GoodsDTO;
import com.starv.micro.goods.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/v1/")
public class GoodsRestController {

    @Autowired
    private IGoodsService service;

    @RequestMapping(method = RequestMethod.GET, path = "goods")
    public Flux<GoodsDTO> getGoods() throws JsonProcessingException {
        return service.getGoods();
    }

}
