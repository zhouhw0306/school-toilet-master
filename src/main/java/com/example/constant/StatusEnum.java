package com.example.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusEnum {
    /**
     * status状态
     */
    WU_REN("0", "无人"),
    YOU_REN("1", "有人"),
    WEN_XIU("2", "维修中");
    /**
     * 状态
     */
    public final String code;
    /**
     * 名称
     */
    public final String name;

    /**
     * 根据code查找
     * @param code 枚举code
     * @return 枚举对象
     */
    public static String findEnumByCode(String code) {
        for (StatusEnum statusEnum : StatusEnum.values()) {
            if (statusEnum.getCode().equals(code)) {
                //如果需要直接返回name则更改返回类型为String,return statusEnum.name;
                return statusEnum.name;
            }
        }
        throw new IllegalArgumentException("code is invalid");
    }

    /**
     * 根据name查找
     * @param name 枚举name
     * @return 枚举对象
     */
    public static String findEnumByName(String name) {
        for (StatusEnum statusEnum : StatusEnum.values()) {
            if (statusEnum.getName().equals(name)) {
                //如果需要直接返回code则更改返回类型为String,return statusEnum.code;
                return statusEnum.code;
            }
        }
        throw new IllegalArgumentException("name is invalid");
    }

}