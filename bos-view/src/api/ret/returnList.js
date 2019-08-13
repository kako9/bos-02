import request from '@/utils/request'

export function returnListList(curPage,pageSize) {
  return request({
    url: '/returnList/returnListList',
    method: 'post',
    params:{ curPage,pageSize }
  })
}

export function getRetReturnListListTerm(curPage,pageSize,applicationno,worksheetno) {
  return request({
    url: '/returnList/getRetReturnListListTerm',
    method: 'post',
    params:{ curPage,pageSize,applicationno,worksheetno }
  })
}

export function cancellation(retReturnList) {
  return request({
    url: '/returnList/cancellation',
    method: 'post',
    data: retReturnList
  })
}

export function updateRetReturnList(retReturnList) {
  return request({
    url: '/returnList/updateRetReturnList',
    method: 'post',
    data: retReturnList
  })
}

export function addRetReturnList(retReturnList) {
  return request({
    url: '/returnList/addRetReturnList',
    method: 'post',
    data: retReturnList
  })
}

export function confirmation(retReturnList) {
  return request({
    url: '/returnList/confirmation',
    method: 'post',
    data: retReturnList
  })
}

export function returnTheGoods(retReturnList) {
  return request({
    url: '/returnList/returnTheGoods',
    method: 'post',
    data: retReturnList
  })
}

export function refuse(retReturnList) {
  return request({
    url: '/returnList/refuse',
    method: 'post',
    data: retReturnList
  })
}
