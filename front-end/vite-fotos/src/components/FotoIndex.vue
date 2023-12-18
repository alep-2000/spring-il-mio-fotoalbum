
<script setup>
// IMPORT LIBS
import { defineProps } from 'vue'; 

// EMITS
const emits = defineEmits(["openFoto"]);

// PROPS
const props = defineProps({
    fotos: {
        type: Array,
        required: true
    }
});
</script>

<template>
    <h1>Foto</h1>
    <ul>
        <li 
            class="list-elem"
            v-for="foto in fotos" 
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