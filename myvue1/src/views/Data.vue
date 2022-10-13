<template>
  <div>
    <div>
      <!--搜索表单-->
      <el-form :inline="true" :model="data" class="demo-form-inline">


        <el-form-item label="客户姓名">
          <el-input v-model="data.Info" placeholder="客户姓名"></el-input>
        </el-form-item>
        <el-form-item label="员工姓名">
          <el-input v-model="data.User" placeholder="员工姓名"></el-input>
        </el-form-item>
        <el-form-item label="时间">
          <el-input v-model="data.Time" placeholder="仅展示选定时间之后的数据"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="query">查询</el-button>
          <el-button type="primary" @click="add">添加</el-button>
        </el-form-item>
      </el-form>

      <el-table
          :data="tableData"

          border
          style="width: 70%;margin: auto;font-size: 18px"
      >
        <el-table-column
            fixed
            prop="data_Id"
            label="编号"
            width="120"
            align="center">
        </el-table-column>
        <el-table-column
            prop="data_Time"
            label="时间"
            width="200"
            align="center">
        </el-table-column>
        <el-table-column
            prop="data_Amount"
            label="供气总量(m³)"
            width="180"
            align="center">
        </el-table-column>
        <el-table-column
            prop="data_Info"
            label="客户姓名"
            width="180"
            align="center">
        </el-table-column>
        <el-table-column
            prop="users.user_Name"
            label="员工姓名"
            width="180"
            align="center"
        >
        </el-table-column>
        <el-table-column
            fixed="right"
            label="操作"
            width="150"
            align="center">
          <template slot-scope="scope">
            <el-button @click="update(scope.$index)" type="danger" size="small" round>修改</el-button>
            <el-button @click="deleteById(scope.$index)" type="primary" size="small" round>删除</el-button>
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
    findUserId() {
      const _this = this
      this.$axios.get('http://localhost:8181/user/findUserId/' + _this.data.User).then(function (resp) {
        //查找到员工的ID，方便待会进行多表查询
        _this.data.UserId = parseInt(resp.data);
      })
      _this.selectAll();
    },
    selectAll(config) {
      const _this = this
      //如果UserId==0的话，说明没有进行员工姓名的输入，此时就不要把员工的ID传过去了，传过去会导致查询不到结果，因为UserId没有=0的员工
      if (_this.data.UserId == 0) {
        this.$axios.post('http://localhost:8181/data/selectAllByPageAndConditionWithNull', _this.data).then(function (resp) {
          //设置表格数据
          _this.tableData = resp.data.rows; // {rows:[],totalCount:100}
          _this.tableData = resp.data
        })
      } else {
        this.$axios.post('http://localhost:8181/data/selectAllByPageAndCondition', _this.data).then(function (resp) {
          //设置表格数据
          _this.tableData = resp.data.rows; // {rows:[],totalCount:100}
          _this.tableData = resp.data
        })

      }
    },
    handleCurrentChange(val) {
      //将当前页设置为当前值
      this.currentPage = val
      //这是后端需要的数值
      this.data.Page = val;
      //改变之后再一次调用SELECTALL函数
      this.selectAll();
    },

    update(rows) {
      this.$router.push('/updateData?id=' + this.tableData[rows].data_Id);
    },
    TotalCount() {
      const _this = this
      if (_this.data.UserId == 0) {
        this.$axios.post('http://localhost:8181/data/totalDataWithNull', _this.data).then(function (resp) {
          _this.totalCount = resp.data;
        })
      } else {
        this.$axios.post('http://localhost:8181/data/totalData', _this.data).then(function (resp) {
          _this.totalCount = resp.data;
        })
      }
    }
    ,
    deleteById(index) {
      console.log(this.tableData[index])
      this.$confirm('确定删除客户：' + this.tableData[index].data_Info + ' ?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        const _this = this
        this.$axios.post('http://localhost:8181/data/deleteById/' + this.tableData[index].data_Id).then(function (resp) {
          if (resp.data == 1) {
            _this.$alert('删除成功！', '', {
              confirmButtonText: '确定',
            });
            //删除成功之后相对应的数据总数就少一条，直接-1
            _this.totalCount--;
            //将原来的页码全部设为1，实现刷新操作
            _this.currentPage = 1;
            _this.data.Page = 1;
            _this.selectAll();
          }
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        });
      });
    },
    query() {
      //查询之后也是将所有页码都设为1，实现刷新
      this.data.Page = 1;
      this.currentPage = 1;
      if (this.data.User != null&&this.data.User!=='') {
        this.findUserId();
      }else{
        this.data.UserId=0;
      }
      this.selectAll();
      this.TotalCount();
    },
    add() {
      //都可以，replace也行
      this.$router.push('/addData');
    }
  },

  data() {
    return {
      odCount: 0,
      totalCount: 100,
      pageSize: 10,
      currentPage: 1,


      tableData: [{
        data_Id: 0,
        data_Info: '华为',
        data_Time: '1231231',
        data_User: 0,
        data_Amount: "1",
        data_UserName: "",
        users: {
          data: null,
          user_Id: 1,
          user_Name: "涂迅",
          user_Pass: "123"
        }
      }],

      data: {
        Page: 1,
        Info: '',
        User: "",
        UserId: 0,
        Time: ''
      }


    }
  },

  created() {
    //初始化
    this.selectAll();
    this.TotalCount()
  }
}
</script>

<style scoped>

</style>
