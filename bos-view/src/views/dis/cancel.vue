<template>
  <!-- 取消签收申请确认-->
  <div>
    <div>
      <el-col :span="9"><el-input  v-model="workorderid" placeholder="请输入工作单ID" class="input-with-select"></el-input></el-col>
      <el-col :span="9"><el-input v-model="worksheetno" placeholder="请输入工作单号" class="input-with-select"></el-input></el-col>
      <el-col :span="2"><el-button  type="primary" plain @click="reset()">重置</el-button></el-col>
      <el-col :span="2"><el-button type="success" plain @click="chataigneau()">查询</el-button></el-col>

    </div>

    <div>
      <el-table
        :data="list"
        border
        style="width: 100%">
        <el-table-column
          type="index"
          label="序号"
          width="50">
        </el-table-column>

        <el-table-column
          prop="worksheetno"
          label="工作单号"
          style="fit: true">
        </el-table-column>

        <el-table-column
          prop="requestcode"
          label="申请单号">
        </el-table-column>

        <el-table-column
          prop="signtime"
          label="签收时间">
        </el-table-column>

        <el-table-column
          prop="signtype"
          label="签收类型"
          :formatter="formatterSignType">
        </el-table-column>

        <el-table-column
          prop="requeststate"
          label="申请状态"
          :formatter="formatterRequestState">
        </el-table-column>

        <el-table-column
          prop="sysUser.username"
          label="申请人">
        </el-table-column>

        <el-table-column
          prop="requesttime"
          label="申请时间">
        </el-table-column>

        <el-table-column
          prop="sysDept.name"
          label="申请单位">
        </el-table-column>

        <el-table-column
          prop="confirmor"
          label="确认人">
        </el-table-column>

        <el-table-column
          label="操作"
          width="270">
          <template slot-scope="scope">
            <el-button type="info" plain @click="applyfor(scope.row)">申请</el-button>
            <el-button type="warning" plain @click="notarize(scope.row)">确认</el-button>
            <el-button type="warning" plain @click="cancellation(scope.row)">作废</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <pagination v-show="total>0" :total="total" :page.sync="page" :limit.sync="limit" @pagination="getList" />
  </div>
</template>


<script>
  import list from "../example/list"
  import Pagination from '@/components/Pagination'
  import {disWorkOrderSignList,conditionDisWorkordersignList,applyfor,notarize,cancellation} from '@/api/dis/workordersign'
  import {accWorksheetList} from '@/api/dis/worksheet'
    export default {
      components: { Pagination },
      data() {
        return {
          list:[],
          total:0,
          page: 1,
          limit: 10,
          workorderid:'',
          worksheetno:'',
          disWorkordersign: {id:'',workorderid:'',worksheetno:'',workordertype:'',signtype:'',requestcode:'',requeststate:'',confirmor:'',requesttime:'',courierint:'',couriername:'',recipient:'',signunit:'',signtime:'',signtime:'',
            abnormalmark:'',inputpersoncode:'',inputpersonid:'',inputid:'',inputtime:'',sysDept:{id:'',name:''},sysUser:{id:'',username:''}},
          accWorksheetList:[]
        }
      },
      methods :{
        // 申请
        applyfor(disWorkordersign){
            this.$confirm('确定申请?', '提示', {
              confirmButtonText: '确定',
              cancelButtonText: '取消',
              type: 'warning',
              center: true
            }).then(() => {
              if(disWorkordersign.requeststate === 4 && disWorkordersign.requeststate != null && disWorkordersign.requeststate !=""){
                applyfor(disWorkordersign).then(response =>{
                  this.$message({
                    message: response.message,
                    type: 'success'
                  });
                  this.getList()
                })
              }else {
                this.$message({
                  message: "异常，该签收单不能申请，请选择其他签收单",
                  type: 'info'
                });
              }

            }).catch(() => {
              this.$message({
                type: 'info',
                message: '已取消'
              });
            });
        },
       // 确认
        notarize(disWorkordersign){
          this.$confirm('确定确认?', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning',
            center: true
          }).then(() => {
              if(disWorkordersign.requeststate === 3 && disWorkordersign.requeststate != null && disWorkordersign.requeststate !="") {
                notarize(disWorkordersign).then(response => {
                  this.$message({
                    message: response.message,
                    type: 'success'
                  });
                  this.getList()
                })
              }else {
                  this.$message({
                    message: "异常，该签收单不能确认，请选择其他签收单",
                    type: 'info'
                  });
                }
          }).catch(() => {
            this.$message({
              type: 'info',
              message: '已取消'
            });
          });
        },
        // 作废
        cancellation(disWorkordersign){
          this.$confirm('确定作废?', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning',
            center: true
          }).then(() => {
              if(disWorkordersign.requeststate === 3 && disWorkordersign.requeststate != null && disWorkordersign.requeststate !="") {
                  cancellation(disWorkordersign).then(response =>{
                    this.$message({
                      message: response.message,
                      type: 'success'
                    });
                    this.getList()
                  })
              }else {
                this.$message({
                  message: "异常，该签收单不能作废，请选择其他签收单",
                  type: 'info'
                });
              }
          }).catch(() => {
            this.$message({
              type: 'info',
              message: '已取消'
            });
          });
        },
        getList(){
          disWorkOrderSignList(this.page,this.limit).then(response => {
            this.list = response.data.list
            console.debug(response.data.total)
            this.total = response.data.total
          })
        },
        chataigneau(){
          conditionDisWorkordersignList(this.page,this.limit,this.workorderid,this.worksheetno).then(response =>{
            this.list = response.data.list
            console.debug(response.data.total)
            this.total = response.data.total
          })
        },
        reset(){
          this.workorderid = ""
          this.worksheetno =""
          this.getList()
        },
        formatterRequestState(row, column, cellValue, index){
          return row.requeststate == 1 ? '通过' : row.requeststate == 2 ? '作废' : row.requeststate == 3 ? '待审批' : row.requeststate == 4 ? '未申请' : '未知';
        },
        formatterSignType(row, column, cellValue, index){
          return row.signtype == 1 ? '正常签收' : row.signtype == 2 ? '反向签收' : '未知';
        }
      },
      created() {
        this.getList()
      }

    }


</script>

<style>

</style>
