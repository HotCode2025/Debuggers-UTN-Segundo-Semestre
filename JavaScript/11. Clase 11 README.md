```markdown
# Tarea - Clase 11: Convenciones de Nombres Descriptivos para Funciones en JavaScript

Este documento contiene el análisis de las funciones de ejemplo, detallando su **significado en español** y los **puntos clave** que las hacen descriptivas.

---

## 1. Manipulación de Datos

Funciones enfocadas en transformar, formatear o validar datos.

| Función (JS)             | Significado en Español                      | Puntos Clave de la Descripción
| `calculateTotalPrice()`  | **Calcular Precio Total**                   | **Acción:** `calculate` indica que la función realiza una operación matemática para obtener un valor.
| `formatUserInput()`      | **Formatear Entrada de Usuario**            | **Acción:** `format` sugiere una estandarización de la presentación de los datos.
| `validateEmailAddress()` | **Validar Dirección de Correo Electrónico** | **Acción:** `validate` implica la verificación del cumplimiento de reglas específicas.
| `convertToCamelCase()`   | **Convertir a Camel Case**                  | **Acción:** `convertTo` describe una conversión de un formato de *string* a otro.
| `filterActiveUsers()`    | **Filtrar Usuarios Activos**                | **Acción:** `filter` indica la selección de un subconjunto de una colección basada en un criterio.

---

## 2. Eventos o Interacción

Funciones que responden a acciones del usuario o gestionan el estado de la interfaz.

| Función (JS)          | Significado en Español           | Puntos Clave de la Descripción |
| `handleButtonClick()` | **Manejar Clic de Botón**        | **Convención:** `handle` es el prefijo estándar para funciones que gestionan la respuesta a un evento específico.
| `onFormSubmit()`      | **Al Enviar Formulario**         | **Convención:** `on` función que se ejecuta **en respuesta** a la finalización de un proceso (el envío del formulario).
| `toggleDarkMode()`    | **Alternar Modo Oscuro**         | **Acción:** `toggle` Cambia un estado binario (encender/apagar) de forma eficiente.
| `updateProgressBar()` | **Actualizar Barra de Progreso** | **Acción:** `update` significa modificar el valor actual de la barra de prograso.
| `initializeApp()`     | **Inicializar Aplicación**       | **Acción:** `initialize` es el término estándar para la función de configuración inicial y *setup* de la aplicación.

---

## 3. Operaciones CRUD (Crear, Leer, Actualizar, Borrar)

Funciones fundamentales para la gestión de la persistencia y ciclo de vida de los datos.

| Función (JS) | Significado en Español | Puntos Clave de la Descripción |
| `createNewUser()`     | **Crear Nuevo Usuario**            | **Operación:** Se asocia a la 'C' de **CRUD (Create)**. Crea un nuevo registro.
| `fetchUserData()`     | **Obtener/Traer Datos de Usuario** | **Operación:** `fetch` se asocia a la 'R' de **CRUD (Read)**, Lee un registro.
| `updateUserProfile()` | **Actualizar Perfil de Usuario**   | **Operación:** `update` se asocia a la 'U' de **CRUD (Update)**. Modifica un registro existente.
| `deleteUserAccount()` | **Eliminar Cuenta de Usuario**     | **Operación:** `delete` se asocia a la 'D' de **CRUD (Delete)**. Elimina un registro.

---

## 4. Utilidades

Funciones auxiliares, genéricas y reutilizables que realizan tareas comunes.

| Función (JS) | Significado en Español | Puntos Clave de la Descripción |
| `generateRandomId()` | **Generar ID Aleatorio**   | **Acción:** `generate` indica la creación de un valor que será único y aleatorio.
| `formatCurrency()`   | **Formatear Moneda**       | **Acción:** Se enfoca en la presentación de datos numéricos en un formato económico específico.
| `debounceSearch()`   | **Retrasar Búsqueda**      | **Técnica:** `debounce` Limita la ejecución de una función (*search*) en un periodo de tiempo.
| `sanitizeInput()`    | **Sanear/Limpiar Entrada** | **Acción:** `sanitize` es un término de seguridad, implica la limpieza de datos para prevenir *exploits*.
| `checkPermissions()` | **Verificar Permisos**     | **Acción:** `check` Verifica si el usuario tiene los derechos necesarios para realizar una acción. |

```