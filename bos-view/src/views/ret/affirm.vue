<template>
  <!--返货申请确认 -->
    <div>
      <div>
        <el-col :span="10"><el-input  v-model="applicationno" placeholder="请输入申请单号" class="input-with-select"></el-input></el-col>
        <el-col :span="10"><el-input v-model="worksheetno" placeholder="请输入工作单号" class="input-with-select"></el-input></el-col>
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
            prop="applicationno"
            label="申请单号"
            style="fit: true">
          </el-table-column>
          <el-table-column
            prop="confirmationtime"
            label="确认时间"
            style="fit: true">
          </el-table-column>
          <el-table-column
            prop="confirmationname"
            label="确认单位">
          </el-table-column>
          <el-table-column
            prop="confirmationpersonname"
            label="确认人">
          </el-table-column>
          <el-table-column
            prop="treatmentstate"
            label="返货处理状态"
            :formatter="formatterTreatmentState">
          </el-table-column>
          <el-table-column
            prop="apremark"
            label="反馈信息">
          </el-table-column>
          <el-table-column
            prop="handlingopinions"
            label="处理信息">
          </el-table-column>

          <el-table-column
            label="操作"
            width="290">
            <template slot-scope="scope">
              <el-button type="info" plain @click="confirmation(scope.row)">申请确认</el-button>
              <el-button type="info" plain @click="returnTheGoods(scope.row)">返货</el-button>
              <el-button type="info" plain @click="refuse(scope.row)">拒绝</el-button>
            </template>
          </el-table-column>
        </el-table>
      </div>
      <pagination v-show="total>0" :total="total" :page.sync="page" :limit.sync="limit" @pagination="getList" />
    </div>
</template>


<script>
  import {returnListList,getRetReturnListListTerm,confirmation,returnTheGoods,refuse} from '@/api/ret/returnList'
  import list from "../example/list"
  import Pagination from '@/components/Pagination'

    export default {
      components: { Pagination },
      data() {
        return {
          list: [],
          total:0,
          page: 1,
          limit: 10,
          applicationno:'',
          worksheetno:''

        }
      },
      methods:{
        // 拒绝
        refuse(retReturnList){
          if (retReturnList.treatmentstate ===1) {
            refuse(retReturnList).then(response =>{
              this.$message({
                message: response.message,
                type: 'success'
              })
              this.getList()
            })
          }else {
            this.$message({
              type: 'info',
              message: '该单不能进行拒绝操作'
            });
          }

        },
        // 返货
        returnTheGoods(retReturnList){
          if (retReturnList.treatmentstate ===1) {
            returnTheGoods(retReturnList).then(response =>{
              this.$message({
                message: response.message,
                type: 'success'
              })
              this.getList()
            })
          }else {
            this.$message({
              type: 'info',
              message: '该单不能进行返货'
            });
          }

        },
        // 返货申请确认
        confirmation(retReturnList){
          if (retReturnList.treatmentstate ===1) {
              confirmation(retReturnList).then(response =>{
                this.$message({
                  message: response.message,
                  type: 'success'
                })
                this.getList()
              })
          }else {
            this.$message({
              type: 'info',
              message: '该单不能进行申请确认'
            });
          }

        },
        getList(){
          returnListList(this.page,this.limit).then(response => {
            this.list = response.data.list
            console.debug(response.data.total)
            this.total = response.data.total
          })
        },
        chataigneau(){
          getRetReturnListListTerm(this.page,this.limit,this.applicationno,this.worksheetno).then(response =>{
            this.list = response.data.list
            console.debug(response.data.total)
            this.total = response.data.total
          })
        },
        reset(){
          this.applicationno = ""
          this.worksheetno =""
          this.getList()
        },
        formatterTreatmentState(row, column, cellValue, index){
          return row.treatmentstate == 1 ? '未确认' : row.treatmentstate == 2 ? '同意返货' : row.treatmentstate == 3 ? '拒绝' : '未知';
        }
      },
      created() {
        this.getList()
      }

    }


</script>

<style>

</style>
