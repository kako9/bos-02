import request from '@/utils/request'

export function getGroupDept() {
  return request({
    url: '/dept/deptList',
    method: 'post'
  })
}

export function updateDept(dept) {
  return request({
    url: '/dept/updateDept',
    method: 'post',
    data:dept
  })
}

export function addDept(dept) {
  return request({
    url: '/dept/addDept',
    method: 'post',
    data:dept
  })
}

export function deleteDept(id) {
  return request({
    url: '/dept/deleteDept',
    method: 'post',
    params:{id}
  })
}

export function getList(curPage,pageSize) {
  return request({
    url: '/dept/getList',
    method: 'post',
    params:{curPage,pageSize}
  })
}

export function getByName(name,curPage,pageSize) {
  return request({
    url: '/dept/getByName',
    method: 'post',
    params:{name,curPage,pageSize}
  })
}

export function getByParentId(parentId) {
  return request({
    url: '/dept/getByParentId',
    method: 'post',
    params:{parentId}
  })
}

export function getByParentIdSysDept() {
  return request({
    url: '/dept/getByParentIdSysDept',
    method: 'post'
  })
}


