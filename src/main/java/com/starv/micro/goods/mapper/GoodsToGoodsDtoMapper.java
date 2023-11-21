package com.starv.micro.goods.mapper;

import com.starv.micro.goods.dto.GoodsDTO;
import com.starv.micro.goods.model.Goods;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface GoodsToGoodsDtoMapper {
    GoodsDTO goodsToGoodsDto(Goods goods);

    Goods goodsDtoToGoods(GoodsDTO dto);
}
