import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  routes: [

    {
      path: '/Home',
      component: resolve => require(['../views/Home.vue'], resolve),
      meta: { title: '自述文件' },
      children: [
        {
          path: '/Info',
          component: resolve => require(['../views/InfoPage.vue'], resolve),
          meta: { title: 'Info' }
        },
        {
          path: '/Consumer',
          component: resolve => require(['../views/Consumer.vue'], resolve),
          meta: { title: 'Consumer' }
        }
      ]
    },

    {
      path: '/',
      component: resolve => require(['../views/Login.vue'], resolve)
    }

  ]
})
