@echo off
REM ====================================================================================
REM Archivo: git_push.bat
REM Propósito: Mueve los archivos de la subcarpeta a la raíz para un commit aplanado,
REM            sube el commit al remoto, y luego revierte la estructura local.
REM
REM ¡EJECUTAR DESDE LA RAÍZ DEL REPOSITORIO GIT!
REM ====================================================================================

REM Define la carpeta de código fuente que quieres aplanar en el remoto
SET SOURCE_DIR=SistemaDeVentas\src\SistemaDeVentas

echo ----------------------------------------------------
echo 1. MOVIENDO ARCHIVOS TEMPORALMENTE A LA RAIZ LOCAL...
echo ----------------------------------------------------
REM Mueve todos los archivos *.java de la carpeta a la raíz (el '.')
move "%SOURCE_DIR%\*.java" .

IF ERRORLEVEL 1 (
echo Error al mover archivos. Asegurate de que la ruta sea correcta.
goto :eof
)

echo ----------------------------------------------------
echo 2. PREPARANDO COMMIT APLLANADO Y SUBIENDO A ORIGIN...
echo ----------------------------------------------------
REM Quita la carpeta de la indexación de Git (la marca para eliminacion remota)
git rm -r --cached "%SOURCE_DIR%"

REM Agrega los archivos que ahora estan en la raiz
git add *.java
git add Crear_Base.txt

REM Crea el commit y sube los cambios al remoto
git commit -m "Subida de código a la raíz remota sin estructura de directorios."
git push origin main

echo ----------------------------------------------------
echo 3. RESTAURANDO ESTRUCTURA LOCAL...
echo ----------------------------------------------------
REM Mueve los archivos de vuelta a su carpeta de paquete original
move *.java "%SOURCE_DIR%"

REM Confirma el movimiento de retorno (solo un cambio de estructura local)
git add .
git commit -m "revert: Estructura local restaurada a %SOURCE_DIR%"
git push origin main

echo ----------------------------------------------------
echo PROCESO COMPLETADO. El repositorio remoto esta aplanado, y el local esta funcional.
echo ----------------------------------------------------
pause