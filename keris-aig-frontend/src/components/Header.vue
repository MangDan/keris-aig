<template>
  <v-app-bar app elevate-on-scroll>
    <div class="d-flex align-center">
      <router-link to="/">
        <v-img
          alt="Vuetify Logo"
          class="shrink mr-2"
          contain
          src="../assets/keris-logo1.png"
          transition="scale-transition"
          width="200"
        />
      </router-link>
    </div>
    <v-spacer></v-spacer>
    <v-img
      alt="MathGenie"
      class="shrink mr-2"
      contain
      src="../assets/mathgenie.png"
      transition="scale-transition"
      width="220"
    />
  </v-app-bar>
</template>
