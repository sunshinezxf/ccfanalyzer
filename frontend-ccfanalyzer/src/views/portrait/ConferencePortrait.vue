<template>
  <div v-loading.fullscreen.lock="loading_chart"
       element-loading-text="LOADING..."
       element-loading-spinner="el-icon-loading"
       element-loading-background="rgba(211,211,211,0.96)"
       style="overflow: hidden" >
    <el-container >
      <div id="link"></div>
      <el-header class="headerr" :style ="this.$store.state.background" height="230px">
        <div><lo></lo></div>

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
            <div style="text-align: center;" >

              <el-select v-model="commonSearchTypeValue" clearable placeholder="All"  style="opacity:80%; width: 10%;text-align: left;position:relative; z-index:9999;" :popper-append-to-body="false" >
                <el-option
                  v-for="item in options"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>

              </el-select>
              <el-input
                v-if="commonSearchTypeValue === ''||commonSearchTypeValue === 'keyword'"
                class="common_input"
                style="opacity:80%;width:50%;margin-top: 4%"
                placeholder="Enter something..."
                v-model="commonInput"
                :disabled="searching"
                @keyup.enter.native="commonSearch"
                clearable>
              </el-input>
              <el-autocomplete v-if="commonSearchTypeValue === 'author'"
                               :minlength="2" style="opacity:80%;width:50%;margin-top: 4%;text-align: left;position:relative; z-index:9999;" :popper-append-to-body="false" v-model="searchAuthor.name" :fetch-suggestions="querySearchAsync" placeholder="Enter something..."
                               @select="handleSelect"></el-autocomplete>
              <el-autocomplete v-if="commonSearchTypeValue === 'affiliation'"
                               :minlength="2" style="opacity:80%;width:50%;margin-top: 4%;text-align: left;position:relative; z-index:9999;" :popper-append-to-body="false" v-model="searchAffiliation.name" :fetch-suggestions="querySearchAsync2" placeholder="Enter something..."
                               @select="handleSelect2"></el-autocomplete>

              <el-button @click="commonSearch" type="primary" icon="el-icon-search" :loading="searching">SEARCH</el-button>

            </div>
          </el-col>
        </el-row>

      </el-header>
      <el-main >
        <el-row>
          <el-col span="17">
            <el-card style="height:320px">
              <el-row class="box-card">
                <div style="margin-left: 2%;">
                  <el-row><div style="font-size:30px">{{ConferencePor.name}}</div></el-row><br><br><br>
                  <el-row>
                    <el-col span="6">
                      <div style="font-size:25px">{{ConferencePor.articleNum}}</div>
                      <div style="font-size:15px">Papers</div>
                    </el-col>
                    <el-col span="6">
                      <div style="font-size:25px">{{ConferencePor.articleCitationNum}}</div>
                      <div style="font-size:15px">Citations</div>
                    </el-col>
                    <el-col span="6">
                      <div style="font-size:25px">{{ConferencePor.authorNum}}</div>
                      <div style="font-size:15px">Authors</div>
                    </el-col>
                    <el-col span="6">
                      <div style="font-size:25px">{{ConferencePor.affiliationNum}}</div>
                      <div style="font-size:15px">Affiliations</div>
                    </el-col>
                  </el-row>
                </div>
              </el-row>
            </el-card>
            <br>
            <h1 style="margin-left: 3%;color:black;">Popular Papers({{paperNum}})</h1>
            <br>

            <div class="col-md-2 text-center" v-for="item in PaperList" :key="item.title">
              <el-card style=" height: 100%">
                <div style="margin-left: 2%;margin-left: 2%">
                  <el-link style="font-size: 27px;color: black" @click="getContent(item.paperId)"><strong>{{item.title}}</strong></el-link><br>
                  <el-row>
              <span class="affcon" style="font-size: 17px;color: dimgray">
                Affiliations:&nbsp;&nbsp;&nbsp;
                <span  class="divider" v-if="item.authors.length==0">None</span>
              <span  v-for="(aff,index) in item.authors" :key="index">
                <span role="separator" class="divider" v-if="index != 0">,</span>
                <el-link style="font-size: 17px;color: cornflowerblue;font-style:italic"  :key='aff' @click="searchAffiliationPor(aff.affiliations[0].id)">{{aff.affiliations[0].name}}</el-link>
              </span>
              </span>
                  </el-row>
                  <el-row>
              <span class="affcon" style="font-size: 17px;color: dimgray">
                Authors:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <span  class="divider" v-if="item.authors.length==0">None</span>
              <span v-for="(author,index) in item.authors" :key="index">
                <span role="separator" class="divider" v-if="index != 0">,</span>
              <el-link style="font-size: 17px;color: cornflowerblue;font-style:italic" :key="author" @click="searchAuthorPor(author.id)">{{author.name}}</el-link>
              </span>
              </span>
                  </el-row>
                  <span class="sum" style="font-size: 15px;color: dimgray;margin-top: 5px;margin-bottom: 5px" v-if="item.abstract" >{{item.abstract}}</span>
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
                  <el-row>
                    <span style="font-size: 17px;color: dimgray"  >Citation:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{{item.citationCnt}}</span><br>
                  </el-row>
                </div>
              </el-card>
              <br>
            </div>
            <br>
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
          </el-col>
          <el-col span="7">
            <div class="ranking_1 grid-content" style="margin-left: 10px">

              <el-card class="box-card" style="height:100%">
                <div slot="header" class="clearfix head_card" style="text-align: center">
                <span style="font-size: 20px;font-weight: bold">
                  <Icon type="md-person" style="color: cornflowerblue;margin-left: 2%" size = "40" />
                  Directions Rank
                </span>
                </div>
                <div>
                  <el-row style="font-size: 18px">
                    <el-col :span="2" style="text-align: left">&nbsp;</el-col>
                    <el-col :span="4" style="text-align: left">Rank</el-col>
                    <el-col :span="8" >Directions</el-col>
                    <el-col :span="9" style="text-align: right">Times Cited</el-col>
                  </el-row>
                </div>
                <br><br>
                <div v-for="(item,index) in ConferencePor.researchDirections" :key="item.id">
                  <!--{{'列表内容 ' + o }}-->
                  <el-row style="font-size: 20px">
                    <el-col :span="2" style="text-align: left">&nbsp;</el-col>
                    <el-col :span="4">{{index+1}}</el-col>
                    <el-col :span="8" style="text-align: left">
                      <el-tooltip effect="dark" placement="left">
                        <div slot="content">
                          {{item.name}}
                        </div>
                        <router-link target="_blank" :to="{name:'DirectionPortrait',query:{directionId:item.id}}">
                          <div style="width: 200px; font-size: 17px;color: cornflowerblue; overflow: hidden;
                       white-space: nowrap;text-overflow: ellipsis;">
                            {{item.name}}
                          </div>
                        </router-link>
                      </el-tooltip>
                    </el-col>
                    <el-col :span="9" style="text-align:right">{{item.citationCnt}}</el-col>
                  </el-row>
                  <div >
                    <el-divider></el-divider>
                  </div>
                </div>
              </el-card>

            </div>
          </el-col>
        </el-row>
        <br>

      </el-main>

    </el-container>
  </div>
</template>

<script>
import {getCommonSearchResult, getAdvancedSearchResult} from '../../API/Home/HomePageAPIs'
import {getConferencePaper, getConferencePortrait} from '../../API/Portrait/ConferencePortraitAPIs'
import lo from '../../components/Center'

export default {
  components: {
    lo
  },

  data () {
    return {
      user: {
        login: true,
        logout: false,
        username: 'yry',
        password: ''
      },
      dialogVisible: false,
      loading_chart: false,
      searching: false,
      ConferencePor: {
        // name: 'IEEE',
        // researchDirections: [{
        //   id: 1,
        //   name: 'a',
        //   citationCnt: 1
        // }],
        // authorNum: 1,
        // affiliationNum: 1,
        // articleNum: 671,
        // articleCitationNum: 10
      },
      commonSearchTypeValue: '',
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
        keywords: []
      },
      maxlen: 250,
      background: {
        backgroundImage: 'url(' + require('@/assets/background.jpg') + ')',
        backgroundRepeat: 'no-repeat',
        backgroundSize: 'cover'
      },
      background2: {
        backgroundImage: 'url(' + require('@/assets/Au.jpg') + ')',
        backgroundRepeat: 'no-repeat',
        backgroundSize: 'cover'
      },
      PaperList: [{
        id: 2,
        name: 'a',
        paperId: 0,
        title: 'Learning Styles and Inclusion.',
        authors: [{
          id: 1,
          name: 'zjh',
          affiliations: [{
            id: 1,
            name: 'NJU'
          }]
        }],
        publication: 'IEEE',
        abstract: 'Learning Models and the Learning Cycle Learning Differences and Learning Styles The Role of the Learning Environment Background to Learning Styles Assessment of Learning Styles Learning Styles Learning and Teaching The Inclusive School Characteristics and Challenges Learning Styles in the Inclusive Context Promoting Effective Learning Learning Styles Strategies and Insights',
        keywords: ['Educational technology'],
        citationCnt: 0
      }]
    }
  },
  methods: {
    commonSearch () {
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
    searchConferencePor (name) {
      let newpage = this.$router.resolve({
        name: 'ConferencePortrait',
        query: {
          name: name
        }
      })
      window.open(newpage.href, '_blank')
    },
    searchDirectionPor (directionId) {
      let newpage = this.$router.resolve({
        name: 'DirectionPortrait',
        query: {
          directionId: directionId
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
      this.advSearchForm.keywords = [name]
      let paperList = []
      let total = 0
      getAdvancedSearchResult(this.advSearchForm).then((res) => {
        paperList = res.content.paperBriefInfoVOList
        total = res.content.totalNum
        let newpage = this.$router.resolve({
          name: 'SearchPaper',
          query: {
            papers: JSON.stringify(paperList),
            totalNum: total,
            content: this.advSearchForm,
            kind: 0
          }
        })
        window.open(newpage.href, '_blank')
      }).catch(error => console.log(error))
    },
    handleCurrentChange (val) {
      this.page = val - 1
      getConferencePaper(this.ConferencePor.id, this.page).then((res) => {
        console.log(res)
        this.PaperList = res.content
      })
      document.querySelector('#link').scrollIntoView(true)
    },
    drawPie () {
    },
    getConferenceContent () {
      this.loading_chart = false
      getConferencePortrait(this.ConferencePor.id).then((res) => {
        console.log(res)
        this.ConferencePor = res.content
        console.log(this.ConferencePor.articleNum)
        if (this.ConferencePor.articleNum > 20) {
          this.paperNum = 20
        } else {
          this.paperNum = this.ConferencePor.articleNum
        }
      })
    },
    getPapers () {
      getConferencePaper(this.ConferencePor.id, 0).then((res) => {
        this.PaperList = res.content
        this.loading_chart = false
      })
    },
    toHomepage () {
      this.$router.push({path: '/'})
    },
    highlight () {
      document.getElementById('OASIS').style.cursor = 'pointer'
      document.getElementById('OASIS').style.fontSize = '80px'
    },
    redoHightLight () {
      document.getElementById('OASIS').style.fontSize = '70px'
    }
  },
  mounted () {
    let name = this.$route.query.name
    this.ConferencePor.id = name
    this.getConferenceContent()
    this.getPapers()
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
  .iconWrap{
    font-size: 150px;
    margin: 10%;
  }
  .el-divider--horizontal{
    margin: 4px 0;
    background: 0 0;
    border-top: 1px solid #e8eaec;
  }
  .cont{
    display: -webkit-box;
    -webkit-box-orient: vertical;
    -webkit-line-clamp:2;
    overflow: hidden;
    text-overflow: ellipsis;
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
