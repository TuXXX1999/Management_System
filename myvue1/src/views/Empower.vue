<template>
  <div style="border: black solid 1px;height: 500px;width: 500px;margin: auto">
    <div style="margin-bottom: 50px;font-size: 30px">请选择普通员工的权限</div>
    <el-checkbox :indeterminate="isIndeterminate" v-model="checkAll" @change="handleCheckAllChange">全选</el-checkbox>
    <div style="margin: 15px 0;"></div>
    <el-checkbox-group v-model="checkedCities" @change="handleCheckedCitiesChange">
      <el-checkbox v-for="city in cities" :label="city" :key="city">{{city}}</el-checkbox>
    </el-checkbox-group>
    <el-button @click="empower" type="primary" size="small" round>授权</el-button>
  </div>
</template>

<script>
const cityOptions = ['修改合同信息', '删除合同'];
export default {
  data() {
    return {
      checkAll: false,
      checkedCities: ['修改合同信息', '删除合同'],
      cities: cityOptions,
      isIndeterminate: true
    };
  },
  methods: {
    empower(){
      console.log(this.checkedCities)
      localStorage.setItem('changeContract', false);
      localStorage.setItem('deleteContract', false);
      for(var i=0;i<this.checkedCities.length;i++){
        if(this.checkedCities[i]=="修改合同信息"){
          localStorage.setItem('changeContract', true);
        }
        if(this.checkedCities[i]=="删除合同"){
          localStorage.setItem('deleteContract', true);
        }
      }
      console.log(localStorage.getItem('deleteContract'))
      console.log(localStorage.getItem('changeContract'))
    },
    handleCheckAllChange(val) {
      this.checkedCities = val ? cityOptions : [];
      this.isIndeterminate = false;
    },
    handleCheckedCitiesChange(value) {
      let checkedCount = value.length;
      this.checkAll = checkedCount === this.cities.length;
      this.isIndeterminate = checkedCount > 0 && checkedCount < this.cities.length;
    }
  }
};
</script>
