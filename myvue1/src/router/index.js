import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Form from '../views/Form.vue'
import Contract from "@/views/Contract";
import Role from "@/views/Role";
import ContractById from "@/views/ContractById";
import OverDate from "@/views/OverDate";
import TotalByTime from "@/views/TotalByTime";
import TotalByUser from "@/views/TotalByUser";
import updateOverDate from "@/views/UpdateOverDate";
import Data from "@/views/Data";
import UpdateData from "@/views/UpdateData";
import UpdateInfo from "@/views/UpdateInfo";
import AddData from "@/views/AddData";
import Info from "@/views/Info";
import UpdateUser from "@/views/UpdateUser";
import Empower from "@/views/Empower";

Vue.use(VueRouter)

const routes = [
    {
        path: '/home',
        name: 'Home',
        component: Home,
        children: [
            {path: '/selectAllInfo', component: Info, name: '查询用户', menuShow: true},
            {path: '/add', component: Form, name: '添加用户', menuShow: true},
            {path: '/warn', component: OverDate, name: '超期报警', menuShow: true},
            {path: '/updateOverDate', component: updateOverDate, name: '修改超期报警数据', menuShow: false},
            {path: '/contract', component: Contract, name: '合同管理', menuShow: true},
            {path: '/contractById', component: ContractById, name: '合同详情', menuShow: false},
            {path: '/updateInfo', component: UpdateInfo, name: '修改用户', menuShow: false},
            {path: '/totalByTime', component: TotalByTime, name: '时间统计', menuShow: true},
            {path: '/totalByUser', component: TotalByUser, name: '用户统计', menuShow: true},
            {path: '/data', component: Data, name: '供气记录', menuShow: true},
            {path: '/addData', component: AddData, name: '新增记录', menuShow: false},
            {path: '/updateData', component: UpdateData, name: '修改供气记录', menuShow: false},
            {path: '/roleByUser', component: Role, name: '权限管理', menuShow: true},
            {path: '/updateUser', component: UpdateUser, name: '修改员工信息', menuShow: false},
        ]
    },
    {
        path: '/',
        name: 'Login',
        component: () => import( '../views/Login.vue')
    }

]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router
