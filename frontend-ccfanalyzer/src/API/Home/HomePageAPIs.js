import axios from 'axios'


axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=UTF-8'
axios.defaults.baseURL = 'http://47.97.228.185:8080'

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
  console.log("fdsa")
  console.log(advSearchMessage.authors)
  return axios.get('/paper/search/advanced?authors='+advSearchMessage.authors+'&affiliations='+advSearchMessage.affiliations+'&startYear='+advSearchMessage.startYear+'&endYear='+advSearchMessage.endYear+'&conferenceName='+advSearchMessage.conferenceName+'&keywords='+advSearchMessage.keywords+'&index='+advSearchMessage.index).then(res => res.data)
}

// 管理员登录
export const adminLogin = (params) => {
  return axios.post('/admin/login', params).then(res => res.data)
}


