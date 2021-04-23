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
        <el-breadcrumb separator="/" style="font-size: 32px">
          <el-breadcrumb-item :to="{ path: '/MyTeams' }">MyTeams</el-breadcrumb-item>
          <el-breadcrumb-item><a href="/">Team1</a></el-breadcrumb-item>
          <el-button  plain style="float:right;width: 200px;font-size: 15px" @click="drawer = true" >修改成员</el-button>
          <el-button  plain style="float:right;width: 100px;margin-right: 30px;font-size: 15px"  type="danger" :disabled="!isOwner" @click="open2">删除团队</el-button>
          <el-button  plain style="float:right;width: 100px;margin-right: 30px;font-size: 15px"  type="info" @click="open">退出团队</el-button>
        </el-breadcrumb>
        <el-divider></el-divider>
        <div>
          <el-drawer
            append-to-body="true"
            style="margin-top: 8%"
            title="全部成员"
            :modal="false"
            :visible.sync="drawer"
            :direction="direction"
            :before-close="handleClose">
            <el-row style="text-align: center">
              <el-col :span="4" >
                <el-button type="primary" circle><span style="font-size: 10px">&nbsp;+&nbsp;</span></el-button>
              </el-col>
              <el-col :span="20">
              <el-input v-model="input" placeholder="addMember" style="width: 80%"></el-input>
              </el-col>
            </el-row>

            <el-divider></el-divider>
            <el-table
              :data="tableData"
              stripe
              style="width: 100%">
              <el-span :span="6">

              <el-table-column
                prop="name"
                label="姓名">
              </el-table-column>
              </el-span>
              <el-table-column
                prop="actions"
                label="操作">
                <template slot-scope="scope">
                  <el-button type="text" :disabled="!isOwner">移出</el-button>
                </template>
              </el-table-column>
            </el-table>
          </el-drawer>
          <br>
          <h1 style="margin-left: 3%;color:black;">{{paperNum}} Papers</h1>
          <div style="text-align:right">
            <el-button type="text" @click="dialogFormVisible = true">文章上传</el-button>
            <el-dialog title="文章信息" :visible.sync="dialogFormVisible" align="center" :modal="false" :close-on-click-modal="false">
              <el-form :model="form">
                <el-form-item label="文章标题" :label-width="formLabelWidth">
                  <el-input v-model="form.title" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="文章简介" :label-width="formLabelWidth">
                  <el-input v-model="form.abstracts" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="文章doi" :label-width="formLabelWidth">
                  <el-input v-model="form.doi" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="文章引用数" :label-width="formLabelWidth">
                  <el-input v-model="form.citation" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="出版标题" :label-width="formLabelWidth">
                  <el-input v-model="form.book_title" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="文章页数" :label-width="formLabelWidth">
                  <el-input v-model="form.paperPages" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="年份" :label-width="formLabelWidth">
                  <el-input v-model="form.years" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="出版商" :label-width="formLabelWidth">
                  <el-input v-model="form.publisher" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="url" :label-width="formLabelWidth">
                  <el-input v-model="form.url" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="出版时间" :label-width="formLabelWidth">
                  <el-input v-model="form.time" autocomplete="off"></el-input>
                </el-form-item>
              </el-form>
              <div slot="footer" class="dialog-footer">
                <el-button @click="dialogFormVisible = false">取 消</el-button>
                <el-button type="primary" @click="Upload(user.token, form)">确 定</el-button>
              </div>
            </el-dialog>
          </div>
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
                <el-button type="primary" icon="el-icon-edit" @click="dialogForm2Visible = true"></el-button>
                <el-dialog title="文章信息" :visible.sync="dialogForm2Visible" align="center" :modal="false" :close-on-click-modal="false">
                  <el-form :model="form">
                    <el-form-item label="文章标题" :label-width="formLabelWidth">
                      <el-input v-model="form.title" autocomplete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="文章简介" :label-width="formLabelWidth">
                      <el-input v-model="form.abstracts" autocomplete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="文章doi" :label-width="formLabelWidth">
                      <el-input v-model="form.doi" autocomplete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="文章引用数" :label-width="formLabelWidth">
                      <el-input v-model="form.citation" autocomplete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="出版标题" :label-width="formLabelWidth">
                      <el-input v-model="form.book_title" autocomplete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="文章页数" :label-width="formLabelWidth">
                      <el-input v-model="form.paperPages" autocomplete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="年份" :label-width="formLabelWidth">
                      <el-input v-model="form.years" autocomplete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="出版商" :label-width="formLabelWidth">
                      <el-input v-model="form.publisher" autocomplete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="url" :label-width="formLabelWidth">
                      <el-input v-model="form.url" autocomplete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="出版时间" :label-width="formLabelWidth">
                      <el-input v-model="form.time" autocomplete="off"></el-input>
                    </el-form-item>
                  </el-form>
                  <div slot="footer" class="dialog-footer">
                    <el-button @click="dialogForm2Visible = false">取 消</el-button>
                    <el-button type="primary" @click="UpdatePaper(user.token, form)">确 定</el-button>
                  </div>
                </el-dialog>
                <el-button type="primary" icon="el-icon-share" @click="dialogForm1Visible = true"></el-button>
                <el-dialog title="文章分享" :visible.sync="dialogForm1Visible" align="center" :modal="false" :close-on-click-modal="false">
                  <el-form :model="shareForm">
                    <el-form-item label="用户名" :label-width="formLabelWidth">
                      <el-input v-model="shareForm.name" autocomplete="off"></el-input>
                    </el-form-item>
                  </el-form>
                  <div slot="footer" class="dialog-footer">
                    <el-button @click="dialogForm1Visible = false">取 消</el-button>
                    <el-button type="primary" @click="SharePapers(user.token, item.paperId, shareForm.name)">确 定</el-button>
                  </div>
                </el-dialog>
              </div>
            </el-card>
          </div>

        </div>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
  import {PaperUpload, PaperShare, PaperUpdate} from '../../API/User/PersonalWarehouseAPIs'
  import {TeamMemberQuit,TeamDelete,getTeamOwner,getTeamList} from '../../API/User/TeamAPIs'
  export default {
    name: 'PersonalWarehouse',
    data () {
      return {
        isOwner:false,
        team_id:1,
        tableData: [{
          name: '王小虎',
        }, {
          date: '2016-05-04',
          name: '王小虎',
          province: '上海',
          city: '普陀区',
          address: '上海市普陀区金沙江路 1517 弄',
          zip: 200333
        }, {
          date: '2016-05-01',
          name: '王小虎',
          province: '上海',
          city: '普陀区',
          address: '上海市普陀区金沙江路 1519 弄',
          zip: 200333
        }, {
          date: '2016-05-03',
          name: '王小虎',
          province: '上海',
          city: '普陀区',
          address: '上海市普陀区金沙江路 1516 弄',
          zip: 200333
        }],
        drawer: false,
        direction: 'rtl',
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
        dialogFormVisible: false,
        form: {
          title: '',
          abstracts: '',
          doi: '',
          citation: '',
          book_title: '',
          paperPages: '',
          years: '',
          publisher: '',
          url: '',
          time: ''
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
      this.isOwnerAble(this.user.token ,this.team_id)
      this.getMemberLists(this.team_id)

    },
    created () {
      var docHeight = document.documentElement.clientHeight
      this.containerHeight.height = docHeight - 40 + 'px'
    },
    methods: {
      isOwnerAble(userID,teamID) {
        getTeamOwner(userID,teamID).then((res) => {
          if(res.content===1){
            this.isOwner=true
          }else{
            this.isOwner=false
          }
        }).catch(error => console.log(error))
      },
      getMemberLists(team_id) {
        getTeamList(team_id).then((res) => {
          if(res.content===1){
            this.isOwner=true
          }else{
            this.isOwner=false
          }
        }).catch(error => console.log(error))
      },
      open() {
        this.$confirm('此操作将退出团队1, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
            TeamMemberQuit(this.user.token, this.team_id).then((res) => {
              this.$message({
                type: 'success',
                message: '退出成功!'
              });
            }).catch(error => console.log(error))
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消退出'
          });
        });
      },
      open2() {
        this.$confirm('此操作将删除团队1，包括所有数据, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          TeamDelete(this.user.token, this.team_id).then((res) => {
            this.$message({
              type: 'success',
              message: '退出成功!'
            });
          }).catch(error => console.log(error))
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消退出'
          });
        });
      },
      handleClick(row) {
        console.log(row);
      },
      handleClose(done) {
        this.$confirm('确认关闭？')
          .then(_ => {
            done();
          })
          .catch(_ => {});
      },
      handleOpen (key, keyPath) {
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
        console.log(Form)
        PaperUpload(token, Form).then((res) => {
          this.$message.success({
            message: 'Upload Successful',
            center: true
          })
        })
      },
      SharePapers (token, paperId, username) {
        PaperShare(token, paperId, username).then((res) => {
          this.$message.success({
            message: 'Share Successful',
            center: true
          })
        })
      },
      UpdatePaper (token, Form) {
        PaperUpdate(token, Form).then((res) => {
          this.$message.success({
            message: 'Update Successful',
            center: true
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
