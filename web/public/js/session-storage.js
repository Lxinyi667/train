// 所有的session key 都在这里统一定义，可以避免多个功能使用同一个key
SESSION_ORDER = 'SESSION_ORDER'
SESSION_TICKET_PARAMS = 'SESSION_TICKET_PARAMS'

// eslint-disable-next-line no-undef
SessionStorage = {
  get: function (key) {
    const v = sessionStorage.getItem(key)
    if (v && typeof (v) !== 'undefined' && v !== 'undefined') {
      return JSON.parse(v)
    }
  },
  set: function (key, data) {
    sessionStorage.setItem(key, JSON.stringify(data))
  },
  remove: function (key) {
    sessionStorage.removeItem(key)
  },
  clearAll: function () {
    sessionStorage.clear()
  }
}
