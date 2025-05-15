package com.DuongNT.LuyenTap.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateBookRequest {
    private String name;
    private String author;
    private int price;
    private int categoryId;
}
