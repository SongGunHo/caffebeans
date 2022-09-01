package com.its.caffebeans.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {
    private Long id;
    private String itmeName;
    private String itemText;
    private int itemPrice;
    private String isSoldout;
    private int cartCount;

    public ItemDTO(String itmeName, String itemText, int itemPrice, String isSoldout, int cartCount) {
        this.itmeName = itmeName;
        this.itemText = itemText;
        this.itemPrice = itemPrice;
        this.isSoldout = isSoldout;
        this.cartCount = cartCount;
    }
}
