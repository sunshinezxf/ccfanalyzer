import axios from 'axios'

axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=UTF-8'
axios.defaults.baseURL = 'http://47.97.228.185:8080'
// 查看会议画像
export const getConferencePortrait = (conferenceId) => {
  return axios.get('/portrait/conference/' + conferenceId).then(res => res.data)
}

// 查看会议相关的论文
export const getConferencePaper = (conferenceId, index) => {
  return axios.get('/portrait/conference/papers?conferenceId=' + conferenceId + '&index=' + index).then(res => res.data)
}
