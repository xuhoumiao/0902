package com.zuoye0831.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("goods")
public class Goods {
    @TableId("gid")
    private Integer gid;
    private String gname;
    private String number;
    private Double price;
    private Integer grounding;
    private Integer article;
    private Integer neww;
    private Integer hot;
    private Integer click;
    private Integer stock;
    private Integer cid;
    private Integer bid;
    @TableField(exist = false)
    private Classify classify;
    @TableField(exist = false)
    private Brand brand;
}
