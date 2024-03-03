// src/vuex/store.js
import {createStore} from "vuex"
import getters from "@/vuex/getters"
import mutations from "@/vuex/mutation"
import actions from "@/vuex/actions";

export default createStore({
  state: {
    user: null,
    isLogin: false,
  },
  mutations,
  getters,
  actions

})