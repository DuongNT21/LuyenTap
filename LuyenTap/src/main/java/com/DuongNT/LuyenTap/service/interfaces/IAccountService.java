package com.DuongNT.LuyenTap.service.interfaces;

import com.DuongNT.LuyenTap.dto.request.CreateAccountRequest;
import com.DuongNT.LuyenTap.dto.response.CreateAccountResponse;
import com.DuongNT.LuyenTap.dto.response.GetAccountResponse;

import java.util.List;

public interface IAccountService {
    CreateAccountResponse createAccount(CreateAccountRequest request);
    List<GetAccountResponse> getAllAccount();
    GetAccountResponse getAccountById(int id);
    void deleteAccount(int id);
    void updateAccount(int id, CreateAccountRequest request);
}
