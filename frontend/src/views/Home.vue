<template>
  <div class="home">
    <div class="home__imageContainer">
      <img class="hero" src="../assets/hero.jpg"/>
    </div>
    <span class="line"></span>
    <div class="home__textContainer">
      <h4>Välkommen till Persbergsbygdens Historia</h4>
      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum sed est aliquam, luctus sem non, vehicula est. Nunc sed dictum sapien. Donec malesuada sit amet dui vel maximus. Aliquam sagittis eros orci, imperdiet tempus lorem interdum ac. Nulla at fringilla nisl. Integer convallis diam eu tristique scelerisque. Vivamus fringilla aliquam quam a finibus.</p>
      <p>Mauris in lacinia eros, id dictum turpis. Duis porttitor congue urna vitae scelerisque. Vivamus facilisis luctus suscipit. Nulla in ullamcorper enim. Aliquam egestas nulla eleifend, egestas mi sed, eleifend nisl. Pellentesque eget sodales augue, sit amet porttitor mi. Nulla ac rutrum quam, et hendrerit dui. Vestibulum condimentum, leo quis dapibus bibendum, tellus quam gravida tortor, at cursus libero dui ac ex. Sed dapibus ut neque quis tempor. Etiam non dui aliquam, maximus erat quis, hendrerit dui. Suspendisse iaculis, quam ut faucibus vehicula, arcu turpis maximus est, id dignissim turpis leo vitae eros. <a href="/project">Klicka här för att komma till projektet</a>
      </p>
      <p>Donec libero sem, egestas id purus nec, venenatis blandit dui. Sed suscipit, magna et vulputate pretium, tortor nunc vulputate nisi, quis rutrum mi mi ut nunc. Aliquam id tortor urna. Ut molestie sit amet augue quis dapibus. Duis nisi mi, viverra nec ex in, aliquam finibus lacus. Donec sed ante fringilla, eleifend quam vitae, tincidunt urna. Pellentesque ut eleifend erat. Morbi blandit enim consectetur lorem blandit, vitae varius tortor placerat. Aenean sem odio, facilisis ac urna vel, consectetur imperdiet justo. Donec ut arcu ultricies, dictum risus sed, faucibus nisi. Suspendisse felis nisl, viverra et eleifend id, suscipit non erat. Vestibulum sed lectus eu purus bibendum tempor eu in turpis. Fusce sed condimentum mauris, ut blandit lorem. Suspendisse potenti.</p>
   </div>
   <span class="line"></span>
  </div>
</template>

<style scoped>

  .home {
    display: flex;
    flex-direction: column;
    align-items: center;
    margin-bottom: 2rem;
  }

  .home__imageContainer {
    object-fit: contain;
    margin-bottom: 2%;
  }

  .hero {
    height: auto;
    width: auto;
    max-height: 600px;

  }

 .home__textContainer {
    text-align: left;
    width: 70%;
 }

 .line {
    height: 3px;
    width: 70%;
    background-color: #9fabd4;
    opacity: 0.4;
 }
 p {
  text-align: justify;
 }

</style>