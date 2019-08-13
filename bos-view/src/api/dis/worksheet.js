import request from '@/utils/request'

export function accWorksheetList() {
  return request({
    url: '/worksheet/accWorksheetList',
    method: 'post'
  })
}
