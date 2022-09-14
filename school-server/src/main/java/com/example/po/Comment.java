package com.example.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName tbl_comment
 */
@TableName(value ="tbl_comment")
@Data
public class Comment implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.ASSIGN_UUID)
    private Integer id;

    /**
     * 内容
     */
    private String content;

    /**
     * 用户名称
     */
    private String nickname;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 业务模块id
     */
    private Integer foreignId;

    /**
     * 父级评论id
     */
    private Integer pid;

    /**
     * 回复对象
     */
    private String target;

    /**
     * 建立时间
     */
    private Date createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}