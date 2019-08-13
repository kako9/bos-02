<template>
  <!--返货申请 -->
    <div>
      <div>
        <el-col :span="9"><el-input  v-model="applicationno" placeholder="请输入申请单号" class="input-with-select"></el-input></el-col>
        <el-col :span="9"><el-input v-model="worksheetno" placeholder="请输入工作单号" class="input-with-select"></el-input></el-col>
        <el-col :span="2"><el-button  type="primary" plain @click="reset()">重置</el-button></el-col>
        <el-col :span="2"><el-button type="success" plain @click="chataigneau()">查询</el-button></el-col>
        <el-col :span="2"><el-button type="info" plain @click="add()">新增</el-button></el-col>
      </div>

      <!-- 新增-->
      <div>
        <el-dialog
          title="新增"
          :visible.sync="addDialogVisible"
          width="50%"
          center>

          <el-form :model="retReturnList" label-width="80px">
            <el-col :span="8">
              <el-form-item label="工作单号">
                <el-select v-model="retReturnList.worksheetno" clearable placeholder="请选择">
                  <el-option
                    v-for="item in accWorksheetList"
                    :key="item.id"
                    :label="item.worksheetno"
                    :value="item.worksheetno">
                  </el-option>
                </el-select>

              </el-form-item>
            </el-col>

            <el-col :span="8">
              <el-form-item label="破损丢失">
                <el-input v-model="retReturnList.aploss"></el-input>
              </el-form-item>
            </el-col>

            <el-col :span="24">
              <el-form-item label="申请备注">
                <el-input v-model="retReturnList.apremark" ></el-input>
              </el-form-item>
            </el-col>

            <el-col :span="24">
              <el-form-item label="处理意见">
                <el-input v-model=" retReturnList.handlingopinions" type="textarea" :rows="4"></el-input>
              </el-form-item>
            </el-col>
          </el-form>

          <span slot="footer" class="dialog-footer">
            <el-button @click="updateDialogVisible = false">取 消</el-button>
            <el-button type="primary" @click="addRetReturnList()">确 定</el-button>
          </span>
        </el-dialog>

      </div>
      <!-- 修改 -->
      <div>
        <el-dialog
          title="修改"
          :visible.sync="updateDialogVisible"
          width="60%"
          center>

          <el-form :model="retReturnList" label-width="80px">
            <el-col :span="8">
              <el-form-item label="申请单号">
                <el-input v-model="retReturnList.applicationno" :disabled="true"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="工作单号">
                <el-input v-model="retReturnList.worksheetno" :disabled="true"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="24">
              <el-form-item label="申请备注">
                <el-input v-model="retReturnList.apremark" ></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="破损丢失">
                <el-input v-model="retReturnList.aploss"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="进港时间">
                <el-input v-model="retReturnList.entrytime" :disabled="true"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="接收单位">
                <el-input v-model="retReturnList.receivingname" :disabled="true"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="作废标志">
                  <el-radio v-model="retReturnList.invalidatesign" :label="1">是</el-radio>
                  <el-radio v-model="retReturnList.invalidatesign" :label="0">否</el-radio>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="返货单位">
                <el-input v-model="retReturnList.returnname" :disabled="true"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="录入时间">
                <el-input v-model="retReturnList.recordingtime" :disabled="true"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="录入单位">
                <el-input v-model="retReturnList.entryname" :disabled="true"></el-input>
              </el-form-item>
            </el-col>

            <el-col :span="8">
              <el-form-item label="录入人">
                <el-input v-model="retReturnList.personname" :disabled="true"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="确认时间">
                <el-input v-model="retReturnList.confirmationtime" :disabled="true"></el-input>
              </el-form-item>
            </el-col>

            <el-col :span="8">
              <el-form-item label="确认单位">
                <el-input v-model="retReturnList.entryname" :disabled="true"></el-input>
              </el-form-item>
            </el-col>

            <el-col :span="8">
              <el-form-item label="确认人">
                <el-input v-model="retReturnList.personname" :disabled="true"></el-input>
              </el-form-item>
            </el-col>

              <el-col :span="24">
                <el-form-item label="返货处理状态">
                  <el-radio v-model="retReturnList.treatmentstate" :label="1">未确认</el-radio>
                  <el-radio v-model="retReturnList.treatmentstate" :label="2">同意返货</el-radio>
                  <el-radio v-model="retReturnList.treatmentstate" :label="3">拒绝</el-radio>
                  <el-radio v-model="retReturnList.treatmentstate" :label="4">同意转发</el-radio>
                </el-form-item>
              </el-col>

              <el-col :span="24">
                <el-form-item label="返货执行状态">
                  <el-radio v-model="retReturnList.apreturnstatus" :label="1">无</el-radio>
                  <el-radio v-model="retReturnList.apreturnstatus" :label="2">已转单</el-radio>
                  <el-radio v-model="retReturnList.apreturnstatus" :label="3">已返货</el-radio>
                </el-form-item>
              </el-col>

              <el-col :span="24">
                <el-form-item label="系统自动确认标志">
                  <el-radio v-model="retReturnList.identificationsign" :label="0">否</el-radio>
                  <el-radio v-model="retReturnList.identificationsign" :label="1">是</el-radio>
                </el-form-item>
              </el-col>


            <el-col :span="24">
              <el-form-item label="处理意见">
                <el-input v-model=" retReturnList.handlingopinions" type="textarea" :rows="4"></el-input>
              </el-form-item>
            </el-col>
          </el-form>

          <span slot="footer" class="dialog-footer">
            <el-button @click="updateDialogVisible = false">取 消</el-button>
            <el-button type="primary" @click="updateRetReturnList()">确 定</el-button>
          </span>
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
            prop="applicationno"
            label="申请单号"
            style="fit: true">
          </el-table-column>
          <el-table-column
            prop="worksheetno"
            label="工作单号"
            style="fit: true">
          </el-table-column>
          <el-table-column
            prop="returntype"
            label="返货类型"
            :formatter="formatterReturnType">
          </el-table-column>
          <el-table-column
            prop="aploss"
            label="破损丢失件数">
          </el-table-column>
          <el-table-column
            prop="entrytime"
            label="进港时间">
          </el-table-column>
          <el-table-column
            prop="receivingname"
            label="接收单位">
          </el-table-column>
          <el-table-column
            prop="invalidatesign"
            label="作废标志"
            :formatter="formatterInvalidatesign">
          </el-table-column>
          <el-table-column
            prop="returnname"
            label="返货单位">
          </el-table-column>
          <el-table-column
            prop="entryname"
            label="录入单位">
          </el-table-column>
          <el-table-column
            prop="personname"
            label="录入人">
          </el-table-column>
          <el-table-column
            label="操作"
            width="180">
            <template slot-scope="scope">
              <el-button type="info" plain @click="update(scope.row)">修改</el-button>
              <el-button type="warning" plain @click="cancellation(scope.row)">作废</el-button>
            </template>
          </el-table-column>
        </el-table>
      </div>
      <pagination v-show="total>0" :total="total" :page.sync="page" :limit.sync="limit" @pagination="getList" />
    </div>
</template>


<script>
  import {returnListList,getRetReturnListListTerm,cancellation,updateRetReturnList,addRetReturnList} from '@/api/ret/returnList'
  import list from "../example/list"
  import Pagination from '@/components/Pagination'
  import {accWorksheetList} from '@/api/dis/worksheet'

    export default {
      components: { Pagination },
      data() {
        return {
          list: [],
          total:0,
          page: 1,
          limit: 10,
          applicationno:'',
          worksheetno:'',
          retReturnList: {id:'',applicationno:'',worksheetno:'',returntype:'',apremark:'',aploss:'',entrytime:'',receivegunit:'',
            invalidatesign:'',returnunit:'',recordingtime:'',entryunit:'',personname:'', confirmationtime:'',confirmationunit:'',
            confirmationpersonname:'',treatmentstate:'',apreturnstatus:'',identificationsign:'',handlingopinions:'',denialtype:'',
            receivingname:'',returnname:'',entryname:'',confirmationname:''},
          updateDialogVisible:false,
          addDialogVisible:false,
          accWorksheetList:[]
        }
      },
      methods: {
        // 向后台提交数据 执行添加
        addRetReturnList(){
          var j = 0;
          this.list.forEach(retReturnList=>{
            if (retReturnList.worksheetno.trim()==this.retReturnList.worksheetno.trim()){
              j++;
            }
          })
          if (this.retReturnList.worksheetno !=null && this.retReturnList.worksheetno!= ''){
            if (j ===0){
              addRetReturnList(this.retReturnList).then(response =>{
                this.$message({
                  message: response.message,
                  type: 'success'
                })
                this.addDialogVisible = false
                this.getList()
              })
            }else{
              this.$message({
                type: 'info',
                message: '这个工作单已经申请过了，请选择其他工作单'
              });
            }

          }else {
            this.$message({
              type: 'info',
              message: '请选择工作单号'
            });
          }

        },
        // 打开添加对话框
        add(){
          this.retReturnList = {id:'',applicationno:'',worksheetno:'',returntype:'',apremark:'',aploss:'',entrytime:'',receivegunit:'',
            invalidatesign:'',returnunit:'',recordingtime:'',entryunit:'',personname:'', confirmationtime:'',confirmationunit:'',
            confirmationpersonname:'',treatmentstate:'',apreturnstatus:'',identificationsign:'',handlingopinions:'',denialtype:'',
            receivingname:'',returnname:'',entryname:'',confirmationname:''}

          accWorksheetList().then(response =>{
            this.accWorksheetList = response.data.list
          })
          this.addDialogVisible = true

        },
        // 向后台提交数据 执行修改
        updateRetReturnList(){
          this.$confirm('确定修改该单?', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning',
            center: true
          }).then(() => {
            updateRetReturnList(this.retReturnList).then(response =>{
              this.$message({
                message: response.message,
                type: 'success'
              })
              this.getList()
              this.updateDialogVisible = false
            })
          }).catch(() => {
            this.$message({
              type: 'info',
              message: '已取消删除'
            });
          });
        },
        // 打开修改对话框
        update(retReturnList){
          console.debug(retReturnList.id)
            this.retReturnList = {id:retReturnList.id,applicationno:retReturnList.applicationno,worksheetno:retReturnList.worksheetno,returntype:retReturnList.returntype,
              apremark:retReturnList.apremark,aploss:retReturnList.aploss, entrytime:retReturnList.entrytime,receivegunit:retReturnList.receivegunit,invalidatesign:retReturnList.invalidatesign,
              returnunit:retReturnList.returnunit,recordingtime:retReturnList.recordingtime,entryunit:retReturnList.entryunit,personname:retReturnList.personname,
              confirmationtime:retReturnList.confirmationtime,confirmationunit:retReturnList.confirmationunit,confirmationpersonname:retReturnList.confirmationpersonname,
              treatmentstate:retReturnList.treatmentstate,apreturnstatus:retReturnList.apreturnstatus,identificationsign:retReturnList.identificationsign,handlingopinions:retReturnList.handlingopinions,
              denialtype:retReturnList.denialtype,receivingname:retReturnList.receivingname, returnname:retReturnList.returnname,entryname:retReturnList.entryname,confirmationname:retReturnList.confirmationname}
            this.updateDialogVisible = true
        },
        // 作废
        cancellation(retReturnList){
          this.$confirm('确定作废该单?', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning',
            center: true
          }).then(() => {
              if(retReturnList.apreturnstatus ===1 && retReturnList.invalidatesign ===0){
                cancellation(retReturnList).then(response =>{
                  this.$message({
                    message: response.message,
                    type: 'success'
                  });
                  this.getList()
                })
              }else {
                this.$message({
                  type: 'info',
                  message: '该返货单已转发或已返货或已作废，不能作废'
                });
              }
          }).catch(() => {
            this.$message({
              type: 'info',
              message: '已取消删除'
            });
          });
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
        formatterReturnType(row, column, cellValue, index){
          return row.returntype == 1 ? '基础设置中对应的返货原因' : row.returntype == 2 ? '未封存' : '未知';
        },
        formatterInvalidatesign(row, column, cellValue, index){
          return row.invalidatesign == 0 ? '否' : row.invalidatesign == 1 ? '是' : '未知';
        }
      },
      created() {
        this.getList()
      }
    }


</script>

<style>

</style>
