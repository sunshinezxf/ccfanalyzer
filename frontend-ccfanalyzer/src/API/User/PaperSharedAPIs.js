import axios from 'axios'
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=UTF-8'
axios.defaults.baseURL = 'http://47.97.228.185:8080'

// 查看被分享的文章
export const SharedPapers = (token) => {
  return axios.get('/user/receive/private_paper?token=' + token).then(res => res.data)
}
