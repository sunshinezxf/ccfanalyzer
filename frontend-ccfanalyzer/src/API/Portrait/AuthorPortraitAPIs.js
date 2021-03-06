import axios from 'axios'

axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=UTF-8'
axios.defaults.baseURL = 'http://47.97.228.185:8080'
// 查看学者画像
export const getAuthorPortrait = (authorId) => {
  return axios.get('/portrait/author/' + authorId).then(res => res.data)
}
