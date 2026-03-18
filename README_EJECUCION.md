# ✅ Guia de ejecucion - CineApp_Bedoya

Este documento explica como abrir y ejecutar el proyecto en **Android Studio**.

## 1) Requisitos previos

- Android Studio instalado (version reciente).
- SDKs de Android configurados.
- Gradle funcionando con conexion a internet.

## 2) Abrir el proyecto

1. Descarga o clona el repositorio.
2. En Android Studio selecciona **Open**.
3. Elige la carpeta raiz del proyecto (donde esta `settings.gradle`).
4. Espera a que termine el **Gradle Sync**.

## 3) Crear dispositivo de prueba

- **Emulador:**
  - Ve a **Device Manager**.
  - Crea un dispositivo con **API 24 o superior**.
- **Dispositivo fisico:**
  - Activa **Opciones de desarrollador**.
  - Habilita **Depuracion USB**.
  - Conecta el telefono por USB.

## 4) Ejecutar la app

1. Presiona el boton **Run (▶)**.
2. Selecciona el dispositivo.
3. Espera a que la app se instale y abra.

## 5) Verificacion rapida

- Guarda un registro.
- Busca por ID.
- Actualiza el registro.
- Elimina el registro.

## 6) Solucion rapida de errores comunes

- **Gradle no sincroniza:** revisa la conexion y vuelve a **Sync Now**.
- **SDK faltante:** Android Studio mostrara el error y te dara la opcion de instalar.
- **Emulador lento:** usa una imagen x86_64 con aceleracion por hardware.
