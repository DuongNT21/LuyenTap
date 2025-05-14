package com.DuongNT.LuyenTap.controller;

import com.DuongNT.LuyenTap.dto.request.CreateAccountRequest;
import com.DuongNT.LuyenTap.dto.response.CreateAccountResponse;
import com.DuongNT.LuyenTap.dto.response.GetAccountResponse;
import com.DuongNT.LuyenTap.service.interfaces.IAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {
    private final IAccountService accountService;

    @PostMapping("/create")
    public CreateAccountResponse createAccount(@RequestBody CreateAccountRequest request) {
        return accountService.createAccount(request);
    }

    @GetMapping("/get")
    public List<GetAccountResponse> getAllAccount() {
        return accountService.getAllAccount();
    }

    @GetMapping("/get/{id}")
    public GetAccountResponse getAccountById(@PathVariable int id){
        return accountService.getAccountById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAccount(@PathVariable int id) {
        accountService.deleteAccount(id);
    }

    @PutMapping("/update/{id}")
    public void updateAccount(@PathVariable int id, @RequestBody CreateAccountRequest request) {
        accountService.updateAccount(id, request);
    }

}
