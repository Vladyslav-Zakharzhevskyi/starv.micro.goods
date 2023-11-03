package com.starv.micro.goods.repository;

import com.starv.micro.goods.model.Goods;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsRepository extends ReactiveCrudRepository<Goods, Long> {
}
