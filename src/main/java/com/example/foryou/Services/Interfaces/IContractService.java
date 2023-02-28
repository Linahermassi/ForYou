package com.example.foryou.Services.Interfaces;

import com.example.foryou.DAO.Entities.Contracts;

import java.util.List;

public interface IContractService {
    Contracts addContract (Contracts contract);
    Contracts editContract (Contracts contract);
    List<Contracts> selectAllContracts();
    Contracts SelectContractById(int contractId);
    void deleteContractById(int ContractId);
    void deleteContract (Contracts contract);
    List<Contracts> addAllContracts(List<Contracts> contractList);
    void deleteAllContracts (List<Contracts> contractList);
    void deleteAllContracts();
}
