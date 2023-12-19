
<script setup>
// // IMPORT LIBS
// import { defineProps } from 'vue'; 





// // PROPS
// const props = defineProps({
//     fotos: {
//         type: Array,
//         required: true
//     }
// });

import { ref } from 'vue';
import axios from 'axios';

const fotos = ref([]);
const filter = ref('');

// IMPORT COMPONENTS
import ContattoForm from './ContattoForm.vue';

// EMITS
const emits = defineEmits(["openFoto"]);

// Metodo per filtrare le foto
const filterFotos = async () => {
    try {
        const response = await axios.get('/api/f1.0/fotos/filter', {
            params: { filter: filter.value }
        });
        fotos.value = response.data; 
    } catch (error) {
        console.error('Errore durante il filtraggio delle foto', error);
    }
};

// Metodo per ottenere tutte le foto
// const getAllPhotos = async () => {
//     try {
//         const response = await axios.get('/api/f1.0/fotos');
//         fotos.value = response.data; 
//     } catch (error) {
//         console.error('Errore durante il recupero di tutte le foto', error);
//     }
// };

// getAllPhotos();
</script>

<template>
    <h1>Foto</h1>
    <form @submit.prevent="filterFotos">
        <label for="filter">Ricerca per Titolo:</label>
        <input v-model="filter" id="filter" name="filter" />
        <button type="submit">Cerca</button>
    </form>
    <contatto-form/>
    <ul>
        <li 
            class="list-elem"
            v-for="foto in filterFotos" 
            :key="foto.id"
            @click="$emit('openFoto', foto.id)"
        >
            {{ foto.titolo }}
        </li>
    </ul>
</template>

<style scoped>

.list-elem {
    cursor: pointer;
    list-style-type: none;
    text-decoration: underline;
}
</style>