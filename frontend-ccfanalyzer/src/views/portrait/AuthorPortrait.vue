<template>
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
          <div><h3>Research Directions Trend:</h3></div>
        </el-row>
        <el-row>
          <div id="trend" style="height:60px"></div>
        </el-row>
        <el-row>
          <el-col span="17">
            <el-card style="height:500px">
              <el-row class="box-card">
                <el-col :span="10">
                  <div style="margin-left: 15%;">
                    <el-row><div style="font-size:40px">{{AuPor.name}}</div></el-row>
                    <br>
                    <el-row><div style="font-size:20px">Information</div></el-row>
                    <el-divider></el-divider>
                    <el-row><div ><i class="el-icon-s-custom"></i>&nbsp;&nbsp;&nbsp;Name:&nbsp;<el-link @click="searchAuthorPor(AuPor.authorId)">{{AuPor.name}}</el-link></div></el-row>
                    <el-row><div class="cont"><i class="el-icon-office-building"></i>&nbsp;&nbsp;&nbsp;Affiliation:&nbsp;
                      <span  style="color: dimgray" class="divider" v-if="AuPor.affiliations==null || AuPor.affiliations.length==0">None</span>
                      <span v-for="(AFF,index) in AuPor.affiliations" :key="index">
                <span role="separator" class="divider" v-if="index != 0">,</span>
                    <el-link @click="searchAffiliationPor(AFF.id)">{{AFF.name}}</el-link></span>
                    </div></el-row>
                    <br>
                    <el-row><div style="font-size:20px">Education</div></el-row>
                    <el-divider></el-divider>
                    <el-row><div class="cont"><i class="el-icon-s-promotion"></i>&nbsp;&nbsp;&nbsp;Directions:&nbsp;
                      <span  style="color: dimgray" class="divider" v-if="AuPor.researchDirections==null || AuPor.researchDirections.length==0">None</span>
                      <span v-for="(researchDirection,index) in AuPor.researchDirections" :key="index">
                <span role="separator" class="divider" v-if="index != 0">,</span>
                    <el-link @click="searchDirectionPor(researchDirection.id)">{{researchDirection.name}}</el-link></span>
                    </div></el-row>
                    <br>
                    <el-row><div style="font-size:20px">Conference</div></el-row>
                    <el-divider></el-divider>
                    <el-row><div class="cont"><i class="el-icon-s-cooperation"></i>&nbsp;&nbsp;&nbsp;Conferences:&nbsp;
                      <span  style="color: dimgray" class="divider" v-if="AuPor.conferences==null || AuPor.conferences.length==0">None</span>
                      <span v-for="(conference,index) in AuPor.conferences" :key="index">
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
                        <div style="font-size:25px">{{AuPor.articleNum}}</div>
                        <div style="font-size:15px">Papers</div>
                      </el-col>
                      <el-col span="10">
                        <div style="font-size:25px">{{AuPor.articleCitationNum}}</div>
                        <div style="font-size:15px">Citations</div>
                      </el-col>
                    </el-row>
                    <div id="main" style="margin-top:40px;height: 250px"></div>
                    <br>
                  </div>
                </el-col>

              </el-row>
            </el-card>
          </el-col>
          <el-col span="7">
            <div class="ranking_1 grid-content" style="margin-left: 10px">

              <el-card class="box-card" style="height:500px">
                <div slot="header" class="clearfix head_card">
                <span style="font-size: 24px;font-weight: bold">
                  <Icon type="md-person" style="color: cornflowerblue;margin-left: 2%" size = "40" />
                  Authors Map
                  <el-tooltip class="item" effect="dark"
                              placement="top">
                    <div slot="content">
                      This chart shows all authors who have collaborated on papers with {{AuPor.name}}.
                    </div>
                    <span style="font-size: 20px; color: #99a9bf">
                      <i class="el-icon-info"></i>
                    </span>
                  </el-tooltip>
                </span>
                </div>
                <div id="map"
                     style="height:400px"></div>

              </el-card>

            </div>
          </el-col>
        </el-row>

        <el-row>
        </el-row>
        <br>
        <h1 style="margin-left: 3%;color:black;">Popular Papers({{paperNum}})</h1>
        <br>

        <div class="col-md-2 text-center" v-for="item in PaperList" :key="item.title">
          <el-col>
            <el-col :span="25">

              <el-card style=" margin-right: 45px;height: 100%">
                <div style="margin-left: 2%;margin-left: 2%">
                  <el-link style="font-size: 27px;color: black" @click="getContent(item.id)"><strong>{{item.name}}</strong></el-link><br>
                  <el-row >
              <span  style="font-size: 17px;color: dimgray">
                <el-col span="2">
                Affiliations:
                </el-col>
                <el-col span="22">
                  <span class="affcon">
                <span  class="divider" v-if="item.affiliations.length==0">None</span>
              <span  v-for="(aff,index) in item.affiliations" :key="index">
                <span role="separator" class="divider" v-if="index != 0">,</span>
                <el-link style="font-size: 17px;color: cornflowerblue;font-style:italic"  :key='aff' @click="searchAffiliationPor(aff.id)">{{aff.name}}</el-link></span>
              </span></el-col>
              </span>
                  </el-row>
                  <el-row class="affcon">
              <span  style="font-size: 17px;color: dimgray">
                <el-col span="2">
                Authors:
            </el-col>
              <el-col span="22">
                <span class="affcon">
                <span  class="divider" v-if="item.authors.length==0">None</span>
              <span v-for="(author,index) in item.authors" :key="index">
                <span role="separator" class="divider" v-if="index != 0">,</span>
              <el-link style="font-size: 17px;color: cornflowerblue;font-style:italic" :key="author" @click="searchAuthorPor(author.id)">{{author.name}}</el-link>
              </span></span></el-col>
              </span>
                  </el-row>
                  <span class="sum" style="font-size: 15px;color: dimgray;margin-top: 5px;margin-bottom: 5px" v-if="item.summary" >{{item.summary}}</span>
                  <el-row>
              <span  style="font-size: 17px;color: dimgray">
                <el-col :span="2">
                Keywords:</el-col>
                <el-col :span="22">
                  <span class="affcon">
                <span  class="divider" v-if="item.keywords.length==0">None</span>
              <span v-for="(keyword,index) in item.keywords" :key="index">
                <span role="separator" class="divider" v-if="index != 0">,</span>
              <el-link style="font-size: 17px;color: cornflowerblue;font-style:italic" :key="keyword" @click="searchByKeyword(keyword)">{{keyword}}</el-link>
              </span></span></el-col>
                </span>
                  </el-row>
                  <el-row>
                    <span style="font-size: 17px;color: dimgray">
                      <el-col :span="2">Publication:</el-col>
                      <el-col :span="22"> <span class="affcon"><el-link style="font-size: 17px;color: cornflowerblue;font-style:italic" @click="searchConferencePor(item.publication)">{{item.publication}}</el-link></span></el-col></span><br>
                  </el-row>
                  <el-row>
                    <span style="font-size: 17px;color: dimgray"  >
                      <el-col :span="2">Citation:</el-col>
                      <el-col :span="22">{{item.citationCnt}}</el-col></span><br>
                  </el-row>
                </div>
              </el-card>
              <br>
            </el-col>

          </el-col>
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
// import {getCommonSearchResult, getAdvancedSearchResult} from '../../api/home/HomePageAPI'
// import {getAuthorPortrait, getAuthorPaper, getAuthorValue, getAuthorMap, getAuthorTrend} from '../../api/portrait/AuthorPortraitAPI'

export default {

  data () {
    return {
      searching: false,
      seriesTrend: [],
      color: ['#B0C4DE', '#F0E68C', '#FFC1C1', '#C1FFC1', '#D8BFD8', '#BBFFFF', '#87CEEB', '#008080', '#D2B48C', '#BC8F8F'],
      Trend: [{
        year: 2019,
        researchDirections: [{
          id: 1,
          name: 'Machine learning',
          percent: 0,
          paperCount: 100
        }, {
          id: 2,
          name: 'software',
          percent: 0,
          paperCount: 100
        }, {
          id: 3,
          name: 'train',
          percent: 0,
          paperCount: 100
        }]
      }, {
        year: 2020,
        researchDirections: [{
          id: 1,
          name: 'Machine learning',
          percent: 33.666666,
          paperCount: 100
        }, {
          id: 2,
          name: 'software',
          percent: 22.1111111,
          paperCount: 100
        }, {
          id: 3,
          name: 'train',
          percent: 7.11111,
          paperCount: 100
        }]
      }],
      trendDirection: [{
        id: 1,
        name: 'Machine learning',
        percent: 66.666666,
        paperCount: 100
      }, {
        id: 2,
        name: 'software',
        percent: 22.1111111,
        paperCount: 100
      }, {
        id: 3,
        name: 'train',
        percent: 7.11111,
        paperCount: 100
      }],
      loading_chart: false,
      aveArticleNum: 0,
      maxArticleNum: 0,
      aveCitationNum: 0,
      maxCitationNum: 0,
      aveHIndex: 0,
      maxHIndex: 0,
      aveDiversityIndex: 0,
      maxDiversityIndex: 0,
      aveActiveness: 0,
      maxActiveness: 0,

      AuPor: {
        // authorId: 1,
        // name: 'John',
        // researchDirections: [{
        //   id: 1,
        //   name: 'a',
        //   citationCnt: 1
        // }],
        // affiliations: [
        //   {
        //     id: 1,
        //     name: 'Nanjing University'
        //   },
        //   {
        //     id: 1,
        //     name: 'Nanjing University'
        //   },
        //   {
        //     id: 1,
        //     name: 'Nanjing University'
        //   }
        // ],
        // conferences: ['IEEE', 'IEEE'],
        // articleNum: 671,
        // articleCitationNum: 3,
        // hIndex: 1,
        // researchDiversityIndex: 1,
        // activeness: 1
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
      }],
      categories: [
        {
          name: 'per',
          itemStyle: {
            normal: {
              color: '#22b9be'
            }
          }
        }, {
          name: 'loc',
          itemStyle: {
            normal: {
              color: '#55a5c6'
            }
          }
        }, {
          name: 'org',
          itemStyle: {
            normal: {
              color: '#ec9f6c'
            }
          }
        }, {
          name: 'time',
          itemStyle: {
            normal: {
              color: '#6a81aa'
            }
          }
        }, {
          name: 'body',
          itemStyle: {
            normal: {
              color: '#cea8b9'
            }
          }
        }, {
          name: 'sigos',
          itemStyle: {
            normal: {
              color: '#c79288'
            }
          }
        }, {
          name: 'check',
          itemStyle: {
            normal: {
              color: '#bee6b8'
            }
          }
        }, {
          name: 'disease',
          itemStyle: {
            normal: {
              color: '#649f61'
            }
          }
        }, {
          name: 'treatmeot',
          itemStyle: {
            normal: {
              color: '#90b32f'
            }
          }
        }]
    }
  },
  methods: {
    loadChartData () {
      var nodes = []
      var links = []
      this.loading_chart = true
      getAuthorMap(this.AuPor.authorId).then(res => {
        if (res.status.code === '0000') {
          nodes = res.data.authors
          links = res.data.connections
          for (var i = 0; i < nodes.length; i++) {
            nodes[i].symbolSize = nodes[i].value - 40 > 0 ? nodes[i].value - 40 : 20
            nodes[i].category = i % (this.categories.length)
            nodes[i].label = {
              show: nodes[i].symbolSize > 0
            }
          }
          this.drawChart(nodes, links)
          this.loading_chart = false
        } else {
          this.$message.error({
            message: res.status.msg,
            center: true
          })
          this.loading_chart = false
        }
      }).catch(error => {
        console.log(error)
        this.loading_chart = false
      })
    },
    drawtrend () {
      let myChart = this.$echarts.init(document.getElementById('trend'))
      let con = this.Trend
      let option = {
        tooltip: {
          trigger: 'item',
          position: function (position) {
            let dom = document.getElementById('chartDom')
            if (dom) {
              // 获取容器的宽度
              let chartsWidth = dom.offsetWidth
              // 判断悬停点落在容器的哪测
              if (position[0] < (chartsWidth / 2)) {
                position[0] = position[0]
              } else {
                position[0] = position[0] - 130
              }
            }
            return [position[0], position[1]]
          },
          formatter: function (params) {
            var color = params.color// 图例颜色
            var htmlStr = '<div>'
            htmlStr += '<span style="margin-right:5px;display:inline-block;width:10px;height:10px;border-radius:5px;background-color:' + color + ';"></span>'
            htmlStr += params.seriesName
            for (let p = 0; p < con.length; ++p) {
              if (params.seriesIndex === p) {
                for (let i = 0; i < con[p].researchDirections.length; ++i) {
                  htmlStr += '<br>'
                  htmlStr += con[p].researchDirections[i].name + ' : ' + (con[p].researchDirections[i].percent * 100).toFixed(2) + '%' + '  (' + con[p].researchDirections[i].paperCnt + 'papers' + ')'
                }
              }
            }
            htmlStr += '</div>'

            return htmlStr
          }
        },
        grid: {
          left: '-3%',
          top: '0%',
          right: '2%',
          bottom: '0%',
          containLabel: true
        },
        xAxis: [{
          show: false

        }],
        yAxis: [{
          axisTick: 'none',
          axisLine: 'none',
          axisLabel: {
            textStyle: {
              color: '#ffffff',
              fontSize: '16'
            }
          },
          data: ['100%']
        }, {

          axisLine: {
            lineStyle: {
              color: 'rgba(0,0,0,0)'
            }
          },
          data: []
        }],
        series: this.seriesTrend
      }
      myChart.setOption(option)
    },
    drawChart (data, links) {
      let myChart = this.$echarts.init(document.getElementById('map'))
      let option = {
        title: {
          text: ''
        },
        tooltip: {},
        animationDurationUpdate: 1500,
        animationEasingUpdate: 'quinticInOut',
        label: {
          normal: {
            show: true,
            textStyle: {
              fontSize: 12
            }
          }
        },
        series: [
          {
            type: 'graph',
            layout: 'force',
            focusNodeAdjacency: true,
            roam: true,
            draggable: true,
            categories: this.categories,
            label: {
              normal: {
                show: true,
                textStyle: {
                  fontSize: 12
                }
              },
              position: 'right'
            },
            force: {
              repulsion: 1000,
              layoutAnimation: false
            },
            itemStyle: {
              borderColor: '#fff', // 节点边框背景色白色
              borderWidth: 1,
              shadowBlur: 10,
              shadowColor: 'rgba(0, 0, 0, 0.3)'
            },
            data: data,
            links: links,
            lineStyle: {
              normal: {
                opacity: 0.9,
                width: 1,
                curveness: 0.3,
                color: 'source'
              }
            },
            emphasis: { // 高亮的图形样式
              lineStyle: {
                width: 5
              }
            }
          }
        ]
      }
      // 使用刚指定的配置项和数据显示图表。
      myChart.setOption(option)
    },
    loadData () {
      this.loadChartData()
    },
    maxSlice (v) {
      return v.length > this.maxlen ? v.slice(0, this.maxlen) + '...' : v
    },
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
      getAuthorPaper(this.AuPor.authorId, this.page).then((res) => {
        this.PaperList = res.data
      })
      document.querySelector('#link').scrollIntoView(true)
    },
    drawPie () {
    },
    getAuthorContent () {
      getAuthorPortrait(this.AuPor.authorId).then((res) => {
        this.AuPor = res.data
        if (this.AuPor.articleNum > 20) {
          this.paperNum = 20
        } else {
          this.paperNum = this.AuPor.articleNum
        }
      })
    },
    getPapers () {
      getAuthorPaper(this.AuPor.authorId, 0).then((res) => {
        this.PaperList = res.data
        this.getValue()
      })
    },
    getValue () {
      getAuthorValue().then((res) => {
        this.aveArticleNum = res.data.aveArticleNum
        this.maxArticleNum = res.data.maxArticleNum
        this.aveCitationNum = res.data.aveCitationNum
        this.maxCitationNum = res.data.maxCitationNum
        this.aveHIndex = res.data.aveHIndex
        this.maxHIndex = res.data.maxHIndex
        this.aveDiversityIndex = res.data.aveDiversityIndex
        this.maxDiversityIndex = res.data.maxDiversityIndex
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
        tooltip: {},
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
        polar: [ // 雷达图必须设置polar
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
                text: 'Diversity Index',
                max: this.maxDiversityIndex,
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
                value: [this.AuPor.articleNum, this.AuPor.articleCitationNum, this.AuPor.hIndex.toFixed(2), this.AuPor.researchDiversityIndex.toFixed(2), this.AuPor.activeness.toFixed(2)],
                name: 'Statistics'
              }, {
                value: [this.aveArticleNum.toFixed(2), this.aveCitationNum.toFixed(2), this.aveHIndex.toFixed(2), this.aveDiversityIndex.toFixed(2), this.aveActiveness.toFixed(2)],
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
            }
          }
        ]
      }
      let myChart = this.$echarts.init(document.getElementById('main'))
      myChart.setOption(option)
      this.$nextTick(function () {
        this.drawPie('main')
      })
    },
    loadTrend () {
      getAuthorTrend(this.AuPor.authorId).then((res) => {
        this.Trend = res.data
        var myTrend = []
        for (let i = 0; i < this.Trend.length; ++i) {
          var data1 = []
          for (let p = 0; p < this.Trend[i].researchDirections.length; ++p) {
            data1.push(this.Trend[i].researchDirections[p].percent * 100)
          }
          var t = (this.Trend[i].ratio * 100).toFixed(3)
          t = t.substr(0, t.length - 1)
          var k = {
            clickable: false,
            name: this.Trend[i].year,
            type: 'bar',
            stack: '圆',
            yAxisIndex: 0,
            color: '#00000',
            data: [t],
            barWidth: 13,
            z: 1,
            itemStyle: {
              emphasis: {
                barBorderRadius: 30
              },
              normal: {
                barBorderRadius: [10, 10, 10, 10],
                color: this.color[i]
              }
            }
          }
          myTrend.push(k)
        }
        this.seriesTrend = myTrend
        this.drawtrend()
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
    let id = this.$route.query.authorId
    this.AuPor.authorId = id
    this.loadTrend()
    this.getAuthorContent()
    this.getPapers()
    this.loadData()
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
  .cont{
    display: -webkit-box;
    -webkit-box-orient: vertical;
    -webkit-line-clamp:2;
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

</style>
