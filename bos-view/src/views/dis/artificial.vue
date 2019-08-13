<template>
  <div>
    <!--人工调度 -->
    <div>
      <el-col :span="10"><el-input  v-model="telphone" placeholder="请输入手机号" class="input-with-select"></el-input></el-col>
      <el-col :span="10"><el-input v-model="businessnoticeno" placeholder="请输入通知单号" class="input-with-select"></el-input></el-col>
      <el-col :span="2"><el-button  type="primary" plain @click="reset()">重置</el-button></el-col>
      <el-col :span="2"><el-button type="success" plain @click="chataigneau()">查台</el-button></el-col>
    </div>

    <el-dialog
      title="分配"
      :visible.sync="allocationDialogVisible"
      width="75%"
      center>
      <el-select v-model="deptId" clearable placeholder="请选择单位">
        <el-option
          v-for="item in deptList"
          :key="item.id"
          :label="item.name"
          :value="item.id">
        </el-option>
      </el-select>

      <span slot="footer" class="dialog-footer">
        <el-button @click="allocationDialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="allocationTrue()">确 定</el-button>
      </span>
    </el-dialog>

    <!-- 详情-->
    <el-dialog
      title="详情"
      :visible.sync="centerDialogVisible"
      width="75%"
      center>
      <el-tabs type="border-card">
        <el-tab-pane label="业务通知单信息">

          <el-form :inline="true" :model="accBusinessadmissibility" class="demo-form-inline">
            <el-col :span="8">
              <el-form-item label="业务通知单号">
                <el-input v-model="accBusinessadmissibility.businessnoticeno" :disabled="true"></el-input>
              </el-form-item>
            </el-col>

            <el-col :span="8">
              <el-form-item label="预约收件时间">
                <el-input v-model="accBusinessadmissibility.reservationtime" :disabled="true"></el-input>
              </el-form-item>
            </el-col>

            <el-col :span="8">
              <el-form-item label="客户名称">
                <el-input v-model="accBusinessadmissibility.customname" :disabled="true"></el-input>
              </el-form-item>
            </el-col>

            <el-col :space="20">
              <el-form-item label="取件地址">
                <el-input style="width: 400px" v-model="accBusinessadmissibility.pickupaddress" :disabled="true"></el-input>
              </el-form-item>
            </el-col>

              <el-form-item label="客户编号">
                <el-input v-model="accBusinessadmissibility.customcode" :disabled="true"></el-input>
              </el-form-item>

              <el-form-item label="联系人">
                <el-input v-model="accBusinessadmissibility.linkman" :disabled="true"></el-input>
              </el-form-item>

              <el-form-item label="联系电话">
                <el-input v-model="accBusinessadmissibility.telphone" :disabled="true"></el-input>
              </el-form-item>

              <el-form-item label="重量">
                <el-input v-model="accBusinessadmissibility.weight" :disabled="true"></el-input>
              </el-form-item>

              <el-form-item label="体积">
                <el-input v-model="accBusinessadmissibility.volume" :disabled="true"></el-input>
              </el-form-item>

              <el-form-item label="重要提示">
                <el-input v-model="accBusinessadmissibility.importanthints" :disabled="true"></el-input>
              </el-form-item>

              <el-form-item label="到达城市">
                <el-input v-model="accBusinessadmissibility.arrivecity" :disabled="true"></el-input>
              </el-form-item>

           <!-- <el-col :space="8">
              <el-form-item label="取货人信息">
                <el-input v-model="accBusinessadmissibility.sysUser.username" :disabled="true"></el-input>
              </el-form-item>
            </el-col>-->
            <el-col :space="24">
              <el-form-item label="派送地址">
                <el-input v-model="accBusinessadmissibility.sendaddress" :disabled="true"></el-input>
              </el-form-item>
            </el-col>
           <!-- <el-col :space="8">
              <el-form-item label="处理单位">
                <el-input v-model="accBusinessadmissibility.sysDept.name" :disabled="true"></el-input>
              </el-form-item>
            </el-col>-->
              <el-form-item label="通知单来源">
                <el-input v-model="accBusinessadmissibility.notificationsource" :disabled="true"></el-input>
              </el-form-item>
          </el-form>
        </el-tab-pane>

        <el-tab-pane label="工单信息" >
          <el-form :inline="true" :model="accWorkorder" class="demo-form-inline">
            <el-col :span="8">
              <el-form-item label="工单号">
                <el-input v-model="accWorkorder.jobno" :disabled="true"></el-input>
              </el-form-item>
            </el-col>

            <el-col :span="8">
              <el-form-item label="工单类型">
                <el-input v-model="accWorkorder.jobtype"  :disabled="true">
                  <span v-if="accWorkorder.jobtype == 1">新单</span>
                  <span v-else-if="accWorkorder.jobtype == 2">追单</span>
                  <span v-else-if="accWorkorder.jobtype == 3">销单</span>
                </el-input>
              </el-form-item>
            </el-col>

            <el-col :span="8">
              <el-form-item label="取件状态">
                <el-input v-model="accWorkorder.pickupstatus" :disabled="true"></el-input>
              </el-form-item>
            </el-col>

              <el-form-item label="短信序号">
                <el-input v-model="accWorkorder.shortmessageint" :disabled="true"></el-input>
              </el-form-item>

              <el-form-item label="工单生成时间">
                <el-input v-model="accWorkorder.workgenerationtime" :disabled="true"></el-input>
              </el-form-item>

              <el-form-item label="追单次数">
                <el-input v-model="accWorkorder.aftersinglenum" :disabled="true"></el-input>
              </el-form-item>

             <!-- <el-form-item label="小件员编号">
                <el-input v-model="accWorkorder.aftersinglenum" :disabled="true"></el-input>
              </el-form-item>-->

              <el-form-item label="取件时间">
                <el-input v-model="accWorkorder.pickuptime" :disabled="true"></el-input>
              </el-form-item>

              <el-form-item label="分拣编号">
                <el-input v-model="accWorkorder.sortingcode" :disabled="true"></el-input>
              </el-form-item>
          </el-form>
        </el-tab-pane>

        <el-tab-pane label="调度历史">调度历史</el-tab-pane>
      </el-tabs>
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
          prop="businessnoticeno"
          label="业务通知单号">
        </el-table-column>

        <el-table-column
          prop="reservationtime"
          label="预约收件时间"
          style="fit: true">
        </el-table-column>

        <el-table-column
          prop="customname"
          label="客户名称"
          style="fit: true">
        </el-table-column>
        <el-table-column
          prop="pickupaddress"
          label="取件地址">
        </el-table-column>
        <el-table-column
          prop="customcode"
          label="客户编号">
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
          prop="weight"
          label="重量">
        </el-table-column>
        <el-table-column
          prop="volume"
          label="体积">
        </el-table-column>
        <el-table-column
          prop="importanthints"
          label="重要提示">
        </el-table-column>
        <el-table-column
          prop="arrivecity"
          label="到达城市">
        </el-table-column>
        <el-table-column
          label="操作"
          width="200">
          <template slot-scope="scope">
            <el-button type="info" plain @click="allocation(scope.row.accWorkorder)">分配</el-button>
            <el-button type="warning" plain @click="sendBack(scope.row.accWorkorder)">退回</el-button>
            <el-button type="info" plain @click="singlePin(scope.row.accWorkorder)">销单</el-button>
            <el-button type="warning" plain @click="particulars(scope.row)">详情</el-button>
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
  import Pagination from '@/components/Pagination'
  import {singlePin,sendBack,allocation} from  '@/api/dis/workorder'
  import {getByParentIdSysDept} from '../../api/sys/dept'

  export default {
    components: { Pagination },
    data() {
      return {
        list:[],
        total:0,
        page: 1,
        limit: 10,
        telphone:'',
        businessnoticeno:'',
        centerDialogVisible:false,
        accBusinessadmissibility: {businessnoticeno:'',reservationtime:'',customname:'',pickupaddress:'',customcode:'',linkman:'',telphone:'',weight:'',volume:'',
          importanthints:'',arrivecity:'',pickerinfo:'',sendaddress:'',processingunit:'',notificationsource:'',customnomodifyflag:'',singletype:'',packagesnum:'',actualweight:'',billingweight:'',
          packingfee:'',actualpacking:''},
        accWorkorder: {id:'',businessnoticeno:'',jobno:'',jobtype:'',pickupstatus:'',shortmessageint:'',workgenerationtime:'',aftersinglenum:'',smallmembernum:'',pickupunit:'',
          pickuptime:'',sortingcode:''},
        deptList:[],
        allocationDialogVisible:false,
        deptId:''
      }
    },
    methods: {
      allocationTrue(){
        if(this.deptId !=null && this.deptId!=""){
          this.$confirm('确定将此单分配给该部门?', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning',
            center: true
          }).then(() => {
            allocation(this.accWorkorder,this.deptId).then(response => {
              this.$message({
                message: response.message,
                type: 'success'
              });
              this.getList()
              this.allocationDialogVisible = false
              this.deptId = ""
            })
          }).catch(() => {
            this.deptId = ""
            this.$message({
              type: 'info',
              message: '已取消删除'
            });
          });
        }else {
          this.$message({
            type: 'info',
            message: '请选择单位'
          });
        }

      },
      allocation(accWorkorder){
        getByParentIdSysDept().then(response =>{
          this.deptList = response.data.deptList
        })
        this.allocationDialogVisible = true
        this.accWorkorder = {id:accWorkorder.id,businessnoticeno:accWorkorder.businessnoticeno,jobno:accWorkorder.jobno,
          jobtype:accWorkorder.jobtype,pickupstatus:accWorkorder.pickupstatus,shortmessageint:accWorkorder.shortmessageint,
          workgenerationtime:accWorkorder.workgenerationtime,aftersinglenum:accWorkorder.aftersinglenum,smallmembernum:accWorkorder.smallmembernum,
          pickupunit:accWorkorder.pickupunit,pickuptime:accWorkorder.pickuptime,sortingcode:accWorkorder.sortingcode}
        console.debug(this.accWorkorder)
      },
      sendBack(accWorkorder){
        this.$confirm('确定退回此单?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning',
          center: true
        }).then(() => {
          sendBack(accWorkorder).then(response => {
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
      singlePin(accWorkorder){
        this.$confirm('确定消除此单?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning',
          center: true
        }).then(() => {
            singlePin(accWorkorder).then(response => {
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
      // 详情
      particulars(accBusinessadmissibility){
        this.centerDialogVisible=true
        this.accBusinessadmissibility = {id:accBusinessadmissibility.id,businessnoticeno:accBusinessadmissibility.businessnoticeno,reservationtime:accBusinessadmissibility.reservationtime,customname:accBusinessadmissibility.customname,
          pickupaddress:accBusinessadmissibility.pickupaddress,customcode:accBusinessadmissibility.customcode,linkman:accBusinessadmissibility.customcode,
          telphone:accBusinessadmissibility.telphone,weight:accBusinessadmissibility.weight,volume:accBusinessadmissibility.volume,importanthints:accBusinessadmissibility.importanthints,
          arrivecity:accBusinessadmissibility.arrivecity,pickerinfo:accBusinessadmissibility.pickerinfo,sendaddress:accBusinessadmissibility.sendaddress,processingunit:accBusinessadmissibility.processingunit,
          notificationsource:accBusinessadmissibility.notificationsource,customnomodifyflag:accBusinessadmissibility.notificationsource,singletype:accBusinessadmissibility.singletype,packagesnum:accBusinessadmissibility.packagesnum,
          actualweight:accBusinessadmissibility.actualweight,billingweight:accBusinessadmissibility.billingweight,packingfee:accBusinessadmissibility.packingfee,actualpacking:accBusinessadmissibility.actualpacking}

          console.debug(this.accBusinessadmissibility)

        this.accWorkorder = {id:accBusinessadmissibility.accWorkorder.id,businessnoticeno:accBusinessadmissibility.accWorkorder.businessnoticeno,jobno:accBusinessadmissibility.accWorkorder.jobno,
          jobtype:accBusinessadmissibility.accWorkorder.jobtype,pickupstatus:accBusinessadmissibility.accWorkorder.pickupstatus,shortmessageint:accBusinessadmissibility.accWorkorder.shortmessageint,
          workgenerationtime:accBusinessadmissibility.accWorkorder.workgenerationtime,aftersinglenum:accBusinessadmissibility.accWorkorder.aftersinglenum,smallmembernum:accBusinessadmissibility.accWorkorder.smallmembernum,
          pickupunit:accBusinessadmissibility.accWorkorder.pickupunit,pickuptime:accBusinessadmissibility.accWorkorder.pickuptime,sortingcode:accBusinessadmissibility.accWorkorder.sortingcode}
        console.debug(this.accWorkorder)

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

