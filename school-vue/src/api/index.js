/* eslint-disable*/
import { get, post, deletes } from './http'

// 是否登录成功
export const getLoginStatus = (params) => post(`admin/login/status`, params)

export const getTableData = (params) => get(`api/toilet/getAll`,params)

export const deleteById = (params) => get(`api/toilet/delete`,params)

export const updateOrAdd = (params) => get(`api/toilet/updateOradd`,params)

//初始化图表1数据
export const getDataByType = () => get(`api/toilet/getDatabytype`)
//初始化图表2数据
export const getDataByTu2 = () => get(`api/toilet/getDataByTu2`)
//初始化图表2数据
export const getDataByTu3 = () => get(`api/toilet/getDataByTu3`)
