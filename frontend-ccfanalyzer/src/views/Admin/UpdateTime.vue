<template>
  <el-container>
   <div class="backimg" :style="this.$store.state.background">
     <div style="margin-top: 2%; font-size: 30px;text-align:center;color: white">
       Paper Data Update Records
     </div>
     <div style="padding: 0px; width: 60%; margin-left: 20%; margin-top: 1.5%">
         <el-row>
           <el-col :span="12">
             <span style="color: white; font-size: 18px; opacity: 90%"><span style="font-weight: bold; color: white">{{recordsCount}}</span> records in total</span>
           </el-col>
           <el-col :span="12" style="text-align: right">
             <router-link :to="{name: 'UploadFile'}" style="font-size: 18px">
               <Icon type="ios-globe-outline" /> Manual operation interface
             </router-link>
           </el-col>
         </el-row>
         <el-divider></el-divider>
     </div>
     <div style="height: 71%">
       <div class="record_item" v-for="recordItem in recordList" :key="recordItem.updateTime"
            style="background-color: white; opacity: 80%; width: 40%; height: 56px; margin-left: 30%; border-radius: 3px; margin-bottom: 0.7%;
          padding: 7px; ">
         <el-row>
           <el-col :span="12" style="padding-left: 15px">
             <div style="font-weight: bold">
               <Icon size="18" type="md-time" /> {{recordItem.updateTime}}
             </div>
           </el-col>
           <el-col :span="12">
             <div>
               <el-row>
                 <el-col :span="12">
                   <span>New Added from ACM:</span>
                 </el-col>
                 <el-col :span="12" style="text-align: right; padding-right: 50px">
                   <span style="font-weight: bold;">{{recordItem.acmcount}}</span>
                   <span> papers</span>
                 </el-col>
               </el-row>
             </div>
             <div>
               <el-row>
                 <el-col :span="12">
                   <span>New Added from IEEE:</span>
                 </el-col>
                 <el-col :span="12" style="text-align: right; padding-right: 50px">
                   <span style="font-weight: bold;">{{recordItem.ieeecount}}</span>
                   <span> papers</span>
                 </el-col>
               </el-row>
             </div>
           </el-col>
         </el-row>
       </div>
     </div>
     <div style="text-align: center; ">
       <el-pagination class="records_pagination"
         layout="prev, pager, next"
         :total="recordsCount" :page-size.sync="pageSize" :current-page.sync="currentPage"
          @current-change="handleCurrentChange">
       </el-pagination>
     </div>
   </div>
 </el-container>
</template>

<script>
import {
  getUpdateHistory
} from '../../API/Admin/AdminLoginAPI'
export default {
  name: 'UpdateTime',
  data () {
    return {
      currentPage: 1,
      pageSize: 8,
      recordsCount: 20,
      recordList: []
    }
  },
  methods: {
    handleCurrentChange (val) {
      this.loadRecords(val - 1)
    },
    loadRecords (index) {
      getUpdateHistory(index).then(res => {
        if (res.status.code === '0000') {
          this.recordsCount = res.data.count
          this.recordList = res.data.historyList
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
    },
    loadData () {
      this.loadRecords(0)
    }
  },
  mounted: function () {
    this.$store.dispatch('flushFun')
    this.loadData()
  }
}
</script>

<style scoped>
  .backimg{
    width:100%;
    height:100%;
    position: absolute;
  }
  .el-divider{
    background-color: white;
    margin-top: 3px;
  }
  .record_item:hover{
    box-shadow: 0 0 10px 2px rgb(255, 255, 255);
  }
</style>

<style>
  .records_pagination .el-pager li{
    color: white;
  }
  .records_pagination .el-pager li.active{
    color: #409EFF;
  }
  .records_pagination .el-pager li{
    background-color: rgba(0, 0, 0, 0);
  }
  .records_pagination .btn-next{
    color: white;
    background-color: rgba(0, 0, 0, 0);
  }
  .records_pagination .btn-prev{
    color: white;
    background-color: rgba(0, 0, 0, 0);
  }
  .records_pagination button:disabled{
    background-color: rgba(0, 0, 0, 0);
  }
</style>
