package com.innerconsulting.retekki.repository;

import com.innerconsulting.retekki.model.Reaction;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactionRepository extends CassandraRepository<Reaction, String> {
}
