<template>
<el-container>
  <el-header class="header" :style ="this.$store.state.background" style="overflow: hidden;padding: 0%">
    <div><lo></lo></div>
  </el-header>
  <el-container>
    <el-aside class="side" width="200px">
      <el-col :span="50">
        <el-menu
          default-active="$route.path"
          class="el-menu-vertical-demo"
          @open="handleOpen"
          @close="handleClose"
          background-color="#545c64"
          text-color="#fff"
          active-text-color="#ffd04b"
          :router="true"
          :span="2" :style="containerHeight">
          <el-menu-item index="/MyTeams">
            <i class="el-icon-menu"></i>
            <span slot="title">MyTeams</span>
          </el-menu-item>
          <el-menu-item index="/PersonalWarehouse">
            <i class="el-icon-menu"></i>
            <span slot="title">PersonalWarehouse</span>
          </el-menu-item>
          <el-menu-item index="/Collections">
            <i class="el-icon-document"></i>
            <span slot="title">MyCollections</span>
          </el-menu-item>
          <el-menu-item index="/PaperShared">
            <i class="el-icon-reading"></i>
            <span slot="title">PaperShared</span>
          </el-menu-item>
        </el-menu>
      </el-col>
    </el-aside>
    <el-main class="main">
      <div>
        <br>
        <h1 style="margin-left: 3%;color:black;">Results: {{paperNum}} Papers</h1>
        <div class="col-md-2 text-center" v-for="item in PaperList" :key="item.title">
          <el-card style="margin-left: 35px; margin-right: 45px;height: 100%">
            <div style="margin-left: 2%;margin-left: 2%">
              <el-link style="font-size: 27px;color: black" @click="getContent(item.paperId)"><strong>{{item.title}}</strong></el-link><br>
              <el-row>
              <span class="affcon" style="font-size: 17px;color: dimgray">
                Affiliations:&nbsp;&nbsp;&nbsp;
                <span  class="divider" v-if="item.affiliations.length==0">None</span>
              <span  v-for="(aff,index) in item.affiliations" :key="index">
                <span role="separator" class="divider" v-if="index != 0">,</span>
                <el-link style="font-size: 17px;color: cornflowerblue;font-style:italic"  :key='aff' @click="searchAffiliationPor(aff.affiliationId)">{{aff.name}}</el-link>
              </span>
              </span>
              </el-row>
              <el-row>
              <span class="affcon" style="font-size: 17px;color: dimgray">
                Authors:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <span  class="divider" v-if="item.authors.length==0">None</span>
              <span v-for="(author,index) in item.authors" :key="index">
                <span role="separator" class="divider" v-if="index != 0">,</span>
              <el-link style="font-size: 17px;color: cornflowerblue;font-style:italic" :key="author" @click="searchAuthorPor(author.authorId)">{{author.name}}</el-link>
              </span>
              </span>
              </el-row>
              <span class="sum" style="font-size: 15px;color: dimgray;margin-top: 5px;margin-bottom: 5px" v-if="item.summary" >{{item.summary}}</span>
              <el-row>
              <span class="affcon" style="font-size: 17px;color: dimgray">
                Keywords:&nbsp;&nbsp;&nbsp;
                <span  class="divider" v-if="item.keywords.length==0">None</span>
              <span v-for="(keyword,index) in item.keywords" :key="index">
                <span role="separator" class="divider" v-if="index != 0">,</span>
              <el-link style="font-size: 17px;color: cornflowerblue;font-style:italic" :key="keyword" @click="searchByKeyword(keyword)">{{keyword}}</el-link>
              </span>
                </span>
              </el-row>
              <el-row>
                <span style="font-size: 17px;color: dimgray">Publication:&nbsp;&nbsp;<el-link style="font-size: 17px;color: cornflowerblue;font-style:italic" @click="searchConferencePor(item.publication)">{{item.publication}}</el-link></span><br>
              </el-row>
            </div>
           <div  style="text-align:right">
             <el-button type="primary" icon="el-icon-delete" @click="deletePaper(user.id, item.paperId)"></el-button>
           </div>
          </el-card>
        </div>
        <el-pagination
          @current-change="handleCurrentChange"
          :page-size="10"
          :page-count="page"
          layout="prev, pager, next"
          :total="paperNum"
          style="text-align: center;font-size: 20px;">
        </el-pagination>
      </div>
    </el-main>
  </el-container>
</el-container>
</template>

<script>
import {getCollections, deleteCollection} from '../../API/User/CollectionAPIs'
import lo from '../../components/Center'

export default {
  components: {
    lo
  },
  name: 'Collections',
  data () {
    return {
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
            id: 1
          }, {
            name: 'bear',
            id: 2
          }],
          affiliations: [{
            name: 'NJU',
            id: 1
          }, {
            name: 'ZJU',
            id: 2
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
    this.user.username = localStorage.getItem('username')
    this.user.token = localStorage.getItem('token')
    this.getCollections(this.user.token)
  },
  created () {
    var docHeight = document.documentElement.clientHeight
    this.containerHeight.height = docHeight - 40 + 'px'
  },
  methods: {
    handleOpen (key, keyPath) {
      console.log(key, keyPath)
    },
    handleClose (key, keyPath) {
      console.log(key, keyPath)
    },
    getCollections (userID) {
      getCollections(userID).then((res) => {
        console.log(res)
        this.PaperList = res.content.paperBriefInfoVOList
        this.paperNum = res.content.totalNum
      })
    },
    deletePaper (userId, paperId) {
      deleteCollection(userId, paperId).then((res) => {
        this.$message.success({
          message: res.content,
          center: true
        })
      })
    },
    getContent (e) {
      let newpage = this.$router.resolve({
        name: 'PaperDetail',
        query: {
          paperId: e
        }
      })
      window.open(newpage.href, '_blank')
    },
    searchAffiliationPor (affiliationId) {
      let newpage = this.$router.resolve({
        name: 'AffiliationPortrait',
        query: {
          affiliationId: affiliationId
        }
      })
      window.open(newpage.href, '_blank')
    },
    searchAuthorPor (authorId) {
      let newpage = this.$router.resolve({
        name: 'AuthorPortrait',
        query: {
          authorId: authorId
        }
      })
      window.open(newpage.href, '_blank')
    }
  }
}
</script>

<style scoped>
  &:last-child {
     margin-bottom: 0;
   }
  .bg-purple2 {
    background-color: rgba(192, 192, 192, 0.43);
  }
  .grid-content2 {
    min-height: 60px;
  }
  .avatar-dropdown {
    display: flex;
    align-content: center;
    align-items: center;
    justify-content: center;
    justify-items: center;
    height: 50px;
    padding: 0;
    font-size: 30px;
  }
  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }
  .clearfix:after {
    clear: both
  }
  .image {
    width: 100%;
    display: block;
  }
  .el-select-dropdown__item span{
    opacity: 80%;
  }
  .image {
    width: 100%;
    display: block;
  }
</style>
