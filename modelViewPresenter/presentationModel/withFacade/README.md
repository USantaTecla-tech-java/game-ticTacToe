# TicTacToe. Solucion 6.2. mvp - presentationModel - withFacade
Universo Santa Tecla  
[uSantaTecla@gmail.com](mailto:uSantaTecla@gmail.com)  
  
**Índice**
1. [Requisitos 2. Gráficos](#requisitos-2-gráficos)  
2. [Vista de Lógica/Diseño](#vista-de-lógicadiseño)  
2.1. [Arquitectura](#arquitectura)  
2.2. [Paquete tictactoe](#paquete-tictactoe)  
2.3. [Paquete tictactoe.views](#paquete-tictactoeviews)  
2.4. [Paquete tictactoe.views.console](#paquete-tictactoeviewsconsole)  
2.5. [Paquete tictactoe.views.graphics](#paquete-tictactoeviewsgraphics)  
2.6. [Paquete tictactoe.models](#paquete-tictactoemodels)  
2.7. [Paquete tictactoe.types](#paquete-tictactoetypes)  
2.8. [Paquete tictactoe.controllers](#paquete-tictactoecontrollers)  
2.9. [Paquete tictactoe.utils](#paquete-tictactoeutils)  
3. [Calidad del Software](#calidad-del-software)  
3.1. [Diseño](#diseño)  
3.2. [Rediseño](#rediseño)  
4. [Vista de Desarrollo/Implementación](#vista-de-desarrolloimplementación)
5. [Vista de Despliegue/Física](#vista-de-desplieguefísica)
6. [Vista de Procesos](#vista-de-procesos)

## Requisitos 2. *Gráficos*

| * _Funcionalidad: **Básica**_ <br/> * _Interfaz: **Gráfica y Texto**_ <br/> * _Distribución: **Standalone**_ <br/> * _Persistencia: **No**_  | ![Tictactoe](docs/images/tictactoe.png) |  
| :------- | :------: |

## Vista de Lógica/Diseño
  - Arquitectura Documento/Vista mediante **Patrón de Vista Separada**  
    * **Patrón Template Method (Factory Method)**, para clases principales  
    * **Patrón Model View Presenter**, para incluir controllers 
    * **Patrón Facade**, para clases principales  
 
### Arquitectura

![Arquitectura](./docs/diagrams/out/arquitectura/arquitectura.svg)

### Paquete *tictactoe*

![Paquete_tictactoe](docs/diagrams/out/paquetes/paqueteTicTacToe.svg)

### Paquete *tictactoe.views*

![Paquete_tictactoe.views](./docs/diagrams/out/paquetes/paqueteTicTactoeViews.svg)

### Paquete *tictactoe.views.console*  

![Paquete_tictactoe.views.console](./docs/diagrams/out/paquetes/paqueteTicTactoeViewsConsole.svg)

### Paquete *tictactoe.views.graphics*  

![Paquete_tictactoe.views.graphics](./docs/diagrams/out/paquetes/paqueteTicTactoeViewsGraphics.svg)

### Paquete *tictactoe.models*

![Paquete_tictactoe.models](./docs/diagrams/out/paquetes/paqueteTicTactoeModels.svg)

### Paquete *tictactoe.types*

![Paquete_tictactoe.types](./docs/diagrams/out/paquetes/paqueteTypes.svg)

### Paquete *tictactoe.controllers*  

![Paquete_tictactoe.controllers](./docs/diagrams/out/paquetes/paqueteTicTactoeControllers.svg)

### Paquete *tictactoe.utils*

![Paquete_tictactoe.utils](./docs/diagrams/out/paquetes/paqueteUtils.svg)

## Calidad del Software

### Diseño

  - ***DRY**: clases principales*

### Rediseño

  - *Nuevas funcionalidades: undo/redo, demo, estadísiticas,…​
    
      - ***Clases Grandes**: los Modelos asumen la responsabilidad y crecen
       en líneas, métodos, atributos, …​ con las nuevas funcionalidades*  
    
      - ***Open/Close**: hay que modificar los modelos que estaban funcionando 
      previamente para incorporar nuevas funcionalidades*

## Vista de Desarrollo/Implementación

![Desarrollo_Implementación](./docs/diagrams/out/vistas/desarrolloImplementacion.svg)

## Vista de Despliegue/Física

![Despliegue_Física](./docs/diagrams/out/vistas/despliegueFisica.svg)

## Vista de Procesos
  - No hay concurrencia
