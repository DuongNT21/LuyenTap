package com.DuongNT.LuyenTap.repository;

import com.DuongNT.LuyenTap.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}
