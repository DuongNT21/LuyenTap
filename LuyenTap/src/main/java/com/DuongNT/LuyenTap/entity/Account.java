package com.DuongNT.LuyenTap.entity;

import com.DuongNT.LuyenTap.enums.RoleEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fullName;
    private String username;
    private String password;
    private LocalDateTime createdDate;
    @Enumerated(EnumType.STRING)
    private RoleEnum role;
    private boolean active;
    private LocalDateTime updateAt;
}
