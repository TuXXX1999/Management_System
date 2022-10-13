<template>
  <!--  echarts容器 默认宽高为0 如果不进行设置 页面不显示-->
  <div>
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
    <el-date-picker
        v-model="value2"
        type="monthrange"
        align="right"
        unlink-panels
        range-separator="至"
        start-placeholder="开始月份"
        end-placeholder="结束月份"
        :picker-options="pickerOptions"
        style="width: 300px;margin-right: 50px;margin-left: 20px">
    </el-date-picker>
    <el-button type="primary" @click="query">查询</el-button>

    <div ref="mychart" id="demoDiv"></div>
  </div>
</template>

<script>
import * as echarts from 'echarts'

export default {
  mounted() {
    this.selectAllInfo();
    const myEcharts = echarts.init(this.$refs.mychart)
    //设置参数
    let xData = ["1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"];
    //默认参数，后期要改的地方
    let yData = [6300, 4800, 3150, 1350, 6300, 4800, 3150, 1350, 6300, 4800, 3150, 1350];

    console.log("yData:" + yData)
    let option = {
      title: {
        //标题
        text: "液化气站供气客户统计",
        x: "center",
        textStyle: {
          fontSize: 30
        }
      },
      xAxis: {
        name: "月份",
        data: xData
      },
      yAxis: {
        name: "供气总量(m³)"
      },
      tooltip: {
        trigger: "axis",
        axisPointer: {
          type: "shadow"
        }
      },
      series: {//系列
        name: "供气总量(m³)",
        type: "bar",
        data: yData
      }
    }
    myEcharts.setOption(option)
  },
  methods: {
    selectAllInfo() {
      const _this = this
      this.$axios.get('http://localhost:8181/info/selectAllInfo').then(function (resp) {
        //设置表格数据
        console.log("resp.data"+resp.data)
        _this.listName = resp.data;
      })
    },
    query(){
      const myEcharts = echarts.init(this.$refs.mychart)
      this.Start=this.value2[0];
      this.End=this.value2[1];
      //年
      var Syear = this.Start.getFullYear();
//月
      var Smonth = this.Start.getMonth() + 1;

      //如果月份和日期小于10的话要在前面加个0,拼凑成XXXX-XX-XX的格式，方便查找
      Smonth = Smonth > 9 ? Smonth : '0' + Smonth


      var StrStart = Syear + '-' + Smonth;
      //年
      var Eyear = this.End.getFullYear();
//月
      var Emonth = this.End.getMonth() + 1;

      //如果月份和日期小于10的话要在前面加个0,拼凑成XXXX-XX-XX的格式，方便查找
      Emonth = Emonth > 9 ? Emonth : '0' + Emonth


      var StrEnd= Eyear + '-' + Emonth;

      var countYear=Eyear-Syear;
      var countMonth= this.End.getMonth() - this.Start.getMonth() +countYear*12;
      var xData=[];
      var j=0;
      for(var i = (this.Start.getMonth() + 1);i<=countMonth+(this.Start.getMonth() + 1);i++){
        if(i>12){
          xData[j++]=(i-12)+"月"
        }else{
          xData[j++]=i+"月"
        }
      }
      console.log(xData)

      var yData=[];
      var _this = this
      this.$axios.get('http://localhost:8181/data/totalByMonthById/' + StrStart+"/"+StrEnd+"/"+this.ruleForm.Data_Info).then(function (resp) {
        console.log(resp.data)
        yData = resp.data
        console.log("sndajdns11:" + yData)
        myEcharts.setOption({
          xAxis: {
            data: xData
          },
          series: [
            {
              data: yData//赋值
            }
          ]
        })
      })

    }
  },
  data() {
    return {
      info: {
        Page: 1,
        Name: '',
        Phone: '',
        Type: ''
      },
      pickerOptions: {
        shortcuts: [{
          text: '今年至今',
          onClick(picker) {
            const end = new Date();
            const start = new Date(new Date().getFullYear(), 0);
            picker.$emit('pick', [start, end]);
          }
        }, {
          text: '最近六个月',
          onClick(picker) {
            const end = new Date();
            const start = new Date();
            start.setMonth(start.getMonth() - 6);
            picker.$emit('pick', [start, end]);
          }
        }]
      },
      value2: '',
      Start:'',
      End:'',
      listName:["小明","小红"]
      ,
      ruleForm: {
        Data_Time: '',
        Data_Amount: '',
        Data_Info: '',
        Data_User: '',
        Data_time: ''
      },
    }
  }
}
</script>


<style>
#demoDiv {
  width: 800px;
  height: 500px;
  border: 1px solid #7e7e7e;
  margin: 80px auto;
}
</style>
