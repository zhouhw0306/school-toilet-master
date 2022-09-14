/* eslint-disable*/
import { get, post, deletes } from './http'

// =======================> 用户 API
// 是否登录成功
export const getLoginStatus = (params) => post(`admin/login/status`, params)
// 返回指定ID的用户
export const getUserOfId = (id) => get(`user/detail?id=${id}`)


// =======================> toilet API
export const getTableData = (params) => get(`api/toilet/getAll`,params)

export const deleteById = (params) => get(`api/toilet/delete`,params)

export const updateOrAdd = (params) => get(`api/toilet/updateOradd`,params)


// =======================> 统计 API
//初始化图表1数据
export const getDataByType = () => get(`api/toilet/getDatabytype`)
//初始化图表2数据
export const getDataByTu2 = () => get(`api/toilet/getDataByTu2`)
//初始化图表2数据
export const getDataByTu3 = () => get(`api/toilet/getDataByTu3`)


// =======================> 评论 API
// 添加评论
export const setComment = (params) => post(`api/comm/addComm`, params)
// 点赞
export const setLike = (params) => post(`api/comm/like`, params)
// 返回所有评论
export const getAllComment = (foreignId) => get(`api/comm/getComm?foreignId=${foreignId}`)
