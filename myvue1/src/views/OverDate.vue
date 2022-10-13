<template>
  <div>
    <div>
      <!--搜索表单-->
      <el-form :inline="true" :model="  OverDate" class="demo-form-inline">

        <el-form-item label="客户类型">
          <el-select v-model="OverDate.Type" placeholder="客户类型">
            <el-option label="常客户" value="0"></el-option>
            <el-option label="临时客户" value="1"></el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="客户姓名">
          <el-input v-model="OverDate.Name" placeholder="客户姓名"></el-input>
        </el-form-item>

        <el-form-item label="电话">
          <el-input v-model="OverDate.Phone" placeholder="电话"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="query">查询</el-button>
        </el-form-item>
      </el-form>

      <el-table
          :data="tableData"

          border
          style="width: 70%;margin: auto;font-size: 18px"
      >
        <el-table-column
            fixed
            prop="overDate_Id"
            label="编号"
            width="150"
            align="center">
        </el-table-column>
        <el-table-column
            prop="overDate_Name"
            label="姓名"
            width="150"
            align="center">
        </el-table-column>

        <el-table-column
            prop="overDate_Phone"
            label="电话号码"
            width="220"
            align="center">
        </el-table-column>
        <el-table-column
            prop="overDate_Type"
            label="客户类型"
            width="180"
            align="center"
        >
        </el-table-column>
        <el-table-column
            prop="overDate_Time"
            label="超期时间"
            width="150"
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
      console.log('页码:' + this.OverDate.Page);
      const _this = this
      console.log("对象"+this.OverDate)
      this.$axios.post('http://localhost:8181/overdate/selectAllByPageAndCondition', _this.OverDate).then(function (resp) {
        console.log('data:' +resp.data.rows)
        //设置表格数据
        _this.tableData = resp.data.rows; // {rows:[],totalCount:100}
        console.log('tableData:' +_this.tableData)
        _this.tableData = resp.data
      })


    },
    handleCurrentChange(val) {
      this.currentPage = val
      this.OverDate.Page=val;
      this.selectAll();
    },

    update(rows) {
      this.$router.push('/updateOverDate?id=' + this.tableData[rows].overDate_Id);
    },
    TotalCount() {
      const _this = this
      this.$axios.post('http://localhost:8181/overdate/totalOverDate',_this.OverDate).then(function (resp) {
        console.log('total:' + resp.data);
        _this.totalCount = resp.data;
      })
    }
    ,
    deleteById(index) {
      console.log(this.tableData[index])
      this.$confirm('确定删除客户：' + this.tableData[index].overDate_Name + ' ?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        const _this = this
        this.$axios.post('http://localhost:8181/overdate/deleteById/' + this.tableData[index].OverDate_Id).then(function (resp) {
          if (resp.data == 1) {
            _this.$alert('删除成功！', '', {
              confirmButtonText: '确定',
            });
            _this.totalCount--;
            // _this.$router.replace("/selectAllBook")
            _this.currentPage=1;
            _this.OverDate.Page=1;
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
      console.log(this.OverDate)
      this.OverDate.Page=1;
      this.currentPage=1;
      this.TotalCount();
      this.selectAll();
    }
  },

  data() {
    return {
      totalCount: 100,
      pageSize: 10,
      currentPage: 1,


      tableData: [{
        overDate_Id: 0,
        overDate_Name: '华为',
        overDate_Phone: '1231231',
        overDate_Type: '华为科技有限公司',
        overDate_Time: "1天"
      }],

      OverDate: {
        Page:1,
        Name: '',
        Phone: '',
        Type: ''
      }


    }
  },

  created() {
    this.selectAll();
    this.TotalCount()
  }
}
</script>

<style scoped>

</style>
