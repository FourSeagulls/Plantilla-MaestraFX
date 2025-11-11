PLANTILLA MAESTRAFX — GUIA DE CONFIGURACIÓN Y USO
-------------------------------------------------

Plantilla diseñada para crear y ejecutar aplicaciones JavaFX con Maven y Scene Builder,
en Fedora Linux con IntelliJ IDEA.


1. REQUISITOS PREVIOS
---------------------

1.1 Instalar JDK 21 (no solo JRE):
    sudo dnf install java-21-openjdk-devel
    java -version

1.2 Instalar Maven:
    sudo dnf install maven
    mvn -version

1.3 Instalar Scene Builder:
    Instalado en /opt/scenebuilder/bin/SceneBuilder
    Se puede abrir con:
        /opt/scenebuilder/bin/SceneBuilder &


2. CONFIGURACIÓN DEL ENTORNO
----------------------------

Editar el archivo ~/.bashrc y añadir las siguientes líneas:

    export JAVA_HOME=/usr/lib/jvm/java-21-openjdk
    export PATH=$JAVA_HOME/bin:$PATH

Recargar y verificar:
    source ~/.bashrc
    echo $JAVA_HOME
    java -version


3. ESTRUCTURA DEL PROYECTO
--------------------------

MaestraFX/
│
├── pom.xml
├── src/
│   ├── main/
│   │   ├── java/org/maestra/MainApp.java
│   │   ├── java/org/maestra/controllers/MainController.java
│   │   └── resources/org/maestra/MainView.fxml
│   └── test/
└── README.txt


4. EJECUCIÓN DEL PROYECTO
-------------------------

Desde IntelliJ IDEA o terminal:

    mvn clean javafx:run

Esto utiliza el plugin javafx-maven-plugin que configura automáticamente el module-path.

Evitar ejecutar directamente "Run → MainApp" sin configurar las opciones VM.


5. CONFIGURAR SCENE BUILDER EN INTELLIJ
---------------------------------------

En IntelliJ:
    File → Settings → Languages & Frameworks → JavaFX
    Path to Scene Builder → /opt/scenebuilder/bin/SceneBuilder

Abrir archivos .fxml:
    Clic derecho → Open in Scene Builder


6. CREAR UN NUEVO PROYECTO DESDE ESTA PLANTILLA
-----------------------------------------------

1. Duplicar la carpeta base:
    cd ~/IdeaProjects
    cp -r MaestraFX MiNuevoProyectoFX
    cd MiNuevoProyectoFX

2. Editar pom.xml:
    <groupId>org.miempresa</groupId>
    <artifactId>MiNuevoProyectoFX</artifactId>
    <version>1.0-SNAPSHOT</version>

3. Abrir en IntelliJ IDEA y verificar:
    - SDK = Java 21
    - Dependencias Maven
    - Ejecutar con: mvn clean javafx:run

4. Ya puede modificarse libremente sin romper la configuración base.


7. RECOMENDACIONES
------------------

- Ejecutar siempre con Maven para mantener compatibilidad con JavaFX.
- Guardar esta plantilla como referencia base:
    cp -r ~/IdeaProjects/MaestraFX ~/Plantillas/MaestraFX-Base
- Si IntelliJ falla:
    - File → Invalidate Caches / Restart
    - Reimportar Maven (Reload All Maven Projects)


-------------------------------------------------
© Four Seagulls — Plantilla base educativa para proyectos JavaFX en Linux
-------------------------------------------------
