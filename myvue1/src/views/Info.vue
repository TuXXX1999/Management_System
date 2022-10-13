<template>
  <div>
    <div>
      <!--搜索表单-->
      <el-form :inline="true" :model="info" class="demo-form-inline">

        <el-form-item label="客户类型" id="type">
          <el-select v-model="info.Type" placeholder="客户类型">
            <el-option label="常客户" value="0"></el-option>
            <el-option label="临时客户" value="1"></el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="客户姓名">
          <!--          <el-input v-model="User.Name" placeholder="员工姓名"></el-input>-->
          <el-select
              v-model="info.Name"
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


        <el-form-item label="电话">
          <el-input v-model="info.Phone" placeholder="电话"></el-input>
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
            prop="info_Id"
            label="编号"
            width="100"
            align="center">
        </el-table-column>
        <el-table-column
            prop="info_Name"
            label="姓名"
            width="100"
            align="center">
        </el-table-column>
        <el-table-column
            prop="info_Phone"
            label="电话号码"
            width="200"
            align="center">
        </el-table-column>
        <el-table-column
            prop="info_Type"
            label="客户类型"
            width="130"
            align="center"
        >
        </el-table-column>
        <el-table-column
            prop="info_Cycle"
            label="供气周期"
            width="150"
            align="center">
        </el-table-column>
        <el-table-column
            prop="info_Address"
            label="家庭住址"
            width="150"
            align="center">
        </el-table-column>
        <el-table-column
            prop="info_Others"
            label="备注"
            width="190"
            align="center">
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
    selectAll(config) {
      const _this = this
      this.$axios.post('http://localhost:8181/info/selectAllByPageAndCondition', _this.info).then(function (resp) {
        console.log('data:' + resp.data)
        //设置表格数据
        _this.tableData = resp.data.rows; // {rows:[],totalCount:100}
        _this.tableData = resp.data
      })
    },
    handleCurrentChange(val) {
      this.currentPage = val
      this.info.Page = val;
      this.selectAll();
    },
    selectAllUser() {
      const _this = this
      this.$axios.get('http://localhost:8181/info/selectAllInfo').then(function (resp) {
        //设置表格数据
        _this.listName = resp.data;
      })
    },
    update(rows) {
      this.$router.push('/updateInfo?id=' + this.tableData[rows].info_Id);
    },
    TotalCount() {
      const _this = this
      this.$axios.post('http://localhost:8181/info/totalInfo', _this.info).then(function (resp) {
        _this.totalCount = resp.data;
      })
    }
    ,
    deleteById(index) {
      console.log(this.tableData[index])
      this.$confirm('确定删除客户：' + this.tableData[index].info_Name + ' ?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        const _this = this
        this.$axios.post('http://localhost:8181/info/deleteById/' + this.tableData[index].info_Id).then(function (resp) {
          if (resp.data == 1) {
            _this.$alert('删除成功！', '', {
              confirmButtonText: '确定',
            });
            _this.totalCount--;
            // _this.$router.replace("/selectAllBook")
            _this.currentPage = 1;
            _this.info.Page = 1;
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
      // console.log(this.info)
      // console.log("yeyeyey:"+this.currentPage)
      this.info.Page = 1;
      this.currentPage = 1;
      this.TotalCount();
      this.selectAll();
    }
  },

  data() {
    return {
      odCount: 0,
      totalCount: 100,
      pageSize: 10,
      currentPage: 1,


      tableData: [{
        info_Id: 0,
        info_Name: '华为',
        info_Phone: '1231231',
        info_Type: '华为科技有限公司',
        info_Cycle: "1",
        info_Address: "",
        info_Others: ""
      }],

      info: {
        Page: 1,
        Name: '',
        Phone: '',
        Type: ''
      },
      listName: ["小明", "小红"]


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
