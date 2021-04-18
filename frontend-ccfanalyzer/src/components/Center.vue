<template>
  <div>
  <div style="margin-left: -19px;margin-right: -19px;text-align:center">
    <el-row style="margin-bottom: 2%">
      <el-col :span="4">
        <div class="grid-content2 bg-purple2" style="color: white;text-align:center">

          <el-row>
                  <span class="avatar-dropdown" @click="toHomepage">
                    <i class="el-icon-s-home" ></i>
                    <span class="u" style="font-size: 20px;color: grey;text-align: center"  @click="toHomepage">
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
              <el-dropdown-item @click.native="toHome" divided>个人中心</el-dropdown-item>
              <el-dropdown-item command="logout" divided>退出登录</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </div>

        <div v-show="!user.login">

                   <span class="avatar-dropdown">
                        <!--<el-avatar class="user-avatar" :src="avatar"></el-avatar>-->
                        <el-avatar src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"></el-avatar>


                       <span class="u" style="font-size: 20px" @click="toLogin">
                          &nbsp;&nbsp; Login&nbsp;In&nbsp;&nbsp;
                       </span>

                      </span>
        </div>
      </div>
      </el-col>
    </el-row>
  </div>
  <div>
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
  </div>
  </div>
</template>

<script>
    export default{
    name: 'lo',
    data(){
          return{
            user: {
              login: false,
              logout: false,
              username: 'yry',
              password: '',
              id: '',
              token: ''
            },
            dialogVisible: false,
          }
    },
      methods:{
        toHomepage () {
          this.$router.push({path: '/'})
        },
        toHome () {
          router.beforeEach((to,from,next)=>{
            if(to.path ==='/Login'){
              next();
            }else {
              let token = localStorage.getItem('userInfo');
              if(token === null || token === ''){
                next('/Login');
              }else {
                next('/Collections');
              }
            }
          });
        },
        toLogin () {
          this.$router.push({path: '/Login'})
        },

      },
      mounted () {
        this.user.username = localStorage.getItem('username')
        this.user.token = localStorage.getItem('token')
        this.user.login=true
        this.user.logout=false
      },
    }
</script>

<style scoped>
  .el-row {
    margin-bottom: 20px;
  &:last-child {
     margin-bottom: 0;
   }
  }

  .bg-purple2 {
    background-color: rgba(255,255,255,0.8);
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


  .el-select-dropdown__item span{
    opacity: 80%;
  }
</style>
