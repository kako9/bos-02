<template>
  <el-form :model="loginForm" :rules="fieldRules" ref="loginForm" label-position="left" label-width="0px" class="demo-ruleForm login-container">
    <h3 class="title">系统登录</h3>
    <el-form-item prop="account">
      <el-input type="text" v-model="loginForm.name" auto-complete="off" placeholder="账号" ></el-input>
    </el-form-item>
    <el-form-item prop="password">
      <el-input type="password" v-model="loginForm.password" auto-complete="on" placeholder="密码"></el-input>
    </el-form-item>
    <el-form-item style="width:100%;">
      <el-button type="primary" style="width:48%;" @click="reset">重 置</el-button>
      <el-button type="primary" style="width:48%;" @click.native.prevent="login" :loading="logining">登 录</el-button>
    </el-form-item>
  </el-form>
</template>
<script>

  import Cookies from "js-cookie";
  export default {
    name: 'Login',
    data() {
      const validateUsername = (rule, value, callback) => {
        if (!validUsername(value)) {
          callback(new Error('请输入账号'))
        } else {
          callback()
        }
      }
      const validatePassword = (rule, value, callback) => {
        if (value.length < 5) {
          callback(new Error('密码的长度必须在6-12位之间'))
        } else {
          callback()
        }
      }
      return {
        logining: false,
        // 表单上绑定的对象
        loginForm: {
          name: 'admin',
          password: 'admin'
        },
        // 属性校验
        fieldRules: {
          name: [
            { required: true, trigger: 'blur',validator: validateUsername},
          ],
          password: [
            { required: true, trigger: 'blur',validator: validatePassword },
          ]
        }
      };
    },
    methods: {
      // 登录按钮操作
      login() {
        // 构建userInfo对象，值为表单中的值
        let userInfo = {name:this.loginForm.name, password:this.loginForm.password}
        console.debug(userInfo);
        // ajax操作
        this.$api.login(userInfo).then((res) => {
          console.debug(res);
          console.debug(res.token)
          // 登录成功，后台返回的token写在cookies里了
          Cookies.set('token', res.token) // 放置token到Cookie
          // 本地session操作，将后台返回的loginUser保存了
          sessionStorage.setItem('user', res.loginUser) // 保存用户到本地会话
          // 登录成功，跳转到主页
          this.$router.push('/')
        }).catch(function(res) {
          alert(res);
        });
      },
      // 重置
      reset() {
        alert()
        this.$refs.loginForm.resetFields();
      }
    }
  }
</script>
<style lang="scss" scoped>
  .login-container {
    -webkit-border-radius: 5px;
    border-radius: 5px;
    -moz-border-radius: 5px;
    background-clip: padding-box;
    margin: 100px auto;
    width: 350px;
    padding: 35px 35px 15px 35px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
    .title {
      margin: 0px auto 30px auto;
      text-align: center;
      color: #505458;
    }
    .remember {
      margin: 0px 0px 35px 0px;
    }
  }
</style>
