<template>
  <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="form-container">
    <el-form-item label="姓名" prop="Info_Name">
      <el-input v-model="ruleForm.name"></el-input>
    </el-form-item>
    <el-form-item label="电话" prop="Info_Phone">
      <el-input v-model="ruleForm.phone"></el-input>
    </el-form-item>
    <el-form-item label="客户类型" prop="Info_Type">
      <el-select style="margin-left: -280px;" v-model="ruleForm.type" placeholder="请选择客户类型">
        <el-option v-for="(item,index) in userData" :label="item.value" :value="item.value"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="供气周期" prop="Info_Cycle">
      <el-input v-model="ruleForm.cycle"></el-input>
    </el-form-item>
    <el-form-item label="家庭住址" prop="Info_Cycle">
      <el-input v-model="ruleForm.address"></el-input>
    </el-form-item>
    <el-form-item label="备注" prop="Info_Cycle">
      <el-input v-model="ruleForm.others"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="submitForm('ruleForm')">添加</el-button>
      <el-button @click="resetForm('ruleForm')">重置</el-button>
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
        name: '',
        phone: '',
        type: '',
        cycle: '',
        address:'',
        others:''
      },
      rules: {
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
        ],
        address: [
          {required: true, message: '请输入家庭住址', trigger: 'blur'}
        ]
      }
    };
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          const _this = this
          //添加用户，添加完成之后返回1代表添加成功，返回0代表失败
          this.$axios.post('http://localhost:8181/info/addInfo', this.ruleForm).then(function (resp) {
            if (resp.data == 1) {
              _this.$alert('客户: ' + _this.ruleForm.name + ' 添加成功！', '', {
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
      //重置表单，实现清空操作
      this.$refs[formName].resetFields();
    }
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
