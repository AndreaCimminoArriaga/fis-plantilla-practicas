# fis-plantilla-practicas
Una plantilla basada en Java spark para el desarrollo de un servicio Web siguiendo el paradigma MVC. La plantilla requiere Java 1.8.


### Clases de la plantilla
Esta plantilla es un esqueleto que provee de las siguientes clases:

![plantilla-practica umlcd](https://user-images.githubusercontent.com/4105186/166678930-5d22ac83-944a-4269-9743-f9b3b4c52c43.jpg)


 * `App` es la clase que arranca el sistema, **no cambiarle el nombre**.
 * `AppUtils` ofrece una serie de métodos estáticos, los más relevantes son: `shouldReturnHtml` que devuelve true si el usuario desde el cliente/navegador pidió una vista basada en HTML, y `shouldReturnJson` que devuelve true si el usuario desde el cliente/navegador pide una vista basada en Json. Para pedir los distintos tipos de vistas se usa la cabecera `Accept` dandole un valor `text/html` para pedir HTML o `application/json` para pedir Json.
 * 
