package com.DuongNT.LuyenTap.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateAccountRequest {
    private String fullName;
    private String userName;
    private String password;
}
