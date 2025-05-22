package com.DuongNT.LuyenTap.controller;

import com.DuongNT.LuyenTap.dto.request.CreateAccountRequest;
import com.DuongNT.LuyenTap.dto.response.BaseResponse;
import com.DuongNT.LuyenTap.dto.response.CreateAccountResponse;
import com.DuongNT.LuyenTap.dto.response.CreateBookResponse;
import com.DuongNT.LuyenTap.dto.response.GetAccountResponse;
import com.DuongNT.LuyenTap.entity.Account;
import com.DuongNT.LuyenTap.service.interfaces.IAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {
    private final IAccountService accountService;

    @PostMapping("/create")
    public ResponseEntity<BaseResponse> createAccount(@RequestBody CreateAccountRequest request) {
        CreateAccountResponse accountResponse =  accountService.createAccount(request);
        return ResponseEntity.ok(
                new BaseResponse(
                        "200",
                        "Create account",
                        accountResponse
                )
        );
    }

    @GetMapping("/get")
    public ResponseEntity<BaseResponse> getAllAccount() {
        List<GetAccountResponse> accounts = accountService.getAllAccount();
        return ResponseEntity.ok(
                new BaseResponse(
                        "200",
                        "Get all account",
                        accounts
                )
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<BaseResponse> getAccountById(@PathVariable int id){
        GetAccountResponse response = accountService.getAccountById(id);
        return ResponseEntity.ok(
                new BaseResponse(
                        "200",
                        "Get account",
                        response
                )
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<BaseResponse> deleteAccount(@PathVariable int id) {
        accountService.deleteAccount(id);
        return ResponseEntity.ok(
                new BaseResponse(
                        "200",
                        "Delete account",
                        null
                )
        );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BaseResponse> updateAccount(@PathVariable int id, @RequestBody CreateAccountRequest request) {
        accountService.updateAccount(id, request);
        return ResponseEntity.ok(
                new BaseResponse(
                        "200",
                        "Update account",
                        null
                )
        );
    }

}
