<div id="top"></div>

<!-- PROJECT LOGO -->
<div >
  <a href="https://github.com/LeslieR0SS/white-camel-api">
    <img src="/src/main/resources/static/white-camel-alberto-logo-sin-fondo.png" alt="Logo" width="100" height="100" align="right">
  </a>
</div>

<!-- TITLE AND PRESENTATION-->

# WHITE CAMEL 
>***Presentation:***
>White Camel is an Edtech project that addresses the steep costs and declining motivation in traditional driving schools by offering an innovative, online, gamified learning platform. Users experience a daily adventure, tackling challenges and earning bonuses through tests. Taking inspiration from ultra marathons, White Camel introduces a competitive element—if the camel overtakes you, you're eliminated.



<!---ADD THE RESPECTIVE LINKS TO THAT DOCUMENTATION-->
<!---
  <div align="center">
    <a href="https://aste.usu.edu/directory/faculty/">Team Directory</a>
    ·
    <a href="https:/DSDD">Wiki</a>
    ·
    <a href="https://www.treehugger.com/thmb/nA-uVVo5Be5LIg_8kNAZvaSKYUM=/768x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/__opt__aboutcom__coeus__resources__content_migration__mnn__images__2017__05__lady-bug-on-leaf-e3cd36cdc3024129b61926ddf6ef386e.jpg">Report Bug</a>
  </div>
--!>


<!-- TABLE OF CONTENTS -->
<details>
  <summary>Index</summary>
  <ol>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
      <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#technical-description">Technical Description</a>
      <ul>
        <li><a href="#architecture">Architecture</a></li>
      </ul>

  </ol>
</details>

---

<!-- GETTING STARTED -->

## Getting Started

Welcome to the initial steps of your journey with our project! This section provides guidance on setting up the project locally. Follow these straightforward steps to get a local copy up and running.

### Prerequisites

- [ ] Install VSC 
- [ ] Intall Spring Boot Extension Pack *- by VMware*
- [ ] Install Java 17

---

### Installation

_Below is an example of how you can instruct your audience on installing and setting up your app._

1. Clone the repo
   ```sh
   git clone git@github.com:LeslieR0SS/white-camel-api.git
   ```


<p align="right">(<a href="#top">back to top</a>)</p>

---

<!-- ROADMAP -->
## Roadmap

- [ ] Install VSC 
- [ ] Intall Spring Boot Extension Pack *- by VMware*
- [ ] Install Java 17
  

<p align="right">(<a href="#top">back to top</a>)</p>

---

## Technical Description

###  Architecture 

We design our application utilizing the principles of **the Hexagonal Architecture**. This approach organizes the system into three distinct layers: the `domain layer` housing domain objects, the `application layer` handling business logic along with the definition of primary and secondary ports, and the `infrastructure layer` responsible for the framework's operations. In this architecture, primary adapters facilitate communication with the application layer, while secondary adapters handle access to databases and communication with external APIs.
