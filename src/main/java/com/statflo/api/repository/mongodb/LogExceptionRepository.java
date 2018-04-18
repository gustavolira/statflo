package com.statflo.api.repository.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.statflo.api.model.LogException;

 public interface LogExceptionRepository extends MongoRepository<LogException, String> {

}
