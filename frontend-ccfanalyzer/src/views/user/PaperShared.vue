<template>
<el-container>
  <el-header class="header" style="overflow: hidden;padding: 0%">
    <div style="margin-left: -19px;margin-right: -19px;text-align:center">
      <el-row style="margin-bottom: 0%">
        <el-col :span="4">
          <div class="grid-content2 bg-purple2" style="color: white;text-align:center">

            <el-row>
                <span class="avatar-dropdown">
                  <i class="el-icon-s-home" ></i>
                  <span class="u" style="font-size: 20px;color: grey;text-align: center">
                  &nbsp;&nbsp;HomePage &nbsp;
               </span>
                </span>
            </el-row>

          </div>
        </el-col>

        <el-col :span="17">
          <div class="grid-content2 bg-purple2" style="color: white;">

            <el-row style="margin-bottom: -8%"></el-row>
          </div>
        </el-col>
        <el-col :span="3"><div class="grid-content2 bg-purple2" style="color: white;">
          <div v-show="user.login">
            <el-dropdown @command="handleCommand">
               <span class="avatar-dropdown">
                <!--<el-avatar class="user-avatar" :src="avatar"></el-avatar>-->
                <el-avatar src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"></el-avatar>

               <span class="u" style="font-size: 20px">
                  &nbsp;&nbsp;{{ user.username }} &nbsp;
               </span>

                 <i class="el-icon-arrow-down el-icon--right"></i>
              </span>
              <el-dropdown-menu slot="dropdown">
                <el-dropdown-item command="logout" divided>退出登录</el-dropdown-item>
              </el-dropdown-menu>
            </el-dropdown>
          </div>

          <div v-show="user.logout">

                 <span class="avatar-dropdown">
                      <!--<el-avatar class="user-avatar" :src="avatar"></el-avatar>-->
                      <el-avatar src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"></el-avatar>

                     <span class="u" style="font-size: 20px">
                        &nbsp;&nbsp; Login&nbsp;In&nbsp;&nbsp;
                     </span>

                    </span>
          </div>
        </div>
        </el-col>
      </el-row>
    </div>

    <el-dialog
      title="Administrator Login"
      :visible.sync="dialogVisible"
      width="30%"
      center>
      <div style="text-align:center">
        <el-input style="width: 70%" placeholder="username" v-model="username" clearable></el-input>
      </div>
      <div style="text-align:center">
        <el-input style="width: 70%; margin-top: 5%" placeholder="password" v-model="password" show-password></el-input>
      </div>
      <span slot="footer" class="dialog-footer">
        <el-button style="width: 70%; margin-bottom: 5%; font-size: large" type="primary" @click="dialogVisible = true; login()">LOGIN</el-button>
      </span>
    </el-dialog>
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
            <span slot="title">我的团队</span>
          </el-menu-item>
          <el-menu-item index="/PersonalWarehouse">
            <i class="el-icon-menu"></i>
            <span slot="title">个人仓库</span>
          </el-menu-item>
          <el-menu-item index="/Collections">
            <i class="el-icon-document"></i>
            <span slot="title">我的收藏</span>
          </el-menu-item>
          <el-menu-item index="/PaperShared">
            <i class="el-icon-reading"></i>
            <span slot="title">分享文章</span>
          </el-menu-item>
        </el-menu>
      </el-col>
    </el-aside>
    <el-main class="main">
      <div>
        <br>
        <div class="col-md-2 text-center" v-for="item in PaperList" :key="item.title">
          <el-card style="margin-left: 35px; margin-right: 45px;height: 100%">
            <div style="margin-left: 2%;margin-left: 2%">
              <el-link style="font-size: 27px;color: black" @click="getContent(item.paperId)"><strong>{{item.title}}</strong></el-link><br>
              <el-row>
            <span class="affcon" style="font-size: 17px;color: dimgray">
              Publisher:&nbsp;&nbsp;&nbsp;
              <span  class="divider" v-if="item.publisher==0">None</span>
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
            <el-link style="font-size: 17px;color: cornflowerblue;font-style:italic" :key="author" >{{author.name}}</el-link>
            </span>
            </span>
              </el-row>
              <span class="sum" style="font-size: 15px;color: dimgray;margin-top: 5px;margin-bottom: 5px" v-if="item.abstracts" >{{item.abstracts}}</span>
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
import {SharedPapers} from '../../API/User/PaperSharedAPIs'

export default {
  name: 'PaperShared',
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
          paper_id: 0,
          title: 'Learning Styles and Inclusion.',
          authors: [{
            name: 'apple'
          }, {
            name: 'bear'
          }],
          publisher: 'IEEE',
          abstracts: 'Learning Models and the Learning Cycle Learning Differences and Learning Styles The Role of the Learning Environment Background to Learning Styles Assessment of Learning Styles Learning Styles Learning and Teaching The Inclusive School Characteristics and Challenges Learning Styles in the Inclusive Context Promoting Effective Learning Learning Styles Strategies and Insights',
          doi: '',
          year: ''
        }
      ],
      page: 0
    }
  },
  mounted () {
    this.user.username = this.user.username = localStorage.getItem('username')
    this.user.token = localStorage.getItem('token')
    this.getSharedPaper(this.user.token)
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
    },
    getSharedPaper (token) {
      SharedPapers(token).then((res) => {
        this.PaperList = res.content.Private_Paper_Must
      })
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
