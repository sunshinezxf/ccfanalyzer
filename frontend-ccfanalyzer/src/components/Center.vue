<template>
  <div>
  <div style="margin-left: -19px;margin-right: -19px;text-align:center">
    <el-row style="margin-bottom: 2%">
      <el-col :span="4">
        <div class="grid-content2 bg-purple2" style="color: white;text-align:center">

          <el-row>
                  <dic class="avatar-dropdown" @click="toHomepage">
                    <i class="el-icon-s-home" ></i>
                    <div class="u" style="font-size: 20px;color: grey;text-align: center"  @click="toHomepage">
                    &nbsp;&nbsp;HomePage &nbsp;
                 </div>
                  </dic>
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
              <el-dropdown-item @click.native="toHome" divided>My&nbsp;Center</el-dropdown-item>
              <el-dropdown-item command="logout" divided @click.native="userLogout">Logout</el-dropdown-item>
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
import {Logout} from '../API/User/LoginAPIs'

export default{
  name: 'lo',
  data () {
    return {
      user: {
        flag: false,
        username: 'yry',
        password: '',
        id: '',
        token: ''
      },
      dialogVisible: false,
    }
  },
  methods: {
    toHomepage () {
      this.$router.push({path: '/'})
    },
    toHome () {

      this.$router.push({path: '/Collections'})
    },
    toLogin () {
      this.$router.push({path: '/Login'})
    },
    userLogout () {
      this.$confirm('This operation will log out, whether to continue?', 'Prompt', {
        confirmButtonText: 'Confirm',
        cancelButtonText: 'Cancel',
        type: 'warning'
      }).then(() => {
        Logout(localStorage.getItem('token')).then((res) => {
          localStorage.clear()
          this.$router.push({
            name: 'Homepage'
          })
        })
        this.$message({
          type: 'success',
          message: 'Logout Successfully!'
        });
      }).catch(() => {
        this.$message({
          type: 'info',
          message: 'Cancel'
        });
      });

    }
  },
  mounted () {
    this.user.username = localStorage.getItem('username')
    this.user.token = localStorage.getItem('token')
    this.user.login = localStorage.getItem('flag')
    this.user.logout = !localStorage.getItem('flag')
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
