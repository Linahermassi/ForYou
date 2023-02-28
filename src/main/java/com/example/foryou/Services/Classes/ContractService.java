package com.example.foryou.Services.Classes;

import com.example.foryou.DAO.Entities.Contracts;
import com.example.foryou.DAO.Repositories.ContractRepository;
import com.example.foryou.Services.Interfaces.IContractService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ContractService implements IContractService {
    private ContractRepository contractRepository;
    @Override
    public Contracts addContract(Contracts contract) {
        return contractRepository.save(contract);
    }
    @Override
    public List<Contracts> addAllContracts(List<Contracts> contractList) {
        return contractRepository.saveAll(contractList);
    }
    @Override
    public Contracts editContract(Contracts contract) {
        return contractRepository.save(contract);
    }
    @Override
    public void deleteContract(Contracts contract) {
        contractRepository.delete(contract);
    }
    @Override
    public void deleteContractById(int contractId) {
        contractRepository.deleteById(contractId);
    }
    @Override
    public void deleteAllContracts(List<Contracts> contractList) {
        contractRepository.deleteAll(contractList);
    }
    @Override
    public void deleteAllContracts() {
        contractRepository.deleteAll();
    }
    @Override
    public List<Contracts> selectAllContracts() {
        return contractRepository.findAll();
    }
    @Override
    public Contracts SelectContractById(int contractId) {
        return contractRepository.findById(contractId).get();
    }



}
