package com.example.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SexEnum {
    /**
     * status状态
     */
    MAN("1", "男"),
    WOMAN("0", "女");
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
        for (SexEnum sexEnum : SexEnum.values()) {
            if (sexEnum.getCode().equals(code)) {
                //如果需要直接返回name则更改返回类型为String,return statusEnum.name;
                return sexEnum.name;
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
        for (SexEnum sexEnum : SexEnum.values()) {
            if (sexEnum.getName().equals(name)) {
                //如果需要直接返回code则更改返回类型为String,return statusEnum.code;
                return sexEnum.code;
            }
        }
        throw new IllegalArgumentException("name is invalid");
    }
}
