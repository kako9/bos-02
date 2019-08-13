import request from '@/utils/request'

export function menuList() {
  return request({
    url: '/menu/menuList',
    method: 'post'
  })
}

export function addMenu(menu) {
  return request({
    url: '/menu/addMenu',
    method: 'post',
    data:menu
  })
}

export function deleteMenu(id) {
  return request({
    url: '/menu/deleteMenu',
    method: 'post',
    params:{id}
  })
}

export function updateMenu(menu) {
  return request({
    url: '/menu/updateMenu',
    method: 'post',
    data:menu
  })
}
