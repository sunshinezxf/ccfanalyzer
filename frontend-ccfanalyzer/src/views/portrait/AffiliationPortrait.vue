<template xmlns:el-col="http://www.w3.org/1999/html">
  <div v-loading.fullscreen.lock="loading_chart"
       element-loading-text="LOADING..."
       element-loading-spinner="el-icon-loading"
       element-loading-background="rgba(211,211,211,0.96)"
       style="overflow: hidden" >
    <el-container >
      <div id="link"></div>
      <el-header class="headerr" :style ="this.$store.state.background" height="150px">
        <el-row>
          <el-col :span="5">
            <el-row>
              <div class="OASIS" id="OASIS" style="font-weight:bold;color:white;font-size: 70px;text-align:center;margin-top: 4%"
                   @mouseenter="highlight" @mouseout="redoHightLight" @click="toHomepage">
                OASIS
              </div>
            </el-row>
            <!--<el-row><div class="OASIS" style="color:white;font-size: 17px;text-align:center; ">-->
            <!--OASIS/Search-->
            <!--</div>-->
            <!--</el-row>-->
          </el-col>
          <el-col :span="19">
            <!--普通搜索-->
            <div style="text-align: center;">
              <el-select v-model="commonSearchTypeValue" clearable placeholder="All" style="opacity:80%; width: 10%">
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
                clearable>
              </el-input>

              <el-button @click="commonSearch" type="primary" icon="el-icon-search" :loading="searching">SEARCH</el-button>

            </div>
          </el-col>
        </el-row>
      </el-header>
      <el-main >
        <el-row>
          <el-col span="17">
            <el-card style="padding-bottom: 4%">
              <el-row class="box-card">
                <el-col :span="10">
                  <div style="margin-left: 10%;">
                    <el-row><div style="font-size:40px">{{AffPor.name}}</div></el-row>
                    <br>
                    <el-row><div style="font-size:20px">Information</div></el-row>
                    <el-divider></el-divider>
                    <el-row><div ><i class="el-icon-s-custom"></i>&nbsp;&nbsp;&nbsp;Name:&nbsp;<el-link @click="searchAffiliationPor(AffPor.affiliationId)">{{AffPor.name}}</el-link></div></el-row>
                    <br>
                    <el-row><div style="font-size:20px">Education</div></el-row>
                    <el-divider></el-divider>
                    <el-row>
                      <div class="cont"><i class="el-icon-s-promotion"></i>&nbsp;&nbsp;&nbsp;Directions:&nbsp;
                        <span  class="divider" v-if="AffPor.researchDirections==null || AffPor.researchDirections.length==0">None</span>
                        <span v-for="(researchDirection,index) in AffPor.researchDirections" :key="index">
                <span role="separator" class="divider" v-if="index != 0">,</span>
                        <el-link @click="searchDirectionPor(researchDirection.id)">{{researchDirection.name}}</el-link></span>
                      </div></el-row>
                    <br>
                    <el-row><div style="font-size:20px">Conference</div></el-row>
                    <el-divider></el-divider>
                    <el-row><div class="cont">
                      <i class="el-icon-s-cooperation"></i>&nbsp;&nbsp;&nbsp;Conferences:&nbsp;
                      <span  class="divider" v-if="AffPor.conferences==null || AffPor.conferences.length==0">None</span>
                      <span v-for="(conference,index) in AffPor.conferences" :key="index">
                      <span role="separator" class="divider" v-if="index != 0">,</span>
                        <el-link @click="searchConferencePor(conference)">{{ conference}}</el-link></span>
                    </div>
                    </el-row>
                  </div>
                </el-col>
                <el-col :span="14">
                  <div style="margin-left: 10%;">
                    <el-row>
                      <el-col span="6">&nbsp;</el-col>
                      <el-col span="8">
                        <div style="font-size:25px">{{AffPor.articleNum}}</div>
                        <div style="font-size:15px">Papers</div>
                      </el-col>
                      <el-col span="10">
                        <div style="font-size:25px">{{AffPor.articleCitationNum}}</div>
                        <div style="font-size:15px">Citations</div>
                      </el-col>
                    </el-row>
                    <div id="main" style="margin-top:40px;height: 250px"></div>
                    <br>
                  </div>
                </el-col>

              </el-row>
            </el-card>
            <br>
            <h1 style="margin-left: 3%;color:black;">Popular Papers({{paperNum}})</h1>
            <br>

            <div class="col-md-2 text-center" v-for="item in PaperList" :key="item.title">
              <el-card style=" height: 100%">
                <div style="margin-left: 2%;margin-left: 2%">
                  <el-link style="font-size: 27px;color: black" @click="getContent(item.id)"><strong>{{item.name}}</strong></el-link><br>
                  <el-row>
              <span class="affcon" style="font-size: 17px;color: dimgray">
                Affiliations:&nbsp;&nbsp;&nbsp;
                <span  class="divider" v-if="item.affiliations.length==0">None</span>
              <span  v-for="(aff,index) in item.affiliations" :key="index">
                <span role="separator" class="divider" v-if="index != 0">,</span>
                <el-link style="font-size: 17px;color: cornflowerblue;font-style:italic"  :key='aff' @click="searchAffiliationPor(aff.id)">{{aff.name}}</el-link>
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
                  Authors Rank
                </span>
                </div>
                <div>
                  <el-row style="font-size: 18px">
                    <el-col :span="4" style="text-align: left">Rank</el-col>
                    <el-col :span="6" >Name</el-col>
                    <el-col :span="12" style="text-align: right">Activeness</el-col>
                  </el-row>
                </div>
                <br><br>
                <div v-for="(item,index) in AffPor.authors" :key="item.id">
                  <!--{{'列表内容 ' + o }}-->
                  <el-row style="font-size: 20px">
                    <el-col :span="4">{{index+1}}</el-col>
                    <el-col :span="16" style="text-align: left">
                      <el-tooltip effect="dark" placement="left">
                        <div slot="content">
                          {{item.name}}
                        </div>
                        <router-link target="_blank" :to="{name:'AuthorPortrait',query:{authorId:item.id}}">
                          <div style="width: 240px; font-size: 17px;color: cornflowerblue; overflow: hidden;
                       white-space: nowrap;text-overflow: ellipsis;">
                            {{item.name}}
                          </div>
                        </router-link>
                      </el-tooltip>
                    </el-col>
                    <el-col :span="3" style="text-align: right; ">
                      <span style="float: right">{{item.activeness.toFixed(2)}}</span>
                    </el-col>
                  </el-row>
                  <div>
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
// import {getCommonSearchResult, getAdvancedSearchResult} from '../../api/home/HomePageAPI'
// import {getAffiliationPortrait, getAffiliationPaper, getAffiliationValue} from '../../api/portrait/AffiliationPortraitAPI'

export default {

  data () {
    return {
      loading_chart: false,
      searching: false,
      aveAuthorNum: 0,
      maxAuthorNum: 0,
      aveArticleNum: 0,
      maxArticleNum: 0,
      aveHIndex: 0,
      maxHIndex: 0,
      aveCitationNum: 0,
      maxCitationNum: 0,
      aveActiveness: 0,
      maxActiveness: 0,
      AffPor: {
        // affiliationId: 1,
        // name: 'Nanjing University',
        // researchDirections: [{
        //   id: 1,
        //   name: 'aa',
        //   citationCnt: 1
        // }],
        // Authors: [
        //   {
        //     id: 1,
        //     name: 'John',
        //     activeness: 1.0
        //   }, {
        //     id: 1,
        //     name: 'John',
        //     activeness: 1.0
        //   }
        // ],
        // conferences: ['IEEE', 'IEEE'],
        // articleNum: 671,
        // articleCitationNum: 10,
        // hIndex: 1.0,
        // researchDiversityIndex: 1.0,
        // activeness: 1.0,
        // authorNum: 1
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
          activeness: 1.0
        }],
        affiliations: [{
          id: 1,
          name: 'NJU'
        }],
        publication: 'IEEE',
        summary: 'Learning Models and the Learning Cycle Learning Differences and Learning Styles The Role of the Learning Environment Background to Learning Styles Assessment of Learning Styles Learning Styles Learning and Teaching The Inclusive School Characteristics and Challenges Learning Styles in the Inclusive Context Promoting Effective Learning Learning Styles Strategies and Insights',
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
            if (res.status.code === '0000') {
              paperList = res.data.paperBriefInfoVOList
              total = res.data.totalNum
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
              if (res.status.code === '0000') {
                paperList = res.data.paperBriefInfoVOList
                total = res.data.totalNum
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
              if (res.status.code === '0000') {
                paperList = res.data.paperBriefInfoVOList
                total = res.data.totalNum
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
              if (res.status.code === '0000') {
                paperList = res.data.paperBriefInfoVOList
                total = res.data.totalNum
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
        paperList = res.data.paperBriefInfoVOList
        total = res.data.totalNum
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
      getAffiliationPaper(this.AffPor.affiliationId, this.page).then((res) => {
        this.PaperList = res.data
      })
      document.querySelector('#link').scrollIntoView(true)
    },
    drawPie () {
    },
    getAffiliationContent () {
      this.loading_chart = true
      getAffiliationPortrait(this.AffPor.affiliationrId).then((res) => {
        this.AffPor = res.data
        if (this.AffPor.articleNum > 20) {
          this.paperNum = 20
        } else {
          this.paperNum = this.AffPor.articleNum
        }
        this.getValue()
      })
    },
    getPapers () {
      getAffiliationPaper(this.AffPor.affiliationrId, 0).then((res) => {
        this.PaperList = res.data
        this.loading_chart = false
      })
    },
    getValue () {
      getAffiliationValue().then((res) => {
        this.aveArticleNum = res.data.aveArticleNum
        this.maxArticleNum = res.data.maxArticleNum
        this.aveCitationNum = res.data.aveCitationNum
        this.maxCitationNum = res.data.maxCitationNum
        this.aveHIndex = res.data.aveHIndex
        this.maxHIndex = res.data.maxHIndex
        this.aveAuthorNum = res.data.aveAuthorNum
        this.maxAuthorNum = res.data.maxAuthorNum
        this.aveActiveness = res.data.aveActiveness
        this.maxActiveness = res.data.maxActiveness
        this.makeChart()
      })
    },
    makeChart () {
      var option = {
        title: {
          text: ''
        },
        backgroundColor: '#ffffff',
        color: ['#37A2DA', '#FF9F7F'],
        tooltip: {
        },
        xAxis: {
          show: false
        },
        yAxis: {
          show: false
        },
        legend: {
          orient: 'vertical',
          x: 'right',
          y: 'bottom',
          data: ['Statistics', 'avg']
        },
        toolbox: {
          show: true,
          feature: {
            mark: {
              show: true
            },
            restore: {
              show: true
            },
            saveAsImage: {
              show: true
            }
          }
        },
        radar: [ // 雷达图必须设置polar
          {
            indicator: [
              {
                text: 'Article Num',
                max: this.maxArticleNum,
                min: 0
              },
              {
                text: 'Citation Num',
                max: this.maxCitationNum,
                min: 0
              },
              {
                text: 'H-Index',
                max: this.maxHIndex,
                min: 0
              },
              {
                text: 'Author Num',
                max: this.maxAuthorNum,
                min: 0
              },
              {
                text: 'Activeness',
                max: this.maxActiveness,
                min: 0
              }
            ]
          }
        ],
        calculable: true,
        series: [
          {
            name: '',
            type: 'radar',
            data: [
              {
                value: [this.AffPor.articleNum, this.AffPor.articleCitationNum, this.AffPor.hIndex.toFixed(2), this.AffPor.authorNum, this.AffPor.activeness.toFixed(2)],
                name: 'Statistics'
              }, {
                value: [this.aveArticleNum.toFixed(2), this.aveCitationNum.toFixed(2), this.aveHIndex.toFixed(2), this.aveAuthorNum.toFixed(2), this.aveActiveness.toFixed(2)],
                name: 'avg'
              }
            ]
          }, {
            type: 'line',
            name: 'Statistics',
            data: [],
            itemStyle: {
              normal: {
                color: '#37A2DA'
              }
            }
          }, {
            type: 'line',
            data: [],
            name: 'avg',
            itemStyle: {
              normal: {
                color: '#FF9F7F'
              }
            }}
        ]
      }
      let myChart = this.$echarts.init(document.getElementById('main'))
      myChart.setOption(option)
      this.$nextTick(function () {
        this.drawPie('main')
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
    let id = this.$route.query.affiliationId
    this.AffPor.affiliationrId = id
    this.getAffiliationContent()
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

</style>

