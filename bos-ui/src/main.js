import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui' // 导入elementui的js
import 'element-ui/lib/theme-chalk/index.css' // elementui样式
import api from './http/index'
Vue.config.productionTip = false
Vue.use(ElementUI) // 使用ElementUI
Vue.use(api) // 使用自己的插件

new Vue({
  el: '#app',
  router,
  render: h => h(App) // 用于渲染ElementUI组件
})
