import request from '@/utils/request'

export function disWorkOrderSignList(curPage,pageSize) {
  return request({
    url: '/workOrderSign/disWorkOrderSignList',
    method: 'post',
    params:{ curPage,pageSize }
  })
}

export function conditionDisWorkordersignList(curPage,pageSize,workorderid,worksheetno) {
  return request({
    url: '/workOrderSign/conditionDisWorkordersignList',
    method: 'post',
    params:{ curPage,pageSize,workorderid,worksheetno }
  })
}

export function updateDisWorkOrderSign(disWorkordersign) {
  return request({
    url: '/workOrderSign/updateDisWorkOrderSign',
    method: 'post',
    data:disWorkordersign
  })
}

export function addDisWorkOrderSign(disWorkordersign) {
  return request({
    url: '/workOrderSign/addDisWorkOrderSign',
    method: 'post',
    data:disWorkordersign
  })
}

export function applyfor(disWorkordersign) {
  return request({
    url: '/workOrderSign/applyfor',
    method: 'post',
    data:disWorkordersign
  })
}


export function notarize(disWorkordersign) {
  return request({
    url: '/workOrderSign/notarize',
    method: 'post',
    data:disWorkordersign
  })
}

export function cancellation(disWorkordersign) {
  return request({
    url: '/workOrderSign/cancellation',
    method: 'post',
    data:disWorkordersign
  })
}
