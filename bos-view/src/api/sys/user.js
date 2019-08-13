import request from '@/utils/request'

export function addUser(user) {
  return request({
    url: '/users/addUser',
    method: 'post',
    data: user
  })
}

export function userList(curPage,pageSize) {
  return request({
    url: '/users/userList',
    method: 'post',
    params:{ curPage,pageSize }
  })
}

export function deleteUser(id) {
  return request({
    url: '/users/deleteUser',
    method: 'post',
    params: { id }
  })
}

export function updateUser(user) {
  return request({
    url: '/users/updateUser',
    method: 'post',
    data: user
  })
}

export function getByName(ByName,curPage,pageSize) {
  return request({
    url: '/users/getByName',
    method: 'post',
    params: { ByName,curPage,pageSize }
  })
}

export function logout() {
  return request({
    url: '/user/logout',
    method: 'get'
  })
}

export function roleList(userId) {
  return request({
    url: '/user/roleList',
    method: 'post',
    params: { userId }
  })
}


