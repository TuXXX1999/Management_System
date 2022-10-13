<template>
  <div id='building'>
      <el-form :model="ruleForm" :rules="rules" ref="ruleForm" class="login-container" label-position="left"
               label-width="0px" v-loading="loading">
        <h2 class="login_title">液化气站客户管理系统登录</h2>
        <el-form-item prop="username">
          <el-input type="text" v-model="ruleForm.username" auto-complete="off" placeholder="账号"></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input type="password" v-model="ruleForm.password" auto-complete="off" placeholder="密码"></el-input>
        </el-form-item>
        <el-form-item style="width: 100%">
          <el-button type="primary" @click="submitForm('ruleForm')">登录</el-button>
          <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
      </el-form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      ruleForm: {
        username: '',
        password: '',
        rolename: ''
      },
      rules: {
        username: [
          {required: true, message: '请输入帐号', trigger: 'blur'},
          {message: '长度在 3 到 5 个字符', trigger: 'blur'}
        ],
        password: [
          {required: true, message: '请输入密码', trigger: 'change'},
          {message: '长度 3 位', trigger: 'blur'}
        ]
      },
      loading: false
    }
  },
  methods: {

    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    submitForm(formName) {
      // console.log(1112321)
      this.$refs[formName].validate((valid) => {
        // console.log(1)
        if (valid) {
          // console.log(2)
          var _this = this
          this.loading = true
          this.$axios.get('http://localhost:8181/user/login/' + this.ruleForm.username + "/" + this.ruleForm.password).then(function (resp) {
            if (resp.data !== 'error') {
              // console.log(666)
              _this.loading = false
              _this.ruleForm.rolename = resp.data;
              localStorage.setItem('access-user', JSON.stringify(_this.ruleForm.username));
              localStorage.setItem('role', JSON.stringify(_this.ruleForm.rolename));
              // _this.$router.push({ path: '/home' })
              _this.$router.replace({path: '/home'})
              // console.log(666)
            } else {
              _this.loading = false
              _this.$alert('登录失败!', '失败!');
              _this.resetForm(formName);
            }
          })
        } else {
          return false;
        }
      });

    }
  },
  created() {
    let that = this;
    document.onkeydown = function (e) {
      e = window.event || e;
      // console.log(e.code)
      if ((e.code == 'Enter' || e.code == 'enter' || e.code == 'NumpadEnter')) {//验证在登录界面和按得键是回车键enter
        that.submitForm('ruleForm');//登录函数
      }
    }
  }
}
</script>
<style>
*{
  margin:0;
  padding:0;
  border:0
}
#building{
  background:url("/src/images/Login.png");
  width:100%;
  height:100%;
  position:fixed;
  background-size:100% 100%;
}
.login-container {
  border-radius: 15px;
  background-clip: padding-box;
  margin: 180px auto;
  width: 350px;
  padding: 35px 35px 15px 35px;
  background: #fff;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 25px #cac6c6;
}

.login_title {
  margin: 0px auto 40px auto;
  text-align: center;
  color: #505458;
}


</style>
