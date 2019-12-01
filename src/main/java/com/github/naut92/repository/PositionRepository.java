package com.github.naut92.repository;

import com.github.naut92.model.Position;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends MongoRepository<Position, String> {
}
