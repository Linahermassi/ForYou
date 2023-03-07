package com.example.foryou.DAO.Repositories;

import com.example.foryou.DAO.Entities.Contracts;
import com.example.foryou.DAO.Entities.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ContractRepository extends JpaRepository<Contracts,Integer> {
    // ********** Trouver contrat par date d'expiration
    List<Contracts> findByExprirationDate(LocalDate expirationDate);
    //*********** Filtrage des contracts par type de sinister
    @Query(value = "select c from Contracts c , Sinister s where s.contract.contract_id=c.contract_id" +
            "and s.typeSinister=?1",nativeQuery = true)
    List<Contracts> selectContractByType(Type type);
    // ********** Affichage des contracts renouvelable dont la date d'expiration et la date d'aujourdhui
    @Query(value = "select c from Contracts c where c.exprirationDate=?1 and c.renewable=FALSE",nativeQuery = true)
    List<Contracts> selectRenewableContract();
    // ********** Supprimer les contracts non renouvlable dont la date d'expiration et la date d'aujourdhui
    @Modifying
    @Query(value = "delete from Contracts c where c.exprirationDate=?1 " +
            "and c.renewable=FALSE",nativeQuery = true)
    int delete (Date todayDate);
}
