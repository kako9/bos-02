<template>
  <!--签收录入 -->
    <div>
      <div>
        <el-col :span="9"><el-input  v-model="workorderid" placeholder="请输入工作单ID" class="input-with-select"></el-input></el-col>
        <el-col :span="9"><el-input v-model="worksheetno" placeholder="请输入工作单号" class="input-with-select"></el-input></el-col>
        <el-col :span="2"><el-button  type="primary" plain @click="reset()">重置</el-button></el-col>
        <el-col :span="2"><el-button type="success" plain @click="chataigneau()">查询</el-button></el-col>
        <el-col :span="2"><el-button type="info" plain @click="addDisWorkordersign()">新增</el-button></el-col>
      </div>

      <!-- 新增 -->
      <div>
        <el-dialog
          title="新增"
          :visible.sync="addDialogVisible"
          width="50%"
          center>
          <el-form :model="disWorkordersign" label-width="80px">
            <el-form-item label="工作单号:">
              <el-select v-model="disWorkordersign.workorderid" clearable placeholder="请选择">
                <el-option
                  v-for="item in accWorksheetList"
                  :key="item.id"
                  :label="item.worksheetno"
                  :value="item.id">
                </el-option>
              </el-select>
            </el-form-item>

            <el-form-item label="工作单类型:">
              <el-radio v-model="disWorkordersign.workordertype" :label="1" border size="medium">返单</el-radio>
              <el-radio v-model="disWorkordersign.workordertype" :label="2" border size="medium">调单</el-radio>
              <el-radio v-model="disWorkordersign.workordertype" :label="3" border size="medium">正常数据</el-radio>
            </el-form-item>

            <el-form-item label="签收类型:">
              <el-radio v-model="disWorkordersign.signtype" :label="1" border size="medium">正常签收</el-radio>
              <el-radio v-model="disWorkordersign.signtype" :label="2" border size="medium">反向签收</el-radio>
            </el-form-item>

            <el-form-item label="签收人:">
              <el-input v-model="disWorkordersign.recipient"></el-input>
            </el-form-item>
            <el-form-item label="派送工号:">
              <el-input v-model="disWorkordersign.courierint"></el-input>
            </el-form-item>
            <el-form-item label="员工姓名:">
              <el-input v-model="disWorkordersign.couriername"></el-input>
            </el-form-item>
            <el-form-item label="是否作废:">
              <el-radio v-model="disWorkordersign.invalidatemark" :label="1" border size="medium">是</el-radio>
              <el-radio v-model="disWorkordersign.invalidatemark" :label="2" border size="medium">否</el-radio>
            </el-form-item>
            <el-form-item label="异常备注:">
              <el-input v-model="disWorkordersign.abnormalmark"></el-input>
            </el-form-item>
          </el-form>
          <span slot="footer" class="dialog-footer">
            <el-button @click="addDialogVisible = false">取 消</el-button>
            <el-button type="primary" @click="addDisWorkordersignTrue()">确 定</el-button>
          </span>
        </el-dialog>

      </div>

      <!-- 修改 -->
      <div>
        <el-dialog
          title="修改"
          :visible.sync="updateDialogVisible"
          width="50%"
          center>
              <el-form :model="disWorkordersign" label-width="80px">
                  <el-form-item label="工作单ID:">
                    <el-input v-model="disWorkordersign.workorderid" :disabled="true"></el-input>
                  </el-form-item>
                  <el-form-item label="工作单号:">
                    <el-input v-model="disWorkordersign.worksheetno" :disabled="true"></el-input>
                  </el-form-item>

                  <el-form-item label="工作单类型:">
                    <el-radio v-model="disWorkordersign.workordertype" :label="1" border size="medium">返单</el-radio>
                    <el-radio v-model="disWorkordersign.workordertype" :label="2" border size="medium">调单</el-radio>
                    <el-radio v-model="disWorkordersign.workordertype" :label="3" border size="medium">正常数据</el-radio>
                  </el-form-item>

                  <el-form-item label="签收类型:">
                    <el-radio v-model="disWorkordersign.signtype" :label="1" border size="medium">正常签收</el-radio>
                    <el-radio v-model="disWorkordersign.signtype" :label="2" border size="medium">反向签收</el-radio>
                  </el-form-item>

                  <el-form-item label="录入单位:">
                    <el-input v-model="disWorkordersign.sysDept.name" :disabled="true"></el-input>
                  </el-form-item>
                  <el-form-item label="录入编号:">
                    <el-input v-model="disWorkordersign.inputpersoncode" :disabled="true"></el-input>
                  </el-form-item>
                  <el-form-item label="录入姓名:">
                    <el-input v-model="disWorkordersign.sysUser.username" :disabled="true"></el-input>
                  </el-form-item>
                  <el-form-item label="签收人:">
                    <el-input v-model="disWorkordersign.recipient" :disabled="true"></el-input>
                  </el-form-item>
                  <el-form-item label="派送工号:">
                    <el-input v-model="disWorkordersign.courierint" :disabled="true"></el-input>
                  </el-form-item>
                  <el-form-item label="员工姓名:">
                    <el-input v-model="disWorkordersign.couriername" :disabled="true"></el-input>
                  </el-form-item>
                  <el-form-item label="是否作废:">
                    <el-radio v-model="disWorkordersign.invalidatemark" :label="1" border size="medium">是</el-radio>
                    <el-radio v-model="disWorkordersign.invalidatemark" :label="2" border size="medium">否</el-radio>
                  </el-form-item>
                  <el-form-item label="异常备注:">
                    <el-input v-model="disWorkordersign.abnormalmark"></el-input>
                  </el-form-item>
              </el-form>
          <span slot="footer" class="dialog-footer">
            <el-button @click="updateDialogVisible = false">取 消</el-button>
            <el-button type="primary" @click="updateDisWorkordersign()">确 定</el-button>
          </span>
        </el-dialog>

      </div>

      <!-- 详情 -->
      <div>
        <el-dialog
          title="详情"
          :visible.sync="particularsDialogVisible"
          width="75%"
          center>
          <el-tabs type="border-card">
          <el-tab-pane label="签收录入详情">
          <el-form :model="disWorkordersign" label-width="80px">
            <el-col :span="8">
                <el-form-item label="工作单ID">
                  <el-input v-model="disWorkordersign.workorderid" :disabled="true"></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="8">
                <el-form-item label="工作单号">
                  <el-input v-model="disWorkordersign.worksheetno" :disabled="true"></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="8">
                <el-form-item label="录入单位">
                  <el-input v-model="disWorkordersign.sysDept.name" :disabled="true"></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="8">
                <el-form-item label="录入编号">
                  <el-input v-model="disWorkordersign.inputpersoncode" :disabled="true"></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="8">
                <el-form-item label="录入姓名">
                  <el-input v-model="disWorkordersign.sysUser.username" :disabled="true"></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="8">
                <el-form-item label="签收人">
                  <el-input v-model="disWorkordersign.recipient" :disabled="true"></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="8">
                <el-form-item label="派送工号">
                  <el-input v-model="disWorkordersign.courierint" :disabled="true"></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="8">
                <el-form-item label="员工姓名">
                  <el-input v-model="disWorkordersign.couriername" :disabled="true"></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="8">
                <el-form-item label="签收时间">
                  <el-input v-model="disWorkordersign.signtime" :disabled="true"></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="8">
                <el-form-item label="录入时间">
                  <el-input v-model="disWorkordersign.inputtime" :disabled="true"></el-input>
                </el-form-item>
            </el-col>

            <el-col :span="8">
                <el-form-item label="是否作废">
                  <el-input v-model="disWorkordersign.invalidatemark" :disabled="true"></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="8">
                <el-form-item label="异常备注">
                  <el-input v-model="disWorkordersign.abnormalmark" :disabled="true"></el-input>
                </el-form-item>
            </el-col>
          </el-form>
          </el-tab-pane>
          </el-tabs>
        </el-dialog>

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
            prop="workorderid"
            label="工作单ID">
          </el-table-column>

          <el-table-column
            prop="worksheetno"
            label="工作单号"
            style="fit: true">
          </el-table-column>

          <el-table-column
            prop="workordertype"
            label="工作单类型"
            :formatter="formatterWorkOrderType"
            style="fit: true">
          </el-table-column>
          <el-table-column
            prop="signtype"
            label="签收类型"
            :formatter="formatterSignType">
          </el-table-column>
          <el-table-column
            prop="sysDept.name"
            label="录入单位">
          </el-table-column>
          <el-table-column
            prop="inputpersoncode"
            label="录入人编号">
          </el-table-column>
          <el-table-column
            prop="sysUser.username"
            label="录入人姓名">
          </el-table-column>
          <el-table-column
            prop="recipient"
            label="签收人">
          </el-table-column>
          <el-table-column
            prop="couriername"
            label="派送员工姓名">
          </el-table-column>
          <el-table-column
            label="操作"
            width="180">
            <template slot-scope="scope">
              <el-button type="warning" plain @click="update(scope.row)">修改</el-button>
              <el-button type="warning" plain @click="particulars(scope.row)">详情</el-button>
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
  import {disWorkOrderSignList,conditionDisWorkordersignList,updateDisWorkOrderSign,addDisWorkOrderSign} from '@/api/dis/workordersign'
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
        disWorkordersign: {id:'',workorderid:'',worksheetno:'',workordertype:'',signtype:'',courierint:'',couriername:'',recipient:'',signunit:'',signtime:'',signtime:'',
          abnormalmark:'',inputpersoncode:'',inputpersonid:'',inputid:'',inputtime:'',sysDept:{id:'',name:''},sysUser:{id:'',username:''}},
        particularsDialogVisible:false,
        updateDialogVisible:false,
        addDialogVisible:false,
        accWorksheetList:[]
      }
    },
    methods:{
      addDisWorkordersignTrue() {
        if(this.disWorkordersign.workorderid !=null && this.disWorkordersign.workorderid !="" && this.disWorkordersign.workordertype !=null && this.disWorkordersign.workordertype !="" &&
          this.disWorkordersign.signtype !=null && this.disWorkordersign.signtype !="" && this.disWorkordersign.recipient !=null && this.disWorkordersign.recipient !="" &&
          this.disWorkordersign.courierint !=null && this.disWorkordersign.courierint !="" && this.disWorkordersign.couriername !=null && this.disWorkordersign.couriername !="" &&
          this.disWorkordersign.invalidatemark !=null && this.disWorkordersign.invalidatemark !=""){
          console.debug(this.disWorkordersign)
          delete this.disWorkordersign.sysUser
          delete this.disWorkordersign.sysDept
         /* this.disWorkordersign.inputtime = new Date()
          this.disWorkordersign.signtime = new Date()*/
          addDisWorkOrderSign(this.disWorkordersign).then(response => {
            debugger
            this.addDialogVisible = false
              this.$message({
                  message: response.message,
                  type: 'success'
                });
              this.getList()
          })

        }else {
          this.$message({
            message: "请把资料填写完整",
            type: 'success'
          });
        }
      },
      addDisWorkordersign(){
        this.disWorkordersign = {id:'',workorderid:'',worksheetno:'',workordertype:'',signtype:'',courierint:'',couriername:'',recipient:'',signunit:'',signtime:'',signtime:'',
          abnormalmark:'',inputpersoncode:'',inputpersonid:'',inputid:'',inputtime:'',sysDept:{id:'',name:''},sysUser:{id:'',username:''}}
        accWorksheetList().then(response =>{
          this.accWorksheetList = response.data.list
        })

        this.addDialogVisible = true
      },
      updateDisWorkordersign(){
        delete this.disWorkordersign.sysUser
        delete this.disWorkordersign.sysDept
        updateDisWorkOrderSign(this.disWorkordersign).then(response =>{
          this.$message({
            message: response.message,
            type: 'success'
          });
          this.getList()
          this.updateDialogVisible = false
        })
        this.disWorkordersign = {id:'',workorderid:'',worksheetno:'',workordertype:'',signtype:'',courierint:'',couriername:'',recipient:'',signunit:'',signtime:'',signtime:'',
          abnormalmark:'',inputpersoncode:'',inputpersonid:'',inputid:'',inputtime:'',sysDept:{id:'',name:''},sysUser:{id:'',username:''}}
      },
      update(disWorkordersign){
        this.disWorkordersign = {id:disWorkordersign.id,workorderid:disWorkordersign.workorderid,worksheetno:disWorkordersign.worksheetno,workordertype:disWorkordersign.workordertype,signtype:disWorkordersign.signtype,courierint:disWorkordersign.courierint,couriername:disWorkordersign.couriername,recipient:disWorkordersign.recipient,signunit:disWorkordersign.signunit,signtime:disWorkordersign.signtime,invalidatemark:disWorkordersign.invalidatemark,
          abnormalmark:disWorkordersign.abnormalmark,inputpersoncode:disWorkordersign.inputpersoncode,inputpersonid:disWorkordersign.inputpersonid,inputid:disWorkordersign.inputid,inputtime:disWorkordersign.inputtime,sysDept:{id:disWorkordersign.sysDept.id,name:disWorkordersign.sysDept.name},sysUser:{id:disWorkordersign.sysUser.id,username:disWorkordersign.sysUser.username}}
        this.updateDialogVisible = true
      },
      particulars(disWorkordersign){
        console.debug(disWorkordersign)
          this.disWorkordersign = {id:disWorkordersign.id,workorderid:disWorkordersign.workorderid,worksheetno:disWorkordersign.worksheetno,workordertype:disWorkordersign.workordertype,signtype:disWorkordersign.signtype,courierint:disWorkordersign.courierint,couriername:disWorkordersign.couriername,recipient:disWorkordersign.recipient,signunit:disWorkordersign.signunit,signtime:disWorkordersign.signtime,invalidatemark:disWorkordersign.invalidatemark,
            abnormalmark:disWorkordersign.abnormalmark,inputpersoncode:disWorkordersign.inputpersoncode,inputpersonid:disWorkordersign.inputpersonid,inputid:disWorkordersign.inputid,inputtime:disWorkordersign.inputtime,sysDept:{id:disWorkordersign.sysDept.id,name:disWorkordersign.sysDept.name},sysUser:{id:disWorkordersign.sysUser.id,username:disWorkordersign.sysUser.username}}
          this.particularsDialogVisible = true
        console.debug(this.disWorkordersign)
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
      formatterWorkOrderType(row, column, cellValue, index){
        return row.workordertype == 1 ? '返单' : row.workordertype == 2 ? '调单' : row.workordertype == 3 ? '正确单据' : '未知';
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
