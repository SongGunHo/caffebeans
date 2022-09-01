package com.its.caffebeans.dto;

import com.its.caffebeans.entiry.GoodsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsDTO {
    private Long id;
    private String goodsPrice;
    private String goodsBenefits;
    private String goodsBrand;
    private String goodsCompany;
    private String goodsOrigin;
    private int goodsSize;
    private String goodsTexture;

    private MultipartFile goodsFile;
    private String goodsFileName;

    public GoodsDTO(String goodsPrice, String goodsBenefits, String goodsBrand, String goodsCompany, String goodsOrigin, int goodsSize, String goodsTexture, MultipartFile goodsFile, String goodsFileName) {
        this.goodsPrice = goodsPrice;
        this.goodsBenefits = goodsBenefits;
        this.goodsBrand = goodsBrand;
        this.goodsCompany = goodsCompany;
        this.goodsOrigin = goodsOrigin;
        this.goodsSize = goodsSize;
        this.goodsTexture = goodsTexture;
        this.goodsFile = goodsFile;
        this.goodsFileName = goodsFileName;
    }

    public static GoodsDTO toGoodsDTO(GoodsEntity goods) {
        GoodsDTO goodsDTO = new GoodsDTO();
        goodsDTO.setId(goods.getGoodsId());
        goodsDTO.setGoodsPrice(goods.getGoodsPrice());
        goodsDTO.setGoodsBenefits(goods.getGoodsBenefits());
        goodsDTO.setGoodsBrand(goods.getGoodsBrand());
        goodsDTO.setGoodsCompany(goods.getGoodsCompany());
        goodsDTO.setGoodsOrigin(goods.getGoodsOrigin());
        goodsDTO.setGoodsSize(0);
        goodsDTO.setGoodsTexture(goods.getGoodsTexture());
        goodsDTO.setGoodsFileName(goods.getGoodsFileName());
        return goodsDTO;
    }
}
