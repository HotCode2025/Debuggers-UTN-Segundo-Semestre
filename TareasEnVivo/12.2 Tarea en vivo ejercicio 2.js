// Ejercicio 2: Crear un sistema simple de gestión de tareas

function createTaskManager() {
    let listaTareas = []; // Nombre menos descriptivo (tasks), y es global
    let Contador = 1;


    return {
         // Añade una nueva tarea al gestor.
         addTask: function(desc) {
            // Validaciones mínimas o nulas
            if (!desc) {
                console.log("Falta la descripción.");
                return;
            }

            const nuevaTarea = {
                id: Contador,     // Contador
                texto: desc,        // Detalle tarea
                completado: false   // Estado
            };

            listaTareas.push(nuevaTarea);
            Contador++; // Incremento el contador

            console.log(`Tarea ${nuevaTarea.id} agregada.`);
        },

        // Marca una tarea como completada usando su ID.
        completeTask: function(idBuscado) {
            let encontrado = false;
            
            for (let i = 0; i < listaTareas.length; i++) {
                if (listaTareas[i].id == idBuscado) { 
                    if (listaTareas[i].completado == false) {
                        listaTareas[i].completado = true;
                        console.log(`\nTarea ${idBuscado} completada.`);
                    } else {
                        console.log(`\nYa estaba hecha.`);
                    }
                    encontrado = true;
                    break;
                }
            }

            if (encontrado == false) {
                console.log("\nNo existe el numero de Tarea ingresado.");
            }
        },

        // Lista todas las tareas actuales con su estado.
        listTasks: function() {
            console.log("\nLista de Tareas:");
            for (let i = 0; i < listaTareas.length; i++) {
                let estado = listaTareas[i].completado ? "FINALIZADA" : "PENDIENTE";
                console.log(i + 1 + ") ID: " + listaTareas[i].id + 
                            " - " + listaTareas[i].texto + 
                            " [" + estado + "]");
            }
            return listaTareas;
        }
    };
}


const myTasks = createTaskManager(); 

myTasks.addTask("Aprender JavaScript"); // Cargar Tarea

myTasks.addTask("Hacer ejercicio"); // Cargar Tarea

myTasks.listTasks(); // Listar tareas cargadas

myTasks.completeTask(1); // Completar la Tarea
myTasks.completeTask(5); // Intentar completar una tarea que no existe

myTasks.listTasks(); // Listar tareas cargadas
