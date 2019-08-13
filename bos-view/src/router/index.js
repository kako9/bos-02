import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

/* Layout */
import Layout from '@/layout'

// Router Modules

/**
 * 注意: 子菜单出现只在 route children.length >= 1
 * Detail see: https://panjiachen.github.io/vue-element-admin-site/guide/essentials/router-and-nav.html
 *
 * hidden: true                   if set true, item will not show in the sidebar(default is false)
 * alwaysShow: true               if set true, will always show the root menu
 *                                if not set alwaysShow, when item has more than one children route,
 *                                it will becomes nested mode, otherwise not show the root menu
 * redirect: noRedirect           if set noRedirect will no redirect in the breadcrumb
 * name:'router-name'             the name is used by <keep-alive> (must set!!!)
 * meta : {
    roles: ['admin','editor']    control the page roles (you can set multiple roles)
    title: 'title'               the name show in sidebar and breadcrumb (recommend set)
    icon: 'svg-name'             the icon show in the sidebar
    noCache: true                if set true, the page will no be cached(default is false)
    affix: true                  if set true, the tag will affix in the tags-view
    breadcrumb: false            if set false, the item will hidden in breadcrumb(default is true)
    activeMenu: '/example/list'  if set path, the sidebar will highlight the path you set
  }
 */

/**
 * constantRoutes
 * a base page that does not have permission requirements
 * all roles can be accessed
 */
export const constantRoutes = [
  {
    path: '/redirect',
    component: Layout,
    hidden: true,
    children: [
      {
        path: '/redirect/:path*',
        component: () => import('@/views/redirect/index')
      }
    ]
  },
  {
    path: '/login',
    component: () => import('@/views/login/index'),
    hidden: true
  },
  {
    path: '/auth-redirect',
    component: () => import('@/views/login/auth-redirect'),
    hidden: true
  },
  {
    path: '/404',
    component: () => import('@/views/error-page/404'),
    hidden: true
  },
  {
    path: '/401',
    component: () => import('@/views/error-page/401'),
    hidden: true
  },
  {
    path: '/',
    component: Layout,
    redirect: '/dashboard',
    children: [
      {
        path: 'dashboard',
        component: () => import('@/views/dashboard/index'),
        name: 'Dashboard',
        meta: { title: '主页', icon: 'dashboard', affix: true }
      }
    ]
  }
]

/**
 * asyncRoutes
 * the routes that need to be dynamically loaded based on user roles
 */
export const asyncRoutes = [
  {
    path: '/permission',
    component: Layout,
    redirect: '/permission/page',
    alwaysShow: true, // will always show the root menu
    name: 'sys',
    meta: {
      title: '系统管理',
      icon: 'user',
      roles: ['admin', 'editor'] // you can set roles in root nav
    },
    children: [
      {
        path: 'page',
        component: () => import('@/views/sys/user'),
        name: 'user',
        meta: {
          title: '用户管理',
          roles: ['admin'] // or you can only set roles in sub nav
        }
      },
      {
        path: 'role',
        component: () => import('@/views/sys/role'),
        name: 'role',
        meta: {
          title: '角色管理'
          // if do not set roles, means: this page does not require permission
        }
      },
      {
        path: 'menu',
        component: () => import('@/views/sys/menu'),
        name: 'menu',
        meta: {
          title: '菜单管理',
          roles: ['admin']
        }
      },
      {
        path: 'dept',
        component: () => import('@/views/sys/dept'),
        name: 'dept',
        meta: {
          title: '部门管理',
          roles: ['admin']
        }
      }
    ]
  },
  {
    path: '/record',
    component: Layout,
    redirect: '/record/page',
    alwaysShow: true, // will always show the root menu
    name: 'example',
    meta: {
      title: '基础档案',
      icon: 'skill',
      roles: ['admin','dev'] // you can set roles in root nav
    },
    children: [
      {
        path: '/basicFileSetting',
        component: () => import('@/views/table/complex-table'),
        name: 'Setting',
        meta: {
          title: '基础档案设置',
          roles: ['dev'] // or you can only set roles in sub nav
        }
      },
      {
        path: 'pickStandard',
        component: () => import('@/views/table/complex-table'),
        name: 'pick',
        meta: {
          title: '收派标准',
          roles: ['admin','dev']
          // if do not set roles, means: this page does not require permission
        }
      },
      {
        path: 'trainSet',
        component: () => import('@/views/table/complex-table'),
        name: 'trainSet',
        meta: {
          title: '班车设置',
          roles: ['dev']
        }
      }
    ]
  },
  {
    path: '/dispatch',
    component: Layout,
    redirect: '/dispatch/page',
    alwaysShow: true, // will always show the root menu
    name: 'dis',
    meta: {
      title: '调度',
      icon: 'skill',
      roles: ['admin','dev'] // you can set roles in root nav
    },
    children: [
      {
        path: '/check',
        component: () => import('@/views/dis/check'),
        name: 'check',
        meta: {
          title: '查台转单',
          roles: ['admin','dev'] // or you can only set roles in sub nav
        }
      },
      {
        path: '/artificial',
        component: () => import('@/views/dis/artificial'),
        name: 'artificial',
        meta: {
          title: '人工调度',
          roles: ['admin','dev']
          // if do not set roles, means: this page does not require permission
        }
      },
      {
        path: '/sign',
        component: () => import('@/views/dis/sign'),
        name: 'sign',
        meta: {
          title: '签收录入',
          roles: ['admin','dev']
        }
      },
      {
        path: '/cancel',
        component: () => import('@/views/dis/cancel'),
        name: 'cancel',
        meta: {
          title: '取消签收申请确认',
          roles: ['admin','dev']
        }
      },
      {
        path: '/publicity',
        component: () => import('@/views/dis/publicity'),
        name: 'publicity',
        meta: {
          title: '宣传录入',
          roles: ['admin','dev']
        }
      }
    ]
  },
  {
    path: '/Return',
    component: Layout,
    redirect: '/Return/page',
    alwaysShow: true, // will always show the root menu
    name: 'ret',
    meta: {
      title: '返货',
      icon: 'skill',
      roles: ['admin','dev'] // you can set roles in root nav
    },
    children: [
      {
        path: '/apply',
        component: () => import('@/views/ret/apply'),
        name: 'apply',
        meta: {
          title: '返货申请',
          roles: ['admin','dev'] // or you can only set roles in sub nav
        }
      },
      {
        path: '/affirm',
        component: () => import('@/views/ret/affirm'),
        name: 'affirm',
        meta: {
          title: '返货申请确认',
          roles: ['admin','dev']
          // if do not set roles, means: this page does not require permission
        }
      },
      {
        path: '/generate',
        component: () => import('@/views/ret/generate'),
        name: 'generate',
        meta: {
          title: '生成返货单',
          roles: ['admin','dev']
        }
      }
    ]
  },
  /** when your routing map is too long, you can split it into small modules **/
  {
    path: '/pdf/download',
    component: () => import('@/views/pdf/download'),
    hidden: true
  },
  // 404 page must be placed at the end !!!
  { path: '*', redirect: '/404', hidden: true }
]
const createRouter = () => new Router({
  // mode: 'history', // require service support
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRoutes
})

const router = createRouter()

// Detail see: https://github.com/vuejs/vue-router/issues/1234#issuecomment-357941465
export function resetRouter() {
  const newRouter = createRouter()
  router.matcher = newRouter.matcher // reset router
}

export default router

