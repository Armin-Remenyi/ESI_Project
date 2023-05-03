import {createRouter, createWebHistory} from 'vue-router'
import AllListings from "@/view/listing/AllListings";
import Listing from "@/view/listing/Listing";
import UpdateListing from "@/view/listing/UpdateListing";
import CreateListing from "@/view/listing/CreateListing";

const listingPages = [
    {
        path: "/api/alllistings",
        name: "AllListings",
        component: AllListings,
    },
    {
        path: "/api/updatelisting/:id",
        name: "UpdateListing",
        component: UpdateListing,
    },
    {
        path: "/api/createlisting",
        name: "CreateListing",
        component: CreateListing,
    },
    {
        path: "/api/listing/:id",
        name: "Listing",
        component: Listing,
    },
]

const routes = [
    ...listingPages,
]


const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router