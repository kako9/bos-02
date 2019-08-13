import request from '@/utils/request'

export function roleList(curPage,pageSize) {
  return request({
    url: '/role/roleList',
    method: 'post',
    params:{ curPage,pageSize }
  })
}

export function addRole(role) {
  return request({
    url: '/role/addRole',
    method: 'post',
    data:role
  })
}

export function updateRole(role) {
  return request({
    url: '/role/updateRole',
    method: 'post',
    data:role
  })
}

export function deleteRole(id) {
  return request({
    url: '/role/deleteRole',
    method: 'post',
    params:{ id }
  })
}

export function getByName(name,curPage,pageSize) {
  return request({
    url: '/role/getByName',
    method: 'post',
    params:{ name,curPage,pageSize}
  })
}

export function getRoleList() {
  return request({
    url: '/role/getRoleList',
    method: 'post'
  })
}
