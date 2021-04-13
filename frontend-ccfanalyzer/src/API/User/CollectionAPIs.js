import axios from 'axios'
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=UTF-8'
axios.defaults.baseURL = 'http://47.97.228.185:8080'
axios.defaults.withCredentials = true

// 获取用户收藏信息
export const getCollections = (token) => {
  return axios.get('/user/collection/list?token=' + token).then(res => res.data)
}

// 删除收藏文章
export const deleteCollection = (token, paperId) => {
  return axios.post('/user/delete?token=' + token + '&paper_id=' + paperId).then(res => res.data)
}
