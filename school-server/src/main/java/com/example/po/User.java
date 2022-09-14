package com.example.po;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhou
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("tbl_user")
public class User {
    private Integer id;
    private String username;
    private String password;
    private String nickname;
    private String address;
    private String createTime;

    @TableField(exist = false)
    private String token;
}
