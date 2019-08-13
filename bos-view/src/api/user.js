import request from '@/utils/request'

export function login(data) {
  console.debug("api里的user里的login方法")
  return request({
    url: '/users/login',
    method: 'post',
    data
  })
}

export function getInfo(token) {
  return request({
    url: '/users/info',
    method: 'post',
    params: { token }
  })
}

export function logout() {
  return request({
    url: '/users/logout',
    method: 'post'
  })
}
