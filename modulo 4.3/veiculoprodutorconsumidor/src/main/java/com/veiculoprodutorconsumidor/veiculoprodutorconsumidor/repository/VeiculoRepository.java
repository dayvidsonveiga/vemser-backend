package com.veiculoprodutorconsumidor.veiculoprodutorconsumidor.repository;

import com.veiculoprodutorconsumidor.veiculoprodutorconsumidor.entity.VeiculoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends MongoRepository<VeiculoEntity, String> {
}
