<template>
  <div>
    <div>
      <!--搜索表单-->
      <el-form :inline="true" :model="contract" class="demo-form-inline">

        <el-form-item label="合同状态">
          <el-select v-model="contract.State" placeholder="是否结算">
            <el-option label="已结算" value="0"></el-option>
            <el-option label="未结算" value="1"></el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="开始时间">
          <el-input v-model="contract.Start" placeholder="XXXX-XX-XX"></el-input>
        </el-form-item>

        <el-form-item label="结束时间">
          <el-input v-model="contract.End" placeholder="XXXX-XX-XX"></el-input>
        </el-form-item>

        <el-form-item>
          <el-button type="primary" @click="query">查询</el-button>
        </el-form-item>
      </el-form>

      <el-table
          :data="tableData"
          border
          style="width: 75%;margin-left: 200px;margin-top: 30px;font-size: 18px"
      >
        <el-table-column
            fixed
            prop="contract_Id"
            label="编号"
            width="100"
            align="center">
        </el-table-column>
        <el-table-column
            prop="contract_Info"
            label="客户姓名"
            width="180"
            align="center">
        </el-table-column>
        <el-table-column
            prop="contract_Start"
            label="开始时间"
            width="180"
            align="center">
        </el-table-column>
        <el-table-column
            prop="contract_End"
            label="结束时间"
            width="180"
            align="center">
        </el-table-column>
        <el-table-column
            prop="contract_Amount"
            label="供气总量"
            width="150"
            align="center"
        >
        </el-table-column>
        <el-table-column
            prop="contract_State"
            label="结算状态"
            width="100"
            align="center">
        </el-table-column>
        <el-table-column
            fixed="right"
            label="操作"
            width="180"
            align="center">
          <template slot-scope="scope">
            <el-button @click="checkById(scope.$index)" type="primary" size="medium " round>查看</el-button>
            <el-button @click="deleteById(scope.$index)" type="danger" size="medium " round v-show="isShow">删除
            </el-button>
          </template>
        </el-table-column>


      </el-table>
      <el-pagination
          background
          layout="prev, pager, next"
          :total="totalCount"
          :page-size="pageSize"
          :current-page="currentPage"
          @current-change="handleCurrentChange"
      >
      </el-pagination>
    </div>
  </div>
</template>

<script>
export default {
  methods: {
    selectAll(config) {
      const _this = this
      this.$axios.post('http://localhost:8181/contract/selectAllByPageAndCondition', _this.contract).then(function (resp) {
        //设置表格数据
        _this.tableData = resp.data.rows; // {rows:[],totalCount:100}

        _this.tableData = resp.data
      })


    },
    handleCurrentChange(val) {
      //将当前页设置为当前值
      this.currentPage = val
      //这是后端需要的数值
      this.contract.Page = val;
      //改变之后再一次调用SELECTALL函数
      this.selectAll();
    },


    //查看具体合同详情，只是多了个描述，但是不能进行修改
    checkById(rows) {
      this.$router.push('/contractById?id=' + this.tableData[rows].contract_Id);
    },

    //获取合同总数，方便进行分页
    TotalCount() {
      const _this = this
      this.$axios.post('http://localhost:8181/contract/totalContract', _this.contract).then(function (resp) {
        //返回的值是合同的总数
        _this.totalCount = resp.data;
      })
    }
    ,
    query() {
      //由于每次查询后肯定会有新的数据，所以要把原来的页数都设为1，否则会出现明明查出来的数据只有1页但是当前页码为3的情况
      this.contract.Page = 1;
      this.currentPage = 1;
      this.TotalCount();
      this.selectAll();
    }
  },

  data() {
    return {
      isShow: true,
      totalCount: 100,
      pageSize: 10,
      currentPage: 1,


      tableData: [{
        contract_Id: 1,
        contract_Info: '',
        contract_Start: '2011',
        contract_End: '1231231',
        contract_Amount: '200吨',
        contract_State: "未结算",
        contract_Describe: "好好好"
      }, {
        contract_Id: 2,
        contract_Info: '',
        contract_Start: '2011',
        contract_End: '1231231',
        contract_Amount: '200吨',
        contract_State: "未结算",
        contract_Describe: "好好好"
      }, {
        contract_Id: 3,
        contract_Info: '',
        contract_Start: '2011',
        contract_End: '1231231',
        contract_Amount: '200吨',
        contract_State: "未结算",
        contract_Describe: "好好好"
      }, {
        contract_Id: 4,
        contract_Info: '',
        contract_Start: '2011',
        contract_End: '1231231',
        contract_Amount: '200吨',
        contract_State: "未结算",
        contract_Describe: "好好好"
      }],

      contract: {
        Page: 1,
        State: '',
        Start: '',
        End: ''
      }


    }
  },
  created() {
    //进来就先调用一次这个函数，显示出所有的合同
    this.selectAll();
    this.TotalCount()

    let role = JSON.parse(window.localStorage.getItem('role'))
    if (role === "admin")
      this.isShow = true;
    else if (role === "user"&&window.localStorage.getItem('changeContract')==="true")
      this.isShow = true;
    else
      this.isShow = false;
  }
}
</script>

<style scoped>

</style>
