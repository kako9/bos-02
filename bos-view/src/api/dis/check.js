import request from '@/utils/request'

export function queryAccBusinessadmissibilityAndAccWorkorderList(curPage,pageSize) {
  return request({
    url: '/check/list',
    method: 'post',
    params:{ curPage,pageSize }
  })
}

export function queryAccBusinessadmissibilityAndAccWorkorderCondition(curPage,pageSize,telphone,businessnoticeno) {
  return request({
    url: '/check/listCondition',
    method: 'post',
    params:{ curPage,pageSize,telphone,businessnoticeno }
  })
}

export function updateAccBusinessadmissibilityAndAccWorkorder(accBusinessadmissibility) {
  return request({
    url: '/check/update',
    method: 'post',
    data: accBusinessadmissibility
  })
}

export function singlePin(accBusinessadmissibility) {
  return request({
    url: '/check/singlePin',
    method: 'post',
    data: accBusinessadmissibility
  })
}

export function basAssociatememberList() {
  return request({
    url: '/associa/basAssociatememberList',
    method: 'post'
  })
}

export function transferSmallPart(empno) {
  return request({
    url: '/associa/transferSmallPart',
    method: 'post',
    params:{empno}
  })
}



