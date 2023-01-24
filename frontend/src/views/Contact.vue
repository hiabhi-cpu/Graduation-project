<template>
    <div class="contact">
      <div class="contact__imageContainer">
      <img class="hero" src="../assets/contact1.jpg"/>
    </div>
      <div class="contact__topContainer">
        <h3>Kontakt</h3>
        <p>
        Har du frågor eller funderingar gällande projektet så är det bara att kontakta mig på min 
          <a href="mailto:tobjorn@persbergsbygdenshistoria.se">email</a> eller genom formuläret nedan.
      </p>
      </div>
      <form >
        <label>Namn</label>
        <input type="text"/>
        <label>Telefonnummer</label>
        <input type="text"/>
        <label>Email</label>
        <input type="email"/>
        <label>Kommentar</label>
        <textarea></textarea>
        <div class="button__container">
          <button>Skicka</button>
        </div>
      </form>
    </div>
  </template>



<style scoped>

.contact {
  display: flex;
  flex-direction: column;
  align-items: center;
  text-align: left;
  justify-content: center;
}

.contact__imageContainer {
  object-fit: contain;
  margin-bottom: 1%;
}

img {
  height: 500px;
}

.contact__topContainer {
  text-align: center;
  width: 460px;
}

form {
  display: flex;
  flex-direction: column;
  margin: 3rem auto;
  padding:30px;
  width:400px;
  height:auto;
  overflow:hidden;
  background: whitesmoke; 
  border-radius:10px;
  border: darkgray solid 1px; 
  box-shadow: 4px 2px 2px lightgray;
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
	border-radius:20px;
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
	border-radius:20px;
	display:inline-block;
	box-sizing:border-box;
	transition:0.2s ease all;
  font-family: sans-serif;
}

form textarea:hover {
  opacity:0.8;
  border: 2px solid green;
}

form textarea:active {
  opacity:0.4;
  border: 2px solid green;
}

form input:hover {
	opacity:0.8;
  border: 2px solid green;
}

form input:active {
	opacity:0.4;
  border: 2px solid green;
}

.button__container {
  margin-top: 5px;
  display: flex;
  justify-content: right;
}

form button {
  width: 80px;
  padding: 5px;
  border: none;
  background-color: white;
  border-radius:20px;
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
  