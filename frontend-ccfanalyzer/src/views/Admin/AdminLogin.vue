<template>
  <div class="backimg" :style="this.$store.state.background">
    <div style="text-align: center">
      <div class="OASIS" style=" ;font-size: 130px;text-align:center;margin-top: 3%;color: black">
        OASIS
      </div>
      <div style="font-size: 30px;text-align:center;margin-bottom: 1%; color: black">
        Admin Login
      </div>
      <div>
        <el-input class="input_" style="width: 18%;" placeholder="username" v-model="username" clearable></el-input>
      </div>
      <div>
        <el-input class="input_" style="width: 18%;margin-top: 2%" placeholder="password" v-model="password" show-password></el-input>
      </div>
      <span slot="footer" class="dialog-footer">
          <el-button class="login" style="width: 18%; margin-bottom: 5%; opacity: 75%;
           font-size: 18px;margin-top: 2%" type="primary" @click="dialogVisible = false; login()" round>LOGIN</el-button>
  </span>
    </div>
  </div>
</template>

<script>
import {
  adminLogin
} from '../../API/Admin/AdminLoginAPI'
export default {
  name: 'AdminLogin',
  data () {
    return {
      username: '',
      password: ''
    }
  },
  methods: {
    login () {
      if (this.username === '') {
        this.$message({
          message: 'Please Enter Username',
          center: true
        })
      } else if (this.password === '') {
        this.$message({
          message: 'Please Enter Password',
          center: true
        })
      } else {
        adminLogin({
          username: this.username,
          password: this.password
        }).then(res => {
          if (res.status.code === '0000') {
            localStorage.setItem('Flag', 'isLogin')
            this.$message.success({
              message: 'Login Successful',
              center: true
            })
            this.$router.push({
              name: 'UpdateTime'
            })
            // setTimeout(function () {
            //   this.$router.push({
            //     name: 'UploadFile'
            //   })
            // }.bind(this), 500)
          } else {
            this.$message.error({
              message: res.status.msg,
              center: true
            })
          }
        }).catch(err => {
          this.$message.error({
            message: err.toString(),
            center: true
          })
        })
      }
    }
  },
  mounted: function () {
    this.$store.dispatch('flushFun')
  }
}
</script>

<style scoped>
  .backimg {
    width:100%;
    height:100%;
    position: absolute
  }
  .login:hover{
    box-shadow: 0 0 10px 2px rgba(87, 146, 224, 1);
  }
</style>
<style>
  .input_ .el-input__inner{
    border-radius: 30px;
  }
</style>
