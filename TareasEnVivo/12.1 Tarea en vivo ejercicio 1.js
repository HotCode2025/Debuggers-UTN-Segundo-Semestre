// Ejercicio 1: Función que valide una contraseña (mínimo 8 caracteres, 1 número, 1 mayúscula)

function validatePassword(password) {
    console.log("");
    // Verificación de longitud mínima (8 caracteres)
    if (password.length < 8) {
        console.log("Error: La contraseña debe tener al menos 8 caracteres.");
        return false;
    }

    // Verificación de al menos 1 número
    let tieneNumero = false;
    for (let i = 0; i < password.length; i++) {
        if (password[i] >= '0' && password[i] <= '9') {
            tieneNumero = true;
            break; // Termina el bucle si encuentra un numero
        }
    }

    if (tieneNumero === false) { 
        console.log("Error: La contraseña debe contener al menos un número.");
        return false;
    }

    // Verificación de al menos 1 letra mayúscula
    let tieneMayuscula = false;
    for (let i = 0; i < password.length; i++) {
        let char = password[i];
        if (char >= 'A' && char <= 'Z') {
            tieneMayuscula = true;
            break; // Termina el bucle si encuentra una mayuscula
        }
    }

    if (!tieneMayuscula) {
        console.log("Error: La contraseña debe contener al menos una mayúscula.");
        return false;
    }
    
    // Si pasa las tres verificaciones, es válida.
    return true;
}

// --- Ejemplos de prueba ---

console.log("Contraseña 'Abc12345': " + validatePassword("Abc12345")); // true
console.log("Contraseña 'weak': " + validatePassword("weak")); // false 
console.log("Contraseña 'sinmayusculas123': " + validatePassword("sinmayusculas123")); // false
console.log("Contraseña 'SOLOMAYUSCULAS': " + validatePassword("SOLOMAYUSCULAS")); // false
console.log("Contraseña 'Corto8': " + validatePassword("Corto8")); // false
