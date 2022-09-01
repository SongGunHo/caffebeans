package com.its.caffebeans.entiry;

import com.its.caffebeans.dto.GoodsDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "goods_2")
public class GoodsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goods_id")
    private Long goodsId;
    @Column
    private String goodsPrice;
    @Column
    private String goodsBenefits;
    @Column
    private String goodsBrand;
    @Column
    private String goodsCompany;
    @Column
    private String goodsOrigin;
    @Column
    private int goodsSize;
    @Column
    private String goodsTexture;
    @Column
    private String goodsFileName;


    public static GoodsEntity toSaveEntity(GoodsDTO goodsDTO) {
        GoodsEntity goodsEntity = new GoodsEntity();
        goodsEntity.setGoodsId(goodsDTO.getId());
        goodsEntity.setGoodsPrice(goodsDTO.getGoodsPrice());
        goodsEntity.setGoodsBenefits(goodsDTO.getGoodsBenefits());
        goodsEntity.setGoodsBrand(goodsDTO.getGoodsBrand());
        goodsEntity.setGoodsCompany(goodsDTO.getGoodsCompany());
        goodsEntity.setGoodsOrigin(goodsDTO.getGoodsOrigin());
        goodsEntity.setGoodsSize(0);
        goodsEntity.setGoodsTexture(goodsDTO.getGoodsTexture());
        goodsEntity.setGoodsFileName(goodsDTO.getGoodsFileName());
        return goodsEntity;
    }

    public static GoodsEntity toUpdateEntity(GoodsDTO goodsDTO) {
        GoodsEntity goodsEntity = new GoodsEntity();
        goodsEntity.setGoodsId(goodsDTO.getId());
        goodsEntity.setGoodsPrice(goodsDTO.getGoodsPrice());
        goodsEntity.setGoodsBenefits(goodsDTO.getGoodsBenefits());
        goodsEntity.setGoodsBrand(goodsDTO.getGoodsBrand());
        goodsEntity.setGoodsCompany(goodsDTO.getGoodsCompany());
        goodsEntity.setGoodsOrigin(goodsDTO.getGoodsOrigin());
        goodsEntity.setGoodsSize(0);
        goodsEntity.setGoodsTexture(goodsDTO.getGoodsTexture());
        goodsEntity.setGoodsFileName(goodsDTO.getGoodsFileName());
        return goodsEntity;
    }
}