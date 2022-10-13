<template>
  <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="form-container">
    <el-form-item label="编号" prop="user_Id">
      <el-input v-model="ruleForm.user_Id" readonly></el-input>
    </el-form-item>
    <el-form-item label="用户名" prop="user_Name">
      <el-input v-model="ruleForm.user_Name"></el-input>
    </el-form-item>
    <el-form-item label="密码" prop="user_Name">
      <el-input v-model="ruleForm.user_Pass"></el-input>
    </el-form-item>
    <el-form-item label="电话" prop="user_Phone">
      <el-input v-model="ruleForm.user_Phone"></el-input>
    </el-form-item>
    <el-form-item label="权限类型">
      <el-select v-model="ruleForm.user_Type" placeholder="权限类型">
        <el-option label="管理员" value="1"></el-option>
        <el-option label="普通员工" value="2"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="家庭住址" prop="user_Address">
      <el-input v-model="ruleForm.user_Address"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="submitForm('ruleForm')">修改</el-button>
      <el-button @click="cancel">取消</el-button>
    </el-form-item>
  </el-form>

</template>

<script>
export default {
  data() {
    return {
      userData: [
        {
          value: ''
        },
        {
          value: '临时客户'
        }
      ],
      ruleForm: {
        user_Id: 1,
        user_Name: '华为',
        user_Pass:'123',
        user_Phone: '',
        user_Role:'',
        user_Type: '华为科技有限公司',
        user_Cycle: "1",
        user_Address: ""
      },
      rules: {
        user_Id: [
          {required: true, message: '请输入编号', trigger: 'blur'}
        ],
        user_Name: [
          {required: true, message: '请输入姓名', trigger: 'blur'}
        ],
        user_Phone: [
          {required: true, message: '请输入电话', trigger: 'blur'}
        ],
        user_Type: [
          {required: true, message: '请选择客户类型', trigger: 'change'}
        ],
        cycle: [
          {required: true, message: '请输入供气周期', trigger: 'blur'}
        ]
      }
    };
  },
  methods: {
    selectById(){
      const _this = this
      this.$axios.get('http://localhost:8181/user/updateUser/'+this.ruleForm.Info_Id).then(function (resp) {
        console.log(resp.data)
        _this.ruleForm = resp.data
        if(_this.ruleForm.user_Role=="1"){
          _this.ruleForm.user_Type="管理员"
        }else if(_this.ruleForm.user_Role=="2"){
          _this.ruleForm.user_Type="普通员工"
        }
      })
    },
    submitForm(formName) {
      console.log(this.ruleForm)
      this.$refs[formName].validate((valid) => {
        if (valid) {
          const _this = this
          this.$axios.post('http://localhost:8181/user/updateUser', this.ruleForm).then(function (resp) {
            if (resp.data == 1) {
              _this.$alert('客户编号: ' + _this.ruleForm.user_Name + ' 修改成功！', '', {
                confirmButtonText: '确定',
                callback: action => {
                  _this.$router.push("/roleByUser")
                }
              });
            }
          })
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    cancel(){
      this.$router.replace("/roleByUser")
    }
  },
  created(){
    // console.log(this.$route.query.id)
    this.ruleForm.Info_Id=this.$route.query.id;
    this.selectById();
  }
}
</script>

<style>
.form-container {
  border-radius: 15px;
  background-clip: padding-box;
  margin: 0px auto;
  width: 600px;
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

.login_remember {
  margin: 0px 0px 35px 0px;
  text-align: left;
}
</style>
