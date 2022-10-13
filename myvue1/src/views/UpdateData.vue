<template>
  <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="form-container">
    <el-form-item label="供气编号" prop="data_Id">
      <el-input v-model="ruleForm.data_Id" readonly></el-input>
    </el-form-item>
    <el-form-item label="供气时间" prop="data_time">
      <el-date-picker
          v-model="ruleForm.data_time"
          type="date"
          placeholder="选择日期"
          :picker-options="pickerOptions">
      </el-date-picker>
    </el-form-item>
    <el-form-item label="供气数量" prop="data_Amount">
      <el-input v-model="ruleForm.data_Amount"></el-input>
    </el-form-item>
    <el-form-item label="供气人(客户)" prop="data_Info">
      <el-input v-model="ruleForm.data_Info"></el-input>
    </el-form-item>
    <el-form-item label="客户接收人员(员工)" prop="data_User">
      <el-input v-model="ruleForm.users.user_Name" readonly></el-input>
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
      pickerOptions: {
        disabledDate(time) {
          return time.getTime() > Date.now();
        }, shortcuts: [{
          text: '今天',
          onClick(picker) {
            picker.$emit('pick', new Date());
          }
        }, {
          text: '昨天',
          onClick(picker) {
            const date = new Date();
            date.setTime(date.getTime() - 3600 * 1000 * 24);
            picker.$emit('pick', date);
          }
        }, {
          text: '一周前',
          onClick(picker) {
            const date = new Date();
            date.setTime(date.getTime() - 3600 * 1000 * 24 * 7);
            picker.$emit('pick', date);
          }
        }]
      },
      ruleForm: {
        data_Id:0,
        data_Time: '',
        data_Amount: '',
        data_Info: '',
        data_User: '',
        data_time:''
      },
      rules: {
        data_time: [
          {required: true, message: '时间不能为空', trigger: 'blur'}
        ],
        data_Amount: [
          {required: true, message: '数量不能为空', trigger: 'blur'}
        ],
        data_Info: [
          {required: true, message: '客户不能为空', trigger: 'change'}
        ],
        data_User: [
          {required: true, message: '员工不能为空', trigger: 'blur'}
        ],
        data_Id: [
          {required: true, message: '编号不能为空', trigger: 'blur'}
        ]
      }
    };
  },
  methods: {
    selectById(){
      const _this = this
      this.$axios.get('http://localhost:8181/data/updateData/'+this.ruleForm.Data_Id).then(function (resp) {
        console.log(resp.data)
        _this.ruleForm = resp.data
      })
    },
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          //年
          var year = this.ruleForm.data_time.getFullYear();
//月
          var month = this.ruleForm.data_time.getMonth() + 1;
//日
          var strDate = this.ruleForm.data_time.getDate();

          month = month > 9 ? month : '0' + month

          strDate = strDate > 9 ? strDate : '0' + strDate

          this.ruleForm.data_Time = year + '-' + month + '-' + strDate;
          const _this = this
          this.$axios.post('http://localhost:8181/data/updateData', this.ruleForm).then(function (resp) {
            if (resp.data == 1) {
              _this.$alert('供气编号: ' + _this.ruleForm.data_Id + ' 修改成功！', '', {
                confirmButtonText: '确定',
                callback: action => {
                  _this.$router.push("/data")
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
      this.$router.replace("/data")
    }
  },
  created(){
    // console.log(this.$route.query.id)
    this.ruleForm.Data_Id=this.$route.query.id;
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
