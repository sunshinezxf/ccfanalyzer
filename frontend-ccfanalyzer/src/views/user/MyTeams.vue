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
      <div >

      <el-main class="main" >
        <div >
          <el-row>
            <div >
            <el-card :span="6" :body-style="{ padding: '0px' }" style="margin: 20px">
              <img class="image"  src="../../assets/add.png"/>
              <div style="padding: 14px;" @click="dialogFormVisible = true">
                <div class="bottom clearfix">
                Team Building
                </div>
              </div>
            </el-card>
              <el-dialog class="biuldTeam" title="Team Building" :visible.sync="dialogFormVisible" text-align="center" :before-close="handleClose" :modal="false" :close-on-click-modal="false"  width="30%">
                <el-form :model="form">
                  <el-form-item label="Team Name" >
                    <el-input v-model="form.team_name" autocomplete="off"></el-input>
                  </el-form-item>
                </el-form>
                <div slot="footer" class="dialog-footer">
                  <el-button @click="dialogFormVisible = false">取 消</el-button>
                  <el-button type="primary" @click="Upload(user.token, form)">确 定</el-button>
                </div>
              </el-dialog>
            </div>
            <el-col :span="24/Team.length" v-for="(team,index) in Team" :key="o" >
              <el-card :body-style="{ padding: '0px' }" style="margin: 20px">
                <img class="image" :src="carouselData[index%4].url" />
                <div style="padding: 14px;">

                  <div class="bottom clearfix">
                    <el-link  @click="getTeamDetail(team.name,team.team_id)"><span style="font-size: 20px;">{{team.name}}</span></el-link>
                  </div>
                </div>
              </el-card>
            </el-col>
          </el-row>
        </div>
      </el-main>
      </div>
    </el-container>
  </el-container>
</template>

<script>
  import {getCollections, deleteCollection} from '../../API/User/CollectionAPIs'
  import {getTeamList,TeamCreate} from '../../API/User/TeamAPIs'
  import lo from '../../components/Center'

  export default {
    components: {
      lo
    },
    data () {
      return {
        form:{
          team_name:''
        },
        carouselData:[
          {url:require('../../assets/team1.jpg'),id:1},
          {url:require('../../assets/team2.jpg'),id:2},
          {url:require('../../assets/team3.jpg'),id:3},
          {url:require('../../assets/team4.jpg'),id:4}
        ],
        Team:[],
        dialogFormVisible:false,
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
        ],
        page: 0
      }
    },
    mounted () {
      this.user.username = localStorage.getItem('username')
      this.user.token = localStorage.getItem('token')
      console.log(this.user.token)
      this.getTeamLists(this.user.token)
    },
    created () {
      var docHeight = document.documentElement.clientHeight
      this.containerHeight.height = docHeight - 40 + 'px'
    },
    methods: {
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
      handleClose (key, keyPath) {
        console.log(key, keyPath)
      },
      getTeamLists (userID) {
        getTeamList(userID).then((res) => {
          this.Team = res.content
          console.log(this.Team)
        })
      },
      Upload (token, Form) {
        TeamCreate({token:token, team_name:Form.team_name}).then((res) => {
          if(res.content==="该团队名称已被使用"){
            this.$message({
              type: 'info',
              message: 'This team name is already in use.'
            });
          }else{
            this.$message.success({
              message: 'Build Successful',
              center: true
            })
            this.dialogFormVisible = false
            this.getTeamLists(token)
          }


        }).catch(() => {
          this.$message({
            type: 'info',
            message: 'Fail to Build'
          });
        });
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
      getTeamDetail (name,id) {
        this.$router.push({ path: 'TeamDetails', query: { teamName:name,
            teamId:id }})
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
  .ma{
    z-index: -999;
    height: 100px;
    filter: alpha(opacity=50);
    -moz-opacity: 0.5;
    -ms-opacity: 0.5;
    -webkit-opacity: 0.5;
    -o-opacity: 0.5;
    opacity: 0.5;
    position: absolute;
    top: 0;
    left: 0;
    right: 0;
    background: url(../../assets/background_night.jpg) ;
    background-size: 100% 100%;
  }
  .time {
    font-size: 13px;
    color: #999;
  }

  .bottom {
    margin-top: 13px;
    line-height: 12px;
  }

  .button {
    padding: 0;
    float: right;
  }


  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }

  .clearfix:after {
    clear: both
  }

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
    width:350px;
    height: 200px;
    display: block;

  }
  .el-select-dropdown__item span{
    opacity: 80%;
  }

  .el-card {
    width: 300px;
    border: none;
    margin: 20px;
    border-radius: 6px;
    -webkit-transition: all 250ms cubic-bezier(0.02, 0.01, 0.47, 1);
    transition: all 250ms cubic-bezier(.02, .01, .47, 1);
    word-break: break-all;
  }
  .el-card:hover {
    box-shadow: 0px 1rem 2rem 0px rgba(48, 55, 66, 0.15);
    transform: translate(0,-5px);
    transition-delay: 0s !important;
  }
  .box-shadow {
    -webkit-box-shadow: 0 0.25rem 1rem rgba(48, 55, 66, 0.15);
    box-shadow: 0 0.25rem 1rem rgba(48, 55, 66, 0.15);
  }
  img {
    opacity: 0.8;
  }

</style>

