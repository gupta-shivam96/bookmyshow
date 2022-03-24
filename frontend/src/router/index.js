import {createRouter,createWebHistory} from 'vue-router'
import HomePage from '../components/HomePage'
import MoviePage from '../components/MoviePage'
import TheaterPage from '../components/TheaterPage'
import TicketArrange from '../components/TicketArrange'
const routes=[
    {
        path:'/',
        name:'Home',
        component: HomePage
    },
    {
        path:'/movie/:cityName/:movieName',
        name:'Movie',
        component: MoviePage
        
    },
    {
        path:'/theater/:cityName/:movieName',
        name:'Theater',
        component: TheaterPage
        
    },
    {
        path:'/ticketarrange',
        name:'TicketArrange',
        component: TicketArrange
        
    }
]
const router=createRouter({
    history:createWebHistory(),
    routes
})

export default router