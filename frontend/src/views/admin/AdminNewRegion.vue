<template>
    <div class="AdminNewRegion">
        <Backbutton>Tillbaka</Backbutton>
      <h2>Skapa ett nytt område</h2>
      <form @submit.prevent="createNewRegion" class="location__form">
            <input v-model="name" placeholder="Namn"/>
            <textarea v-model="text" placeholder="Text"/>
            <input type="file" placeholder="Image" @change="fileSelected"/>
      <button type="submit">Skapa ny plats</button>
        </form>
    </div>
  </template>

  <script>
    import axios from 'axios'
    import Backbutton from '../../components/BackButton.vue'

  export default {
    components: {
    Backbutton,
    },
    data() {
      return {
        name: "", 
        text: "",
        image: null,
      }
    },
    methods: {
        fileSelected(e) {
        this.image = e.target.files[0];
        },
        async createNewRegion(e) {
            const formData = new FormData();
            formData.append('name', this.name);
            formData.append('text', this.text);
            formData.append('file', this.image);
            const response = await axios.post('http://localhost:8080/region', formData, {
                headers: {
                    'content-type': 'multipart/form-data',
                    Authorization: localStorage.getItem('token')
                }
                }
            )
            this.$router.push({ path: '/admin', replace: true })
        }
    }
    
  }
  </script>

  <style scoped>

  .AdminNewRegion {
    display: flex;
    flex-direction: column;
    align-items: center;
    margin-bottom: 2rem;
  }

  .location__form {
    display: flex;
    flex-direction: column;
    align-items: center;
    }

    form label {
	font-size:14px;
	color:black;
	cursor:pointer;
}

form input {
	margin:15px 0;
	padding:15px 10px;
	width:100%;
	outline:none;
	border:1px solid #bbb;
	display:inline-block;
	box-sizing:border-box;
	transition:0.2s ease all;
}

form textarea {
    margin:15px 0;
	padding:15px 10px;
	width:100%;
	outline:none;
	border:1px solid #bbb;
	display:inline-block;
	box-sizing:border-box;
	transition:0.2s ease all;
    font-size: 16px;
    font-family: sans-serif;
}

   .activeRegion {
    color: green;
    text-decoration: underline;
    text-shadow: 0px 0px 1px green;
    transform: scale(1.2,1.2);
   }

   .activeTag {
    transform: scale(1.25,1.25);
    }

  .admin__regionContainer {
    width: 80%;
    display: flex;
    justify-content: center;
  }

  .admin__region {
    padding: 0px 20px;
  }

  .admin__tagContainer {
    width: 80%;
    display: flex;
    justify-content: center;
    padding: 15px;
  }


  .tag:hover {
    cursor: pointer;
  }

  input {
  display: block;
  width: 350px;
  margin: 20px auto;
  padding: 10px 45px;
  font-size: 16px;
  border: none;
  border-radius: 5px;
  box-shadow: rgba(50, 50, 93, 0.25) 0px 2px 5px -1px,
    rgba(0, 0, 0, 0.3) 0px 1px 3px -1px;
}

.searchResult {
  text-decoration: none;
  color: black;
}

form button {
  width: 120px;
  padding: 10px;
  border: black solid 1px;
  background-color: whitesmoke;
  color:black;
  font-size:14px;
  box-shadow: 4px 2px 2px lightgray;
}

form button:hover {
  opacity:0.8;
  background-color: green;
  color:white; 
}


</style>