import {createRouter, createWebHistory} from 'vue-router'
import AllListings from "@/view/listing/AllListings";
import Listing from "@/view/listing/Listing";
import Contract from "@/view/contract/Contract";
import UpdateListing from "@/view/listing/UpdateListing";
import CreateListing from "@/view/listing/CreateListing";
import AllContract from "@/view/contract/AllContract";
import CreateContract from "@/view/contract/CreateContract";
import UpdateContract from "@/view/contract/UpdateContract";

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

const contractPages = [
    {
        path: "/api/allcontracts",
        name: "AllContract",
        component: AllContract,
    },
    {
        path: "/api/createcontract/:id",
        name: "CreateContract",
        component: CreateContract,
    },
    {
        path: "/api/updatecontract/:id",
        name: "UpdateContract",
        component: UpdateContract,
    },
    {
        path: "/api/contract/:id",
        name: "Contract",
        component: Contract,
    },
]

const routes = [
    ...listingPages,
    ...contractPages,
]


const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router