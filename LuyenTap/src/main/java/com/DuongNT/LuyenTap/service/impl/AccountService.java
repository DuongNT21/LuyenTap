package com.DuongNT.LuyenTap.service.impl;

import com.DuongNT.LuyenTap.dto.request.CreateAccountRequest;
import com.DuongNT.LuyenTap.dto.response.CreateAccountResponse;
import com.DuongNT.LuyenTap.dto.response.GetAccountResponse;
import com.DuongNT.LuyenTap.entity.Account;
import com.DuongNT.LuyenTap.enums.RoleEnum;
import com.DuongNT.LuyenTap.repository.AccountRepository;
import com.DuongNT.LuyenTap.service.interfaces.IAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService implements IAccountService {
    private final AccountRepository accountRepository;
    @Override
    public CreateAccountResponse createAccount(CreateAccountRequest request) {
        Account account = new Account();
        account.setActive(true);
        account.setRole(RoleEnum.USER);
        account.setCreatedDate(java.time.LocalDateTime.now());
        account.setFullName(request.getFullName());
        account.setUsername(request.getUserName());
        account.setPassword(request.getPassword());
        accountRepository.save(account);
        CreateAccountResponse response = new CreateAccountResponse();
        response.setId(account.getId());
        response.setFullName(account.getFullName());
        response.setUsername(account.getUsername());
        response.setRole(account.getRole().name());
        return response;
    }

    @Override
    public List<GetAccountResponse> getAllAccount() {
        List<Account> accounts = accountRepository.findAll();
        List<GetAccountResponse> responses = new ArrayList<>();
        for (Account account : accounts) {
            GetAccountResponse response = new GetAccountResponse();
            response.setFullName(account.getFullName());
            response.setUsername(account.getUsername());
            responses.add(response);
        }
        return responses;
    }

    @Override
    public GetAccountResponse getAccountById(int id) {
        Account account = accountRepository.findById(id).orElse(null);
        GetAccountResponse response = new GetAccountResponse();
        response.setFullName(account.getFullName());
        response.setUsername(account.getUsername());
        return response;
    }

    @Override
    public void deleteAccount(int id) {
        Account account = accountRepository.findById(id).orElse(null);
        accountRepository.delete(account);
    }

    @Override
    public void updateAccount(int id, CreateAccountRequest request) {
        Account account = accountRepository.findById(id).orElse(null);
        account.setFullName(request.getFullName());
        account.setUsername(request.getUserName());
        accountRepository.save(account);
    }

}
