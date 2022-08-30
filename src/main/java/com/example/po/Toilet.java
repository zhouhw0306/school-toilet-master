package com.example.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author zhou
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("tbl_toilet")
public class Toilet {
    //设置主键生成策略
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String type; //  1 小便池 2 蹲坑 3马桶
    private String status; // 0 无人  1 有人 2 维修中
    private String placeNo; // 所属大楼编号
    private String placeDetail; // 详细位置
    private String sex; // 1 男 0女
    private String health; // 1 干净 2 一般 3 肮脏
    private Integer useNum; // 今日使用次数
    private Integer useNumCount; // 使用次数
    private String setupTime; // 启用时间
    private String cleanTime; // 上次清洁时间
}
