<template>
  <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="form-container">
    <el-form-item label="编号" prop="overDate_Id">
      <el-input v-model="ruleForm.overDate_Id" readonly></el-input>
    </el-form-item>
    <el-form-item label="姓名" prop="overDate_Name">
      <el-input v-model="ruleForm.overDate_Name" readonly></el-input>
    </el-form-item>
    <el-form-item label="电话" prop="Info_Phone">
      <el-input v-model="ruleForm.overDate_Phone" readonly></el-input>
    </el-form-item>
    <el-form-item label="客户类型" prop="overDate_Type">
      <el-input v-model="ruleForm.overDate_Type" readonly></el-input>
    </el-form-item>
    <el-form-item label="供气周期" prop="overDate_Time">
      <el-input v-model="ruleForm.overDate_Time"></el-input>
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
          value: '常客户'
        },
        {
          value: '临时客户'
        }
      ],
      ruleForm: {
        overDate_Id:0,
        overDate_Name: '',
        overDate_Phone: '',
        overDate_Type: '',
        overDate_Time: ''
      },
      rules: {
        overDate_Id: [
          {required: true, message: '请输入编号', trigger: 'blur'}
        ],
        overDate_Name: [
          {required: true, message: '请输入姓名', trigger: 'blur'}
        ],
        overDate_Phone: [
          {required: true, message: '请输入电话', trigger: 'blur'}
        ],
        overDate_Type: [
          {required: true, message: '请选择客户类型', trigger: 'change'}
        ],
        overDate_Time: [
          {required: true, message: '请输入供气周期', trigger: 'blur'}
        ]
      }
    };
  },
  methods: {
    selectById(){
      const _this = this
      this.$axios.get('http://localhost:8181/overdate/updateOverDate/'+this.ruleForm.Info_Id).then(function (resp) {
        console.log(resp.data)
        _this.ruleForm = resp.data
      })
    },
    submitForm(formName) {
      console.log(this.ruleForm)
      this.$refs[formName].validate((valid) => {
        if (valid) {
          const _this = this
          this.$axios.post('http://localhost:8181/overdate/updateOverDate', this.ruleForm).then(function (resp) {
            if (resp.data == 1) {
              _this.$alert('客户编号: ' + _this.ruleForm.overDate_Name + ' 修改成功！', '', {
                confirmButtonText: '确定',
                callback: action => {
                  _this.$router.push("/warn")
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
      this.$router.replace("/warn")
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
