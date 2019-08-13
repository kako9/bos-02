import request from '@/utils/request'

export function singlePinAndAdd(accWorkorder) {
  return request({
    url: '/workorder/singlePinAndAdd',
    method: 'post',
    data:accWorkorder
  })
}

export function singlePin(accWorkorder) {
  return request({
    url: '/workorder/singlePin',
    method: 'post',
    data: accWorkorder
  })
}


export function sendBack(accWorkorder) {
  return request({
    url: '/workorder/sendBack',
    method: 'post',
    data: accWorkorder
  })
}

export function allocation(accWorkorder,deptId) {
  return request({
    url: '/workorder/allocation',
    method: 'post',
    data: accWorkorder,
    params:{deptId}
  })
}
