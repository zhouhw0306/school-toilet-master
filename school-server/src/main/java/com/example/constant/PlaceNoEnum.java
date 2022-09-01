package com.example.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PlaceNoEnum {
    /**
     * status状态
     */
    QI_DENG("1","启德楼"),
    AI_XIN("2","爱心楼"),
    YI_FU("3","逸夫楼"),
    ZHI_YUAN("4","致远楼"),
    XIN_HUA("5","沁华楼");
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
        for (PlaceNoEnum placeNoEnum : PlaceNoEnum.values()) {
            if (placeNoEnum.getCode().equals(code)) {
                //如果需要直接返回name则更改返回类型为String,return statusEnum.name;
                return placeNoEnum.name;
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
        for (PlaceNoEnum placeNoEnum : PlaceNoEnum.values()) {
            if (placeNoEnum.getName().equals(name)) {
                //如果需要直接返回code则更改返回类型为String,return statusEnum.code;
                return placeNoEnum.code;
            }
        }
        throw new IllegalArgumentException("name is invalid");
    }
}
