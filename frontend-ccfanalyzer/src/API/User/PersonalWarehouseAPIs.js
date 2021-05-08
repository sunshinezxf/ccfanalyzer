import axios from 'axios'
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=UTF-8'
axios.defaults.baseURL = 'http://47.97.228.185:8080'

// 个人论文上传
export const PaperUpload = (params) => {
  return axios.post('/user/paperImport', params).then(res => res.data)
}

// 分享
export const PaperShare = (token, paperId, username) => {
  return axios.post('/user/share?token=' + token + '&paper_id=' + paperId + '&username=' + username).then(res => res.data)
}

// 修改论文
export const PaperUpdate = (params) => {
  return axios.post('/user/paperAlter', params).then(res => res.data)
}

// 获取私人文章
export const PaperInfo = (token) => {
  return axios.get('/warehouse/private/papers?token=' + token).then(res => res.data)
}
