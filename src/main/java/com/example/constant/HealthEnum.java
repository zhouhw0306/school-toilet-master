package com.example.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HealthEnum {
    /**
     * status状态
     */
    GAN_JING("1", "干净"),
    YI_BAN("2", "一般"),
    ANG_ZHANG("3", "肮脏");
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
        for (HealthEnum healthEnum : HealthEnum.values()) {
            if (healthEnum.getCode().equals(code)) {
                //如果需要直接返回name则更改返回类型为String,return statusEnum.name;
                return healthEnum.name;
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
        for (HealthEnum healthEnum : HealthEnum.values()) {
            if (healthEnum.getName().equals(name)) {
                //如果需要直接返回code则更改返回类型为String,return statusEnum.code;
                return healthEnum.code;
            }
        }
        throw new IllegalArgumentException("name is invalid");
    }
}
