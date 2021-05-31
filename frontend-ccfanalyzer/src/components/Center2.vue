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

        <el-col :span="20">
          <div class="grid-content2 bg-purple2" style="color: white;">

            <el-row style="margin-bottom: -8%"></el-row>
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
    name: 'lo2',
    data () {
      return {
        user: {
          flag: false,
          username: '',
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
      }
    }
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

