<template>
  <div>
    <div>
      <el-input placeholder="请输入用户名" style="width: 600px;" v-model="ByName" class="input-with-select">
        <el-button slot="append" icon="el-icon-search" @click="getByName"></el-button>
      </el-input>
      <el-button type="primary" style="margin-left: 10px;"  slot="append" plain @click="addDialog">添加用户</el-button>
    </div>
  <div>
    <el-dialog
      title="添加用户"
      :visible.sync="dialogVisible"
      width="40%"
      :before-close="handleClose">
      <el-form ref="dataForm" :rules="rules" label-position="left" :model="user"  label-width="60px;" style="width: 400px; margin-left:50px;">
        <el-form-item label="用户名:" prop="username">
            <el-input v-model="user.username" placeholder="请输入用户名"></el-input>
        </el-form-item>
        <el-form-item label="密码:" prop="password">
          <el-input v-model="user.password" placeholder="请输入密码" show-password></el-input>
        </el-form-item>
        <el-form-item label="邮箱:" prop="email">
          <el-input v-model="user.email" placeholder="请输入邮箱"></el-input>
        </el-form-item>
        <el-form-item label="手机号：" prop="mobile">
          <el-input v-model="user.mobile" placeholder="请输入手机号"></el-input>
        </el-form-item>
        <el-form-item label="部门：" prop="deptId">
          <!--<el-cascader v-model="user.deptId" :options="deptList" :show-all-levels="false">
            <el-option-group
              v-for="group in deptList"
              :key="group.id"
              :label="group.name">
              <el-option-group
                v-for="children in group.children"
                :key="children.id"
                :label="children.name">
                <el-option
                  v-for="item in children.children"
                  :key="item.id"
                  :label="item.name"
                  :value="item.id">
                </el-option>
              </el-option-group>
            </el-option-group>
          </el-cascader>-->
          <el-select v-model="user.deptId" placeholder="请选择">
             <el-option-group
              v-for="group in deptList"
              :key="group.id"
              :label="group.name">
              <el-option-group
                v-for="children in group.children"
                :key="children.id"
                :label="children.name">
                <el-option
                  v-for="item in children.children"
                  :key="item.id"
                  :label="item.name"
                  :value="item.id">
                </el-option>
              </el-option-group>
            </el-option-group>
          </el-select>
        </el-form-item>
        <el-form-item label="个人介绍:" prop="introduction">
            <el-input type="textarea" :rows="3" v-model="user.introduction"></el-input>
          </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="addUser(user)">添加</el-button>
      </span>
    </el-dialog>

  </div>

    <div>
      <el-dialog
        title="修改用户"
        :visible.sync="updateDialog"
        width="40%"
        :before-close="updateHandle"
        :rules="rules">
        <el-form ref="dataForm" :rules="rules" label-position="left" :model="user"  label-width="90px;" style="width: 400px; margin-left:50px;">
          <el-form-item label="用户名:" prop="username">
            <el-input v-model="user.username" placeholder="请输入用户名"></el-input>
          </el-form-item>
          <el-form-item label="密码:" prop="password">
            <el-input v-model="user.password" placeholder="请输入密码" show-password></el-input>
          </el-form-item>
          <el-form-item label="邮箱:" prop="email">
            <el-input v-model="user.email" placeholder="请输入邮箱"></el-input>
          </el-form-item>
          <el-form-item label="手机号：" prop="mobile">
            <el-input min="10000000001" max="19999999999" type="number" v-model="user.mobile" placeholder="请输入手机号"></el-input>
          </el-form-item>
          <el-form-item label="部门：" prop="deptId">
            <!-- <el-cascader v-model="user.deptId" :options="deptList" :show-all-levels="false">

             </el-cascader>-->
            <el-select v-model="user.deptId" placeholder="请选择">
              <el-option-group
              v-for="group in deptList"
              :key="group.id"
              :label="group.name">
              <el-option-group
                v-for="children in group.children"
                :key="children.id"
                :label="children.name">
                <el-option
                  v-for="item in children.children"
                  :key="item.id"
                  :label="item.name"
                  :value="item.id">
                </el-option>
              </el-option-group>
            </el-option-group>
            </el-select>

          </el-form-item>

            <div style="margin-top: 20px">
            状态： &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<el-radio v-model="user.status" :label="1" border size="medium">正常</el-radio>
              <el-radio v-model="user.status" :label="0" border size="medium">禁用</el-radio><br>
            </div>
            <div style="margin-top: 20px">
            是否删除: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<el-radio v-model="user.delFlag" :label="0" border size="medium">正常</el-radio>
            <el-radio v-model="user.delFlag" :label="-1" border size="medium">已删除</el-radio><br>
            </div>
          <br>
          <el-form-item label="个人介绍:" prop="introduction">
            <el-input type="textarea" :rows="3" v-model="user.introduction"></el-input>
          </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
    <el-button @click="updateDialog = false">取 消</el-button>
    <el-button type="primary" @click="updateUser(user)">修改</el-button>
  </span>
      </el-dialog>

    </div>

    <div>
      <el-dialog
        title="提示"
        :visible.sync="allocationRoleDiaLog"
        width="30%"
        :before-close="allocationRoleHandleClose">

        <el-checkbox :indeterminate="isIndeterminate" v-model="checkAll" @change="handleCheckAllChange">全选</el-checkbox>
        <div style="margin: 15px 0;"></div>
        <el-checkbox-group v-model="roleList" @change="handleCheckedCitiesChange">
          <el-checkbox v-for="role in roles" :label="role.id" :key="role.id">{{role.name}}</el-checkbox>
        </el-checkbox-group>

        <span slot="footer" class="dialog-footer">
            <el-button @click="allocationRoleDiaLog = false">取 消</el-button>
            <el-button type="primary" @click="allocationRole()">确 定</el-button>
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
      prop="username"
      label="用户名"
      style="fit: true">
    </el-table-column>
    <el-table-column
      prop="email"
      label="邮箱"
      style="fit: true">
    </el-table-column>
    <el-table-column
      prop="mobile"
      label="手机号">
    </el-table-column>
    <el-table-column
      prop="status"
      label="状态"
    :formatter="formatterStatus">
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
      label="是否删除"
      :formatter="formatterDelFlag">
    </el-table-column>
    <el-table-column
      prop="introduction"
      label="个人介绍">
    </el-table-column>
    <el-table-column
      fixed="right"
      label="操作"
      width="180">
      <template slot-scope="scope">
        <el-button type="success" icon="el-icon-check" circle title="分配角色" @click="allocationRole(scope.row)"></el-button>
        <el-button type="primary" icon="el-icon-edit" circle @click="openUpdateDialog(scope.row)" title="修改用户信息"></el-button>
        <el-button type="danger" icon="el-icon-delete" circle @click="deleteUser(scope.row.id)" title="删除用户"></el-button>
      </template>
    </el-table-column>
  </el-table>
    </div>
      <pagination v-show="total>0" :total="total" :page.sync="page" :limit.sync="limit" @pagination="getList" />

  </div>
</template>

<script>
  import {userList,addUser,updateUser,deleteUser,getByName,roleList} from "@/api/sys/user"
  import {getGroupDept} from "@/api/sys/dept"
  import list from "../example/list"
  import Pagination from '@/components/Pagination'
  import {phoneNumber,emailValue,integerP,enOrnunText,validateLength} from '@/utils/myValiDate'
  import {getRoleList} from "@/api/sys/role"

  export default {
    components: { Pagination },
    methods: {
      allocationRole(user){
            this.allocationRoleDiaLog = true
            getRoleList().then(response =>{
                this.roles = response.data.roles
            })

            roleList(user.id).then(response =>{
              this.roleList = response.data.roleList
            })
      },
      getGroupDept(){
        getGroupDept().then(response=>{
          console.debug("---------"+response.data.deptList)
          this.deptList = response.data.deptList
        })
      },
      updateUser(user){
        updateUser(user).then(response =>{
          this.updateDialog = false
          this.getList()
          this.$message({
            message: '修改成功!',
            type: 'success'
          });
        })

        this.user = {username:'',password:'',email:'',mobile:'',introduction:'',status:'',delFlag:'',deptId:''}
      },
      addUser(user){
        debugger
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            var j = 0;
           this.list.forEach(users=>{
             console.debug("---")
             console.debug(users)
             console.debug(users.username)
             console.debug(user.username)
                if (users.username.trim()==user.username.trim()){
                  j++;
                }
           })

            if(j>=1){
              this.$notify({
                title: '警告',
                message: '用户名已被其他用户占用',
                type: 'warning'
              });
            }else{
              addUser(user).then(response => {
                this.getList()
                this.dialogVisible = false
                this.$message({
                  message: '添加成功!',
                  type: 'success'
                });
              })
              this.user = {username: '', password: '', email: '', mobile: '', introduction: '', status: '', delFlag: '',deptId:''}
            }
         }else{
            this.$notify({
              title: '警告',
              message: '请核对你输入的信息',
              type: 'warning'
            });
          }
        })
      },
      getByName(){
        console.debug("---"+this.page+"----"+this.limit)
          getByName(this.ByName,this.page,this.limit).then(response =>{
            this.list = response.data.list
            this.total = response.data.total
          })
      },
      addDialog(){
        this.getGroupDept()
        this.dialogVisible = true,
        this.user = {username:'',password:'',email:'',mobile:'',introduction:'',status:'',delFlag:'',deptId:''}
      },
      openUpdateDialog(user){
          this.getGroupDept()
          this.updateDialog = true,
          this.user = {id:user.id,username:user.username,password:user.password,email:user.email,mobile:user.mobile,introduction:user.introduction,status:user.status,delFlag:user.delFlag,deptId:user.deptId}
      },
      deleteUser(id){

        this.$confirm('此操作将删除该用户, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning',
          center: true
        }).then(() => {
          deleteUser(id).then(response =>{
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
      getList(){
        userList(this.page,this.limit).then(response =>{
          this.list = response.data.list
          console.debug(response.data.total)
          this.total = response.data.total
        })
      },
      handleClose(done) {
        this.$confirm('确认关闭？')
          .then(_ => {
            done();
          })
          .catch(_ => {});
      },
      allocationRoleHandleClose(done){
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
      formatterStatus(row, column, cellValue, index){
        return row.status == 1 ? '正常' : row.status == 0 ? '禁用' : '未知';
      },
      formatterDelFlag(row, column, cellValue, index){
        return row.delFlag == 0 ? '正常' : row.delFlag == -1 ? '已删除' : '未知';
      },
      handleCheckAllChange(val) {
        this.roleList = val ? this.roles : [];
        this.isIndeterminate = false;
      },
      handleCheckedCitiesChange(value) {
        let checkedCount = value.length;
        this.checkAll = checkedCount === this.roles.length;
        this.isIndeterminate = checkedCount > 0 && checkedCount < this.roles.length;
      }
    },
    data() {
      return {
        list:[{id:"1",username:"张三",email:"133",mobile:"1515",status:"0",create_by:"admin",create_time:"2019-07-02", last_update_by:"admin",last_update_time:"2019-02-01",del_flag:"1",introduction:"..."}],
        dialogVisible: false,
        updateDialog:false,
        allocationRoleDiaLog:false,
        user:{username:'',password:'',email:'',mobile:'',introduction:'',status:'',delFlag:'',deptId:''},
        ByName :'',
        total:0,
        page: 1,
        limit: 10,
        rules: {
          username: [{ required: true, message: '用户名不能为空', trigger: 'blur' }],
          password: [{ required: true, message: '密码不能为空', trigger: 'blur' },
            {validator:enOrnunText,trigger: 'blur'}],
          email: [{ required: true, message: 'email不能为空', trigger: 'blur' },
            {validator:emailValue, trigger: 'blur'}],
          mobile: [{ required: true, message: '电话号码不能为空', trigger: 'blur' },
            {validator:phoneNumber,integerP,trigger: 'blur'}]
        },
       deptList:[],
        checkAll: false,
        roles:[],
        roleList: [],
        isIndeterminate: true
      }
    },
    created() {
      this.getList()
    }
  }

</script>
