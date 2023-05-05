import {createRouter, createWebHistory} from 'vue-router'
import AllListings from "@/view/listing/AllListings";
import Listing from "@/view/listing/Listing";
import UpdateListing from "@/view/listing/UpdateListing";
import CreateListing from "@/view/listing/CreateListing";
import AllCandidacies from "@/view/candidacy/AllCandidacies";
import Candidacy from "@/view/candidacy/Candidacy";
import UpdateCandidacy from "@/view/candidacy/UpdateCandidacy";
import CreateCandidacy from "@/view/candidacy/CreateCandidacy";

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

const candidacyPages = [
    {
        path: "/api/allcandidacies",
        name: "AllCandidacies",
        component: AllCandidacies,
    },
    {
        path: "/api/updatecandidacy/:id",
        name: "UpdateCandidacy",
        component: UpdateCandidacy,
    },
    {
        path: "/api/createcandidacy",
        name: "CreateCandidacy",
        component: CreateCandidacy,
    },
    {
        path: "/api/candidacies/:id",
        name: "Candidacy",
        component: Candidacy,
    },

]

const routes = [
    ...listingPages,
    ...candidacyPages,
]


const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router