<template>
  <el-container class="home_container">
    <el-header>
      <div class="home_title" style="">
        <img :src="require('../images/logo.jpg')" alt="" id="logo"/>
        <span style="color: white;font-size: 30px;margin-left: 10px">液化气站客户管理系统</span>
        <span style="color: white;font-size: 30px;margin-left: 500px" >员工版</span>
      </div>
      <div class="home_userinfoContainer">
        <el-dropdown @command="handleCommand">
  <span class="el-dropdown-link home_userinfo" style="font-size: 20px">
    {{ currentUserName }}<i class="el-icon-arrow-down el-icon--right home_userinfo"></i>
  </span>
          <el-dropdown-menu slot="dropdown" style="font-size: 20px">
            <el-dropdown-item command="logout">退出登录</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </div>
    </el-header>
    <el-container>
      <el-aside width="200px" style="background-color:#4e6379">
                <el-menu router background-color=#3b6596  >
                  <el-submenu :index="1">
                    <template slot="title" >
                      <i class="el-icon-user-solid">
                      </i>
                      <span style="color: white;font-size: 15px">客户管理</span>
                    </template>
                    <el-menu-item index="/selectAllInfo">
                      <div style="position: relative;left: 20px">
                        <i class="el-icon-user"></i>
                        <span style="color: white;font-size: 15px">查询用户</span>
                      </div>
                    </el-menu-item>
                    <el-menu-item index="/add">
                      <div style="position: relative;left: 20px">
                        <i class="el-icon-circle-plus"></i>
                        <span style="color: white;font-size: 15px">添加用户</span>
                      </div>
                    </el-menu-item>
                  </el-submenu>
                  <el-submenu :index="2">
                    <template slot="title"><i class="el-icon-notebook-2"></i>
                      <span style="color: white;font-size: 15px">数据管理</span>
                    </template>
                    <el-menu-item index="/data">
                      <div style="position: relative;left: 20px" id="data">
                        <i class="el-icon-s-goods"></i>
                        <span style="color: white;font-size: 15px">供气记录</span>
                      </div>
                    </el-menu-item>
                    <el-menu-item index="/warn">
                      <div style="position: relative;left: 20px">
                        <i class="el-icon-warning"></i>
                        <span style="color: white;font-size: 15px">超期报警</span>
                      </div>
                    </el-menu-item>
                    <el-menu-item index="/contract">
                      <div style="position: relative;left: 20px">
                        <i class="el-icon-s-goods"></i>
                        <span style="color: white;font-size: 15px">合同管理</span>
                      </div>
                    </el-menu-item>

                  </el-submenu>
                  <el-submenu :index="3">
                    <template slot="title"><i class="el-icon-s-data"></i>
                      <span style="color: white;font-size: 15px">报表统计</span>
                    </template>
                    <el-menu-item index="/totalByTime">
                      <div style="position: relative;left: 20px;">
                        <i class="el-icon-date"></i>
                        <span style="color: white;font-size: 15px">时间统计</span>
                      </div>
                    </el-menu-item>
                    <el-menu-item index="/totalByUser">
                      <div style="position: relative;left: 20px">
                        <i class="el-icon-s-custom"></i>
                        <span style="color: white;font-size: 15px">客户统计</span>
                      </div>
                    </el-menu-item>
                  </el-submenu>
                  <el-submenu :index="4" v-show="this.isShow">
                    <template slot="title"><i class="el-icon-user-solid"></i>
                      <span style="color: white;font-size: 15px">权限管理</span>
                    </template>
                    <el-menu-item index="/roleByUser">
                      <div style="position: relative;left: 20px">
                        <i class="el-icon-user"></i>
                        <span style="color: white;font-size: 15px">员工管理</span>
                      </div>
                    </el-menu-item>

                  </el-submenu>
                </el-menu>

      </el-aside>
      <el-container>
        <el-main>
          <el-breadcrumb separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/' }">
              <span style="color: black;font-size: 20px">首页</span>
            </el-breadcrumb-item>
            <el-breadcrumb-item v-text="this.$router.currentRoute.name" style="font-size: 20px"></el-breadcrumb-item>
          </el-breadcrumb>
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>
  </el-container>
</template>


<script>
export default {
  methods: {

    //检查是否存在超期预警的客户，如果存在的话就会蹦出来弹窗提醒员工
    checkOverDate(){
      const _this = this
      this.$axios.post('http://localhost:8181/overdate/checkOverDate',_this.OverDate).then(function (resp) {
        console.log('total:' + resp.data);
        _this.odCount = resp.data;
        if(_this.odCount!=0){
          _this.$confirm('有超期供气客户，请及时处理！', '提示', {
            confirmButtonText: '处理',
            cancelButtonText: '稍后',
            type: 'warning'
          }).then(function () {
            //如果确定的话就跳转到超期预警的界面。
            _this.$router.replace('/warn');
          }, function () {
            //取消
          })
        }
      })
    },
    handleCommand(command) {
      var _this = this;
      if (command == 'logout') {
        this.$confirm('注销登录吗?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(function () {
          localStorage.removeItem('access-user');
          _this.currentUserName = '游客';
          _this.$router.replace('/');
        }, function () {
          //取消
        })
      }
    }
  },
  created() {
    //加载的时候就进行超期预警的检查，有就弹窗
    this.checkOverDate();
  },
  mounted: function () {
    let user = JSON.parse(window.localStorage.getItem('access-user'))
    let role = JSON.parse(window.localStorage.getItem('role'))
    if(role==="user")
      this.isShow=false;
    else if(role==="admin")
      this.isShow=true;
    this.currentUserName = user
  },
  data() {
    return {
      isShow:true,
      currentUserRole:'',
      currentUserName: '',
      defaultActiveIndex: "0",
      collapsed: false,
    }
  }
}
</script>
<style>

#logo{
  height: 25px;
  width: 25px;
}


.home_container {
  height: 100%;
  position: absolute;
  top: 0px;
  left: 0px;
  width: 100%;
}

.el-header {
  background-color: #4e6379;
  /*color: #333;*/
  text-align: center;
  display: flex;
  align-items: center;
  justify-content: space-between;
}

.el-aside {
  background-color: #575c72;
}

.el-main {
  background-color: #fff;
  color: #000;
  text-align: center;
}

.home_title {
  color: #fff;
  font-size: 22px;
  display: inline;
}

.home_userinfo {
  color: #fff;
  cursor: pointer;
}

.home_userinfoContainer {
  display: inline;
  margin-right: 20px;
}
</style>
