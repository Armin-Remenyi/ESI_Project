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
//import UpdateUser from "@/view/user/UpdateUser";
//import DeleteUser from "@/view/user/DeleteUser";
import CreateCandidate from "@/view/candicacy/CreateCandidate";
import CreateHandover from "@/view/handover/CreateHandover";
import Handover from "@/view/handover/Handover";
import UpdateHandover from "@/view/handover/UpdateHandover";
import auth from "@/auth";
import LogIn from "@/view/session/LogIn";
import SignUp from "@/view/session/SignUp";


const beforeEnterPage = async (to, from, next) => {
    let authResult = await auth.authenticated();
    if (!authResult) {
        next('/api/login')
    } else {
        next();
    }
}

const listingPages = [
    {
        path: "/api/alllistings",
        name: "AllListings",
        component: AllListings,
        beforeEnter: beforeEnterPage
    },
    {
        path: "/api/updatelisting/:id",
        name: "UpdateListing",
        component: UpdateListing,
        beforeEnter: beforeEnterPage
    },
    {
        path: "/api/createlisting/:id",
        name: "CreateListing",
        component: CreateListing,
        beforeEnter: beforeEnterPage
    },
    {
        path: "/api/listing/:id",
        name: "Listing",
        component: Listing,
        beforeEnter: beforeEnterPage
    },
]

const contractPages = [
    {
        path: "/api/allcontracts",
        name: "AllContract",
        component: AllContract,
        beforeEnter: beforeEnterPage
    },
    {
        path: "/api/createcontract/:id",
        name: "CreateContract",
        component: CreateContract,
        beforeEnter: beforeEnterPage
    },
    {
        path: "/api/updatecontract/:id",
        name: "UpdateContract",
        component: UpdateContract,
        beforeEnter: beforeEnterPage
    },
    {
        path: "/api/contract/:id",
        name: "Contract",
        component: Contract,
        beforeEnter: beforeEnterPage
    },
]

const propertiesPages = [
    {
        path: "/api/allproperties",
        name: "AllProperties",
        component: AllProperties,
        beforeEnter: beforeEnterPage
    },
    {
        path: "/api/property/:id",
        name: "Property",
        component: Property,
        beforeEnter: beforeEnterPage
    },
    {
        path: "/api/createproperty",
        name: "CreateProperty",
        component: CreateProperty,
        beforeEnter: beforeEnterPage
    },
    {
        path: "/api/updateproperty/:id",
        name: "UpdateProperty",
        component: UpdateProperty,
        beforeEnter: beforeEnterPage
    },
]

const usersPages = [
    {
        path: "/api/user",
        name: "User",
        component: User,
        beforeEnter: beforeEnterPage
    },
    {
        path: "/api/createuser",
        name: "CreateUser",
        component: CreateUser,
    },
    // {
    //     path: "/api/updateuser/:id",
    //     name: "UpdateUser",
    //     component: UpdateUser,
    //     beforeEnter: beforeEnterPage
    // },
    {
        path: "/api/createcandidate/:id",
        name: "CreateCandidate",
        component: CreateCandidate,
        beforeEnter: beforeEnterPage
    },
]

const candidacyPages = [
    {
        path: "/api/createcandidate/:id",
        name: "CreateCandidate",
        component: CreateCandidate,
        beforeEnter: beforeEnterPage
    },
]

const handoverPages = [
    {
        path: "/api/createhandover/:id",
        name: "CreateHandover",
        component: CreateHandover,
        beforeEnter: beforeEnterPage
    },
    {
        path: "/api/handover/:id",
        name: "Handover",
        component: Handover,
        beforeEnter: beforeEnterPage
    },
    {
        path: "/api/updatehandover/:id",
        name: "UpdateHandover",
        component: UpdateHandover,
        beforeEnter: beforeEnterPage
    },
]

const publicPages = [
    {
        path: "/api/login",
        name: "LogIn",
        component: LogIn,
        beforeEnter: async (to, from, next) => {
            let authResult = await auth.authenticated();
            if (authResult) {
                next('/api/alllistings')
            } else {
                next();
            }
        }
    },
    {
        path: "/api/signup",
        name: "SignUp",
        component: SignUp,
        beforeEnter: async (to, from, next) => {
            let authResult = await auth.authenticated();
            if (authResult) {
                next('/api/alllistings')
            } else {
                next();
            }
        }
    },
]

const routes = [
    ...listingPages,
    ...contractPages,
    ...propertiesPages,
    ...usersPages,
    ...candidacyPages,
    ...handoverPages,
    ...publicPages,
]


const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router