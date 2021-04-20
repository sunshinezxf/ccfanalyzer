import axios from 'axios'
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=UTF-8'
axios.defaults.baseURL = 'http://47.97.228.185:8080'
axios.defaults.withCredentials = true
// 用户登录
export const Login = (userForm) => {
  return axios.post('/user/login', userForm).then(res => res.data)
}

// 退出登录
export const Logout = (token) => {
  return axios.post('/user/logout', token).then(res => res.data)
}
