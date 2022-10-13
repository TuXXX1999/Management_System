<template>
  <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="form-container">
    <el-form-item label="编号" prop="Info_Id">
      <el-input v-model="ruleForm.info_Id" readonly></el-input>
    </el-form-item>
    <el-form-item label="姓名" prop="Info_Name">
      <el-input v-model="ruleForm.info_Name"></el-input>
    </el-form-item>
    <el-form-item label="电话" prop="Info_Phone">
      <el-input v-model="ruleForm.info_Phone"></el-input>
    </el-form-item>
    <el-form-item label="客户类型" prop="Info_Type">
      <el-select style="margin-left: -280px;" v-model="ruleForm.info_Type" placeholder="请选择客户类型">
        <el-option v-for="(item,index) in userData" :label="item.value" :value="item.value"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="供气周期" prop="Info_Cycle">
      <el-input v-model="ruleForm.info_Cycle"></el-input>
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
        info_Id:0,
        info_Name: '',
        info_Phone: '',
        info_Type: '',
        info_Cycle: ''
      },
      rules: {
        id: [
          {required: true, message: '请输入编号', trigger: 'blur'}
        ],
        name: [
          {required: true, message: '请输入姓名', trigger: 'blur'}
        ],
        phone: [
          {required: true, message: '请输入电话', trigger: 'blur'}
        ],
        type: [
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
      this.$axios.get('http://localhost:8181/info/updateInfo/'+this.ruleForm.Info_Id).then(function (resp) {
        console.log(resp.data)
        _this.ruleForm = resp.data
      })
    },
    submitForm(formName) {
      console.log(this.ruleForm)
      this.$refs[formName].validate((valid) => {
        if (valid) {
          const _this = this
          this.$axios.post('http://localhost:8181/info/updateInfo', this.ruleForm).then(function (resp) {
            if (resp.data == 1) {
              _this.$alert('客户编号: ' + _this.ruleForm.info_Name + ' 修改成功！', '', {
                confirmButtonText: '确定',
                callback: action => {
                  _this.$router.push("/selectAllInfo")
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
      this.$router.replace("/selectAllInfo")
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
