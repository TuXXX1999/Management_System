<template>
  <el-form :model="ruleForm" :rules="rules" ref="ruleForm" class="form-container" label-width="80px">
    <el-form-item label="客户姓名" prop="contract_Info">
      <el-input v-model="ruleForm.contract_Info"></el-input>
    </el-form-item>
    <el-form-item label="开始时间" prop="contract_Start">
      <el-input v-model="ruleForm.contract_Start"></el-input>
    </el-form-item>
    <el-form-item label="结束时间" prop="contract_End">
      <el-input v-model="ruleForm.contract_End"></el-input>
    </el-form-item>
    <el-form-item label="供气总量" prop="contract_Amount">
      <el-input v-model="ruleForm.contract_Amount" readonly></el-input>
    </el-form-item>
    <el-form-item label="开始时间" prop="contract_Start">
      <el-input v-model="ruleForm.contract_Start"></el-input>
    </el-form-item>
    <el-form-item label="合同状态" prop="contract_State">
      <el-select v-model="ruleForm.contract_State" placeholder="合同状态">
        <el-option label="已结算" value="0"></el-option>
        <el-option label="未结算" value="1"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="合同描述" prop="contract_Describe">
      <el-input v-model="ruleForm.contract_Describe" type="textarea"
                resize="none"
                :autosize="{ minRows: 1, maxRows: 5 }"></el-input>
    </el-form-item>

    <el-form-item label="合同图片">
<!--      <img v-image-preview src="src/images/合同1.jpg" id="contractPhoto1"/>-->
      <img v-image-preview :src="require(''+'@/images/合同1.jpg'+'')" id="contractPhoto1"/>
    </el-form-item>
    <el-form-item>
      <el-button type="danger" @click="updateContract('ruleForm')" v-show="isShow">修改</el-button>
      <el-button type="primary" @click="goBack()">返回</el-button>
    </el-form-item>
  </el-form>

</template>

<script>

export default {
  data() {
    return {
      isShow: true
      ,
      ruleForm: {
        contract_Id: 0,
        contract_Info: '',
        contract_Start: '',
        contract_End: '',
        contract_Amount: '',
        contract_Describe: '',
        contract_State: ''
      },
      rules: {
        contract_Id: [
          {required: true, message: '无编号', trigger: 'blur'}
        ],
        contract_Start: [
          {required: true, message: '无开始时间', trigger: 'blur'}
        ],
        contract_End: [
          {required: true, message: '无结束时间', trigger: 'blur'}
        ],
        contract_Amount: [
          {required: true, message: '无具体数量', trigger: 'change'}
        ],
        contract_Describe: [
          {required: true, message: '无描述', trigger: 'blur'}
        ],
        contract_State: [
          {required: true, message: '无描述', trigger: 'blur'}
        ]
      }
    };
  },
  methods: {
    selectById() {
      const _this = this
      this.$axios.get('http://localhost:8181/contract/selectById/' + _this.ruleForm.contract_Id).then(function (resp) {
        //返回的是一个集合，由于这个集合直接对应数值怎么都对应不上，干脆就直接挨个赋值了。
        _this.ruleForm.contract_Id = resp.data.contract_Id
        _this.ruleForm.contract_Info = resp.data.contract_Info
        _this.ruleForm.contract_Start = resp.data.contract_Start
        _this.ruleForm.contract_End = resp.data.contract_End
        _this.ruleForm.contract_Amount = resp.data.contract_Amount
        _this.ruleForm.contract_Describe = resp.data.contract_Describe
        _this.ruleForm.contract_State = resp.data.contract_State
      })
    },
    goBack() {
      //返回原来的合同页面
      this.$router.replace("/contract")
    },
    updateContract(formName) {
      console.log(this.ruleForm)
      this.$refs[formName].validate((valid) => {
        if (valid) {
          const _this = this
          this.$axios.post('http://localhost:8181/contract/updateContract', this.ruleForm).then(function (resp) {
            if (resp.data == 1) {
              _this.$alert('合同编号: ' + _this.ruleForm.contract_Id + ' 修改成功！', '', {
                confirmButtonText: '确定',
                callback: action => {
                  _this.$router.push("/contract")
                }
              });
            }
          })
        } else {
          console.log('error submit!!');
          return false;
        }
      });

    }
  },
  created() {
    //一进来先让传过来的ID值等于待会要查询的id值
    this.ruleForm.contract_Id = this.$route.query.id;
    this.selectById();
    let role = JSON.parse(window.localStorage.getItem('role'))
    console.log(role)
    if (role === "admin")
      this.isShow = true;
    else
      this.isShow = false;
  }
}
</script>

<style>
#contractPhoto1 {
  height: 50px;
  width: 90px;
}

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
