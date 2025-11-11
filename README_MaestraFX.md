# 🧩 Plantilla MaestraFX

````markdown
# 🧩 Plantilla MaestraFX — Guía de Configuración y Uso

Esta plantilla está diseñada para crear y ejecutar aplicaciones **JavaFX** con **Maven** y **Scene Builder**, en **Fedora Linux** con **IntelliJ IDEA**.

---

## 🧱 1. Requisitos previos

- **JDK 21** (no solo JRE)  
  ```bash
  sudo dnf install java-21-openjdk-devel
  java -version
````

* **Maven**

  ```bash
  sudo dnf install maven
  mvn -version
  ```

* **Scene Builder**

    * Instalado en `/opt/scenebuilder/bin/SceneBuilder`
    * Se puede abrir con:

      ```bash
      /opt/scenebuilder/bin/SceneBuilder &
      ```

---

## ⚙️ 2. Configuración del entorno

Editar el archivo `~/.bashrc`:

```bash
export JAVA_HOME=/usr/lib/jvm/java-21-openjdk
export PATH=$JAVA_HOME/bin:$PATH
```

Recargar y verificar:

```bash
source ~/.bashrc
echo $JAVA_HOME
java -version
```

---

## 🧩 3. Estructura del proyecto

```
MaestraFX/
│
├── pom.xml
├── src/
│   ├── main/
│   │   ├── java/org/maestra/MainApp.java
│   │   ├── java/org/maestra/controllers/MainController.java
│   │   └── resources/org/maestra/MainView.fxml
│   └── test/
└── README_MaestraFX.md
```

---

## 🚀 4. Ejecutar el proyecto

Método recomendado (desde IntelliJ o terminal):

```bash
mvn clean javafx:run
```

Esto usa el **javafx-maven-plugin**, que configura automáticamente el `module-path`.

> 💡 Evita usar “Run → MainApp” directamente, salvo que hayas configurado manualmente las VM options de JavaFX.

---

## 🧭 5. Scene Builder en IntelliJ

Configurar una vez:

> File → Settings → Languages & Frameworks → JavaFX
> Path to Scene Builder → `/opt/scenebuilder/bin/SceneBuilder`

Abrir `.fxml` → Clic derecho → **Open in Scene Builder**

---

## 🧰 6. Crear un nuevo proyecto desde esta plantilla

1. Duplicar la carpeta:

   ```bash
   cd ~/IdeaProjects
   cp -r MaestraFX MiNuevoProyectoFX
   cd MiNuevoProyectoFX
   ```

2. Editar `pom.xml`:

   ```xml
   <groupId>org.miempresa</groupId>
   <artifactId>MiNuevoProyectoFX</artifactId>
   <version>1.0-SNAPSHOT</version>
   ```

3. Abrir en IntelliJ

    * Verificar que el SDK es **Java 21**
    * Verificar dependencias Maven
    * Ejecutar con `mvn clean javafx:run`

4. ¡Listo!
   Ya puedes modificar `.fxml`, controladores y recursos sin romper el proyecto.

---

## 🧠 7. Recomendaciones finales

* Usa **Maven** para ejecutar: garantiza compatibilidad total con JavaFX.
* Guarda esta plantilla como **referencia base**:

  ```bash
  cp -r ~/IdeaProjects/MaestraFX ~/Plantillas/MaestraFX-Base
  ```
* Si IntelliJ falla:

    * `File → Invalidate Caches / Restart`
    * Reimporta Maven (`Reload All Maven Projects`)

---

© Foour Seagulls — *Plantilla base educativa para proyectos JavaFX en Linux*

```

