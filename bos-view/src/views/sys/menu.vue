<template>
  <div>
  <div>
  <!--菜单的修改-->
  <el-dialog
    title="修改菜单"
    :visible.sync="dialogFormVisible3" >
    <el-form v-model="menu"   style="width: 80%">
      <el-form-item label="菜单名称" >
        <el-input v-model="menu.name" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="菜单权限名称" >
        <el-input v-model="menu.url" autocomplete="off"></el-input>
      </el-form-item>

      <div style="margin-top: 20px">
        是否删除: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<el-radio v-model="menu.delFlag" :label="0" border size="medium">正常</el-radio>
        <el-radio v-model="menu.delFlag" :label="-1" border size="medium">删除</el-radio><br>
      </div>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-tooltip class="item" effect="dark" content="返回到用户页面" placement="right">
        <el-button @click="dialogFormVisible3 = false">取 消</el-button>
      </el-tooltip>
      <el-tooltip class="item" effect="dark" content="请检查填写的信息是否正确" placement="right">
        <el-button type="primary" @click="updateMenuFather()">确 定</el-button>
      </el-tooltip>
    </div>
  </el-dialog>
</div>

  <div>
  <!--菜单的添加父级-->
  <el-dialog
    title="添加菜单"
    :visible.sync="dialogFormVisible2" >
    <el-form v-model="menu"   style="width: 80%">
      <el-form-item label="菜单名称" >
        <el-input v-model="menu.name" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="菜单权限名称" >
        <el-input v-model="menu.url" autocomplete="off"></el-input>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-tooltip class="item" effect="dark" content="返回到用户页面" placement="right">
        <el-button @click="dialogFormVisible2 = false">取 消</el-button>
      </el-tooltip>
      <el-tooltip class="item" effect="dark" content="请检查填写的信息是否正确" placement="right">
        <el-button type="primary" @click="AddMenuFather()">确 定</el-button>
      </el-tooltip>
    </div>
  </el-dialog>
</div>

  <div>
  <!--菜单的添加-->
  <el-dialog
    title="添加菜单"
    :visible.sync="dialogFormVisible" >
    <el-form v-model="menu"   style="width: 80%">
      <el-form-item label="菜单名称" >
        <el-input v-model="menu.name" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="菜单权限名称" >
        <el-input v-model="menu.url" autocomplete="off"></el-input>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-tooltip class="item" effect="dark" content="返回到用户页面" placement="right">
        <el-button @click="dialogFormVisible2 = false">取 消</el-button>
      </el-tooltip>
      <el-tooltip class="item" effect="dark" content="请检查填写的信息是否正确" placement="right">
        <el-button type="primary" @click="AddMenu()">确 定</el-button>
      </el-tooltip>
    </div>
  </el-dialog>
</div>

  <div class="custom-tree-container">
  <div class="block">
    <el-button type="primary" @click="dialogFormVisible2 = true" plain>添加最高级菜单</el-button>
    <el-tree
      :data="list"
      node-key="id"
      default-expand-all
      :expand-on-click-node="false">
      <span class="custom-tree-node" slot-scope="{ node, data }">
        <span>{{ node.label }}</span>  &nbsp;
        <span
          :formatter="formatterDelFlag">
          {{ node.delFlag }}</span>
        <span>
          <el-button
            type="text"
            size="mini"
            @click="() => append(data)">
            添加
          </el-button>
          <el-button
            type="text"
            size="mini"
            @click="() => update(data)">
            修改
          </el-button>
          <el-button
            type="text"
            size="mini"
            @click="() => remove(node, data)">
            删除
          </el-button>
        </span>
      </span>
    </el-tree>
  </div>
</div>
  </div>
</template>
<script>
  import {menuList,addMenu,updateMenu,deleteMenu} from '@/api/sys/menu'

  let id = 1000;
  export default {
    data() {
      return {
        list: [],
        menu:{id:'',name:'',url:'',delFlag:'',parentId:''},
        dialogFormVisible : false,
        dialogFormVisible2 : false,
        dialogFormVisible3: false
      }
    },

    created(){
      this.getmenulist();
    },

    methods: {
      getmenulist(){
        menuList().then(response => {
          this.list=response.data.list
        })
      },
      update(menu){
        this.menu = {id:menu.id,name:menu.label,url:menu.url,delFlag:menu.delFlag}
        this.dialogFormVisible3=true
      },
      // 修改
      updateMenuFather(){
        updateMenu(this.menu).then(response => {
          this.$message({
            title: '提示',
            message: "修改成功"
          });
          this.getmenulist()
          this.dialogFormVisible3 = false
          this.menu  = {id:'',name:'',url:'',delFlag:'',parentId:''}
        })
       },
      append(menu) {
        this.menu  = {id:'',name:'',url:'',delFlag:'',parentId:''}
        this.menu.parentId=menu.id
        this.dialogFormVisible = true
      },
      AddMenuFather(){
        this.menu  = {id:'',name:'',url:'',delFlag:'',parentId:''}
        this.menu.parentId=0
        addMenu(this.menu).then(response => {
          this.getmenulist()
          this.dialogFormVisible2 = false
            this.$message({
              title: '提示',
              message: "添加成功 "
            });
          this.menu ={id:'',name:'',url:'',delFlag:'',parentId:''}
       })
      },
      AddMenu()
        {
          this.$confirm('是否确认添加子集菜单到你所点击的菜单下?', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
          }).then(() => {
            addMenu(this.menu).then(response => {
              this.getmenulist()
              this.dialogFormVisible=false
              this.$message({
                title: '提示',
                message: "添加成功"
              });

              this.menu ={id:'',name:'',url:'',delFlag:'',parentId:''}
            })
          })
      },
      formatterDelFlag(row, column, cellValue, index){
        return row.delFlag == 0 ? '正常' : row.delFlag == -1 ? '已删除' : '未知';
      },
      remove(node, data) {
        console.debug(node)
        console.debug(data)
        this.$confirm('提示：你删除的该菜单?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          deleteMenu(data.id).then(response => {
            this.getmenulist()
            this.$message({
              title: '提示',
              message: "删除成功"
            });
          })
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });
        });


      },

    }
  };
</script>

<style>


  .el-tree-node:focus > .el-tree-node__label {
    background-color: transparent !important;
  }

  .custom-tree-node {
    flex: 1;
    display: flex;
    align-items: center;
    justify-content: space-between;
    font-size: 18px;
    color: #F6416C;
    padding-right: 10px;
  }
</style>
