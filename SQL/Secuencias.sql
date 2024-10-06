---- crear secuencias ---
CREATE SEQUENCE choferesImagen_seq
START WITH 1           -- Inicia con el valor 1
INCREMENT BY 1         -- Incrementa en 1 cada vez que se utiliza
NOCACHE;               -- No almacena en caché los valores de la secuencia
---Secuencias creadas---
choferes_seq --Secuencia de la tabla choferes
usuarios_seq --Secuencia de la tabla usuarios
choferesImagen_seq --Secuencia de la tabla choferes imagenes

---Eliminar secuencia--
drop SEQUENCE usuarios_seq