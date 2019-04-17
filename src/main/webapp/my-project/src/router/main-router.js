import Vue from 'vue'
import VueRouter from 'vue-router'
import HelloWorld from '../components/HelloWorld'
import HelloWorld2 from '../components/HelloWorld2'

Vue.use(VueRouter)

const router = new VueRouter({
    routes: [
        // dynamic segments start with a colon
        {path: '/', redirect: '/home'},
        {name: 'home', path: '/home', component: HelloWorld},
        {name: 'home2', path: '/home2', component: HelloWorld2},

    ]
});

export default router