# TicTacToe. Solucion 9.3. mvp - presentationModel - with Composite
Universo Santa Tecla  
[uSantaTecla@gmail.com](mailto:uSantaTecla@gmail.com)

**Índice**
1. [Requisitos 2. Gráficos](#requisitos-2-gráficos)
2. [Vista de Lógica/Diseño](#vista-de-lógicadiseño)  
   2.1. [Arquitectura](#arquitectura)  
   2.2. [Paquete tictactoe](#paquete-tictactoe)  
   2.3. [Paquete tictactoe.views](#paquete-tictactoeviews)  
   2.6. [Paquete tictactoe.types](#paquete-tictactoetypes)  
   2.7. [Paquete tictactoe.models](#paquete-tictactoemodels)  
   2.8. [Paquete tictactoe.controllers](#paquete-tictactoecontrollers)  
   2.9. [Paquete tictactoe.utils](#paquete-tictactoeutils)  
3. [Vista de Desarrollo/Implementación](#vista-de-desarrolloimplementación)
4. [Vista de Despliegue/Física](#vista-de-desplieguefísica)
5. [Vista de Procesos](#vista-de-procesos)

## Requisitos 2. *Gráficos*

| * _Funcionalidad: **Básica + undo/redo**_ <br/> * _Interfaz: **Gráfica y Texto**_ <br/> * _Distribución: **Standalone**_ <br/> * _Persistencia: **No**_  | ![Tictactoe](docs/images/tictactoe.png) |  
| :------- | :------: |

## Vista de Lógica/Diseño
- Modelo/Vista/Presentador con Presentador del Modelo con **Vista Achicada**  
    * **Patrón Command**, para el menú  
    * **Patrón Composite**, para multicontroladores  
    * **Patrón Memento**, para la funcionalidad undo/redo  

### Arquitectura

![Arquitectura](./docs/diagrams/out/arquitectura/arquitectura.svg)

### Paquete *tictactoe*

![Paquete_tictactoe](./docs/diagrams/out/paquetes/paqueteTicTacToe.svg)

### Paquete *tictactoe.views*

![Paquete_tictactoe.views](./docs/diagrams/out/paquetes/paqueteTicTacToeViews.svg)

### Paquete *tictactoe.models*

![Paquete_tictactoe.models](./docs/diagrams/out/paquetes/paqueteTicTacToeModels.svg)

### Paquete *tictactoe.types*

![Paquete_tictactoe.types](./docs/diagrams/out/paquetes/paqueteTypes.svg)

### Paquete *tictactoe.controllers*

![Paquete_tictactoe.controllers](./docs/diagrams/out/paquetes/paqueteTicTacToeControllers.svg)

### Paquete *tictactoe.utils*

![Paquete_tictactoe.utils](./docs/diagrams/out/paquetes/paqueteUtils.svg)

## Vista de Desarrollo/Implementación

![Desarrollo_Implementación](./docs/diagrams/out/vistas/desarrolloImplementacion.svg)

## Vista de Despliegue/Física

![Despliegue_Física](./docs/diagrams/out/vistas/despliegueFisica.svg)

## Vista de Procesos
- No hay concurrencia
