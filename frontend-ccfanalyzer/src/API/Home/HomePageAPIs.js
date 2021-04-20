import axios from 'axios'


axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=UTF-8'
axios.defaults.baseURL = 'http://47.97.228.185:8080'

// 获得论文相关的统计数据
export const getStatistics = () => {
  return axios.get('/interests/statistics').then(res => res.data)
}


// 普通搜索论文（全匹配）
export const getCommonSearchResult = (searchMessage, index) => {
  return axios.get('/paper/search/common?searchMessage=' + searchMessage + '&index=' + index).then(res => res.data)
}

// 高级搜索论文
export const getAdvancedSearchResult = (advSearchMessage) => {
  console.log("!!!!!!!!!!!!!!!!!!!!!!")
  console.log(advSearchMessage)
  return axios.get('/paper/search/advanced?authors='+advSearchMessage.authors+'&affiliations='+advSearchMessage.affiliations+'&startYear='+advSearchMessage.startYear+'&endYear='+advSearchMessage.endYear+'&conferenceName='+advSearchMessage.conferenceName+'&keywords='+advSearchMessage.keywords+'&index='+advSearchMessage.index).then(res => res.data)
}


//作者搜索提示
export const getMatchAuthor = (input) => {
  return axios.get('/paper/matchAuthor?input='+input).then(res => res.data)
}

//机构搜索提示
export const getMatchAffiliation = (input) => {
  return axios.get('/paper/matchAffiliation?input='+input).then(res => res.data)
}

//会议搜索提示
export const getMatchConference = (input) => {
  return axios.get('/paper/matchConference?input='+input).then(res => res.data)
}
