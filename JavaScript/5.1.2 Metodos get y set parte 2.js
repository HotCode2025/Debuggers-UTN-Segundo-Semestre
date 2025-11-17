//Creacion de un objeto
let persona = {
    nombre: "Rebeca",
    apellido: "Navarro",
    email: "rebeca.navarro@gmail.com",
    edad: 0,
    idioma: "ES",
    get lang(){
        return this.idioma.toUpperCase();
    },
    set lang(lang){
        this.idioma = lang.toUpperCase()
    },
    nombreCompleto: function(){//metodo o funcion en JavaScript
        return this.nombre+" "+this.apellido;
    },
    get nombreEdad(){//este es el metodo get
        return "El nombre es: "+this.nombre+", Edad: "+this.edad;
    }
}
console.log("Comenzamos con el metodo get y set para idiomas");
persona.lang = "EN"; //primero recibe el parametro, lo convierte a mayusculas y luego lo asigna
console.log(persona.lang);