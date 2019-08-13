<template>
    <div>
      <!--查台转单 -->
      <div>
        <el-col :span="10"><el-input  v-model="telphone" placeholder="请输入手机号" class="input-with-select"></el-input></el-col>
        <el-col :span="10"><el-input v-model="businessnoticeno" placeholder="请输入通知单号" class="input-with-select"></el-input></el-col>
        <el-col :span="2"><el-button  type="primary" plain @click="reset()">重置</el-button></el-col>
        <el-col :span="2"><el-button type="success" plain @click="chataigneau()">查台</el-button></el-col>
      </div>

      <el-dialog
        title="转单"
        :visible.sync="centerDialogVisible"
        width="30%"
        center>
        <el-col :span="24">
          <el-radio-group v-model="radio">
            <el-radio :label="3" @change="cdr()">定区编号</el-radio>
            <el-radio :label="6" @change="smallPart()">小件员工号</el-radio>
            <!--<el-radio :label="9" @click="flag=false;ff=false;f=true">单位</el-radio>-->
          </el-radio-group>
        </el-col>
          <el-select v-show="flag" v-model="zonecode" clearable placeholder="请选择定区编号">
            <el-option
              v-for="item in basZoneInfoList"
              :key="item.id"
              :label="item.zonecode"
              :value="item.zonecode">
            </el-option>
          </el-select>

            <el-select v-show="ff" v-model="empno" clearable placeholder="请选择小件员工号">
              <el-option
                v-for="item in basAssociatememberList"
                :key="item.id"
                :label="item.empno"
                :value="item.empno">
              </el-option>
          </el-select>
          <span slot="footer" class="dialog-footer">
              <el-button @click="centerDialogVisible = false">取 消</el-button>
              <el-button type="primary" @click="transferOfOrder()">确 定</el-button>
          </span>
      </el-dialog>


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
            prop="accWorkorder.jobno"
            label="工单号"
            style="fit: true">
          </el-table-column>
          <el-table-column
            prop="accWorkorder.shortmessageint"
            label="短信序号"
            style="fit: true">
          </el-table-column>
          <el-table-column
            prop="businessnoticeno"
            label="业务通知单号">
          </el-table-column>
          <el-table-column
            prop="accWorkorder.workgenerationtime"
            label="工单生成时间">
          </el-table-column>
          <el-table-column
            prop="pickupaddress"
            label="收件地址">
          </el-table-column>
          <el-table-column
            prop="linkman"
            label="联系人">
          </el-table-column>
          <el-table-column
            prop="telphone"
            label="联系电话">
          </el-table-column>
          <el-table-column
            prop="accWorkorder.aftersinglenum"
            label="追单次数">
          </el-table-column>
          <el-table-column
            prop="sysDept.name"
            label="处理单位">
          </el-table-column>
          <el-table-column
            label="操作"
            width="180">
            <template slot-scope="scope">
              <el-button type="info" plain @click="openTransferDialog(scope.row.accWorkorder)">转单</el-button>
              <el-button type="warning" plain @click="retry(scope.row.accWorkorder)">重发</el-button>
            </template>
          </el-table-column>
        </el-table>
      </div>
      <pagination v-show="total>0" :total="total" :page.sync="page" :limit.sync="limit" @pagination="getList" />
    </div>
</template>


<script>
  import {queryAccBusinessadmissibilityAndAccWorkorderList,queryAccBusinessadmissibilityAndAccWorkorderCondition,basAssociatememberList,transferSmallPart,updateAccBusinessadmissibilityAndAccWorkorder} from "@/api/dis/check"
  import list from "../example/list"
  import {transferSmsDQ,basZoneInfoList} from '@/api/dis/zoneInfo'
  import {singlePinAndAdd} from '@/api/dis/workorder'
  import {retry} from '@/api/dis/associatemember'
  import Pagination from '@/components/Pagination'
    export default {
      components: { Pagination },
      data() {
        return {
          zonecode:'',
          empno:'',
          flag: false,
          ff:false,
          list: [],
          total:0,
          page: 1,
          limit: 10,
          telphone:'',
          businessnoticeno:'',
          centerDialogVisible:false,
          basAssociatememberList: [],
          radio:'',
          accWorkorder:undefined,
          basZoneInfoList:''
        }
      },
      methods: {
        // 重发
        retry(accWorkorder){
          this.$confirm('确定重发该单?', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning',
            center: true
          }).then(() => {
            retry(accWorkorder).then(response =>{
              this.$message({
                message: response.message,
                type: 'success'
              });
              this.getList()
            })

          }).catch(() => {
            this.$message({
              type: 'info',
              message: '已取消删除'
            });
          });
        },
        // 转单
        transferOfOrder(){
            if(this.zonecode!=null && this.zonecode!='' || this.empno!=null && this.empno!='' ){
              if(this.empno!=null && this.empno!=''){
                singlePinAndAdd(this.accWorkorder).then(response=>{
                  this.$message({
                    message: response.message,
                    type: 'success'
                  });
                  this.getList()
                  transferSmallPart(this.empno).then(response=>{
                    this.$message({
                      message: response.message,
                      type: 'success'
                    });
                  })
                })
                this.centerDialogVisible =false
              }
              if(this.zonecode!=null && this.zonecode!=''){
                singlePinAndAdd(this.accWorkorder).then(response=>{
                  this.$message({
                    message: response.message,
                    type: 'success'
                  });
                  this.getList()
                  transferSmsDQ(this.zonecode).then(response=>{
                    this.$message({
                      message: response.message,
                      type: 'success'
                    });
                  })
                })
               this.centerDialogVisible =false
              }
            }else {
              this.$message({
                message: '请选择转单目标',
                type: 'warning'
              });
            }
        },
        cdr(){
          this.flag = true
          this.ff = false
          basZoneInfoList().then(response =>{
            this.basZoneInfoList = response.data.basZoneInfoList
            if (this.flag=true){
              this.empno =''
            }
          })
        },
        smallPart(){
          this.flag = false
          this.ff = true
          basAssociatememberList().then(response =>{
              this.basAssociatememberList = response.data.list
              if (this.ff=true){
                this.zonecode =''
              }
          })
        },
          openTransferDialog(accWorkorder){
            this.accWorkorder = accWorkorder
            this.flag = false
            this.ff = false
            this.radio = ''
            this.zonecode = ''
            this.empno = ''
            this.centerDialogVisible = true
          },
          getList(){
                queryAccBusinessadmissibilityAndAccWorkorderList(this.page,this.limit).then(response => {
                  this.list = response.data.list
                  console.debug(response.data.total)
                  this.total = response.data.total
                })
          },
          chataigneau(){
            queryAccBusinessadmissibilityAndAccWorkorderCondition(this.page,this.limit,this.telphone,this.businessnoticeno).then(response =>{
              this.list = response.data.list
              console.debug(response.data.total)
              this.total = response.data.total
            })
          },
          reset(){
            this.telphone = ""
            this.businessnoticeno =""
            this.getList()
          }
      },
      created() {
        this.getList()
      }
  }
</script>

<style>

</style>
