import axios from 'axios'
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=UTF-8'
axios.defaults.baseURL = 'http://47.97.228.185:8080'


// 团队创建
export const TeamCreate  = (token, team_name) => {
  console.log(token)
  console.log(team_name)
  return axios.post('/team/create', token, team_name).then(res => res.data)
}

// 邀请成员
export const TeamInviteMember  = (token, invitee,team_id) => {
  return axios.post('/team/invite',token,invitee,team_id).then(res => res.data)
}

// 退出团队
export const TeamMemberQuit  = (token, team_id) => {

  return axios.post('/team/quit', token, team_id).then(res => res.data)
}

// 删除团队
export const TeamDelete  = (token, team_id) => {
  return axios.post('/team/delete', token, team_id).then(res => res.data)
}

// 踢出团队
export const TeamDeleteMember  = (token, team_id) => {
  return axios.post('/team/memberDelete', token, team_id).then(res => res.data)
}

// 团队列表查看
export const getTeamList = (token) => {
  return axios.get('/team/list?token=' + token).then(res => res.data)
}

// 团队成员查看
export const getTeamMember = (teamId) => {
  return axios.get('/team/list?team_id=' + teamId).then(res => res.data)
}

// 确认是否为某一团队队长
export const getTeamOwner = (token,teamId) => {
  return axios.get('/team/owner/check?token='+token+'?team_id=' + teamId).then(res => res.data)
}
