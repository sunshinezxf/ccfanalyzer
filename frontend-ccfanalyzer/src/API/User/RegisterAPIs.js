import axios from 'axios'
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=UTF-8'
axios.defaults.baseURL = 'http://47.97.228.185:8080'

// 用户注册
export const Register = (name, password) => {
  return axios.post('/user/register?username=' + name + '&password=' + password).then(res => res.data)
}
