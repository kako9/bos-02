<template>
  <div>
    <div>
      <div>
        <el-input placeholder="请输人部门名称" style="width: 600px;" v-model="ByName" class="input-with-select">
          <el-button slot="append" icon="el-icon-search" @click="getByName"></el-button>
        </el-input>
        <el-button type="primary" style="margin-left: 10px;"  slot="append" plain @click="addDialog">添加角色</el-button>
      </div>

      <div>
        <el-dialog
          title="添加部门"
          :visible.sync="dialogVisible"
          width="40%"
          :before-close="handleClose">
          <el-form ref="dataForm" label-position="left" :model="dept"  label-width="60px;" style="width: 400px; margin-left:50px;">
            <el-form-item label="部门名称:" prop="name">
              <el-input v-model="dept.name" placeholder="请输入部门名称"></el-input>
            </el-form-item>

            <el-form-item label="选择上级部门:" prop="parentId"><br/>
              <el-select v-show="first" @clear="zero" v-model="dept.parentId" clearable placeholder="请选择" @change="getSecondLevel(dept.parentId)">
                  <el-option
                    v-for="item in deptList"
                    :key="item.id"
                    :label="item.name"
                    :value="item.id">
                  </el-option>
                </el-select>

              <el-select v-show="second" @clear="zero" v-model="dept.parentId" clearable placeholder="请选择" @change="getThreeLevel(dept.parentId)">
                <el-option
                  v-for="item in items"
                  :key="item.id"
                  :label="item.name"
                  :value="item.id">
                </el-option>
              </el-select>

              <el-select v-show="thirdly" @clear="zero" v-model="dept.parentId" clearable placeholder="请选择">
                <el-option
                  v-for="item in children"
                  :key="item.id"
                  :label="item.name"
                  :value="item.id">
                </el-option>
              </el-select>
            </el-form-item>
          </el-form>
          <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="addDept(dept)">添加</el-button>
      </span>
        </el-dialog>
      </div>

      <div>
        <el-dialog
          title="修改部门"
          :visible.sync="updateDialog"
          width="40%"
          :before-close="updateHandle">
          <el-form ref="dataForm" label-position="left" :model="dept"  label-width="90px;" style="width: 400px; margin-left:50px;">
            <el-form-item label="部门名称:" prop="name">
              <el-input v-model="dept.name" placeholder="请输入部门名称"></el-input>
            </el-form-item>

            <el-form-item label="选择上级部门:" prop="parentId"><br/>
              <el-select v-show="first" @clear="zero" v-model="dept.parentId" clearable placeholder="请选择" @change="getSecondLevel(dept.parentId)">
                <el-option
                  v-for="item in deptList"
                  :key="item.id"
                  :label="item.name"
                  :value="item.id">
                </el-option>
              </el-select>

              <el-select v-show="second" @clear="zero" v-model="dept.parentId" clearable placeholder="请选择" @change="getThreeLevel(dept.parentId)">
                <el-option
                  v-for="item in items"
                  :key="item.id"
                  :label="item.name"
                  :value="item.id">
                </el-option>
              </el-select>

              <el-select v-show="thirdly" @clear="zero" v-model="dept.parentId" clearable placeholder="请选择">
                <el-option
                  v-for="item in children"
                  :key="item.id"
                  :label="item.name"
                  :value="item.id">
                </el-option>
              </el-select>
            </el-form-item>

            <div style="margin-top: 20px">
                是否删除: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<el-radio v-model="dept.delFlag" :label="0" border size="medium">正常</el-radio>
                <el-radio v-model="dept.delFlag" :label="-1" border size="medium">删除</el-radio><br>
            </div>
          </el-form>
          <span slot="footer" class="dialog-footer">
        <el-button @click="updateDialog = false">取 消</el-button>
        <el-button type="primary" @click="updateDept(dept)">修改</el-button>
      </span>
        </el-dialog>
      </div>
    </div>
  <div>
    <el-table
      :data="list"
      border
      style="width: 100%">
      <el-table-column
        fixed
        prop="name"
        label="部门名称"
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
          <el-button type="danger" icon="el-icon-delete" circle @click="deleteDept(scope.row)"></el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
    <pagination v-show="total>0" :total="total" :page.sync="page" :limit.sync="limit" @pagination="getList" />
  </div>
</template>

<script>
  import {getGroupDept,updateDept,addDept,deleteDept,getList,getByName,getByParentId} from "@/api/sys/dept"
  import list from "../example/list"
  import Pagination from '@/components/Pagination'
  export default {
    components: {Pagination},
    methods:{
      zero(){
        this.first = true
        this.second = false
        this.thirdly = false
      },
      getByName(){
          getByName(this.ByName,this.page,this.limit).then(response =>{
            console.debug(response.data.list)
            this.list = response.data.list
            this.total = response.data.total
          })
      },
      getSecondLevel(id){
        if (id!=null&&id!=""){
          getByParentId(id).then(response=>{
            this.items = response.data.children
            this.first = false
            this.second = true
            this.thirdly = false
          })
        }

      },
      getThreeLevel(id){
        if (id!=null&&id!=""){
          getByParentId(id).then(response=>{
            this.children = response.data.children
            this.first = false
            this.second = false
            this.thirdly = true
          })
        }
      },
      getGroupDept(){
        getGroupDept().then(response =>{
            this.deptList = response.data.deptList
        })
      },
      deleteDept(dept){
        this.$confirm('此操作将删除该角色, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning',
          center: true
        }).then(() => {
          console.debug(dept)
         // if (dept.children.size()===0){
            deleteDept(dept.id).then(response =>{
              this.getList()
              this.$message({
                type: 'success',
                message: '删除成功!'
              });
            })
         // }else {
         //     this.$message.error('删除失败，该部门下有其他部门!');
         //  }

        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });
        });
      },
      updateDept(dept){
        updateDept(dept).then(response =>{
          this.getList()
          this.updateDialog = false
          this.$message({
            message: '修改成功!',
            type: 'success'
          });

        })
        this.first = false
        this.second = false
        this.thirdly = false
        this.dept = {name:'',delFlag:'',parentId:''}
      },
      addDept(dept){
        addDept(dept).then(response => {
          this.getList()
          this.dialogVisible = false
          this.$message({
            message: '添加成功!',
            type: 'success'
          });

        })

        this.first = false
        this.second = false
        this.thirdly = false
        this.dept= {name:'',delFlag:'',parentId:''}
      },
      addDialog(){
            this.dialogVisible = true,
            this.dept = {name:'',parentId:''},
            this.getGroupDept(),
              this.first = true
        this.second = false
        this.thirdly = false
      },
      openUpdateDialog(dept){
          this.updateDialog = true,
          this.dept = {id:dept.id,name:dept.name,delFlag:dept.delFlag,parentId:dept.parentId}
          this.getGroupDept(),
          this.first = true
          this.second = false
          this.thirdly = false
      },
      getList(){
        getList(this.page,this.limit).then(response =>{
          console.debug(response.data.list)
          this.list = response.data.list
          this.total = response.data.total
        })
      },
      formatterDelFlag(row, column, cellValue, index){
        return row.delFlag == 0 ? '正常' : row.delFlag == -1 ? '已删除' : '未知';
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
    },
    data() {
      return {
        list: [{id:"1",name:"admin",createBy:"11",createTime:"2019-01-05",lastUpdateBy:"1515",lastUpdateTime:"2019-07-02",delFlag:"0"}],
        dialogVisible: false,
        updateDialog: false,
        dept:{name:'',delFlag:'',parentId:''},
        deptList: [],
        items: [],
        children: [],
        ByName: '',
        total: 0,
        page: 1,
        limit: 10,
        first:false,
        second:false,
        thirdly:false
      }
    },
    created() {
      this.getList()
    }
  }
</script>
