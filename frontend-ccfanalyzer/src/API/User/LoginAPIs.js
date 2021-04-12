import axios from 'axios'
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=UTF-8'
axios.defaults.baseURL = 'http://47.97.228.185:8080'

// 用户登录
export const Login = (name, password) => {

  return axios.post('/user/login?username=' + name + '&password=' + password).then(res => res.data)
}
