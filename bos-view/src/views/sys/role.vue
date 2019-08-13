<template>
  <div>
    <div>
      <el-input placeholder="请输入角色名" style="width: 600px;" v-model="ByName" class="input-with-select">
        <el-button slot="append" icon="el-icon-search" @click="getByName"></el-button>
      </el-input>
      <el-button type="primary" style="margin-left: 10px;"  slot="append" plain @click="addDialog">添加角色</el-button>
    </div>
  <div>
  <el-dialog
    title="添加角色"
    :visible.sync="dialogVisible"
    width="40%"
    :before-close="handleClose">
    <el-form ref="dataForm" label-position="left" :model="role"  label-width="60px;" style="width: 400px; margin-left:50px;">
      <el-form-item label="角色名:" prop="name">
        <el-input v-model="role.name" placeholder="请输入角色名"></el-input>
      </el-form-item>
      <el-form-item label="备注:" prop="remark">
        <el-input v-model="role.remark" placeholder="请输入备注"></el-input>
      </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="addRole(role)">添加</el-button>
      </span>
  </el-dialog>

  </div>

  <div>
    <el-dialog
      title="修改角色"
      :visible.sync="updateDialog"
      width="40%"
      :before-close="updateHandle">
      <el-form ref="dataForm" label-position="left" :model="role"  label-width="90px;" style="width: 400px; margin-left:50px;">
        <el-form-item label="角色名:" prop="name">
          <el-input v-model="role.name" placeholder="请输入角色名"></el-input>
        </el-form-item>
        <el-form-item label="备注:" prop="remark">
          <el-input v-model="role.remark" placeholder="请输入备注"></el-input>
        </el-form-item>

        <div style="margin-top: 20px">
          是否删除: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<el-radio v-model="role.delFlag" :label="0" border size="medium">正常</el-radio>
          <el-radio v-model="role.delFlag" :label="-1" border size="medium">删除</el-radio><br>
        </div>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="updateDialog = false">取 消</el-button>
        <el-button type="primary" @click="updateRole(role)">修改</el-button>
      </span>
    </el-dialog>

  </div>

  <div>
    <el-table
      :data="list"
      border
      style="width: 100%">
      <el-table-column
        fixed
        prop="name"
        label="角色名"
        style="fit: true">
      </el-table-column>
      <el-table-column
        prop="remark"
        label="备注"
        style="fit: true">
      </el-table-column>
      <el-table-column
        prop="createBy"
        label="创建人">
      </el-table-column>
      <el-table-column
        prop="createTime"
        label="创建时间">
      </el-table-column>
      <el-table-column
        prop="lastUpdateBy"
        label="更新人">
      </el-table-column>
      <el-table-column
        prop="lastUpdateTime"
        label="更新时间">
      </el-table-column>
      <el-table-column
        prop="delFlag"
        label="状态"
        :formatter="formatterDelFlag">
      </el-table-column>
      <el-table-column
        fixed="right"
        label="操作">
        <template slot-scope="scope">
          <el-button type="primary" icon="el-icon-edit" circle @click="openUpdateDialog(scope.row)"></el-button>
          <el-button type="danger" icon="el-icon-delete" circle @click="deleteRole(scope.row.id)"></el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
   <pagination v-show="total>0" :total="total" :page.sync="page" :limit.sync="limit" @pagination="getList" />
  </div>
</template>

<script>
  import {roleList,addRole,updateRole,deleteRole,getByName} from "@/api/sys/role"
  import list from "../example/list"
  import Pagination from '@/components/Pagination'

  export default {
    components: {Pagination},
    methods:{
      getByName(){
        console.debug("---"+this.page+"----"+this.limit)
        getByName(this.ByName,this.page,this.limit).then(response =>{
          this.list = response.data.list
          this.total = response.data.total
        })
      },
      updateRole(role){
        updateRole(role).then(response =>{
          this.getList()
          this.updateDialog = false
          this.$message({
            message: '修改成功!',
            type: 'success'
          });
        })

        this.role = {name:'',remark:'',delFlag:''}
      },
      addRole(role){
            addRole(role).then(response => {
              this.getList()
              this.dialogVisible = false
              this.$message({
                message: '添加成功!',
                type: 'success'
              });
            })

            this.role = {name: '', remark: ''}
      },
      addDialog(){
        this.dialogVisible = true,
          this.role = {name:'',remark:''}
      },
      openUpdateDialog(role){
        this.updateDialog = true,
          this.role = {id:role.id,name:role.name,remark:role.remark,delFlag:role.delFlag}
      },
      getList(){
        roleList(this.page,this.limit).then(response =>{
          this.list = response.data.list
          console.debug(response.data.total)
          this.total = response.data.total
        })
      },
      deleteRole(id){

        this.$confirm('此操作将删除该角色, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning',
          center: true
        }).then(() => {
          deleteRole(id).then(response =>{
            this.getList()
            this.$message({
              type: 'success',
              message: '删除成功!'
            });
          })

        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });
        });

      },
      handleClose(done) {
        this.$confirm('确认关闭？')
          .then(_ => {
            done();
          })
          .catch(_ => {});
      },
      updateHandle(done) {
        this.$confirm('确认关闭？')
          .then(_ => {
            done();
          })
          .catch(_ => {});
      },
      formatterDelFlag(row, column, cellValue, index){
        return row.delFlag == 0 ? '正常' : row.delFlag == -1 ? '已删除' : '未知';
      }
    },
    data() {
      return {
        list:[{id:"1",name:"admin",remark:"11",createBy:"1515",createTime:"2019-01-05",lastUpdateBy:"1515",lastUpdateTime:"2019-07-02",delFlag:"0"}],
        dialogVisible: false,
        updateDialog:false,
        role:{name:'',remark:'',delFlag:''},
        ByName :'',
        total:0,
        page: 1,
        limit: 10,
      }
    },
    created() {
      this.getList()
    }

  }
</script>
