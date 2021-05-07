<template xmlns:el-col="http://www.w3.org/1999/html">
  <el-container>
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
    <el-container>
      <el-aside width=70%>
        <div style="margin: 39px">
          <el-row>
            <el-col :span="17">
          <span style="font-size: 45px;color: black"><strong>{{item.title}}</strong></span><br><br>
            </el-col>
            <el-col :span="3">
              <div class="st" style="font-size: 60px;margin-top: -25px">
              <el-button  icon="el-icon-star-off" circle @click="collectPaper(item.paperId)"></el-button>
              </div>
            </el-col>
            <el-col :span="3">
              <div class="st" style="font-size: 60px;margin-top: -25px">
              <el-button icon="el-icon-share" circle></el-button>
              </div>
            </el-col>
          </el-row>
          <span style="font-size: 23px;color: dimgray;font-style:italic" >{{item.publicationYear}}&nbsp;&nbsp;</span><br>
          <el-row>
          <span  style="font-size: 21px;color: dimgray">
            <el-col span="3">
                Affiliations:
              </el-col>
            <el-col span="21">
              <span  style="font-size: 19px;color: dimgray" class="divider" v-if="item.affiliations.length==0">None</span>
          <span v-for="(aff,index) in item.affiliations" :key="index">
                <span role="separator" class="divider" v-if="index != 0">,</span>
                <el-link style="font-size: 21px;color: cornflowerblue;font-style:italic"  :key='aff.name' @click="searchAffiliationPor(aff.affiliationId)">{{aff.name}}</el-link>
          </span>
              </el-col><br>
          </span>
          </el-row>
          <el-row>
          <span  style="font-size: 21px;color: dimgray">
            <el-col span="3">
                Authors:
            </el-col>
              <el-col span="21">
                <span  style="font-size: 19px;color: dimgray" class="divider" v-if="item.authors.length==0">None</span>
          <span v-for="(author,index) in item.authors" :key="index">
                <span role="separator" class="divider" v-if="index != 0">,</span>
             <el-link style="font-size: 21px;color: cornflowerblue;font-style:italic" :key="author.name" @click="searchAuthorPor(author.authorId)">{{author.name}}</el-link>
          </span><br></el-col>
          </span>
          </el-row>
          <!--<el-row>-->
          <!--<span  style="font-size: 21px;color: dimgray">-->
            <!--<el-col span="3">-->
                <!--Directions:-->
            <!--</el-col>-->
              <!--<el-col span="21">-->
                <!--<span  style="font-size: 19px;color: dimgray" class="divider" v-if="item.directions.length==0">None</span>-->
          <!--<span v-for="(direction,index) in item.directions" :key="index">-->
                <!--<span role="separator" class="divider" v-if="index != 0">,</span>-->
             <!--<el-link style="font-size: 21px;color: cornflowerblue;font-style:italic" :key="direction.name" @click="searchDirectionPor(direction.directionId)">{{direction.name}}</el-link>-->
          <!--</span><br></el-col>-->
          <!--</span>-->
          <!--</el-row>-->
          <br>
          <span style="font-size: 17px;color: dimgray" >{{item.summary}}</span><br><br><br>
          <el-row>
            <el-col span="3">
          <span style="font-size: 19px;color: dimgray" >
            Keywords:</span></el-col>
          <el-col span="21">
            <span  style="font-size: 19px;color: dimgray" class="divider" v-if="item.keywords.length==0">None</span>
          <span v-for="(keyword,index) in item.keywords" :key="index">

                <span role="separator" class="divider" v-if="index != 0">,</span>
              <el-link style="font-size: 19px;color:cornflowerblue;font-style:italic" :key="keyword" @click="searchByKeyword(keyword)">{{keyword}}</el-link>
              </span><br></el-col></el-row>
          <el-row>
            <el-col span="3">
              <span style="font-size: 19px;color: dimgray" >Publication:</span></el-col>
            <el-col span="21"><span ><el-link style="font-size: 19px;color:cornflowerblue;font-style:italic"  @click="searchConferencePor(item.publication)">{{item.publication}}</el-link></span></el-col>
          </el-row>
          <el-row>
            <span  style="font-size: 19px;color: dimgray" class="divider" v-if="item.startPage>=0">
            <el-col span="3">
              <span style="font-size: 19px;color: dimgray" >StartPage:</span></el-col>
            <el-col span="21"><span style="font-size: 19px;color: dimgray" >{{item.startPage}}</span></el-col></span>
          </el-row>
          <el-row>
            <span  style="font-size: 19px;color: dimgray" class="divider" v-if="item.endPage>=0">
            <el-col span="3">
              <span style="font-size: 19px;color: dimgray" >EndPage:</span></el-col>
            <el-col span="21"><span style="font-size: 19px;color: dimgray" >{{item.endPage}}</span></el-col>
            </span>
          </el-row>
          <el-row>
            <el-col span="3">
              <span style="font-size: 19px;color: dimgray" >DOI:</span></el-col>
            <el-col span="21"><span style="font-size: 19px;color: dimgray" >{{item.doi}}</span>
              <el-button type="primary"  style="float:right" @click="pdflink(item.url)">PDF</el-button>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="5">
              <i class="el-icon-view"></i>

            </el-col>
            <el-col :span="5">
              <i class="el-icon-upload"></i>
            </el-col>
            <el-col :span="5">
              <i class="el-icon-download"></i>
            </el-col>
            <el-col :span="9">

            </el-col>
          </el-row>
        </div>
      </el-aside>
      <el-main>
        <el-col span="4" style="height: 100%">
          <div style="float:left;width: 1px;height: 100%; background: grey"></div>
        </el-col>
        <el-col span="18">
          <br>
          <div>
            <el-row>
            <el-col :span="8">
              <div class="grid-content">
                <Icon class="header_icon" type="md-school" size="50"/>
              </div>
            </el-col>

            <el-col :span="16">
              <div class="grid-content">
                <div class="header_num" style="font-size: 23px;">{{item.articleCitationCount}}</div>
                <div class="header_type">Article Citation Count</div>
              </div>
            </el-col>
            </el-row>
            <el-divider></el-divider>
            <br>
            <el-row>
              <el-col :span="8">
                <div class="grid-content">
                  <Icon class="header_icon" type="md-school" size="50"/>
                </div>
              </el-col>
              <el-col :span="16">
                <div class="grid-content">
                  <div class="header_num" style="font-size: 23px;">{{ref.referenceCount}}</div>
                  <div class="header_type">Reference Count</div>
                </div>
              </el-col>
            </el-row>
            <br><br>
            <span style="font-size: 30px;">Reference Papers</span><br>

            <div class="ref" v-for="refer in ref.references" :key="refer">
              <el-row>
                <el-tooltip effect="dark" placement="left">
                  <div slot="content">
                    {{refer.reference}}
                  </div>
                  <el-link :title="refer.reference" @click="referlink(refer.googleScholarLink)">
                    <div style="font-size: 17px;color: cornflowerblue;overflow: hidden;white-space: nowrap;width: 350px;text-overflow: ellipsis;">
                      {{refer.reference}}
                    </div>
                  </el-link>
                </el-tooltip>
              </el-row>
            </div>
            </div>
</el-col>
      </el-main>
    </el-container>
  </el-container>

</template>

<script>
  import {getPaperDetail,getPaperDetailref,paperCollection} from '../../API/Paper/PaperDetail'
  import {
    getCommonSearchResult, getAdvancedSearchResult,getMatchAuthor,getMatchAffiliation,
    //   getAffiliationActivityRanking, getAuthorActivityRanking, getResearchDirectionPopularityRanking, getTopPapers, getTopAffiliations, getTopAuthors,  adminLogin,
  } from '../../API/Home/HomePageAPIs'
  import lo from '../../components/Center'
  import Qs from 'qs'
  export default {
    components: {
      lo
    },
  name: 'PaperDetail',
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
      dialogVisible: false,
      commonSearchTypeValue: '',
      searching: false,
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
      advSearchForm: {
        authors: [],
        affiliations: [],
        startYear: 2013,
        endYear: 2020,
        conferenceName: '',
        keywords: [],
        index:0
      },
      commonInput: '',
      background: {
        backgroundImage: 'url(' + require('@/assets/background.jpg') + ')',
        backgroundRepeat: 'no-repeat',
        backgroundSize: 'cover'
      },
      item: {
        paperId: 0,
        title: 'Learning Styles and Inclusion.',
        authors: [{
          authorId: 1,
          name: 'yry'
        }],
        affiliations: [
          {
            authorId: 1,
            name: 'yry'
          }
        ],

        publication: 'IEEE',
        publicationYear: '2005',
        startPage: 0,
        endPage: 0,
        doi: '10.1109',
        summary: 'Learning Models and the Learning Cycle Learning Differences and Learning Styles The Role of the Learning Environment Background to Learning Styles Assessment of Learning Styles Learning Styles Learning and Teaching The Inclusive School Characteristics and Challenges Learning Styles in the Inclusive Context Promoting Effective Learning Learning Styles Strategies and Insights ...',
        keywords: ['Educational technology'],
        url: 'http://www.baidu.com',
        articleCitationCount: 0,
        referenceCount: 0,
        references: [{
          reference: 'Learning Styles and Inclusion',
          googleScholarLink: 'http://www.baidu.com'
        }]
      },
      ref:{
        referenceCount: 0,
        references: [{
          reference: 'Learning Styles and Inclusion',
          googleScholarLink: 'http://www.baidu.com'
        }]
      }
    }
  },
  methods: {

    Detail () {
      getPaperDetail(this.item.paperId).then((res) => {
        this.item = res.content
        this.getRef()
      })

    },
    getRef(){
      getPaperDetailref(this.item.paperId).then((res) => {
        console.log("fsd")
        console.log(res)
        this.item.references=res.content.references
        this.item.referenceCount=res.content.referenceCount
        this.ref=res.content
        console.log(this.item.referenceCount)
      })
    },
    pdflink (e) {
      window.location.href = e
    },
    referlink (e) {
      window.location.href = e
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
              paperList = res.content.paperBriefInfoVOList
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
    searchDirectionPor (directionId) {
    //   let newpage = this.$router.resolve({
    //     name: 'DirectionPortrait',
    //     query: {
    //       directionId: directionId
    //     }
    //   })
    //   window.open(newpage.href, '_blank')
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
    searchConferencePor (name) {
      let newpage = this.$router.resolve({
        name: 'ConferencePortrait',
        query: {
          name: name
        }
      })
      window.open(newpage.href, '_blank')
    },
     searchByKeyword (name) {
    //   this.advSearchForm.keywords = [name]
    //   let paperList = []
    //   let total = 0
    //   getAdvancedSearchResult(this.advSearchForm).then((res) => {
    //     paperList = res.data.paperBriefInfoVOList
    //     total = res.data.totalNum
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
    toHomepage () {
      this.$router.push({path: '/'})
    },
    highlight () {
      document.getElementById('OASIS').style.cursor = 'pointer'
      document.getElementById('OASIS').style.fontSize = '40px'
    },
    redoHightLight () {
      document.getElementById('OASIS').style.fontSize = '50px'
    },
    collectPaper (paperId) {
      if (localStorage.getItem('flag')) {
        var params = {
          token: localStorage.getItem('token'),
          paper_id: paperId
        }
        paperCollection(Qs.stringify(params)).then((res) => {
          console.log(res)
          this.$message.success({
            message: 'Collection Successful',
            center: true
          })
        })
      } else {
        this.$message.error({
          message: 'Please Login First',
          center: true
        })
      }
    }
  },
  mounted () {
    let id = this.$route.query.paperId
    this.item.paperId = id
    this.Detail()
    this.$store.dispatch('flushFun')
  }
}
</script>
<style scoped>
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
