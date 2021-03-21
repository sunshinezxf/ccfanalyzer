<template>
  <div>
    <el-main class="main" :style="this.$store.state.background" style="overflow: hidden;padding: 0%">
    <el-row>
      <el-col :span="4">
        <el-row>
          <div class="OASIS" id="OASIS" style="font-weight:bold;color:white;font-size: 40px;text-align:center;margin-top: 4%"
               @mouseenter="highlight" @click="toHomepage">
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
        <div style="text-align: center;">
          <el-select v-model="commonSearchTypeValue" clearable placeholder="All" style="opacity:80%; width: 10%;text-align: left;position:relative; z-index:9999;" :popper-append-to-body="true">
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
            :disabled="searching"
            @keyup.enter.native="commonSearch"
            clearable>
          </el-input>

          <el-button @click="commonSearch" type="primary" icon="el-icon-search" :loading="searching">SEARCH</el-button>

        </div>
      </el-col>
    </el-row>
    </el-main>
    <el-footer>
      <div align="center">
        <el-card class="box-card" style="margin-top: 4%" >
          <div slot="header" class="clearfix" style="font-size: 20px">
            <span >用户注册</span>
          </div>
          <div class="text item">
            <el-form :model="registerForm" class="demo-ruleForm">
              <el-form-item label="用户名" prop="username" >
                <el-input v-model="registerForm.username"></el-input>
              </el-form-item>
              <el-form-item label="密码" prop="password">
                <el-input type="password" v-model="registerForm.password" ></el-input>
              </el-form-item>
              <el-form-item label="确认密码" prop="checkPassword">
                <el-input type="password" v-model="registerForm.checkPass" ></el-input>
              </el-form-item>
              <el-form-item>
                <el-button type="primary" @click="resetForm('ruleForm')">重置</el-button>
                <el-button type="primary" @click="register(registerForm)" >注册</el-button>
              </el-form-item>
            </el-form>
          </div>
        </el-card>
      </div>
    </el-footer>
  </div>
</template>

<script>
import {getAdvancedSearchResult, getCommonSearchResult} from '../../API/Home/HomePageAPIs'
import {Register} from '../../API/User/RegisterAPIs'

export default {
  name: 'Register',
  data () {
    return {
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
      searching: false,
      commonSearchTypeValue: '',
      registerForm: {
        username: '',
        password: '',
        checkPass: ''
      }
    }
  },
  methods: {
    commonSearch () {
      if (this.searching) {
        return
      }
      if (this.commonInput !== '') {
        this.searching = true
        let paperList = []
        let total = 0
        if (this.commonSearchTypeValue === '') { // type为All
          getCommonSearchResult(this.commonInput, 0).then((res) => {
            if (res.success) {
              paperList = res.content.paperBriefInfoVOList
              total = res.content.totalNum
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
              if (res.success) {
                console.log(res.content.totalNum)
                paperList = res.content.paperBriefInfoVOList
                total = res.content.totalNum
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
              if (res.success) {
                paperList = res.content.paperBriefInfoVOList
                total = res.content.totalNum
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
              if (res.success) {
                paperList = res.content.paperBriefInfoVOList
                total = res.content.totalNum
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
    register (ruleForm) {
      console.log(ruleForm)
      if (ruleForm.username === '') {
        this.$message({
          message: 'Please Enter Username',
          center: true
        })
      } else if (ruleForm.password === '') {
        this.$message({
          message: 'Please Enter Password',
          center: true
        })
      } else if (ruleForm.checkPass !== ruleForm.password) {
        this.$message({
          message: 'Inconsistent Password Input',
          center: true
        })
      } else {
        Register(ruleForm.username, ruleForm.password).then((res) => {
          if (res.content === '成功注册！') {
            this.$message.success({
              message: '注册成功，请重新登录',
              center: true
            })
            this.$router.push({
              name: 'Login'
            })
          } else {
            this.$message.error({
              message: res.content,
              center: true
            })
          }
        })
      }
    },
    resetForm (formName) {
      this.$refs[formName].resetFields()
    },
    toHomepage () {
      this.$router.push({name: 'Homepage'})
    },
    highlight () {
      document.getElementById('OASIS').style.cursor = 'pointer'
      document.getElementById('OASIS').style.fontSize = '40px'
    }
  }
}
</script>

<style scoped>
  .text {
    font-size: 14px;
  }

  .item {
    margin-bottom: 18px;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }
  .clearfix:after {
    clear: both
  }

  .box-card {
    width: 480px;
  }
</style>
