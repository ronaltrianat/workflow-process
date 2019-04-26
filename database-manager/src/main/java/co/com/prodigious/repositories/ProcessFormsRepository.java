package co.com.prodigious.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.prodigious.entities.ProcessFormsEntity;

@Repository
public interface ProcessFormsRepository extends CrudRepository<ProcessFormsEntity, Integer> {

}
