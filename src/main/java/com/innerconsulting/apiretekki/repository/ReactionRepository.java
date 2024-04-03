package com.innerconsulting.apiretekki.repository;


import com.innerconsulting.apiretekki.model.Reaction;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactionRepository extends CassandraRepository<Reaction, String> {
}
