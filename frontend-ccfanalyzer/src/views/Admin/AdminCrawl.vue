<template>
<el-container>
  <el-header class="header" :style ="this.$store.state.background" style="overflow: hidden;padding: 0%">
    <div><lo2></lo2></div>
  </el-header>
  <el-container>
    <div style="text-align: center;margin-right: -30%">
    <h1>Crawler management</h1>
    <br>
      <el-row>
      <el-col :span="20">
        <el-input v-model="input" placeholder="Link" style="width: 90%"></el-input>
      </el-col>
      <el-col :span="4" >
        <el-button type="warning" plain @click="Startcrawler">Start crawler</el-button>
      </el-col>
      </el-row>
      <br>
      <el-row>

    <el-table :data="gridData">
      <el-table-column property="startTime" label="startTime" width="150"></el-table-column>

      <el-table-column property="finishTime" label=" finishTime" width="150"></el-table-column>
      <el-table-column property="finishTime" label=" finishTime" width="150"></el-table-column>
      <el-table-column property="requestBytes" label="requestBytes" width="120"></el-table-column>
      <el-table-column property="requestCount" label="requestCount" width="120"></el-table-column>
      <el-table-column property="countGET" label="countGET" width="90"></el-table-column>
      <el-table-column property="count200" label="count200" width="90"></el-table-column>
      <el-table-column property="count301" label="count301" width="90"></el-table-column>
      <el-table-column property="count302" label="count302" width="90"></el-table-column>
      <el-table-column property="count40x" label="count40x" width="90"></el-table-column>


      <el-table-column property="paperCount" label="paperCount" width="120"></el-table-column>
      <el-table-column property="meetingCount" label="meetingCount" width="120"></el-table-column>

    </el-table>
        <br>
        <br>
      </el-row>
      <span>
        <div v-show="cr" style="font-size: 22px">{{input }} is crawling!!!!!</div>
      </span>

      <br>
      </div>

  </el-container>
</el-container>
</template>

<script>
  import {
    getCrawl
    //   getAffiliationActivityRanking, getAuthorActivityRanking, getResearchDirectionPopularityRanking, getTopPapers, getTopAffiliations, getTopAuthors,  adminLogin,
  } from '../../API/Home/HomePageAPIs'
  import {
    openCrawl
  } from '../../API/Admin/AdminLoginAPI'
import lo2 from '../../components/Center2'

export default {
  components: {
    lo2
  },
  name: 'AdminCrawl',
  data () {
    return {
      gridData:[],
      input:'',
      cr:false,
      message:'',
      user: {
        login: true,
        logout: false,
        username: 'yry',
        password: '',
        id: '',
        token: ''
      },
      username: '',
      password: '',
      containerHeight: {
        height: ''
      },
      paperNum: 8,
      PaperList: [
        {
          paperId: 0,
          title: 'Learning Styles and Inclusion.',
          authors: [{
            name: 'apple',
            authorId: 1
          }, {
            name: 'bear',
            authorId: 2
          }],
          affiliations: [{
            name: 'NJU',
            affiliationId: 1
          }, {
            name: 'ZJU',
            affiliationId: 2
          }],
          publication: 'IEEE',
          summary: 'Learning Models and the Learning Cycle Learning Differences and Learning Styles The Role of the Learning Environment Background to Learning Styles Assessment of Learning Styles Learning Styles Learning and Teaching The Inclusive School Characteristics and Challenges Learning Styles in the Inclusive Context Promoting Effective Learning Learning Styles Strategies and Insights',
          keywords: ['Educational technology']
        }
      ],
      page: 0
    }
  },
  mounted () {

    this.getC()
  },
  created () {
    var docHeight = document.documentElement.clientHeight
    this.containerHeight.height = docHeight - 40 + 'px'
  },
  methods: {
    Startcrawler(){
      this.cr=true
      openCrawl(this.input).then(res => {
        console.log(res)
        this.message=res.content
      }).catch(error => console.log(error))
    },
    getC(){
      getCrawl().then(res => {
        this.gridData=res.content
      }).catch(error => console.log(error))
    }
  }
}
</script>

<style scoped>

</style>
