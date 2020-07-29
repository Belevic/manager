package com.bsuir.vmsis.repository;

import com.bsuir.vmsis.model.impl.Transfer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferRepository extends CrudRepository<Transfer,Long> {
}
