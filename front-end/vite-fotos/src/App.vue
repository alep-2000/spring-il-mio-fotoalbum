<script setup>
// IMPORT LIBS
import { onMounted, ref } from 'vue';
import axios from 'axios';

// IMPORT COMPONENTS
import FotoIndex from './components/FotoIndex.vue';
import FotoShow from './components/FotoShow.vue';

// DATA
const fotos = ref(null);
const fotoActive = ref(null);

// FUNCTIONS
const openFoto = (id) => {
  fotos.value.forEach((foto) => {
    if (foto.id === id) {
      fotoActive.value = foto;
    }
  });
};
const closeFoto = (update) => {
  fotoActive.value = null;
  if (update) updateFotos();
};

const updateFotos = async () => {
  const data = await axios.get("http://localhost:8080/api/f1.0/fotos");
  fotos.value = data.data;
};

// HOOKS
onMounted(updateFotos);
</script>

<template>
  <foto-index 
      v-if="fotoActive == null"
      :fotos="fotos" 
      @open-foto="openFoto"
    />
    <foto-show 
        v-else
        :foto="fotoActive"
        @close-foto="closeFoto"
      />
</template>
