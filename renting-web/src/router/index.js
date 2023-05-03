import {createRouter, createWebHistory} from 'vue-router'
import AllListings from "@/view/AllListings";


const routes = [
    {
        path: "/api/alllistings",
        name: "AllListings",
        component: AllListings,
    },
]


const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router