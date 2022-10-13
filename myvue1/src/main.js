import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import Element from "element-ui"
import "element-ui/lib/theme-chalk/index.css"
import axios from 'axios'
Vue.prototype.$axios=axios

import VueDirectiveImagePreviewer from 'vue-directive-image-previewer'
import 'vue-directive-image-previewer/dist/assets/style.css'
Vue.use(VueDirectiveImagePreviewer)
Vue.use(Element)
Vue.config.productionTip = false

import preview from 'vue-photo-preview'
import 'vue-photo-preview/dist/skin.css'
Vue.use(preview,{
  fullscreenEl: false, //控制是否显示右上角全屏按钮
  closeEl: false, //控制是否显示右上角关闭按钮
  tapToClose: true, //点击滑动区域应关闭图库
  shareEl: false, //控制是否显示分享按钮
  zoomEl: false, //控制是否显示放大缩小按钮
  counterEl: false, //控制是否显示左上角图片数量按钮
  arrowEl: true,  //控制如图的左右箭头（pc浏览器模拟手机时）
  tapToToggleControls: true, //点击应切换控件的可见性
  clickToCloseNonZoomable: true //点击图片应关闭图库，仅当图像小于视口的大小时
})

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
