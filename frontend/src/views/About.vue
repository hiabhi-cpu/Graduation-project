<template>
  <div class="about">
    <div class="about__imageContainer">
      <img class="hero" src="../assets/about.jpg"/>
    </div>
    <span class="line"></span>
    <div class="about__textContainer">
      <p class="about__textContainer__text">
        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum sed est aliquam, luctus sem non, vehicula est. Nunc sed dictum sapien. Donec malesuada sit amet dui vel maximus. Aliquam sagittis eros orci, imperdiet tempus lorem interdum ac. Nulla at fringilla nisl. Integer convallis diam eu tristique scelerisque. Vivamus fringilla aliquam quam a finibus.
      </p>
      <p class="about__textContainer__text">
        Donec libero sem, egestas id purus nec, venenatis blandit dui. Sed suscipit, magna et vulputate pretium, tortor nunc vulputate nisi, quis rutrum mi mi ut nunc. Aliquam id tortor urna. Ut molestie sit amet augue quis dapibus. Duis nisi mi, viverra nec ex in, aliquam finibus lacus. Donec sed ante fringilla, eleifend quam vitae, tincidunt urna. Pellentesque ut eleifend erat. Morbi blandit enim consectetur lorem blandit, vitae varius tortor placerat. Aenean sem odio, facilisis ac urna vel, consectetur imperdiet justo. Donec ut arcu ultricies, dictum risus sed, faucibus nisi. Suspendisse felis nisl, viverra et eleifend id, suscipit non erat. Vestibulum sed lectus eu purus bibendum tempor eu in turpis. Fusce sed condimentum mauris, ut blandit lorem. Suspendisse potenti.
      </p>
      <p class="about__textContainer__text">
        Curabitur pellentesque purus lectus, sed tristique nibh facilisis et. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nunc eget justo volutpat urna tincidunt ullamcorper. Integer commodo congue justo eu eleifend. Nunc ullamcorper odio non velit lobortis mattis. Donec at elit vel metus porta maximus at id turpis. Sed pulvinar, ipsum eget ultricies viverra, sem ex aliquam tortor, congue vestibulum magna augue non quam. Pellentesque vel nibh a felis ornare malesuada. Aliquam at porta magna. Pellentesque sem elit, fringilla eget suscipit id, placerat ac lorem. Nulla sit amet arcu id turpis placerat finibus vitae vel leo. Ut in rutrum nunc, et placerat lacus. Nunc hendrerit, lectus et hendrerit sodales, purus mauris efficitur urna, et tincidunt nisi nisl quis neque.
      </p>
    </div>
      <span class="line"></span>
      <div class="about__fiftyFiftyContainer">
        <div class="about__fiftyFiftyContainer__innerContainer">
            <img class="about__fiftyFiftyContainer__innerContainer__column" src="../assets/Malm.jpg"/>
            <div class="about__fiftyFiftyContainer__innerContainer__column">
              <h4>"Historien lever kvar"</h4>
              <p class="about__fiftyFiftyContainer__text">
                Nunc ullamcorper odio non velit lobortis mattis. Donec at elit vel metus porta maximus at id turpis. Sed pulvinar, ipsum eget ultricies viverra, sem ex aliquam tortor, congue vestibulum magna augue non quam. Pellentesque vel nibh a felis ornare malesuada. 
              </p>
            </div>
        </div>
        <div class="about__fiftyFiftyContainer__innerContainer">
            <div class="about__fiftyFiftyContainer__innerContainer__column">
              <h4>"Jag började forska om Persbergskanal för cirka 12 år sedan"</h4>
              <p class="about__fiftyFiftyContainer__text">
                Curabitur pellentesque purus lectus, sed tristique nibh facilisis et. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nunc eget justo volutpat urna tincidunt ullamcorper. Integer commodo congue justo eu eleifend. Nunc ullamcorper odio non velit lobortis mattis. Donec at elit vel metus porta maximus at id turpis. 
              </p>
              <p class="about__fiftyFiftyContainer__text">
                Curabitur pellentesque purus lectus, sed tristique nibh facilisis et. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nunc eget justo volutpat urna tincidunt ullamcorper. Integer commodo congue justo eu eleifend. Nunc ullamcorper odio non velit lobortis mattis. Donec at elit vel metus porta maximus at id turpis. 
              </p>
            </div>
            <img class="about__fiftyFiftyContainer__innerContainer__column" src="../assets/admin.jpg"/>
        </div>
      </div>
      <span class="line"></span>

  </div>
</template>

<style scoped>

  .about {
    display: flex;
    flex-direction: column;
    align-items: center;
    margin-bottom: 2rem;
  }

  .about__imageContainer {
    object-fit: contain;
    margin-bottom: 1%;
  }

  .hero {
    height: auto;
    width: auto;
    max-height: 600px;
  }

 .about__textContainer {
    width: 70%;
 }

 .about__textContainer__text {
    text-align: justify;
 }

 .line {
    height: 3px;
    width: 70%;
    background-color: #9fabd4;
    opacity: 0.4;
 }

 .about__fiftyFiftyContainer {
    margin: 1rem 0rem; 
    width: 70%;
 }
 .about__fiftyFiftyContainer__innerContainer {
    display: flex;
    align-items: center;
    background-color: whitesmoke;
 }

 .about__fiftyFiftyContainer__innerContainer__column {
   width: 50%;
 }

 .about__fiftyFiftyContainer__text {
    padding: 25px;
    text-align: justify;
 }

</style>