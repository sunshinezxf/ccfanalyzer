<template>
  <div style="overflow: hidden">
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
                <span  class="divider" v-if="item.affiliations==='Null'">None</span>
              <span  v-for="(aff,index) in item.affiliations" :key="index">
                <span role="separator" class="divider" v-if="index != 0">,</span>
                <el-link style="font-size: 17px;color: cornflowerblue;font-style:italic"  :key='aff' @click="searchAffiliationPor(aff.affiliationId)">{{aff.name}}</el-link>
              </span>
              </span>
              </el-row>
              <el-row>
              <span class="affcon" style="font-size: 17px;color: dimgray">
                Authors:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <span  class="divider" v-if="item.authors==='Null'">None</span>
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
                <span  class="divider" v-if="item.keywords==='Null'">None</span>
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
    getCommonSearchResult, getAdvancedSearchResult,getMatchAuthor,getMatchAffiliation,getMatchConference
    //   getAffiliationActivityRanking, getAuthorActivityRanking, getResearchDirectionPopularityRanking, getTopPapers, getTopAffiliations, getTopAuthors,  adminLogin,
  } from '../../API/Home/HomePageAPIs'
  import lo from '../../components/Center'

  export default {
    components: {
      lo
    },

  data () {
    return {
      searchAuthor:{},
      searchAffiliation:{},
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
    commonSearch() {
      console.log("!!!!!!!!!!!!")
      if (this.searching) {
        return
      }
      if(this.commonSearchTypeValue === ''){
        if (this.commonInput !== '') {
          this.searching = true
          let paperList = []
          let total = 0
          getCommonSearchResult(this.commonInput, 0).then(res => {
            if (res.success) {
              if(typeof(res.content) == "undefined"){
                console.log("dsgf")
                paperList=[]
              }else{
                paperList = res.content.paperBriefInfoVOList
              }
              total = res.content.totalNum
              console.log(total)
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
                message: "Invaild Input",
                center: true
              })
            }
          }).catch(error => console.log(error))
        }else{
          this.$message({
            message: 'Please Enter Something!',
            center: true
          })
        }
      }else if(this.commonSearchTypeValue === 'author'){
        console.log("!!!!!!!!!!!!")
        if (this.searchAuthor.name!== '') {
          this.advSearchForm.authors = [this.searchAuthor.name]
          let paperList = []
          let total = 0
          getAdvancedSearchResult(this.advSearchForm).then(res => {
            if (res.success) {
              console.log(this.advSearchForm.authors)
              console.log(res)
              paperList = res.content.paperBriefInfoVOList
              total = res.content.totalNum
              this.searching = false
              let newpage = this.$router.resolve({
                name: 'SearchPaper',
                query: {
                  papers: JSON.stringify(paperList),
                  totalNum: total,
                  content: this.searchAuthor.name+'(Author)',
                  kind: 0
                }
              })
              window.open(newpage.href, '_blank')

            } else {
              this.searching = false
              this.$message.error({
                message: "Invaild Input" ,
                center: true
              })
            }
          }).catch(error => console.log(error))
        }else{
          this.$message({
            message: 'Please Enter Something!',
            center: true
          })
        }
      }else if(this.commonSearchTypeValue === 'affiliation'){
        if (this.searchAffiliation.name!== '') {
          this.advSearchForm.affiliations = [this.searchAffiliation.name.replace(/,/ig,'，').replace(/&/ig,'%26').replace(/\+/g, '%2B').
          replace(/\"/g,'%22').
          replace(/\'/g, '%27').
          replace(/\//g,'%2F')]
          let paperList = []
          let total = 0
          getAdvancedSearchResult(this.advSearchForm).then(res => {
            if (res.success) {
              paperList = res.content.paperBriefInfoVOList
              total = res.content.totalNum
              this.searching = false
              let newpage = this.$router.resolve({
                name: 'SearchPaper',
                query: {
                  papers: JSON.stringify(paperList),
                  totalNum: total,
                  content: this.searchAffiliation.name+'(Affiliation)',
                  kind: 0
                }
              })
              window.open(newpage.href, '_blank')
            } else {
              this.searching = false
              this.$message.error({
                message: "Invaild Input" ,
                center: true
              })
            }
          }).catch(error => console.log(error))
        }else{
          this.$message({
            message: 'Please Enter Something!',
            center: true
          })
        }

      }else {
        if (this.commonInput!== '') {
          console.log("!!!!!!!!!!!!")
          this.advSearchForm.keywords = [this.commonInput]
          console.log(this.advSearchForm)
          let paperList = []
          let total = 0
          getAdvancedSearchResult(this.advSearchForm).then(res => {
            if (res.success ) {
              paperList = res.content.paperBriefInfoVOList
              total = res.content.totalNum
              this.searching = false
              let newpage = this.$router.resolve({
                name: 'SearchPaper',
                query: {
                  papers: JSON.stringify(paperList),
                  totalNum: total,
                  content: this.commonInput+'(Keyword)',
                  kind: 0
                }
              })
              window.open(newpage.href, '_blank')
            } else {
              this.searching = false
              this.$message.error({
                message: "Invaild Input",
                center: true
              })
            }
          }).catch(error => console.log(error))
        }else{
          this.$message({
            message: 'Please Enter Something!',
            center: true
          })
        }
      }
    },
    querySearchAsync(queryString, cb) {
      if (queryString && queryString.length > 2) {
        getMatchAuthor(queryString).then(res => {
          console.log(res)
          if (res.success) {
            var list = [{}];
            for(let i of res.content){
              i.value = i.name;  //将想要展示的数据作为value
            }
            list = res.content;
            cb(list);
          }
        })
      }
    },
    handleSelect(item) {
      this.searchAuthor.authorId = item.id
      console.log(this.searchContexts)
    },
    querySearchAsync2(queryString, cb) {
      if (queryString && queryString.length > 2) {
        getMatchAffiliation(queryString).then(res => {
          console.log(res)
          if (res.success) {
            var list = [{}];
            for(let i of res.content){
              i.value = i.name;  //将想要展示的数据作为value
            }
            list = res.content;
            cb(list);
          }
        })
      }
    },
    handleSelect2(item) {
      this.searchAffiliation.affiliationId = item.id

      console.log(this.searchAffiliation.affiliationId, item);
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
    console.log(this.PaperList)
    this.paperNum = this.$route.query.totalNum
    console.log(this.paperNum)
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
