# Buscaminas

Implementamos el juego de buscaminas: el objetivo es despejar todas las casillas del tablero que no contienen minas, sin detonar ninguna mina: el tablero oculta 6 minas.

<div align=center>

|![image](https://github.com/user-attachments/assets/776990a4-ee0d-4385-b6e9-b07f1a1626d8)|![image](https://github.com/user-attachments/assets/48401510-52d2-4f16-83c9-7d2926c95fff)|![image](https://github.com/user-attachments/assets/d294c4ab-7f3e-4599-8acd-0b29c87d636e)|![image](https://github.com/user-attachments/assets/2885a066-3358-4e2b-94e6-a4ee55e85c57)|![image](https://github.com/user-attachments/assets/cc13a23b-d4f4-4d13-a699-60b2956fbecc)|
|:-:|:-:|:-:|:-:|:-:|
|Despejar|Marcar|Marcar|Victoria|Derrota|

</div>

## Elementos del juego

- Un tablero cuadriculado de 6x6.
- 6 minas ocultas distribuidas aleatoriamente en el tablero.
- Dos posibles acciones por turno: Despejar (D) o Marcar (M).

## Mecánica de juego

1. **Inicio**: El juego comienza con todas las casillas cubiertas y sin marcar.
1. **Acciones posibles**:
   - **Despejar (D)**: Seleccionar una casilla para revelar su contenido.
   - **Marcar (M)**: Colocar una marca en una casilla donde se sospecha hay una mina.
1. **Resultados de despejar una casilla**:
   - Si la casilla contiene una mina, el juego termina y el jugador pierde.
   - Si la casilla no contiene una mina, se revela y permanece descubierta.
1. **Victoria**: Se gana cuando todas las casillas sin minas han sido despejadas, independientemente de si todas las minas fueron correctamente marcadas.
1. **Derrota**: Se pierde si en cualquier momento se despeja una casilla que contiene una mina.

### Características adicionales

- Las coordenadas se expresan como (fila, columna), empezando desde 1
- El jugador puede marcar cualquier casilla como mina, incluso si no contiene una

```
BUSCAMINAS
  1 2 3 4 5 6
1 _ _ _ _ _ _ 
2 _ _ _ _ _ _ 
3 _ _ _ _ _ _ 
4 _ _ _ _ _ _ 
5 _ _ _ _ _ _ 
6 _ _ _ _ _ _ 

[D]espejar o [M]arcar mina?

```

```
BUSCAMINAS
  1 2 3 4 5 6
1 _ _ _ _ _ _ 
2 _ _ _ _ _ _ 
3 _ _ _ _ _ _ 
4 _ _ _ _ _ _ 
5 _ _ _ _ _ _ 
6 _ _ _ _ _ _ 

[D]espejar o [M]arcar mina? D

Elija coordenada:
> Fila: 3
> Columna: 3

Coordenada despejada

BUSCAMINAS
  1 2 3 4 5 6
1 _ _ _ _ _ _ 
2 _ _ _ _ _ _ 
3 _ _ D _ _ _ 
4 _ _ _ _ _ _ 
5 _ _ _ _ _ _ 
6 _ _ _ _ _ _ 

[D]espejar o [M]arcar mina? M

Elija coordenada:
> Fila: 5
> Columna: 4

Coordenada marcada

BUSCAMINAS
  1 2 3 4 5 6
1 _ _ _ _ _ _ 
2 _ _ _ _ _ _ 
3 _ _ D _ _ _ 
4 _ _ _ _ M _ 
5 _ _ _ _ _ _ 
6 _ _ _ _ _ _ 

[D]espejar o [M]arcar mina?

```

## Compilación y ejecución

Para compilar el proyecto utilice el compilador de Java desde la carpeta `src`:

```bash
javac *.java
```

Esto generará los archivos `.class` en la misma carpeta. Para iniciar una partida ejecute:

```bash
java Buscaminas
```

El juego se desarrollará en la consola solicitando la acción y las coordenadas en cada turno.
