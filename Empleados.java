package gestionempleados;

public class Empleado {

        private int idEmpleado;
        private String nombre;
        private String apellido;
        private String tipoDocumento;
        private String nroDocumento;
        private String cuil;
        private String sexo;
        private String fechaNacimiento;
        private String domicilio;
        private String barrio;
        private String localidad;
        private String provincia;
        private String codigoPostal;
        private String telCelular;
        private String telFijo;
        private String email;
        private String fechaIngreso;
        private String fechaEgreso;
        private String puesto;
        private double sueldoBase;
        private String horario;
        private int idUsuario;
        private boolean estado; // true=activo, false=inactivo

        public Empleado(int idEmpleado, String nombre, String apellido, String puesto, double SueldoBase) {
            this.idEmpleado = idEmpleado;
            this.nombre = nombre;
            this.apellido = apellido;
            this.puesto = puesto;
            this.sueldoBase = SueldoBase;
            this.estado = true;
        }

        //Getters y Setters
        public int getIdEmpleado() {
            return this.idEmpleado;
        }

        public void setIdEmpleado(int idEmpleado) {
            this.idEmpleado = idEmpleado;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellido() {
            return this.apellido;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        public String getPuesto() {
            return this.puesto;
        }

        public void setPuesto(String puesto) {
            this.puesto = puesto;
        }

        public double getSueldoBase() {
            return this.sueldoBase;
        }

        public void setSueldoBase(double SueldoBase) {
            this.sueldoBase = SueldoBase;
        }

        public boolean isEstado() {
            return this.estado;
        }

        public void setEstado(boolean estado) {
            this.estado = estado;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Empleado{");
            sb.append("idEmpleado=").append(idEmpleado);
            sb.append(", nombre=").append(nombre);
            sb.append(", apellido=").append(apellido);
            sb.append(", puesto=").append(puesto);
            sb.append(", sueldoBase=").append(sueldoBase);
            sb.append(", estado=").append(estado);
            sb.append('}');
            return sb.toString();
        }

}


