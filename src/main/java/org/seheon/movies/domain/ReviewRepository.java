package org.seheon.movies.domain;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface ReviewRepository extends MongoRepository<Review, ObjectId> {
}
