<template>
    <div class="contact">
      <div class="contact__fiftyFiftyContainer">
        <div class="contact__fiftyFiftyContainer__innerContainer">
            <img class="contact__fiftyFiftyContainer__innerContainer__column" src="../assets/contact1.jpg"/>
            <div class="contact__fiftyFiftyContainer__innerContainer__column">
              <h4 class="contact__fiftyFiftyContainer__text">
                Har du frågor eller funderingar gällande projektet så är det bara att kontakta mig på min <a href="mailto:tobjorn@persbergsbygdenshistoria.se">email</a>
              </h4>
            </div>
        </div>
        <div class="contact__fiftyFiftyContainer__innerContainer">
            <div class="contact__fiftyFiftyContainer__innerContainer__column">
              <h4 class="contact__fiftyFiftyContainer__text">
                 Under sommaren erbjuder jag även guidade turer till Getön, som du kan läsa mer om <a href="#">här</a>
              </h4>
            </div>
            <img class="contact__fiftyFiftyContainer__innerContainer__column" src="../assets/contact2.jpg"/>
        </div>
      </div>
    </div>
  </template>



<style scoped>

  .contact {
    display: flex;
    flex-direction: column;
    align-items: center;
  }

 .contact__fiftyFiftyContainer {
    margin-top: 4rem;
    margin-bottom: 2rem;
    width: 70%;
 }
 .contact__fiftyFiftyContainer__innerContainer {
    display: flex;
    align-items: center;
    background-color: whitesmoke;
 }

 .contact__fiftyFiftyContainer__innerContainer__column {
   width: 50%;
 }

 .contact__fiftyFiftyContainer__text {
    text-align: left;
    padding: 5rem;
 }

</style>
  