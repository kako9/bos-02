import request from '@/utils/request'

export function transferSmsDQ(zonecode) {
  return request({
    url: '/zoneInfo/transferSms',
    method: 'post',
    params:{zonecode }
  })
}

export function basZoneInfoList() {
  return request({
    url: '/zoneInfo/basZoneInfoList',
    method: 'post'
  })
}
