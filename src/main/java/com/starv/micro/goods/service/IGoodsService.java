package com.starv.micro.goods.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.starv.micro.goods.dto.GoodsDTO;

import java.util.List;

public interface IGoodsService {

    List<GoodsDTO> getGoods() throws JsonProcessingException;
}
