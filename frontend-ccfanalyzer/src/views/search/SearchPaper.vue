<template>
  <div style="overflow: hidden">
  <el-container >
    <div id="link"></div>
    <el-header class="headerr" :style ="this.$store.state.background" height="230px">
      <div style="margin-left: -19px;margin-right: -19px;text-align:center">
        <el-row style="margin-bottom: 1%">
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
          <el-button style="width: 70%; margin-bottom: 5%; font-size: large" type="primary" @click="dialogVisible = false; login()">LOGIN</el-button>
        </span>
      </el-dialog>



      <el-row>
        <el-col :span="4">
          <el-row>
            <div class="OASIS" id="OASIS" style="font-weight:bold;color:white;font-size: 40px;text-align:center;margin-top: 4%"
                 @mouseenter="highlight" @mouseout="redoHightLight" @click="toHomepage">
              CCF ANALYZER
            </div>
          </el-row>
          <!--<el-row><div class="OASIS" style="color:white;font-size: 17px;text-align:center; ">-->
          <!--OASIS/Search-->
          <!--</div>-->
          <!--</el-row>-->
        </el-col>
        <el-col :span="20">
        <!--普通搜索-->
        <div style="text-align: center;">
          <el-select v-model="commonSearchTypeValue" clearable placeholder="All" style="opacity:80%; width: 10%;text-align: left;position:relative; z-index:9999;" :popper-append-to-body="false">
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
          <el-input
            style="opacity:80%;width:50%; justify-content: center;;margin-top: 4%"
            placeholder="Enter something..."
            v-model="commonInput"
            :disabled="searching"
            @keyup.enter.native="commonSearch"
            clearable>
          </el-input>

          <el-button @click="commonSearch" type="primary" icon="el-icon-search" :loading="searching">SEARCH</el-button>

        </div>
      </el-col>
      </el-row>
    </el-header>
    <el-main >
      <div v-show="showSearchContent">
        <br>
        <h1 style="margin-left: 3%;color:black;">Search: {{searchContent}}</h1>
      </div>
      <br>
      <h1 style="margin-left: 3%;color:black;">Results: {{paperNum}} Papers:</h1>
      <br>

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
          </el-card>
            <br>
          <!--<el-col :span="2">-->
            <!--<el-button icon="el-icon-d-arrow-right" circle style="height: 60px;width: 60px;margin-top: 70px" @click="getContent(item.paperId)"></el-button>-->
          <!--</el-col>-->
      </div>
      <br>
        <span class="demonstration">&nbsp;</span>
        <el-pagination
          @current-change="handleCurrentChange"
          :page-size="10"
          :page-count="page"
          layout="prev, pager, next"
          :total="paperNum"
        style="text-align: center;font-size: 20px;">
        </el-pagination>
    </el-main>

  </el-container>
  </div>
</template>

<script>
  import {
    getCommonSearchResult, getAdvancedSearchResult,
    //   getAffiliationActivityRanking, getAuthorActivityRanking, getResearchDirectionPopularityRanking, getTopPapers, getTopAffiliations, getTopAuthors,  adminLogin,
  } from '../../API/Home/HomePageAPIs'

export default {

  data () {
    return {
      user:{
        login: true,
        logout: false,
        username: 'yry',
        password: '',
      },
      searchContent: ' ',
      showSearchContent: true,
      commonSearchTypeValue: '',
      searching: false,
      paperNum: 1,
      page: 0,
      options: [
        {
          value: 'author',
          label: 'Author'
        }, {
          value: 'affiliation',
          label: 'Affiliation'
        }, {
          value: 'keyword',
          label: 'Keyword'
        }],
      commonInput: '',
      advSearchForm: {
        authors: [],
        affiliations: [],
        startYear: 2013,
        endYear: 2020,
        conferenceName: '',
        keywords: [],
        index:0
      },
      maxlen: 250,
      background: {
        backgroundImage: 'url(' + require('@/assets/background.jpg') + ')',
        backgroundRepeat: 'no-repeat',
        backgroundSize: 'cover'
      },

      PaperList: [
        {
          paperId: 0,
          title: 'Learning Styles and Inclusion.',
          authors: ['Gavin Reid', 'YRY'],
          affiliations: ['NJU', 'NJU'],
          publication: 'IEEE',
          summary: 'Learning Models and the Learning Cycle Learning Differences and Learning Styles The Role of the Learning Environment Background to Learning Styles Assessment of Learning Styles Learning Styles Learning and Teaching The Inclusive School Characteristics and Challenges Learning Styles in the Inclusive Context Promoting Effective Learning Learning Styles Strategies and Insights',
          keywords: ['Educational technology']
        }
      ]
    }
  },
  methods: {
    maxSlice (v) {
      return v.length > this.maxlen ? v.slice(0, this.maxlen) + '...' : v
    },
    commonSearch () {
      if (this.searching) {
        return
      }
      if (this.commonInput !== '') {
        this.searching = true
        let paperList = []
        let total = 0
        if (this.commonSearchTypeValue === '') { // type为All
          getCommonSearchResult(this.commonInput, 0).then((res) => {
            if (res.success) {
              paperList = res.content.paperBriefInfoVOList
              total = res.content.totalNum
              this.searching = false
              let newpage = this.$router.resolve({
                name: 'SearchPaper',
                query: {
                  papers: JSON.stringify(paperList),
                  totalNum: total,
                  content: this.commonInput,
                  kind: 0
                }
              })
              window.open(newpage.href, '_blank')
            } else {
              this.searching = false
              this.$message.error({
                message: res.status.msg,
                center: true
              })
            }
          }).catch(error => console.log(error))
        } else { // type有值
          if (this.commonSearchTypeValue === 'author') {
            this.advSearchForm.authors = [this.commonInput]
            let paperList = []
            let total = 0
            getAdvancedSearchResult(this.advSearchForm).then((res) => {
              if (res.success) {
                console.log(res.content.totalNum)
                paperList = res.content.paperBriefInfoVOList
                total = res.content.totalNum
                this.searching = false
                let newpage = this.$router.resolve({
                  name: 'SearchPaper',
                  query: {
                    papers: JSON.stringify(paperList),
                    totalNum: total,
                    content: this.commonInput,
                    kind: 0
                  }
                })
                window.open(newpage.href, '_blank')
              } else {
                this.searching = false
                this.$message.error({
                  message: res.status.msg,
                  center: true
                })
              }
            }).catch(error => console.log(error))
          } else if (this.commonSearchTypeValue === 'affiliation') {
            this.advSearchForm.affiliations = [this.commonInput]
            let paperList = []
            let total = 0
            getAdvancedSearchResult(this.advSearchForm).then((res) => {
              if (res.success) {
                paperList = res.content.paperBriefInfoVOList
                total = res.content.totalNum
                this.searching = false
                let newpage = this.$router.resolve({
                  name: 'SearchPaper',
                  query: {
                    papers: JSON.stringify(paperList),
                    totalNum: total,
                    content: this.commonInput,
                    kind: 0
                  }
                })
                window.open(newpage.href, '_blank')
              } else {
                this.searching = false
                this.$message.error({
                  message: res.status.msg,
                  center: true
                })
              }
            }).catch(error => console.log(error))
          } else if (this.commonSearchTypeValue === 'keyword') {
            this.advSearchForm.keywords = [this.commonInput]
            let paperList = []
            let total = 0
            getAdvancedSearchResult(this.advSearchForm).then((res) => {
              if (res.success) {
                paperList = res.content.paperBriefInfoVOList
                total = res.content.totalNum
                this.searching = false
                let newpage = this.$router.resolve({
                  name: 'SearchPaper',
                  query: {
                    papers: JSON.stringify(paperList),
                    totalNum: total,
                    content: this.commonInput,
                    kind: 0
                  }
                })
                window.open(newpage.href, '_blank')
              } else {
                this.searching = false
                this.$message.error({
                  message: res.status.msg,
                  center: true
                })
              }
            }).catch(error => console.log(error))
          }
        }
      } else {
        this.$message({
          message: 'Please Enter Something!',
          center: true
        })
      }
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
    searchAffiliationPor (affiliationId) {
      let newpage = this.$router.resolve({
        name: 'AffiliationPortrait',
        query: {
          affiliationId: affiliationId
        }
      })
      window.open(newpage.href, '_blank')
    },
     searchConferencePor (name) {
      let newpage = this.$router.resolve({
        name: 'ConferencePortrait',
        query: {
          name: name
        }
      })
      window.open(newpage.href, '_blank')
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
    searchByKeyword (name) {
    //   this.advSearchForm.keywords = [name]
    //   let paperList = []
    //   let total = 0
    //   getAdvancedSearchResult(this.advSearchForm).then((res) => {
    //     paperList = res.content.paperBriefInfoVOList
    //     total = res.content.totalNum
    //     let newpage = this.$router.resolve({
    //       name: 'SearchPaper',
    //       query: {
    //         papers: JSON.stringify(paperList),
    //         totalNum: total,
    //         content: this.advSearchForm,
    //         kind: 0
    //       }
    //     })
    //     window.open(newpage.href, '_blank')
    //   }).catch(error => console.log(error))
     },
    handleCurrentChange (val) {
    //   this.page = val - 1
    //   if (this.$route.query.kind === '0') {
    //     getCommonSearchResult(this.$route.query.content, this.page).then((res) => {
    //       this.PaperList = res.content.paperBriefInfoVOList
    //     }).catch(error => console.log(error))
    //   }
    //   if (this.$route.query.kind === '1') {
    //     let newin = this.$route.query.content
    //     newin.index = this.page
    //     getAdvancedSearchResult(this.$route.query.content).then((res) => {
    //       this.PaperList = res.content.paperBriefInfoVOList
    //     }).catch(error => console.log(error))
    //   }
    //   document.querySelector('#link').scrollIntoView(true)
    },
    toHomepage () {
      this.$router.push({path: '/'})
    },
    highlight () {
      document.getElementById('OASIS').style.cursor = 'pointer'
      document.getElementById('OASIS').style.fontSize = '40px'
    },
    redoHightLight () {
      document.getElementById('OASIS').style.fontSize = '50px'
    }
  },
  mounted () {
    let paperList = JSON.parse(this.$route.query.papers)
    this.PaperList = paperList
    this.paperNum = this.$route.query.totalNum
    this.searchContent = this.$route.query.content
    if (JSON.stringify(this.searchContent).substring(0, 1) === '{'||JSON.stringify(this.searchContent).substring(1, 2) === '[') {

      this.showSearchContent = false
    } else {
      this.showSearchContent = true
    }
    this.$store.dispatch('flushFun')
  }
}
</script>

<style scoped>
  .affcon{
      display: -webkit-box;
      -webkit-box-orient: vertical;
      -webkit-line-clamp:1;
      overflow: hidden;
      text-overflow: ellipsis;

    }
  .sum{
    display: -webkit-box;
    -webkit-box-orient: vertical;
    -webkit-line-clamp:3;
    overflow: hidden;
    text-overflow: ellipsis;

  }
  .block{
    margin-left: 100px;
    margin-top:-10px
  }
  .block2{
    margin-left: 200px;
    margin-top:-10px
  }
  .headerr{
    margin:-8px;
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
  .bg-purple2 {
    background-color: rgba(255,255,255,0.8);
  }
  .grid-content2 {
    min-height: 60px;
  }
</style>
