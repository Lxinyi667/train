SESSION_ALL_TRAIN = 'SESSION_ALL_TRAIN'
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
