<script setup>
// IMPORT LIBS
import { onMounted, ref } from 'vue';
import axios from 'axios';

// IMPORT COMPONENTS
import FotoIndex from './components/FotoIndex.vue';
// import PizzaShow from './components/PizzaShow.vue';
// import PizzaForm from './components/PizzaForm.vue';

// DATA
const fotos = ref(null);
const fotoActive = ref(null);
// const creatingPizza = ref(false);

// FUNCTIONS
// const openPizza = (id) => {
//   pizzas.value.forEach((pizza) => {
//     if (pizza.id === id) {
//       pizzaActive.value = pizza;
//     }
//   });
// };
// const closePizza = (update) => {
//   pizzaActive.value = null;
//   if (update) updatePizzas();
// };
// const pizzaCreated = () => {
//   creatingPizza.value = false;
//   updatePizzas();
// };
const updateFotos = async () => {
  const data = await axios.get("http://localhost:8080/api/f1.0/fotos");
  fotos.value = data.data;
};
// const deletePizza = () => {
//   pizzaActive.value = null;
//   updatePizzas();
// };

// HOOKS
onMounted(updateFotos);
</script>

<template>
  <fotos-index 
      :fotos="fotos" 
    />
</template>
