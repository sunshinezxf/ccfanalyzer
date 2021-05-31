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
          <h1 style="margin-left: 3%;color:black;">{{paperNum}} Papers</h1>
          <div style="text-align:right">
            <el-button type="text" @click="dialogFormVisible = true">Upload&nbsp;Paper</el-button>
            <el-dialog title="PaperInfo" :visible.sync="dialogFormVisible" align="center" :modal="false" :close-on-click-modal="false">
              <el-form :model="form">
                <el-form-item label="Title" :label-width="formLabelWidth">
                  <el-input v-model="form.title" autocomplete="off" placeholder="标题只允许出现两次数字和-, :.'?特殊符号"></el-input>
                </el-form-item>
                <el-form-item label="Abstract" :label-width="formLabelWidth">
                  <el-input v-model="form.abstracts" autocomplete="off" placeholder="简介允许出现-, :.'?()_特殊符号"></el-input>
                </el-form-item>
                <el-form-item label="Authors" :label-width="formLabelWidth">
                  <el-input v-model="form.authors" autocomplete="off" placeholder="作者名字间用英文逗号分隔"></el-input>
                </el-form-item>
                <el-form-item label="Paper doi" :label-width="formLabelWidth">
                  <el-input v-model="form.doi" autocomplete="off" placeholder="需要 数字.数字/字符串 的形式"></el-input>
                </el-form-item>
                <el-form-item label="Citation Counts" :label-width="formLabelWidth">
                  <el-input v-model="form.citation" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="Book_title" :label-width="formLabelWidth">
                  <el-input v-model="form.book_title" autocomplete="off" placeholder="出版刊物标题允许-, :.'?特殊符号"></el-input>
                </el-form-item>
                <el-form-item label="PaperPages" :label-width="formLabelWidth">
                  <el-input v-model="form.pages" autocomplete="off" placeholder="页数需要 页数--页数/页数-页数 的形式"></el-input>
                </el-form-item>
                <el-form-item label="Year" :label-width="formLabelWidth">
                  <el-input v-model="form.year" autocomplete="off" placeholder="年份1960到今年"></el-input>
                </el-form-item>
                <el-form-item label="Publisher" :label-width="formLabelWidth">
                  <el-input v-model="form.publisher" autocomplete="off" placeholder="出版商简称需大写且长度3到10中"></el-input>
                </el-form-item>
                <el-form-item label="Url" :label-width="formLabelWidth">
                  <el-input v-model="form.url" autocomplete="off" placeholder="url开头必须是https://doi.org/"></el-input>
                </el-form-item>
                <el-form-item label="PublishTime" :label-width="formLabelWidth">
                  <el-input v-model="form.time" autocomplete="off" placeholder="按照周几(简写) 日 月(简写) 年的形式"></el-input>
                </el-form-item>
              </el-form>
              <div slot="footer" class="dialog-footer">
                <el-button @click="dialogFormVisible = false">Cancel</el-button>
                <el-button type="primary" @click="Upload(user.token, form); dialogFormVisible = false">Confirm</el-button>
              </div>
            </el-dialog>
          </div>
          <div class="col-md-2 text-center" v-for="item in PaperList" :key="item.title">
            <el-card style="margin-left: 35px; margin-right: 45px;height: 100%">
              <div style="margin-left: 2%;margin-left: 2%">
                <el-link style="font-size: 27px;color: black" @click="getContent(item.paperId)"><strong>{{item.title}}</strong></el-link><br>
                <el-row>
              <span class="affcon" style="font-size: 17px;color: dimgray">
                Authors:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <span  class="divider" v-if="item.authors.length==0">None</span>
              <span v-for="(author,index) in item.authors" :key="index">
                <span role="separator" class="divider" v-if="index != 0">,</span>
              <span style="font-size: 17px;color: dimgray;font-style:italic" :key="author" >{{author}}</span>
              </span>
              </span>
                </el-row>
                <span class="sum" style="font-size: 15px;color: dimgray;margin-top: 5px;margin-bottom: 5px" v-if="item.abstracts" >{{item.abstracts}}</span>
                <el-row>
                  <span style="font-size: 17px;color: dimgray">Publication:&nbsp;&nbsp;<el-link style="font-size: 17px;color: cornflowerblue;font-style:italic">{{item.publisher}}</el-link></span><br>
                </el-row>
              </div>
              <div  style="text-align:right">
                <el-button type="primary" icon="el-icon-edit" @click="dialogForm2Visible = true"></el-button>
                <el-dialog title="PaperInfo" :visible.sync="dialogForm2Visible" align="center" :modal="false" :close-on-click-modal="false">
                  <el-form :model="modifyForm">
                    <el-form-item label="Title" :label-width="formLabelWidth">
                      <el-input v-model="modifyForm.title" autocomplete="off" placeholder="标题只允许出现两次数字和-, :.'?特殊符号"></el-input>
                    </el-form-item>
                    <el-form-item label="Authors" :label-width="formLabelWidth">
                      <el-input v-model="modifyForm.authors" autocomplete="off" placeholder="简介允许出现-, :.'?()_特殊符号"></el-input>
                    </el-form-item>
                    <el-form-item label="Abstract" :label-width="formLabelWidth">
                      <el-input v-model="modifyForm.abstracts" autocomplete="off" placeholder="作者名字间用英文逗号分隔"></el-input>
                    </el-form-item>
                    <el-form-item label="Paper doi" :label-width="formLabelWidth">
                      <el-input v-model="modifyForm.doi" autocomplete="off" placeholder="需要 数字.数字/字符串 的形式"></el-input>
                    </el-form-item>
                    <el-form-item label="Citation Counts" :label-width="formLabelWidth">
                      <el-input v-model="modifyForm.citation" autocomplete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="Book_title" :label-width="formLabelWidth">
                      <el-input v-model="modifyForm.book_title" autocomplete="off" placeholder="出版刊物标题允许-, :.'?特殊符号"></el-input>
                    </el-form-item>
                    <el-form-item label="PaperPages" :label-width="formLabelWidth">
                      <el-input v-model="modifyForm.pages" autocomplete="off" placeholder="页数需要 页数--页数/页数-页数 的形式"></el-input>
                    </el-form-item>
                    <el-form-item label="Year" :label-width="formLabelWidth">
                      <el-input v-model="modifyForm.year" autocomplete="off" placeholder="年份1960到今年"></el-input>
                    </el-form-item>
                    <el-form-item label="Publisher" :label-width="formLabelWidth">
                      <el-input v-model="modifyForm.publisher" autocomplete="off" placeholder="出版商简称需大写且长度3到10中"></el-input>
                    </el-form-item>
                    <el-form-item label="Url" :label-width="formLabelWidth">
                      <el-input v-model="modifyForm.url" autocomplete="off" placeholder="url开头必须是https://doi.org/"></el-input>
                    </el-form-item>
                    <el-form-item label="PublishTime" :label-width="formLabelWidth">
                      <el-input v-model="modifyForm.time" autocomplete="off" placeholder="按照周几(简写) 日 月(简写) 年的形式"></el-input>
                    </el-form-item>
                  </el-form>
                  <div slot="footer" class="dialog-footer">
                    <el-button @click="dialogForm2Visible = false">Cancel</el-button>
                    <el-button type="primary" @click="UpdatePaper(user.token, modifyForm, item.paper_id); dialogForm2Visible = false">Confirm</el-button>
                  </div>
                </el-dialog>
                <el-button type="primary" icon="el-icon-share" @click="dialogForm1Visible = true"></el-button>
                <el-dialog title="Paper Share" :visible.sync="dialogForm1Visible" align="center" :modal="false" :close-on-click-modal="false">
                  <el-form :model="shareForm">
                    <el-form-item label="UserName" :label-width="formLabelWidth">
                      <el-input v-model="shareForm.name" autocomplete="off"></el-input>
                    </el-form-item>
                  </el-form>
                  <div slot="footer" class="dialog-footer">
                    <el-button @click="dialogForm1Visible = false">Cancel</el-button>
                    <el-button type="primary" @click="SharePapers(user.token, item.paper_id, shareForm.name); dialogForm1Visible = false">Confirm</el-button>
                  </div>
                </el-dialog>
                <el-button type="primary" icon="el-icon-delete" @click="deletePaper(user.token, item.paper_id)" style="text-align:right"></el-button>
              </div>
            </el-card>
          </div>
        </div>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
import {PaperUpload, PaperShare, PaperUpdate, PaperInfo,deletePaper} from '../../API/User/PersonalWarehouseAPIs'
import lo from '../../components/Center'
import Qs from 'qs'
export default {
  components: {
    lo
  },
  name: 'PersonalWarehouse',
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
      paperNum: '',
      PaperList: [
        {
          authors: [{
            name: 'apple'
          }, {
            name: 'bear'
          }],
          abstracts: 'Learning Models and the Learning Cycle Learning Differences and Learning Styles The Role of the Learning Environment Background to Learning Styles Assessment of Learning Styles Learning Styles Learning and Teaching The Inclusive School Characteristics and Challenges Learning Styles in the Inclusive Context Promoting Effective Learning Learning Styles Strategies and Insights',
          bib_source: '',
          bib_url: '',
          book_title: '',
          citation: '',
          doi: '',
          pages: '',
          paper_id: '',
          publisher: '',
          time: '',
          title: '',
          url: '',
          year: ''
        }
      ],
      dialogFormVisible: false,
      form: {
        authors: '',
        title: '',
        abstracts: '',
        doi: '',
        citation: '',
        book_title: '',
        pages: '',
        year: '',
        publisher: '',
        url: '',
        time: '',
        bib_url: '',
        bib_source: '',
        token: ''
      },
      modifyForm: {
        paper_id: '',
        authors: [],
        title: '',
        abstracts: '',
        doi: '',
        citation: '',
        book_title: '',
        pages: '',
        publisher: '',
        year: '',
        url: '',
        time: '',
        bib_url: '',
        bib_source: ''
      },
      formLabelWidth: '120px',
      shareForm: {
        name: ''
      },
      dialogForm1Visible: false,
      dialogForm2Visible: false
    }
  },
  mounted () {
    this.user.username = this.user.username = localStorage.getItem('username')
    this.user.token = localStorage.getItem('token')
    this.getPersonalPaper()
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
    Upload (token, Form) {
      Form.token = token
      if (Form.year === '' || Form.year < 1960 || Form.year > 2021) {
        this.$message.error({
          message: 'Please Enter Correct Year',
          center: true
        })
      } else if (Form.citation === '') {
        Form.citation = 0
      } else if (Form.title === '') {
        this.$message.error({
          message: 'Please Enter Title',
          center: true
        })
      } else if (Form.abstracts === '') {
        this.$message.error({
          message: 'Please Enter abstract',
          center: true
        })
      } else if (Form.doi === '') {
        this.$message.error({
          message: 'Please Enter doi',
          center: true
        })
      } else if (Form.publisher === '') {
        this.$message.error({
          message: 'Please Enter Publisher',
          center: true
        })
      } else if (Form.authors === '') {
        this.$message.error({
          message: 'Please Enter Authors',
          center: true
        })
      } else {
        PaperUpload(Qs.stringify(Form)).then((res) => {
          console.log(res)
          this.$message.success({
            message: 'Upload Successful',
            center: true
          })
          location.reload()
        })
      }
    },
    SharePapers (token, paperId, username) {
      PaperShare(token, paperId, username).then((res) => {
        console.log(res)
        this.$message.success({
          message: 'Share Successful',
          center: true
        })
      })
    },
    UpdatePaper (token, Form, paperId) {
      Form.token = token
      Form.paper_id = paperId
      if (Form.year === '' || Form.year < 1960 || Form.year > 2021) {
        this.$message.error({
          message: 'Please Enter Correct Year',
          center: true
        })
      } else if (Form.citation === '') {
        Form.citation = 0
      } else if (Form.title === '') {
        this.$message.error({
          message: 'Please Enter Title',
          center: true
        })
      } else if (Form.abstracts === '') {
        this.$message.error({
          message: 'Please Enter abstract',
          center: true
        })
      } else if (Form.doi === '') {
        this.$message.error({
          message: 'Please Enter doi',
          center: true
        })
      } else if (Form.publisher === '') {
        this.$message.error({
          message: 'Please Enter Publisher',
          center: true
        })
      } else if (Form.authors === '') {
        this.$message.error({
          message: 'Please Enter Authors',
          center: true
        })
      } else {
        PaperUpdate(Qs.stringify(Form)).then((res) => {
          console.log(res)
          this.$message.success({
            message: 'Update Successful',
            center: true
          })
          location.reload()
        })
      }
    },
    getPersonalPaper () {
      PaperInfo(localStorage.getItem('token')).then((res) => {
        console.log(res)
        this.PaperList = res.content
      })
    },
    deletePaper (token, id) {
      this.$confirm('Are you sure to delete this article?', 'Prompt', {
        confirmButtonText: 'Confirm',
        cancelButtonText: 'Cancel',
        type: 'warning'
      }).then(() => {
        deletePaper(token, id).then((res) => {
          console.log(res)
          this.$message.success({
            message: 'Update Successful',
            center: true
          })
          location.reload()
        })
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
