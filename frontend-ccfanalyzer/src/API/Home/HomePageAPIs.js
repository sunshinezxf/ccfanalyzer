import axios from 'axios'

axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=UTF-8'
axios.defaults.baseURL = process.env.NODE_ENV === 'production'
  ? 'http://47.97.288.185:8080'
  : 'http://localhost:3180'

// 获得论文相关的统计数据
export const getStatistics = () => {
  return axios.get('/interests/statistics').then(res => res.data)
}


// 普通搜索论文（全匹配）
export const getCommonSearchResult = (searchMessage, index) => {
  return axios.get('/paper/search/common?searchMessage=' + searchMessage + '&index=' + index).then(res => res.data)
}

// 高级搜索论文
export const getAdvancedSearchResult = (advSearchMessage) => {
  return axios.post('/paper/search/advanced', advSearchMessage).then(res => res.data)
}

// 管理员登录
export const adminLogin = (params) => {
  return axios.post('/admin/login', params).then(res => res.data)
}


