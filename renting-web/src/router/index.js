import {createRouter, createWebHistory} from 'vue-router'
import AllListings from "@/view/listing/AllListings";
import Listing from "@/view/listing/Listing";
import Contract from "@/view/contract/Contract";
import UpdateListing from "@/view/listing/UpdateListing";
import CreateListing from "@/view/listing/CreateListing";
import AllContract from "@/view/contract/AllContract";
import CreateContract from "@/view/contract/CreateContract";
import UpdateContract from "@/view/contract/UpdateContract";
import AllProperties from "@/view/property/AllProperties";
import Property from "@/view/property/Property";
import CreateProperty from "@/view/property/CreateProperty";
import UpdateProperty from "@/view/property/UpdateProperty";
import User from "@/view/user/User";
import CreateUser from "@/view/user/CreateUser";
import UpdateUser from "@/view/user/UpdateUser";
//import DeleteUser from "@/view/user/DeleteUser";
import CreateCandidate from "@/view/candicacy/CreateCandidate";
import CreateHandover from "@/view/handover/CreateHandover";
import Handover from "@/view/handover/Handover";
import UpdateHandover from "@/view/handover/UpdateHandover";

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
        path: "/api/createlisting/:id",
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

const propertiesPages = [
    {
        path: "/api/allproperties",
        name: "AllProperties",
        component: AllProperties,
    },
    {
        path: "/api/property/:id",
        name: "Property",
        component: Property,
    },
    {
        path: "/api/createproperty",
        name: "CreateProperty",
        component: CreateProperty,
    },
    {
        path: "/api/updateproperty/:id",
        name: "UpdateProperty",
        component: UpdateProperty,
    },
]

const usersPages = [
    {
        path: "/api/user/:id",
        name: "User",
        component: User,
    },
    {
        path: "/api/createuser",
        name: "CreateUser",
        component: CreateUser,
    },
    {
        path: "/api/updateuser/:id",
        name: "UpdateUser",
        component: UpdateUser,
    },
    {
        path: "/api/createcandidate/:id",
        name: "CreateCandidate",
        component: CreateCandidate,
    },
]

const candidacyPages = [
    {
        path: "/api/createcandidate/:id",
        name: "CreateCandidate",
        component: CreateCandidate,
    },
]

const handoverPages = [
    {
        path: "/api/createhandover/:id",
        name: "CreateHandover",
        component: CreateHandover,
    },
    {
        path: "/api/handover/:id",
        name: "Handover",
        component: Handover,
    },
    {
        path: "/api/updatehandover/:id",
        name: "UpdateHandover",
        component: UpdateHandover,
    },
]

const routes = [
    ...listingPages,
    ...contractPages,
    ...propertiesPages,
    ...usersPages,
    ...candidacyPages,
    ...handoverPages,
]


const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router