<template lang="">
    <div v-if="!fotoUpdate"  >
        <h1>
            Foto: {{ myFoto.titolo }}
            <span 
                class="link"
                @click="$emit('closeFoto', myFoto != foto)">
                X
            </span>
        </h1>
        <p>Visibilità: {{ myFoto.visibile }}</p>
        <span>{{ myFoto.descrizione }}</span>
        <br>
        <br>
        <img :src="myFoto.url" alt="foto image" >
        <br>
    </div>
</template>

<script setup>
// IMPORT LIBS
import { ref } from 'vue';


// PROPS
const props = defineProps({
    foto: {
        type: Object,
        required: true
    }
});

// EMITS
const emits = defineEmits(["closeFoto"]);

// DATA
const fotoUpdate = ref(false);
const myFoto = ref(props.foto);

//FUNCTIONS
const updatedFoto = (newFoto) => {
    fotoUpdate.value = false;
    myFoto.value = newFoto;
}

</script>

<style scoped>
    .link {
    cursor: pointer;
    text-decoration: underline;
}
</style>