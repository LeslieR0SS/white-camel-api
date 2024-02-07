<div id="top"></div>

<!-- LOGO DEL PROYECTO -->
<div>
  <a href="https://github.com/LeslieR0SS/white-camel-api">
    <img src="/src/main/resources/static/white-camel-alberto-logo-sin-fondo.png" alt="Logo" width="100" height="100" align="right">
  </a>
</div>

<!-- TÍTULO Y PRESENTACIÓN -->

# WHITE CAMEL 
>***Presentación:***
>White Camel es un proyecto de Edtech que aborda los altos costos y la disminución de la motivación en las autoescuelas tradicionales al ofrecer una plataforma de aprendizaje innovadora, en línea y gamificada. Los usuarios experimentan una aventura diaria, enfrentando desafíos y ganando bonificaciones a través de pruebas. Inspirado en ultramaratones, White Camel introduce un elemento competitivo: si el camello te adelanta, quedas eliminado.

<!---AGREGA LOS ENLACES RESPECTIVOS A ESA DOCUMENTACIÓN-->
<!---
  <div align="center">
    <a href="https://aste.usu.edu/directory/faculty/">Directorio del Equipo</a>
    ·
    <a href="https:/DSDD">Wiki</a>
    ·
    <a href="https://www.treehugger.com/thmb/nA-uVVo5Be5LIg_8kNAZvaSKYUM=/768x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/__opt__aboutcom__coeus__resources__content_migration__mnn__images__2017__05__lady-bug-on-leaf-e3cd36cdc3024129b61926ddf6ef386e.jpg">Informar un Error</a>
  </div>
--!>


<!-- ÍNDICE -->
<details>
  <summary>Índice</summary>
  <ol>
    <li>
      <a href="#getting-started">Primeros Pasos</a>
      <ul>
        <li><a href="#prerequisites">Requisitos Previos</a></li>
        <li><a href="#installation">Instalación</a></li>
      </ul>
    </li>
    <li><a href="#technical-description">Descripción Técnica</a>
      <ul>
        <li><a href="#architecture">Arquitectura</a></li>
      </ul>

  </ol>
</details>

---

<!-- PRIMEROS PASOS -->

## Primeros Pasos

¡Bienvenido a los primeros pasos de tu viaje con nuestro proyecto! Esta sección proporciona orientación sobre cómo configurar el proyecto localmente. Sigue estos pasos sencillos para obtener una copia local y ejecutarla.

### Requisitos Previos

- [ ] Instalar un IDE 
- [ ] Java Development Kit (JDK) 17 o superior instalado en tu sistema.
- [ ]  Maven instalado en tu sistema para la gestión de dependencias.

---

### Instalación

_A continuación explicaremos los pasos a seguir para reliazar la instalación y configuración de tu nuestra aplicación._

#### Paso 1: Clonar el Repositorio
1. Abre tu terminal o línea de comandos.
2. Ejecuta el siguiente comando para clonar el repositorio de GitHub:
    ```bash
    git clone https://github.com/LeslieR0SS/white-camel-api.git
    ```

#### Paso 2: Compilar el Proyecto
1. Navega al directorio del proyecto clonado:
    ```bash
    cd white-camel-api
    ```
2. Ejecuta el siguiente comando para compilar el proyecto usando Maven:
    ```bash
    mvn clean install
    ```

#### Paso 3: Ejecutar la Aplicación Backend
- Ejecuta el siguiente comando para iniciar la aplicación backend con Spring Boot:
    ```bash
    mvn spring-boot:run
    ```
- La aplicación se ejecutará en segundo plano y estará lista para recibir solicitudes.

#### Paso 4: Ejecutar la Aplicación Frontend
1. Abre tu IDE (Entorno de Desarrollo Integrado) y navega al directorio donde se encuentra la vista HTML principal de la aplicación frontend.
2. Desde tu IDE, abre el archivo HTML principal y ejecútalo utilizando la opción de ejecución de tu IDE.
3. Esto abrirá una pantalla de navegador en el localhost:5500, donde podrás interactuar con la aplicación frontend.

#### Paso 5: Acceder a la Aplicación
- Abre tu navegador web y visita la siguiente URL para acceder a la aplicación:
    ```
    http://localhost:5500
    ```

#### Paso 6: ¡Listo para Usar!
- Ahora puedes comenzar a utilizar White Camel para estudiar teoría de conducción, completar desafíos diarios y disfrutar de una experiencia de aprendizaje gamificada.

### Notas Adicionales:
- Asegúrate de tener una conexión a Internet activa durante la instalación para descargar las dependencias necesarias.
- Si experimentas algún problema durante la instalación o ejecución, consulta la documentación del proyecto o ponte en contacto con el equipo de desarrollo para recibir asistencia.

¡Disfruta utilizando White Camel y feliz aprendizaje de conducción!


<p align="right">(<a href="#top">back to top</a>)</p>

---


## Descripción Técnica

###  Arquitectura 

Diseñamos nuestra aplicación siguiendo el patrón de **Arquitectura Repository**. Este enfoque organiza el sistema en cuatro capas claramente definidas. La capa de `Controladores` actúa como punto de entrada, gestionando las solicitudes HTTP y dirigiendo el flujo. La capa de `Servicios` contiene la lógica empresarial y se comunica con los controladores y la capa de `Repositorios`. La cual se encarga del acceso a los datos y la comunicación con la base de datos. Finalmente, la capa de `Modelo` representa las entidades del dominio, como la clase `User`, proporcionando un modelo de datos coherente y estructurado para la aplicación.
 
