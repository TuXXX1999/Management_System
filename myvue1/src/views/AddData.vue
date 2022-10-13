<template>
  <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="form-container">
    <el-form-item label="供气人" prop="Data_Info">
      <!--      <el-input v-model="ruleForm.Data_Info"></el-input>-->
      <el-select
          v-model="ruleForm.Data_Info"
          placeholder="姓名"
          clearable filterable
      >
        <el-option
            v-for="item in this.listName"
            :key="item"
            :label="item"
            :value="item"
        />
      </el-select>
    </el-form-item>
    <el-form-item label="供气时间" prop="Data_time">
      <el-date-picker
          v-model="ruleForm.Data_time"
          type="date"
          placeholder="选择日期"
          :picker-options="pickerOptions">
      </el-date-picker>
    </el-form-item>
    <el-form-item label="供气数量" prop="Data_Amount">
      <el-input v-model="ruleForm.Data_Amount"></el-input>
    </el-form-item>
    <!--    <el-form-item label="供气人" prop="Data_Info">-->
    <!--      <el-input v-model="ruleForm.Data_Info"></el-input>-->
    <!--    </el-form-item>-->
    <el-form-item label="客户接待人" prop="Data_User">
      <el-input v-model="ruleForm.Data_User" readonly></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="submitForm('ruleForm')">记录</el-button>
      <el-button @click="resetForm('ruleForm')">重置</el-button>
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
      listName:["小明","小红"]
      ,
      ruleForm: {
        Data_Time: '',
        Data_Amount: '',
        Data_Info: '',
        Data_User: '',
        Data_time: '',
        Data_UserId: ''
      },
      rules: {
        Data_Time: [
          {required: true, message: '时间不能为空', trigger: 'blur'}
        ],
        Data_Amount: [
          {required: true, message: '数量不能为空', trigger: 'blur'}
        ],
        Data_Info: [
          {required: true, message: '客户不能为空', trigger: 'change'}
        ],
        Data_User: [
          {required: true, message: '员工不能为空', trigger: 'blur'}
        ]
      },
      data: {
        Info: '',
        User: "",
        UserId: 0,
        Time: ''
      }
    };
  },
  methods: {
    findUserId() {
      const _this = this
      this.$axios.get('http://localhost:8181/user/findUserId/' + _this.ruleForm.Data_User).then(function (resp) {
        //查找到员工的ID，方便待会进行多表查询
        _this.ruleForm.Data_UserId = parseInt(resp.data);
      })
    },
    selectAllInfo() {
      const _this = this
      this.$axios.get('http://localhost:8181/info/selectAllInfo').then(function (resp) {
        //设置表格数据
        console.log("resp.data"+resp.data)
        _this.listName = resp.data;
      })
    }
    ,
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
//年
          var year = this.ruleForm.Data_time.getFullYear();
//月
          var month = this.ruleForm.Data_time.getMonth() + 1;
//日
          var strDate = this.ruleForm.Data_time.getDate();
          //如果月份和日期小于10的话要在前面加个0,拼凑成XXXX-XX-XX的格式，方便查找
          month = month > 9 ? month : '0' + month

          strDate = strDate > 9 ? strDate : '0' + strDate

          this.ruleForm.Data_Time = year + '-' + month + '-' + strDate;

          const _this = this
          //将要添加的数据POST回后端，后端成功返回1,只需要判断返回数值即可知道是否添加成功
          this.$axios.post('http://localhost:8181/data/addData', this.ruleForm).then(function (resp) {
            if (resp.data == 1) {
              _this.$alert('数据记录成功！', '', {
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
    }
  },
  created(key) {
    var Name = localStorage.getItem('access-user');
    //除去首尾的双引号
    var str1 = Name.replace("\"", "").replace("\"", "");
    this.ruleForm.Data_User = str1
    this.selectAllInfo();
    this.findUserId();
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
