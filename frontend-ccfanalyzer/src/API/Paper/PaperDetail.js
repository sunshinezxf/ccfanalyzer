import axios from 'axios'


axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=UTF-8'
axios.defaults.baseURL = 'http://47.97.228.185:8080'


// 获得论文全部信息
export const getPaperDetail = (paperId) => {
  return axios.get('/paper/simple/info?paperId=' + paperId).then(res => res.data)
}
//获得一篇论文全部引用

export const getPaperDetailref = (paperId) => {
  return axios.get('/paper/simple/info/ref?paperId=' + paperId).then(res => res.data)
}
