import request from '@/utils/request'

export function retry(accWorkorder) {
  return request({
    url: '/associa/retry',
    method: 'post',
    data:accWorkorder
  })
}
