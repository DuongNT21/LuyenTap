package com.DuongNT.LuyenTap.service.interfaces;

import com.DuongNT.LuyenTap.dto.request.CreateAccountRequest;
import com.DuongNT.LuyenTap.dto.response.CreateAccountResponse;

public interface IAccountService {
    CreateAccountResponse createAccount(CreateAccountRequest request);
}
