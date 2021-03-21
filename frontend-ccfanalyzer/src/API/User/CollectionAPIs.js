import axios from 'axios'
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=UTF-8'
axios.defaults.baseURL = 'http://47.97.228.185:8080'

// 获取用户收藏信息
export const getCollections = (userId) => {
  return axios.get('/user/collection/list?user_id=' + userId).then(res => res.data)
}

// 删除收藏文章
export const deleteCollection = (userId, paperId) => {
  return axios.post('/user/delete?user_id=' + userId + '&paper_id=' + paperId).then(res => res.data)
}
