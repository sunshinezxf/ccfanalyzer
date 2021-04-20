import axios from 'axios'
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=UTF-8'
axios.defaults.baseURL = 'http://47.97.228.185:8080'

// 管理员登录
export const adminLogin = (params) => {
  return axios.post('/admin/login', params).then(res => res.data)
}

// 获取历次更新数据的时间和新增论文数
export const getUpdateHistory = (index) => {
  return axios.get('/paper/update/history?index=' + index).then(res => res.data)
}
