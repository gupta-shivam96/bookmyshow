import {createRouter,createWebHistory} from 'vue-router'
import HomePage from '../components/HomePage'
import MoviePage from '../components/MoviePage'

const routes=[
    {
        path:'/',
        name:'Home',
        component: HomePage
    },
    {
        path:'/movie/:movieName',
        name:'Movie',
        component: MoviePage
        
    }
]
const router=createRouter({
    history:createWebHistory(),
    routes
})

export default router