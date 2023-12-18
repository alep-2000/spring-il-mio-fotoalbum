<template>
    <h1>Foto</h1>
    <ul>
        <li 
            class="list-elem"
            v-for="foto in fotos" 
            :key="foto.id"
        >
            {{ foto.titolo }}
        </li>
    </ul>
</template>

<script setup>
// IMPORT LIBS
import { defineProps } from 'vue';  

// // EMITS
// const emits = defineEmits(["openPizza"]);

// PROPS
const props = defineProps({
    fotos: {
        type: Array,
        required: true
    }
});
</script>

<style scoped>

.list-elem {
    cursor: pointer;
    list-style-type: none;
    text-decoration: underline;
}
</style>