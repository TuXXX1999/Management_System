<template>
  <div>
    <div>
      <!--搜索表单-->
      <el-form :inline="true" :model="User" class="demo-form-inline">

        <el-form-item label="员工类型">
          <el-select v-model="User.Type" placeholder="客户类型">
            <el-option label="管理员" value="1"></el-option>
            <el-option label="普通员工" value="2"></el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="员工姓名">
          <!--          <el-input v-model="User.Name" placeholder="员工姓名"></el-input>-->
          <el-select
              v-model="User.Name"
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

        <el-form-item>
          <el-button type="primary" @click="query">查询</el-button>
        </el-form-item>
      </el-form>

      <el-table
          :data="tableData"

          border
          style="width: 80%;margin: auto;font-size: 18px"

      >
        <el-table-column
            fixed
            prop="user_Id"
            label="编号"
            width="170"
            align="center">
        </el-table-column>
        <el-table-column
            prop="user_Name"
            label="姓名"
            width="180"
            align="center">
        </el-table-column>
        <el-table-column
            prop="roles.role_Name"
            label="权限类型"
            width="200"
            align="center"
        >
        </el-table-column>
        <el-table-column
            prop="user_Phone"
            label="电话号码"
            width="200"
            align="center"
        >
        </el-table-column>
        <el-table-column
            prop="user_Address"
            label="家庭住址"
            width="200"
            align="center"
        >
        </el-table-column>
        <el-table-column
            fixed="right"
            label="操作"
            width="220"
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
    handleCheckChange(data, checked, indeterminate) {
      console.log(data, checked, indeterminate);
    },
    empower(roleId){
      this.roleFormVisible=true;
    },
    selectAll(config) {
      const _this = this
      console.log(this.User)
      this.$axios.post('http://localhost:8181/user/selectAllByPageAndCondition', _this.User).then(function (resp) {
        console.log('data:' + resp.data)
        //设置表格数据
        _this.tableData = resp.data.rows; // {rows:[],totalCount:100}
        _this.tableData = resp.data
      })


    },
    handleCurrentChange(val) {
      this.currentPage = val
      this.User.Page = val;
      this.selectAll();
    },

    update(rows) {
      this.$router.push('/updateUser?id=' + this.tableData[rows].user_Id);
    },
    TotalCount() {
      const _this = this
      this.$axios.post('http://localhost:8181/user/totalUser', _this.User).then(function (resp) {
        _this.totalCount = resp.data;
      })
    }
    ,
    deleteById(index) {
      this.$confirm('确定删除客户：' + this.tableData[index].User_Name + ' ?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        const _this = this
        this.$axios.post('http://localhost:8181/user/deleteById/' + this.tableData[index].User_Id).then(function (resp) {
          if (resp.data == 1) {
            _this.$alert('删除成功！', '', {
              confirmButtonText: '确定',
            });
            _this.totalCount--;
            // _this.$router.replace("/selectAllBook")
            _this.currentPage = 1;
            _this.User.Page = 1;
            _this.selectAll();
          }
        })
      }).catch(() => {
        this.$message({
          type: 'user',
          message: '已取消删除'
        });
      });
    },
    query() {
      this.User.Page = 1;
      this.currentPage = 1;
      this.TotalCount();
      this.selectAll();
    },
    selectAllUser() {
      const _this = this
      this.$axios.get('http://localhost:8181/user/selectAllUser').then(function (resp) {
        //设置表格数据
        _this.listName = resp.data;
      })
    }
  },

  data() {
    return {
      MenuData: [{
        id: 1,
        label: '一级 1',
        children: [{
          id: 4,
          label: '二级 1-1',
          children: [{
            id: 9,
            label: '三级 1-1-1'
          }, {
            id: 10,
            label: '三级 1-1-2'
          }]
        }]
      }],
      odCount: 0,
      totalCount: 100,
      roleFormVisible:false,
      pageSize: 10,
      form:{},
      currentPage: 1,
      listName: ["小明", "小红"]
      ,
      tableData: [{
        user_Id: 0,
        user_Name: '华为',
        user_Type: '华为科技有限公司',
        user_Phone: '18176951312',
        user_Address: ""
      }],

      User: {
        Page: 1,
        Name: '',
        Type: ''
      }


    }
  },

  created() {
    this.selectAll();
    this.TotalCount()
    this.selectAllUser();
  }
}
</script>

<style scoped>

</style>
