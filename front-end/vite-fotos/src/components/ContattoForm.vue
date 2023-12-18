<script setup>
// IMPORT LIBS
import { ref } from 'vue';
import axios from 'axios';

// DATA
const contatto = ref({
    nome: '',
    email: '',
    messaggio: ''
});

// FUNCTIONS
const sendMessage = async () => {
    try {
    const response = await axios.post('http://localhost:8080/contatti', { contatto: contatto.value });
    console.log(response);
  } catch (error) {

    console.error(error);
  }
};
</script>

<template>
    <div class="col-12 border rounded-5 shadow my-5">
        <div class="row px-5">
            <div class="col-12 text-center py-3">
                <form @submit.prevent="sendMessage">
                    <div class="input-group my-3">
                        <span class="input-group-text" id="basic-addon2">Nome</span>
                        <input type="text" id="nome" class="form-control" v-model="contatto.nome" required>
                    </div>
                    <div class="input-group my-3">
                        <span class="input-group-text" id="basic-addon2">Email</span>
                        <input type="email" id="email" class="form-control" v-model="contatto.email" required>
                    </div>
                    <div class="input-group my-3">
                        <span class="input-group-text" id="basic-addon2">Testo</span>
                        <textarea type="text" id="messaggio" class="form-control" v-model="contatto.messaggio"
                            required></textarea>
                    </div>
                    <button type="submit" class="btn btn-success my-4">Invia</button>
                </form>
            </div>
        </div>
    </div>
</template>