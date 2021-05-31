import axios from 'axios'
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=UTF-8'
axios.defaults.baseURL = 'http://47.97.228.185:8080'


export const openCrawl = (link) => {
  return axios.get('/admin/crawl?link=' + link).then(res => res.data)
}
