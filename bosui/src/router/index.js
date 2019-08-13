import Vue from 'vue'
import Router from 'vue-router'
import Cookies from 'js-cookie'

Vue.use(Router)

  const router = new Router({
    routes: [
      {
        path: '/',
        redirect: '/home'
      },
      {
        path: '/home',
        component: () => import('../views/home/Home'),
        hidden: true
      },
      {
        path: '/login',
        component: () => import('../views/login/Login'),
        hidden: true
      }
      ,{
        path: '/404',component: () => import('../views/404'),
        hidden: true
      }
    ]
  })
router.beforeEach((to,from,next) => {
  // 登录成功后，会把用户信息保存在会话
  // 存在时间为会话生命周期，页面关闭即失效
  let user = sessionStorage.getItem('user')
  // 如果是登录
  if (to.path == '/login') {
    if (user) {
      // 会话里存在用户信息,代表已经登录，跳转到首页
      next({ path: '/'})
    } else {
      // 放行
      next()
    }
  } else {
    // 不是登录，用户信息不存在，去登录
    if (!user) {
      next({ path: '/login'})
    } else {
      // 存在用户信息，放行
      next()
    }
  }
})
export default router
