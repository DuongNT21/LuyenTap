package com.DuongNT.LuyenTap.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class GetBookResponse {
    private int id;
    private String name;
    private String author;
    private int price;
    private LocalDateTime createdAt;
    private int categoryId;
}
