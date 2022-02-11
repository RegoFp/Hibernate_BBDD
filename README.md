<h1 align="center">
  <a href="https://github.com/Zettlr/Zettlr">
    <img src="https://github.com/RegoFp/Hibernate_BBDD/blob/main/logo.jpeg" alt="Hibernate_BBDD"/>
  </a>
  <br/>
  Hibernate_BBDD
</h1>

El repositorio se ha creado para poder desarrollar un trabajo de la asignatura Acceso a Datos.
Se puede clonar y examinar el código. Si los cambios se consideran oportunos, se hará merge con la rama principal.

<h2 align ="center"> Integrantes</h2>

  - [Daniel Rego](https://github.com/RegoFp)
  - [Enrique Rivas](https://github.com/enriquerivasf)
  - [Rocío Seoane](https://github.com/rocioseoane)
  - [Gianny Uffo](https://github.com/uffogianny)

<h2 align ="center"> Recursos</H2>

* [GitHub](https://www.docker.com/products/docker-desktop)
* [Visual Studio](https://visualstudio.microsoft.com/es/)
* [Java](https://www.java.com/es/)
* [AWS](https://aws.amazon.com/es/)

<h3 align ="center">AWS</h3>
<h3 align = "center">Características</h3>

  <h3>Carga administrativa reducida</h4>
  
  - Facilidad de uso.  
  
  ```
    Se puede realizar la administración desde la línea de comandos de Amazon RDS para obtener acceso 
    a las capacidades de una base de datos relacional lista en pocos minutos. 
    
    Las instancias de base de datos de Amazon RDS están preconfiguradas con los parámetros y ajustes 
    adecuados para el motor y la clase que haya seleccionado. Puede lanzar una instancia de base de 
    datos y conectar su aplicación en cuestión de minutos. Los grupos de parámetros de base de datos
    ofrecen un control minucioso de la base de datos y la posibilidad de ajustarla.
  ```
  -  Aplicación automática de parches en el software
  ```
    Con Amazon RDS se garantizará que el software de la base de datos relacional de sus implementaciones 
    permanezca actualizado con los últimos parches. Tiene la opción de controlar si se deben aplicar 
    parches a su instancia de base de datos o no, y el momento en que se deben aplicar.
  ```
   [Más info](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/Welcome.html)
   
   -  Sugerencias sobre prácticas recomendadas
   ```
    Amazon RDS ofrece orientación sobre prácticas recomendadas mediante el análisis de las métricas de 
    configuración y uso de las instancias de bases de datos. Las sugerencias cubren áreas como versiones 
    de motores de base de datos, almacenamiento, tipos de instancias y redes. Puede analizar las sugerencias
    disponibles y realizar una acción sugerida de inmediato, programarla para su próximo periodo de 
    mantenimiento o descartarla por completo. 
   ```
   
   <h3> Rendimiento</h3>
   
   - Almacenamiento en SSD de uso general o provisionado 
   ```
    El almacenamiento de uso general de Amazon RDS es una opción de almacenamiento en SSD que ofrece una 
    base uniforme de 3 IOPS por GB aprovisionado y la posibilidad de alcanzar ráfagas de hasta 3000 IOPS 
    por encima del valor de referencia. 
    La opción de almacenamiento de IOPS provisionadas en SSD de Amazon RDS se diseñó para proporcionar un 
    rendimiento de E/S rápido, predecible y uniforme. Debe especificar una tasa de IOPS al crear una 
    instancia de base de datos y Amazon RDS aprovisionará esa tasa de IOPS durante todo el ciclo de vida 
    de la instancia de base de datos. 
  ```
   
   
   <h3> Escalabilidad</h3>
   
   - Escalado de informática con un botón    
 
   ```
    Puede escalar los recursos informáticos y de memoria para ampliar o reducir la implementación, hasta un 
    máximo de 32 vCPU y 244 GiB de RAM. Las operaciones de escalado de informática normalmente se llevan a 
    cabo en cuestión de minutos. 
   ```
   
   -  Réplicas de lectura 
   ```
    Las réplicas de lectura facilitan el escalado de manera elástica más allá de las limitaciones de capacidad
    de una única instancia de base de datos para cargas de trabajo de base de datos con uso elevado de las 
    lecturas. Puede crear una o varias réplicas de una instancia de base de datos de origen determinada y 
    abastecer el alto volumen de tráfico de lectura de la aplicación desde distintas copias de sus datos, 
    lo cual aumenta el rendimiento de lectura total.
   ```
   
   <h3> Disponibilidad y durabilidad</h3>
   
   - Copias de seguridad automatizadas
   
   ```
    La característica de copia de seguridad automatizada de Amazon RDS permite la recuperación a un momento
    dado de su instancia de base de datos. Amazon RDS realizará una copia de seguridad de los registros de 
    base de datos y de transacciones y los almacenará durante un periodo de retención que puede especificar 
    el usuario. 
   ```
   
   - Instantáneas de bases de datos
   ```
    Las instantáneas de base de datos son copias de seguridad que inicia el usuario de la instancia 
    almacenada en Amazon S3, que se conservará hasta que se eliminen explícitamente. Puede crear una 
    nueva instancia a partir de instantáneas de base de datos cuando lo desee. Aunque las instantáneas 
    de base de datos pueden servir desde el punto de vista operativo como copias de seguridad completas, 
    solo se le factura el uso de almacenamiento progresivo.
   ```
   
   - Implementaciones Multi-Az
   ```
    Las implementaciones Multi-AZ de Amazon RDS ofrecen una mejora de la disponibilidad y la durabilidad 
    de las instancias de base de datos, lo que las hace idóneas para las cargas de trabajo de bases de datos
    de producción Cuando aprovisiona una instancia de base de datos Multi-AZ, Amazon RDS replica los datos 
    de forma sincrónica en una instancia en espera en una zona de disponibilidad (AZ) diferente.
   ```
   
   - Sustitución automática de hospedaje 
   ```
    Amazon RDS sustituye automáticamente la instancia informática de la implementación en caso de error del
    hardware.
   ```
  <h3> Seguridad</h3>
  
  - Cifrado en tránsito y en reposo
   ```
    Permite cifrar sus bases de datos mediante las claves que administra a través del AWS Key Management 
    Service (KMS). En  una instancia de base de datos que se ejecute con cifrado de Amazon RDS, los datos 
    almacenados en reposo en el almacenamiento subyacente están cifrados, al igual que sus copias de 
    seguridad automatizadas, las réplicas de lectura y las instantáneas.
   ```
   
   - Aislamiento de la red
   ```
    Las VPC permite aislar la base de datos en su propia red virtual y conectarse a su infraestructura de 
    TI local mediante las VPN con IPsec cifradas estándar del sector. Puede configurar los ajustes del 
    firewall y controlar el acceso de red a las instancias de la base de datos.
   ```
   - Permisos de acceso a recursos
   ```
     Integraación con AWS Identity and Access Management (IAM) y ofrece la posibilidad de controlar las 
     acciones que los usuarios y grupos de AWS IAM pueden realizar en recursos específicos de Amazon RDS, 
     desde instancias de base de datos hasta instantáneas, grupos de parámetros y grupos de opciones.
     Además, puede etiquetar los recursos de Amazon RDS y controlar las acciones que pueden realizar los 
     usuarios y grupos de IAM en grupos de recursos que tengan la misma etiqueta y valor asociado. 
     Por ejemplo, puede configurar las reglas de IAM para garantizar que los desarrolladores puedan 
     modificar las instancias de base de datos de “Desarrollo”, pero de tal manera que solo los 
     administradores de la base de datos puedan modificar las instancias de base de datos de “Producción”. 
   ```
    
  <h3> Manejabilidad</h3>
    - Monitorización y métricas
    ```
     Es posible ver métricas operativas clave, incluidos el uso de la capacidad de cómputo, memoria y 
     almacenamiento, la actividad de E/S y las conexiones de instancias de bases de datos. Amazon RDS 
     también ofrece monitorización optimizada, la cual ofrece acceso a más de 50 métricas de CPU, memoria, 
     sistema de archivo y E/S de disco e información sobre rendimiento, una herramienta fácil de usar 
     que lo ayuda a detectar rápidamente los problemas de rendimiento.
    ```
    - Notificaciones de eventos
   ```
    Se pueden configurar las notificaciones de eventos por email o SMS a través de Amazon SNS. Se puede
    utilizar la consola de administración de AWS o las APIS para suscribirse a eventos ya creados y 
    asociados a las distintas bases de datos.
   ```
   
