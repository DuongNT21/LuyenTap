package com.DuongNT.LuyenTap.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateAccountResponse {
    private int id;
    private String fullName;
    private String username;
    private String role;
}
