package raskusur.raskusur.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import raskusur.raskusur.model.Ledger;

@Repository
public interface LedgerRepository extends JpaRepository<Ledger, Long>{
    
    
}
