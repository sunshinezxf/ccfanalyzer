import axios from 'axios'

axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=UTF-8'
axios.defaults.baseURL = 'http://47.97.228.185:8080'
// 查看学者画像
export const getAuthorPortrait = (authorId) => {
  return axios.get('/portrait/author/' + authorId).then(res => res.data)
}

// 查看作者相关的论文
export const getAuthorPaper = (authorId, index) => {
  return axios.get('/portrait/author/papers?authorId=' + authorId + '&index=' + index).then(res => res.data)
}
// 查看一个作者和与他相关作者之间的学术关系图谱
export const getAuthorMap = (authorId) => {
  return axios.get('/relationMap/author/single/' + authorId).then(res => res.data)
}
// 获取作者雷达图基本值
export const getAuthorValue = (authorId) => {
  return axios.get('/interests/getValue/author/' + authorId).then(res => res.data)
}

// 查看学者的研究方向变化趋势
export const getAuthorTrend = (authorId) => {
  return axios.get('/portrait/author/direction_trend?authorId=' + authorId).then(res => res.data)
}
