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
  fullscreenEl: false, //�����Ƿ���ʾ���Ͻ�ȫ����ť
  closeEl: false, //�����Ƿ���ʾ���Ͻǹرհ�ť
  tapToClose: true, //�����������Ӧ�ر�ͼ��
  shareEl: false, //�����Ƿ���ʾ����ť
  zoomEl: false, //�����Ƿ���ʾ�Ŵ���С��ť
  counterEl: false, //�����Ƿ���ʾ���Ͻ�ͼƬ������ť
  arrowEl: true,  //������ͼ�����Ҽ�ͷ��pc�����ģ���ֻ�ʱ��
  tapToToggleControls: true, //���Ӧ�л��ؼ��Ŀɼ���
  clickToCloseNonZoomable: true //���ͼƬӦ�ر�ͼ�⣬����ͼ��С���ӿڵĴ�Сʱ
})

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
