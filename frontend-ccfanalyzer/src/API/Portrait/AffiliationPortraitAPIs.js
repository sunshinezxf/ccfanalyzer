import axios from 'axios'

axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=UTF-8'
axios.defaults.baseURL = 'http://47.97.228.185:8080'

// 查看机构画像
export const getAffiliationPortrait = (affiliationId) => {
  return axios.get('/portrait/affiliation?affiliationId=' + affiliationId).then(res => res.data)
}

// 查看机构相关论文
export const getAffiliationPaper = (affiliationId, index) => {
  return axios.get('/portrait/affiliation/papers?affiliationId=' + affiliationId + '&index=' + index).then(res => res.data)
}

// 获取机构雷达图基本值
export const getAffiliationValue = () => {
  return axios.get('/portrait/getValue/affiliation').then(res => res.data)
}
